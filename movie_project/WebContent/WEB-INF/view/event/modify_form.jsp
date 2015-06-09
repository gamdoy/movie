<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">

$(document).ready(function(){
	$("#modifyForm").on("submit", function(){
		
		if(!$("#evtTitle").val()){
			alert("이벤트 이름을 입력하세요");
			$("#evtTitle").focus();
			return false;
		}
		
		if(!$("#evtStartDate").val()){
			alert("시작일을 입력하세요");
			$("#evtStartDate").focus();
			return false;
		}
		
		if(!$("#evtEndDate").val()){
			alert("종료일을 입력하세요");
			$("#evtEndDate").focus();
			return false;
		}
		
		if(!$("#evtRegDate").val()){
			alert("등록일을 입력하세요");
			$("#evtRegDate").focus();
			return false;
		}
		
		if(!$("#evtContent").val()){
			alert("이벤트내용을 입력하세요");
			$("#evtContent").focus();
			return false;
		}
		
	});
});

</script>

<h2>이벤트 수정 </h2>

<form method="post" action="<%=request.getContextPath() %>/event/modifyEvent.do" id="modifyForm" 
	      enctype="multipart/form-data">
	<input type="hidden" name="evtNo" value="${evtVO.evtNo }">
	<table style="width:500px">
		<tr>
			<td>이벤트번호</td>
			<td>${evtVO.evtNo }</td>
		</tr>
		<tr>
			<td width="100">이벤트 이름</td>
			<td>
				<input type="text" name="evtTitle" id='evtTitle'> 
				
			</td>
		</tr>
		<tr>
			<td>시작일</td>
			<td>
				<input type="text" id="evtStartDate" name="evtStartDate"> 
			</td>
		</tr>
		<tr>
			<td>종료일</td>
			<td>
				<input type="text" id="evtEndDate" name="evtEndDate"> 
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>
				<input type="text" id="evtRegDate" name="evtRegDate"> 
			</td>
		</tr>
		<tr>
			<td>이벤트 내용</td>
			<td>
				<input type="text" id="evtContent" name="evtContent"> 
			</td>
		</tr>
		<tr>
			<td>이벤트이미지</td>
			<td>
				<input type="file" id="evtImageFile" name="evtImageFile">
			</td>
		</tr>
		<tr>
			<td colspan="2">
		
				<input type="submit" value="수정">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>