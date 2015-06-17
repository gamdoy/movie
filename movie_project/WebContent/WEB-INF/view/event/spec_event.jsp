<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav style="width: 800px" align="center">
<h2>${evtVO.evtTitle}</h2>
</nav>
No.${evtVO.evtNo} | 기간 : ${evtVO.evtStartDate }~${evtVO.evtEndDate }

<table border="1">
	<tr>
			<td colspan="2"><c:choose>
					<c:when test="${empty requestScope.evtVO.evtFile }">
						<nav style="width: 800px" align="center">
							<img src="<%=request.getContextPath()%>/images/event/noimage.png">
						</nav>
					</c:when>
					<c:otherwise>
						<nav style="width: 800px" align="center">
							<img src="<%=request.getContextPath()%>/images/event/${requestScope.evtVO.evtFile }">
						</nav>
					</c:otherwise>
				</c:choose></td>
	
	</tr>
</table>

<form method="POST" action="<%=request.getContextPath() %>/event/modifyEventNumber.do" id="spec_event">
<input type="hidden" id="evtNo" name="evtNo" value="${evtVO.evtNo }">
<c:choose>
	<c:when test="${sessionScope.login_info.memMemberType=='102300'}">
		<nav style="width: 800px" align="right">
			<input type="submit" value="수정하기"/>
		</nav>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>
</form>
<form method="POST" action="<%=request.getContextPath() %>/event/deleteEventByEventNumber.do" id="spec_event">
<input type="hidden" id="evtNo" name="evtNo" value="${evtVO.evtNo }">
<c:choose>
	<c:when test="${sessionScope.login_info.memMemberType=='102300'}">
		<nav style="width: 800px" align="right">
			<input type="submit" value="삭제하기"/>
		</nav>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>
</form>
