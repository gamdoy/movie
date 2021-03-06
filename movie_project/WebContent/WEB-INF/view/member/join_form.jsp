<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.normalMessage{color: blue;}
.errorMessage{color: red;}
.joinform {
	text-align:
    font-family: 'Ubuntu', 'Lato', sans-serif;
   	background-color: black;
   
}
.joinform label {
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

.joinform input[type=text]:hover,
.joinform input[type=password]:hover,
.joinform label:hover ~ input[type=text],
.joinform label:hover ~ input[type=password] {
    background: #27292c;
}

.joinform input[type=text]:focus, 
.joinform input[type=password]:focus {
    box-shadow: inset 0 0 2px #000;
    background: #494d54;
    border-color: #51cbee;
    outline: none; /* Remove Chrome outline */
}

.joinform input[type=submit], 
.joinform input[type=button],
.joinform input[type=reset]{
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
.joinform input[type=button] {
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
.joinform input[type=submit]:hover { 
    box-shadow: inset 0 1px 0 rgba(255,255,255,0.6);
}

.joinform input[type=submit]:active { 
    background: #287db5;
    box-shadow: inset 0 0 3px rgba(0,0,0,0.6);
    border-color: #000; /* Fallback */
    border-color: rgba(0,0,0,0.9);
}

.no-boxshadow .joinform input[type=submit]:hover {
    background: #2a92d8;
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/date_picker.js"></script>
<script type="text/javascript">
var idDup = false;//ID 중복여부 체크 - true : 사용할 수 있다(중복아님), false : 사용할 수 없다(중복아님)
var idflag = false;
var idflag2 = false;
$(document).ready(function(){
	
	//ID 중복 체크
	$("#idconfirm").on("click", function(){
		idflag2 = true;
		var id = $("#memId").val();
		$.ajax({
			url:"<%=request.getContextPath() %>/member/idDuplicateCheck.do",
			data:{"id":id},
			dataType:"JSON",
			beforeSend:function(){
				if(!id){//id에 입력된 값이 없으면 전송하지 않는다.
					return false;
				}
			},
			success:function(ret){
				idDup = ret.result;
				if(!idDup){
					$("#dupMessageLayer").text("중복된 아이디 입니다.");
					$("#dupMessageLayer").prop("class","errorMessage");
					idflag = false;
				}else{
					$("#dupMessageLayer").text("사용할 수 있는 아이디 입니다.");
					$("#dupMessageLayer").prop("class","normalMessage");
					idflag = true;

				}
			}
		})
	});
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
	if(!$("#memId").val()){
		alert("Id를 입력하세요.");
		return false;
	}else if(idflag2==false){
		alert("중복확인버튼을 눌러주세요.");
		return false;
	}else if(idflag==false){
		alert("중복아이디입니다. 다른아이디를 사용해주세요.");
		return false;
	}else if(!$("#memPassword").val()){
		alert("비밀번호를 입력하세요.");
		return false;
	}else if(!($("#memPassword").val()==$("#password2").val())){
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


<form class="joinform" method="post" action="<%=request.getContextPath() %>/member/join.do"  id="registerForm" onsubmit=" return setSubmit();" enctype="multipart/form-data">
	<input type="hidden" id="memPhoneNo" name="memPhoneNo">
	<input type="hidden" id="zipNo" name="zipNo">
	ddd
	<p class="joinform">
		<label for="memId" style="height: 50px;"><br>ID</label>
		<input type="text" name="memId" id="memId"> <input type="button" name="idconfirm" id="idconfirm" value="중복확인">
		<span id="dupMessageLayer"> </span><span class="errorMessage"><form:errors path="member.id"/></span>	
	</p>
		
	<p class="joinform">
		<label for="memPassword">Password</label>
			<input type="password" id="memPassword" name="memPassword"><span id="passwrodMessageLayer"></span> <span class="errorMessage"><form:errors path="member.password"/></span>
	</p>
	<p class="joinform">
		<label for="password2">Password확인</label>	
				<input type="password" id="password2" name="password2"><span id="passwrodMessageLayer2"></span> <span class="errorMessage"><form:errors path="member.password"/></span>
	</p>
	<p class="joinform">
		<label for="memName">이름</label>					
				<input type="text" id="memName" name="memName"> <span class="errorMessage"><form:errors path="member.name"/></span>
	</p>	
	<p class="joinform">
		<label for="memBirthDate">생년월일</label>	
				<input type="text" name="memBirthDate" id="memBirthDate" readonly="readonly" onClick="datePicker(event,'memBirthDate')" onClick="datePicker(event,'memBirthDate')"><br>
	</p>
	<p class="joinform">
		<label for="memEmail">이메일</label>			
				<input type="text" id="memEmail" name="memEmail"><span id="emailMessageLayer"></span> <span class="errorMessage"><form:errors path="member.email"/></span>
	</p>
	<p class="joinform">
		<label for="memAddressDetail">상세주소</label>					
				<input type="text" size="7" id="zipcode" name="zipcode" readonly="readonly">   <input type="text" id="address2" size="25"name="address2" readonly="readonly">  <input type="button" id="address" name="address" value="우편번호검색"><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" size="38" id="memAddressDetail" name="memAddressDetail">
	</p>	
	<p class="joinform">
		<label for="tel">연락처</label>				
				<select name="tel" id="tel">
					<c:forEach items="${telList }" var="tList">
						<option value="${tList.cmnCodeEng}"> ${tList.cmnCodeKor}</option>					
					</c:forEach>
				</select>
				-
				<input type="text" size="4" id="tel2" name="tel2">
				-
				<input type="text" size="4" id="tel3" name="tel3">
	</p>			 
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="가입">
				&nbsp;&nbsp;<input type="reset" value="다시작성">
			
</form>
