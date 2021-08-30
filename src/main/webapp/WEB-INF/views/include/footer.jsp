<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
footer figure{ background: #fff; margin: 14px 0 0; }
</style>
<footer style="font-size: 14px; margin-top: 20px; margin-bottom: 20px; display:block; background: #fff; width:100%">
	<figure style='position : fixed;  bottom:0px; height:100px '>
		<a href="list.rv" >
			<img alt="reservation" src="imgs/reservation.png" />
		</a>
		<figcaption class="hide">예약페이지</figcaption>
	</figure>
	<figure style='position : fixed; left : 180px; bottom:0px; padding:10px 0; '>
		<div>상호명 : 소소한 스토리지 &nbsp; 대표 : 소담1호 &nbsp; 개인정보책임관리자 : 소담2호</div>
		<div>사업장 주소 : 광주광역시 광주광역시 서구 농성동 한울직업전문학교 3층 301호</div>
		<div>연락처 : 062.555.6789</div>
		<div>Copyright 2021</div>
	</figure>
   <figure style='position : fixed; right : 0px; bottom:0px;'>
			<a href="#">
				<img src="imgs/topimg.png" alt="top" />
			</a>
				<figcaption class="hide">맨 위로</figcaption>
	</figure>

</footer>
<script>
$(function(){
	$('footer figure:nth-child(2)').css('width', $('footer').outerWidth()-(180+150) );
	$('.aside').css('height', $('body').prop("scrollHeight") - $('header').outerHeight()  - $('footer').outerHeight());
});
</script>