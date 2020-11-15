<%@page import="vo.GongmoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="vo.*,model.*,dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:useBean id="toDay" class="java.util.Date" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="script.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

/* 세로메뉴바 */
#cssmenu ul li a {
  margin: 0px auto;
  padding: 0;
  border: 0;
  list-style: none;
  line-height: 1;
  display: block;
  position: relative;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}
#cssmenu {
  width: 200px;
  font-family: Helvetica, Arial, sans-serif;
  color: #ffffff;
}
#cssmenu ul ul {
  display: none;
}
.align-right {
  float: right;
}
#cssmenu > ul > li > a {
  padding: 15px 20px;
  border-left: 1px solid #1c74a2;
  border-right: 1px solid #1c74a2;
  border-top: 1px solid #1c74a2;
  cursor: pointer;
  z-index: 2;
  font-size: 14px;
  font-weight: bold;
  text-decoration: none;
  color: #ffffff;
  text-shadow: 0 1px 1px rgba(0, 0, 0, 0.35);
  background: #36aae7;
  background: -webkit-linear-gradient(#2e9fda, #2394ce);
  background: -moz-linear-gradient(#2e9fda, #2394ce);
  background: -o-linear-gradient(#2e9fda, #2394ce);
  background: -ms-linear-gradient(#2e9fda, #2394ce);
  background: linear-gradient(#2e9fda, #2394ce);
  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.15);
}
#cssmenu > ul > li > a:hover,
#cssmenu > ul > li.active > a,
#cssmenu > ul > li.open > a {
  color: #eeeeee;
  background: #1fa0e4;
  background: -webkit-linear-gradient(#2392cc, #2084b8);
  background: -moz-linear-gradient(#2392cc, #2084b8);
  background: -o-linear-gradient(#2392cc, #2084b8);
  background: -ms-linear-gradient(#2392cc, #2084b8);
  background: linear-gradient(#2392cc, #2084b8);
}
#cssmenu > ul > li.open > a {
  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.15), 0 1px 1px rgba(0, 0, 0, 0.15);
  border-bottom: 1px solid #1682ba;
}
#cssmenu > ul > li:last-child > a,
#cssmenu > ul > li.last > a {
  border-bottom: 1px solid #1c74a2;
}
.holder {
  width: 0;
  height: 0;
  position: absolute;
  top: 0;
  right: 0;
}
.holder::after,
.holder::before {
  display: block;
  position: absolute;
  content: "";
  width: 6px;
  height: 6px;
  right: 20px;
  z-index: 10;
  -webkit-transform: rotate(-135deg);
  -moz-transform: rotate(-135deg);
  -ms-transform: rotate(-135deg);
  -o-transform: rotate(-135deg);
  transform: rotate(-135deg);
}
.holder::after {
  top: 17px;
  border-top: 2px solid #ffffff;
  border-left: 2px solid #ffffff;
}
#cssmenu > ul > li > a:hover > span::after,
#cssmenu > ul > li.active > a > span::after,
#cssmenu > ul > li.open > a > span::after {
  border-color: #000073;
}
.holder::before {
  top: 18px;
  border-top: 2px solid;
  border-left: 2px solid;
  border-top-color: inherit;
  border-left-color: inherit;
}
#cssmenu ul ul li a {
  cursor: pointer;
  border-bottom: 1px solid #2d4d66;
  border-left: 1px solid #2d4d66;
  border-right: 1px solid #2d4d66;
  padding: 10px 20px;
  z-index: 1;
  text-decoration: none;
  font-size: 13px;
  color: #eeeeee;
  background: #3d6889;
  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.1);
}
#cssmenu ul ul li:hover > a,
#cssmenu ul ul li.open > a,
#cssmenu ul ul li.active > a {
  background: #38607e;
  color: #ffffff;
}
#cssmenu ul ul li:first-child > a {
  box-shadow: none;
}
#cssmenu ul ul ul li:first-child > a {
  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.1);
}
#cssmenu ul ul ul li a {
  padding-left: 30px;
}
#cssmenu > ul > li > ul > li:last-child > a,
#cssmenu > ul > li > ul > li.last > a {
  border-bottom: 0;
}
#cssmenu > ul > li > ul > li.open:last-child > a,
#cssmenu > ul > li > ul > li.last.open > a {
  border-bottom: 1px solid #32373e;
}
#cssmenu > ul > li > ul > li.open:last-child > ul > li:last-child > a {
  border-bottom: 0;
}
#cssmenu ul ul li.has-sub > a::after {
  display: block;
  position: absolute;
  content: "";
  width: 5px;
  height: 5px;
  right: 20px;
  z-index: 10;
  top: 11.5px;
  border-top: 2px solid #eeeeee;
  border-left: 2px solid #eeeeee;
  -webkit-transform: rotate(-135deg);
  -moz-transform: rotate(-135deg);
  -ms-transform: rotate(-135deg);
  -o-transform: rotate(-135deg);
  transform: rotate(-135deg);
}
#cssmenu ul ul li.active > a::after,
#cssmenu ul ul li.open > a::after,
#cssmenu ul ul li > a:hover::after {
  border-color: #ffffff;
}
.row3{
	margin-top: 100px;
	float: right;
}

