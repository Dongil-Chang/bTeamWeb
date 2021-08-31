<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>방명록 안내</h3>
<table>
	<tr>
		<th>예약 상품명</th><td>${vo.product_id}</td>
	</tr>
	<tr>
		<th>상품사이즈</th><td>${vo.product_type}</td>
	</tr>
	<tr>
		<th>예약 품목명</th><td>${vo.product_code}</td>
	</tr>
	<tr>
		<th>예약 시작일</th><td>${vo.booking_start}</td>
	</tr>
	<tr>
		<th>예약 종료일</th><td>${vo.booking_end}</td>
	</tr>
</table>
<a class='btn-fill' onclick='$("form").submit()'>예약완료하기</a>
</body>
</html>