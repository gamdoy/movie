<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
function getEvent(evtNo){
	$("#evtNo").val(evtNo);
	$("#now_event").submit();
}

</script>



<style type="text/css">

table#listTB thead tr{
	font-weight: bold;
	background: lightgray;
}
</style>
<h2>진행중인 이벤트</h2>
<a href="<%=request.getContextPath() %>/event/regisForm.do"><font color="black">관리자 이벤트 추가</font></a>
<form method="POST" action="<%=request.getContextPath() %>/event/searchEventText.do" id="search_event">
<input type="text" id="searchText" name="searchText">
<input type="submit" value="검색">
</form>
<form method="POST" action="<%=request.getContextPath() %>/event/specEvent.do" id="now_event">
<input type="hidden" name="evtNo" id="evtNo"> 	
<c:if test="${fn:length(requestScope.event_list) != 0 }">
	<table id="listTB" style="width:700px">
		<thead>
			<tr>
				<td>NO</td>
				<td>이름</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.event_list }" var="eventVO">
				<tr>
					<td><label onclick="getEvent(${eventVO.evtNo })">${eventVO.evtNo }</label> </td>
					<td>${eventVO.evtName}</td>
					
				</tr> 
			</c:forEach>
		</tbody>
	</table>
</c:if>
</form>