.h3 {
	
}
</style>
</head>
<body>
<div class="trending-area fix">
	<div class="container">
			<div class="row d-flex justify-content-between">
				<!-- 왼쪽 메인 주제 ----------------------------------------------------------------------------------- 왼쪽 메인 주제-->
				<div class="container">
					<div class="col-md-4" >
					<div class="section-tittle pt-25 pb-20">
						<h3>전체 공모전</h3>
					</div>
				</div>
				<!-- 카테고리가로바 ----------------------------------------------------------------------------------- 카테고리가로바-->
				<div class="col-lg-8">
				<section class="whats-news-area pt-50 pb-20">
					<div class="nav">
						<div class="properties__button">
							 <!--Nav Button  -->                                            
                            <nav>                                                                     
                                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="onclick" href="../gongmo/gongmo_all.do" role="tab" aria-controls="nav-home" aria-selected="true">전체</a>
                                    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="onclick" href="../gongmo/gongmo_cno1.do?cno=1" role="tab" aria-controls="nav-profile" aria-selected="false">기획/아이디어</a>
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="onclick" href="../gongmo/gongmo_cno2.do?cno=2" role="tab" aria-controls="nav-contact" aria-selected="false">디자인</a>
                                    <a class="nav-item nav-link" id="nav-last-tab" data-toggle="onclick" href="../gongmo/gongmo_cno1.do?cno=3" role="tab" aria-controls="nav-contact" aria-selected="false">광고/마케팅</a>
                                    <a class="nav-item nav-link" id="nav-Sports" data-toggle="onclick" href="../gongmo/gongmo_cno1.do?cno=4" role="tab" aria-controls="nav-contact" aria-selected="false">문학/시나리오</a>
                                    <a class="nav-item nav-link" id="nav-technology" data-toggle="onclick" href="../gongmo/gongmo_cno1.do?cno=5" role="tab" aria-controls="nav-contact" aria-selected="false">기타</a>
                                </div>
                            </nav>
                            <!--End Nav Button  -->
						</div>
					</div>
				</section>
			</div>
		</div>
		</div>
			<!-- 세로카테고리바-------------------------------------------------------------------------------- -->
			<div class="col-lg-4">
				<div id='cssmenu'>
				<ul>
				   <li><a href='#'><span>메뉴</span></a></li>
				   <li class='active has-sub'><a href='../gongmo/gongmo_all.do'><span>공모전</span></a>
				      <ul>
				         <li class='last'><a href='../gongmo/gongmo_cno1.do?cno=1'><span>기획/아이디어</span></a></li>
				         <li class='last'><a href='../gongmo/gongmo_cno2.do?cno=2'><span>디자인</span></a></li>
				         <li class='last'><a href='../gongmo/gongmo_cno3.do?cno=3'><span>광고/마케팅</span></a></li>
				         <li class='last'><a href='../gongmo/gongmo_cno4.do?cno=4'><span>영상/사진/UCC</span></a></li>
				         <li class='last'><a href='../gongmo/gongmo_cno5.do?cno=5'><span>문학/시나리오</span></a></li>
				         <li class='last'><a href='../gongmo/gongmo_cno6.do?cno=6'><span>기타</span></a></li>
				      </ul>
				   </li>
				     <li class='active has-sub'><a href='#'><span>교육</span></a>
				   		<ul>
				         <li class='last'><a href='#'><span>정부(국비)지원</span></a></li>
				         <li class='last'><a href='#'><span>고용보험환급</span></a></li>
				         <li class='last'><a href='#'><span>무료교육</span></a></li>
				      </ul>
				   </li>
				     <li class='active has-sub'><a href='#'><span>스터디모집</span></a>
				   		<ul>
				         <li class='last'><a href='#'><span>어학/회화</span></a></li>
				         <li class='last'><a href='#'><span>자격증</span></a></li>
				         <li class='last'><a href='#'><span>라이프/취미</span></a></li>
				      </ul>
				   </li>
				</ul>
				</div>
			</div>
			
			<!-- 오늘 날짜 ------------------------------------------- -->
