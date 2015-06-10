<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제목 : ${requestScope.title } <br>
정보 : ${requestScope.info }<br>
파일 명 : ${requestScope.filename }<br>
파일 크기 : ${requestScope.filesize }<br>
<image src="/movie_project/upimage/${requestScope.filename }">
</body>
</html>