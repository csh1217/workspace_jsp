package org.joonzis.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joonzis.vo.PersonVO;

public class PersonAction {
	public String process(HttpServletRequest request) {
		
		// 1. 파라미터들 가져오기
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String self = request.getParameter("self");
		
		// 2. request 객체에 속성으로 저장
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("phone", phone);
		request.setAttribute("addr", addr);
		request.setAttribute("self", self);
		
		// 3. session 객체에 속성으로 저장
		// request와 session에 담기는 속성명을 같게 한다.
		// session에 담을 때에는 결과를 확인하기 위해 "session's "를 값 앞에 붙인다.
		HttpSession session = request.getSession();
		session.setAttribute("name", "session's " + name );
		session.setAttribute("age", "session's " + age );
		session.setAttribute("phone", "session's " + phone );
		session.setAttribute("addr", "session's " + addr );
		session.setAttribute("self", "session's " + self );
		
		// 4. vo 에 저장
		PersonVO vo = new PersonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setPhone(phone);
		vo.setAddr(addr);
		vo.setSelf(self);
		session.setAttribute("vo", vo);
		
		// 5. map에 저장
		Map<String, String> map = new HashMap<>();
		map.put("name", "map's " + name);
		map.put("age", "map's " + age);
		map.put("phone", "map's " + phone);
		map.put("addr", "map's " + addr);
		map.put("self", "map's " + self);
		session.setAttribute("map", map);
		
		return "view/output.jsp";
	}
}
