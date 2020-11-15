<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.nav {
	padding: 10px;
}

.row2 {
	margin: 0px auto; /*가운데 정렬*/
}
</style>
</head>
<body>
	>
	<div class="container">
		<table class="table table-striped">
			<div class="row d-flex justify-content-between">
			
				<!-- 왼쪽 메인 주제 ----------------------------------------------------------------------------------- 왼쪽 메인 주제-->
				<div class="col-lg-3 col-md-3">
					<div class="section-tittle mb-30">
						<h3>기타공모전</h3>
					</div>
				</div>
				
				<!-- 카테고리가로바 ----------------------------------------------------------------------------------- 카테고리가로바-->
				<section class="whats-news-area pt-50 pb-20">
					<div class="nav">
						<div class="properties__button">
							<nav>
								<div class="nav nav-tab" id="nav-tab" role="tablist">
									<a class="nav-item nav-link active" data-toggle="tab"
										href="../gongmo/gongmo_all.do" role="tab"
										aria-controls="nav-home" aria-selected="true">전체보기</a> <a
										class="nav-item nav-link" id="nav-profile-tab"
										data-toggle="tab" href="../gongmo/gongmo_cno1.do?cno=1"
										role="tab" aria-controls="nav-profile-tab"
										aria-selected="true">기획/아이디어</a> <a class="nav-item nav-link"
										id="nav-contact-tab" data-toggle="tab"
										href="../gongmo/gongmo_cno1.do?cno=2" role="tab"
										aria-controls="nav-contact-tab" aria-selected="true">디자인</a> <a
										class="nav-item nav-link" id="nav-technology"
										data-toggle="tab" href="../gongmo/gongmo_cno1.do?cno=3"
										role="tab" aria-controls="nav-contact" aria-selected="true">광고/마케팅</a>
									<a class="nav-item nav-link" id="nav-last-tab"
										data-toggle="tab" href="../gongmo/gongmo_cno1.do?cno=4"
										role="tab" aria-controls="nav-contact" aria-selected="true">영상/광고/UCC</a>
									<a class="nav-item nav-link" id="nav-Sports" data-toggle="tab"
										href="../gongmo/gongmo_cno1.do?cno=5" role="tab"
										aria-controls="nav-contact" aria-selected="true">문학/수기/시나리오</a>
									<a class="nav-item nav-link" id="nav-technology"
										data-toggle="tab" href="../gongmo/gongmo_cno1.do?cno=6"
										role="tab" aria-controls="nav-contact" aria-selected="true">기타</a>
								</div>
							</nav>
						</div>
					</div>
				</section>
			</div>
			<!-- 게시물 ----------------------------------------------------------------------------------------------------------- 게시물 -->
			<div class="col-md-4"></div>
			<div class="col-md-8">
				<c:forEach var="vo" items="${list }">
					<div class="col-md-4 col-md-8">
						<div class="thumbnail">
							<a
								href="../gongmo/gongmo_detail.do?no=${vo.gm_no }&page=${curpage}&cno=6">
								<img src="${vo.gm_poster }" alt="Lights"
								style="width: 250px; height: 200px;">
								<div class="caption">
									<p style="font-size: 10px;">${fn:length(vo.gm_subject)>20?fn:substring(vo.gm_subject,0,20)+="...":vo.gm_subject  }</p>
								</div>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</table>
		
		<!-- 페이지 페이징 버튼 ========================================================================================= 페이지 페이징 버튼 -->
		<div class="row2">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${curpage>BLOCK }">
						<li><a href="../gongmo/gongmo_cno6.do?page=${startPage-1 }">&lt;</a></li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:if test="${i==curpage }">
							<li class="active"><a
								href="../gongmo/gongmo_cno6.do?page=${i }">${i }</a></li>
						</c:if>
						<c:if test="${i!=curpage }">
							<li><a href="../gongmo/gongmo_cno6.do?page=${i }">${i }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${endPage<totalpage }">
						<li><a href="../gongmo/gongmo_cno6.do?page=${endPage+1 }">&gt;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>