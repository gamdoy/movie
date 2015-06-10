<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table, td{
dorfer: 1px;

}
table{
width:500px;
height:100px;
magin:auto;
text-align: center;
}
</style>
<title>결과 페이지</title>
</head>
<body>
	<h1>등록내용</h1>

	<table border="1">
		<tr>
			<td>제목</td>
			<td>${requestScope.movie.title }</td>
		</tr>
		<tr>
			<td>줄거리</td>
			<td>${requestScope.movie.sysnopsis }</td>
		</tr>

		<tr>
			<td>공식홈</td>
			<td>${requestScope.movie.officialSite }</td>
		</tr>
		<tr>
			<td>상영등급</td>
			<td>
				${requestScope.movie.sgradeName }
			</td>
		</tr>

		<tr>
			<td>포스터</td>
			<td colspan="2"><c:choose>
					<c:when test="${empty requestScope.movie.posterName }">
						<img src="<%=request.getContextPath()%>/images/movie/noimage.png">
					</c:when>
					<c:otherwise>
						<img
							src="<%=request.getContextPath()%>/images/movie/${requestScope.movie.posterName }">
					</c:otherwise>
				</c:choose></td>
			
		</tr>

		<tr>
			<td>개봉일</td>
			<td>${requestScope.movie.intheaters }</td>
		</tr>

		<tr>
			<td>상영시간</td>
			<td>${requestScope.movie.runtime }</td>
		</tr>

		<tr>
			<td>트레일러</td>
			<td>${requestScope.movie.trailer }</td>
		</tr>

		<tr>
			<td>장르</td>
			<td>${requestScope.movie.genreName }</td>
		</tr>

		<tr>
			<td>감독</td>
			<td>${requestScope.movie.dirName } </td>
		</tr>

		<tr>
			<td>배우<br>
			</td>
			<td> ${requestScope.movie.actName 	}</td>
		</tr>

		<tr>
			<td>제작사<br>
			</td>
			<td>${requestScope.movie.proName }</td>
		</tr>
	</table>
	 <span style="background-color:#00FEFE">
	<a href="<%=request.getContextPath()%>/movie/adminmovie_list.do"> 리스트 </a>
	</span>
	
</body>
</html>