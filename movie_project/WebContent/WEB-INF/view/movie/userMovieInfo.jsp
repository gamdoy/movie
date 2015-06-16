<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">

<style type="text/css">
tr {
	text-align: center;
}
</style>
<script type="text/javascript">
	var flag = false;
	function submitCheck() {
		$.each($(".star"), function() {
			if ($(this).prop("checked") == true) {
				/* alert("점수가 반영 되었습니다.") */
				flag = true;
			}
		});
		return flag;
	}
</script>

<h1>영화 정보</h1>
${sessionScope }
<table>
	<tr>
		<!-- 제목 -->
		<td>제목</td>
		<td colspan="3">${requestScope.movie.title }
	</tr>
	<tr>
		<!-- 줄거리 -자동 줄넘김 적용 -->
		<td>줄거리</td>
		<td colspan="3">${requestScope.movie.sysnopsis }</td>
	</tr>
	<tr>
		<!-- 상영등급 -->
		<td>상영등급</td>
		<td>${requestScope.movie.screeningGrade}</td>

		<!-- 장르 -->
		<td>장르</td>
		<td>${requestScope.movie.genre}</td>
	</tr>

	<tr>
		<!-- 영화감독 -->
		<td>감독</td>
		<td>${requestScope.movie.dirNo}</td>
		<!-- 배우 -->
		<td>배우</td>
		<td>${requestScope.movie.actNo}</td>
	</tr>

	<tr>
		<!-- 제작사 -->
		<td>제작사</td>
		<td>${requestScope.movie.proNo}</td>
		<!-- 포스터 -->
		<td>포스터</td>
		<td><img
			src="<%=request.getContextPath()%>/images/movie/${requestScope.movie.posterName }"></td>
	</tr>

	<tr>
		<!-- 공식홈 -->
		<td>공식홈</td>
		<td>${requestScope.movie.officialSite }</td>
		<!-- 트레일러 -->
		<td>트레일러</td>
		<td>${requestScope.movie.trailer }<br> <%--  <iframe width="560" height="315" src="${requestScope.movie.trailer }" frameborder="0" allowfullscreen></iframe> --%></td>
	</tr>

	<tr>
		<!-- 개봉일 -->
		<td>개봉일</td>
		<td>${requestScope.movie.intheaters }</td>
		<!-- 상영시간 -->
		<td>상영시간</td>
		<td>${requestScope.movie.runtime }</td>
	</tr>
	<tr>

		<td>평점</td>
		<td colspan="2">현제평점:${requestScope.movie.avgGrade }<br> 
			평가하기
			<form action="<%=request.getContextPath()%>/movie/login/movieGrade.do"
					id="mg" onsubmit="return submitCheck();">
					1<input name="star" id="star" type="radio" class="star" value="1" />
					2<input name="star" id="star" type="radio" class="star" value="2" />
					3<input name="star" id="star" type="radio" class="star" value="3" />
					4<input name="star" id="star" type="radio" class="star" value="4" />
					5<input name="star" id="star" type="radio" class="star" value="5" />
					<input type="hidden" name="movNo"
						value="${requestScope.movie.movieNo }"> <input
						type="submit" value="평가">
				</form>
		<td>
			<form action="<%=request.getContextPath()%>/movie/login/addFavorite.do">
				<input type="hidden" name="movNo"
					value="${requestScope.movie.movieNo }"> <input
					type="hidden" name="memNo" value="${sessionScope.login_info.memNo}">

					<c:choose>
						<c:when test="${sessionScope.login_info.memNo != null && requestScope.movie.movieNo==requestScope.list.favor }">
		 				이미 관심 영화로 등록 되 있습니다.
					</c:when>
						<c:otherwise>
							<input type="submit" value="관심영화 추가"><br>
						</c:otherwise>
					</c:choose>

			</form>
		</td>
	</tr>

</table>
