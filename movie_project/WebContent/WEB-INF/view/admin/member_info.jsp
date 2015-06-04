<%@ page contentType= "text/html;charset=UTF-8"%>

<script type="text/javascript">

$(document).ready(function(){
	var usedMileage = $("#mileage").val();
	
	$("#mileage").keyup(function(){
		if(this.val() < usedMileage || this.val() <= 0)
				alert("욕심쟁이 시네요.");
	});
	
	$(':radio[name="milUse"]').on("click", function(){
		var mcheck = $(':radio[name="milUse"]:checked').val();
		if(mcheck == "use"){
			$("#mileage").prop("disabled",false);
			$("#mileage").prop("value","");
		}
		else if(mcheck == "unuse"){
			$("#mileage").prop("disabled",true);
			$("#mileage").prop("value","0");
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
			<td>보유쿠폰</td>
			<td>보유마일리지</td>
		</tr>
		<tr align="center" height="50">
			<td>${requestScope.member_info.coupon.coupNo }</td>
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