<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<script type="text/javascript">
$(document).ready(function(){
	$(".mileageBtn").on("click", function(){
		var no = $(this).parent().children().html();
		location.href="<%=request.getContextPath() %>/admin/getMemberByNo.do?memNo="+no;
	});
	
	$(".memberTypeBtn").on("click", function(){
		var no = $(this).parent().parent().children().html();
		var memberType = $(this).parent().children().val();
		location.href="<%=request.getContextPath() %>/admin/modifyMemberType.do?memNo="+no+"&memberType="+memberType;
	});
	
	$(".modifyMemBtn").on("click", function(){
		var no = $(this).parent().children().html();
		location.href="<%=request.getContextPath() %>/admin/modifyMember.do?memNo="+no;
	});
	
});

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

<form method="post" id="f_coupon" action="<%=request.getContextPath() %>/admin/getMemberByKeyword.do">

	<h2 align="center">회원목록</h2>

	<table id="listTB" style="width:1200px" align="center" >
		<thead>
			<tr>
				<td hidden="hidden">회원번호</td>
				<td>ID</td>
				<td>이름</td>
				<td width="100">생년월일</td>
				<td>E-MAIL</td>
				<td>전화번호</td>
				<td width="120">마일리지</td>
				<td width="150">회원등급</td>
				<td width="100">가입일</td>
				<td width="120">정보수정</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.memberMap.member_list }" var="adminVO" varStatus="i">
				<tr id="search">
					<td hidden="hidden">${adminVO.memNo}</td>
					<td>${adminVO.memberId}</td>
					<td>${adminVO.memberName}</td>
					<td>${adminVO.memberBirthdate}</td>
					<td>${adminVO.memberEmail}</td>
					<td>${adminVO.memberPhone}</td>
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
			<td colspan="5" align="center">
				<c:choose>
					<c:when test="${memberMap.pagingBean.previousPageGroup }">
						<a href="<%=request.getContextPath() %>/admin/member_list_Paging.do?page=${memberMap.pagingBean.startPageOfPageGroup-1}"><font color="black">◀</font></a>
					</c:when>
					<c:otherwise>
						◀
					</c:otherwise>
				</c:choose>	

		<!-- 페이지 번호 -->
				<c:forEach begin="${memberMap.pagingBean.startPageOfPageGroup }"  end="${memberMap.pagingBean.endPageOfPageGroup}" var="pageNum">
					<c:choose>
						<c:when test="${pageNum == memberMap.pagingBean.currentPage }">
							<b><i>${pageNum}</i></b>
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
			</td>
			<td colspan="3" align="center">     
				<select id="searchType" name="searchType">
					<option value="MEM_ID">ID</option>
					<option value="MEM_NAME">이름</option>
					<option value="MEM_MEMBERTYPE">등급</option>
					<option value="MEM_PHONENO">전화번호</option>
				</select>
			
				<input type="text" id="searchKeyword" name="searchKeyword">
				<input type="submit" id="memSearch" value="검색">
			</td>
		</tr>
		</tfoot>
	</table><p>
</form>
