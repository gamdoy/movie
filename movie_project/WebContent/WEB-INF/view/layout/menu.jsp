<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	a:link {text-decoration:none; color: white;}/*방문하지 않은 페이지*/
	a:hover	{text-decoration:underline; color: white;}/*링크에 마우스 올라갔을 때*/
	a:active	{text-decoration:none; color: white;}/*링크 클릭시*/
	a:visited {text-decoration:none; color: white;}/*방문한 링크 표시*/
	.menu {background-color: gray; height: 160px;width: 1280px;}/*메뉴영역*/
	.main_menu {background-color: black; height: 80px;width: 1280px;}/*메뉴영역*/
	.myinfo_menu {background-color: gray; height: 80px;width: 1280px; display: none;}
	.movie_menu {background-color: gray; height: 80px;width: 1280px; display: none;}
	.event_menu {background-color: gray; height: 80px;width: 1280px; display: none;}
	.customer_menu {background-color: gray; height: 80px;width: 1280px; display: none;}
</style>
<script type="text/javascript">
	$(document).ready(function() {
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
			$(".reserve_menu").show();
		});
		$("#theaterBtn").on("click", function() {
			hide_subMenu();
			location.href = "<%= request.getContextPath()%>/theater/theaterManagement.do";
		});
		$("#eventBtn").on("click", function() {
			hide_subMenu();
			$(".event_menu").show();
		});
		$("#customerBtn").on("click", function() {
			hide_subMenu();
			$(".customer_menu").show();
		});
		$("#testBtn").on("click", function() {
			$.ajax({
				url:"<%=request.getContextPath() %>/theater/ajaxTest.do",
				data:{"theaNo":"1"},
				dataType:"JSON",
				success:function(ret){
					alert(ret.theaNo);
				}
			});
		});
	});
	function hide_subMenu() {
			$(".myinfo_menu").hide();
			$(".movie_menu").hide();
			$(".event_menu").hide();
			$(".customer_menu").hide();
	}
</script>
<div class="menu"><!-- 메뉴영역 -->
	<span>
	<div class="main_menu"><!-- 메인 메뉴영역 -->
		<label id="movieBtn">영화</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<label id="reserveBtn">예매</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<label id="theaterBtn">극장</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<label id="eventBtn">이벤트</label>&nbsp;&nbsp;&nbsp;&nbsp;
		<label id="customerBtn">고객센터</label>
		<label id="testBtn">test</label>
	</div>
	<div class="myinfo_menu"><!-- 마이페이지 서브메뉴영역 -->
		정보수정&nbsp;&nbsp;&nbsp;관심영화&nbsp;&nbsp;&nbsp;관람작&nbsp;&nbsp;&nbsp;마일리지 관리&nbsp;&nbsp;&nbsp;예매내역&nbsp;&nbsp;&nbsp;회원탈퇴
	</div>
	<div class="movie_menu"><!-- 영화 서브메뉴영역 -->
		예매율&nbsp;&nbsp;&nbsp;평점&nbsp;&nbsp;&nbsp;제목순
	</div>
	<div class="reserve_menu"><!-- 영화 서브메뉴영역 -->
	</div>
	<div class="theater_menu"><!-- 영화 서브메뉴영역 -->
	</div>
	<div class="event_menu"><!-- 이벤트 서브메뉴영역 -->
		진행중인 이벤트&nbsp;&nbsp;&nbsp;종료된 이벤트&nbsp;&nbsp;&nbsp;당첨자 확인
	</div>
	<div class="customer_menu"><!-- 이벤트 서브메뉴영역 -->
		공지사항&nbsp;&nbsp;&nbsp;Q & A&nbsp;&nbsp;&nbsp;F & Q
	</div>
	</span>
	<span style="float: right;" >
	</span>
</div>
<div class="login_area">
	<input id="id" type="text">11
</div>
<!-- 로그인 영역 -->    