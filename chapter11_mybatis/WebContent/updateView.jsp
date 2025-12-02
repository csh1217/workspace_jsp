<%@page import="org.joonzis.ex.MemberVO"%>
<%@page import="org.joonzis.ex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	// Java -> DAO
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPw(pw);
	
	MemberDAO dao = MemberDAO.getInstance();
	vo = dao.getUpdateView(vo);
	pageContext.setAttribute("vo", vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="index.jsp"/>
		<br> <hr> <br>
	<c:choose>
		<c:when test="${empty vo}">
		<script type="text/javascript">
				alert("!정보 입력 오류!");
				location.href = 'view_all.jsp';
			</script>
		</c:when>
		<c:otherwise>
		<h1>${vo2.id}의 회원정보 변경</h1>
			<form method="post">
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
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${vo.idx}</td>
							<td><input type="hidden" name="id" value="${vo.id}"></td>
							<td><input type="password" name="pw" value="${vo.pw}"></td>
							<td><input type="text" name="name" value="${vo.name}"></td>
							<td><input type="number" name="age" value="${vo.age}"></td>
							<td><input type="text" name="addr" value="${vo.addr}"></td>
							<td>${vo.reg_date}</td>
							<td><input type="button" value="수정"
								onclick="update(this.form)"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</c:otherwise>
	</c:choose>

</body>
<script type="text/javascript">

	function update(f) {
		if(!f.pw.value||!f.name.value||!f.age.value||!f.addr.value){
			alert("정보 입력 오류");
			return;
		}
		f.action = 'update.jsp';
		f.submit();
	}
</script>
</html>