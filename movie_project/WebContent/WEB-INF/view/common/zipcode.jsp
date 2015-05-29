<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%= request.getContextPath()%>/script/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#searchBtn").on("click", function() {
		alert($("#location").val());
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/commoncode/findZipcode.do",
			data:{
						keyword:$("#location").val()
					},
			dataType:"JSON"
			
		});
	});
});
</script>
</head>
<body>
검색 : <input type="text" id="location"><input type="button" id="searchBtn" value="검색"><br>
<table>
	<thead>
		<tr>
			<td>주소</td>
			<td>우편번호</td>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
</body>
</html>