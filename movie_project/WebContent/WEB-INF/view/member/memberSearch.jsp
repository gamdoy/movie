<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function idlink() {
	window.open("<%= request.getContextPath()%>/member/idsearch_form.do","idsearch", "height=500, width=700, menubar=no, toolbar=no, location=no, status=no, resizable=no");
}
function pwlink() {
	window.open("<%= request.getContextPath()%>/member/pwsearch_form.do","idsearch", "height=500, width=700, menubar=no, toolbar=no, location=no, status=no, resizable=no");
}
</script>
</head>
<body>
	
	<input type="button" id="idsearch" value="아이디찾기" onclick="idlink()">
	<input type="button" id="passwordsearch" value="비밀번호찾기" onclick="pwlink()">

</body>
</html>