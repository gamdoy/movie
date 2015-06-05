<%@ page contentType= "text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
$(document).ready(function(){
	var usedMileage = $("#memberMileage").val();
	var memNo=$("#memNo").val();
	$("#couponlistBtn").on("click", function(){
		window.open('getCouponList.do?memNo='+memNo, "post", "height=400, width=700");
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

</script>

<form method="post" id="f_coupon" action="<%=request.getContextPath() %>/admin/issueCouponById.do">
	<input type="hidden" id="memNo" name="memNo" value="${requestScope.member_info.memNo}">
	<table style="width:700px">
		<tr align="center" height="30">
			<td colspan="2">"${requestScope.member_info.memberName}" 고객님의 현재 회원등급 입니다</td>
		</tr>
		<tr align="center" height="50">
			<td colspan="2">${requestScope.member_info.memberType}</td>
		</tr>
		<tr align="center" height="30">
			<td id="couponlistBtn">보유쿠폰</td>
			<td>보유마일리지</td>
		</tr>
		<tr align="center" height="50">
			<td>${fn:length(requestScope.coupon_list )}</td>
			<td>${requestScope.member_info.memberMileage}</td>
		</tr>
		<tr align="center" height="30">	
			<td colspan="2">쿠폰발급
				<select id="coupType" name="coupType">
					<option value="combo">콤보</option>
					<option value="popcorn">팝콘</option>
					<option value="cola">콜라</option>
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