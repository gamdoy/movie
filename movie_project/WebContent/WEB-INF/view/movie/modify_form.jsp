<%@ page contentType = "text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 수정</title>
</head>
<body>
<h1>영화 정보 수정<br>
</h1>
<form method="post"
		action="<%=request.getContextPath()%>/movie/register.do"
		id="modifyForm" name="modifyForm" enctype="multipart/form-data"
		onsubmit="return submitCheck();">
		
		<table>
			<tr>
				<!-- 제목 -->
				<td>제목</td>
				<td colspan="3"><input type="text" id="title" name="title"
					autofocus="autofocus"
					value="${requestScope.movie.title }"></td>
			</tr>
			<tr>
				<!-- 줄거리 -자동 줄넘김 적용 -->
				<td>줄거리</td>
				<td colspan="3"><textarea name="sysnopsis"
						style="resize: none; wrap: hard;" rows="12" cols="70">
						${requestScope.movie.sysnopsis }</textarea></td>
			</tr>

			<tr>
				<!-- 상영등급 -->
				<td>상영등급</td>
				<td><select name="screeningGrade" id="screeningGrade">
						<c:forEach items="${screenGrade }" var="sgrade">
							
							<option value="${sgrade.cmnNo }"
							 ${requestScope.movie.screeningGrade==sgrade.cmnNo? 'selected="selected"':""}>
							${sgrade.cmnCodeKor }</option>
						</c:forEach>
				</select>
				
				 <!-- 장르 -->
				<td>장르</td>
				<td width="50"><select name="genre" id="genre">
						<c:forEach items="${genre }" var="genre">
							<option value="${genre.cmnNo }"
							 ${requestScope.movie.genre==genre.cmnNo? 'selected="selected"':""}>
							${genre.cmnCodeKor }</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<!-- 영화감독 -->
				<td>감독</td>
				<td><select name="dirNo" id="dirNo">

						<c:forEach items="${dirNo }" var="dir">
							<option value="${dir.dirNo }"
							${requestScope.movie.dirNo==dir.dirNo? 'selected="selected"':""}>
							${dir.dirName }</option>
						</c:forEach>
				</select></td>
				<!-- 배우 -->
				<td>배우</td>
				<td><select name="actNo" id="actNo">
						<c:forEach items="${actNo }" var="act">
							<option value="${act.actNo }"
							${requestScope.movie.actNo==act.actNo? 'selected="selected"':""}>
							${act.actName }</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<!-- 제작사 -->
				<td>제작사</td>
				<td><select name="proNo" id="proNo">
						<c:forEach items="${proNo }" var="pro">
							<option value="${pro.proNo }"
							${requestScope.movie.proNo==pro.proNo? 'selected="selected"':""}>
							${pro.proName }</option>
						</c:forEach>
				</select></td>
				<!-- 포스터 -->
				<td>포스터</td>
				<td><input type="file" name="poster">
					<br>
					<img src="<%=request.getContextPath()%>/images/${requestScope.movie.posterName }">
				</td>
			</tr>

			<tr>
				<!-- 공식홈 -->
				<td>공식홈</td>
				<td><input type="text" name="officialSite" id="officialSite"
					 value="${requestScope.movie.officialSite }"></td>
				<!-- 트레일러 -->
				<td>트레일러</td>
				<td><input type="text" name="trailer" id="trailer"
					 value="${requestScope.movie.trailer }"></td>
			</tr>

			<tr>
				<!-- 개봉일 -->
				<td>개봉일</td>
				<td><input type="text" name="intheaters"
					 value="${requestScope.movie.intheaters }"><br> <input
					type="button" value="달력 선택"
					onClick="datePicker(event,'intheaters')"></td>
				<!-- 상영시간 -->
				<td>상영시간</td>
				<td><input type="number" name="runtime"
					 value="${requestScope.movie.runtime }"></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="수정"></td>
				<td><input type="reset" value="리셋"></td>
			</tr>
		</table>
		<span style="background-color:#00FEFE">
		<a href="<%=request.getContextPath()%>/movie/adminmovie_list.do"> 리스트 </a>
		</span>
	</form>
</body>
</html>