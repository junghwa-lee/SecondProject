<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#annLink{
		transition-property: background-color;
		transition-duration: 0.5s;
	}
	#annLink:hover{
		background-color: #C2EDFC;
		border-radius: 5px;
		cursor: pointer;
	}
</style>
</head>
<body>
		<div style="height:70px; width:100%; padding: 15px;">
		<h3 style="display: inline; font-weight:bold;">인기 공고</h3>
             <div style="margin-left: 585px;display: inline;text-align: right;">
		       	<input type=button value=더보기 onclick="location.href='#'" class="more"
		       			style="font-size:13px;">
		       </div>
		</div>
		
		<c:forEach var="vo" items="${list }" varStatus="s">
		
			<div class="col-lg-4" style="padding:10px;" id="annLink">
				<a href="../Workb/detail.do?l_no=${vo.l_no }">
				    <div class="single-bottom mb-35">
				    	
				        <div class="trend-bottom-img mb-30">
				            <img src="../image/Screenshot_${s.count }.png">
				        </div>
				        <div class="trend-bottom-cap">
				            <span class="color1">${vo.lname }</span>
				            <h4 style="font-size: 15px;"><a href="#">${vo.ltitle }</a></h4>
				        </div>
				    </div>
			    </a>
		    </div>
		
		</c:forEach>
</body>
</html>