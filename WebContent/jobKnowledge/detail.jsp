<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!-- 게시글 상세보기 페이지 ================================================================================================== -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	// 질문글삭제
	function deleteReally(){
		window.open("../jobKnowledge/deleteReally.do", "deleteReally", "width=320,height=300,scrollbars=no")
	}
	
	// 답변글삭제
	/* function deleteReally_reply(){
		window.open("../jobKnowledge/deleteReally_reply.do", "deleteReally_reply", "width=320,height=300,scrollbars=no")
	} */
	
	
	
	// 댓글입력창 활성/비활성화
	$(function(){
		$('.comment_Insert_area').hide();
		
		$('.bring_comment_tab').click(function(){				// bring_comment_tab 클릭시
			let no = $(this).attr('id')						// 변수 no는 클릭한 bring_comment_tab의 value값
			$('#comment_Insert_area' + no).toggle(); 			// #comment_Insert_area + no를 토글
		});
	
		
		// 답변글의 댓글목록 보이기
		$('.lookComment').click(function(){
			let board_no = $(this).siblings('#comment_board_no').val();
			let reply_no = $(this).siblings('#comment_reply_no').val();
			$.ajax({
				type:'post',
				data: {"board_no" : board_no, "reply_no" : reply_no},
				url:'../jobKnowledge/bringComment.do',
				success:function(result)
				{
				 $('.comment_list' + reply_no).html(result);
				}
			});
		})
		
		
		// 답변글 삭제시 비밀번호 입력창
		$('.inputPwd').hide();						// inputPwd
		
		$('.deleteReplyButton').click(function(){				// deleteReplyButton 클릭시
			let rno = $(this).attr('id')						// 변수 no는 클릭한 bring_comment_tab의 value값
			$('#inputPwd' + rno).toggle(); 			// #comment_Insert_area + no를 토글
		});
		
		$('#text-box').keyup(function (e){
		    var content = $(this).val();
		    $('#counter').html("("+content.length+" / 최대 1000자)");    //글자수 실시간 카운팅

		    if (content.length > 1000){
		        alert("최대 1000자까지 입력 가능합니다.");
		        $(this).val(content.substring(0, 800));
		        $('#counter').html("1000 / 최대 1000자");
		    }
		});
		
		// 답변삭제
		/* $('.deleteReplyButton').click(function(){
			window.open("../jobKnowledge/deleteReally_reply.do", "deleteReally_reply", "width=320,height=300,scrollbars=no");
			function getrno(){
				var rnorno = $(this).siblings('.rno');		// 답변글번호 가져오고 input에 넣기?
			}
			
		}) */
		
		
		
		
	
	// 답변글의 댓글 가져오기
		/* var board_no = $('#bno').val();		// 질문글의 번호
		var reply_no = $('#rno').val();		// 답변글의 번호
		$.ajax({
			type:'post',
			data: {"board_no" : board_no, "reply_no" : reply_no},
			url:'../jobKnowledge/bringComment.do',
			success:function(result)
			{
			 $('.comment_list').html(result);
			}
		}); */
	});
	
	
</script>
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

/* 답변 내 수정버튼 */
.modifyReplyButton{
	background-color: #5A91CF;
}
.modifyReplyButton:hover{
	background-color: #4979B0;
}

