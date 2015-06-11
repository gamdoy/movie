<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.theaArea1 {background-color: red; height: 800px; width: 300px; float: left;} 
.theaArea2{background-color: red; height: 800px; width: 600px; float: left;}
.theaArea3{background-color: red; height: 800px; width: 300px; float: left;}
.posterArea {background-color: blue; height: 500px; width: 600px;float: left;} 
.dateArea {background-color: gray; height: 300px; width: 300px; float: left;} 
.movieArea {background-color: green; height: 300px; width: 300px; float: left;}
.scheduleArea {background-color: white; height: 700px; width: 300px;}
.submitArea {background-color: white; height: 100px; width: 300px; display: none;}
.screenTime {overflow : auto; height: 30px;} 
.area2 {height:800px; width:1200px; display: none; float: left;}
</style>
<script type="text/javascript">
	var no;
	var date;
	var time;
	var sno;
	$(document).ready(function() {
		$("#showSeatArea").on("click", function() {
			$("#theaNo").val(no);
			$("#schNo").val(sno);
			$("#schDate").val(date + " " + time);
			$("#theaFrm").submit();
		})
	});
	
	function getSchedule(theaNo) {
		$(".submitArea").hide();
		no = theaNo;
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/theater/getScheduleList.do",
			data:{
						theaNo:theaNo
					},
			dataType:"JSON",
			beforeSend:function(){
				$(".dateArea").empty();
				$(".movieArea").empty();
				$(".posterArea").empty();
			},
			success: function(ret) {
				$.each(ret, function() {
					$(".dateArea").append($("<div class='schDate' onclick=\"getMovie('" +  this.schDate + "', '" + theaNo + "');\" id='" + this.schDate + "'>").append(this.schDate));
				})
			}	
		});
	}
	
	function getMovie(schDate, theaNo) {
		$(".submitArea").hide();
		no = theaNo;
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/theater/getMovieList.do",
			data:{
						theaNo:theaNo,
						schDate:schDate
					},
			dataType:"JSON",
			beforeSend:function(){
				$(".movieArea").empty();
				$(".posterArea").empty();
			},
			success: function(ret) {
				$.each(ret, function() {
					$(".movieArea").append($("<div class='movieTitle' onclick=\"showSchedule('" +  this.schDate + "', '" + this.theaNo + "', '" + this.movNo + "');\" id='" + this.schDate + "'>").append(this.movTitle));
				});
			}	
		});
	}
	
	function showSchedule(schDate, theaNo, movNo) {
		$(".submitArea").hide();
		date = schDate;
		$.ajax({
			type:"POST",
			url:"<%=request.getContextPath()%>/theater/getScreenTimeList.do",
			data:{
						theaNo:theaNo,
						schDate:schDate,
						movNo:movNo
					},
			dataType:"JSON",
			beforeSend:function(){
				$(".scheduleArea").empty();
				$(".posterArea").empty();
			},	
			success:function(ret){
				$.each(ret, function() {
					if(this.emptySeat == 0 ){
						$(".scheduleArea").append($("<div class='screenTime' onclick=\"hideSubmit();\" id='" + this.schDate + "'>").append(this.schDate + "(" + this.emptySeat + ")"));
					} else {
						$(".scheduleArea").append($("<div class='screenTime' onclick=\"setTime('" +  this.schDate + "', '" + this.schNo + "');\" id='" + this.schDate + "'>").append(this.schDate + "(" + this.emptySeat + ")"));
					}
					$(".posterArea").html($("<img src='<%= request.getContextPath()%>/" + this.movPoster + "'>"));
				})
			}	
		});
	}
	
	function setTime(schDate, schNo){
		time = schDate;
		sno = schNo;
		$(".submitArea").show();
	}
	
	function hideSubmit(){
		$(".submitArea").hide();
	}
</script>
<form method="post" id="theaFrm" action="<%= request.getContextPath()%>\theater\reserveForm.do">
	<input type="hidden" name="theaNo" id="theaNo">
	<input type="hidden" name="schDate" id="schDate">
	<input type="hidden" name="schNo" id="schNo">
</form>
<div class="area1">
	<div class="theaArea1"><!-- 극장 -->
		<c:forEach items="${theaList }" var="theater">
			<div id="thea${theater.theaNo }" onclick="getSchedule(${theater.theaNo});">
				${theater.theaLocation }
			</div>
		</c:forEach>
	</div>
	<div class="theaArea2">
		<div class="posterArea">포스터</div><!-- 포스터 -->
		<div class="dateArea">상영일</div><!-- 상영일 -->
		<div class="movieArea">영화</div><!-- 영화 -->
	</div>
	<div class="theaArea3">
		<div class="scheduleArea">시간표</div><!-- 시간표 -->
		<div class="submitArea"><input type="button" id=showSeatArea value="예약"></div><!-- 예약버튼 -->
	</div>
</div>