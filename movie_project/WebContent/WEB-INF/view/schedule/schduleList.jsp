<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/date_picker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/jquery.js"></script>
<script type="text/javascript">
var submitFlag = false;
$(document).ready(function() {
	$.each($("#searchType").children(), function() {
		if($(this).val() == "${searchVO.searchType }"){
			$(this).prop("selected", "selected");
		}
	});
	$("#searchType").on("change", function() {
		if($("#searchType").val() == "sch_date"){
			datePicker(event,'searchKeyword');
		}
	});
	$("#searchKeyword").on("keyup", function() {
		if($("#searchType").val() == "sch_date"){
			alert("상영일은 달력을 통해서만 입력 가능합니다.");
			$("#searchKeyword").val("");
			datePicker(event,'searchKeyword');
		}
	});
	$("#schDate").on("change", function() {
		alert($("#schDate").val());
	});
	$("#addSchedule").on("click", function() {
		$("#schDate").val($("#date").val());
		var schduleCount = 0;
		if($("#movieSel").val()=="default"){
			alert("영화를 선택하세요.");
			return false;
		} else if(!$("#date").val()){
			alert("상영일을 선택하세요.");
			return false;
		}
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/theater/getScheduleCount.do",
			data:{
				mrNo:"${mrNo}",
				movNo:$("#movieSel").val(),
				schDate:$("#schDate").val()
					},
			dataType:"JSON",
			success: function(ret) {
				if(ret == "0"){
					$.ajax({
						type:"POST",
						url:"<%=request.getContextPath()%>/theater/setSchedule.do",
						data:{
							mrNo:"${mrNo}",
							movNo:$("#movieSel").val(),
							schDate:$("#schDate").val(),
							theaNo:$("#theaNo").val()
								},
						dataType:"JSON",
						success: function(ret) {
							if(ret == "1"){
								alert("상영 스케줄을 등록하였습니다.");
								location.reload();
							} else {
								alert("상영 스케줄 등록에 실패하였습니다.");
							}
						},
						error:function(){
							alert("상영 스케줄 등록에 실패하였습니다.");
						}
					});
				} else {
					alert("상영 스케줄이 존제합니다.")
				}
			},
			error:function(){
				alert("상영 스케줄 등록에 실패하였습니다.");
			}
		});
	});
});
function checkVal(){
	if(submitFlag && "${searchVO.searchKeyword}" != $("#searchKeyword").val()) {
		$("#searchKeyword").val("${searchVO.searchKeyword}");
	}
}

function goSubmit(pageNo){
	$("#page").val(pageNo);
	$("#frm").prop("action", "<%=request.getContextPath() %>/theater/setScheduleForm.do");
	$("#frm").submit();
}

function goPage(pageNo){
	$("#page").val(pageNo);
	submitFlag = true;
	$("#frm").prop("action", "<%=request.getContextPath() %>/theater/setScheduleForm.do");
	$("#frm").submit();
}
</script>
<form id="frm" action="<%=request.getContextPath() %>/theater/setSchedule.do" method="post" onsubmit="return checkVal();">
	<input type="hidden" name="mrNo" id="mrNo" value="${mrNo }">
	<input type="hidden" name="theaNo" id="theaNo" value="${theaNo }">
	<input type="hidden" name="movNo" id="movNo" value="${movNo }">
	<input type="hidden" name="schDate" id="schDate">
	<input type="hidden" name="page" id="page">
	<table>
		<thead>
			<tr>
				<td>영화</td>
				<td>상영일</td>
				<td>스케줄 추가</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<select id="movieSel">
							<option value="default">영화 제목</option>
			  				<c:forEach items="${ movieList}" var="movie">
			  					<c:choose>
			  						<c:when test="false">
					  					<option value="${movie.movieNo }" selected="selected">${movie.title }</option>
			  						</c:when>
			  						<c:otherwise>
			  							<option value="${movie.movieNo }">${movie.title }</option>
			  						</c:otherwise>
			  					</c:choose>
			  				</c:forEach>
			  			</select>
				</td>
				<td>
					<input type="text" id="date" name="date" onClick="datePicker(event,'date')" readonly="readonly">
				</td>
				<td>
					<input type="button" value="추가" id="addSchedule">
				</td>
			</tr>
		</tbody>
	</table>
	<table>
	  <thead>
	  	<tr>
	  		<td>상영관 이름</td>
	  		<td>영화</td>
	  		<td>상영 시간</td>
	  	</tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${scheduleList }" var="schedule">
		  	<tr>
		  		<td>
		  			${schedule.mrName }
		  		</td>
		  		<td>${schedule.movTitle }</td>
		  		<td>${schedule.schDate }</td>
		  	</tr>
	  	</c:forEach>
	  </tbody>
	  <tfoot>
	  	<tr>
	  		<td colspan="3" >
	  			<span>
		  			<c:choose>
						<c:when test="${pagingBean.previousPageGroup }">
							<label onclick="goPage(${pagingBean.startPageOfPageGroup-1})">◀</label>
						</c:when>
						<c:otherwise>
							<label>◀</label>
						</c:otherwise>
					</c:choose>	
					<!-- 페이지 번호 -->
					<c:forEach begin="${pagingBean.startPageOfPageGroup }" end="${pagingBean.endPageOfPageGroup}" var="pageNum">
						<c:choose>
							<c:when test="${pageNum == pagingBean.currentPage }">
								<b>[${pageNum}]</b>
							</c:when>
							<c:otherwise>
								<label onclick="goPage(${pageNum})">
									${pageNum}
								</label>
							</c:otherwise>
						</c:choose>
						&nbsp;&nbsp;
					</c:forEach>
					<!-- 다음 페이지 그룹 -->
					<c:choose>
						<c:when test="${pagingBean.nextPageGroup }">
							<label onclick="goPage(${pagingBean.endPageOfPageGroup+1})">▶</label>
						</c:when>
						<c:otherwise>
							<label>▶</label>
						</c:otherwise>
					</c:choose>
				</span>
				<span style="float: right;">
		  			<select id="searchType" name="searchType">
		  				<option value="mr_name">상영관 이름</option>
		  				<option value="mov_title">영화</option>
		  				<option value="sch_date">상영일</option>
		  			</select>
		  			<input type="text" name="searchKeyword" id="searchKeyword" value="${searchVO.searchKeyword }">
		  			<input type="button" value="검색" onclick="goSubmit(1)">
	  			</span>
	  		</td>
	  	</tr>
	  </tfoot>
	</table>
</form>