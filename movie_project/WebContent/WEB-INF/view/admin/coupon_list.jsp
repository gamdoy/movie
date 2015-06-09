<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<style type="text/css">

table#listTB thead tr{
	font-weight: bold;
	background: lightgray;
}

</style>
<h2>쿠폰목록</h2>
<c:if test="${fn:length(requestScope.coupon_list) != 0 }">
	<table style="width:700px" border="1">
		<thead>
			<tr>
				<td>쿠폰이름</td>
				<td>사용유무</td>
				<td>사용일자</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.coupon_list }" var="couponVO" varStatus="i">
				<tr>
					<td>${couponVO.coupType}</td>
					<td>${couponVO.coupUsed}</td>
					<td>${couponVO.coupUsedDate}</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
</c:if>