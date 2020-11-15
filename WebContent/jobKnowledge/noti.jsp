<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.notiDiv{
	background-color: #E77070; 
	padding:5px;
	border-radius: 5px;
	transition-property: background-color;
	transition-duration: 0.3s;
}
.notiDiv:hover{
	background-color: #E54141;
	cursor: pointer;
}
</style>
</head>
<body>
	<c:if test="${noti_list != null }">
		<c:forEach var="noti_vo" items="${noti_list }">
			<div>
				<c:if test="${fn:length(noti_vo.subject)>10 }">
					<div class="notiDiv" onclick="location.href='../jobKnowledge/declineNoti.do?no=${noti_vo.no }'">
					<%-- <a href="../jobKnowledge/declineNoti.do?no=${noti_vo.no }" style="text-decoration: none; color:white; background-color: #FF4A4A;"> --%>
					<span class="answer_box_header_title" style="font-size: 10pt; color:white;">${fn:substring(noti_vo.subject, 0, 10) }..글에 ${noti_vo.noti }개의 새로운 답변</span>
					<!-- </a> -->
					</div>
				</c:if>
				<c:if test="${fn:length(noti_vo.subject)<=10 }">
					<div class="notiDiv" onclick="location.href='../jobKnowledge/declineNoti.do?no=${noti_vo.no }'">
					<%-- <a href="../jobKnowledge/declineNoti.do?no=${noti_vo.no }" style="text-decoration: none; color:white; background-color: #FF4A4A;"> --%>
					<span class="answer_box_header_title" style="font-size: 10pt; color:white;">${noti_vo.subject }글에 ${noti_vo.noti }개의 새로운 답변</span>
					<!-- </a> -->
					</div>
				</c:if>
			
			</div>
		</c:forEach>
	</c:if>
</body>
</html>