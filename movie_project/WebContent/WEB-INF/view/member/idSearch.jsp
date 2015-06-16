<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/date_picker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/jquery.js"></script>
<script type="text/javascript">

function setSubmit(){
	if(!$("#memName").val()){
		alert("이름을 입력하세요.");
		return false;
	}else if($("#tel").val()=="phoneType"){
			alert("번호를 선택하세요.");
			return false;	
	}else if(!$("#tel2").val()){
			alert("전화번호를 입력하세요.");
			return false;	
	}else if(!$("#tel3").val()){
			alert("전화번호를 입력하세요.");
			return false;
	}
$("#memPhoneNo").val($("#tel").val()+"-"+$("#tel2").val()+"-"+$("#tel3").val());
}
</script>
</head>
<body>
<c:choose>
	<c:when test="${empty member_info.memId}">
<form action="<%=request.getContextPath() %>/member/idSearch.do" id="idSearchForm" 
	      enctype="multipart/form-data" onsubmit="return setSubmit();">
	      <br>
	      <br>
	      <br>
	      <br>
	<input type="hidden" id="memPhoneNo" name="memPhoneNo">      
	<table>
	<tr>
		<td>이름</td><td><input type="text" id="memName" name="memName"></td>
	</tr>
	<tr>
			<td>연락처</td>
			<td> 
				<select name="tel" id="tel">
					<c:forEach items="${telList }" var="tList">
						<c:choose>
							<c:when test="${tList.cmnCodeEng == fn:substring(sessionScope.login_info.memPhoneNo,0,3) }">
								<option value="${tList.cmnCodeEng}" selected="selected"> ${tList.cmnCodeKor}</option>					
							</c:when>
							<c:otherwise>
								<option value="${tList.cmnCodeEng}"> ${tList.cmnCodeKor}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				-
				<input type="text" size="4" id="tel2" name="tel2">
				-
				<input type="text" size="4" id="tel3" name="tel3">
				 
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<input type="text" name="memBirthDate" id="memBirthDate" size="6" readonly="readonly" onClick="datePicker(event,'memBirthDate')" onClick="datePicker(event,'memBirthDate')">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="id찾기">
				<input type="submit" value="취소">	
			</td>
		</tr>	
</table>
</form>
</c:when>
<c:when test="${!empty member_info.memId}">
	${member_info.memId}

</c:when>
</c:choose>
</body>
</html>