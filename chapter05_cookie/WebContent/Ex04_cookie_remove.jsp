<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <%
	 Cookie[] cookieBox = request.getCookies();
	 if(cookieBox != null && cookieBox.length > 0){
		for(int i=0; i<cookieBox.length;i++){
			if(cookieBox[i].getName().equals("name")){
				cookieBox[i].setMaxAge(0);
				response.addCookie(cookieBox[i]);
				out.print("쿠키 값을 삭제하였습니다");
				break;
			}
		}
	}else{
		out.print("쿠키가 존재하지 않습니다.");
	}
	 %>
</body>
</html>