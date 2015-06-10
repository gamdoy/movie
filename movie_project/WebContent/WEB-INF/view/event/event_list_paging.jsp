<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
table#listTB thead tr{
	font-weight: bold;
	background: lightgray;
}
table#listTB tbody tr{
	cursor: pointer;
}
div#dialog{
	width:400px;
	display: none;
}
article{
	border-bottom: 1px solid black;
	padding: 5px;
	padding-left: 10px;
}
</style>

<h2>이벤트목록</h2> 	
<c:if test="${fn:length(requestScope.pageMap.event_list) != 0 }">
	<table id="listTB" style="width:700px">
		<thead>
			<tr>
				<td>이벤트명</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.pageMap.event_list }" var="eventVO">
				<tr>
					<td>${eventVO.evtTitle }</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
</c:if>

<p>
<!-- 페이징 처리 -->
<!-- 이전 페이지 그룹 -->
<c:choose>
	<c:when test="${pageMap.pagingBean.previousPageGroup }">
		<a href="<%=request.getContextPath() %>/event/eventListPaging.do?page=${pageMap.pagingBean.startPageOfPageGroup-1}">◀</a>
	</c:when>
	<c:otherwise>
		◀
	</c:otherwise>
</c:choose>	
<!-- 페이지 번호 -->
<c:forEach begin="${pageMap.pagingBean.startPageOfPageGroup }" end="${pageMap.pagingBean.endPageOfPageGroup}" var="pageNum">
	<c:choose>
		<c:when test="${pageNum == pagingBean.currentPage }">
			<b>[${pageNum}]</b>
		</c:when>
		<c:otherwise>
			<a  href="<%=request.getContextPath() %>/event/eventListPaging.do?page=${pageNum}">
				<font color="black">${pageNum}</font>
			</a>
		</c:otherwise>
	</c:choose>
	&nbsp;&nbsp;
</c:forEach>
<!-- 다음 페이지 그룹 -->
<c:choose>
	<c:when test="${pageMap.pagingBean.nextPageGroup }">
		<a href="<%=request.getContextPath() %>/event/eventListPaging.do?page=${pagingBean.endPageOfPageGroup+1}">▶</a>
	</c:when>
	<c:otherwise>
		▶
	</c:otherwise>
</c:choose>	
</p>

<div id="dialog" title="선택 회원 정보">
	<figure id="pic"></figure>
	<section>
		<header style="text-align: center;font-weight: bolder;font-size: 1.3em;border-bottom: 2px solid black;padding: 5px"> 정보 </header>
		<article id="id"></article>
		<article id="password"></article>
		<article id="name"></article>
		<article id="email"></article>
		<article id="joinDate"></article>
	</section>
</div>

</body>
</html>