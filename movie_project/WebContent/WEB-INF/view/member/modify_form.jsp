<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">

$(document).ready(function(){
	$("#modifyForm").on("submit", function(){
		
		if(!$("#password").val()){
			alert("password를 입력하세요");
			$("#password").focus();
			return false;
		}
		
		if(!$("#name").val()){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		
		if(!$("#email").val()){
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
		
	});
});

</script>

<h2>회원정보 수정 폼</h2>

<form method="post" action="<%=request.getContextPath() %>/member/modifyMemberInfo.do" id="modifyForm" 
	      enctype="multipart/form-data">
	<input type="hidden" name="memId" value="${sessionScope.login_info.memId }">
	<table style="width:500px">
		<tr>
			<td>ID</td>
			<td>${sessionScope.login_info }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
				<input type="password" name="memPassword" id="memPassword">  <span class="errorMessage"><form:errors path="member.password"/></span>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${sessionScope.login_info.memName }</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="memEmail"  value="${sessionScope.login_info.memEmail }" id="email">  <span class="errorMessage"><form:errors path="member.email"/></span>
			</td>
		</tr>
		<tr> 
			<td colspan="2" >
				<input type="submit" value="수정">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
