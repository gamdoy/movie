 <%@ page contentType= "text/html;charset=UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>글읽기</title>
<script type="text/javascript">
function goUrl(){
	window.location="<%=request.getContextPath() %>/qa/qa.do";
}

function deleteUrl(){
	var number = ${requestScope.qa_vo.fqNo }
	window.location="<%=request.getContextPath() %>/qa/deleteQa.do?number="+number;
}
</script>
<script type="text/javascript">

function modifyUrl(){
	var number = ${requestScope.qa_vo.fqNo }
	window.location="<%=request.getContextPath() %>/qa/modify.do?number="+number;
}

</script>
</head>

<input type="hidden" id="qaCount" name="qaCount" value="${qaCount}+1">	
	<table style="width:600px">
	<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
		<tr>
			<td width="80" align="center">제목</td>
			<td colspan="3">
				${requestScope.qa_vo.qaTitle }
			</td>
		</tr>
		<tr>
			<td  align="center">이름</td>
			<td>${requestScope.qa_vo.fqNo }</td>
			<td  align="center" width="100">작성일</td>
			<td>${requestScope.qa_vo.fqLastdate}</td>
		</tr>
		<tr>   
			<td  align="center">파일</td>
			<td colspan="3" ><a href="<%=request.getContextPath() %>/qa/download.do?filename=${requestScope.fileName }"><font color="black">${requestScope.fileName }</font></a></td>
		</tr>
		<tr height="1" bgcolor="#82B5DF">
		<tr>
			<td colspan="4">${requestScope.qa_vo.qaText}</td>
		</tr>
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
	</table>
	<div style="width:600px;" align="right">                                  
			                                                               
			<input type="button" value="수정" onclick="modifyUrl();">
			<input type="button" value="삭제" onclick="deleteUrl();">
			<input type="button" value="이전 페이지" onclick="goUrl();">
	</div>    

