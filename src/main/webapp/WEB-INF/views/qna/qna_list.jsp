<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FAQ 1</title>
<link rel="stylesheet" href="css/accordion.css">	
<script type="text/javascript" src="js/accordion.js"></script>
<style>
/* FAQ */


#faq-top { padding : 20px 4%; }
#faq-top div { height: 30px; }
#faq-top ul {margin: 0; display: flex;}
#faq-top ul li * {vertical-align: middle;}
#faq-top ul li:not(:first-child) { margin-left: 3px;}
#faq-top ul:first-child {float: left;}
#faq-top ul:last-child {float: right;}

/* .faq{ */
/* border-bottom:0px solid #ddd;margin:1em 0; */
/* width: 100%; */
/* min-height: 60%; */
/* } */

/* .faq .faqHeader{ */
/* position:relative; */
/* /* zoom:1 */ */
/* } */

/* .faq .faqHeader { */
/* position:absolute; */
/* bottom:0; */
/* right:0; */
/* border:0; */
/* padding:0; */
/* overflow:visible; */
/* /* background: #00D4FF; */ */
/* cursor:pointer */
/* } */

/* .faqBody{ */
/* margin:0;padding:0 */
/* } */

/* .faqBody::after { */
/* 	clear : both; */
/* 	content : ''; */
/* 	display : block; */
/* } */

/* .faq_left { */
/* 	width : 35%; */
/* 	height : 650px; */
/* 	line-height : 650px; */
/* 	background : #05668d; */
/* 	float: left; */
/* 	font-size : 60pt; */
/* 	font-weight: 800; */
/* 	color : #fff; */
/* } */

/* .faq_right { */
/* 	width : 65%; */
/* 	height : 400px; */
/* 	background : #fff; */
/* 	float: right; */
/* } */


/* .faq .faqBody .article{ */
/* list-style:none; */
/* margin-top: 30px; */
/* } */

/* .faq .q{ */
/* /* margin:10px 0; */ */
/* padding : 10px 50px; */
/* background: #ededed; */
/* } */

/* .faq .q .a{ */
/* 	display:block;text-align:left;  */
/*     background:url("faq1_icon_q.png") no-repeat 0 0; */
/*     padding:20px 0 0 35px; */
/*     font-size:18px; */
/*     color:#5e5e5e; */
/*     font-weight:bold; */
/*     line-height: 27px; */
/*     cursor:pointer; */
/*     margin: 10px 0; !important */
/* } */
    
/* .faq .q a:hover, .faq .q a:active, .faq .q a:focus{} */

/* .faq .a{ */
/* 	background:#ededd8;  */
/* 	padding: 10px 75px 10px 75px; */
/*     font-size: 16px; */
/*     color: #444444; */
/*     line-height: 22px; */
/*     padding : 20px 50px; */
/*     border-top: 1px solid #bdbdbd; */
/*     /* margin:-10px 0 0 0; */ */
/* } */
/* .q{ */
/* 	max-width : 100%; */
/* 	text-align : left; */
/* 	font-size: 20px; */
/* 	border-bottom: 1px solid #bdbdbd; */
/* 	margin-top: 10px; */
/* } */

/* .a{ */
/* 	max-width : 100%; */
/* 	text-align : left; */
/* 	font-size: 18px; */
	
/* }	 */
/* summary { cursor: pointer; } */

/* 삼각형 없애기 */
/* summary { list-style: none; }	 */
/* summary::-webkit-details-marker { */
/* 	display: none; */
/* }	 */
*/	


</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>

</head>
<body>
<!-- <h3>소소한 FAQ</h3> -->
<form action="list.QnA" method="post">
<input type="hidden" name="curPage" value="1" />
<div id = 'faq-top'>
	<div>
		<ul>
			<li>
				<select name='search' class='w-px90'>
					<option value="all"  ${page.search eq 'all' ? 'selected' : '' }>전체</option>
					<option value="faq_title" ${page.search eq 'faq_title' ? 'selected' : '' }>제목</option>
					<option value="faq_content" ${page.search eq 'faq_content' ? 'selected' : '' }>내용</option>
				</select>
			</li>
			<li><input type="text" name='keyword' value='${page.keyword }' class='w-px300' /></li>
			<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>
		</ul>
	
		<ul>
			<!-- 관리자로 로그인된 경우만 글쓰기 가능 -->
			<!-- 로그인 시 정보를 담고 있는 session.setAttribute("loginInfo", vo)을 통해 admin 값을 가져와 비교함. -->			
			<c:if test="${loginInfo.subcode eq '3'}">
				<li><a class='btn-fill' href='new.pd'>상품등록</a></li>
			</c:if>
		</ul>
	</div>
</div>
</form>

<div class='faq'>
	<div class="faqHeader">
    	<ul>
			<!-- 로그인 시 정보를 담고 있는 session.setAttribute("loginInfo", vo)을 통해 admin 값을 가져와 비교함.		
			<c:if test="${loginInfo.subcode eq '3'}">
				<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
			</c:if> -->	
		</ul>
    </div>
	<div class='faqbody'>
		<c:forEach items="${page.list}" var="vo">
			<details>
				<summary class='q'>${vo.faq_title }
					<i class="fas fa-angle-double-down"></i>
				</summary>
				<pre class='a'>${vo.faq_content }</pre>
			</details>
		</c:forEach>
	</div>
</div>
<div class='btnSet'>
<jsp:include page="/WEB-INF/views/include/page.jsp" />
</div>
</body>
</html>
