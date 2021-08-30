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
<!-- jQueryUI  DatePicker 사용을 위한 js -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>

<script type="text/javascript">
	$(function() {

		//오늘 날짜를 출력
		$("#today").text(new Date().toLocaleDateString());

		//datepicker 한국어로 사용하기 위한 언어설정
		$.datepicker.setDefaults($.datepicker.regional['ko']);

		// 시작일(fromDate)은 종료일(toDate) 이후 날짜 선택 불가
		// 종료일(toDate)은 시작일(fromDate) 이전 날짜 선택 불가

		//시작일.
		$('#booking_start').datepicker({
			showOn : "both", // 달력을 표시할 타이밍 (both: focus or button)
			buttonImage : "imgs/calendar.png", // 버튼 이미지
			buttonImageOnly : true, // 버튼 이미지만 표시할지 여부
			buttonText : "날짜선택", // 버튼의 대체 텍스트
			dateFormat : "yy-mm-dd", // 날짜의 형식
			changeMonth : true, // 월을 이동하기 위한 선택상자 표시여부
			minDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이전 날짜 선택 불가)
			onClose : function(selectedDate) {
				// 시작일(booking_start) datepicker가 닫힐때
				// 종료일(booking_end)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
				$("#booking_end").datepicker("option", "minDate", selectedDate);
			}
		});

		//종료일
		$('#booking_end').datepicker(
				{
					showOn : "both",
					buttonImage : "imgs/calendar.png",
					buttonImageOnly : true,
					buttonText : "날짜선택",
					dateFormat : "yy-mm-dd",
					changeMonth : true,
					minDate: 0, // 오늘 이전 날짜 선택 불가
					onClose : function(selectedDate) {
						// 종료일(booking_end) datepicker가 닫힐때
						// 시작일(booking_start)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
						$("#booking_start").datepicker("option", "maxDate",	selectedDate);
					}
				});
	});
</script>


</head>
<body>
<!-- <h3>예약하기</h3> -->

<form action="reserv_step1.rv" method="post">
<input type = "hidden" name="booking_member" value="${loginInfo.id }" />
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
		<details>
			<summary class='step'>1단계 (예약일 선택)
				<i class="fas fa-angle-double-down"></i>
			</summary>
			<div style="text-align: left; padding-left: 50px; background: #fea">
			오늘 날짜 : <span id="today"></span></div>
			<div class='a'>
				<label for="booking_start">예약시작일</label>
				<input type="text" name="booking_start" id="booking_start">
				<a id='delete' ><i class="font-img fas fa-minus-circle"></i></a>
          ~
          		<label for="booking_end">종료일</label>
          <input type="text" name="booking_end" id="booking_end">
				<a id='delete' ><i class="font-img fas fa-minus-circle"></i></a>
			</div>
		</details>
		<details>
			<summary class='step'>2단계 (상품 형태 선택)
				<i class="fas fa-angle-double-down"></i>
			</summary>			
			<div class='a'>
				<figure>
					<img src = "imgs/cabi.png" alt="cabinet" />
					<input type="radio" id="product_id" name="product_id" value='C' checked >캐비닛
				</figure>
				<figure>
					<img src = "imgs/box.png" alt="box" />
					<input type="radio" id="product_id" name="product_id" value='B' >박스
				</figure>
			</div>
		</details>
		<details>
			<summary class='step'>3단계 (상품 사이즈 선택)
				<i class="fas fa-angle-double-down"></i>
			</summary>			
			<div class='a'>
			<i class="fab fa-gofore"></i>
				<input type="radio" id="product_type" name="product_type" value='G' checked >대
			<i class="fab fa-medium-m"></i>
				<input type="radio" id="product_type" name="product_type" value='M' >중
			<i class="fab fa-stripe-s"></i>
				<input type="radio" id="product_type" name="product_type" value='S' >소
			</div>
		</details>
	</div>
</div>
</form>

<div class='btnSet'>
	<a class = 'btn-fill' onclick= "$('form').submit()">다음 단계</a>
	<a class = 'btn-empty' href='/'>취소</a>
</div>

</body>
</html>
