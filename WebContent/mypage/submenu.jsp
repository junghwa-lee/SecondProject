<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.mypage{
	width: 200px;
	height: 75px;
	padding-left: 30px;
	font-weight: bolder;	
	vertical-align: middle;
	margin: 0px auto;
	
	/* border-bottom: 1px solid #8c8c8c; */
}
.mypage p{
	 font-weight: bolder; 
	 line-height: 75px;
	 font-size: 15pt;
}
#sidebar{
	width: 201px;
	border: 1px solid #8c8c8c;	
    background-color: rgba( 35, 80, 142, 0.1 );
}
.menu{
	padding-left: 30px;
	width: 200px;
	height: 60px;
}
.menu p{
	line-height: 60px;
}
.sub{
	padding-left: 45px;
	width: 200px;
	height: 40px;
}
.menu:hover{ 
	background-color: rgba( 35, 80, 142, 0.4); 
}
</style>
</head>
<body>


     <div id="sidebar">
           <aside class="single_sidebar_widget post_category_widget" style="padding: 15px 0px; ">
             <div class="mypage">
             	<p>마이페이지</p>
             </div> 
             <ul class="list cat-list">
                 <div class="menu">
                     <a href="../resume/resume.do" class="d-flex">
                         <p>이력서 등록</p>
                     </a>
                 </div>
                 <div class="menu">
                     <a href="../resume/list.do" class="d-flex">
                         <p>이력서 관리</p>
                     </a>
                 </div>
                 <div class="menu">
                     <a href="../mypage/scrap.do" class="d-flex">
                         <p>스크랩</p>
                     </a>
                 </div>
                 <div class="sub">
                     <a href="#" class="d-flex">
                         <p> <img src="../mypage/b.png" style="width: 10px; height: 10px; margin-right: 10px;">&nbsp;채용공고</p>
                     </a>
                 </div>
                 <!-- <div class="sub">
                     <a href="#" class="d-flex">
                         <p> <img src="../mypage/b.png" style="width: 10px; height: 10px; margin-right: 10px;">&nbsp;합격자소서</p>
                     </a>
                 </div> -->
                 <div class="sub">
                     <a href="../mypage/newsscrap.do" class="d-flex">
                         <p> <img src="../mypage/b.png" style="width: 10px; height: 10px; margin-right: 10px;">&nbsp;취업뉴스</p>
                     </a>
                 </div>
                 <div class="sub">
                     <a href="../mypage/tipscrap.do" class="d-flex">
                         <p> <img src="../mypage/b.png" style="width: 10px; height: 10px; margin-right: 10px;">&nbsp;취업꿀팁</p>
                     </a>
                 </div>
                 <div class="sub">
                     <a href="../mypage/videoscrap.do" class="d-flex">
                         <p> <img src="../mypage/b.png" style="width: 10px; height: 10px; margin-right: 10px;">취업영상</p>
                     </a>
                 </div>
                 <div class="sub">
                     <a href="../jobKnowledge/scrapList2.do" class="d-flex">
                         <p> <img src="../mypage/b.png" style="width: 10px; height: 10px; margin-right: 10px;">Job 지식인</p>
                     </a>
                 </div>
                 <div class="sub">
                    <a href="../mypage/gongmoscrap.do" class="d-flex">
                        <p> <img src="../mypage/b.png" style="width: 10px; height: 10px; margin-right: 10px;">&nbsp;공모전</p>
                    </a>
                </div>
                 
                
                  <div class="menu">
                     <a href="../user/update.do" class="d-flex">
                         <p>회원정보 수정</p>
                     </a>
                 </div> 
                 <!-- <div class="menu">
                     <a href="#" class="d-flex">
                         <p>아무거나</p>
                     </a>
                 </div> -->
                 
             </ul>
         </aside>
     </div>
                 <div>
                 <a href="https://allforyoung.com/posts/3413/">
                 	<img src="../mypage/eduwill.JPG" style="width: 200px; margin-top: 30px;">
                 </a>
                 </div>
                 
               
    
</body>
</html>
