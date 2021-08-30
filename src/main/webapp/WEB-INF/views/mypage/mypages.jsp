<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#myPageBox {
	margin : 0 auto;
	text-align : left;
	border: 1px solid #ccc;
	background: #eee;
	max-width: 1000px;
	min-height: 100px;
	padding : 20px 30px 0 30px;
	margin-top: 10px;
	font-size : 20px;
	border-radius: 1em;
	margin-left: 30px;
}
.mypage_name { display: flex; line-height: 24px;}
.mypage_a {font-size : 28px; font-weight: 600; margin-right: 20px;}
.mypage_info {width: 100%; display : flex;}
.mapage_con_left{width: 50%; padding : 10px;}
.mapage_con_right{width: 50%; padding : 10px;}
</style>
</head>
<body>
	<div id="myPageBox">
		<div class='mypage_name'>
			<div class='mypage_a'>마이페이지</div>
			<div>
				<span style="color: #6096ba; font-weight: 600">${loginInfo.name }</span>님은
				<c:choose>
					<c:when test="${loginInfo.subcode eq '1' }">일반회원</c:when>
					<c:when test="${loginInfo.subcode eq '2' }">사업자회원</c:when>
					<c:when test="${loginInfo.subcode eq '3' }">관리자</c:when>
				</c:choose>
				입니다.
			</div>
		</div>
		<div class='mypage_title'>
			<div class='mypage_info'>
				<div class='mapage_con_left'>
					<div>
						<ul>
							<li>아이디 : ${loginInfo.id }</li>
							<li>이메일 : ${loginInfo.email }</li>
						</ul>
					</div>
				</div>
				<div class='mapage_con_right'>
					<div>
						<ul>
							<li>성 &nbsp;&nbsp;명 : ${loginInfo.name }</li>
							<li>연락처 : ${loginInfo.tel }</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>