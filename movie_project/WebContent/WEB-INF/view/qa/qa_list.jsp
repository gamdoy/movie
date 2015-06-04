<%@ page contentType= "text/html;charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>QA게시판</title>

<script type="text/javascript">
function goUrl(){
	window.location="<%=request.getContextPath() %>/qa/write.do";
}
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
    <body>
       <!-- 검색 폼 영역 -->
       <form name="searchForm" action="" method="get">
       <p>
           <select name="searchType">
               <option value="ALL">전체검색</option>
               <option value="SUBJECT">제목</option>
               <option value="WRITER">작성자</option>

           </select>
           <input type="text" name="searchText" value="" />
           <input type="submit" value="검색" />
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
         			<td align="center" colspan="5">글리스트페이지</td>
           </tbody>
           <tfoot>
               <tr>
                    <td align="center" colspan="5">페이징페이지</td>
               </tr>
           </tfoot>
       </table>
       <!-- //게시판 목록 영역 -->
       <!-- 버튼 영역 -->
       <p>
           <input type="button" value="글쓰기" onclick="goUrl()"/>
       </p>
       <!-- //버튼 영역 -->
    </body>
</html>