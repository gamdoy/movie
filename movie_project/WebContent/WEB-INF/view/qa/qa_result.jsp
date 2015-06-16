 <%@ page contentType= "text/html;charset=UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>글읽기</title>
<script type="text/javascript">

$(document).ready(function(){
	$("#hiddenBtn").on("click", function(){
		if($("#comment_body").prop("hidden")==false){
			$("#comment_body").prop("hidden", "true");
		}else{
			$("#comment_body").prop("hidden", false);
		}
	});
});
function goUrl(){
	window.location="<%=request.getContextPath() %>/qa/qa.do";
}

function deleteUrl(){
	var number = ${requestScope.qa_vo.fqNo }
	window.location="<%=request.getContextPath() %>/qa/deleteQa.do?number="+number;
}

function replyUrl(){
	var fqParentNumber = ${requestScope.qa_vo.fqParentNumber }
	var fqNo = ${requestScope.qa_vo.fqNo }
	window.location="<%=request.getContextPath() %>/qa/reply.do?fqParentNumber="+fqParentNumber+"&fqNo="+fqNo;
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
			<td width="200">
			${requestScope.qa_vo.qaTitle }
			</td>
			<td align="center">조회수</td>
			<td align="center">${requestScope.qa_vo.qaCount }</td>
		</tr>
		<tr>
			<td  align="center">이름</td>
			<td>${requestScope.qa_vo.fqNo }</td>
			<td  align="center" width="100">작성일</td>
			<td align="center">${requestScope.qa_vo.fqLastdate}</td>
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
	
	
<c:choose>
	<c:when test="${QaVO.qaSecret=='use' }">
		<td class="secret"><input type="hidden" id="secret${QaVO.fqNo }" value="${QaVO.qaPassword }">
		<img src="<%=request.getContextPath()%>/upload/kgpg.png" width="10px" height="10px">${QaVO.qaTitle}</td> 
	</c:when>
	<c:otherwise>
		<td>${QaVO.qaTitle}</td> 
	</c:otherwise>
</c:choose>
	
	<!-- COMMENT게시판 Form -->
	<table width="600" border="3" bordercolor="gray" >
	<thead >
		<tr height="30">
			<c:choose>
				<c:when test="${countComment ==0}">
				<td align="center" bgcolor="gray"  id="hiddenBtn"><font color="red">덧글 ${countComment }</font></td>
				</c:when>
			<c:otherwise>
				<td align="center" bgcolor="gray"  id="hiddenBtn"><font color="red">덧글 ${countComment } 
				<img src="<%=request.getContextPath()%>/upload/ico-new.gif" width="10px" height="10px"></font></td>
			</c:otherwise>
			</c:choose>
			<td colspan="3" align="center" bgcolor="gray"><font color="white">Comment</font></td>
		</tr>
	</thead>
		<tbody id="comment_body">
		<form method="post" action="<%=request.getContextPath()%>/qa/comment.do"  id="qa_commentForm">
			<input type="hidden" name="fqNo" value="${requestScope.qa_vo.fqNo}" >
			<input type="hidden" name="memNo" value="${requestScope.qa_vo.memNo}">
			
				<c:forEach items="${requestScope.comment_list}" var="commentVO">
				<tr id="comment_content">
					<td align="center">${commentVO.memNo}</td>
					<td style="border-right-color: white">${commentVO.comText}</td><td style="border-left-color:white" ><div align="right">
					<a href="<%=request.getContextPath() %>/qa/selectComment_toModify.do?comNo=${commentVO.comNo }&fqNo=${requestScope.qa_vo.fqNo}"><font color="black" size="1">수정</font></a>
					|
					<a href="<%=request.getContextPath() %>/qa/deleteComment.do?comNo=${commentVO.comNo }&fqNo=${requestScope.qa_vo.fqNo}"><font color="black" size="1">삭제</font></a></div></td>
					<td align="center" width="130">${commentVO.comRegDate}</td>
				</tr> 
				</c:forEach>
				
				<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
			<tr>
				<td align="center" bgcolor="gray" width="100"><font color="white">id값</font></td>
				<td align="center" width="500" colspan="2"><textarea name="comText" cols="48" rows="3"></textarea></td>
				<td align="center"><input type="submit" value="확인" ></td>
			</tr>
			
			</tbody>
		
		</form>
	</table>
	<div style="width:600px;" align="right">
			<input type="button" value="덧글" onclick="replyUrl();">                                                      
			<input type="button" value="수정" onclick="modifyUrl();">	
			<input type="button" value="삭제" onclick="deleteUrl();">
			<input type="button" value="이전 페이지" onclick="goUrl();">
	</div>    

