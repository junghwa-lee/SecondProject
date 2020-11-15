<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
	#jobLink{
		transition-property: background-color;
		transition-duration: 0.5s;
	}

	#jobLink:hover{
		background-color: #C2EDFC;
		border-radius: 5px;
		font-size: 20px;
		font-weight: bold;
	}
</style>
</head>
<body>

		
		<c:forEach var="jvo" items="${jlist }">
		
               		<a href="../jobKnowledge/detail.do?no=${jvo.no }" style="color:black; width:100%;" id="jobLink">
	              		<div class="jobArea" style="height:90px; width:100%; padding:10px;">
	              			
		              			<c:if test="${fn:length(jvo.subject)>18 }">											<!-- 제목 -->
		              				<span style="font-size: 20px;">${fn:substring(jvo.subject, 0, 18) }...</span>
		              			</c:if>
		              			<c:if test="${fn:length(jvo.subject)<=18 }">
		              				<span style="font-size: 20px;">${jvo.subject}</span>
		              			</c:if>
		              			
		              			<div class="jobhit" style="text-align: right;">										<!-- 조회수 -->
		              				<span style="font-size: 13px;">조회  ${jvo.hit }</span>
		              			</div>
	              			
	              		</div>
                    </a>
                    
                
         </c:forEach>
</body>
</html>