/* 답변 내 삭제버튼 */
.deleteReplyButton{
	background-color: #FD9999;
}
.deleteReplyButton:hover{
	background-color: #FF5757;
}
</style>
</head>
<body>
	<div class="col-lg-12" style="background-color: #9EC1E8; border-radius: 5px; border: 1px solid #437EC0;min-height: 800px; padding:20px; overflow-y: auto;">
	
			<div class="tag_area" style="margin-bottom: 20px;">															<!-- 태그 -->
																	<!-- 태그 클릭시 태그에 맞는 게시글로 이동하는 기능 필요 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆ -->
					<c:if test="${count==0 }">																										<!-- 스크랩하기 -->
						<div style="text-align: right;">
							<input type=button value="스크랩" onclick="location.href='../jobKnowledge/scrap.do?no=${vo.no}'">
						</div>
					</c:if>
					
					<div style="width:230px; height: 50px; background-color: white; border-radius: 5px; padding: 10px; font-size: 16px;">
						<img src="../image/medal.png" style="width:30px; height:30px;">&nbsp;&nbsp;${vo.point }
						<a href="../jobKnowledge/listByTag.do?tag=${vo.tag }" style="background-color: #EEDCFF; color: black; border-radius: 5px; font-size:16px; padding-left: 5px; padding-right: 5px; margin-left: 10px;">#${vo.tag }</a>	
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
					<c:if test="${vo.id == sessionScope.id }" >																				<!-- 세션id와 게시글 id가 같으면 수정 / 삭제 버튼 활성화 -->
						<form action="../jobKnowledge/modify_board.do" method="post" style="position: absolute; right: 5px; bottom:1px;">
							<input type=submit value="수정" class="littleButton" id="mButton">
							<input type=hidden name=no value=${vo.no } id="bno">
						</form>
					</c:if>
					<c:if test="${vo.id == sessionScope.id}" >	
						<%-- <form action="../jobKnowledge/delete_board.do" method="post" style="position: absolute; right: 50px; bottom:1px;">
							<input type=submit value="삭제">
							<input type=hidden name=no value=${vo.no }>
						</form> --%>
						<input type=button value=삭제 onclick="deleteReally()" class="littleButton" id="dButton"
						style="position: absolute; right: 70px; bottom:1px;">
						<input type=hidden value=${vo.no } id="parentId">
					</c:if>
					
				</div>
			</div>
			
			<!-- 답변입력란 ================================================================================================================================================================================== 답변입력란 -->
			<form action="../jobKnowledge/reply.do" method="post">																													<!-- 답변하기 -->
				<div class="reply_area" style="border-radius: 5px; border: 1px solid #AFAFAF;background-color: white; padding:20px; margin-top: 30px; position: relative;">
					
						<div class="reply_content_area">
							<textarea class="content_textarea" id="text-box" rows="10" cols="107" name=content placeholder="진심어린 답변을 작성해주세요."
							style="background-color: white; font-size: 15px; border: none; resize: none; overflow-y: auto; margin-bottom: 10px;"></textarea>		<!-- 답변내용 입력 -->
							<div style="height:10px; border-bottom: 1px solid #D1D1D1; margin-bottom: 50px;"></div>
							<input type="hidden" name="no" value="${vo.no }">
							<div style="display: inline; text-align: right; width:100%;">
								<span style="color:#797979; font-size: 14px;" id="counter">(0 / 최대 1000자)</span>		
							</div>																			<!-- no넘기기(답변수 증가용) -->
							<input type=submit value=답변하기 id="replyButton"
									style="height:50px; width:130px; color:white; font-size: 20px; border: none; border-radius: 5px; margin-right:10px; position: absolute; bottom: 10px; right: 10px;">
							<input type=hidden value=${vo.no } name="board_no">
						</div>
						<div class="bottom_reply">
							
						</div>
				</div>
				
			</form>
			
			
			
			<div style="width:100%; margin-top:100px; margin-bottom:20px; border-bottom: 1px solid #797979; font-size: 20px;">답변 ${vo.reply }</div>				<!-- 답변입력란 - 답변리스트간 구분선 -->
			
			<!-- 답변 리스트 ================================================================================================================================================================== 답변리스트 -->
			<c:forEach var="rVO" items="${list }">
				<div class="reply_list_area" style="background-color: #4273AB; padding:10px; border-radius: 5px; margin-top: 40px; margin-bottom: 40px;">
					<div class="reply_list" style="border-radius: 5px; border: 1px solid #D1D1D1;background-color: white; padding:20px; margin-bottom: 15px;">		<!-- 답변 전체 박스 -->
						
						<div class="subject_area" style="margin-bottom: 20px;">														<!-- 답변제목 -->
							<c:if test="${rVO.adopt == 1 }">
								<img src="../image/adopt.png" style="width:40px; height:40px; margin-right: 5px;">
							</c:if>
							<h3 style="display: inline;">${rVO.id }</h3>
						</div>
						<div class="content_area">																					<!-- 답변내용 -->
							<p>${rVO.content }</p>
							<p>${rVO.no }</p>
						</div>
						<div class="delete_modify_button" style="text-align: right;">
							<input type=button value="댓글작성" id="${rVO.no }" class="bring_comment_tab littleButton commentButton" onclick="bring_comment_tab()">
							<!-- <form method="post" action="../jobKnowledge/bringComment.do" style="display: inline;"> -->												<!-- 댓글보기 버튼 -->
								<input type=submit value="댓글보기" class="lookComment littleButton commentButton">
								<input type=hidden id="comment_board_no" name="board_no" value=${vo.no }>
								<input type=hidden id="comment_reply_no" name="reply_no" value=${rVO.no }>
							<!-- </form> -->
							<c:if test="${rVO.id == sessionScope.id }">
									<form action="../jobKnowledge/modifyReply.do" method="post" style="display: inline;">
										<input type=submit value=수정 class="littleButton modifyReplyButton">
										<input type=hidden name="board_no" value=${vo.no }>
										<input type=hidden name="reply_no" value=${rVO.no }>
									</form>
									<input type=button value=삭제  id=${rVO.no } class="littleButton deleteReplyButton">
									
							</c:if>
							
						</div>
					</div>
					
					<!-- 삭제시 비밀번호입력창 -->
					<div class="inputPwd" id="inputPwd${rVO.no }" style="text-align: right;">
						<p style="display: inline; color: red; font-weight: bold;">* 삭제한 답변은 복구할 수 없습니다. 삭제하시겠습니까?</p>
						<form action="../jobKnowledge/delete_reply.do" method="post" style="display: inline;">
							<!-- <input type="password" size=10 placeholder="비밀번호 입력" name="pwd"> -->
							<input type="submit" value="삭제" class="littleButton deleteReplyButton">
							<input type=hidden value=${rVO.no } name="rno">
							<input type=hidden value=${vo.no } name="bno">
						</form>
					</div>
					
					<!-- 채택버튼 -->
					<c:if test="${sessionScope.id == vo.id && rVO.id != sessionScope.id && adoptCount == 0}">
						<div style="text-align: right;">
							<form action="../jobKnowledge/adopt.do" method="get">
								<input type="submit" value="채택하기" class="littleButton" id="adoptButton">
								<input type="hidden" value=${vo.no } name="board_no">
								<input type="hidden" value=${rVO.no } name="reply_no">
								<input type="hidden" value=${rVO.id } name="reply_id">
							</form>
						</div>
					</c:if>
					
					<!-- 댓글입력란 ======================================================================================================================================================================== 댓글입력란 -->
					<div id="comment_Insert_area${rVO.no }" class="comment_Insert_area" 
							style="width:90%; hight: 70px; background-color: white; border: 1px solid black; border-radius: 5px; padding: 10px; margin-top: 20px; margin-left: 10%; margin-bottom: 20px;">		<!-- 댓글 다는 공간 -->
						<form action="../jobKnowledge/comment_insert.do" method="post">
							<textarea rows="3" cols="87" name=content  placeholder="댓글을 작성해주세요"
							style="background-color: white; font-size: 15px; border: none; resize: none; overflow-y:"></textarea>
							<div class="comment_bottom" style="text-align: right; width:100%;">
								<input type=submit value=댓글등록 id="insertCommentButton"
									style="height:30px; background-color: #5A91CF; color:white; font-size: 10px; border: none; border-radius: 5px;">
							</div>
							<input type=hidden name=reply_no value="${rVO.no}" id=rnoo>
							<input type=hidden name=board_no value="${vo.no}">
						</form>
					</div>
					
					
					<!-- 댓글리스트 달리는 공간 ======================================================================================================================================================================== 댓글리스트 달리는 공간 -->
					<div class="comment_list${rVO.no }">
						<jsp:include page="${comment_list_jsp }"></jsp:include>
					</div>
					
					
					
				</div>
			</c:forEach>
			
	</div>
</body>
</html>