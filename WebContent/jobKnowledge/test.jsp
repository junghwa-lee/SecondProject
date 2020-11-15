<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		var bno = 
		
	})
	
</script>
</head>
<body>
	<div class="col-lg-12" style="background-color: #E9E9E9; border-radius: 5px; height: 1700px;">
		
	<c:forEach var="i" begin="1" end="5">	
	
		<input type=button id="a${i }">
		
		<input tyle=textarea value="입력${i }" id="b${i }"> 
	
	
	</c:forEach>
	</div>
</body>
</html>