<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	
	div.row1{
		width: 770px;
		margin-left: 40px;
	}
	
	.select1{
		width: 150px; 
		height: 40px;
		background-color: white;
		vertical-align: middle;
		
	}
	
	table.rform {
		width: 770px;
		height: 750px;
	    border-collapse: collapse;
	    text-align: left;
	    line-height: 1.5;
		margin : 20px 0px;
	}
	table.rform th {
	    padding-left: 20px;
	    font-weight: bold;
	    font-size: medium;
	    vertical-align: middle;
	    color: #153d73;
	     background-color:  rgba( 0, 0, 0, 0.03);
	    border-bottom: 10px solid #FFFFFF;
	
	}
	table.rform td {
	 
	    vertical-align: middle;
	    background-color:  rgba( 0, 0, 0, 0.03);
	    border-bottom: 10px solid #FFFFFF;
	    padding-left: 50px;
	}
	
	#cl{
	width:435px; 
	height:300px; 
    resize:vertical;
	}
	
	#sname, #bgrade{
	width: 165px;
	height: 40px;
	margin-left: 15px;
	}
	
	#smajor{
	width: 210px;
	height: 40px;
	margin-left: 15px;
	}
	
	#sdate1{
	width: 130px;
	height: 40px;
	margin-left: 1px;
	}
	
	#sdate2{
	width: 130px;
	height: 40px;
	margin-left: 1px;
	}
	
	#cdate{
	width: 250px;
	height: 40px;
	margin-left: 15px;
	}
	
	#bname{
	width: 270px;
	height: 40px;
	margin-left: 15px;
	}
	
	#bdate{
	width:250px;
	height: 40px;
	}
	
	#cname{
	width:165px;
	height: 40px;
	}
	
	#btn_group{
		width: 600px;
		margin:0 auto; 
		text-align: center;
	}
	
	#resumeBtn{ 
		margin-right:20px;
		width:200px;
		border-color: white;
		background-color: rgba( 13, 80, 163);
		color: white; 
		font-weight: bolder; 
	 } 
	 
	#resumeBtn:hover{ 
		color:black; 
		background-color:  rgba( 13, 80, 163, 0.09);
	}
	
	
	
	
	input::-webkit-input-placeholder { font-size: 10pt;  font-family: inherit;}
	input::-ms-input-placeholder { font-size: 10pt;  font-family: inherit;}
	input::placeholder { font-size: 10pt; font-family: inherit;}
	textarea::-webkit-input-placeholder { font-size: 10pt; font-family: inherit; }
	textarea::-ms-input-placeholder { font-size: 10pt;  font-family: inherit;}
	textarea::placeholder { font-size: 10pt; font-family: inherit; }
	input::

</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(function(){
	$('#resumeBtn').click(function(){
		$('#resumeFrm').submit();
	});
}); 
</script>
</head>
<body>
	
	<div class="whole-wrap" style="height: 850px">
		 <div class="row row1">
		  <form method=post action="../resume/resume_ok.do" name="resumeFrm" id="resumeFrm">
			<table class="rform">
			<!-- <input type=hidden name=no id="no"> -->
			  	<tr>
			  	  <th scope="row" width=15%>학력</th>
			  	  <td width=85%>
			  	   <div class="select">
				    <select class="select1" name=stype>
					  <option value="고등학교">고등학교</option>
					  <option value="대학(2,3년)" selected>대학(2,3년)</option>
					  <option value="대학(4년)">대학(4년)</option>
					  <option value="대학원">대학원</option>
				    </select>
			  	  	<input type=text name=sname  placeholder=" 학교명" id="sname">
					<input type=text name=smajor placeholder=" 전공명" id="smajor">
				   </div>
			  	 <div style="height: 10px"></div>
			  	   <div class="select">
					  <span style="color:black; font-size:15px; margin-left: 15px;">입학</span>
					  <input type="month" name=sdate1 id="sdate1">
					  <span style="color:black; font-size:15px; margin-left: 15px;">졸업</span>
					  <input type="month" name=sdate2 id="sdate2">
					  <select class="select1" name=state>
						<option value="졸업">졸업</option>
						<option value="졸업예정">졸업예정</option>
						<option value="재학">재학</option>
						<option value="휴학">휴학</option>
					  </select>
					</div>
			  	  </td>
			  	</tr>	
			  	
			  	<tr>
			  	  <th scope="row" width=15%>경력</th>
			  	  <td width=85%>
			  	    <div class="select">
				     <select class="select1" name=btype>
					   <option value="경영,사무">경영,사무</option>
					   <option value="영업,고객상담">영업,고객상담</option>
					   <option value="생산,제조">생산,제조</option>
					   <option value="IT,인터넷">IT,인터넷</option>
				 	   <option value="전문직">전문직</option>
					   <option value="교육">교육</option>
					   <option value="미디어">미디어</option>
					   <option value="건설">건설</option>
					   <option value="유통">유통</option>
					   <option value="서비스">서비스</option>
					   <option value="디자인">디자인</option>
					   <option value="의료">의료</option>
				     </select>
			  	  	 <input type=text name=bname  placeholder=" 회사명" id="bname">
				    </div>
			  	 <div style="height: 10px"></div>
			  	 	 <input type=text name=bdate  placeholder=" 재직기간(YY/MM/DD ~ YY/MM/DD)" id="bdate">
			  	 	 <input type=text name=bgrade  placeholder=" 직급/직책" id="bgrade">
			  	  </td>
			  	</tr>
			  	
			  	<tr>
			  	  <th scope="row" width=15%>자격증</th>
			  	  <td width=85%>
     						<input type=text name=cname  placeholder=" 자격증명" id="cname">
			  	 	<input type=text name=cdate  placeholder=" 취득일(YY/MM/DD)" id="cdate">
			  	  </td>
			  	</tr>
			  	<tr>
			  	  <th scope="row" width=15%>자기소개서</th>
			  	  <td width=85%>
			  	  	<input type=text name=subject  placeholder=" 제목을 입력하세요" id="subject" style="width: 435px; height: 35px;">
			  	  	<textarea rows="8" cols="50" name="cl" id="cl" placeholder=" 내용을 입력하세요." style="padding-top: 10px; border-top: 0px;"></textarea>
			  	  </td>
			  	</tr>
			</table>
			
			<div id="btn_group">
			 <input type=button value="등록하기" class="genric-btn radius" id="resumeBtn">
			 <!-- <input type=button value="취소" class="genric-btn danger radius" id="clBtn"
			  onclick="javascript:history.back()"> -->
			</div>
		  </form>
		 </div>
	</div>

</body>
</html>