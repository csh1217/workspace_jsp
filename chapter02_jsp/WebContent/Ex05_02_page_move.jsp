<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>페이지 이동 중간 페이지</h1>
    <div>이름 = <%=name%></div>
    <div>나이 = <%=age%></div>
    
    <br> <hr> <br>

    <!-- 1. <a> 태그로 이동하기-->
    <!-- 파라미터 전달 X-->
     <a href="Ex05_03_page_move.jsp">파라미터x</a>
    <!-- 파라미터 전달 O-->
     <a href="Ex05_03_page_move.jsp?name=<%=name%>&age=<%=age%>">파라미터O</a>  
       
    <br> <hr> <br>
     
    <!-- 2. location.href로 이동하기 -->
     <button onclick="location.href='Ex05_03_page_move.jsp'">파라미터x</button>
     <button onclick="location.href='Ex05_03_page_move.jsp?name=<%=name%>&age=<%=age%>'">파라미터o</button>
     
     <!-- 3. 포워드 -->
      <%
        /*request
            .getRequestDispatcher("Ex05_03_page_move.jsp")
            .forward(request, response);*/
      %>
      <!-- 4. 리다이렉트 -->
      <%
      	/*response.sendRedirect("Ex05_03_page_move.jsp");*/
      %>

</body>
<script type="text/javascript">

</script>
</html>