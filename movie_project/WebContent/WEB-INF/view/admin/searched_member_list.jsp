<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
$(document).ready(function(){
	var searchType = $("#currentSearchType").val();
	var searchKeyword =$("#currentSearchKeyword").val();
	var pageNum;
	
	$.each($("#searchType").children(), function() {
	      if($(this).val() == "${currentSearchType }"){
	         $(this).prop("selected", "selected");
	      }
	 });
	
	/* 
	if ($("#MEM_ID").val() == searchType){
		$("#MEM_ID").prop("selected","selected")
	}
	if ($("#MEM_NAME").val() == searchType){
		$("#MEM_NAME").prop("selected","selected")
	}
	if ($("#MEM_MEMBERTYPE").val() == searchType){
		$("#MEM_MEMBERTYPE").prop("selected","selected")
	}
	if ($("#MEM_PHONENO").val() == searchType){
		$("#MEM_PHONENO").prop("selected","selected")
	}
	 */

	$("table#listTB tbody tr").on("click", function(){
			var no = $(this).find(":first-child").text();
				location.href="<%=request.getContextPath() %>/admin/getMemberByNo.do?memNo="+no;
	});
	 
	$("#nextPageGroupBtn").on("click", function(){
		location.href="<%=request.getContextPath() %>/admin/getMemberByKeyword.do?page=${searchedMemberMap.pagingBean2.endPageOfPageGroup+1}&searchType="+searchType+"&searchKeyword="+searchKeyword;
	});
	
	 $(".PageBtn").on("click", function(){
		var label = $(this).text();
		location.href="<%=request.getContextPath() %>/admin/getMemberByKeyword.do?page="+label+"&searchType="+searchType+"&searchKeyword="+searchKeyword;
	});
	
	$("#previousPageGroupBtn").on("click", function(){
		location.href="<%=request.getContextPath() %>/admin/getMemberByKeyword.do?page=${searchedMemberMap.pagingBean2.startPageOfPageGroup-1}&searchType="+searchType+"&searchKeyword="+searchKeyword;
	});
});
function checkVal() {
	if(!$("#searchKeyword").val()){
		alert("검색어를 입력하세요.");
		return false;
	}
}

</script>

<style type="text/css">

table#listTB thead tr{
	font-weight: bold;
	background: lightgray;
}
</style>

<form method="post" id="f_coupon" action="<%=request.getContextPath() %>/admin/getMemberByKeyword.do" onsubmit="return checkVal();">
	<div style="width:700px;" align="center">     
			<h2>회원목록</h2>
	</div>    
	<div style="width:700px;" align="right">     
		<select id="searchType" name="searchType" >
			<option id="MEM_ID" value="MEM_ID">ID</option>
			<option id="MEM_NAME" value="MEM_NAME">이름</option>
			<option id="MEM_MEMBERTYPE" value="MEM_MEMBERTYPE">등급</option>
			<option id="MEM_PHONENO" value="MEM_PHONENO">전화번호</option>
		</select>
		
		<input type="hidden" id="currentSearchType" value=${currentSearchType }>
		
		<input type="text" id="searchKeyword" name="searchKeyword" value=${currentSearchKeyword }>
		<input type="hidden" id="currentSearchKeyword" value=${currentSearchKeyword }>
		
		<input type="submit" id="memSearch" value="검색">
	</div> <p>
	

	<table id="listTB" style="width:700px">
		<thead>
			<tr>
				<td hidden="hidden">회원번호</td>
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
			<c:forEach items="${requestScope.searchedMemberMap.member_list }" var="adminVO" varStatus="i">
				<tr id="search">
					<td hidden="hidden">${adminVO.memNo}</td>
					<td>${adminVO.memberId}</td>
					<td>${adminVO.memberName}</td>
					<td>${adminVO.memberBirthdate}</td>
					<td>${adminVO.memberEmail}</td>
					<td>${adminVO.memberPhone}</td>
					<td>${adminVO.memberMileage}</td>
					<td>${adminVO.memberTypeName}</td>
					<td>${adminVO.memberJoindate}</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
	<p/>
	
	<div style="width:700px;" align="center">     
		<c:choose>
			<c:when test="${searchedMemberMap.pagingBean2.previousPageGroup }">
				<label id="previousPageGroupBtn" name="previousPageGroupBtn">
					<font color="black">◀</font>
				</label>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>	
		
		<!-- 페이지 번호 -->
		<c:forEach begin="${searchedMemberMap.pagingBean2.startPageOfPageGroup }" end="${searchedMemberMap.pagingBean2.endPageOfPageGroup}" var="pageNum">
			<c:choose>
				<c:when test="${pageNum == searchedMemberMap.pagingBean2.currentPage}">
					<b><i>${pageNum}</i></b>
				</c:when>
				<c:otherwise>
					<label class="PageBtn" name="${pageNum}" value="${pageNum}">
						${pageNum}
					</label>
				</c:otherwise>
			</c:choose>
			&nbsp;&nbsp;
		</c:forEach>
		<!-- 다음 페이지 그룹 -->
		<c:choose>
			<c:when test="${searchedMemberMap.pagingBean2.nextPageGroup }">
				<label id="nextPageGroupBtn" name="nextPageGroupBtn"><font color="black">▶</font></label>
			</c:when>
			<c:otherwise>
				▶
			</c:otherwise>
		</c:choose>	
	</div>
	
</form>
