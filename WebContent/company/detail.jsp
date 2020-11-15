<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript">
  $(function(){
		
	
  </script>
</head>
<style type="text/css">
.col-lg-12 posts-list{
	width: 200px;
}
#home{
	width:700px;
}
#menu1{
	width:700px;
}
#logo{
	border: 2px solid black;
	border-radius: 10px;
	padding: 5px;
}


</style>
<body>
   
   <!--================기업상세보기 =================-->
   
   <section class="blog_area single-post-area section-padding">
      <div class="container">
         <div class="row">
            <div class="col-lg-8 posts-list" style="">
               <div class="single-post">
                  <div class="feature-img"></div>
                     <img class="img-fluid" src="${vo.clogo }" alt="기업로고" id="logo" width=150 height="150">
                  </div>
                  
					<!-- ==============================기업 소개,리뷰 부분 시작======================================= -->
					<div class=" posts-list">
					  <h2>${vo.cname }</h2>
					  <p><img src="star.png" width=20 height=20 id="user">&nbsp;${vo.cscore }</p>
					  <p>${vo.ctype } | ${vo.cindutype }</p>
               		</div>

               		<!-- ==============================탭메뉴 시작부분================================= -->
               		<ul class="nav nav-tabs">
					    <li class="active"><a data-toggle="tab" href="#home">소개</a></li>
					    <li><a data-toggle="tab" href="#menu1">기업후기</a></li>
					    <li><a data-toggle="tab" href="#menu2">면접후기</a></li>
					</ul>
					<!-- ================기업소개탭====================================================================== -->
					  <div class="tab-content" width="200">
					  
					    <div id="home" class="tab-pane fade in active">
					      <br>
					      <ul>
					      	<li>대표이름 : ${vo.bname }</li><br>
					      	<li>설립일 : ${vo.cdate }</li><br>
					      	<li>사원수 : ${vo.worknum }</li><br>
					      	<li>기업주소 : ${vo.cloc }</li><br>
					      	<li>매출 : ${vo.sale }</li><br>
					      	<li>기업소개 : ${vo.cover }</li><br>
					      	<li>웹사이트 : <a href="http://${vo.site1 }"> ${vo.site1 }</a></li><br>
					      	<li>연혁 : ${vo.history }</li>
					      </ul>
					    </div>

					    
					  	<!-- ================기업후기탭=================================================================== -->
					  	
					    <div id="menu1" class="tab-pane fade">
								      <c:forEach var="wvo" items="${work_list }">
								      
								      <div class="container" style="width:750px; margin-bottom:30px;margin-top:20px;">				<!-- 기업후기 가로길이 -->
										  <div class="media">
											  <div class="media-left">
											  &nbsp;&nbsp;&nbsp;&nbsp;
											    <img src="user.png" class="media-object" style="width:50px">
											    &nbsp;&nbsp;&nbsp;&nbsp;
											  </div>
											  <div class="typebar">
											    <h4 class="media-heading">${wvo.rtype } | ${wvo.rloc } | ${wvo.rdate } </h4>
											    <p><img src="star.png" width=15 height=15>&nbsp;${wvo.rscore }</p>
											  </div>
											</div>
										  <div class="panel-group" >
										    <div class="panel panel-primary">
										      <div class="panel-heading">총평</div>
										      <div class="panel-body">${wvo.rsub }</div>
										    </div>
										    <div class="panel panel-success">
										      <div class="panel-heading">장점</div>
										      <div class="panel-body">${wvo.rgood }</div>
										    </div>
										    <div class="panel panel-warning">
										      <div class="panel-heading">단점</div>
										      <div class="panel-body">${wvo.rbad }</div>
										    </div>
											 <div class="panel panel-info">
										      <div class="panel-heading">바라는 점</div>
										      <div class="panel-body">${wvo.rwish }</div>
										    </div>
										  </div>
										</div>
										
								</c:forEach>
					    </div>
					    <!-- -페이지 -->
						
               			
               			
               			<!-- 면접후기 탭 ===================================================================================== -->
               			
               			<div id="menu2" class="tab-pane fade" >
               			
               				<c:forEach var="ivo" items="${int_list }">
									<div class="container" style="width:750px; margin-bottom:30px;margin-top:20px;">
									  <div class="media">
										  <div class="media-left">
										    <img src="user.png" class="media-object" style="width:50px">
										  </div>
										  <div class="media-body">
										    <h5 class="media-heading">면접결과 &nbsp;${ivo.iresult}</h5>
										    <p>면접난이도&nbsp;<img src="star.png" width=15 height=15>&nbsp;${ivo.iscore }</p>
										    <p>면접일&nbsp;${ivo.iregdate }</p>
										  </div>
										</div>
									  <div class="panel-group">
									    <div class="panel panel-primary">
									      <div class="panel-heading">총평</div>
									      <div class="panel-body">${ivo.ireview }</div>
									    </div>
									    <div class="panel panel-default">
									      <div class="panel-heading">면접질문</div>
									      <div class="panel-body">${ivo.iq }</div>
									    </div>
									    <div class="panel panel-default">
									      <div class="panel-heading">면접답변 혹은 면접느낌</div>
									      <div class="panel-body">${ivo.ia }</div>
									    </div>
									  </div>
									</div>
							</c:forEach>
						</div>
						<!-- 새글작성 버튼 -->
					<!-- 	&nbsp;&nbsp;&nbsp;&nbsp;
               		<div class=button>
						<a href="../company/insert.do" class="genric-btn success circle">새 리뷰 작성</a>
					</div> -->
               		
               		
            </div>
      </div>
            <!--  =========================================사이드바 시작부분======================================================-->
      <div class="col-lg-4">
               <div class="blog_right_sidebar">
               
                  
                  
                  <aside class="single_sidebar_widget post_category_widget">
                     <h4 class="widget_title">Category</h4>
                     <ul class="list cat-list">
                         <li>
                           <a href="../company/company.do?cateno=100" class="d-flex">
                              <p>서비스업</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=200" class="d-flex">
                              <p>제조/화학</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=300" class="d-flex">
                              <p>의료/제약/복지</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=400" class="d-flex">
                              <p>유통/무역/운송</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=500" class="d-flex">
                              <p>교육업</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=600" class="d-flex">
                              <p>건설업</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=700" class="d-flex">
                              <p>IT/웹/통신</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=800" class="d-flex">
                              <p>미디어/디자인</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=900" class="d-flex">
                              <p>은행/금융업</p>
                           </a>
                        </li>
                        <li>
                           <a href="../company/company.do?cateno=1000" class="d-flex">
                              <p>기관/협회</p>
                           </a>
                        </li>
                     </ul>
                  </aside>
                                    <aside class="single_sidebar_widget popular_post_widget">
                     <h3 class="widget_title">최근 본 기업</h3>
                     <div class="media post_item">
                        <img src="masa.jpg" alt="post">
                        <div class="media-body">
                           <a href="#">
                              <h3>한국마사회</h3>
                           </a>
                           <p>01 시간 전</p>
                        </div>
                     </div>
                     <div class="media post_item">
                        <img src="mc.png" alt="post">
                        <div class="media-body">
                           <a href="#">
                              <h3>한국맥도날드(유)</h3>
                           </a>
                           <p>02 시간 전</p>
                        </div>
                     </div>
                     <div class="media post_item">
                        <img src="nong.png" alt="post">
                        <div class="media-body">
                           <a href="#">
                              <h3>한국농어촌공사</h3>
                           </a>
                           <p>03 시간 전</p>
                        </div>
                     </div>
                     <div class="media post_item">
                        <img src="startbuc.jpg" alt="post">
                        <div class="media-body">
                           <a href="#">
                              <h3>스타벅스커피코리아(주)</h3>
                           </a>
                           <p>04 시간 전</p>
                        </div>
                     </div>
                  </aside>
                  
                  	</div>
                  </div>
     			 </div>
      
               
               </div>
            </div>
   </section>
   <!--================ Blog Area end =================-->

        
</body>

</html>