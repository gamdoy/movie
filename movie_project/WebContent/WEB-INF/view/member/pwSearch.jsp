<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.pwsearch {
    font-family: 'Ubuntu', 'Lato', sans-serif;
    font-weight: 350;
    /* Size and position */
    
    overflow: hidden;

    /* Styles */
    background:black;
   
}
.pwsearch {
    font-family: 'Ubuntu', 'Lato', sans-serif;
    font-weight: 350;
}
.pwsearch label {
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


.pwsearch input[type=text]:hover,
.pwsearch label:hover ~ input[type=text],
    background: #27292c;
}

.pwsearch input[type=text]:focus, 
    box-shadow: inset 0 0 2px #000;
    background: #494d54;
    border-color: #51cbee;
    outline: none; /* Remove Chrome outline */
}
.pwsearch p:nth-child(3),
.pwsearch p:nth-child(4) {
    float: left;
    width: 50%;
}
.pwsearch input[type=submit],
.pwsearch input[type=button]  {
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
.pwsearch input[type=submit]:hover { 
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
	src="<%=request.getContextPath()%>/script/jquery.js"></script>
<script type="text/javascript">
function cancle(){
	window.close();
}
</script>
</head>
<body>
<c:choose>
	<c:when test="${empty member_info.memPassword }">
<form class="pwsearch" action="<%=request.getContextPath() %>/member/pwSearch.do" enctype="multipart/form-data" onsubmit="return setSubmit();" method="post">
	 	  <br>    
	      <br>
	<p class="idsearch">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="memId">ID</label>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" id="memId" name="memId">
	</p>
		
	<p class="idsearch">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="memName">이름</label>&nbsp;&nbsp;&nbsp;
			<input type="text" name="memName" id="memName">	
	</p>
	<p class="idsearch">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="memEmail">이메일</label>&nbsp;&nbsp;&nbsp;
				<input type="text" name="memEmail" id="memEmail">
			
	</p>
	<br>
	<p class="idsearch">
				<center>
				<input type="submit" value="Password찾기">&nbsp;
				<input type="button" value="취소" onclick="cancle()">
				</center>	
				<br>
	</p>
</form>
	</c:when>
	<c:when test="${!empty member_info.memPassword }">
	<br>
	<br>
	<br>
	찾으신 ID의 비밀번호는: ${member_info.memPassword } 입니다.
	</c:when>
</c:choose>
</body>
</html>