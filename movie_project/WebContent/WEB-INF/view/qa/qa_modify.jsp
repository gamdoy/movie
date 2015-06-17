<%@ page contentType= "text/html;charset=UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$(':radio[name="qaSecret"]').on("click", function(){
		var secretCheck = $(':radio[name="qaSecret"]:checked').val();
		if(secretCheck=='use'){
			$("#qaPassword").prop("disabled","disabled");
		}
		if(secretCheck=='unuse'){
			$("#qaPassword").prop("disabled",null);
		}
	});
});

function goUrl(){
	window.location="<%=request.getContextPath() %>/qa/login/qa.do";
}
</script>
<h2> 수정페이지</h2>

<form method="post" action="<%=request.getContextPath()%>/qa/login/modifyQa.do"  id="qa_modifyForm" enctype="multipart/form-data">
<input type="hidden" id="fqNo" name="fqNo" value="${qaVO.fqNo}">
<input type="hidden" id="fileNo" name="fileNo" value="${qaVO.fileNo }">

	<table style="width:600px">
	<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
		<tr>
			<td width="80" align="center">제목</td>
			<td colspan="3">
				<input type="text" name="qaTitle" id='qaTitle' size="85" value="${requestScope.qaVO.qaTitle }">
			</td>
		</tr>
		<tr>
			<td  align="center">ID</td>
			<td><input type="text" id="name" name="name" size="30" value="${requestScope.qaVO.memId }" disabled="disabled"></td>
			<td  align="center" width="100">비밀번호</td>
			<td><input type="password" id="qaPassword" name="qaPassword" size="30" disabled="disabled" value=${requestScope.qaVO.qaPassword }></td> 
		</tr>
		<tr>   
			<td  align="center">파일</td>
			<td><input type="file" id="upfile" name="upfile" size="14"></td>
			<td align="center">공개설정</td><td align="right"><input type="radio" name="qaSecret" value="use" checked="checked">공개<input type="radio" name="qaSecret" value="unuse" >비공개</td>
		</tr>
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
		<tr>
			 <td colspan="4"><textarea name="qaText" id="qaText" cols="70" rows="13">${requestScope.qaVO.qaText }</textarea></td>
		</tr>
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
	</table>
	<div style="width:600px;" align="right">                                                                                                 
			<input type="submit" value="완료">
			<input type="reset" value="다시작성">
			<input type="button" value="취소" onclick="goUrl();">
	</div>    
</form>
