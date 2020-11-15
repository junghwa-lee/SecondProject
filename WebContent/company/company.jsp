<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<!-- 라이브러리 추가 -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
 $(function(){
	 $.ajax({
		 type:'post',
		 url:'../company/find.do',
		 success:function(result)
		 {
			 $('#company_find').html(result);
		 }
	 });
</script>
<!-- css================================ -->
<style type="text/css">
#nav-tabContent{
	boarder:2px;
	solid:blue;
	padding:4px 4px 4px 4px;
}
.what-img{
	width: 250px;
	height: 250px;
	border: 3px solid #08088A;
	border-radius: 10px;
}
.color1{
 background-color: #CEE3F6;
}

</style>
<!-- css================================ -->
   <body>
    <main>
   <!-- ==============================================기업목록 출력 시작================================================================ -->
    <section class="whats-news-area pt-50 pb-20">
        <div class="container">
            <div class="row">
            <div class="col-lg-8">
                <div class="row d-flex justify-content-between">
                    <div class="col-lg-3 col-md-3">
                        <div class="section-tittle mb-30">
                            <h3>기업보기</h3>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <!-- Nav Card -->
                        <div class="tab-content" id="nav-tabContent">
                            <!-- card one -->
                            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">           
                                <div class="whats-news-caption">
                                    <div class="row">
                                        <c:forEach var="vo" items="${list }">
                                        	<div class="col-lg-6 col-md-6">
	                                            <div class="single-what-news mb-100">
	                                                <div class="what-img">
	                                                    <img src="${vo.clogo }" alt="company logo" border=10>
	                                                </div>
	                                                <div class="what-cap">
	                                                    <span class="color1"><img src="star.png" width=15 height=15>&nbsp;평점 ${vo.cscore }</span>
	                                                    <h6><a href="../company/detail.do?cno=${vo.cno }">${vo.cname }</a></h6>
	                                                </div>
	                                            </div>
                                       		 </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <!-- End Nav Card -->
                    </div>
                </div>
            </div>
            <!-- ================================기업검색 사이드바=================================== -->
            <div class="col-lg-4">
                <!-- Section Tittle -->
                <div class="section-tittle mb-40">
                    <h3>기업검색</h3>
                </div>
                <div class="blog_right_sidebar">
                  <aside class="single_sidebar_widget search_widget">
                     <form action="../company/find.do">
                        <div class="form-group">
                           <div class="input-group mb-3">
                              <input type="text" name="fname" class="form-control" placeholder='기업 이름 검색'
                                 onfocus="this.placeholder = ''" onblur="this.placeholder = '기업 이름 검색'">
                              <div class="input-group-append">
                                 <button class="btns" type="button"><i class="ti-search"></i></button>
                              </div>
                           </div>
                        </div>
                        <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                           type="submit">검색하기</button>
                     </form>
                  </aside>
                   <!-- ================================기업검색 사이드바=================================== -->
                  <!-- ==================================카테고리 사이드바 시작============================================ -->
                  <aside class="single_sidebar_widget post_category_widget">
                     <h4 class="widget_title">산업군</h4>
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
                  <!-- ==================================사이드바 끝============================================ -->
               </div>
            </div>
            </div>
            </div>
        </div>
    </section>
    <!-- Whats New End -->
	 <!--======================================페이지 넘기기 =========================================================================-->
    <div class="pagination-area pb-45 text-center">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="single-wrap d-flex justify-content-center">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-start">
                              <li class="page-item"><a class="page-link" href="company.do?page=${curpage>1?curpage-1:curpage }"><span class="flaticon-arrow roted"></span></a></li>
                                <li class="page-item active"><a class="page-link" href="../company/company.do?page=1">01</a></li>
                                <li class="page-item"><a class="page-link" href="../company/company.do?page=2">02</a></li>
                                <li class="page-item"><a class="page-link" href="../company/company.do?page=3">03</a></li>
                              <li class="page-item"><a class="page-link" href="company.do?page=${curpage<totalpage?curpage+1:curpage }"><span class="flaticon-arrow right-arrow"></span></a></li>
                            </ul>
                          </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End pagination  -->

        
    </body>
</html>