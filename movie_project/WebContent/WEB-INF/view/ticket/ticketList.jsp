<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
var submitFlag = false;
$(document).ready(function() {
	$.each($("#searchType").children(), function() {
		if($(this).val() == "${searchVO.searchType }"){
			$(this).prop("selected", "selected");
		}
	});
});
function checkVal(){
	if(submitFlag && "${searchVO.searchKeyword}" != $("#searchKeyword").val()) {
		$("#searchKeyword").val("${searchVO.searchKeyword}");
	}
}
function goPage(pageNo){
	$("#page").val(pageNo);
	submitFlag = true;
	$("#ticketForm").submit();
}
function changeTicStatus(ticNo) {
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/theater/modifyTicketByNo.do",
		dataType:"text",
		data:{
					ticNo:ticNo,
					ticStatus:$("#ticStatusSel"+ticNo).val()
				},
		success:function(ret){
			if(ret == "true"){
				alert("수정에 성공하였습니다.");
			} else {
				alert("수정에 실패하였습니다.");
			}
		}	
	});
}
</script>
<form action="<%=request.getContextPath() %>/theater/ticketList.do" method="post" onsubmit="checkVal();" id="ticketForm">
	<input type="hidden" id="page" name="page" value="${pageNum}">
	<table>
	  <thead>
	  </thead>
	  <tbody>
	  	<c:forEach items="${ticketList}" var="ticket">
		  	<tr>
		  		<td>${ticket.ticNo }</td>
		  		<td>${ticket.memId }</td>
		  		<td>${ticket.movTitle }</td>
		  		<td>${ticket.ticDate }</td>
		  		<td>${ticket.mrName }</td>
		  		<td>${ticket.theaLocation }</td>
		  		<td>${ticket.ticPaytypename }</td>
		  		<td>
		  			<select onchange="changeTicStatus(${ticket.ticNo })" id="ticStatusSel${ticket.ticNo }">
			  			<c:forEach items="${ticStatusList }" var="ticStatus">
			  				<c:if test="${ticStatus.cmnNo != '112000' }">
				  				<c:choose>
				  					<c:when test="${ticStatus.cmnCodeKor == ticket.ticStatusname}">
				  						<option value="${ticStatus.cmnNo }" selected="selected">${ticket.ticStatusname }</option>
				  					</c:when>
				  					<c:otherwise>
				  						<option value="${ticStatus.cmnNo }">${ticStatus.cmnCodeKor }</option>
				  					</c:otherwise>
				  				</c:choose>
			  				</c:if>
			  			</c:forEach>
		  			</select>
		  		</td>
		  	</tr>
	  	</c:forEach>
	  </tbody>
	  <tfoot>
	  	<tr>
	  		<td colspan="9" >
	  			<span>
		  			<c:choose>
						<c:when test="${pagingBean.previousPageGroup }">
							<label onclick="goPage(${pagingBean.startPageOfPageGroup-1})">◀</label>
						</c:when>
						<c:otherwise>
							<label>◀</label>
						</c:otherwise>
					</c:choose>	
					<!-- 페이지 번호 -->
					<c:forEach begin="${pagingBean.startPageOfPageGroup }" end="${pagingBean.endPageOfPageGroup}" var="pageNum">
						<c:choose>
							<c:when test="${pageNum == pagingBean.currentPage }">
								<b>[${pageNum}]</b>
							</c:when>
							<c:otherwise>
								<label onclick="goPage(${pageNum})">
									${pageNum}
								</label>
							</c:otherwise>
						</c:choose>
						&nbsp;&nbsp;
					</c:forEach>
					<!-- 다음 페이지 그룹 -->
					<c:choose>
						<c:when test="${pagingBean.nextPageGroup }">
							<label onclick="goPage(${pagingBean.endPageOfPageGroup+1})">▶</label>
						</c:when>
						<c:otherwise>
							<label>▶</label>
						</c:otherwise>
					</c:choose>
				</span>
				<span style="float: right;">
		  			<select id="searchType" name="searchType">
		  				<option value="mem_id">ID</option>
		  				<option value="mov_title">영화</option>
		  				<option value="thea_location">지점</option>
		  				<option value="tic_paytype">결제방식</option>
		  				<option value="tic_status">결제여부</option>
		  			</select>
		  			<input type="text" name="searchKeyword" id="searchKeyword" value="${searchVO.searchKeyword }">
		  			<input type="submit" value="검색">
	  			</span>
	  		</td>
	  	</tr>
	  </tfoot>
	</table>
</form>
