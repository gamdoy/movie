<%@ page contentType= "text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글읽기</title>
<script type="text/javascript">
function goUrl(){
	window.location="<%=request.getContextPath() %>/qa/qa.do";
}
</script>
</head>
<body>
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
			<td>${requestScope.qa_vo.fqRegdate}</td>
		</tr>
		<tr>   
			<td  align="center">파일</td><td colspan="3"></td>
		</tr>
		<tr height="1" bgcolor="#82B5DF">
		<tr>
			<td colspan="4">${requestScope.qa_vo.qaText}</td>
		</tr>
		<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
	</table>
	<div style="width:600px;" align="right">                                                                                                 
			<input type="submit" value="수정">
			<input type="button" value="취소" onclick="goUrl();">
	</div>    
</body>
</html>