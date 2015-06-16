<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
<script type="text/javascript">

function goUrl(){
	window.location="<%=request.getContextPath() %>/event/eventListPaging.do";
}

function deleteUrl(){
	var winNo = ${requestScope.winVO.winNo }
	window.location="<%=request.getContextPath() %>/event/deleteWinner.do?winNo="+winNo;
}

function modifyFormUrl(){
	var winNo = ${requestScope.winVO.winNo }
	window.location="<%=request.getContextPath() %>/event/modifyForm.do?winNo="+winNo;
}
</script>
</head>


<table style="width:600px">
	<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
		<tr>
			<td width="80" align="center">이벤트명</td>
			<td colspan="3">
				${requestScope.winVO.winTitle }
			</td>
		</tr>
		<tr>
			<td  align="center" width="100">등록일</td>
			<td>${requestScope.winVO.winRegdate}</td>
		</tr>
		
		<tr height="1" bgcolor="#82B5DF">
		<tr>
			<td colspan="4">${requestScope.winVO.winText}</td>
		</tr>
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
</table>
	<div style="width:600px;" align="right">                                  
			                                                               
			<input type="button" value="수정" onclick="modifyFormUrl();">
			<input type="button" value="삭제" onclick="deleteUrl();">
			<input type="button" value="이전 페이지" onclick="goUrl();">
	</div>    

