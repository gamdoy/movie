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
				<td>ID</td>
				<td>이름</td>
				<td>Email</td>
				<td>가입일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.event_list }" var="EventVO">
				<tr>
					<td>${EventVO.id }</td>
					<td>${EventVO.name}</td>
					<td>${EventVO.email}</td>
					<td>${EventVO.joinDate}</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
</c:if>