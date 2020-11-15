<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="section-tittle pt-25 pb-20">
		<h3>공모전 스크랩 목록</h3>
	</div>
	<table class="table">
	    <tr>
	      <td>
	        <c:forEach var="vo" items="${gList }">
	          <table class="table">
	            <tr>
	              <td width=30% class="text-center" rowspan="3">
	               <a href="../gongmo/gongmo_detail.do?no=${vo.gm_no }">
	               <img src="${vo.gm_poster }" width=200 height=150>
	               </a>
	              </td>
	              <td width=70%>제목 : ${vo.gm_subject }</td>
	            </tr>
	            <tr>
	               <td width=70% valign="top">기간  ${vo.gm_period }</td>
	            </tr>
	          <tr>
	               <td width=70% class="text-right">
	                 <a href="../gongmo/gongmoScrapCancel.do?no=${vo.jjim_no }" class="button button-contactForm boxed-btn">선택취소</a>
	               </td>
	            </tr>
	          </table>
	        </c:forEach>
	      </td>
	    </tr>
	  </table>
</body>
</html>