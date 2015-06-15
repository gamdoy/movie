<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	if("${error_message}"!=""){
		alert("${error_message}");
	}
});
</script>
<h1>메인페이지</h1>
${sessionScope.login_info.memId} 님. 환영합니다.
<iframe width="854" height="510" src="https://www.youtube.com/embed/Ricl9FWSxXc" frameborder="0" allowfullscreen></iframe>