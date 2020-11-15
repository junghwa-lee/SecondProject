<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send()
{
	var f=document.frm;
	// 반드시 입력을 할 수 있게 만든다 
	if(f.ss.value=="")
	{
		f.ss.focus();
		return;
	}
	f.submit();// submit버튼과 동일한 역할  ==> Jquery => NodeJS => reactjs => vuejs => typescript
}
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

.row1 {
	margin: 400px;
}

.nav {
	padding: 10px;
}

.row2 {
	margin: 0px auto; /*가운데 정렬*/
}

.p {
	font-weight: bold;
	font-size: 9px;
}
</style>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<div class="row d-flex justify-content-between">
				<!-- 왼쪽 메인 주제 ----------------------------------------------------------------------------------- 왼쪽 메인 주제-->
				<div class="col-lg-3 col-md-3">
					<div class="section-tittle mb-30">
						<h3>전체 공모전</h3>
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
				<table class="table">
       <tr>
         <td>
           <a href="main.jsp?mode=2" class="btn btn-sm btn-success">새글</a>
         </td>
       </tr>
     </table>
     <table class="table table-striped">
       <tr class="warning">
         <th class="text-center" width=45%>제목</th>
         <th class="text-center" width=15%>주최</th>
         <th class="text-center" width=20%>작성일</th>
         <th class="text-center" width=10%>조회수</th>
       </tr>
       <c:forEach var="vo" items="${list }">
         <tr>
		    <td class="text-center" width=10%>${vo.gm_subject}</td>
		    <td class="text-center" width=15%>${vo.gm_host }</td>
		    <td class="text-center" width=20%>${vo.gm_period }</td>
		    <td class="text-center" width=10%>${vo.gm_hit }</td>
		</tr>
	   </c:forEach>
     </table>
     <table class="table">
       <tr>
         <td class="text-left">
          <form method="post" action="../gongmo/gongmo_list_detail.do?cno=1" name=frm>
	          Search:
	          <select name="fd" class="input-sm">
	            <option value="name">주최</option>
	            <option value="subject">공모명</option>
	            <option value="content">내용</option>
	          </select>
	          <%-- 검색어 입력 --%>
	          <input type=text name=ss class="input-xs">
	          <input type=hidden name=mode value=4>
	          <%-- 검색버튼 --%>
	          <input type=button value=검색 class="btn btn-xs btn-danger"
	            onclick="send()">
          </form>
         </td>
         <td class="text-right">
          <a href="#" class="btn btn-xs btn-primary">이전</a>
           ${curpage } page / ${totalpage } pages
          <a href="#" class="btn btn-xs btn-primary">다음</a>
         </td>
       </tr>
     </table>
	</div>
	</table>
		<!-- 페이지 페이징 버튼 ========================================================================================= 페이지 페이징 버튼 -->
		<div class="row2">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${curpage>BLOCK }">
						<li><a href="../gongmo/gongmo_all?page=${startPage-1 }">&lt;</a></li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:if test="${i==curpage }">
							<li class="active"><a href="../gongmo/gongmo_all?page=${i }">${i }</a></li>
						</c:if>
						<c:if test="${i!=curpage }">
							<li><a href="../gongmo/gongmo_all.do?page=${i }">${i }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${endPage<totalpage }">
						<li><a href="../gongmo/gongmo_all.do?page=${endPage+1 }">&gt;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>