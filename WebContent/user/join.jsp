<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>

<style type="text/css">
	.whole {
	    width:100%;
	    height:950px;
	    margin: 0;
  		padding-top: 80px;
  		padding-bottom: 40px;
  		/* font-family: "Nanum Gothic", arial, helvetica, sans-serif; */
  		background-repeat: no-repeat;
  		background:rgba( 35, 80, 142, 0.1); 
	}
	
    .card {
        margin: 0 auto; 
        float: none; 
        margin-bottom: 10px; 
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
	
	#logBtn{
		background-color:  rgba( 13, 80, 163);
	}
	
	#content { 
		height: 10px; 
		line-height: 10px;
		font-size: x-large;
		font-weight: bolder;
		margin: 0px auto;
	}
	
	table.userform {
		width: 600px;
		height: 650x;
	    border-collapse: collapse;
	    text-align: left;
	    line-height: 1.5;
	    border-top: 1px solid #ccc;
		margin : 0px auto;
		
	}
	table.userform th {
	    padding: 10px;
	    font-weight: bold;
	    font-size: medium;
	    vertical-align: middle;
	    color: #153d73;
	    border-bottom: 1px solid rgba(0,0,0,0.1);
	
	}
	table.userform td {
	    padding: 10px;
	    vertical-align: top;
	    border-bottom: 1px solid rgba(0,0,0,0.1);
	    vertical-align: middle;
	}
	
	#btn_group{
		width: 600px;
		margin:0 auto; 
		text-align: center;
	}
	
	#joinBtn{ 
		margin-right:20px;
		width:200px;
		border-color: white;
		background-color: rgba( 13, 80, 163);
		color: white; 
		font-weight: bolder; 
	 }
	
	#joinBtn:hover{ 
		color:black; 
		background-color:  rgba( 13, 80, 163, 0.09);
	}
	
	
	#button{
		width: 130px;
		border-color: white;
		background-color: rgba( 13, 80, 163, 0.6);
		color: white; 
		font-weight: bolder; 
		text-align: center;
		margin: 0 auto;
	}
	
	input::-webkit-input-placeholder { font-size: 10pt;  font-family: inherit;}
	input::-ms-input-placeholder { font-size: 10pt;  font-family: inherit;}
	input::placeholder { font-size: 10pt; font-family: inherit;}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
function postfind()
{
	new daum.Postcode({
		oncomplete:function(data)
		{
			$('#post').val(data.zonecode);
			$('#addr1').val(data.address);
		}
	}).open();
}
function idcheck()
{
	window.open("../user/idcheck.do","idcheck","width=320,height=300,scrollbars=no");
}

$(function(){
	$('#joinBtn').click(function(){
		let id=$('#id').val();
		if(id.trim()=="")
		{
			$('#id').focus();
			return;
		}
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		
		let pwd1=$('#pwd1').val();
		if(pwd1.trim()=="")
		{
			$('#pwd1').focus();
			return;
		}
		
		if(pwd!==pwd1)
		{
			alert("비밀번호를 다시 입력하세요");
			$('#pwd1').val("");
			$('#pwd1').focus();
			return;
		}
		
		let name=$('#name').val();
		if(name.trim()=="")
		{
			$('#name').focus();
			return;
		}
		
		let birthday=$('#birthday').val();
		if(birthday.trim()=="")
		{
			$('#birthday').focus();
			return;
		}
		
		
		let post=$('#post').val();
		if(post.trim()=="")
		{
			$('#post').focus();
			return;
		}
		
		let addr1=$('#addr1').val();
		if(addr1.trim()=="")
		{
			$('#addr1').focus();
			return;
		}
		
		$('#joinFrm').submit();
	});
});
</script>
</head>

  <body>
   <div class="whole">
	<div class="card align-middle" style="width:700px; border-radius:20px;">
		<div class="card-title" style="margin-top:30px; height: 30px;">
			<h2 class="card-title text-center" style="color:#113366; font-weight: bolder;">회원가입</h2>
		</div>
		
		<div class="card-body">
		<form method=post action="../user/join_ok.do" name="joinFrm" id="joinFrm">
					
					<table class="userform">
					  	<tr>
					  	  <th scope="row" width=30%>아이디*</th>
					  	  <td width=70%>
					  	  	<input type=text name=id class="input-sm" size=15 style="margin-right: 15px;" readonly id="id">
					  	  	<input type=button value="중복체크" class="genric-btn radius small" id="button" onclick="idcheck()">
					  	  </td>
					  	</tr>	
					  	<tr>
					  	  <th scope="row" width=30%>비밀번호*</th>
					  	  <td width=70%>
					  	  	<input type=password name=pwd class="input-sm" size=15 id="pwd">
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>비밀번호확인*</th>
					  	  <td width=70%>
       						<input type=password name=pwd1 class="input-sm" size=15 id="pwd1">
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>이름*</th>
					  	  <td width=70%>
					  	  	<input type=text name=name class="input-sm" size=15 id="name">
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>이메일</th>
					  	  <td width=70%>
					  	  	<input type=text name=email class="input-sm" size=45>
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>생년월일*</th>
					  	  <td width=70%>
					  	  	<input type=date name=birthday class="input-sm" size=25 id="birthday">
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>성별</th>
					  	  <td width=70%>
					  	  	<input type=radio name=sex id="male" value="남">
					  	  	<label for="male">남</label>
					  	  	<input type=radio name=sex id="female" style="margin-left: 30px;" value="여">
					  	  	<label for="female">여</label>
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>우편번호*</th>
					  	  <td width=70%>
					  	  	<input type=text name=post class="input-sm" size=7 style="margin-right: 15px;" readonly id="post">
       						<input type=button value="우편번호찾기" style="padding-left: 20px;" class="genric-btn radius small" id="button" onclick="postfind()">
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>주소*</th>
					  	  <td width=70%>
					  	  	<input type=text name=addr1 class="input-sm" size=45 readonly id="addr1">
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>상세주소</th>
					  	  <td width=70%>
					  	  	<input type=text name=addr2 class="input-sm" size=45>
					  	  </td>
					  	</tr>
					  	<tr>
					  	  <th scope="row" width=30%>전화번호</th>
					  	  <td width=70%>
					        <input type=text name=tel class="input-sm" size=25 placeholder="  숫자만 입력">
					       </td>
					  	</tr>
					</table>
					<div style="height: 20px;"></div>
					<div id="btn_group">
					 <input type=button value="가입하기" class="genric-btn radius" id="joinBtn">
					 <!-- <input type=button value="취소" class="genric-btn danger radius" id="cancleBtn"
					  onclick="javascript:history.back()"> -->
					</div>
					 
				   </form>
		</div>
		
	</div>
   </div>
	
  
  </body>
</html>