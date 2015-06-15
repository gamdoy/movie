<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	[id^=submit] {display: none;}
	[id^=modifyZipcode] {display: none;}
</style>
<script type="text/javascript">
$(document).ready(function() {
});
var theaId;
var modifiable = true;
var addable = true;

//극장정보수정 폼으로 변경
function modifyInfo(theaNo) {
	if(!modifiable){
		alert("이전 극장정보를 먼저 수정해 주세요.");
		return false;
	}
	modifiable = false;
	toggleBtn(theaNo);
	theaId = "#" + theaNo;
	var theaLocation = $(theaId).next().html();
	var theaPhoneNo = $(theaId).next().next().html();
	var theaAddress1 = $(theaId).next().next().next().html();
	var theaAddress2 = $(theaId).next().next().next().next().html();
	var phoneNo1 = theaPhoneNo.split("-")[0];
	var phoneNo2 = theaPhoneNo.split("-")[1];
	var phoneNo3 = theaPhoneNo.split("-")[2];
	var zipNo = $(theaId).children().next().val();
	var zipZipcode = $(theaId).children().next().next().val();
	var theaStatus = $(theaId).children().next().next().next().val();
	var statusSel = $("<select id='theaStstus'>");
	var phoneSel = $("<select id='phoneNo1'>");

	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/commonCode/phoneCode.do",
		dataType:"JSON",
		success: function(ret) {
			$.each($(ret) ,function() {
				if(this.cmnCodeKor == phoneNo1) {
					phoneSel.append("<option value=" + this.cmnCodeKor + " selected='selected' >" + this.cmnCodeKor + "</option>");
				} else {
					phoneSel.append("<option value=" + this.cmnCodeKor + ">" + this.cmnCodeKor + "</option>");
				}
			});
		$(theaId).next().next().html($(theaId).next().next().html() 
				+ " - <input type='text' id='phoneNo2' size='3' value='" + phoneNo2 
				+ "'> -  <input type='text' id='phoneNo3' size='3' value='" + phoneNo3 + "'>");
		}
	});
	
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/commonCode/getCode.do",
		data:{keyword:"111"},
		dataType:"JSON",
		success: function(ret) {
			$.each($(ret) ,function() {
				if(this.cmnNo == theaStatus) {
					statusSel.append("<option value=" + this.cmnNo + " selected='selected' >" + this.cmnCodeKor + "</option>");
				} else {
					statusSel.append("<option value=" + this.cmnNo + ">" + this.cmnCodeKor + "</option>");
				}
			});
		$(theaId).next().next().next().next().next().html(statusSel);
		}
	});
	
	
	
	$(theaId).next().html("<input type='text'  size='8' id='modifyLocation' value='" + theaLocation + "'>");
	$(theaId).next().next().empty().append(phoneSel);
	$(theaId).next().next().next().html("<input type='text' id='modifyAddress1' value='" + theaAddress1 + "' readonly='readonly' onclick=\"modifyZipcode('" + theaNo + "');\">");
	$(theaId).next().next().next().next().html("<input type='text' id='modifyAddress2' value='" + theaAddress2 + "'>");
}



//극장정보 수정하기
function submitInfo(theaNo) {
	modifiable = true;
	theaId = "#" + theaNo;
	var theaLocation = $(theaId).next().children().val();
	var theaAddress1 = $(theaId).next().next().next().children().val();
	var theaAddress2 = $(theaId).next().next().next().next().children().val();
	var phoneNo1 = $("#phoneNo1").val();
	var phoneNo2 = $("#phoneNo2").val();
	var phoneNo3 = $("#phoneNo3").val();
	var zipNo = $(theaId).children().next().val();
	var zipZipcode = $(theaId).children().next().next().val();
	var theaStatus = $("#theaStstus").val();
	if(theaStatus=="111000"){
		alert("영업상태를 체크하세요.");
		return false;
	}
	toggleBtn(theaNo);
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/theater/modifyTheater.do",
		data:{
					theaNo:theaNo,
					theaLocation:theaLocation,
					theaAddress1:theaAddress1,
					theaAddress2:theaAddress2,
					theaPhoneNo:phoneNo1+"-"+phoneNo2+"-"+phoneNo3,
					zipNo:zipNo,
					zipZipcode:zipZipcode,
					theaStatus:theaStatus
				},
		dataType:"JSON",
		success: function(ret) {
			location.reload();
		}	
	});
}

