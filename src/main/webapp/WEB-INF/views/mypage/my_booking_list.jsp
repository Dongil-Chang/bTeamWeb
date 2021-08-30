<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>예약목록</h3>
<form action="list.pd" method="post">
<input type="hidden" name="curPage" value="1" />
<div id = 'list-top'>
	<div>
		<ul>
			<li>
				<select name='search' class='w-px90'>
					<option value="all"  ${page.search eq 'all' ? 'selected' : '' }>전체</option>
					<option value="booking_member" ${page.search eq 'booking_member' ? 'selected' : '' }>예약자명</option>
					<option value="product_code" ${page.search eq 'product_code' ? 'selected' : '' }>상품코드</option>
				</select>
			</li>
			<li><input type="text" name='keyword' value='${page.keyword }' class='w-px300' /></li>
			<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>
		</ul>
	</div>
</div>
</form>

<table class='tb_list'>
	<thead>
		<tr>
			<th class='w-px120'>번호</th>
			<th class='w-px120'>상품코드</th>
			<th>예약시작일</th>
			<th>예약종료일</th>
			<th class='w-px120'>예약상태</th>
			<th class='w-px120'>사용상태</th>
			<th class='w-px120'>상품형태</th>
		</tr>
	</thead>
	<tbody>	
		<c:if test="${empty page.list }">
			<tr>
				<td colspan='7'>상품 정보가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach items = '${page.list }' var='vo'>
			<tr>
				<td>${vo.no }</td>
				<td>${vo.product_code }</td>
				<td>${vo.booking_start }</td>
				<td>${vo.booking_end }</td>
				<td>${vo.reserved }</td>
				<td>${vo.product_using }</td>
				<td>${vo.product_id }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class='btnSet'>
<jsp:include page="/WEB-INF/views/include/page.jsp" />
</div>
</body>
</html>