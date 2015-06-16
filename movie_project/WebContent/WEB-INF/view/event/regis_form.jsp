<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/date_picker.js"></script>

<script type="text/javascript">
	
var idDup = false;//ID 중복여부 체크 - true : 사용할 수 있다(중복아님), false : 사용할 수 없다(중복아님) 
$(document).ready(function(){

	$("#registerForm").on("submit", function(){
		
		if(!$("#evtTitle").val()){
			alert("이벤트 분류명을 입력하세요");
			$("#evtName").focus();
			return false;
		}
		
		if(!$("#evtStartDate").val()){
			alert("시작일을 입력하세요");
			$("#evtStartDate").focus();
			return false;
		}
		
		if(!$("#evtEndDate").val()){
			alert("종료일을 입력하세요");
			$("#evtEndDate").focus();
			return false;
		}
		
	
		if(!$("#evtContent").val()){
			alert("이벤트제목을 입력하세요");
			$("#evtTitle").focus();
			return false;
		}
		
		
		
		
		if(!$("#evtStartDate").val() "#evtEndDate").val()){
			alert("이벤트제목을 입력하세요");
			$("#evtTitle").focus();
			return false;
		}
	
		var startDate=$("#evtStartDate").val();
		var endDate=$("#evtEndDate").val();
		
		var arr1=startDate.split('-');
		var arr2=endDate.split('-');
		
		var evtStartDate=new Date(arr1[0],arr1[1],arr1[2]);
		var evtEndDate=new Date(arr2[0],arr2[1],arr2[2]);
		
		if(evtStartDate<evtEndDate){
			$("#endDateLabel").prop("value","이벤트 종료일은 시작일 이후여야합니다.");
			alert("이벤트 종료일은 시작일 이후여야합니다.");
			return false;
		}
	
		
	});
	
});

function day_check(value){
	var arr=value.split('-');
	
	var startDate=new Date(arr[0],arr[1],arr[2]);
	var endDate=new Date(arr[0],arr[1],arr[2]);
	
	if(startDate<endDate){
		alert("이벤트 종료일은 시작일 이후여야합니다.");
		$("#evtEndDate").prop("value","");
		return false;
	}
}

</script>

<h2>이벤트 추가</h2>

<form method="post" action="<%=request.getContextPath() %>/event/addEvent.do"  id="registerForm" enctype="multipart/form-data">
	<table style="width:600px">
		<tr>
			<td width="100">이벤트 이름</td>
			<td>
				<input type="text" name="evtTitle" id='evtTitle'> 
				
			</td>
		</tr>
		<tr>
			<td>시작일</td>
			<td>
				<input type="text" id="evtStartDate" name="evtStartDate" onClick="datePicker(event,'evtStartDate')" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td>종료일</td>
			<td>
				<input type="text" id="evtEndDate" name="evtEndDate" onClick="datePicker(event,'evtEndDate')" onclick="day_check(value)" readonly="readonly">
				<label id="endDateLabel" name="endDateLabel" ></label>
			</td>
		</tr>
		<tr>
			<td>이벤트 내용</td>
			<td>
				<input type="text" id="evtContent" name="evtContent"> 
			</td>
		</tr>
		<tr>
			<td>이벤트이미지</td>
			<td>
				<input type="file" id="evtImageFile" name="evtImageFile">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
