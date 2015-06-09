<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
$(document).ready(function(){
	$("table#listTB tbody tr").on("click", function(){
		var id = $(this).find(":first-child").text();
			location.href="<%=request.getContextPath() %>/admin/getMemberById.do?memberId="+id;
	});
});


</script>

<style type="text/css">

table#listTB thead tr{
	font-weight: bold;
	background: lightgray;
}
</style>

<form method="post" id="f_coupon" action="<%=request.getContextPath() %>/admin/getMemberByKeyword.do">
	<div style="width:700px;" align="center">     
			<h2>회원목록</h2>
	</div>    
	<div style="width:700px;" align="right">     
		<select id="searchType" name="searchType">
			<option value="MEM_ID">ID</option>
			<option value="MEM_NAME">이름</option>
			<option value="MEM_MEMBERTYPE">등급</option>
			<option value="MEM_PHONENO">전화번호</option>
		</select>
		
		<input type="text" id="searchKeyword" name="searchKeyword">
		<input type="submit" id="memSearch" value="검색">
	</div> <p>
	

	<table id="listTB" style="width:700px">
		<thead>
			<tr>
				<td>ID</td>
				<td>이름</td>
				<td>생년월일</td>
				<td>E-MAIL</td>
				<td>전화번호</td>
				<td>마일리지</td>
				<td>회원등급</td>
				<td>가입일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.memberMap.member_list }" var="adminVO" varStatus="i">
				<tr id="search">
					<td>${adminVO.memberId}</td>
					<td>${adminVO.memberName}</td>
					<td>${adminVO.memberBirthdate}</td>
					<td>${adminVO.memberEmail}</td>
					<td>${adminVO.memberPhone}</td>
					<td>${adminVO.memberMileage}</td>
					<td>${adminVO.memberType}</td>
					<td>${adminVO.memberJoindate}</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
	
<c:choose>
	<c:when test="${memberMap.pagingBean.previousPageGroup }">
		<a href="<%=request.getContextPath() %>/admin/member_list_Paging.do?page=${memberMap.pagingBean.startPageOfPageGroup-1}"><font color="black">◀</font></a>
	</c:when>
	<c:otherwise>
		◀
	</c:otherwise>
</c:choose>	

<!-- 페이지 번호 -->
<c:forEach begin="${memberMap.pagingBean.startPageOfPageGroup }" end="${memberMap.pagingBean.endPageOfPageGroup}" var="pageNum">
	<c:choose>
		<c:when test="${pageNum == pagingBean.currentPage }">
			<b>[${pageNum}]</b>
		</c:when>
		<c:otherwise>
			<a  href="<%=request.getContextPath() %>/admin/member_list_Paging.do?page=${pageNum}">
				<font color="black">${pageNum}</font>
			</a>
		</c:otherwise>
	</c:choose>
	&nbsp;&nbsp;
</c:forEach>
<!-- 다음 페이지 그룹 -->
<c:choose>
	<c:when test="${memberMap.pagingBean.nextPageGroup }">
		<a href="<%=request.getContextPath() %>/admin/member_list_Paging.do?page=${memberMap.pagingBean.endPageOfPageGroup+1}"><font color="black">▶</font></a>
	</c:when>
	<c:otherwise>
		▶
	</c:otherwise>
</c:choose>	
	
</form>
