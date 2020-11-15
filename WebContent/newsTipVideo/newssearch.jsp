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

.thumbnail:hover {background-color: #e6f7ff;}
.joodJobList {margin-top:0; border:1px solid #e0e0e0; border-top:1px solid #999; border-bottom:none; background-color:#fff;}
.joodJobList li {*zoom:1; border-bottom:1px solid #e8e8e8; position:relative;}
.joodJobList li a {overflow:hidden; display:block; width:100%;}
.joodJobList li a:hover {background-color:#f6fafd;}
.joodJobList li a:hover dt strong {text-decoration:underline;}
.joodJobList li:after {content:""; display:block; clear:both;}
.joodJobList li .thumb {float:left; width:258px; padding:30px 0; text-align:center; position:relative;}
.joodJobList li .thumb img {border:1px solid #ececec;}
.joodJobList li dl {float:left; width:660px; padding:26px 10px 0px;}
.joodJobList li dt {font-size:17px; color:#333; font-weight:bold; word-break:keep-all; word-wrap:break-word; }
.joodJobList li dt strong{display:inline-block; position:relative; padding:0 110px 0 0; max-width:100%; box-sizing:border-box; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;}
.joodJobList li .tx {font-size:14px; line-height:22px; color:#666; margin-top:11px; height:44px; overflow:hidden; margin-bottom:0px;}
.joodJobList li .listSubItem {font-size:14px; line-height:22px; color:#666; margin-top:0px; height:44px; overflow:hidden; margin-bottom:3px;}
.joodJobList li.scNoSelect {border-top:none !important;}

.w3-bar {margin-top:0; border:1px solid #e0e0e0; border-top:1px solid #999; border-bottom:none; background-color:#fff; *zoom:1; border-bottom:1px solid #e8e8e8; position:relative; text-align:center; padding:10px 10px 10px; }

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
    <a href="../newsTipVideo/news.do" class="btn btn-light">취업뉴스</a>
    <a href="../newsTipVideo/tip.do" class="btn btn-primary">취업꿀팁</a>
    <a href="../newsTipVideo/video.do" class="btn btn-primary">취업영상</a>
</div>

<div style="height:30px"></div>

<span style="text-align: left; height:50px; padding:0px 5px 50px"><b>"${searchkey }"</b> 검색 결과 총 <span style="color:#336699; font-weight:bold;">${searchcount }</span>개</span>

<div style="height:30px"></div>

<ul class="joodJobList">
<c:forEach var="vo" items="${list }">
 <li>
  <a href="../newsTipVideo/newsdetail.do?no=${vo.n_no }">
   <p class="thumb">
    <img src="${vo.n_poster }">
   </p>
   <dl>
    <dt>
     <strong>
       ${vo.n_title }
     </strong>
    </dt>
    <dd class="tx">${vo.n_precontent }</dd>
    <dd class="listSubItem">
         <span class="item">${vo.n_regdate }</span>
         <span class="item viewItem"><span class="stSpBefore stIcnView"><span class="skip">&nbsp;&nbsp;|&nbsp;&nbsp;<i class="glyphicon glyphicon-user" style="color:#336699"></i> </span>${vo.n_hit }</span></span>
    </dd>
   </dl>
  </a>
 </li>
</c:forEach>
</ul>

<div class="topnav">
  <a class="active" href="#">Top</a>
  <div class="search-container">
    <form action="../newsTipVideo/newsSearch.do">
      <input type="text" placeholder="검색어를 입력하세요" name="searchkey">
      <button type="submit" value=검색 id="searchButton"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>
<div class="w3-bar">
 <c:if test="${curpage>BLOCK }">
  <a href="../newsTipVideo/newsSearch.do?page=${startPage-1 }&searchkey=${searchkey }" class="w3-button">&lt;</a>
 </c:if>
 <c:forEach var="i" begin="${startPage }" end="${endPage }">
  <c:if test="${i==curpage }">
  <a href="../newsTipVideo/newsSearch.do?page=${i }&searchkey=${searchkey }" class="w3-button w3-blue">${i }</a>
  </c:if>
  <c:if test="${i!=curpage }">
  <a href="../newsTipVideo/newsSearch.do?page=${i }&searchkey=${searchkey }" class="w3-button">${i }</a>
  </c:if>
  </c:forEach>
  <c:if test="${endPage<totalpage }">
  <a href="../newsTipVideo/newsSearch.do?page=${endPage+1 }&searchkey=${searchkey }" class="w3-button">&gt;</a>
  </c:if>
</div>

<div style="height:100px"></div>

</body>
</html>