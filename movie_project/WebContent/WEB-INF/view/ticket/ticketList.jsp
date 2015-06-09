<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
  <thead>
  </thead>
  <tbody>
  	<c:forEach items="${ticketList}" var="ticket" varStatus="idx">
	  	<tr>
	  		<td>${idx.index+1 }</td>
	  		<td>${ticket.ticNo }</td>
	  		<td>${ticket.memId }</td>
	  		<td>${ticket.movTitle }</td>
	  		<td>${ticket.ticDate }</td>
	  		<td>${ticket.mrName }</td>
	  		<td>${ticket.theaLocation }</td>
	  		<td>${ticket.ticPaytypename }</td>
	  		<td>${ticket.ticStatusname }</td>
	  	</tr>
  	</c:forEach>
  </tbody>
</table>
