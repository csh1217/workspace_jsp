<%@page import="org.joonzis.ex.MemberVO"%>
<%@page import="org.joonzis.ex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
<link rel="stylesheet" href="table.css">
</head>
<body>
	<form method="get">
		<table>
			<thead>
					<td colspan="2">검색</td>
			</thead>
			<tbody>
				<tr>
					<td>아이디 입력</td>
					<td><input type="text" name="id"></td>
				</tr>
			</tbody>
			<tfoot>
				<td colspan="2"><input type="button" value="검색" onclick="view_one(this.form)"></tr>
			</tfoot>
		</table>
	</form>
</body>
<script type="text/javascript">
	function view_one(f){
		// id 입력 검증 후 view_one.jsp로 이동
		if(!f.id.value){
			alert('!아이디 입력!')
			return;
		}
		f.action = 'view_one.jsp';
		f.submit();
	}
</script>
</html>