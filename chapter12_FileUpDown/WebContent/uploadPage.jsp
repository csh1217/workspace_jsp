<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
				<!-- 
					파일 업로드 시 method는 반드시 post여야 함
					(파일을 get으로 받을 시 URL이 너무 길어져 업로드가 안됨)
					enctype="multipart/form-data"로 인코딩 필수
				 -->
		<form action="upload.jsp" method="post" enctype="multipart/form-data">
			<p>업로더<input type="text" name="uploader"></p>
			<p>첨부파일<input type="file" name="filename"></p>
			<input type="submit" value="업로드">
		</form>
	</div>
</body>
</html>