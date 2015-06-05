<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
  <thead>
  </thead>
  <tbody>
  	<c:forEach items="${ticketList}" var="tikcet" varStatus="idx">
	  	<tr>
	  		<td>${idx.index+1 }</td>
	  		<td>${tikcet.ticNo }</td>
	  		<td>${tikcet.ticDate }</td>
	  		<td>${tikcet.ticNo }</td>
	  	</tr>
  	</c:forEach>
  </tbody>
</table>
