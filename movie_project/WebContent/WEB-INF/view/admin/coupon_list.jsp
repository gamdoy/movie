<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style type="text/css">
table
{
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;
	width: 480px;
	text-align: left;
	border-collapse: collapse;
	border: 1px solid #69c;
}

thead tr
{
	padding: 15px 10px 10px 10px;
	font-weight: normal;
	font-size: 14px;
	color: #039;
	border:0px;
}
tbody
{
	background: #e8edff;
	border:0px;
}
td
{
	padding: 10px;
	color: #669;
	border-top: 1px dashed #fff;
	border:0px;
}
tbody tr:hover td
{
	color: #339;
	background: #d0dafd;
	
}

</style>

<style type="text/css">
table#listTB thead tr{
	font-weight: bold;
	background: lightgray;
}
</style>

<body style="overflow-X:hidden">                 

	<div style="width:500px;" align="center"> <h2><font color="darkgray"><b>쿠폰목록</b></font></h2></div><p/>
	<c:if test="${fn:length(requestScope.coupon_list) != 0 }">
		<table style="width:500px" border="1" align="center">
			<thead>
				<tr>
					<td>쿠폰이름</td>
					<td>사용유무</td>
					<td>사용일자</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.coupon_list }" var="couponVO" varStatus="i">
					<tr id="${couponVO.coupNo }">
						<td>${couponVO.coupTypeName}</td>
						<td>${couponVO.coupUsedValue}</td>
						<td>${couponVO.coupUsedDate}</td>
					</tr> 
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>