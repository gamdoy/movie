<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
function goUrl(){
	window.location="<%=request.getContextPath() %>/event/eventListPaging.do";
}
</script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/date_picker.js">
</script>

<h2> 추가페이지</h2>

<form method="post" action="<%=request.getContextPath()%>/event/modifyWinner.do"  id="modifyWinner_form" enctype="multipart/form-data">
<input type="hidden" id="winNo" name="winNo" value="${winVO.winNo}">

	<table style="width:600px">
	<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
		<tr>
			<td width="80" align="center">이벤트명</td>
			<td colspan="3">
				<input type="text" name="winTitle" id='winTitle' size="85">
			</td>
		</tr>
		<tr>
			<td  align="center">기간</td>
			<td><input type="text" id="winRegdate" name="winRegdate" size="30"onClick="datePicker(event,'winRegdate')" readonly="readonly"></td>
		</tr>
		
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
		<tr>
			 <td colspan="4"><textarea name="winText" id="winText" cols="70" rows="13"></textarea></td>
		</tr>
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
	</table>
	<div style="width:600px;" align="right">                                                                                                 
			<input type="submit" value="완료">
			<input type="reset" value="다시작성">
			<input type="button" value="취소" onclick="goUrl();">
	</div>    
</form>