<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
   $('.jobcalendar2').hover(function(){
      $(this).css("cursor","pointer");
   },function(){
      $(this).css("cursor","");
   })
}); 
</script>
</head>
<body>
   <!-- Start Align Area -->
   <table class="table">
   </table>
   <div class="whole-wrap">
      <div class="container box_1400">
         <!-- <div class="section-top-border">
            <h3 class="mb-30">채용공고</h3>
         </div> -->
         <div class="progress-table-wrap">
            <table class="table">
               <tr style="background-color: #495FA1; color: white;">
                  <th class="text-center" width=5%>번호</th>
                  <th class="text-center" width=15%>회사명</th>
                  <th class="text-center" width=30%>채용공고</th>
                  <!-- <th class="text-center" width=30%>경력</th>
                     <th class="text-center" width=60%>학력</th> -->
                  <th class="text-center" width=10%>근무형태</th>
                  <th class="text-center" width=10%>마감일</th>
                  <th class="text-center" width=10%>연봉</th>
                  <th class="text-center" width=10%>근무지</th>
               </tr>
               <c:forEach var="vo" items="${list}" end="9">
                  <tr>
                     <td class="text-center" width=5%>${vo.l_no }</td>
                     <td class="text-center" width=15%>${vo.lname }</td>
                     <td class="text-center" width=30%>
                        <a href="../Workb/detail.do?l_no=${vo.l_no }" 
                           style="color: black;">${vo.ltitle }</a>
                     </td>
                     <td class="text-center" width=10%>${vo.lapp_con }</td>
                     <td class="text-center" width=10%>${vo.ldeadline }</td>
                     <td class="text-center" width=10%>${vo.lsal }</td>
                     <td class="text-center" width=10%>${vo.lworkspace }</td>
                  </tr>
               </c:forEach>
            </table>
         </div>
      </div>
   </div>
   <!-- End Align Area -->
</body>
</html>