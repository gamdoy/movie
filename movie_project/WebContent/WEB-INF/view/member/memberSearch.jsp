<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.searchform input[type=button],
.searchform input[type=reset]{
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
.searchform input[type=button] {
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
</style>
<script type="text/javascript">
function idlink() {
	window.open("<%= request.getContextPath()%>/member/idsearch_form.do","idsearch", "height=300,top=300,left=500, width=400, menubar=no, toolbar=no, location=no, status=no, resizable=no");
}
function pwlink() {
	window.open("<%= request.getContextPath()%>/member/pwsearch_form.do","idsearch", "height=300,top=300,left=500, width=400, menubar=no, toolbar=no, location=no, status=no, resizable=no");
}
</script>
</head>
<body>
<form class="searchform" style="background-color: black;">	
	<center><br><br><br><br><br><br><br><br><br><br>
	<input type="button" id="idsearch" value="아이디찾기" onclick="idlink()">&nbsp;&nbsp;&nbsp;
	<input type="button" id="passwordsearch" value="비밀번호찾기" onclick="pwlink()">
	</center><br><br><br><br><br><br><br><br><br><br>
</form>
</body>
</html>