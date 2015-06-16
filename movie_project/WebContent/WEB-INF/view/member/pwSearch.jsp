<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/jquery.js"></script>
</head>
<body>
<c:choose>
	<c:when test="${empty member_info.memPassword }">
<form action="<%=request.getContextPath() %>/member/pwSearch.do" enctype="multipart/form-data" onsubmit="return setSubmit();">
<table>
	<tr>
		<td>아이디</td><td><input type="text" id="memId" name="memId"></td>
	</tr>
	<tr>
		<td>이름</td><td><input type="text" id="memName" name="memName"></td>
	</tr>
	<tr>
		<td>이메일</td><td><input type="text" id="memEmail" name="memEmail"></td>
	</tr>
	<tr>
			<td colspan="2">
				<input type="submit" value="password찾기">
				<input type="submit" value="취소">	
			</td>
		</tr>
</table>
</form>
	</c:when>
	<c:when test="${!empty member_info.memPassword }">
	<br>
	<br>
	<br>
	찾으신 ID의 비밀번호는: ${member_info.memPassword } 입니다.
	</c:when>
</c:choose>
</body>
</html>