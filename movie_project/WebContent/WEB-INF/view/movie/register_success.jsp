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
				<select name="screeningGrade" >
						<c:forEach items="${screenGrade }" var="sgrade">
							<option value="${sgrade.cmnNo }"> ${sgrade.cmnCodeKor }</option>
						</c:forEach> 
				</select>  

			</td>
		</tr>

		<tr>
			<td>포스터</td>
			<td colspan="2"><c:choose>
					<c:when test="${empty requestScope.movie.posterName }">
						<img src="<%=request.getContextPath()%>/images/noimage.png">
					</c:when>
					<c:otherwise>
						<img
							src="<%=request.getContextPath()%>/images/${requestScope.movie.posterName }">
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
			<td>평점</td>
			<td>${requestScope.movie.movGrade }</td>
		</tr>

		<tr>
			<td>평점참가인원</td>
			<td>${requestScope.movie.movCount }</td>
		</tr>

		<tr>
			<td>장르</td>
			<td>${requestScope.movie.genre }</td>
		</tr>

		<tr>
			<td>감독번호</td>
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
</body>
</html>