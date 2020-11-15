<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<style type="text/css">
.question{
	font-weight: bold;
	color: black;
}
.indutype{
	font-weight: bold;
	
}
#subtitle{
	font-size: small;
	font-weight: 100;
}
#letterpanel{
	border : 8px solid #E0ECF8;
	padding: 20px;
	margin: 20px;
}
.l_sidebar{
	border : 5px solid #E0ECF8;
	margin-top : 20px;
	padding: 20px;
	width: 100;
	height: 50%;
}
.sidebar_title{
	font-weight: bold;
}
#sidetitle{
	font-size :medium;
	color: black;
}
#sidetitle:hover{
	color:#5882FA;
}
</style>


<html>

   <body>
    <main>
        <!-- 합격자기소개서 상세보기 시작 -->
        <div class="about-area">
            <div class="container">
                   <div class="row">
                        <div class="col-lg-8">
     
                            <!-- 합격자소서 내용 출력 부분 -->
                            <div class="about-right mb-90" id=letterpanel>
                                <div class="section-tittle mb-30 pt-30 text-center">
                                    <h3>${vo.ssubject }</h3>
                                </div>
                                 <div class="indutype">
                                    <p id="subtitle">지원 직무 : ${vo.sindutype }</p>
                                </div>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <div class="about-prea">
                                    <p class="question">${vo.sq1 }</p>
                                </div> 
                                <div class="about-prea">
                                   <p class="about-pera1 mb-25">${vo.sa1 }</p>
                                </div>
                                <div class="about-prea">
                                    <p class="question">${vo.sq2 }</p>
                                </div> 
                                <div class="about-prea">
                                   <p class="about-pera1 mb-25">${vo.sa2 }</p>
                                </div>
                                <div class="about-prea">
                                    <p class="question">${vo.sq3 }</p>
                                </div> 
                                <div class="about-prea">
                                   <p class="about-pera1 mb-25">${vo.sa3 }</p>
                                </div>
                             </div>   
                            </div>
                            <!--=================================사이드바  -->

							  <aside class="l_sidebar">
			                     <h4 class="sidebar_title">인기 자소서 Top3</h4>
			                     &nbsp;&nbsp;&nbsp;&nbsp;
			                     <div class="media post_item">
			                        <div class="media-body">
			                        <c:forEach var="vo" items="${pList }" end="3">
			                           <a href="../selfletter/detail.do?sno=${vo.sno }">
			                              <p id="sidetitle">${vo.ssubject }</p>
			                           </a>
			                         <%--  <p>${vo.sindutype} </p> --%>
			                        </c:forEach>
			                        </div>
			                     </div>
			                  </aside>  

                            
                            
                            
                            
                            <!--=================================사이드바  -->
                            
                   </div>
                   <!-- =====================버튼그룹============================== -->
                    <div id="btn_group">
				       <input type=button value="목록" class="genric-btn danger circle" id="listBtn"
				                 onclick="javascript:history.back()">
			       </div>
			       &nbsp;&nbsp;&nbsp;&nbsp;
            </div>
        </div>
        <!-- 합격자기소개서 상세보기 끝 -->

        
        
        
    </main>
        
    </body>
</html>