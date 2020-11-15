<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	width: 600px; 
	border: 1px solid black;
	border-collapse: collapse;
	margin-left: 30px;
	font-size: 10pt;
}
th{
	border: 1px solid black;
}
.t1 td {
	padding-left: 15px;
	border: 1px solid black;
}
.t2 td{
	text-align: center;
	border: 1px solid black;
}
.t3 td{
	height: 270px; 
	vertical-align:top;
	padding-top: 10px;
	padding-left: 15px;
}

</style>
</head>
<body>
	<table class="t1" style="height: 150px;">
	  <h4 style="margin-left: 30px; margin-bottom: 5px;">인적사항</h4>
	  <tr>
	  	<th width="15%">이름</th>
	  	<td width="35%">${uvo.name }</td>
	  	<th width="15%">생년월일</th>
	  	<td width="35%">${uvo.birthday }</td>
	  </tr>
	  <tr>
	  	<th width="15%">이메일</th>
	  	<td width="35%">${uvo.email }</td>
	  	<th width="15%">전화번호</th>
	  	<td width="35%">${uvo.tel }</td>
	  </tr> 
	  <tr>
	  	<th width="50px">주소</th>
	  	<td colspan="3">(${uvo.post })&nbsp;${uvo.addr1 }&nbsp;${uvo.addr2 }</td>
	  </tr>
	</table>
	
	<table class="t2" style="height: 70px;">
	  <h4 style="margin-left: 30px; margin-bottom: 5px;">학력사항</h4>
	  <tr height="35%">
	  	<th width="30%">학교명</th>
	  	<th width="20%">전공</th>
	  	<th width="20%">졸업상태</th>
	  	<th width="30%">재학기간</th>
	  </tr>
	  <tr height="65%">
	  	<td width="30%">${vo.sname}</td>
	  	<td width="20%">${vo.smajor}</td>
	  	<td width="20%">${vo.state}</td>
	  	<td width="30%">${vo.sdate1}&nbsp; ~ &nbsp;${vo.sdate2}</td>
	  </tr>
	</table>
    
    <table class="t2" style="height: 70px;">
	  <h4 style="margin-left: 30px; margin-bottom: 5px;">경력사항</h4>
	  <tr height="35%">
	  	<th width="30%">회사명</th>
	  	<th width="20%">직종</th>
	  	<th width="20%">직급/직책</th>
	  	<th width="30%">재직기간</th>
	  </tr>
	  <tr height="65%">
	  	<td width="30%">${vo.bname}</td>
	  	<td width="20%">${vo.btype}</td>
	  	<td width="20%">${vo.bgrade}</td>
	  	<td width="30%">${vo.bdate}</td>
	  </tr>
	</table>
	
	<table class="t2" style="height: 70px;">
	  <h4 style="margin-left: 30px; margin-bottom: 5px;">자격사항</h4>
	  <tr height="35%">
	  	<th width="60%">자격증명</th>
	  	<th width="40%">취득일</th>
	  </tr>
	  <tr height="65%">
	  	<td width="60%">${vo.cname}</td>
	  	<td width="40%">${vo.cdate}</td>
	  </tr>
	</table>
	
	<table class="t3" style="height: 70px;">
	  <h4 style="margin-left: 30px; margin-bottom: 5px;">자기소개서</h4>
	  <tr>
	  	<td>${vo.cl}</td>
	  </tr>
	</table>
	
</body>
</html>