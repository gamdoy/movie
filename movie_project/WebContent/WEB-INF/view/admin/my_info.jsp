<%@ page contentType= "text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
$(document).ready(function(){
	var usedMileage = $("#memberMileage").val();
	var memNo=$("#memNo").val();
	
	$("#couponlistBtn").on("click", function(){
		window.open('getCouponList.do?memNo='+memNo, "post", "height=400, width=550, scrollbars=yes");
	});
	
	$("#coupType").on("click", function() {
	      if($(this).val() == "113100"){
	         $(".memberMileage").prop("value","8000");
	      }
	      if($(this).val() == "113200"){
		         $(".memberMileage").val("5000");
		  }
	      if($(this).val() == "113300"){
		         $(".memberMileage").val("3000");
		  }
	 });
});

function checkMileage(){
	var clientMileage = ${requestScope.member_info.memberMileage};
	var useMileage = $(".memberMileage").val();
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
	<table style="width:700px">
		<tr align="center" height="30">
			<td colspan="2">"${requestScope.member_info.memberName}" 고객님의 현재 회원등급 입니다</td>
		</tr>
		<tr align="center" height="50">
			<td colspan="2">${requestScope.member_info.memberTypeName}</td>
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
					<option value="null">종류</option>
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
				<input type="text" class="memberMileage" disabled="disabled">
				<input type="hidden" class="memberMileage" name="memberMileage"><br>
			</td>
		</tr>
	</table>
</form>