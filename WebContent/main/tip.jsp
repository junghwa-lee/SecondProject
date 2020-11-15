<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#tipLink{
		transition-property: background-color;
		transition-duration: 0.5s;
	}
	#tipLink:hover{
		background-color: #C2EDFC;
		border-radius: 5px;
		cursor: pointer;
	}
</style>
</head>
<body>
		<div style="height:70px; width:100%; padding: 15px;">
		<h3 style="display: inline; font-weight:bold;">꿀팁</h3>
             <div style="margin-left: 200px;display: inline;text-align: right;">
		       	<input type=button value=더보기 onclick="location.href='../newsTipVideo/tip.do'" class="more"
		       			style="font-size:13px;">
		       </div>
		</div>
		

		<c:forEach var="tvo" items="${tlist }">
		
		
	   		<div class="trand-right-single d-flex" style="padding:10px;" id="tipLink">
	   			<a href="../newsTipVideo/tipdetail.do?no=${tvo.t_no }">
	   		
	            <div class="trand-right-img">
	                <img  src="${tvo.t_poster}">
	            </div>
	            <div class="trand-right-cap">
	                <!-- <span class="color1">자기소개서</span> -->
	                <h5 style="font-size: 12px;"><a href="../newsTipVideo/tipdetail.do?no=${tvo.t_no }">${tvo.t_title }</a></h5>
	            </div>
	            
	        	 </a>
	        </div>
	   
	   	</c:forEach>
</body>
</html>