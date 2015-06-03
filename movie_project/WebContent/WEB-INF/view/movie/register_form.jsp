<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/jquery.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>


	<!-- 제목 <input type="text" name="title"><br>
줄거리 <input type="text" name="sysnopsis"><br>
공식홈 <input type="text" name="officialSite"><br>
상영등급 <input type="text" name="screeningGade"><br>
포스터 <input type="text" name="poster"><br>
개봉일 <input type="text" name="intheaters"><br>
상영시간 <input type="number" name="runtime"><br>
트레일러 <input type="text" name="trailer"><br>
평점 <input type="number" name="movGrade"><br>
평점참가인원  <input type="number" name="movCount"><br>
장르 <input type="text" name="genre"><br>
감독번호(후에 db불러오는걸로 수정) <input type="text" name="DIR_NO"><br>
배우(db수정떔에 sysdate로 해놓음) <input type="text"  disabled ><br>
제작사(후에 db불러오는걸로 수정) <input type="text" name="proNo"><br>
<input type="submit"> -->

	<h1>영화등록</h1>
	
	<form method="post"
		action="<%=request.getContextPath()%>/movie/register.do"
		id="registerForm" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title"></td>
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
				<td><select name="screeningGrade" id="screenGrade">
						<c:forEach items="${screenGrade }" var="sgrade">
							<option value="${sgrade.cmnNo }"> ${sgrade.cmnCodeKor }</option>
						</c:forEach> 
				</select>  
				</td>
				
				
			</tr>

			<tr>
				<td>포스터</td>
				<td><input type="file" name="poster"></td>
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
				<td><input type="text" name="movGrade"></td>
			</tr>

			<tr>
				<td>평점참가인원</td>
				<td><input type="number" name="movCount"></td>
			</tr>

			<tr>
				<td>장르</td>
				<td><select name="genre" id="genre">
						<c:forEach items="${genre }" var="genre">
							<option value="${genre.cmnNo }">${genre.cmnCodeKor }</option>

						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>감독<br>
				<td><select name="director" id="director">
						<c:forEach items="${director }" var="director">
							<option value="${director.dirNo }">${director.dirName }</option>

						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>배우<br>
				</td>
				 <td><select name="actor" id="actor">
						<c:forEach items="${actor }" var="actor">
							<option value="${actor.actNo }">${actor.actName }</option>
						</c:forEach>
				</select></td> 
			</tr>

			<tr>
				<td>제작사<br>(후에 db불러오는걸로 수정)
				</td>
				<td><select name="production" id="production">
						<c:forEach items="${production }" var="production">
							<option value="${production.proNo }">${production.proName }</option>
						</c:forEach>
				</select></td>  
			</tr>

			<tr>
				<td><input type="submit" value="등록"></td>
				<td><input type="reset" value="리셋"></td>
			</tr>

		</table>
	</form>
</body>
</html>