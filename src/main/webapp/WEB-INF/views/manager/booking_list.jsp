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

<table class='tb_list'>
	<thead>
		<tr>
			<th class='w-px120'>번호</th>
			<th class='w-px120'>예약자명</th>
			<th class='w-px120'>상품코드</th>
			<th>예약시작일</th>
			<th>예약종료일</th>
			<th class='w-px120'>예약상태</th>
			<th class='w-px120'>사용상태</th>
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
				<td>${vo.name }</td>
				<td>${vo.product_code }</td>
				<td>${vo.booking_start }</td>
				<td>${vo.booking_end }</td>
				<td>${vo.reserved }</td>
				<td>${vo.product_using }</td>
				<%-- <td>
					<c:choose>	
						<c:when test="${vo.product_id eq 'C'}">캐피닛(C)</c:when>
						<c:when test="${vo.product_id eq 'B'}">박스(B)</c:when>
					</c:choose>
				</td>
				<td>
					<c:choose>	
						<c:when test="${vo.product_type eq 'G'}">대(G)</c:when>
						<c:when test="${vo.product_type eq 'M'}">중(M)</c:when>
						<c:when test="${vo.product_type eq 'S'}">소(S)</c:when>
					</c:choose>
				</td>
				<td>
					<a href='detail.pd?product_code=${vo.product_code}'>${vo.product_code }</a>
					</td>
				<td>${vo.product_cost }</td>
				<td>${vo.product_using }</td> --%>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class='btnSet'>
<jsp:include page="/WEB-INF/views/include/page.jsp" />
</div>
</body>
</html>