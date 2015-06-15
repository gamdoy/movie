<%@ page contentType = "text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
<style type="text/css">
table{
width: 80%;
border: 1px solid gray;
border-spacing:10px;
}
td{
padding: 10px;
border-width 10px;
text-align:center;
width:100px;
height:50px;
border: 1px solid blue;

}

</style>


</head>
<body>
	<table id="list1" >
	<c:forEach items="${requestScope.movie }" var="movie" varStatus="idx">
               <c:if test="${idx.index%4==0 }">
                  <tr>
               </c:if>
                     <td width="15" height="20" align="center">
                        <div style="width:200;">
                           <div onclick="location.href='<%=request.getContextPath()%>/movie/user_movie_info.do?movNo='+${movie.movieNo }">
                              <c:choose>
                                 <c:when test="${empty reqestScope.movie.posterName }">
                                    <img src="<%=request.getContextPath()%>/images/movie/noimage.png">
                                 </c:when>
                                 <c:otherwise>
                                    <img src="<%=request.getContextPath()%>/images/movie/${reqestScope.movie.posterName }">
                                 </c:otherwise>
                              </c:choose>
                           </div>
                           
                           <div style="color: black;">
                              ${movie.title }
                           </div>
                           
                           <div style="color: black;">
                              ${movie.intheaters }~${eventVO.runtime }
                           </div>
                        </div>
                     </td>
               <c:if test="${(idx.index+1)%4==0 }">
                  </tr>
               </c:if>
               </c:forEach>
	</table>
	
	<span onclick="moreList()">더보기</span>
	<table hidden="true" id="list2">
	<tr>
	<td>111<br>1111</td>
	<td>222</td>
	<td>333</td>
	<td>444</td>
	</tr>
	<tr>
	<td>111</td>
	<td>222</td>
	<td>333</td>
	<td>444</td>
	</tr>
	</table>
	
</body>
</html>