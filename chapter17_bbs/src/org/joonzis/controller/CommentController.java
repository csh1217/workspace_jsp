package org.joonzis.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.joonzis.service.CommentService;
import org.joonzis.service.CommentServiceImpl;
import org.joonzis.vo.BVO;
import org.joonzis.vo.CVO;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CommentController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		// 비동기 처리를 위한 객체들
		ObjectMapper objectMapper = null;  // JSON과 java객체를 변환
		String jsonString = null;  // JSON으로 직렬화 된 데이터를 담는 용도
		PrintWriter out = response.getWriter(); // 응답 객체
		JSONObject obj = new JSONObject();  // 응답으로 보내줄 객체
		
		// DB데이터를 다루기 위한 객체들
		CVO cvo = null;
		CommentService cservice = new CommentServiceImpl();
		
		switch (cmd) {
		case "insertComment":
			cvo = new CVO();
			cvo.setWriter(request.getParameter("writer"));
			cvo.setPw(request.getParameter("pw"));
			cvo.setContent(request.getParameter("content"));
			cvo.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
			cvo.setIp(Inet4Address.getLocalHost().getHostAddress());
			
			cservice.insertComment(cvo);
			obj.put("result", "success");
			break;
			
			//insertComment(cvo)
			//insert_comment
		}
		out.print(obj);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
