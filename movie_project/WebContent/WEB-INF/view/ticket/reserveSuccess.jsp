<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/jquery.js"></script>
<script type="text/javascript">
function goReservePage() {
	window.location = "<%=request.getContextPath() %>/theater/movieSchedule.do";
}
</script>
<h2>예매 성공</h2>
상영 시간 : ${ticket.ticDate}
결제 금액 : ${ticket.ticPrice * ticket.ticTotalcustomer}
좌석 정보 : ${fn:replace(ticket.ticSeatno, "|", " ")}
<br>
<input type="button"value="예매페이지로" onclick="goReservePage();">