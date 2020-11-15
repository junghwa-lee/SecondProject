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
	 	font-size: 11pt;
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
	font-size: 9pt;
	}
	
	#sdate2{
	width: 130px;
	height: 40px;
	margin-left: 1px;
	font-size: 9pt;
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
	
	#rupdateBtn{ 
		margin-right:20px;
		width:100px;
		border-color: white;
		background-color: rgba( 13, 80, 163);
		color: white; 
		font-weight: bolder; 
		margin-right: 50px;
	 } 
	 
	#rupdateBtn:hover{ 
		color:black; 
		background-color:  rgba( 13, 80, 163, 0.09);
	}
	
	#clBtn{ 
		margin-right:20px;
		width:100px;
		border-color: white;
		background-color: rgba( 255, 162, 119);
		color: white; 
		font-weight: bolder; 
		margin-right: 50px;
	 } 
	 
	#clBtn:hover{ 
		color:black; 
		background-color: rgba( 255, 110, 43, 0.09);
	}
	
	#printBtn{
		position: absolute;
		left: 750px;
		width: 45px; 
		height: 45px;
	}
	
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(function(){
	$('#rupdateBtn').click(function(){
		$('#rupdateFrm').submit();
	});
}); 

function resumeprint()
{
	window.open("../resume/print.do?no=${vo.no }","resumeprint","width=750,height=900,scrollbars=yes");
}
</script>
</head>
<body>
	
  <div class="whole-wrap" style="height: 850px">
	 <div class="row row1">
		<form method=post action="../resume/resumeUpdate_ok.do" name="rupdateFrm" id="rupdateFrm">
			<table class="rform">
			  	<input type=hidden name=id value="${vo.id }">
			  	<input type=hidden name=no value="${vo.no }">
			  	<tr>
			  	  <th scope="row" width=15%>학력</th>
			  	  <td width=85%>
			  	   <div class="select">
				    <select class="select1" name=stype>
				   	  <option value="고등학교" ${vo.stype=="고등학교"?"selected":""}>고등학교</option>
					  <option value="대학(2,3년)" ${vo.stype=="대학(2,3년)"?"selected":""}>대학(2,3년)</option>
					  <option value="대학(4년)" ${vo.stype=="대학(4년)"?"selected":""}>대학(4년)</option>
					  <option value="대학원" ${vo.stype=="대학원"?"selected":""}>대학원</option>
				    </select>
			  	  	<input type=text name=sname  placeholder=" 학교명" id="sname" value="${vo.sname }">
					<input type=text name=smajor placeholder=" 전공명" id="smajor" value="${vo.smajor }">
				   </div>
			  	 <div style="height: 10px"></div>
			  	   <div class="select">
					  <span style="color:black; font-size:15px; margin-left: 15px;">입학</span>
					  <input type="month" name=sdate1 id="sdate1" value="${vo.sdate1 }">
					  <span style="color:black; font-size:15px; margin-left: 15px;">졸업</span>
					  <input type="month" name=sdate2 id="sdate2" value="${vo.sdate2 }">
					  <select class="select1" name=state>
						<option value="졸업" ${vo.state=="졸업"?"selected":""}>졸업</option>
						<option value="졸업예정" ${vo.state=="졸업예정"?"selected":""}>졸업예정</option>
						<option value="재학" ${vo.state=="재학"?"selected":""}>재학</option>
						<option value="휴학" ${vo.state=="휴학"?"selected":""}>휴학</option>
					  </select>
					</div>
			  	  </td>
			  	</tr>	
			  	
			  	<tr>
			  	  <th scope="row" width=15%>경력</th>
			  	  <td width=85%>
			  	    <div class="select">
				     <select class="select1" name=btype>
					   <option value="경영,사무" ${vo.btype=="경영,사무"?"selected":""}>경영,사무</option>
					   <option value="영업,고객상담" ${vo.btype=="영업,고객상담"?"selected":""}>영업,고객상담</option>
					   <option value="생산,제조" ${vo.btype=="생산,제조"?"selected":""}>생산,제조</option>
					   <option value="IT,인터넷" ${vo.btype=="IT,인터넷"?"selected":""}>IT,인터넷</option>
				 	   <option value="전문직" ${vo.btype=="전문직"?"selected":""}>전문직</option>
					   <option value="교육" ${vo.btype=="교육"?"selected":""}>교육</option>
					   <option value="미디어" ${vo.btype=="미디어"?"selected":""}>미디어</option>
					   <option value="건설" ${vo.btype=="건설"?"selected":""}>건설</option>
					   <option value="유통" ${vo.btype=="유통"?"selected":""}>유통</option>
					   <option value="서비스" ${vo.btype=="서비스"?"selected":""}>서비스</option>
					   <option value="디자인" ${vo.btype=="디자인"?"selected":""}>디자인</option>
					   <option value="의료" ${vo.btype=="의료"?"selected":""}>의료</option>
				     </select>
			  	  	 <input type=text name=bname  placeholder=" 회사명" id="bname" value="${vo.bname }">
				    </div>
			  	 <div style="height: 10px"></div>
			  	 	 <input type=text name=bdate  placeholder=" 재직기간(YY/MM/DD ~ YY/MM/DD)" id="bdate" value="${vo.bdate }">
			  	 	 <input type=text name=bgrade  placeholder=" 직급/직책" id="bgrade" value="${vo.bgrade }">
			  	  </td>
			  	</tr>
			  	
			  	<tr>
			  	  <th scope="row" width=15%>자격증</th>
			  	  <td width=85%>
     						<input type=text name=cname  placeholder=" 자격증명" id="cname" value="${vo.cname }">
			  	 	<input type=text name=cdate  placeholder=" 취득일(YY/MM/DD)" id="cdate" value="${vo.cdate }">
			  	  </td>
			  	</tr>
			  	<tr>
			  	  <th scope="row" width=15%>자기소개서</th>
			  	  <td width=85%>
			  	    <input type=text name=subject  placeholder=" 제목을 입력하세요" id="subject"  style="width: 435px; height: 35px;" value="${vo.subject }">
			  	  	<textarea rows="8" cols="55" name="cl" id="cl" placeholder=" 내용을 입력하세요." style="padding-top: 10px; border-top: 0px;">${vo.cl }</textarea>
			  	  </td>
			  	</tr>
			</table>
			
			<div id="btn_group">
			 <input type=button value="수정" class="genric-btn success radius" id="rupdateBtn">
			 <input type=button value="취소" class="genric-btn danger radius" id="clBtn" onclick="javascript:history.back()">
			 <img src="../resume/print.png" id="printBtn" onclick="resumeprint()">
			 <!-- <input type=button value="인쇄" class="genric-btn success radius" id="printBtn" onclick="resumeprint()"> -->
			</div>
		   
		  </form>
	 </div>
  </div>
	

</body>
</html>