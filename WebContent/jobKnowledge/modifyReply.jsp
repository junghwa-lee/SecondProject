<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* 답변하기 버튼 */
#replyButton{								
	background-color: #5A91CF;
	transition-property: background-color;
	transition-duration: 0.5s;
}
#replyButton:hover{
	background-color: #4979B0;
}
/* 질문글 아래쪽 닉네임, 조회수, 작성일 */
.bottom_info span{
	font-size: 15px;
	color: #878787;
}

/*질문글 및 답변의 수정/삭제 버튼*/
.littleButton{
	width:50px;
	height: 30px;
	border: none;
	border-radius: 5px;
	transition-property: background-color;
	transition-duration: 0.5s;
	color: white;
}
/*삭제버튼*/
#dButton{
	background-color: #FD9999;
}
#dButton:hover{
	background-color: #FF5757;
}
/*수정버튼*/
#mButton{
	background-color: #5A91CF;
}
#mButton:hover{
	background-color: #4979B0;
}

/*채택버튼*/
#adoptButton{
	background-color: #3EEB60; 
}
#adoptButton:hover{
	background-color: #33B04C; 
}


/* 답변 내 댓글작성, 댓글보기 버튼 */
.commentButton{
	background-color: #F575FF;
}
.commentButton:hover{
	background-color: #AA4EB1;
}
</style>
</head>
<body>

	<div class="col-lg-12" style="background-color: #9EC1E8; border-radius: 5px; border: 1px solid #437EC0;min-height: 800px; padding:20px; overflow-y: auto;">
	
			<div class="tag_area" style="margin-bottom: 20px;">															<!-- 태그 -->
																	<!-- 태그 클릭시 태그에 맞는 게시글로 이동하는 기능 필요 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆ -->
					
					<div style="width:190px; height: 50px; background-color: white; border-radius: 5px; padding: 10px; font-size: 16px;">
						<img src="../image/medal.png" style="width:30px; height:30px;">&nbsp;&nbsp;${vo.point }
						<a href="../jobKnowledge/listByTag.do?tag=${board_vo.tag }" style="background-color: #EEDCFF; color: black; border-radius: 5px; font-size:16px; padding-left: 5px; padding-right: 5px; margin-left: 10px;">#${vo.tag }</a>	
					</div>
			</div>
			
			<!-- 질문글 ==================================================================================================================================================== 질문글 -->
			<div class="answer_box" style="border-radius: 5px; border: 1px solid #AFAFAF;background-color: white; padding:20px;">		<!-- 게시글 전체 박스 -->
				
				<div class="subject_area" style="margin-bottom: 20px;">														<!-- 제목 -->
					<i style="display: inline; font-size: 20px; color: #386BFF;">Q&nbsp;&nbsp;&nbsp;</i><h3 style="display: inline;">${vo.subject }</h3>
				</div>
				<div class="content_area">
					<p>${vo.content }</p>
				</div>
			</div>
			
			<div class="bottom_area" style="margin-top: 20px;">
				<div class="bottom_info" style="position: relative;">
					<span style="color: #636363; font-weight: bold;">${vo.id }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;&nbsp;&nbsp;
					<span>조회수&nbsp;${vo.hit }</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;&nbsp;&nbsp;
					<span>작성일&nbsp;<fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd"/></span>					
				</div>
			</div>
			
			
			
			
			<div style="width:100%; margin-top:100px; margin-bottom:20px; border-bottom: 1px solid #797979; font-size: 20px;"></div>				<!-- 답변입력란 - 답변리스트간 구분선 -->
			
			
			
			
			
			<div class="reply_list_area" style="background-color: #4273AB; padding:10px; border-radius: 5px; margin-top: 40px; margin-bottom: 40px;">
				<form action="../jobKnowledge/modifyReply_ok.do">
					<div class="reply_list" style="border-radius: 5px; border: 1px solid #D1D1D1;background-color: white; padding:20px; margin-bottom: 15px;">		<!-- 답변 전체 박스 -->
						
						<div class="subject_area" style="margin-bottom: 20px;">														<!-- 답변제목 -->
							<h3 style="display: inline;">${rVO.id }</h3>
						</div>
						<div class="content_area">																					<!-- 답변내용 -->
							<textarea class="content_textarea" rows="10" cols="107" name=reply_content 
						style="background-color: white; font-size: 15px; border: none; resize: none;">${rVO.content }</textarea>
							<p>${rVO.no }</p>
						</div>
						<div class="modify_button" style="text-align: right;">
							<input type=submit value=수정완료  id=${rVO.no } class="littleButton deleteReplyButton">
							<input type=hidden name="board_no" value=${vo.no }>
							<input type=hidden name="reply_no" value=${rVO.no }>
						</div>
					</div>
				</form>
					
			</div>
	
	</div>

</body>
</html>