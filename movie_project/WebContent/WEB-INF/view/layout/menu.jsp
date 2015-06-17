<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	a:link {text-decoration:none; color: white;}/*방문하지 않은 페이지*/
	a:hover	{text-decoration:underline; color: white;}/*링크에 마우스 올라갔을 때*/
	a:active	{text-decoration:none; color: white;}/*링크 클릭시*/
	a:visited {text-decoration:none; color: white;}/*방문한 링크 표시*/
	.loginArea{background-color: gray; height: 195px;width: 300px; float:right;}
	.loginArea tr{height: 65px;}
	.menu {height: 195px;width: 880px; float:left;}/*메뉴영역*/
	.main_menu {background-color: black; height: 100px;width: 880px;}/*메뉴영역*/
	.myinfo_menu {height: 95px;width: 880px; display: none;}
	.movie_menu {height: 95px;width: 880px; display: none;}
	.event_menu {height: 95px;width: 880px; display: none;}
	.customer_menu {height: 95px;width: 880px; display: none;}
	.admin_menu {height: 95px;width: 880px; display: none;}
</style>
<script type="text/javascript">
var flag = false;

	$(document).ready(function() {
		if(${sessionScope.login_info != null}){
			hide_subMenu();
			$(".myinfo_menu").show();
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
		<!-- <label id="adminBtn">관리자</label> -->
	</section>
	<section class="myinfo_menu"><!-- 마이페이지 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/member/modify_form.do">정보수정</a>&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/movie/user_favorate.do">관심영화</a>
		관람작&nbsp;&nbsp;&nbsp;
		마일리지 관리&nbsp;&nbsp;&nbsp;
		예매내역&nbsp;&nbsp;&nbsp;
		<label style="cursor: pointer;" onclick="memberleave()">회원탈퇴</label>	
	</section>
	<section class="movie_menu"><!-- 영화 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/movie/user_movie_list.do">영화</a>
		예매율&nbsp;&nbsp;&nbsp;평점&nbsp;&nbsp;&nbsp;제목순
	</section>f
	<section class="reserve_menu"><!-- 영화 서브메뉴영역 -->
	</section>
	<section class="theater_menu"><!-- 영화 서브메뉴영역 -->
	</section>
	<section class="event_menu"><!-- 이벤트 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/event/nowEvent.do">진행중인 이벤트</a>&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/event/endEvent.do">종료된 이벤트</a>&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/event/eventListPaging.do">당첨자 확인</a>
	</section>
	<section class="customer_menu"><!-- 이벤트 서브메뉴영역 -->
		<a href="<%=request.getContextPath() %>/notice/notice.do">공지사항</a>&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/qa/qa.do">Q & A</a>
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
<form action="<%=request.getContextPath() %>/member/login.do" method="post" >
	<table style=" width: 300px; height: 180px">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" size="5" placeholder="ID" onclick="id" autofocus="autofocus"></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" name="password" placeholder="Password" size="5"></td>	
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="join()">				
				<input type="button" value="Id/PW찾기" onclick="membersearch()">
			</td>
		</tr>			
	</table>
</form>
</c:when>
<c:when test="${sessionScope.login_info != null}">
<form>
<table style=" width: 300px;">
		<tr>	
			<td colspan="2">${sessionScope.login_info.memId}님환영합니다.</td>
		</tr>
	
		<tr>
			<td><input type="button" name="myinfoBtn" id="myinfoBtn" value="마이페이지"></td>
			<td><input type="button" name="" id="" value="예매내역"></td>
		</tr>
		<tr>
			<td><input type="button" name="admin" id="admin" value="관리자모드"></td>
			<td><input type="button" name="logout" id="logout" value="로그아웃"></td>
		</tr>
</table>
</form>		

</c:when>
</c:choose>
</section><!-- 로그인 영역 -->
