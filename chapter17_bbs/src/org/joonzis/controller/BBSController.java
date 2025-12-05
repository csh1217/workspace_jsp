package org.joonzis.controller;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joonzis.model.FileDownload;
import org.joonzis.service.BBSService;
import org.joonzis.service.BBSServiceImpl;
import org.joonzis.vo.BVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/BBSController")
public class BBSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BBSController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 파일 업로드
		String realPath = request.getServletContext().getRealPath("/upload"); // 업로드 경로
		MultipartRequest mr =null; //파일 데이터 처리용
		
		
		
		String cmd = request.getParameter("cmd");
		if(cmd == null) {
			// 파일 업로드 시 일반 request에서 받아올 수 없기 때문에 mr 객체 생성해서 파라미터를 받는다.
			mr = new MultipartRequest(
					request,
					realPath,
					1024 * 1024* 10,
					"utf-8",
					new DefaultFileRenamePolicy()
				);
			cmd = mr.getParameter("cmd");
		}
		
		boolean isForward = true;
		String path = "";
		BBSService bservice = new BBSServiceImpl();
		List<BVO> list = null; 
		BVO bvo = null;
		HttpSession session = request.getSession();
		int b_idx = 0;
		String open = null; // 세션 정보 저장
		
		switch (cmd) {
		case "allList": // 게시글 전체 목록 보기
			
			// 세션 삭제(조회수)
			open=(String)session.getAttribute("open");
			if(open!=null) {
				session.removeAttribute("open");
			}
			
			list = bservice.getList();
			request.setAttribute("list", list);
			path = "bbs/allList.jsp";
			break;
			
		case "insertBBSPage": // 게시글 작성 페이지 이동
			path = "bbs/insert_page.jsp";
			break;
			
		case "insertBBS": // 게시글 작성
			bvo = new BVO();
			// 파라미터 꺼내서 vo에 저장
			// vo를 DB까지 전달
			bvo.setWriter(mr.getParameter("writer"));
			bvo.setTitle(mr.getParameter("title"));
			bvo.setPw(mr.getParameter("pw"));
			bvo.setContent(mr.getParameter("content"));
			// bvo.setIp(request.getRemoteAddr()); // IPv6
			bvo.setIp(Inet4Address.getLocalHost().getHostAddress()); // IPv4
			
			// 첨부 파일 유무에 따라서 filename값을 결정
			if(mr.getFile("filename")!=null) {
				bvo.setFilename(mr.getFilesystemName("filename"));
			}else {
				bvo.setFilename("");
			}
			bservice.getInsertBBS(bvo);
			
			// dml 후에 보여줄 화면을 list로 간다면 기존 list로 가는 서블릿 경로를 리다이렉트 해준다
			isForward = false;
			path = "BBSController?cmd=allList";
			break;
			
		// 게시글 상세 보기
		case "view" :
			// 게시글 가져오는 로직
			b_idx = Integer.parseInt(request.getParameter("b_idx"));
			bvo = bservice.getBBS(b_idx);
			
			// 조회수 증가 로직
			// 1. 상세 페이지에 접근 시 세션에 정보를 저장
			// 2. 세션이 만료되기 전까지 조회수의 증가를 더 이상 하지 않는다(새로고침 등으로 조회 수 증가 방지)
			// 3. 메인 화면(allList.jsp로 이동하게 되면 세션을 만료)
			open = (String)session.getAttribute("open");
			if(open==null) {
				session.setAttribute("open", "yes");
				int hit = bvo.getHit() + 1;
				bvo.setHit(hit);
				bservice.updateHit(bvo);
				//매퍼 아이디 : update_hit
			}
			session.setAttribute("bvo", bvo);
			path = "bbs/view.jsp";
			break;
			
			// 게시글 삭제
		case "remove":
			b_idx = Integer.parseInt(request.getParameter("b_idx"));
			
			bservice.removeBBS(b_idx);
			isForward = false;
			path = "BBSController?cmd=allList";
			break;
			
			// 수정 페이지 이동
		case "updatePage":
			path = "bbs/update_page.jsp";
			break;
			
			// 게시글 수정
		case "update":
			bvo = new BVO();
			bvo.setB_idx(Integer.parseInt(mr.getParameter("b_idx")));
			bvo.setTitle(mr.getParameter("title"));
			bvo.setContent(mr.getParameter("content"));
			
			File newFile = mr.getFile("filename");
			String oldFile = mr.getParameter("oldfile");
			
			if(newFile!=null) {
				// 새 첨부 파일 O
				if(oldFile!=null) {
					//기존 파일 O
					File removeFile = new File(realPath + "/" + oldFile);
					if(removeFile.exists()) { // 기존 첨부 차일 유무 확인
						removeFile.delete();
					}
				}
				bvo.setFilename(newFile.getName());
			}else {
				// 새 첨부 파일 X
				if(oldFile!=null) {
					// 기존 첨부 파일 O
					bvo.setFilename(oldFile);
				}else { // 기존 첨부 파일 X
					bvo.setFilename("");
				}
			}
			bservice.updateBBS(bvo);
			isForward = false;
			path = "BBSController?cmd=view&b_idx=" + mr.getParameter("b_idx");
			break;
			
		case "download":
			FileDownload fd = new FileDownload();
			fd.doDownload(request, response);
			break;
			
		}
			
		
		if(isForward) {
			request.getRequestDispatcher(path).forward(request, response);
		}else {
			response.sendRedirect(path);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
