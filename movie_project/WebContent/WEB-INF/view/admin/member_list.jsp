<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
$(document).ready(function(){
	$("table#listTB tbody tr").on("click", function(){
		var id = $(this).find(":first-child").text();
			location.href="<%=request.getContextPath() %>/admin/getMemberById.do?memberId="+id;
	});
	
	var searchData = $("#memSearchData").val();
	var searchColumn = $("#memberSearch").val();
	$("#memSearch").on("click", function(){
		
		
		
		
	});
});
</script>

<style type="text/css">

table#listTB thead tr{
	font-weight: bold;
	background: lightgray;
}
</style>


	<div style="width:700px;" align="center">     
			<h2>회원목록</h2>
	</div>    
	<div style="width:700px;" align="right">     
		<select id="memberSearchColumn" name="memberSearchColumn">
			<option value="id">ID</option>
			<option value="name">이름</option>
			<option value="type">등급</option>
			<option value="phone">전화번호</option>
		</select>
		
		<input type="text" id="memSearchData" name="memSearchData">
		<input type="button" id="memSearch" value="검색">
	</div> <p>
	
<c:if test="${fn:length(requestScope.member_list) != 0 }">
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
			<c:forEach items="${requestScope.member_list }" var="adminVO" varStatus="i">
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
</c:if>
