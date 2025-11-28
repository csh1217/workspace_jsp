<%@page import="org.joonzis.ex.MemberVO"%>
<%@page import="java.util.List"%>
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
			result = dao.remove(id);
		}
	}
	pageContext.setAttribute("result", result);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty table}">
			<script type="text/javascript">
				alert("없는 아이디 입니다.");
				location.href='view_all.jsp';

			</script>
		</c:when>
		<c:when test="${result > 0}">
			<script type="text/javascript">
				alert("데이터 삭제 성공");
				location.href='view_all.jsp';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("비밀번호가 다릅니다.");
				location.href = 'view_all.jsp';
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>