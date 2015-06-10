<%@ page contentType= "text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<head>

<meta charset="UTF-8">
<title>QA게시판</title>



<script type="text/javascript">
$(document).ready(function(){
	$("tbody tr").on("click", function(){
		
		var number = $(this).find(":first-child").text();
		if($(this).find(":first-child").next().prop("class")=="secret"){
			var password = prompt('비밀번호를 입력하세요',"");
			
			if(!($("#secret" + number).val()==password)){
				alert("비밀번호가 옳바르지 않습니다.");
				return false;
			}
		}
		location.href="<%=request.getContextPath()%>/qa/selectQa.do?number="+number;
	})
});
</script>

<script type="text/javascript">
function goUrl(){
	window.location="<%=request.getContextPath() %>/qa/write.do";
}
</script>

<script type="text/javascript">
$(document).ready(function(){
		$("#searchForm").on("submit", function(){
			if(!$("#searchKeyword").val().trim()){
				alert("값을 입력하세요");
				$("#searchKeyword").focus();
				return false;
		}
	});
});
</script>

</head>
<!-- CSS 영역 -->
    <style type="text/css">
        * {font-size: 9pt;}
        p {width: 600px; text-align: right;}
        table thead tr th {background-color: gray;}
    </style>
  
 <!-- //CSS 영역 -->
   
    </head>
       <!-- 검색 폼 영역 -->
       <form name="searchForm" method="post" id="searchForm" action="<%=request.getContextPath() %>/qa/getQaByKeyword.do">
       <p>
           <select name="searchType" id="searchType">
            	  <option value="qa_title">제목</option>
              	 <option value="WRITER">작성자</option>
                 <option value="qa_text">내용</option>
           </select>
           <input type="text" name="searchKeyword" id="searchKeyword">
           <input type="submit" id="QaSearch" value="검색">
       </p>
       </form>
       
       <!-- 게시판 목록 영역 -->
       <table border="1" summary="게시판 목록">
           
           <colgroup>
               <col width="50" />
               <col width="300" />
               <col width="80" />
               <col width="100" />
               <col width="70" />
           </colgroup>  
           <thead>
               <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록 일시</th>
                    <th>조회수</th>
               </tr>
           </thead>
           <tbody>
           	<c:forEach items="${requestScope.pageMap.qa_list }" var="QaVO">
				<tr id="qa_content">
				
					<td>${QaVO.fqNo}</td>
					<c:choose>
						<c:when test="${QaVO.qaSecret=='use' }">
							<td class="secret"><input type="hidden" id="secret${QaVO.fqNo }" value="${QaVO.qaPassword }">
							<img src="<%=request.getContextPath()%>/upload/kgpg.png" width="10px" height="10px">${QaVO.qaTitle}</td> 
						</c:when>
						<c:otherwise>
							<td>${QaVO.qaTitle}</td> 
						</c:otherwise>
					</c:choose>
					<td>${QaVO.memNo}</td>
					<td>${QaVO.fqLastdate}</td>
					<td>${QaVO.qaCount}</td>
				</tr> 
			</c:forEach>
           </tbody>
           <tfoot>
               <tr>
                    <td align="center" colspan="5">
                    <c:choose>

	<c:when test="${pageMap.pagingBean.previousPageGroup }">

		<a href="<%=request.getContextPath() %>/qa/qa.do?page=${pageMap.pagingBean.startPageOfPageGroup-1}"><font color="black">◀</font></a>

	</c:when>

	<c:otherwise>

		◀

	</c:otherwise>

</c:choose>	

 

<!-- 페이지 번호 -->

<c:forEach begin="${pageMap.pagingBean.startPageOfPageGroup }" end="${pageMap.pagingBean.endPageOfPageGroup}" var="pageNum">

	<c:choose>

		<c:when test="${pageNum == pagingBean.currentPage }">

			<b>[${pageNum}]</b>

		</c:when>

		<c:otherwise>

			<a  href="<%=request.getContextPath() %>/qa/qa.do?page=${pageNum}">

				<font color="black">${pageNum}</font>

			</a>

		</c:otherwise>

	</c:choose>

	&nbsp;&nbsp;

</c:forEach>

<!-- 다음 페이지 그룹 -->

<c:choose>

	<c:when test="${pageMap.pagingBean.nextPageGroup }">

		<a href="<%=request.getContextPath() %>/qa/qa.do?page=${pageMap.pagingBean.endPageOfPageGroup+1}"><font color="black">▶</font></a>

	</c:when>

	<c:otherwise>

		▶

	</c:otherwise>

</c:choose>
                    
                    </td>
             	</tr>
           </tfoot>
       </table>
       <!-- //게시판 목록 영역 -->
       <!-- 버튼 영역 -->
       <p>
           <input type="button" value="글쓰기" onclick="goUrl()"/>
       </p>
       <!-- //버튼 영역 -->
 