<%-- 				<fmt:formatDate var="toDay" value="${toDay}" pattern="yyyy.MM.dd" />
			
			 	<c:forEach var="dvo" items="${list }">
			 	
		 			<c:set var = "countdown" value = "${dvo.gm_period }"/>
					<c:set var = "countdown2" value = "${fn:substring(countdown,12,23)}" />
					<p>${countdown }</p>
					<p>뒤에서 자르기 : ${countdown2 }</p> 
					
					<fmt:parseDate value="${toDay }" var="strPlanDate" pattern="yyyy.MM.dd"/>
					<fmt:parseNumber value="${strPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="strDate"></fmt:parseNumber>
					<fmt:parseDate value="${countdown2 }" var="endPlanDate" pattern="yyyy.MM.dd"/>
					<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"></fmt:parseNumber>
 					<font color="red">${endDate - strDate }</font>

				</c:forEach> --%>
 				
			<!-- 게시물 ----------------------------------------------------------------------------------------------------------- 게시물 -->	
			<div class="col-lg-8">
				<div class="box">
				<c:forEach var="vo" items="${list }">
					<div class="col-md-4 col-md-8">
						<div class="thumbnail">
							<a href="../gongmo/gongmo_detail.do?no=${vo.gm_no }&page=${curpage}">
								<img src="${vo.gm_poster }" alt="Lights" style="width: 250px; height: 200px;">
								<div class="caption">
									<p style="font-size: 10px;">제목: ${fn:length(vo.gm_subject)>14?fn:substring(vo.gm_subject,0,14)+="...":vo.gm_subject  }</p>
									<p style="font-size: 10px;">기한: ${vo.gm_period }</p>
									<p style="font-size: 10px;">주최: ${fn:length(vo.gm_host)>14?fn:substring(vo.gm_host,0,14)+="...":vo.gm_host  }</p>
								</div>
							</a>
						</div>
					</div>
				</c:forEach>
				</div>
			 <!-- 검색-------------------------------------------------------------------------------------------------------- -->
			 	<div style="text-align: right;">
						<form action="../gongmo/gongmo_find.do" style="display: inline-block; margin-right:15px;">
							<select name="finding" class="dropup">
								<option value="gm_subject" selected="selected">제목</option>
								<option value="gm_host">주최</option>
							</select>
							<input type=text name="voca" size=25 placeholder="검색어 입력" style="height:30px; border: none; border-radius: 5px; margin-left:15px;">
							<input type=submit value=검색 id="searchButton">
						</form>
					</div>			
				</div>
		<!-- 페이지 페이징 버튼 ========================================================================================= 페이지 페이징 버튼 -->
		<div class="box2">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${curpage>BLOCK }">
						<li><a href="../gongmo/gongmo_all?page=${startPage-1 }">&lt;</a></li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:if test="${i==curpage }">
							<li class="active"><a href="../gongmo/gongmo_all?page=${i }">${i }</a></li>
						</c:if>
						<c:if test="${i!=curpage }">
							<li><a href="../gongmo/gongmo_all.do?page=${i }">${i }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${endPage<totalpage }">
						<li><a href="../gongmo/gongmo_all.do?page=${endPage+1 }">&gt;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>		
	<!-- 최근 방문한 질문글 리스트  -->
	    <h2></h2>
		  <table class="table"> 
		    <c:forEach var="vo" items="${cList }" varStatus="s">
		      <div class="col-md-2">
			    <div class="thumbnail">
			        <a href="../gongmo/gongmo_all_before.do?no=${vo.gm_no }">
						<img src="${vo.gm_poster }" alt="Lights" style="width: 250px; height: 200px;">
					</a>
		       </div>
		    </div>
		    </c:forEach>
		</table>
</body>
</html>