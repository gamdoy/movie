<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/jQuery_class/jquery.js"></script>
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
			<c:forEach items="${requestScope.movie }" var="movie">
				<tr>
					<td>${movie.movieNo }</td>
					<td align="center" onClick="location.href='<%=request.getContextPath()%>/movie/modify_form.do?movNo='+${movie.movieNo }" style="cursor:pointer;">
					${movie.title }</td>
					<td>${movie.genreName }</td>
					<td>${movie.dirName }</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>