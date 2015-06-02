<%@ page contentType= "text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<form method="post" action="<%=request.getContextPath() %>/stats/statistics_list.do"  id="statsForm">
시작일 : <input type="date" name="startDate">
종료일 : <input type="date" name="endDate">
<input type="submit"  value="조회">
</form>
</body>
</html>