<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 질문하기 페이지 ============================================================================================================ -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<div class="col-lg-12" style="background-color: #9EC1E8; border-radius: 5px;">
		<form action="../jobKnowledge/modify_board_ok.do" method="post">
			<div class="do_answer" style="height: 1100px; padding:20px;">
			
				<div class="tag_area" style="margin-bottom: 20px;">															<!-- 태그 -->
					<a href="../jobKnowledge/listByTag.do?tag=${vo.tag }" style="background-color: #EEDCFF; color: #878787; border-radius: 5px; font-size:15px; padding-left: 5px; padding-right: 5px;">#${vo.tag }</a>													<!-- 태그 클릭시 태그에 맞는 게시글로 이동하는 기능 필요 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆ -->
				</div>
				
				<div class="answer_area" style="height:900px; background-color: white; border-radius: 5px; padding: 15px;">
					<div class="subject_area">																						<!-- 제목입력 -->
						<input class="subject_input" type=text name=subject value=${vo.subject }
						style="width:100%; height:60px; font-size:40px; border: none;">
					</div>
					<div class="segment_line" style="height:20px; border-bottom: 1px solid #D1D1D1; margin-bottom: 40px;">			<!-- 제목 - 내용간 구분선 -->
					</div>
					<div class="content_area">																						<!-- 내용입력 -->
						<textarea class="content_textarea" rows="33" cols="107" name=content 
						style="background-color: white; font-size: 15px; border: none; resize: none;">${vo.content }</textarea>
					</div>
				</div>
				<div class="bottom_buttons" style="margin-top: 20px; text-align: center;">											<!-- 확인, 취소버튼 -->
					<input type=submit value=수정 
					style="height:50px; width:130px; background-color: #5A91CF; color:white; font-size: 20px; border: none; border-radius: 5px; margin-right:10px;">
					<input type=button value=취소 onclick="location.href='../jobKnowledge/detail.do?no=${vo.no}'"
					style="height:50px; width:130px; background-color: white; color:#9D9D9D; font-size: 20px; border: none; border-radius: 5px; margin-left:10px;">
				</div>
			</div>
			<input type=hidden name=no value="${vo.no }">
		</form>
	</div>
</body>

</body>
</html>