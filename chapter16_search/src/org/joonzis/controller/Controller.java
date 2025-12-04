package org.joonzis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.EmployeeService;
import org.joonzis.service.EmployeeServiceImpl;
import org.joonzis.vo.EmployeeVO;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		if(cmd == null) {
			cmd = "allList";
		}
		
		// 단순 화면 이동/ 데이터 사용 구분
		boolean isForward = true;
		// 이동 경로
		String path = "";
		// service객체 생성
		EmployeeService service = new EmployeeServiceImpl();
		//List 객체
		List<EmployeeVO> list = null;
		
		switch (cmd) {
		// DB사용 ---------
		case "allList" :
			list = service.getAll();
			request.setAttribute("list", list);
			path = "allList.jsp";
			break;
		case "deptList":
			String deptId = request.getParameter("department_id");
			
			list = service.getDeptId(deptId);
			request.setAttribute("list", list);
			request.setAttribute("deptId", deptId);
			path = "deptList.jsp";
			break;
		case "inputDept" :
			path = "input_dept.jsp";
			break;
		case "dynamicList":
			Map<String, Object> info = new HashMap<>();
			int key = Integer.parseInt(request.getParameter("key"));
			String value = request.getParameter("value");
			info.put("key", key);
			info.put("value", value);
			
			list = service.getDynamic(info);
			request.setAttribute("list", list);
			request.setAttribute("key", key);
			request.setAttribute("value", value);
			path = "dynamicList.jsp";
			break;
		case "inputDynamic" :
			path = "input_dynamic.jsp";
			break;
		
		
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
