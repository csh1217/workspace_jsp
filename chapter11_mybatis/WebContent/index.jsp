<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<link rel="stylesheet" href="table.css">
</head>
<body>
	<form method="post">
		<table>
			<thead>
				<tr>
					<th colspan="2">회원 정보 관리</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>.
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<input type="button" value="전체보기" onclick="view_all()">&nbsp;&nbsp;
						<input type="button" value="검색" onclick="search()">&nbsp;&nbsp;
						<input type="button" value="삽입" onclick="insert(this.form)">&nbsp;&nbsp;
						<input type="button" value="삭제" onclick="remove(this.form)">&nbsp;&nbsp;
						<input type="button" value="수정" onclick="update_page(this.form)">&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
<script type="text/javascript">
	function view_all(){
		location.href = 'view_all.jsp';
	}
	function search() {
		location.href ='search.jsp';
	}
	function insert(f){
		if(!f.id.value||!f.pw.value||!f.name.value||!f.age.value||!f.addr.value){
			alert('!모든 내용 입력!');
			return;
		}
		f.action = 'insert.jsp';
		f.submit();
	}
	
	function remove(f){
		if(!f.id.value||!f.pw.value){
			alert("!아이디&비밀번호 입력!")
			return;
		}
		f.action = 'remove.jsp';
		f.submit();
	}
	function update_page(f){
		if(!f.id.value||!f.pw.value){
			alert("!아이디&비밀번호 입력!")
			return;
		}
			f.action = 'updateView.jsp';
		    f.submit();
	}
</script>
</html>









