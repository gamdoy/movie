<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/jquery.js"></script>
<script type="text/javascript">
function modifyMovieroomInfo(mrNo){
	if($("#screenSel"+mrNo).val() == "109000"){
		alert("상영타입을 선택해 주세요.");
		return;
	}
	var screenType = $("#screenSel"+mrNo).val();
	var lineNo = $("#lineSel"+mrNo).val();
	var seatNo = $("#seatSel"+mrNo).val();
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/theater/modifyMovieroom.do",
		data:{
					theaNo:$("#theaNo").val(),
					mrNo:mrNo,
					mrScreentype:screenType,
					mrLine:lineNo,
					mrSeat:seatNo
				},
		dataType:"JSON",
		success: function(ret) {
			if(ret == "1"){
				alert("수정에 성공하였습니다.");
			} else {
				alert("수정에 실패하였습니다.");
			}
		}	
	});
}
function setSchedule(mrNo) {
	$("#mrNo").val(mrNo);
	$("#frm").submit();
}
</script>
<form method="post" id="frm" action="<%=request.getContextPath() %>/theater/setScheduleForm.do">
	<input type="hidden" name="theaNo" id="theaNo" value="${theaNo }">
	<input type="hidden" name="mrNo" id="mrNo">
</form>
<table>
  <thead>
  	<tr>
  		<td>번호</td>
  		<td>상영관 이름</td>
  		<td>상영타입</td>
  		<td>열수</td>
  		<td>좌석수</td>
  		<td>수정</td>
  		<td>상영스케줄 설정</td>
  	</tr>
  </thead>
  <tbody>
	<c:forEach items="${movieroomList }" var="movieroom" varStatus="idx">
	  	<tr>
	  		<td><input type="hidden" name="mrNo" id="mrNo" value="${movieroom.mrNo }">${idx.index+1 }</td>
	  		<td>${movieroom.mrName }</td>
	  		<td>
	  			<input type="hidden" id="screen${movieroom.mrNo }" value="${movieroom.mrScreentype }">
	  			<select id="screenSel${movieroom.mrNo }">
	  				<c:forEach items="${codeList }" var="code">
	  					<c:choose>
	  						<c:when test="${code.cmnNo ==  movieroom.mrScreentype }">
			  					<option value="${code.cmnNo }" selected="selected">${code.cmnCodeKor }</option>
	  						</c:when>
	  						<c:otherwise>
			  					<option value="${code.cmnNo }">${code.cmnCodeKor }</option>
	  						</c:otherwise>
	  					</c:choose>
	  				</c:forEach>
	  			</select>
	  		</td>
	  		<td>
	  			<select id="lineSel${movieroom.mrNo }">
	  				<c:forEach begin="1" end="15" varStatus="line">
	  					<c:choose>
	  						<c:when test="${line.index ==  movieroom.mrLine }">
			  					<option value="${line.index }" selected="selected">${line.index }</option>
	  						</c:when>
	  						<c:otherwise>
			  					<option value="${line.index }">${line.index }</option>
	  						</c:otherwise>
	  					</c:choose>
	  				</c:forEach>
	  			</select>
	  		</td>
	  		<td>
	  			<select id="seatSel${movieroom.mrNo }">
	  				<c:forEach begin="1" end="15" varStatus="seat">
	  					<c:choose>
	  						<c:when test="${seat.index ==  movieroom.mrSeat }">
			  					<option value="${seat.index }" selected="selected">${seat.index }</option>
	  						</c:when>
	  						<c:otherwise>
			  					<option value="${seat.index }">${seat.index }</option>
	  						</c:otherwise>
	  					</c:choose>
	  				</c:forEach>
	  			</select>
	  		</td>
	  		<td><input type="button" value="수정" onclick="modifyMovieroomInfo(${movieroom.mrNo})"></td>
	  		<td><input type="button" value="상영스케줄 설정" onclick="setSchedule(${movieroom.mrNo})"></td>
	  	</tr>
	</c:forEach>
  </tbody>
  <tfoot>
  </tfoot>
</table>