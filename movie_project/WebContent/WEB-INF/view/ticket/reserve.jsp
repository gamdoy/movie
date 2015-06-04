<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">

function setReservedSeat(){
	alert(1);
}
</script>
</head>
<body onload="setReservedSeat()">
	<div>
		<div>
			<label><input type="radio" name="peopleNo" class="peopleNo" value="1">1</label>
			<label><input type="radio" name="peopleNo" class="peopleNo" value="2">2</label>
			<label><input type="radio" name="peopleNo" class="peopleNo" value="3">3</label>
			<label><input type="radio" name="peopleNo" class="peopleNo" value="4">4</label>
		</div>
		<span	id="seatArea">
			<table id="seatTable">
				<tbody>
					<c:forEach	 items="${rows }" var="row">
						<tr id="row${row }"><td>${row }</td></tr>
					</c:forEach>
				</tbody>
			</table>
		</span>
		<span>
			<input type="button" id="reserve" value="예약">
			<input type="button" id="reset" value="초기화">
		</span>
	</div>
</body>
</html>