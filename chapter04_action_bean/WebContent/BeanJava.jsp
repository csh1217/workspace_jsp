<%@page import="org.joonzis.bean.BeanJava"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BeanJava bj = new BeanJava();
	bj.setVal1("{value1}");
	bj.setVal2("{value2}");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<ul>
			<li>val1 : <%=bj.getVal1()%></li>
			<li>val2 : <%=bj.getVal2()%></li>
		</ul>
</body>
</html>