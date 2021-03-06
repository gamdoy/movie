<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
function getEvent(evtNo){
	$("#evtNo").val(evtNo);
	$("#now_event").submit();
}

</script>

<form method="POST" action="<%=request.getContextPath() %>/event/specEvent.do" id="now_event">
<input type="hidden" name="evtNo" id="evtNo"> 	
	<c:if test="${fn:length(search_event_list) != 0 }">
		<table id="listTB" style="width:800px; color: gray; border: 10ex; border-color: white;" >
			
			<tbody>
				
						<c:forEach items="${search_event_list }" var="eventVO" varStatus="idx">
						<c:if test="${idx.index%4==0 }">
					<tr>
						</c:if>
								<td width="15" height="20" align="center" style="width: 200px;">
									<div style="width:200;">
										<div onclick="getEvent(${eventVO.evtNo })">
											<c:choose>
												<c:when test="${empty eventVO.evtFile }">
													<img src="<%=request.getContextPath()%>/images/noimage.png">
												</c:when>
												<c:otherwise>
													<img src="<%=request.getContextPath()%>/images/event/${eventVO.evtFile }">
												</c:otherwise>
											</c:choose>
										</div>
										
										<div style="color: black;">
											${eventVO.evtTitle }
										</div>
										
										<div style="color: black;">
											${eventVO.evtStartDate }~${eventVO.evtEndDate }
										</div>
									</div>
								</td>
						<c:if test="${(idx.index+1)%4==0 }">
					</tr>
						</c:if>
						</c:forEach>
				
			</tbody>
		</table>
	</c:if>
</form>
