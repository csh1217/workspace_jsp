<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<p>7 + 2=${7+2}</p>
		<p>7 - 2=${7-2}</p>
		<p>7 * 2=${7*2}</p>
		<p>7 / 2=${7/2}</p>
		<p>7 % 2=${7%2}</p>
		<% pageContext.setAttribute("a", 1);%>
		a : ${a}
</body>
</html>