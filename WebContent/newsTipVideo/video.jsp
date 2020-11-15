<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
.videocontainer{text-align:center;}
.list_cast type3 mt30{text-align:right;}
.list_cast li a:hover { background-color: #e6f7ff; }
.list_cast { margin-right: 0px; overflow: hidden; }
.list_cast:after { content: ""; display: block; clear: both; }
.list_cast li { float: left; width: 232px; height: 272px; margin-right: 19px; }
.list_cast li a { position: relative; display: block; text-decoration: none; }
.list_cast .pic { position: relative; display: block; }
.list_cast .pic:before { content: ""; display: block; position: absolute; top: 0; right: 0; bottom: 0; left: 0; border: solid 1px rgba(0, 0, 0, 0.1); }
.list_cast .pic img { width: 100%; height: 131px; }
.list_cast span.ico1 { display: inline-block; padding-left: 12px; }
.list_cast span.ico1:after { width: 8px; background-image: url("https://imgorg.catch.co.kr/job/corp/ico_play02.gif"); }
.list_cast span:after { content: ""; display: block; position: absolute; top: 5px; left: 0; height: 9px; background-repeat: no-repeat; background-position: left center; }
.list_cast .t1 { display: block; font-size: 16px; letter-spacing: -1px; padding-left: 47px; margin-top: 7px; }
.list_cast .t1 .bar:before { content: "I"; display: inline-block; vertical-align: middle; margin: -4px 5px 0 5px; }
.list_cast .t2 { display: block; padding-left: 47px; margin-top: 10px; color: #336699; font-weight:bold; position: relative; }
.list_cast .t2 .check { position: absolute; top: 0; right: 0; font-size: 13px; color: #888; }
.list_cast .t3 { display: block; padding-left: 47px; margin-top: 9px; }
.list_cast .t3 span { position: relative; font-size: 13px; color: #888; }
.list_cast .t3 span.ico1 { padding-left: 12px; margin-right: 5px; }
.list_cast .t3 span.ico1:after { width: 8px; background-image: url("https://imgorg.catch.co.kr/job/corp/ico_play02.gif"); }
.list_cast .t3 span.ico2 { padding-left: 15px; }
.list_cast .t3 span.ico2:after { width: 11px; background-image: url("https://imgorg.catch.co.kr/job/corp/ico_like02.gif"); }
.list_cast .t3 span:after { content: ""; display: block; position: absolute; top: 5px; left: 0; height: 9px; background-repeat: no-repeat; background-position: left center; }
.list_cast .t4 { position: absolute; font-size: 30px; top: 135px; left: 0; width: 38px; text-align: center; }
.list_cast.type2 li { height: 250px; }
.list_cast.type2 .pic img { height: 138px; border: solid 1px #c6c6c6; }
.list_cast.type2 .t1 { padding-left: 0; }
.list_cast.type2 .t2 { padding-left: 0; }
.list_cast.type2 .t3 { padding-left: 0; }
.list_cast.type3 { border-bottom: solid 1px #272727; }
.list_cast.type3 li { height: 250px; }
.list_cast.type3 .t1 { padding-left: 0; }
.list_cast.type3 .t2 { padding-left: 0; }
.list_cast.type3 .t3 { padding-left: 0; }
.list_cast.type4 li { height: 185px; }
.list_cast.type4 .t1 { padding-left: 0; line-height: 22px; max-height: 44px; }
.list_cast .t1 {font-size:14px; color:#666;}
.w3-bar {margin-top:0; border:1px solid #e0e0e0; border-top:1px solid #999; border-bottom:none; background-color:#fff; *zoom:1; border-bottom:1px solid #e8e8e8; position:relative; text-align:center; padding:10px 10px 10px; }

* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 600px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #000000;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}
/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 3s;
  animation-name: fade;
  animation-duration: 3s;
}

@-webkit-keyframes fade {
  from {opacity: .1} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .1} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}

* {box-sizing: border-box;}
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}

.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #2196F3;
  color: white;
}

.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
}

</style>
</head>
<body>

<div class="btn-group btn-group-justified">
    <a href="../selfletter/letter.do" class="btn btn-primary">합격자소서</a>
    <a href="../company/company.do" class="btn btn-primary">기업·면접후기</a>
    <a href="../newsTipVideo/news.do" class="btn btn-primary">취업뉴스</a>
    <a href="../newsTipVideo/tip.do" class="btn btn-primary">취업꿀팁</a>
    <a href="../newsTipVideo/video.do" class="btn btn-light">취업영상</a>
</div>

<div style="height:30px"></div>

<div class="slideshow-container">
<c:forEach var="vo" items="${hlist }" begin="0" end="2" varStatus="status">
<a href="../newsTipVideo/videodetail.do?no=${vo.v_no }">
<div class="mySlides fade">
  <img src="${vo.v_poster }" width="600" height="200">
  <br>
  <br>
  <br>
  <br>
  <br>
  <div class="text"><span class="label label-danger">Hot</span> <b>이 시각 인기 취업영상</b><br>${vo.v_title }</div>
</div>
</a>
</c:forEach>
</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 3000); // Change image every 2 seconds
}
</script>

<span style="text-align: left; height:50px; padding:0px 5px 50px">총 <span style="color:#336699; font-weight:bold;">${videocount }</span>개</span>

<div style="height:30px"></div>

<ul class="list_cast type3 mt30">
 <c:forEach var="vo" items="${list }">
	<li>
		<a href="../newsTipVideo/videodetail.do?no=${vo.v_no }">
			<span class="pic"><img src="${vo.v_poster }" alt=""></span>
			<span class="t2">${vo.v_writer } <span class="ico1 check">${vo.v_hit }</span></span>
			<span class="t1">${vo.v_title }</span>
		</a>
	</li>
 </c:forEach>
</ul>

<div class="topnav">
  <a class="active" href="#">Top</a>
  <div class="search-container">
    <form action="../newsTipVideo/videoSearch.do">
      <input type="text" placeholder="검색어를 입력하세요" name="searchkey">
      <button type="submit" value=검색 id="searchButton"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>

<div class="w3-bar">
 <c:if test="${curpage>BLOCK }">
  <a href="../newsTipVideo/video.do?page=${startPage-1 }" class="w3-button">&lt;</a>
 </c:if>
 <c:forEach var="i" begin="${startPage }" end="${endPage }">
  <c:if test="${i==curpage }">
  <a href="../newsTipVideo/video.do?page=${i }" class="w3-button w3-blue">${i }</a>
  </c:if>
  <c:if test="${i!=curpage }">
  <a href="../newsTipVideo/video.do?page=${i }" class="w3-button">${i }</a>
  </c:if>
  </c:forEach>
  <c:if test="${endPage<totalpage }">
  <a href="../newsTipVideo/video.do?page=${endPage+1 }" class="w3-button">&gt;</a>
  </c:if>
</div>
<div style="height:100px"></div>

</body>
</html>