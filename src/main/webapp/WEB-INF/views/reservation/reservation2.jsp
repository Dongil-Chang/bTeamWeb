<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>예약하기</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">  <!-- DatePicker  css 복사  -->

<style>

 /*datepicker에서 사용한 이미지 버튼 style적용*/
   img.ui-datepicker-trigger {
      margin-left:5px; vertical-align:middle; cursor:pointer;
}

.booking{
border-bottom:0px solid #ddd;margin:1em 0;
width: 100%;
min-height: 60%;
}
.booking .bookingHeader{
position:relative;
/* zoom:1 */
}
.booking .bookingHeader {
position:absolute;
bottom:0;
right:0;
border:0;
padding:0;
overflow:visible;
/* background: #00D4FF; */
cursor:pointer
}
.bookingBody{
margin:0;padding:0
}
.bookingBody::after {
	clear : both;
	content : '';
	display : block;
}
.booking_left {
	width : 35%;
	height : 650px;
	line-height : 650px;
	background : #05668d;
	float: left;
	font-size : 60pt;
	font-weight: 800;
	color : #fff;
}
.booking_right {
	width : 65%;
	height : 400px;
	background : #fff;
	float: right;
}
.booking .bookingBody .article{
list-style:none;
margin-top: 30px;
}
.booking .step{
/* margin:10px 0; */
padding : 10px 50px;
background: #ededed;
}
.booking .step .a{
	display:block;text-align:left; 
    background:url("faq1_icon_q.png") no-repeat 0 0;
    padding:20px 0 0 35px;
    font-size:18px;
    color:#5e5e5e;
    font-weight:bold;
    line-height: 27px;
    cursor:pointer;
    margin: 10px 0; !important
}
.booking .step a:hover, .booking .step a:active, .booking .step a:focus{}
.booking .a{
	background:#ededd8; 
	padding: 10px 75px 10px 75px;
    font-size: 16px;
    color: #444444;
    line-height: 22px;
    padding : 20px 50px;
    border-top: 1px solid #bdbdbd;
    /* margin:-10px 0 0 0; */
}
.step{
	max-width : 100%;
	text-align : left;
	font-size: 20px;
	border-bottom: 1px solid #bdbdbd;
	margin-top: 10px;
}
.a{
	max-width : 100%;
	text-align : left;
	font-size: 18px;
}	
.change_color { 
	color: #eb4034;
}
.return_color { 
	color: #eb4034;
}
.a figure {
	display : inline;
}
.a figure img {
	width: 15%; height : 15%;
}
summary { cursor: pointer; }

/* 삼각형 없애기 */
summary { list-style: none; }	
summary::-webkit-details-marker {
	display: none;
}	
*/	

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src='js/join_check.js'></script>

</head>
<body>
<!-- <h3>예약하기</h3> -->

<form action="reserv_step2.rv" method="post">
<input type = "hidden" name="booking_member" value="${loginInfo.id }" />
<input type = "hidden" name="booking_start" value="${vo.booking_start}" />
<input type = "hidden" name="booking_end" value="${vo.booking_end}" />

<div class='booking'>
	<div class="bookingHeader">
    	<ul>
			<!-- 로그인 시 정보를 담고 있는 session.setAttribute("loginInfo", vo)을 통해 admin 값을 가져와 비교함.		
			<c:if test="${loginInfo.subcode eq '3'}">
				<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
			</c:if> -->	
		</ul>
    </div>
	<div class='bookingbody'>
		<details open>
			<summary class='step' >4단계 (예약 서비스 상품 선택)
				<i class="fas fa-angle-double-down"></i>
			</summary>
			<!-- 그리드 형태 -->
			<div>
			<ul class='grid'>
				<c:forEach items="${list }" var="vo">
					<li>
<%-- 						<div><a onclick='go_detail(${vo.product_code})'>${vo.product_code }</a></div> --%>
						<h3 class="productCode">${vo.product_code }</h3>
						
<%-- 						
						<c:if test="${vo.product_using eq 'Y'}">
							<div style="color: red;">사용중</div>
						</c:if>
 --%>					<c:if test="${vo.reserved != 'Y'}">
							<div style="color: green;">사용 가능</div>
						</c:if>
						<%-- <div>${vo.booking_start }</div> --%>
					</li>
				</c:forEach>
			</ul>	
			</div>
		</details>
	</div>
</div>
</form>

<div class='btnSet'>
	<a class = 'btn-fill' onclick= "$('form').submit()">다음 단계</a>
	<a class = 'btn-empty' href=''>취소</a>
</div>
<script>

/* $('.productCode').click(function(){
	$(this).addClass('change_color');
}); 
 */

 
 $('.productCode').toggle(function() {
	 
		$(this).addClass('change_color').css('display', 'block');;
	}, function() {
		$(this).addClass('return_color');
	}); 
 
</script>
</body>
</html>
