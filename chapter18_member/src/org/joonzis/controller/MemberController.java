package org.joonzis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		if(cmd == null) {
			cmd = "mainPage";
		}
		
		String path = "";
		
		switch (cmd) {
		case "mainPage":
			path = "index.jsp";
			break;
		case "myPage":
			path = "/member/myPage.jsp";
			break;
		case "loginPage":
			path = "/member/loginPage.jsp";
			break;
		case "joinPage":
			path = "/member/joinPage.jsp";
			break;
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