//상영관 정보 수정
function modifyMovieroom(theaNo) {
	location.href="<%=request.getContextPath() %>/theater/modifyMovieroomForm.do?theaNo=" + theaNo;
}

//극장추가DIV 출력
function addTheaterFrom() {
	if(!addable){
		alert("이전 극장정보를 먼저 추가해 주세요.");
		return false;
	}
	addable = false;
	$("#tbody").append($("<tr>")
			.append("<td id='999999'>신규"
					+ "<input type='hidden' id='theaNo' name='theaNo'>"
					+ "<input type='hidden' id='zipNo' name='zipNo'>"
					+ "<input type='hidden' id='zipZipcode' name='zipZipcode'>" 
					+ "</td>")
			.append("<td><input type=text id='theaLocation' name='theaLocation'></td>")
			.append("<td><select id=phoneNo1><option>02</option><option>031</option><option>032</option><option>033</option></select>"
					+"<input type=text id='phoneNo2' name='phoneNo1'>"
					+"<input type=text id='phoneNo3' name='phoneNo2'></td>")
			.append("<td><input type=text id='theaAddress1' name='theaAddress1' readonly='readonly'></td>")
			.append("<td><input type=text id='theaAddress2' name='theaAddress2'></td>")
			.append("<td>비영업</td>")
			.append("<td><span><input  type='button' onclick='addTheater();' value='저장'>"
					+ "<input  type='button' onclick=\"modifyZipcode('999999')\";' value='우편번호 검색'></span></td>")
	);
}
function addTheater(){
	$.ajax({
		type:"POST",
		url:"<%=request.getContextPath()%>/theater/addTheater.do",
		data:{
					theaLocation:$("#theaLocation").val(),
					theaAddress1:$("#theaAddress1").val(),
					theaAddress2:$("#theaAddress2").val(),
					theaPhoneNo:$("#phoneNo1").val()+"-"+$("#phoneNo2").val()+"-"+$("#phoneNo3").val(),
					zipNo:$("#zipNo").val(),
					zipZipcode:$("#zipZipcode").val(),
				},
		dataType:"JSON",
		success: function(ret) {
			location.reload();
		}	
	});
}
//우편번호 팝업창
function modifyZipcode(theaNo) {
	window.open("<%= request.getContextPath()%>/commonCode/getZipCodeForTheater.do?theaNo=" + theaNo, "zipcode", "height=500, width=700, menubar=no, toolbar=no, location=no, status=no, resizable=no");
}

//버튼 토글
function toggleBtn(theaNo) {
	$("#modify" + theaNo).toggle();
	$("#toggle" + theaNo).toggle();
	$("#submit" + theaNo).toggle();
	$("#modifyZipcode" + theaNo).toggle();
}
</script>
<input type="button" value="극장추가" onclick="addTheaterFrom()">
<p>
<div id="TheaterInfoLayer">
<table>
	<thead id="thead">
		<tr>
			<td>번호</td>
			<td>지점명</td>
			<td>전화번호</td>
			<td>주소1</td>
			<td>주소2</td>
			<td>영업여부</td>
			<td>극장정보수정</td>
			<td>상영관수정</td>
		</tr>
	</thead>
	<tbody id="tbody">
		<c:forEach items="${theaterList }" var="theater" varStatus="status">
			<tr>
				<td id="${theater.theaNo}">
					<input type="hidden" value="${theater.theaNo}">
					<input type="hidden" value="${theater.zipNo}">
					<input type="hidden" value="${theater.zipZipcode}"> 
					<input type="hidden" value="${theater.theaStatus}"> 
					${status.index +1 }
				</td>
				<td>${theater.theaLocation }</td>
				<td>${theater.theaPhoneNo }</td>
				<td>${theater.theaAddress1 }</td>
				<td>${theater.theaAddress2 }</td>
				<td>
					<c:forEach items="${statusList }" var="status">
						<c:if test="${status.cmnNo == theater.theaStatus }">
							${status.cmnCodeKor }
						</c:if>
					</c:forEach>
				</td>
				<td>
					<span id="modify${theater.theaNo}"><input  type="button" onclick="modifyInfo('${theater.theaNo}');" value="극장정보수정"></span>
					<span id="submit${theater.theaNo}"><input  type="button" onclick="submitInfo('${theater.theaNo}');" value="저장"></span>
				</td>
				<td>
					<span id="modifyMovieroom${theater.theaNo}"><input type="button" onclick="modifyMovieroom(${theater.theaNo})" value="상영관 수정"></span>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>