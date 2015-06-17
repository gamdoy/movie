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
	
	$(".memberTypeBtn").on("click", function(){
		var no = $(this).parent().parent().children().html();
		var memberType = $(this).parent().children().val();
		location.href="<%=request.getContextPath() %>/admin/modifyMemberType.do?memNo="+no+"&memberType="+memberType;
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

		$(".mileageBtn").on("click", function(){
			var no = $(this).parent().children().html();
			location.href="<%=request.getContextPath() %>/admin/getMemberByNo.do?memNo="+no;
		});
		
		$(".modifyMemBtn").on("click", function(){
			var no = $(this).parent().children().html();
			location.href="<%=request.getContextPath() %>/admin/modifyMember.do?memNo="+no;
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

#listTB
{
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;
	width: 480px;
	text-align: left;
	border-collapse: collapse;
	border: 1px solid #69c;
}

#listTB thead tr
{
	padding: 15px 10px 10px 10px;
	font-weight: normal;
	font-size: 14px;
	color: #039;
	border:0px;
}
#listTB tbody
{
	background: #e8edff;
	border:0px;
}
#listTB td
{
	padding: 10px;
	color: #669;
	border-top: 1px dashed #fff;
	border:0px;
}
#listTB tbody tr:hover td
{
	color: #339;
	background: #d0dafd;
	
}

</style>

<form method="post" id="f_coupon" action="<%=request.getContextPath() %>/admin/getMemberByKeyword.do" onsubmit="return checkVal();">
	<h2 align="center">회원목록</h2>

	<table id="listTB" style="width:800px" align="center">
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
					<td class="mileageBtn">${adminVO.memberMileage}	[발급]</td>
					<td>	
						<select id="memberType" class="memberType" name="memberType">
							<option value="${adminVO.memberTypeName}">${adminVO.memberTypeName}</option>
							<option value="회원">회원</option>
							<option value="VIP">VIP</option>
						</select>
					<input type="button" class="memberTypeBtn" value="변경">
					</td>
					<td>${adminVO.memberJoindate}</td>
					<td class="modifyMemBtn">[수정하기]</td>
				</tr> 
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td align="center" colspan="5">     
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
				</td>
				
				<td colspan="3" align="center">     
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
				</td>
			</tr>
		</tfoot>
	</table>
	<p>
</form>
