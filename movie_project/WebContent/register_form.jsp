<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>영화등록</h1>
	<form method="post"
		action="<%=request.getContextPath()%>/movie/register.do"
		id="registerForm" enctype="multipart/form-data">
		<table border="1">

			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>

			<tr>
				<td>줄거리</td>
				<td><input type="text" name="sysnopsis"></td>
			</tr>

			<tr>
				<td>공식홈</td>
				<td><input type="text" name="officialSite"></td>
			</tr>
			<tr>
				<td>상영등급</td>
				<td><input type="text" name="screeningGade"></td>
			</tr>

			<tr>
				<td>포스터</td>
				<td><input type="text" name="poster"></td>
			</tr>

			<tr>
				<td>개봉일</td>
				<td><input type="text" name="intheaters"></td>
			</tr>

			<tr>
				<td>상영시간</td>
				<td><input type="number" name="runtime"></td>
			</tr>

			<tr>
				<td>트레일러</td>
				<td><input type="text" name="trailer"></td>
			</tr>

			<tr>
				<td>평점</td>
				<td><input type="number" name="movGrade"></td>
			</tr>

			<tr>
				<td>평점참가인원</td>
				<td><input type="number" name="movCount"></td>
			</tr>

			<tr>
				<td>장르</td>
				<td><input type="text" name="genre"></td>
			</tr>

			<tr>
				<td>감독번호<br>(후에 db불러오는걸로 수정)
				</td>
				<td><input type="text" name="DIR_NO"></td>
			</tr>

			<tr>
				<td>배우<br>(db수정떔에 sysdate로 해놓음)
				</td>
				<td><input type="text" disabled></td>
			</tr>

			<tr>
				<td>제작사<br>(후에 db불러오는걸로 수정)
				</td>
				<td><input type="text" name="proNo"></td>
			</tr>

			<tr>
				<td><input type="submit"></td>
			</tr>

		</table>
	</form>
</body>
</html>