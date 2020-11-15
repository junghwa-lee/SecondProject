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
$(function(){
    $.ajax({
       type:'post',
       url:'../jobcalendar/date.do',
       success:function(result)
       {
          $('#jobcalendar_date').html(result);
       }
    });
    
    $.ajax({
       type:'post',
       url:'../jobcalendar/jobcalendar2.do',
       success:function(result)
       {
          $('#jobcalendar2_info').html(result);
       }
    }) 
});
</script>
</head>
<body>
   <div style="height: 30px"></div>
   <div class="row">
      <table class="table">
      <tr>
       <td width=40% height=500>
         <table class="table">
           <%-- <caption class="text-center"> --%>
           <h5 class="text-left">채용 달력</h5>
           <%-- </caption> --%>
           <tr>
             <td>
               <div id="jobcalendar_date"></div>
             </td>
           </tr>
         </table>
       </td>
       <td width=60% height=500>
         <table class="table">
           <h5 class="text-left">채용 정보</h5>
           <tr>
             <td>
               <div id="jobcalendar2_info"></div>
             </td>
           </tr>
         </table>
          </td>
     </tr>
   </table>
  </div>
</body>
</html>