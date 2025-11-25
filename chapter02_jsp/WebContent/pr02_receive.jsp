<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String ele1 = request.getParameter("ele1");
	int ele2 = Integer.parseInt(request.getParameter("ele2"));
	String[] ele3 = request.getParameterValues("ele3");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li> ele1 : <%=ele1 %></li>
		<li> ele2 : <%=ele2 %></li>
		<li> ele3 : 
			<%
				if(ele3 != null){
					for(int i=0; i<ele3.length; i++){%>
						<%= ele3[i]%>
					<%}
				}else{%>
					none
				<%}
			%>
	</ul>

</body>
</html>