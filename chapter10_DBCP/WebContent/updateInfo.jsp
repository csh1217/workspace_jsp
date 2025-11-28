<%@page import="org.joonzis.ex.MemberVO"%>
<%@page import="org.joonzis.ex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// jsp->dao
	MemberDAO dao = MemberDAO.getInstance();
	MemberVO table = dao.getUserInfoById(id);//비밀번호 비교를 위해
	pageContext.setAttribute("table", table);
	
	int result = 0;
	if(table != null){
		if(pw.equals(table.getPw())){
			result = 1;
		}
	}
	pageContext.setAttribute("result", result);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">
<style type="text/css">
	input[type=text]{
		width: 100px;
	}
	input[type=number]{
		width: 60px;
	}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${empty table}">
			<script type="text/javascript">
				alert("존재하지 않는 아이디입니다");
				history.back();
			</script>
		</c:when>
		<c:when test="${result==0}">
			<script type="text/javascript">
				alert("!비밀번호 입력 오류!");
				history.back();
			</script>
		</c:when>
		<c:otherwise>
			<h1>${table.id}의 회원정보 변경</h1>
			<form method="get">
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
							<td>${table.idx}</td>
							<td><input type="text" name="id"></td>
							<td><input type="text" name="pw"></td>
							<td><input type="text" name="name"></td>
							<td><input type="number" name="age"></td>
							<td><input type="text" name="addr"></td>
							<td>${table.reg_date}</td>
							<td><input type="button" value="수정" onclick="update(this.form)"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
</body>
<script type="text/javascript">

	function update(f) {
		if(!f.id.value||!f.pw.value||!f.name.value||!f.age.value||!f.addr.value){
			alert("정보 입력 오류");
			return;
		}
		f.action = 'update.jsp';
		f.submit();
	}
</script>
</html>