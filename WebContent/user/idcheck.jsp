<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
    margin: 0px auto;
    width:300px;
    height: 200px;
}
#idcheckBtn{
	width:45px;
	height:27px;
	margin-left: 5px;
	background-color:  rgba( 13, 80, 163, 0.6);
	border-color: white;
	color: white;
	padding-right: 5px;
	text-align: left;
}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#idcheckBtn').click(function(){
		let id=$('#id').val();
		if(id=="")
		{
			$('#id').focus();
			return;
		}
		$.ajax({
			type:'post',
			url:'../user/idcheck_ok.do',
			data:{"id":id},   
			success:function(result)
			{
				let count=result.trim();  
				if(count==0)
				{
					$('#idcheck_result').html("<font color=blue>사용 가능한 아이디입니다</font>");
					$('#ok').html('<input type=button value=확인 onclick="ok()">')
				}
				else 
				{
					$('#idcheck_result').html("<font color=red>이미 사용중인 아이디입니다</font>");
				}
			}
		})
	})
});
function ok()
{
	opener.joinFrm.id.value=$('#id').val();
	self.close();
}
</script>

	<!-- CSS here -->
   <link rel="stylesheet" href="assets/css/bootstrap.min.css">
   <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
   <link rel="stylesheet" href="assets/css/slicknav.css">
   <link rel="stylesheet" href="assets/css/animate.min.css">
   <link rel="stylesheet" href="assets/css/magnific-popup.css">
   <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
   <link rel="stylesheet" href="assets/css/themify-icons.css">
   <link rel="stylesheet" href="assets/css/slick.css">
   <link rel="stylesheet" href="assets/css/nice-select.css">
   <link rel="stylesheet" href="assets/css/style.css">
   <link rel="stylesheet" href="assets/css/responsive.css">
   
</head>

<body>
 
  <div class="container box_1170" >
     <div class="row" style="text-center">
       <div style="margin:0 auto">
         <div style="height: 30px" ></div>
       		<h3 class="text-center">아이디 중복체크</h3><br>
      		<input type=text id=id class="input-sm" size=15 > 
            <input type=button value=" 확 인 " id="idcheckBtn" >
      		<div style="height: 20px" ></div>
         	<div class="text-center" id="idcheck_result"></div><br>
         	<div class="text-center" id="ok"></div>
       </div>
     </div>
   </div> 

	    <!-- JS here -->
		<!-- All JS Custom Plugins Link Here here -->
        <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
		
		<!-- Jquery, Popper, Bootstrap -->
		<script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="./assets/js/popper.min.js"></script>
        <script src="./assets/js/bootstrap.min.js"></script>
	    <!-- Jquery Mobile Menu -->
        <script src="./assets/js/jquery.slicknav.min.js"></script>

		<!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="./assets/js/owl.carousel.min.js"></script>
		<script src="./assets/js/slick.min.js"></script>
		
		<!-- One Page, Animated-HeadLin -->
        <script src="./assets/js/wow.min.js"></script>
		<script src="./assets/js/animated.headline.js"></script>
		<script src="./assets/js/jquery.magnific-popup.js"></script>
		
		<!-- Scrollup, nice-select, sticky -->
        <script src="./assets/js/jquery.scrollUp.min.js"></script>
        <script src="./assets/js/jquery.nice-select.min.js"></script>
		<script src="./assets/js/jquery.sticky.js"></script>
        
        <!-- contact js -->
        <script src="./assets/js/contact.js"></script>
        <script src="./assets/js/jquery.form.js"></script>
        <script src="./assets/js/jquery.validate.min.js"></script>
        <script src="./assets/js/mail-script.js"></script>
        <script src="./assets/js/jquery.ajaxchimp.min.js"></script>
        
		<!-- Jquery Plugins, main Jquery -->	
        <script src="./assets/js/plugins.js"></script>
        <script src="./assets/js/main.js"></script>
        
</body>
</html>


