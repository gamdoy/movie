<%@ page contentType= "text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style type="text/css">
table
{
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;
	width: 480px;
	text-align: left;
	border-collapse: collapse;
	border: 1px solid #69c;
}

thead tr
{
	padding: 15px 10px 10px 10px;
	font-weight: normal;
	font-size: 14px;
	color: #039;
	border: 1px solid #69c;
}
tbody
{
	background: #e8edff;
	border: 1px solid #69c;
}
td
{
	padding: 10px;
	color: #669;
	border-top: 1px dashed #fff;
	border: 1px solid #69c;
}
tbody tr:hover td
{
	color: #339;
	background: #d0dafd;
	
}

</style>
<script type="text/javascript">
$(document).ready(function(){
	var usedMileage = $("#memberMileage").val();
	var memNo=$("#memNo").val();
	
	$("#couponlistBtn").on("click", function(){
		window.open('getCouponList.do?memNo='+memNo, "post", "height=400, width=550, scrollbars=yes");
	});
	
	$(':radio[name="milUse"]').on("click", function(){
		var mcheck = $(':radio[name="milUse"]:checked').val();
		if(mcheck == "use"){
			$("#memberMileage").prop("disabled",false);	
			$("#memberMileage").prop("value","");
		}
		else if(mcheck == "unuse"){
			$("#memberMileage").prop("disabled",true);
			$("#memberMileage").prop("value","0");
		}
	});
});

function checkMileage(){
	var clientMileage = ${requestScope.member_info.memberMileage};
	var useMileage = $("#memberMileage").val();
	if(!useMileage || useMileage.trim() == ""){
		alert("값을 입력하세요.");
		return false;
	}else if(useMileage > clientMileage){
		alert("마일리지가 부족합니다.");
		return false;
	}else if(!useMileage){
		alert("값을 입력하세요.");
		return false;
	}else if(useMileage <= clientMileage){
		alert("발급되었습니다. \n잔여 마일리지 : "+(clientMileage-useMileage));
		return true;
	}
	alert("잘못된 값입니다.");
	return false;
}

</script>

<form method="post" id="f_coupon" action="<%=request.getContextPath() %>/admin/issueCouponById.do" onsubmit="return checkMileage()">
	<input type="hidden" id="memNo" name="memNo" value="${requestScope.member_info.memNo}">
	<table style="width:700px" align="center" >
		<tr align="center" height="30">
			<td colspan="2">"${requestScope.member_info.memberName}" 고객님의 현재 회원등급 입니다</td>
		</tr>
		<tr align="center" height="50">
			<td colspan="2"><h1>${requestScope.member_info.memberTypeName}</h1></td>
		</tr>
		<tr align="center" height="30">
			<td>쿠폰내역</td>
			<td>보유마일리지</td>
		</tr>
		<tr align="center" height="50">
			<td id="couponlistBtn">${fn:length(requestScope.coupon_list )}</td>
			<td>${requestScope.member_info.memberMileage}</td>
		</tr>
		<tr align="center" height="30">	
			<td colspan="2">쿠폰발급
				<select id="coupType" name="coupType">
					<option value="113100">콤보</option>
					<option value="113200">팝콘</option>
					<option value="113300">콜라</option>
				</select>
				<input type="submit" id="coupBtn" value="확인">
			</td>
		</tr>
		
		<tr align="center" height="30">
			<td>사용할 마일리지</td>
				<td>
				<input type="text" id="memberMileage" name="memberMileage"><br>
				사용 <input type="radio" name="milUse" value="use" checked="checked">
				미사용 <input type="radio" name="milUse" value="unuse">
			</td>
		</tr>
	</table>
</form>