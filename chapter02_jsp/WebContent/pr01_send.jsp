<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		<fieldset>
			ele1 : <input type="text" name="ele1"> <br>
			ele2 : <input type="number" name="ele2"> <br>
			ele3 :
			<input type = "checkbox" name="ele3" value="val1">val1
			<input type = "checkbox" name="ele3" value="val2">val2
			<input type = "checkbox" name="ele3" value="val3">val3
			<br>
			<button type="button" value="전송" onclick="send(this.form)">전송</button>
		</fieldset>
	</form>

</body>
<script type="text/javascript">
	function send(f) {
		f.action = '/chapter02_jsp/pr02_receive.jsp';
		f.submit();
	}
</script>
</html>