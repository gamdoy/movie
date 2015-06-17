<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table border="1">
	<tr>
			<td colspan="2"><c:choose>
					<c:when test="${empty requestScope.evtVO.evtFile }">
						<img src="<%=request.getContextPath()%>/images/event/noimage.png">
					</c:when>
					<c:otherwise>
						<img src="<%=request.getContextPath()%>/images/event/${requestScope.evtVO.evtFile }">
					</c:otherwise>
				</c:choose></td>
			
	</tr>
</table>

<form method="POST" action="<%=request.getContextPath() %>/event/modifyEventNumber.do" id="spec_event">
<input type="hidden" id="evtNo" name="evtNo" value="${evtVO.evtNo }">
<c:choose>
	<c:when test="${sessionScope.login_info.memMemberType=='102300'}">
		<input type="submit" value="수정하기"/>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>
</form>
<form method="POST" action="<%=request.getContextPath() %>/event/deleteEventByEventNumber.do" id="spec_event">
<input type="hidden" id="evtNo" name="evtNo" value="${evtVO.evtNo }">
<c:choose>
	<c:when test="${sessionScope.login_info.memMemberType=='102300'}">
		<input type="submit" value="삭제하기"/>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>
</form>
