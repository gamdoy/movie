<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/jquery.js"></script>
<style type="text/css">
table{
text-align: center;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$.each($("#searchType").children(), function() {
		if($(this).val() == "${searchVO.searchType }"){
			$(this).prop("selected", "selected");
		}
	});
});
</script>
<form method="post"
		action="<%=request.getContextPath()%>/movie/adminmovie_list.do"
		id="registerForm" name="registerForm" enctype="multipart/form-data"	>
	<table id="list" style="width: 700px">
		<thead>
			<tr>
				<td>번호</td>
				<td>영화제목</td>
				<td>장르</td>
				<td>감독</td>
				<td>배우</td>
				<td>제작사</td>
				<td>개봉일</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${requestScope.moviePaging.movie }" var="movie">
				<tr onClick="location.href='<%=request.getContextPath()%>/movie/modify_form.do?movNo='+${movie.movieNo }"
						style="cursor: pointer;">
					<td>${movie.movieNo }</td>
					<td>${movie.title }</td>
					<td>${movie.genreName }</td>
					<td>${movie.dirName }</td>
					<td>${movie.actName }</td>
					<td>${movie.proName }</td>
					<td>${movie.intheaters }</td>
				</tr>
			</c:forEach>
		</tbody>

		<tfoot>
		<tr>
		 <td colspan="7">
			<span>
			 <!-- 페이징 처리 --> 
			 <!-- 이전 페이지 그룹 -->
			  <c:choose>
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
							<b>${pageNum}</b>
						</c:when>
						<c:otherwise>
							<a	href="<%=request.getContextPath() %>/movie/adminmovie_list.do?pageNo=${pageNum}">
								<font color="black">${pageNum}</font>
							</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> <!-- 다음 페이지 그룹 --> <c:choose>
					<c:when test="${moviePaging.pagingBean.nextPageGroup }">
						<a href="<%=request.getContextPath() %>/movie/adminmovie_list.do?pageNo=${moviePaging.pagingBean.endPageOfPageGroup+1}">▶</a>
					</c:when>
					<c:otherwise>	▶
					</c:otherwise>
				</c:choose>

			</span>
			<span style="float: right;"> 
				<select	name="searchType" id="searchType" >
							<option value="mov_title" >영화제목</option>
							<option value="genre_name" >장르</option>
							<option value="dir_name">감독</option>
							<option value="act_name">배우</option>
							<option value="pro_name">제작사</option>
				</select> 
				<input type="text" id="searchKeyword" name="searchKeyword" value="${searchVO.searchKeyword }">
				<input type="submit" value="검색">
				<input type="button" name="callList" onclick="location.href='<%=request.getContextPath()%>/movie/adminmovie_list.do'" value="목록">
				</span>
			</td>
		</tr>
	</tfoot>
  </table>
 </form>

