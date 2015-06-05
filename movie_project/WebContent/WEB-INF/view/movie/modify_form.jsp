<%@ page contentType = "text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript"	src="<%=request.getContextPath()%>/script/jquery.js"></script>
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
	
	
	function submitCheck() {
		var flag = true;
		
		$("#modifyForm input,textarea").each(function(){
			if(!$(this).val()){
				alert('['+$(this).prop("name")+"] 항목은 필수 입력사항 입니다");
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
		if(${requestScope.movie.success==1 }){
			alert("수정 성공");
		}
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

		/* select문 0번값 체크		*/
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
<h1>영화 정보 수정<br>
<br>
</h1>
<form method="post"
		action="<%=request.getContextPath()%>/movie/modify_success.do"
		id="modifyForm" name="modifyForm" enctype="multipart/form-data" onsubmit="return submitCheck();">
		
	
<input type="hidden" id="movieNo" name="movieNo" value="${requestScope.movie.movieNo }">
		<table>
			<tr>
				<!-- 제목 -->
				<td>제목</td>
				<td colspan="3"><input type="text" id="title" name="title"
					autofocus="autofocus"
					value="${requestScope.movie.title }" ></td>
			</tr>
			<tr>
				<!-- 줄거리 -자동 줄넘김 적용 -->
				<td>줄거리</td>
				<td colspan="3"><textarea name="sysnopsis"
						style="resize: none; wrap: hard;" rows="12" cols="70">${requestScope.movie.sysnopsis }</textarea></td>
			</tr>

			<tr>
				<!-- 상영등급 -->
				<td>상영등급</td>
				<td><select name="screeningGrade" id="screeningGrade">
						<c:forEach items="${screenGrade }" var="sgrade">
							
							<option value="${sgrade.cmnNo }"
							 ${requestScope.movie.screeningGrade==sgrade.cmnNo? 'selected="selected"':""}>
							${sgrade.cmnCodeKor }</option>
						</c:forEach>
				</select>
				
				 <!-- 장르 -->
				<td>장르</td>
				<td width="50"><select name="genre" id="genre">
						<c:forEach items="${genre }" var="genre">
							<option value="${genre.cmnNo }"
							 ${requestScope.movie.genre==genre.cmnNo? 'selected="selected"':""}>
							${genre.cmnCodeKor }</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<!-- 영화감독 -->
				<td>감독</td>
				<td><select name="dirNo" id="dirNo">

						<c:forEach items="${dirNo }" var="dir">
							<option value="${dir.dirNo }"
							${requestScope.movie.dirNo==dir.dirNo? 'selected="selected"':""}>
							${dir.dirName }</option>
						</c:forEach>
				</select></td>
				<!-- 배우 -->
				<td>배우</td>
				<td><select name="actNo" id="actNo">
						<c:forEach items="${actNo }" var="act">
							<option value="${act.actNo }"
							${requestScope.movie.actNo==act.actNo? 'selected="selected"':""}>
							${act.actName }</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<!-- 제작사 -->
				<td>제작사</td>
				<td><select name="proNo" id="proNo">
						<c:forEach items="${proNo }" var="pro">
							<option value="${pro.proNo }"
							${requestScope.movie.proNo==pro.proNo? 'selected="selected"':""}>
							${pro.proName }</option>
						</c:forEach>
				</select></td>
				<!-- 포스터 -->
				<td>포스터</td>
				<td><input type="file" name="poster" >
					<span>
					등록된 포스터<br>
				<img src="<%=request.getContextPath()%>/images/${requestScope.movie.posterName }">
				</span>
				</td>
			</tr>

			<tr>
				<!-- 공식홈 -->
				<td>공식홈</td>
				<td><input type="text" name="officialSite" id="officialSite"
					 value="${requestScope.movie.officialSite }"></td>
				<!-- 트레일러 -->
				<td>트레일러</td>
				<td><input type="text" name="trailer" id="trailer"
					 value="${requestScope.movie.trailer }"></td>
			</tr>

			<tr>
				<!-- 개봉일 -->
				<td>개봉일</td>
				<td><input type="text" name="intheaters"
					 value="${requestScope.movie.intheaters }"><br> <input
					type="button" value="달력 선택"
					onClick="datePicker(event,'intheaters')"></td>
				<!-- 상영시간 -->
				<td>상영시간</td>
				<td><input type="number" name="runtime"
					 value="${requestScope.movie.runtime }"></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="수정"></td>
				<td><input type="reset" value="리셋"></td>
			</tr>
		</table>
		<span style="background-color:#00FEFE">
		<a href="<%=request.getContextPath()%>/movie/adminmovie_list.do"> 리스트 </a>
		</span>
	</form>