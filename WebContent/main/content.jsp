<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	$.ajax({							// 팁 가져오기
		 type:'get',
		 url:'../main/announce.do',
		 async: false,
		 dataType:'html',
		 success:function(result)
		 {
			 $('#getAnnounce').html(result);
		 }
	 })
	
	
	  $.ajax({							// 팁 가져오기
		 type:'get',
		 url:'../main/tip.do',
		 async: false,
		 dataType:'html',
		 success:function(result)
		 {
			 $('#getTip').html(result);
		 }
	 })
	 
	 
	 $.ajax({							// 지식인 가져오기
		 type:'get',
		 url:'../main/jobknowledge.do',
		 async: false,
		 dataType:'html',
		 success:function(result)
		 {
			 $('#getJobknowledge').html(result);
		 }
	 })
	 
	 
	 $.ajax({							// 비디오 가져오기
		 type:'get',
		 url:'../main/video.do',
		 async: false,
		 dataType:'html',
		 success:function(result)
		 {
			 $('#getVideo').html(result);
		 }
	 })
	 
	 
	 $.ajax({							// 공모전 가져오기
		 type:'get',
		 url:'../main/gongmo.do',
		 async: false,
		 dataType:'html',
		 success:function(result)
		 {
			 $('#getGongmo').html(result);
		 }
	 })
	 
	 
	 
	 
});

	

	
</script>

<style type="text/css">
.more{
	background-color: #DEF6FF;
	border: none;
	border-radius: 5px;
	height: 30px;
	width: 50px;
	transition-property: background-color;
	transition-duration: 0.5s;
	
}
.more:hover{
	background-color: #B7EBFF;
	cursor: pointer;
}
</style>

</head>
<body>
	<main>
    <!-- 채용공고 + 취업관련 팁 ================================================================================================ 채용공고 + 취업관련 팁 -->
    <div class="trending-area fix">
        <div class="container">
            <div class="trending-main">
                <div class="row" style="margin-top:30px">
                
                <!-- 채용공고 ============================================================================================== 채용공고 -->
                    <div class="col-lg-8">
                        <div class="trending-bottom">
                            <div class="row" id="getAnnounce">
                            
                            	
                            
                            </div>
                        </div>
                    </div>
                    
                    
				<!-- 취업관련 팁 ============================================================================================== 취업관련 팁 -->
                    <div class="col-lg-4" id="getTip">
                    
                    	
	                        
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    
   <!-- 공모전 + 취업지식인 ============================================================================================================= 공모전 + 취업지식인 -->
    <section class="whats-news-area pt-50 pb-20">
        <div class="container">
            <div class="row">
            
		<!-- 공모전 ============================================================================================================= 공모전 -->
            <div class="col-lg-8">
                <!-- <div class="row d-flex justify-content-between"> -->
                    <!-- <div class="col-lg-3 col-md-3" style="width:100%; margin:0px;">
                        <div class="section-tittle mb-30">
                            <h3 style="display: inline;">공모전</h3>
                            <div style="margin-left: 100px;display: inline;text-align: right;">
                            	
						       	<input type=button value=더보기 onclick="location.href='../gongmo/gongmo_all.do'" class="more"
						       			style="font-size:13px;">
						       </div>
                        </div>
                    </div> -->
                    <!-- <div class="col-lg-9 col-md-9">
                        <div class="properties__button">
                            Nav Button                                             
                            <nav>                                                                     
                                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">분류1</a>
                                    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">분류2</a>
                                    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">분류3</a>
                                    <a class="nav-item nav-link" id="nav-last-tab" data-toggle="tab" href="#nav-last" role="tab" aria-controls="nav-contact" aria-selected="false">분류4</a>
                                    <a class="nav-item nav-link" id="nav-Sports" data-toggle="tab" href="#nav-nav-Sport" role="tab" aria-controls="nav-contact" aria-selected="false">분류5</a>
                                    <a class="nav-item nav-link" id="nav-technology" data-toggle="tab" href="#nav-techno" role="tab" aria-controls="nav-contact" aria-selected="false">분류6</a>
                                </div>
                            </nav>
                            End Nav Button 
                        </div>
                    </div> -->
                <!-- </div> -->
                <div class="row">
                    <div class="col-12">
                        <!-- Nav Card -->
                        <div class="tab-content" id="nav-tabContent">
                            <!-- card one -->
                            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">           
                                <div class="whats-news-caption">
                                    <div class="row" id="getGongmo">
                                        
                                    </div>
                                </div>
                            </div>
                            
                            
                        </div>
                    <!-- End Nav Card -->
                    </div>
                </div>
            </div>
            
		<!-- 취업지식인 ============================================================================================================= 취업지식인 -->
            <div class="col-lg-4">
                <!-- Section Tittle -->
                <div class="section-tittle mb-40">
                    <h3 style="display: inline;">Job 지식인</h3>
                    <div style="margin-left: 175px;display: inline;text-align: right;">
                    	<input type=button value=더보기 onclick="location.href='../jobKnowledge/list.do'" class="more"
                    			style="font-size:13px;">
                    </div>
                </div>
                <div class="single-follow mb-45">
                    <div class="single-box"  id="getJobknowledge">
                    
                    </div>
                </div>
            </div>
            </div>
        </div>
    </section>
    
    
<!-- 취업관련 동영상 ==================================================================================================================== 취업관련 동영상 -->
    
    <div class="recent-articles">
        <div class="container">
           <div class="recent-wrapper">
                
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle mb-30">
                            <h3 style="display: inline;">취업관련동영상</h3>
                            <div style="margin-left: 100px;display: inline;text-align: right;">
		                    	<input type=button value=더보기 onclick="location.href='../newsTipVideo/video.do'" class="more"
		                    			style="font-size:13px;">
		                    </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="recent-active dot-style d-flex dot-style" id="getVideo">
                            
                        </div>
                    </div>
                </div>
           </div>
        </div>
    </div>           
    
    
    
    </main>
</body>
</html>