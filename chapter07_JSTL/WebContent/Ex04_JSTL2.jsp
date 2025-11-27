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
		1. JSTL을 이용하여 평균변수(avg), 학점변수(grade) 생성
		2. JSTL을 이용하여 합격불합격 출력(pass)60점이상일시 합격
		
		3. 출력 데이터
			국어 : 00점
			영어 : 00점
			수학 : 00점
			평균 : 00점
			학점 : A
			합격여부 : 합격
	 -->
	 <c:set var="avg" value="${(param.kor + param.eng + param.mat)/3}"/>
	 <!-- EL은 '' 안의 값을 문자열로 인식(""은 변수나 프로퍼티) -->
	 <c:set var="grade" value="${avg >= 90 ? 'A' : (avg >= 80 ? 'B' : (avg >= 70 ? 'C' : (avg >= 60 ? 'D' : 'F')))}"/>
	 <c:set var="pass" value="${avg >= 60 ? '합격' : '불합격'}"/> 
	 
	 <p>국어 : ${param.kor}점</p>
	 <p>영어 : ${param.eng}점</p>
	 <p>수학 : ${param.mat}점</p>
	 <p>평균 : ${avg}점</p>
	 <p>학점 : ${grade}</p>
	 <p>합격여부 : ${pass}</p> 
</body>
</html>