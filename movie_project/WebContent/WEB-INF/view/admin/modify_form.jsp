<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/date_picker.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	if("${message}"=="true"){
		alert("수정되었습니다");
		window.location="<%= request.getContextPath()%>/main.do";
	}
	var phone1 = "${requestScope.member_info.memberPhone}".split("-")[0];
	var phone2 = "${requestScope.member_info.memberPhone}".split("-")[1];
	var phone3 = "${requestScope.member_info.memberPhone}".split("-")[2];
	$("#tel2").val(phone2);
	$("#tel3").val(phone3);

	var passwordType = /[a-z0-9A-Z]/;
	$("#memPassword").on("keyup", function(){
		var password = this.value;
		if(password.length<8){
			$("#passwrodMessageLayer").text("비밀번호는 8자이상으로 입력해주세요.");
			$("#passwrodMessageLayer").prop("class","errorMessage");
			return false;
		}else if(!passwordType.test(password)){	
			$("#passwrodMessageLayer").text("비밀번호는 영문 숫자조합으로 입력해주세요.");
			$("#passwrodMessageLayer").prop("class","errorMessage");
		}else{	
			$("#passwrodMessageLayer").text("사용할수 있는 비밀번호입니다.");
			$("#passwrodMessageLayer").prop("class","normalMessage");
		}
		$("#password2").on("keyup", function(){
			var password2 = this.value;
			if(password==password2){
				$("#passwrodMessageLayer2").text("비밀번호가 일치합니다.");
				$("#passwrodMessageLayer2").prop("class","normalMessage");
			}else{
				$("#passwrodMessageLayer2").text("비밀번호가 일치하지 않습니다.");
				$("#passwrodMessageLayer2").prop("class","errorMessage");

			}
		})	
	});
	
	var emailType = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/; 
	$("#memberEmail").on("change", function(){
		var email = this.value;
		if(!emailType.test(email)){
			$("#emailMessageLayer").text("이메일형식에 맞게 입력해주세요.");
			$("#emailMessageLayer").prop("class","errorMessage");
		}else{
			$("#emailMessageLayer").text("사용할수 있는 이메일주소입니다.");
			$("#emailMessageLayer").prop("class","normalMessage");
		}
	})
	
	$("#zipcode").on("click", function(){
		alert("우편번호검색을 눌러주세요.");
	})
	$("#address2").on("click", function(){
		alert("우편번호검색을 눌러주세요.");
	})
	$("#address").on("click",function() {
	window.open("<%= request.getContextPath()%>/member/zipcodeForMember.do", "zipcode", "height=500, width=700, menubar=no, toolbar=no, location=no, status=no, resizable=no");
	})
	$("#memAddressDetail").on("click", function(){
		if(!$("#address2").val()){
			alert("우편번호검색을 먼저 눌러주세요.");
		}
	})
});
function setSubmit(){
	if(!$("#memPassword").val()){
		alert("비밀번호를 입력하세요.");
		return false;
		
	}else if(!($("#memPassword").val()==$(password2).val())){
		alert("비밀번호를 일치하게 입력하세요.");
		return false;
			
	}else if(!$("#memberName").val()){
		alert("이름을 입력하세요.");
		return false;
		
	}else if(!$("#memberBirthdate").val()){
	alert("생년월일을 입력하세요.");
	return false;
	
	}else if(!$("#memberEmail").val()){
		alert("이메일을 입력하세요.");
		return false;
		
	}else if(!$("#memAddressDetail").val()){
		alert("주소를 입력하세요.");
		return false;
		
	}else if($("#tel").val()=="phoneType"){
		alert("번호를 선택하세요.");
		return false;
		
	}else if(!$("#tel2").val()){
		alert("전화번호를 입력하세요.");
		return false;
		
	}else if(!$("#tel3").val()){
		alert("전화번호를 입력하세요.");
		return false;
	}
	$("#memberPhone").val($("#tel").val()+"-"+$("#tel2").val()+"-"+$("#tel3").val());
}

</script>

<h2>회원정보 수정 폼</h2>

<form action="<%=request.getContextPath() %>/admin/modifyMemberInfo.do" id="modifyForm" 
	      enctype="multipart/form-data" onsubmit="return setSubmit();">
	<input type="hidden" name="memberId" value="${requestScope.member_info.memberId }">
	<input type="hidden" id="memberPhone" name="memberPhone">
	<input type="hidden" id="zipNo" name="zipNo" value="${requestScope.member_info.zipNo }">
	
	<table style="width:500px">
		<tr>
			<td width="100">ID</td>
			<td>
				${requestScope.member_info.memberId }
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" id="memPassword" name="memPassword"><span id="passwrodMessageLayer"></span> <span class="errorMessage"><form:errors path="member.password"/></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td>
				<input type="password" id="password2" name="password2"><span id="passwrodMessageLayer2"></span> <span class="errorMessage"><form:errors path="member.password"/></span>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" id="memberName" name="memberName" value="${requestScope.member_info.memberName }"> <span class="errorMessage"><form:errors path="member.name"/></span>
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<input type="text" name="memberBirthdate" id="memberBirthdate" value="${requestScope.member_info.memberBirthdate }" readonly="readonly" onClick="datePicker(event,'memberBirthdate')" onClick="datePicker(event,'memberBirthdate')">
			</td>
		</tr>		
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" id="memberEmail" name="memberEmail" value="${requestScope.member_info.memberEmail }"><span id="emailMessageLayer"></span> <span class="errorMessage"><form:errors path="member.email"/></span>
			</td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td>
				<input type="text" size="7" id="zipcode" name="zipcode" value="${requestScope.member_info.zipNo }" readonly="readonly">   <input type="text" id="address2" size="25"name="address2" value="${requestScope.member_info.zipAddress}" readonly="readonly">  <input type="button" id="address" name="address" value="우편번호검색"><br>
				<input type="text" size="30" id="memAddressDetail" name="memAddressDetail" value="${requestScope.member_info.memAddressDetail }">
			</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td> 
				<select name="tel" id="tel">
					<c:forEach items="${telList }" var="tList">
						<c:choose>
							<c:when test="${tList.cmnCodeEng == fn:substring(requestScope.member_info.memberPhone,0,3) }">
								<option value="${tList.cmnCodeEng}" selected="selected"> ${tList.cmnCodeKor}</option>					
							</c:when>
							<c:otherwise>
								<option value="${tList.cmnCodeEng}"> ${tList.cmnCodeKor}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				-
				<input type="text" size="4" id="tel2" name="tel2">
				-
				<input type="text" size="4" id="tel3" name="tel3">
				 
			</td>
		</tr>
		<tr> 
			<td colspan="2" >
				<input type="submit" value="수정">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
