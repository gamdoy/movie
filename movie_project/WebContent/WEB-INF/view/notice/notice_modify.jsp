<%@ page contentType= "text/html;charset=UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function goUrl(){
	window.location="<%=request.getContextPath() %>/notice/notice.do";
}
</script>
<h2> 수정페이지</h2>

<form method="post" action="<%=request.getContextPath()%>/notice/modifyNotice.do"  id="notice_modifyForm" enctype="multipart/form-data">
<input type="hidden" id="notiNo" name="notiNo" value="${noticeVO.notiNo}">

	<table style="width:600px">
	<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
		<tr>
			<td width="80" align="center">제목</td>
			<td colspan="3">
				<input type="text" name="notiTitle" id='notiTitle' size="85">
			</td>
		</tr>
		<tr>
			<td  align="center">등록일</td>
			<td><input type="text" id="notiRegdate" name="notiRegdate" size="30"></td>
		</tr>
		<tr>   
			<td  align="center">파일</td>
			<td><input type="file" id="upfile" name="upfile" size="14"></td>
			
		</tr>
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
		<tr>
			 <td colspan="4"><textarea name="notiText" id="notiText" cols="70" rows="13"></textarea></td>
		</tr>
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
	</table>
	<div style="width:600px;" align="right">                                                                                                 
			<input type="submit" value="완료">
			<input type="reset" value="다시작성">
			<input type="button" value="취소" onclick="goUrl();">
	</div>    
</form>
