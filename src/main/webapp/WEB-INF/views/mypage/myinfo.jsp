<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>정보수정 페이지</h3>
	
	<form method="post" action="myinfo_chk">
	<input type="hidden" name ="id" value="${loginInfo.id }" />
		<table>
			<tr>
				<th class='w-px120'>비밀번호</th>
			</tr>
			<tr>
				<td><input type="password" name='pw' title='비밀번호' class='chk' /> </td>
			</tr>
		</table>
	</form>
	<div class='btnSet'>
		<a class='btn-fill' onclick=" $('form').submit() ">확인</a>
	</div>

</body>
</html>