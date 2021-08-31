<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id='privacy_body' class='w-pct50 center' >
		<div class='privacy_title' style="margin-top: 10px;">
			<h3>${vo.provision_nm }</h3>
		</div>
		<div class='privacy_content' style="margin-top: 5px;">
			<div>
				<textarea class='p_textarea'>${vo.provision_content }</textarea>
			</div>
		</div>
		<div class='btnSet'>
			<a class='btn-fill' onclick="history.go(-1)">회원가입으로</a> <!-- 이전 화면으로 이동 -->
		</div>
	</div>
</body>
</html>