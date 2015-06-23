<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	a:link {text-decoration:none; color: white;}/*방문하지 않은 페이지*/
	a:hover	{text-decoration:underline; color: white;}/*링크에 마우스 올라갔을 때*/
	a:active	{text-decoration:none; color: white;}/*링크 클릭시*/
	a:visited {text-decoration:none; color: white;}/*방문한 링크 표시*/
	.loginArea{background-color: black; height: 195px;width: 300px; float:right;}
	.loginArea tr{height: 65px;}
	.menu {background-color: black; height: 195px;width: 880px; float:left;}/*메뉴영역*/
	.main_menu {background-color: black; height: 100px;width: 880px;}/*메뉴영역*/
	.myinfo_menu {background-color: black; height: 95px;width: 880px; display: none;}
	.movie_menu {background-color: black; height: 95px;width: 880px; display: none;}
	.event_menu {background-color: black; height: 95px;width: 880px; display: none;}
	.customer_menu {background-color: black; height: 95px;width: 880px; display: none;}
	.admin_menu {background-color: black; height: 95px;width: 880px; display: none;}
	
	.form-1 {
    font-family: 'Ubuntu', 'Lato', sans-serif;
    font-weight: 350;
    /* Size and position */
    height: 195px;
    width: 300px;
    position: relative;
    overflow: hidden;

    /* Styles */
    background:black;
   
}
.form-2 {
    font-family: 'Ubuntu', 'Lato', sans-serif;
    font-weight: 350;
}
.form-2 label {
    /* Size and position */
    
    float: left;

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
.form-1 label {
    /* Size and position */
    
    float: left;

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

.form-1 input[type=text]:hover,
.form-1 input[type=password]:hover,
.form-1 label:hover ~ input[type=text],
.form-1 label:hover ~ input[type=password] {
    background: #27292c;
}

.form-1 input[type=text]:focus, 
.form-1 input[type=password]:focus {
    box-shadow: inset 0 0 2px #000;
    background: #494d54;
    border-color: #51cbee;
    outline: none; /* Remove Chrome outline */
}
.form-1 p:nth-child(3),
.form-1 p:nth-child(4) {
    float: left;
    width: 50%;
}
.form-1 input[type=submit] {
    /* Width and position */
    width: 100%;
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
.form-1 input[type=button] {
    /* Width and position */
    width: 49%;
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
.form-2 input[type=button] {
    /* Width and position */
    width: 49%;
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
.form-1 input[type=submit]:hover { 
    box-shadow: inset 0 1px 0 rgba(255,255,255,0.6);
}

.form-1 input[type=submit]:active { 
    background: #287db5;
    box-shadow: inset 0 0 3px rgba(0,0,0,0.6);
    border-color: #000; /* Fallback */
    border-color: rgba(0,0,0,0.9);
}

.no-boxshadow .form-1 input[type=submit]:hover {
    background: #2a92d8;
}
</style>
<script type="text/javascript">
var flag = false;

	$(document).ready(function() {
		if(${sessionScope.login_info != null}){
			hide_subMenu();
			
		}
		$("#myinfoBtn").on("click", function() {
			hide_subMenu();
			$(".myinfo_menu").show();
		});
		$("#movieBtn").on("click", function() {
			hide_subMenu();
			$(".movie_menu").show();
		});
		$("#reserveBtn").on("click", function() {
			hide_subMenu();
			window.location = "<%=request.getContextPath() %>/theater/movieSchedule.do";
		});
		$("#theaterBtn").on("click", function() {
			hide_subMenu();
			window.location = "<%=request.getContextPath() %>/theater/theaterManagement.do";
		});
		$("#eventBtn").on("click", function() {
			hide_subMenu();
			$(".event_menu").show();
		});
		$("#customerBtn").on("click", function() {
			hide_subMenu();
			$(".customer_menu").show();
		});
		$("#statsBtn").on("click", function() {
			hide_subMenu();
			$(".stats_menu").show();
		});
		$("#admin").on("click", function() {
			hide_subMenu();
			$(".admin_menu").show();
		});
		$("#logout").on("click", function(){
			window.location="<%=request.getContextPath() %>/member/logout.do";
		});
		
		$("#mypage").on("click", function(){
			window.location="<%=request.getContextPath() %>/admin/myinfo.do"
		});
	});
	function hide_subMenu() {
			$(".myinfo_menu").hide();
			$(".movie_menu").hide();
			$(".event_menu").hide();
			$(".customer_menu").hide();
			$(".stats_menu").hide();
			$(".admin_menu").hide();
	}
	function join() {
		window.location="<%=request.getContextPath() %>/member/joinForm.do";
	}
	function membersearch(){
		window.location="<%=request.getContextPath() %>/member/membersearch.do";
	}
	function memberleave(){
		flag = confirm("정말 탈퇴하시겠습니까?");
		if(flag){
			location.href="<%=request.getContextPath() %>/member/memberLeave.do";
		}
	}

</script>
<section style="float: left; width: 1180px; height: 80px;">
	<iframe src="http://ad.cgv.co.kr/NetInsight/html/CGV/CGV_201401/main@TopBar_EX" width="100%" height="80" title="" frameborder="0" scrolling="no" topmargin="0" leftmargin="0" marginwidth="0" marginheight="0" name="TopBanner" id="TopBanner"></iframe>
</section>
<section class="menu"><!-- 메뉴영역 -->
	<section class="main_menu"><!-- 메인 메뉴영역 -->
		<img src="<%=request.getContextPath()%>/upload/icon.png" width="100px" height="50px" alt="183box" />
		<label id="movieBtn">영화</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<label id="reserveBtn">예매</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${sessionScope.login_info != null && sessionScope.login_info.memMemberType == '102300'}">
		<label id="theaterBtn">극장</label>&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
		<label id="eventBtn">이벤트</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<label id="customerBtn">고객센터</label>&nbsp;&nbsp;&nbsp;&nbsp;
		
	</section>
	<section class="myinfo_menu"><!-- 마이페이지 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/member/modify_form.do">정보수정</a>&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/movie/user_favorate.do">관심영화</a>
		관람작&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/admin/myinfo.do">마일리지 관리</a>&nbsp;&nbsp;&nbsp;
		예매내역&nbsp;&nbsp;&nbsp;
		<label style="cursor: pointer;" onclick="memberleave()">회원탈퇴</label>	
	</section>
	<section class="movie_menu"><!-- 영화 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/movie/user_movie_list.do">영화</a>
		예매율&nbsp;&nbsp;&nbsp;평점&nbsp;&nbsp;&nbsp;제목순
	</section>
	<section class="reserve_menu"><!-- 영화 서브메뉴영역 -->
	</section>
	<section class="theater_menu"><!-- 영화 서브메뉴영역 -->
	</section>
	<section class="event_menu"><!-- 이벤트 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/event/nowEvent.do">진행중인 이벤트</a>&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/event/endEvent.do">종료된 이벤트</a>&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/event/eventListPaging.do">당첨자 확인</a>
	</section>
	<section class="customer_menu"><!-- 이벤트 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/notice/notice.do">공지사항</a>&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/qa/login/qa.do">Q & A</a>
	</section>
	<section class="admin_menu"><!-- 관리자 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/admin/member_list_Paging.do">회원정보조회</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;예매현황	
		<a href="<%=request.getContextPath() %>/movie/register_form.do">영화등록</a>
		<a href="<%=request.getContextPath() %>/movie/adminmovie_list.do">영화리스트</a>
	</section>
	<!-- 
		<section class="stats_menu">
			<a href="<%=request.getContextPath() %>/admin/member_list.do">회원목록</a>&nbsp;&nbsp;&nbsp;
		</section>
	 -->
</section>

<section class="loginArea">
<c:choose>
	<c:when test="${sessionScope.login_info == null}">
<form class="form-1" action="<%=request.getContextPath() %>/member/login.do" method="post" >
	
	<p class="clearfix" style="margin: 0px;">
			<label for="login">Username</label>
			<input type="text" name="id" size="15" placeholder="ID" onclick="id" autofocus="autofocus">
	</p>
	<p class="clearfix" style="margin: 0px; height: 50px;">
			<label for="password">Password</label>
			<input type="password" name="password" placeholder="Password" size="15">	
	</p>	
	<p class="clearfix2" style="margin: 0px; height: 45px; width:300px;">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="join()">				
			<input type="button" value="Id/PW찾기" onclick="membersearch()">
	</p>
</form>
</c:when>
<c:when test="${sessionScope.login_info != null}">
<form class="form-2">
		<p class="login-after">
			<label for="id">${sessionScope.login_info.memId} 님 환영합니다.</label>
		</p>
	
		<p class="login-after">
			<input type="button" name="myinfoBtn" id="myinfoBtn" value="마이페이지">
			<input type="button" name="" id="" value="예매내역">
		</p>
		<p class="login-after">
			<c:if test="${sessionScope.login_info != null && sessionScope.login_info.memMemberType == '102300'}">
				<input type="button" name="admin" id="admin" value="관리자모드">
			</c:if>

			<input type="button" name="logout" id="logout" value="로그아웃">
		</p>
</form>		

</c:when>
</c:choose>
</section><!-- 로그인 영역 -->
