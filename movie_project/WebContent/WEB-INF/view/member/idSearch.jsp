<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.idsearch {
    font-family: 'Ubuntu', 'Lato', sans-serif;
    font-weight: 350;
    /* Size and position */
    
    overflow: hidden;

    /* Styles */
    background:black;
   
}
.idsearch {
    font-family: 'Ubuntu', 'Lato', sans-serif;
    font-weight: 350;
}
.idsearch label {
    /* Size and position */
    

    /* Styles */
    color: #ddd;
    font-size: 15px;
    text-transform: uppercase;
    letter-spacing: 1px;
    text-shadow: 0 1px 0 #000;
    text-indent: 10px;
    font-weight: 700;
    cursor: pointer;
}


.idsearch input[type=text]:hover,
.idsearch label:hover ~ input[type=text],
    background: #27292c;
}

.idsearch input[type=text]:focus, 
    box-shadow: inset 0 0 2px #000;
    background: #494d54;
    border-color: #51cbee;
    outline: none; /* Remove Chrome outline */
}
.idsearch p:nth-child(3),
.idsearch p:nth-child(4) {
    float: left;
    width: 50%;
}
.idsearch input[type=submit],
.idsearch input[type=button]  {
    /* Width and position */
    width: 30%;
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
.idsearch input[type=submit]:hover { 
    box-shadow: inset 0 1px 0 rgba(255,255,255,0.6);
}

.idsearch input[type=submit]:active { 
    background: #287db5;
    box-shadow: inset 0 0 3px rgba(0,0,0,0.6);
    border-color: #000; /* Fallback */
    border-color: rgba(0,0,0,0.9);
}

.no-boxshadow idsearch input[type=submit]:hover {
    background: #2a92d8;
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/date_picker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/jquery.js"></script>
<script type="text/javascript">
function cancle(){
	window.close();
}

function setSubmit(){
	if(!$("#memName").val()){
		alert("이름을 입력하세요.");
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
</head>
<body>
<c:choose>
	<c:when test="${empty member_info.memId}">
<form class="idsearch" action="<%=request.getContextPath() %>/member/idSearch.do" id="idSearchForm" 
	      enctype="multipart/form-data" onsubmit="return setSubmit();">
	      <br>
	      <br>
	      <br>
	<input type="hidden" id="memPhoneNo" name="memPhoneNo"> 
	    
	<p class="idsearch">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="memName">이름</label>&nbsp;&nbsp;
			<input type="text" id="memName" name="memName">
	</p>
		
	<p class="idsearch">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="tel">연락처</label>&nbsp;
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
				<font style="color: white;">-</font>
				<input type="text" size="4" id="tel2" name="tel2">
				<font style="color: white;">-</font>
				<input type="text" size="4" id="tel3" name="tel3">
				 
	</p>
	<p class="idsearch">
			&nbsp;&nbsp;&nbsp;<label for="membirthdate">생년월일</label>&nbsp;
				<input type="text" name="memBirthDate" id="memBirthDate" size="6" readonly="readonly" onClick="datePicker(event,'memBirthDate')" onClick="datePicker(event,'memBirthDate')">
			
	</p>
	<p class="idsearch">
				<center>
				<input type="submit" value="id찾기">&nbsp;
				<input type="button" value="취소" onclick="cancle()">
				</center>	
	<br>			
	</p>
</form>
</c:when>
<c:when test="${!empty member_info.memId}">
	<br>
	<br>
	<br>
	<br>
	<br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	당신의 ID는&nbsp;<font size="5">${member_info.memId}</font>&nbsp; 입니다.
	

</c:when>
</c:choose>
</body>
</html>