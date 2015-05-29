<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
	<h1>등록및 수정내용</h1>
	
	

	<table border="1">
		<tr>
			<td>제목</td>
			<td>${requestScope.movieVO.title }</td>
		</tr>
		<tr>
			<td>줄거리</td>
			<td>${requestScope.movieVO.sysnopsis }</td>
		</tr>

		<tr>
			<td>공식홈</td>
			<td>${requestScope.movieVO.officialSite }</td>
		</tr>
		<tr>
			<td>상영등급</td>
			<td>${requestScope.movieVO.screeningGrade }</td>
		</tr>

		<tr>
			<td>포스터</td>
			<td>${requestScope.movieVO.posterName }</td>
		</tr>

		<tr>
			<td>개봉일</td>
			<td>${requestScope.movieVO.intheaters }</td>
		</tr>

		<tr>
			<td>상영시간</td>
			<td colspan="2">
			<c:choose>
				<c:when test="${empty requestScope.member.posterName }">
					<img src="<%=request.getContextPath()%>/images/noimage.png">
				</c:when>
				<c:otherwise>
					<img src="<%=request.getContextPath()%>/images/${requestScope.member.potserName }">
				</c:otherwise>
			</c:choose>
		</td>
		</tr>

		<tr>
			<td>트레일러</td>
			<td>${requestScope.movieVO.trailer }</td>
		</tr>

		<tr>
			<td>평점</td>
			<td>${requestScope.movieVO.movGrade }</td>
		</tr>

		<tr>
			<td>평점참가인원</td>
			<td>${requestScope.movieVO.movCount }</td>
		</tr>

		<tr>
			<td>장르</td>
			<td>${requestScope.movieVO.genre }</td>
		</tr>

		<tr>
			<td>감독번호<br>(후에 db불러오는걸로 수정)
			</td>
			<td>지금은 값 없음</td>
		</tr>

		<tr>
			<td>배우<br>(db수정떔에 고정값)
			</td>
			<td>${requestScope.movieVO.proNo }</td>
		</tr>

		<tr>
			<td>제작사<br>(후에 db불러오는걸로 수정)
			</td>
			<td>${requestScope.movieVO.officialSite }</td>
		</tr>

		

	</table>
</body>
</html>