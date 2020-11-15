<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#gongmoLink{
		padding:15px;
		transition-property: background-color;
		transition-duration: 0.5s;
	}
	#gongmoLink:hover{
		background-color: #C2EDFC;
		border-radius: 5px;
		cursor: pointer;
	}

</style>
</head>
<body>
		<h3 style="display: inline; font-weight:bold;">공모전</h3>
             <div style="margin-left: 585px;display: inline;text-align: right;">
		       	<input type=button value=더보기 onclick="location.href='../gongmo/gongmo_all.do'" class="more"
		       			style="font-size:13px;">
		       </div>
		</div>
			<c:forEach var="vo" items="${glist }">
			
					<div class="col-lg-6 col-md-6" id="gongmoLink">
						<a href="../gongmo/gongmo_detail.do?no=${vo.gm_no }">
	                          <div class="single-what-news mb-100">
	                              <div class="what-img">
	                                  <img src="${vo.gm_poster } ">
	                              </div>
	                              <div class="what-cap">
	                                  <span class="color1">${vo.gm_host }</span>
	                                  <h4><a href="#">${vo.gm_subject }</a></h4>
	                              </div>
	                          </div>
                          </a>
                      </div>
                      
             </c:forEach>
</body>
</html>