<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">


</script>
<style type="text/css">
table{
border: 1px solid gray;
border-spacing:10px;
}
td{
border-width 10px;
text-align:center;
width:100px;
height:50px;

}

</style>

	<h1>관심영화</h1>
	<table>
	<c:forEach items="${requestScope.movie }" var="movie" varStatus="idx">
               <c:if test="${idx.index%4==0 }">
                  <tr>
               </c:if>
                     <td width="15" height="20" align="center">
                        <div style="width:200;">
                           <div onclick="location.href='<%=request.getContextPath()%>/movie/user_movie_info.do?movNo='+${movie.movieNo }">
                              <c:choose>
                                 <c:when test="${empty movie.posterName }">
                                    <img src="<%=request.getContextPath()%>/images/movie/noimage.png">
                                 </c:when>
                                 <c:otherwise>
                                    <img src="<%=request.getContextPath()%>/images/movie/${movie.posterName }">
                                 </c:otherwise>
                              </c:choose>
                           </div>
                           
                           <div style="color: black;">
                              ${movie.title }
                           </div>
                           
                        </div>
                     </td>
               <c:if test="${(idx.index+1)%4==0 }">
                  </tr>
               </c:if>
               </c:forEach>
	</table>