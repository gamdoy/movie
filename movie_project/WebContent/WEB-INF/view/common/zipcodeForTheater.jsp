<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%= request.getContextPath()%>/script/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var address = "";
	$("#searchBtn").on("click", function() {
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/commonCode/findZipcode.do",
			data:{
						keyword:$("#location").val()
					},
			dataType:"JSON",
			success:function(xhr){
				address = "";
				$("#tb").empty();
				$(xhr).each(function() {
					$("tbody").append($("<tr>")).append("<td id='" + this.zipNo + "'></td><td></td>");
					$("#"+this.zipNo).html(this.zipZipcode);
					
					address = this.zipAddress;
					var tdStr = "<label onclick=\"modifyZipcod(" + this.zipNo + ",'" + this.zipZipcode + "', '" + address + "')\">" + address + "</label>";
					$("#"+this.zipNo).next().html(tdStr);
				});
			}
		});
	});
});
function modifyZipcod(zipNo, zipcode, address) {
	var id = "#" + ${theaNo};
	opener.$(id).children().next().val(zipNo);
	opener.$(id).children().next().next().val(zipcode);
	opener.$(id).next().next().next().children().val(address);
	self.close();
}
</script>
</head>
<body>
검색 : <input type="text" id="location"><input type="button" id="searchBtn" value="검색"><br>
<table>
	<thead>
		<tr>
			<td>우편번호</td>
			<td>주소</td>
		</tr>
	</thead>
	<tbody id="tb">
		
	</tbody>
</table>
</body>
</html>