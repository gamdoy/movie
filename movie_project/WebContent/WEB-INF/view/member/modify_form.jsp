<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
.normalMessage{color: blue;}
.errorMessage{color: red;}
.modifyform {
	text-align:
    font-family: 'Ubuntu', 'Lato', sans-serif;
   	background-color: black;
    margin-top: 0px;
   
}
.modifyform label {
    /* Size and position */
    font-family: 'Ubuntu', 'Lato', sans-serif;
    text-align:center;
    font-weight: 350;
    width:120px;
    float: left;
	background-color:black;
    /* Styles */
    color: #ddd;
    font-size: 12px;
    text-transform: uppercase;
    letter-spacing: 1px;
    text-shadow: 0 1px 0 #000;
    text-indent: 10px;
    font-weight: 700;
    cursor: pointer;
}

.modifyform input[type=text]:hover,
.modifyform input[type=password]:hover,
.modifyform label:hover ~ input[type=text],
.modifyform label:hover ~ input[type=password] {
    background: #27292c;
}

.modifyform input[type=text]:focus, 
.modifyform input[type=password]:focus {
    box-shadow: inset 0 0 2px #000;
    background: #494d54;
    border-color: #51cbee;
    outline: none; /* Remove Chrome outline */
}

.modifyform input[type=submit], 
.modifyform input[type=button],
.modifyform input[type=reset]{
    /* Width and position */
    width: 150px;
    padding: 8px 5px;
  
    /* Styles */
    border: 1px solid #0273dd; /* Fallback */
    border: 1px solid rgba(0,0,0,0.4);
    box-shadow:
        inset 0 1px 0 rgba(255,255,255,0.3),
        inset 0 10px 10px rgba(255,255,255,0.1);
    border-radius: 3px;
    background: #38a6f0;
    cursor:pointer;
  
    /* Font styles */
    font-family: 'Ubuntu', 'Lato', sans-serif;
   	color: #ddd;
    font-weight: 700;
    font-size: 15px;
    text-shadow: 0 -1px 0 rgba(0,0,0,0.8);
}
.modifyform input[type=button] {
    /* Width and position */
    padding: 8px 5px;
  
    /* Styles */
    border: 1px solid #0273dd; /* Fallback */
    border: 1px solid rgba(0,0,0,0.4);
    box-shadow:
        inset 0 1px 0 rgba(255,255,255,0.3),
        inset 0 10px 10px rgba(255,255,255,0.1);
    border-radius: 3px;
    background: #38a6f0;
    cursor:pointer;
  
    /* Font styles */
    font-family: 'Ubuntu', 'Lato', sans-serif;
    color: white;
    font-weight: 700;
    font-size: 15px;
    text-shadow: 0 -1px 0 rgba(0,0,0,0.8);
}
.modifyform input[type=submit]:hover { 
    box-shadow: inset 0 1px 0 rgba(255,255,255,0.6);
}

.modifyform input[type=submit]:active { 
    background: #287db5;
    box-shadow: inset 0 0 3px rgba(0,0,0,0.6);
    border-color: #000; /* Fallback */
    border-color: rgba(0,0,0,0.9);
}

.no-boxshadow .modifyform input[type=submit]:hover {
    background: #2a92d8;
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/date_picker.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	if("${message}"=="true"){
		alert("수정되었습니다");
		window.location="<%= request.getContextPath()%>/main.do";
	}
	var phone1 = "${sessionScope.login_info.memPhoneNo}".split("-")[0];
	var phone2 = "${sessionScope.login_info.memPhoneNo}".split("-")[1];
	var phone3 = "${sessionScope.login_info.memPhoneNo}".split("-")[2];
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
	$("#memEmail").on("change", function(){
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
	alert($("#memPassword").val());
	if(!$("#memPassword").val()){
		alert("비밀번호를 입력하세요.");
		return false;
		
	}else if(!($("#memPassword").val()==$(password2).val())){
		alert("비밀번호를 일치하게 입력하세요.");
		return false;
			
	}else if(!$("#memName").val()){
		alert("이름을 입력하세요.");
		return false;
		
	}else if(!$("#memBirthDate").val()){
	alert("생년월일을 입력하세요.");
	return false;
	
	}else if(!$("#memEmail").val()){
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
	$("#memPhoneNo").val($("#tel").val()+"-"+$("#tel2").val()+"-"+$("#tel3").val());
}

</script>



<form class="modifyform" action="<%=request.getContextPath() %>/member/modifyMemberInfo.do" id="modifyForm" 
	      enctype="multipart/form-data" onsubmit="return setSubmit();">
	<input type="hidden" name="memId" value="${sessionScope.login_info.memId }">
	<input type="hidden" id="memPhoneNo" name="memPhoneNo">
	<input type="hidden" id="zipNo" name="zipNo" value="${sessionScope.login_info.zipNo }">
	
	
	<p class="modifyform">
	<br>
	<br>
		<label for="memId" style="margin-top: 0px;">ID</label>
		<font style="color: white;">${sessionScope.login_info.memId }</font> 
	</p>
		
	<p class="modifyform">
		<label for="memPassword">Password</label>
		<input type="password" id="memPassword" name="memPassword"><span id="passwrodMessageLayer"></span> <span class="errorMessage"><form:errors path="member.password"/></span>
	</p>
	<p class="modifyform">
		<label for="password2">Password확인</label>	
				<input type="password" id="password2" name="password2"><span id="passwrodMessageLayer2"></span> <span class="errorMessage"><form:errors path="member.password"/></span>
	</p>
	<p class="modifyform">
		<label for="memName">이름</label>					
				<input type="text" id="memName" name="memName" value="${sessionScope.login_info.memName }"> <span class="errorMessage"><form:errors path="member.name"/></span>
	</p>	
	<p class="modifyform">
		<label for="memBirthDate">생년월일</label>	
				<input type="text"  value="${sessionScope.login_info.memBirthDate }" name="memBirthDate" id="memBirthDate" readonly="readonly" onClick="datePicker(event,'memBirthDate')" onClick="datePicker(event,'memBirthDate')"><br>
	</p>
	<p class="modifyform">
		<label for="memEmail">이메일</label>			
				<input type="text" value="${sessionScope.login_info.memEmail }" id="memEmail" name="memEmail"><span id="emailMessageLayer"></span> <span class="errorMessage"><form:errors path="member.email"/></span>
	</p>
	<p class="modifyform">
		<label for="memAddressDetail">상세주소</label>					
				<input type="text" size="7" value="${sessionScope.login_info.zipNo }" id="zipcode" name="zipcode" readonly="readonly">   <input type="text" id="address2" value="${sessionScope.login_info.zipAddress}" size="25"name="address2" readonly="readonly">  <input type="button" id="address" name="address" value="우편번호검색"><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" size="38" value="${sessionScope.login_info.memAddressDetail }" id="memAddressDetail" name="memAddressDetail">
	</p>	
	<p class="modifyform">
		<label for="tel">연락처</label>				
				<select name="tel" id="tel">
					<c:forEach items="${telList }" var="tList">
						<c:choose>
							<c:when test="${tList.cmnCodeEng == fn:substring(sessionScope.login_info.memPhoneNo,0,3) }">
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
	</p>	
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="수정">
				&nbsp;&nbsp;<input type="reset" value="다시작성">
			
	
</form>
