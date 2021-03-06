<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<meta charset="UTF-8">

<script type="text/javascript"
   src="<%=request.getContextPath()%>/script/jquery.js"></script>
<script type="text/javascript"
   src="<%=request.getContextPath()%>/script/date_picker.js"></script>
<!-- css -->
<style type="text/css">
table, td {
   dorfer: 1px;
}

table {
   width: 50%;
   height: 100px;
   magin: auto;
   text-align: center;
}
</style>


<script type="text/javascript">
   /* db 컬럼 크기
    * 제목 20
    * 줄거리 무제한
    * 공식홈 50
    * 트레일러 50
    * 
    *
    */
   
   
   
   function submitCheck() {
      var flag = true;
      $("#registerForm input,textarea").each(function(){
         if(!$(this).val()) {
            alert('['+$(this).parent().prev().html()+"] 항목은 필수 입력사항 입니다");
            flag = false;
            return false;
         } 
      return flag;
      });
      $("select").each(function(){
         if(this.selectedIndex==0){
         alert('['+this.options[0].text+"] 항목은 필수 입력사항 입니다");
            flag = false;
            return false;
         }
      }); 
      return flag;
   }

   $(document).ready(function() {

      /* 글자수 체크 */
      $("#title").on("blur", function() {
         var a = $(this).val();
         if (a.length >= 10) {
            alert("10글자 이하로 입력하세요");
            $(this).focus();
         }
      });
      $("#officialSite").on("blur", function() {
         var a = $(this).val();
         if (a.length >= 50) {
            alert("영문 50글자 이하로 입력하세요");
            $(this).focus();
         }
      });
      $("#trailer").on("blur", function() {
         var a = $(this).val();
         if (a.length >= 50) {
            alert("영문 50글자 이하로 입력하세요");
            $(this).focus();
         }
      });

      /* select문 0번값 체크      */
      $("#screeningGrade").on("change", function() {
         var a = $(this).val();
         if (a == 104000) {
            alert("상영 등급을 선택해 주세요");
            $(this).focus();
         }
      });
      
      $("#genre").on("change", function() {
         var a = $(this).val();
         if (a == 110000) {
            alert("장르를 선택해 주세요");
            $(this).focus()
         }
      });
      
      $("#dirNo").on("change", function() {
         var a = $(this).val();
         if (a == 1) {
            alert("감독을 선택해 주세요");
            $(this).focus();
         }
      });
      $("#actNo").on("change", function() {
         var a = $(this).val();
         if (a == 1) {
            alert("배우를 선택해 주세요");
            $(this).focus();
         }

      });
      $("#proNo").on("change", function() {
         var a = $(this).val();
         if (a == 1) {
            alert("제작사를 선택해 주세요");
            $(this).focus();
         }
      });
      
   });
</script>


   <h1>영화등록</h1>

   <form method="post"
      action="<%=request.getContextPath()%>/movie/register.do"
      id="registerForm" name="registerForm" enctype="multipart/form-data"
      onsubmit="return submitCheck();">

      <table>
         <tr>
            <!-- 제목 -->
            <td>제목</td>
            <td colspan="3"><input type="text"  name="title" id="title"
               autofocus="autofocus"> </td>
         </tr>
         <tr>
            <!-- 줄거리 -자동 줄넘김 적용 -->
            <td>줄거리</td> 
            <td colspan="3"><textarea name="sysnopsis" 
                  style="resize: none; wrap: hard;" rows="12" cols="70" id="sysnopsis"></textarea></td>
         </tr>

         <tr>
            <!-- 상영등급 -->
            <td>상영등급</td>
            <td><select name="screeningGrade" >
                  <c:forEach items="${screenGrade }" var="sgrade">
                     <option value="${sgrade.cmnNo }">${sgrade.cmnCodeKor }</option>
                  </c:forEach>
            </select> <!-- 장르 -->
            <td>장르</td>
            <td width="50"><select name="genre" >
                  <c:forEach items="${genre }" var="genre">
                     <option value="${genre.cmnNo }">${genre.cmnCodeKor }</option>
                  </c:forEach>
            </select></td>
         </tr>

         <tr>
            <!-- 영화감독 -->
            <td>감독</td>
            <td><select name="dirNo" >

                  <c:forEach items="${dirNo }" var="dir">
                     <option value="${dir.dirNo }">${dir.dirName }</option>
                  </c:forEach>
            </select></td>
            <!-- 배우 -->
            <td>배우</td>
            <td><select name="actNo" id="배우">
                  <c:forEach items="${actNo }" var="act">
                     <option value="${act.actNo }">${act.actName }</option>
                  </c:forEach>
            </select></td>
         </tr>

         <tr>
            <!-- 제작사 -->
            <td>제작사</td>
            <td><select name="proNo" id="제작사">
                  <c:forEach items="${proNo }" var="pro">
                     <option value="${pro.proNo }">${pro.proName }</option>
                  </c:forEach>
            </select></td>
            <!-- 포스터 -->
            <td>포스터</td>
            <td ><input type="file" name="poster"></td>
         </tr>

         <tr>
            <!-- 공식홈 -->
            <td>공식홈페이지</td>
            <td><input type="text" name="officialSite" id=officialSite
               placeholder=""></td>
            <!-- 트레일러 -->
            <td>트레일러</td>
            <td><input type="text" name="trailer" id=trailer ></td>
         </tr>

         <tr>
            <!-- 개봉일 -->
            <td>개봉일</td>
            <td><input type="text" name="intheaters" onClick="datePicker(event,'intheaters')" readonly="readonly"> </td>
            <!-- 상영시간 -->
            <td>상영시간</td>
            <td><input type="number" name="runtime" style="width:15%;">분</td>
         </tr>

         <tr>
            <td colspan="3"><input type="submit" value="등록"></td>
            <td><input type="reset" value="리셋"></td>
         </tr>

      </table>
   </form>