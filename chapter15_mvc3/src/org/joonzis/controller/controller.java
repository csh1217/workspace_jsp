package org.joonzis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.LanguageService;
import org.joonzis.service.LanguageServiceImpl;

@WebServlet("*.do")//.do로 끝나는
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// *.do 로 요청이 들어왔을 때 구분 방법
		// <요청 확인>
		// 전체 경로 : /chapter15_mcv3/xxx.do
		String requestURI = request.getRequestURI();
		// 컨텍스트 : /chapter15_mcv3
		String contextPath = request.getContextPath();
		// 요청 : /xxx.do
		String cmd = requestURI.substring(contextPath.length());
		
		// service 객체 생성
		LanguageService service = new LanguageServiceImpl();
		String result = null;
		
		switch (cmd) {
		case "/hangeul.do":
			result = service.executeHangeul();
			break;
		case "/english.do":
			result = service.executeEnglish();
			break;
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("view/output.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
