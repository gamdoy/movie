<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
$(document).ready(function(){
	$("tbody tr").on("click", function(){
		
		var winNo = $(this).find(":first-child").text();
		
		location.href="<%=request.getContextPath()%>/event/specWinner.do?winNo="+winNo;
	})
});
</script>

<script type="text/javascript">
function goUrl(){
	window.location="<%=request.getContextPath() %>/event/addWinnerForm.do";
}
</script>



   <!-- 게시판 목록 영역 -->
       <table border="1" summary="게시판 목록">
           
           
           <thead>
               <tr>
                    <th width="30">번호</th>
                    <th width="300">제목</th>
                    <th width="150">등록 일시</th>
               </tr>
           </thead>
           <tbody>
           	<c:forEach items="${requestScope.pageMap.winner_list }" var="winnerVO">
				<tr id="win_content">
				
					<td>${winnerVO.winNo}</td>
					<td>${winnerVO.winTitle}</td> 
					<td>${winnerVO.winRegdate}</td>
				</tr> 
			</c:forEach>
           

<tr>
<td colspan="3">
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
		<a href="<%=request.getContextPath() %>/event/eventListPaging.do?page=${pageMap.pagingBean.endPageOfPageGroup+1}">▶</a>
	</c:when>
	<c:otherwise>
		▶
	</c:otherwise>
</c:choose>
</td>
</tr>
</tbody>	
</table>

<c:choose>
	<c:when test="${sessionScope.login_info.memMemberType=='102300'}">
		<nav style="width: 510px" align="right">
		<input type="button" value="글쓰기" onclick="goUrl();"></nav>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>

