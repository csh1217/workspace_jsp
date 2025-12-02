<%@page import="java.util.List"%>
<%@page import="org.joonzis.ex.MemberVO"%>
<%@page import="org.joonzis.ex.MemberDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// Java -> DAO
	String id = request.getParameter("id");
	MemberDAO dao = MemberDAO.getInstance();
	MemberVO vo = dao.getUserInfoById(id);
	pageContext.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.id} 회원 정보</title>
<link rel="stylesheet" href="table.css">

</head>
<body>
	<h1>${vo2.id}의 전체 데이터</h1>
	<table>
		<thead>
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty vo}">
					<tr>
						<td colspan="7">데이터가 없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<th>${vo.idx}</th>
						<th>${vo.id}</th>
						<th>${vo.pw}</th>
						<th>${vo.name}</th>
						<th>${vo.age}</th>
						<th>${vo.addr}</th>
						<th>${vo.reg_date}</th>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>