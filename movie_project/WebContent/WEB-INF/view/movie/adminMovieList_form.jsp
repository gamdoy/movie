<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/jquery.js"></script>
<style type="text/css"></style>
<script type="text/javascript"></script>

</head>
<body>
	<table id="list" style="width: 700px">
		<thead>
			<tr>
				<td>번호</td>
				<td>영화제목</td>
				<td>장르</td>
				<td>감독</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${requestScope.moviePaging.movie }" var="movie">
				<tr>
					<td>${movie.movieNo }</td>
					<td align="center"
						onClick="location.href='<%=request.getContextPath()%>/movie/modify_form.do?movNo='+${movie.movieNo }"
						style="cursor: pointer;">${movie.title }</td>
					<td>${movie.genreName }</td>
					<td>${movie.dirName }</td>
				</tr>
			</c:forEach>
		</tbody>

		<tfoot>
		<tr>
		 <td colspan="4">
			<span>
			 <!-- 페이징 처리 --> <!-- 이전 페이지 그룹 --> <c:choose>
					<c:when test="${moviePaging.pagingBean.previousPageGroup }">
						<a href="${initParam.rootPath }/movie/adminmovie_list.do?pageNo=${moviePaging.pagingBean.startPageOfPageGroup-1}">◀</a>
					</c:when>
					<c:otherwise>	◀ 
					</c:otherwise>
				</c:choose> <!-- 페이지 번호 --> <c:forEach
					begin="${moviePaging.pagingBean.startPageOfPageGroup }"
					end="${moviePaging.pagingBean.endPageOfPageGroup}" var="pageNum">
					<c:choose>
						<c:when test="${pageNum == moviePaging.pagingBean.currentPage }">
							<b>[${pageNum}]</b>
						</c:when>
						<c:otherwise>
							<a	href="<%=request.getContextPath() %>/movie/adminmovie_list.do?pageNo=${pageNum}">
								<font color="black">${pageNum}</font>
							</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> <!-- 다음 페이지 그룹 --> <c:choose>
					<c:when test="${moviePaging.pagingBean.nextPageGroup }">
						<a
							href="<%=request.getContextPath() %>/movie/adminmovie_list.do?pageNo=${moviePaging.pagingBean.endPageOfPageGroup+1}">▶</a>
					</c:when>
					<c:otherwise>	▶
					</c:otherwise>
				</c:choose>

			</span>
			<span style="float: right;"> 
				<select	name="search">
							<option value="일번">일번</option>
				</select> <input type="text" id="searchBy"> <input type="submit"
						value="검색">
				</span>
			</td>
		</tr>
		</tfoot>
	</table>
</body>
</html>
