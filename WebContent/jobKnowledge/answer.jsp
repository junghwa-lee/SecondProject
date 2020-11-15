<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 질문하기 페이지 ============================================================================================================ -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#text-box').keyup(function (e){
	    var content = $(this).val();
	    $('#counter').html("("+content.length+" / 최대 1000자)");    //글자수 실시간 카운팅

	    if (content.length > 1000){
	        alert("최대 1000자까지 입력 가능합니다.");
	        $(this).val(content.substring(0, 800));
	        $('#counter').html("1000 / 최대 1000자");
	    }
	});


});
</script>
<style type="text/css">
.subject_input::placeholder{
	color: #B4B4B4;
	font-size: 40px;
	
}
.content_textarea::placeholder{
	color: #B4B4B4;
}
</style>
</head>
<!-- 
직무
노동법
취업지원
공기업
급여
회사생활
면접
자기소개서
스펙
인적성검사
 -->
<body>
	<div class="col-lg-12" style="background-color: #9EC1E8; border-radius: 5px; border: 1px solid #437EC0;">
		<form action="answer_ok.do" method="post">
			<div class="do_answer" style="height: 1000px; padding:20px;">
				<div class="select_tag" style="height: 60px;">
					<select class="select_box" name="tag" style="display: inline; width: 50px; height:30px; font-size:40px;">		<!-- 태그 셀렉트박스 -->
						<option value="직무">직무</option>
						<option value="노동법">노동법</option>
						<option value="취업지원">취업지원</option>
						<option value="공기업">공기업</option>
						<option value="급여">급여</option>
						<option value="회사생활">회사생활</option>
						<option value="면접">면접</option>
						<option value="자기소개서">자기소개서</option>
						<option value="스펙">스펙</option>
						<option value="인적성검사">인적성검사</option>
					</select>
				</div>
				<div class="answer_area" style="height:750px; background-color: white; border-radius: 5px; padding: 15px; border: 1px solid #AFAFAF;">
					<div class="subject_area">																						<!-- 제목입력 -->
						<input class="subject_input" type=text name=subject placeholder="질문 제목을 입력해주세요."
						style="width:100%; height:60px; font-size:40px; border: none;">
					</div>
					<div class="segment_line" style="height:20px; border-bottom: 1px solid #D1D1D1; margin-bottom: 40px;">			<!-- 제목 - 내용간 구분선 -->
					</div>
					<div class="content_area">																						<!-- 내용입력 -->
						<textarea class="content_textarea" id="text-box" rows="23" cols="107" name=content placeholder="구체적인 내용을 입력해주세요."
						style="background-color: white; font-size: 15px; border: none; resize: none;"></textarea>
					</div>
					<div style="width:100%; height:20px; border-bottom: 1px solid #D1D1D1; margin-bottom: 20px;"></div>
					<div class="point_area" style="text-align: right; font-size: 14px;">
						<span style="color:#aaa; margin-right: 30px;" id="counter">(0 / 최대 1000자)</span>
						<img src="../image/medal.png" style="width:30px; height:30px;">
						포인트 : <input type="text" name=point size=10 placeholder="포인트 입력" style="border:1px solid #D1D1D1; border-radius: 5px; text-align: center;">
					</div>
				</div>
				<div class="bottom_buttons" style="margin-top: 20px; text-align: center;">											<!-- 확인, 취소버튼 -->
					<input type=submit value=확인 
					style="height:50px; width:130px; background-color: #5A91CF; color:white; font-size: 20px; border: none; border-radius: 5px; margin-right:10px;">
					<input type=button value=취소 onclick="javascript:history.back()"
					style="height:50px; width:130px; background-color: white; color:#9D9D9D; font-size: 20px; border: none; border-radius: 5px; margin-left:10px;">
				</div>
			</div>
		</form>
	</div>
</body>
</html>