<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!-- 태그별 게시글 목록 출력하는 페이지 ============================================================================================================= -->
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.answer_box{
	transition-property: background-color;
	transition-duration: 0.5s;
}

.answer_box:hover {					/* 게시글 호버 */
	background-color:  #E7E7E7;
}
.answer_list{ -ms-overflow-style: none; } 				/* 질문 리스트 스크롤바 없애기 */
.answer_list::-webkit-scrollbar{ display:none; }

.list_option input{
	background-color: white;
	transition-property: background-color;
	transition-duration: 0.5s;
}

.list_option input:hover{
	background-color: #E7E7E7;
}

/*검색버튼*/
#searchButton{
	height: 30px;
	width: 40px;
	color: white;
	background-color: #FD9999;
	border: none;
	border-radius: 5px;
	transition-property: background-color;
	transition-duration: 0.5s;
}
#searchButton:hover{
	background-color: #FF5757;
}

/* 게시글 리스트 크기 확대 */
.answer_box{
	transition: all ease 0.1s;
}
.answer_box:hover{
	transform: scale( 1.01 );
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="col-lg-12" style="background-color: #9EC1E8; border-radius: 5px; min-height: 800px; border: 1px solid #437EC0;">
			<div class="content_area" style="padding: 20px;">						<!-- 전체 목록 div -->
				<div class="heading_area" style="height:100px; padding:15px;">						<!-- 머리부분 (태그이름 + 정렬기준) -->
					<h3>${tag }</h3>																<!-- 머리부분 제목 -->
					<div class="list_option" style="text-align: right">						<!-- 머리부분 옵션들 -->
						<input type=button value="답변적은순" id="array_by_reply" onclick="location.href='../jobKnowledge/listByReply.do'"
						style="width:100px; height:40px; font-size: 13px; border-radius: 5px; border:none;">
						<input type=button value="최신순" id="array_by_recent" onclick="location.href='../jobKnowledge/list.do'"
						style="width:100px; height:40px; font-size: 13px; border-radius: 5px; border:none;">
						
						<form method="post" style="display: inline;">
						<select class="selectpicker" onchange="window.open(value,'_self');"
							style="display: inline; width: 50px; height:10px; font-size:10px;">						<!-- 태그 셀렉트박스 (태그별 게시글 출력) -->
							<option>태그 선택</option>
							<option value="listByTag.do?tag=직무">직무</option>
							<option value="listByTag.do?tag=노동법">노동법</option>
							<option value="listByTag.do?tag=취업지원">취업지원</option>
							<option value="listByTag.do?tag=공기업">공기업</option>
							<option value="listByTag.do?tag=급여">급여</option>
							<option value="listByTag.do?tag=회사생활">회사생활</option>
							<option value="listByTag.do?tag=면접">면접</option>
							<option value="listByTag.do?tag=자기소개서">자기소개서</option>
							<option value="listByTag.do?tag=스펙">스펙</option>
							<option value="listByTag.do?tag=인적성검사">인적성검사</option>
						</select>
						</form>
					</div>
				</div>
				
				<div class="answer_list" style="overflow-y:auto; height: 600px; background-color: white; border-radius: 5px;">												<!-- 질문 리스트 공간 -->
					
						<c:forEach var="vo" items="${list }" >
							<%-- <c:choose>
								<c:when test="${i==10 }"> --%>									<!-- 10번째는 테두리 밑부분 설정 -->
								
									<div class="answer_box" style="height:150px; padding: 20px; border-top: 1px solid #9D9D9D; border-bottom: 1px solid #9D9D9D">		<!-- 개별 질문 박스 -->
										<div class="answer_box_header">																<!-- 질문박스 위의 제목 + 내용 -->
											<c:if test="${fn:length(vo.subject)>35 }">
												<a href="../jobKnowledge/detail.do?no=${vo.no }" style="text-decoration: none; color:black;">
												<span class="answer_box_header_title" style="font-weight: bold; font-size: 18pt;">${fn:substring(vo.subject, 0, 35) }...</span>
												</a>
											</c:if>
											<c:if test="${fn:length(vo.subject)<=35 }">
												<a href="../jobKnowledge/detail.do?no=${vo.no }" style="text-decoration: none; color:black;">
												<span class="answer_box_header_title" style="font-weight: bold; font-size: 18pt;">${vo.subject }</span>
												</a>
											</c:if>
											<div style="height:10px;"></div>
											
											<c:if test="${fn:length(vo.content)>50}">
												<p class="answer_box_header_content">${fn:substring(vo.content, 0, 50) }...</p>
											</c:if>
											<c:if test="${fn:length(vo.content)<=50}">
												<p class="answer_box_header_content">${vo.content }</p>
											</c:if>
										</div>
										<div class="answer_box_info" style="font-size: 9pt; margin-top:10px;">					<!-- 질문박스 아래의 정보들 -->
											<span class="answer_box_info_reply">답변${vo.reply }</span>&nbsp;&nbsp;&nbsp;
											<span class="answer_box_info_tag">${vo.tag }</span>&nbsp;&nbsp;&nbsp;
											<span class="answer_box_info_regdate"><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd"/></span>
										</div>
									</div>
								
								<%-- </c:when>
								
								<c:otherwise>
									<div class="answer_box" style="height:150px; padding: 20px; border-top: 1px solid #9D9D9D">		<!-- 개별 질문 박스 -->
										<div class="answer_box_header">																<!-- 질문박스 위의 제목 + 내용 -->
											<span class="answer_box_header_title" style="font-weight: bold; font-size: 18pt;">제목제목</span>
											<div style="height:10px;"></div>
											<p class="answer_box_header_content">내용내용내용</p>
										</div>
										<div class="answer_box_info" style="font-size: 9pt; margin-top:10px;">					<!-- 질문박스 아래의 정보들 -->
											<span class="answer_box_info_reply">답변0</span>&nbsp;&nbsp;&nbsp;
											<span class="answer_box_info_tag">급여</span>&nbsp;&nbsp;&nbsp;
											<span class="answer_box_info_regdate">방금</span>
										</div>
									</div>
								</c:otherwise> 
							</c:choose>--%>
							
						</c:forEach>
					
					
				</div>																										<!-- 질문리스트 공간 끝 -->
				<div class="text-center">
					<ul class="pagination">
						<c:if test="${currpage>block }">
							<li><a href="../jobKnowledge/list.do?page=${startpage-1 }">&lt;</a></li>
						</c:if>
						<c:forEach var="i" begin="${startpage }" end="${endpage }">
							<c:if test="${i==currpage }">
							<li class="active"><a href="../jobKnowledge/list.do?page=${i }">${i }</a></li>
							</c:if>
							<c:if test="${i!=currpage }">
							<li><a href="../jobKnowledge/list.do?page=${i }">${i }</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${endpage<totalpage }">
							<li><a href="../jobKnowledge/list.do?page=${endpage+1 }">&gt;</a></li>
						</c:if>
					</ul>
					
					<div style="text-align: right;">
						<form action="../jobKnowledge/search.do" style="display: inline-block; margin-right:15px;">
							<select name="finding" class="dropup">
								<option value="subject" selected="selected">제목</option>
								<option value="content">내용</option>
								<option value="id">글쓴이</option>
							</select>
							<input type=text name="voca" size=25 placeholder="검색어 입력" style="height:30px; border: none; border-radius: 5px; margin-left:15px;">
							<input type=submit value=검색 id="searchButton">
						</form>
					</div>
					
				</div>
				
				
				
				
				
				
				
				
			</div>
		</div>
</body>
</html>