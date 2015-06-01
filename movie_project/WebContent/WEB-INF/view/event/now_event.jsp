<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style type="text/css">

table#listTB thead tr{
	font-weight: bold;
	background: lightgray;
}
</style>
<h2>회원목록</h2> 	
<c:if test="${fn:length(requestScope.event_list) != 0 }">
	<table id="listTB" style="width:700px">
		<thead>
			<tr>
				<td>NO</td>
				<td>이름</td>
				<td>시작일</td>
				<td>종료일</td>
				<td>등록일</td>
				<td>이벤트</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.event_list }" var="EventVO">
				<tr>
					<td>${EventVO.evtNo }</td>
					<td>${EventVO.evtName}</td>
					<td>${EventVO.evtStartDate}</td>
					<td>${EventVO.evtEndDate}</td>
					<td>${EventVO.evtRegDate}</td>
					<td>${EventVO.evtTitle}</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
</c:if>

