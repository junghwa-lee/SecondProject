<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#videoLink{
		transition-property: background-color;
		transition-duration: 0.5s;
	}

	#videoLink:hover{
		background-color: #C2EDFC;
		border-radius: 5px;
		cursor: pointer;
	}
</style>
</head>
<body>
			<c:forEach var="vo" items="${vlist }">
				
				<div id="videoLink">
				
					<div class="single-recent mb-100" style="padding: 10px;" >
						<a href="../newsTipVideo/videodetail.do?no=${vo.v_no }">
					         <div class="what-img">
					             <img src="${vo.v_poster }" alt="">
					         </div>
					         <div class="what-cap">
					             <h4 style="font-size:12px;"><a href="../newsTipVideo/videodetail.do?no=${vo.v_no }">${vo.v_title }</a></h4>
					         </div>
				         </a>
				     </div>
				 
				 </div>
				 
			</c:forEach>
</body>
</html>