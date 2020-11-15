<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#content { 
		font-size: 18pt;
		font-weight: bolder;
		margin-bottom: 30px;
	}
	.toplist{
		width: 1000px;
		height: 40px;
		background-color :rgba( 35, 80, 142, 0.1 );
		border-top: solid 2px #2A58A8;
		border-bottom: solid 2px #2A58A8;
		font-weight: bolder;
		padding-top: 0px;
		display: table-cell;
     	vertical-align: middle;
     	text-align: center;

	}
</style>
</head>
<body>
<div class="resume-list">
  <div class="container">
  	<div class="row">
  	  <div class="col-lg-12">
  	  	<div id="content">${id }님의 뉴스 스크랩</div>
  	  	
  	  	<div class="tableList">
  	  	  <div class="top-area">
  	  	  	<div class="toplist">스크랩 목록</div>
  	  	  </div>
  	  	 
  	  	  <div class="list-area">
  	  	  	<ul>
  	  	  	    
  	  	  	    
  	 <!-- 스크랩 리스트 넣는부분 -->
  <table class="table">
    <tr>
      <td>
        <c:forEach var="vo" items="${nList }">
          <table class="table">
            <tr>
              <td width=30% class="text-center" rowspan="2">
               <img src="${vo.n_poster }" width=150 height=100>
              </td>
              <td width=70%>${vo.n_title }<br><b><span style="color:#336699">취업뉴스</span></b><br><br>
               <span style="float:right;"><button type="button" title="글이동" onclick="location.href='../newsTipVideo/newsdetail.do?no=${vo.n_no }'" style="color:black;"><span>원문보기</span></button>&nbsp;
	       	   <button type="button" title="취소" onclick="location.href='../newsTipVideo/newsScrapCancel.do?no=${vo.n_sno }'" style="color:black;"><span>스크랩 취소</span></button></span>
              </td>
            </tr>
          </table>
        </c:forEach>
      </td>
    </tr>
  </table>
  	  	  	</ul>
  	  	  </div>
  	  	</div>
  	  </div>
  	</div>
  </div>
</div>
</body>
</html>