<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${evtVO }<br>

${evtVO.evtNo}

<form method="POST" action="<%=request.getContextPath() %>/event/modifyForm.do" id="spec_event">
<input type="hidden" id="evtNo" name="evtNo" value="${evtVO.evtNo }">
<input type="submit" value="수정하기"/>
</form>
</body>
</html>