<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>

<style type="text/css">
	.whole {
	    width:100%;
	    height:950px;
	    margin: 0;
  		padding-top: 80px;
  		padding-bottom: 40px;
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
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#logBtn').click(function(){
		let id=$('#log_id').val();
		if(id.trim()=="")
		{
			alert('아이디를 입력하세요');
			$('#log_id').focus();
			return;
		}
		
		let pwd=$('#log_pwd').val();
		if(pwd.trim()=="")
		{
			alert('비밀번호를 입력하세요');
			$('#log_pwd').focus();
			return;
		}
		$('#logFrm').submit(); 
	});
});
</script>
</head>

  <body>
   <div class="whole">
	<div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366; font-weight: bolder;">로그인</h2>
		</div>
		
		<div class="card-body">
		 <c:if test="${sessionScope.id==null }">
	      <div class="form-signin-heading" style="margin-bottom: 20px;">로그인이 필요한 서비스입니다.</div>
	      <form class="form-signin" method="post" action="../user/login_ok.do" id="logFrm">
	        <label for="inputEmail" class="sr-only">Your ID</label>
	        <input type="text" name=id id="log_id" class="form-control" placeholder="Your ID" required autofocus><BR>
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" name=pwd id="log_pwd" class="form-control" placeholder="Password" required><br>
	        <input type="button" class="btn btn-lg btn-primary btn-block" id="logBtn" value="로그인">
	      </form>
	     </c:if>
		</div>
		
	</div>
   </div>
	
  
  </body>
</html>