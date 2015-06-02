<%@ page contentType= "text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function goUrl(){
	window.location="<%=request.getContextPath() %>/qa/qa.do";
}
</script>
</head>
<body>
<table>
  <tr>
   <td>
   <table>
     <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td><input  type="text" name="title" size="70" maxlength="100"></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td align="center">이름</td>
      <td><input  type="text" name="name" size="10" maxlength="50" value="ID">          비밀번호 : <input type="text" name="password" size="10"></td>
     
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
  	 <tr>
      <td>&nbsp;</td>
      <td align="center">파일</td>
      <td><input type="file" name="upfile" size="50"> </td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea name="memo" cols="50" rows="13"></textarea></td>
      <td>&nbsp;</td>
     </tr>
     <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
     <tr align="center">
      <td>&nbsp;</td>
      <td colspan="2"><input type="submit" value="등록">
       <input type=button value="취소" onclick="goUrl();">
      <td>&nbsp;</td>
     </tr>
    </table>
   </td>
  </tr>
 </table>

</body>
</html>