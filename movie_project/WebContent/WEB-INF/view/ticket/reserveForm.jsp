<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/script/jquery.js"></script>
<script type="text/javascript">
var checkedPeople = false;
var peopleNo = 0;
var row;
var no;
$(document).ready(function() {
	//좌석 배치
	$("#seatArea tr").each(function() {
		for (var seat = 1; seat <= ${movieRoom.mrLine}; seat++) {
			$(this).append("<td id='" + $(this).prop("id") + seat + "'>" + seat + "</td>")
		}
	});
	
	//좌석에 mouseover 이벤트
	$("#seatArea tr").on("mouseover", "td", function() {
		if(checkedPeople){
			changeBackground($(this), "mouseover");
		}
	});
	
	//좌석에 mouseout 이벤트
	$("#seatArea tr").on("mouseout", "td", function() {
		if(checkedPeople){
			changeBackground($(this), "mouseout");
		}
	});
	
	//좌석에 mouseclick 이벤트
	$("#seatArea tr").on("click", "td", function() {
		if(checkedPeople){
			changeBackground($(this), "click");
		}
	});
	
	//예약 인원 재설정 시 초기화 처리
	$(".peopleNo").on("click", function() {
		checkedPeople = true;
		$("#seatArea tr td").each(function() {
			if($(this).prop("className") != "reserved"){
				$(this).css("background-color","white");
			}
		});
		$(".peopleNo").each(function() {
			if($(this).prop("checked")){
				peopleNo = $(this).val();
			}
		});
	});
	
	//예약 처리
	$("#reserve").on("click", function() {
		if(!row){
			alert("예매할 좌석을 선택해 주세요.");
			return;
		} else if(!$("#ticPaytype").val()){
			alert("결제방식을 선택해 주세요.");
			return;
		}
		var rowNo = row.substr(3);
		$.ajax({
			type:"POST",
			url:"<%= request.getContextPath()%>/theater/reserve.do",
			data:{
				ticTotalcustomer:peopleNo,
				mrLine:rowNo,
				mrSeat:no,
				ticDate:"${movieRoom.schDate}",
				mrNo:"${movieRoom.mrNo}",
				schNo:"${movieRoom.schNo}",
				ticPaytype:$("#ticPaytype").val()
			},
			dataType:"JSON",
			success:function(ret){
				if(ret.reserved=="true"){
					alert("이미 예매된 자리입니다.");
					location.reload();
					return false;
				}
				location.href="<%=request.getContextPath() %>" + ret.url + "?ticNo="+ret.ticNo;
			},
			error:errorCallback
		});
	});
	
	//초기화 처리
	$("#reset").on("click", function() {
		$("#seatArea tr td").each(function() {
			if($(this).prop("className") == "reserve"){
				$(this).css("background-color","white");
				$(this).prop("className", "");
			} else if($(this).prop("className") != "reserved"){
				$(this).css("background-color","white");
			} 
		});
		$(".peopleNo").each(function() {
			$(this).prop("checked", false);
		});
	});
	
	//결제방식 선택처리
	$(".ticPaytype").on("click", function() {
		$("#ticPaytype").val($(this).val());
	})
});

//좌석에 mouseover, mouseout, click callback 처리 함수
function changeBackground(_this, event){
	row = _this.prop("id").substr(0,4);//선택된 열을 뽑는다.
	no = Number(_this.prop("id").substr(4));//선택된 좌석을 뽑는다.
	var maxNo = Number(no) + Number(peopleNo);//선택된 좌석을 기준으로 예약 인원 값 처리
	if(maxNo > ${movieRoom.mrSeat}){//좌석이 마지막 자리를 넘어갈경우 예약 인원에 맞게 진행되도록 처리
		no -= (maxNo - ${movieRoom.mrSeat} -1);
	}
	for (var _no = no; _no < maxNo; _no++) {
		if($("#" + row + _no).prop("className") == "reserved"){
			return false;
		}
	}
	if(event == "mouseover"){
		for (var _no = no; _no < maxNo; _no++) {
			$("#" + row + _no).css("background-color","gray");
		}
	} else if(event == "mouseout"){
		for (var _no = no; _no < maxNo; _no++) {
			$("#" + row + _no).css("background-color","white");
		}
	} else if(event == "click"){
		checkedPeople = false;
		for (var _no = no; _no < maxNo; _no++) {
			$("#" + row + _no).prop("className", "reserve");
		}
	}
}
function errorCallback(xhr, status, err){
	alert(status+", "+xhr.readyState+" "+err);
}
function setReservedSeat(){
	var jArr = ${reservedSeatList };
	$(jArr).each(function() {
		var seatsArr = this.split("|");
		for(var idx=1; idx < seatsArr.length-1; idx++){
			var seatRow = seatsArr[idx].split("-")[0]; 
			var seatNo = seatsArr[idx].split("-")[1];
			var id = "#row" + seatRow + seatNo;
			$(id).css("background-color", "gray");
			$(id).addClass("reserved");
		}
	});
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
					<c:forEach	 begin="1" end="${movieRoom.mrLine }" var="idx">
						<tr id="row${idx }"><td>${idx }열</td></tr>
					</c:forEach>
				</tbody>
			</table>
		</span>
		<span>
			<c:forEach	 items="${payTypeList }" var="payType" varStatus="idx">
				<c:choose>
					<c:when test="${idx.index  == 0}">
						${payType.cmnCodeKor }
						<input type="hidden" id="ticPaytype">
					</c:when>
					<c:otherwise>
						<label><input type="radio" name="ticPaytype" class="ticPaytype" value="${payType.cmnNo }">${payType.cmnCodeKor }</label>
					</c:otherwise>
				</c:choose>
			</c:forEach><br>
			<input type="button" id="reserve" value="예약">
			<input type="button" id="reset" value="초기화">
		</span>
	</div>