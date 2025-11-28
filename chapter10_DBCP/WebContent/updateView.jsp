<%@page import="org.joonzis.ex.MemberDAO"%>
<%@page import="org.joonzis.ex.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정할 사용자 정보 입력</title>
<link rel="stylesheet" href="table.css">
</head>
<body>
	<form method="get">
		<h1>수정할 사용자 정보 입력</h1>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="id"></td>
					<td><input type="text" name="pw"></td>
					<td><input type="button" value="확인" onclick="checkInfo(this.form)"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
<script type="text/javascript">
	function checkInfo(f){
		// id 입력 검증 후 view_one.jsp로 이동
		if(!f.id.value||!f.pw.value){
			alert('!정보 입력!')
			return;
		}
		f.action = 'updateInfo.jsp';
		f.submit();
	}
</script>
</html>