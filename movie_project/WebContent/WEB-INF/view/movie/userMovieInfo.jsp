<%@ page contentType = "text/html; charset=UTF-8"%>
<meta charset="UTF-8">
<style type="text/css">
tr{
text-align: center;
}


</style>
<!--

-->
</style>
<h1>영화 정보<br>
<br>
</h1>
<form >
		<table >
			<tr>
				<!-- 제목 -->
				<td>제목</td>
				<td colspan="3">${requestScope.movie.title }</tr>
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
				<td><img src="<%=request.getContextPath()%>/images/movie/${requestScope.movie.posterName }"></td>
			</tr>

			<tr>
				<!-- 공식홈 -->
				<td>공식홈</td>
				<td>${requestScope.movie.officialSite }</td>
				<!-- 트레일러 -->
				<td>트레일러</td>
				<td>${requestScope.movie.trailer }<br>
					<%--  <iframe width="560" height="315" src="${requestScope.movie.trailer }" frameborder="0" allowfullscreen></iframe> --%></td>
			</tr>

			<tr>
				<!-- 개봉일 -->
				<td>개봉일</td>
				<td>${requestScope.movie.intheaters }</td>
				<!-- 상영시간 -->
				<td>상영시간</td>
				<td>${requestScope.movie.runtime } </td>
			</tr>
		</table>
	</form>
