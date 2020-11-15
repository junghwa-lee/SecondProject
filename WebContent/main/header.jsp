<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	
		
</script>
<style type="text/css">
#headerLink{
	color: white;
	font-size: 13pt;
}

</style>
</head>
<body>
	<header>
        <!-- Header Start -->
       <div class="header-area" style="background-color: #355880;">
            <div class="main-header ">
                <div class="header-top black-bg d-none d-md-block">
                   <div class="container">
                       <div class="col-xl-12">
                            <div class="row d-flex justify-content-between align-items-center">
                                <div class="header-info-left">
                                    <ul>     
                                        <li><img src="assets/img/icon/header_icon1.png" alt="">10ºc, Cloudy </li>
                                        <li><img src="assets/img/icon/header_icon1.png" alt="">Monday, 9th November, 2020</li>
                                    </ul>
                                </div>
                                <div class="header-info-right">
                                    <ul class="header-social">    
                                        <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                        <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                                       <li> <a href="#"><i class="fab fa-pinterest-p"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                       </div>
                   </div>
                </div>
                <div class="header-mid d-none d-md-block">
                   <div class="container">
                        <div class="row d-flex align-items-center">
                            <!-- Logo -->
                            <div class="col-xl-3 col-lg-3 col-md-3">
                                <div class="logo">
                                    <a href="../main/main.do"><img src="../image/logo2.png" width=400px></a>
                                </div>
                            </div>
                            <div class="col-xl-9 col-lg-9 col-md-9">
                                <div class="header-banner f-right ">
                                    <img src="assets/img/hero/header_card.jpg" alt="">
                                </div>
                            </div>
                        </div>
                   </div>
                </div>
               <div class="header-bottom"><!--  header-sticky -->
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-xl-10 col-lg-10 col-md-12 header-flex">
                                <!-- sticky -->
                                    <div class="sticky-logo">
                                        <a href="index.html"><img src="../image/logo2.png" width=300px></a>
                                    </div>
                                <!-- Main-menu -->
                                <div class="main-menu d-none d-md-block">
                                    <nav>                  
                                        <ul id="navigation">    
                                            <li><a href="../main/main.do" id="headerLink">홈</a></li>
                                            <li><a href="../Workb/workb.do" id="headerLink">채용공고</a>
                                            	<ul class="submenu">
                                                    <li><a href="../Workb/workb.do">지역별</a></li>
                                                    <li><a href="../Workb/workb2.do">업종별</a></li>
                                                    <li><a href="../jobcalendar/jobcalendar.do">채용달력</a></li>
                                                    <!-- <li><a href="details.html">상시모집</a></li> -->
                                                </ul>
                                            </li>
                                            <li><a href="../selfletter/letter.do" id="headerLink">취업꿀팁</a>
                                            	<ul class="submenu">
                                                    <li><a href="../selfletter/letter.do">합격자소서</a></li>
                                                    <li><a href="../company/company.do">기업·면접후기</a></li>
                                                    <li><a href="../newsTipVideo/news.do">취업뉴스</a></li>
                                                    <li><a href="../newsTipVideo/tip.do">취업꿀팁</a></li>
                                                    <li><a href="../newsTipVideo/video.do">취업영상</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="../gongmo/gongmo_home.do" id="headerLink">공모전</a>
                                            	<ul class="submenu">
                                                    <li><a href="../gongmo/gongmo_all.do">전체 공모전</a></li>
                                                    <li><a href="../gongmo/gongmo_cno1.do?cno=1">기획/아이디어</a></li>
                                                    <li><a href="../gongmo/gongmo_cno2.do?cno=2">디자인</a></li>
                                                    <li><a href="../gongmo/gongmo_cno3.do?cno=3">광고/마케팅</a></li>
                                                    <li><a href="../gongmo/gongmo_cno4.do?cno=4">영상/사진/UCC</a></li>
                                                    <li><a href="../gongmo/gongmo_cno5.do?cno=5">문학/시나리오</a></li>
                                                    <li><a href="../gongmo/gongmo_cno6.do?cno=6">기타</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="../jobKnowledge/list.do" id="headerLink">Job 지식인</a>				<!-- 잡지식인 메인페이지 : 게시글 리스트 출력 -->
                                            	<ul class="submenu">
                                            		<li><a href="../jobKnowledge/list.do">목록</a></li>
                                            		<c:if test="${sessionScope.id != null }">
                                            			<li><a href="../jobKnowledge/answer.do">질문하기</a></li>
                                            		</c:if>
                                                </ul>
                                            </li>
                                            
                                           <c:if test="${sessionScope.id==null }">
	                                            <li><a href="../user/login.do" id="headerLink">로그인</a>
		                                            <ul class="submenu">
		                                              <li><a href="../user/login.do">로그인</a></li>
												      <li><a href="../user/join.do">회원가입</a></li>
												    </ul>
											    </li>
	                                        </c:if>
	                                        <c:if test="${ sessionScope.id!=null}">
											      <c:if test="${sessionScope.admin=='n'}">
										            <li><a href="../resume/list.do" id="headerLink">마이페이지</a>
										            <ul class="submenu">
										            	 <li><a href="../resume/list.do">이력서 관리</a></li>
										            	 <li><a href="../user/update.do">회원수정</a></li>
										           	</ul>
										            </li>
										          </c:if>
										          <c:if test="${sessionScope.admin=='y'}">
										            <li><a href="#" id="headerLink">관리자페이지</a>
										             <ul class="submenu">
										            	<li><a href="../user/update.do">회원정보 수정</a></li>
										           	 </ul>
										           	</li>
										          </c:if>
    									    </c:if>
	                                        <li>
                                            <%-- <c:if test="${sessionScope.id!=null }">
											  <form action="../user/logout.do">get(생략이 가능)
											    <div class="logout" style="margin-left: 30px;" >
											      ${sessionScope.name }님 
											      <button class="genric-btn danger radius small">로그아웃</button>
											    </div>
											  </form>
 											</c:if> --%>
 											</li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>       
                        <div>
                            <!-- <div class="col-xl-2 col-lg-2 col-md-4">
                            </div> 
                            <div class="col-xl-2 col-lg-2 col-md-4">
                                <div class="header-right-btn f-right d-none d-lg-block">
                                    <i class="fas fa-search special-tag"></i>
                                    <div class="search-box">
                                        <form action="#">
                                            <input type="text" placeholder="Search">
                                            
                                        </form>
                                    </div>
                                </div>
                            </div> -->
                            <c:if test="${sessionScope.id!=null }">
 											
                            <form action="../user/logout.do" style="display: inline;"><%-- get(생략이 가능) --%>
								    <div class="text-right" style="color: white;">
								      ${sessionScope.name }님 
								      <button class="genric-btn radius small" style="background-color: red; border: 0px;">로그아웃</button>
								    <!--   <button class="genric-btn danger radius small" style="background-color: red;">로그아웃</button> -->
								    </div>
						    </form>
						    </c:if>
						</div>
                            <!-- Mobile Menu -->
                            <div class="col-12">
                                <div class="mobile_menu d-block d-md-none"></div>
                            </div>
                        </div>
                    </div>
               </div>
               
            </div>
       </div>
        <!-- Header End -->
    </header>
</body>
</html>