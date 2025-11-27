<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		1. 기본 forEach 사용 예제
		최소 값 , 최대 값, 최소 값~ 최대 값 화면에 출력
		최소,최대 값을 변수 저장
	 -->
	 <c:set var="max" value="${param.num1 >= param.num2 ? param.num1 : param.num2}"/>
	 <c:set var="min" value="${param.num1 < param.num2 ? param.num1 : param.num2}"/>
	 <c:forEach var="i" begin="${min}" end="${max}" step="1">
	 		${i}
	 </c:forEach>
	 <br>
	 최대값 : ${max}<br>
	 최소값 : ${min}<br>

	 <br><hr><br>
	 <!-- 2. 향상 forEach를 이용하여 음식 종류들 출력 -->
		<c:forEach var="name" items="${paramValues.foods}">
			${name}<br>
		</c:forEach>
	
	
</body>
</html>