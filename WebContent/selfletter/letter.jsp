<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<style type="text/css">
.line:hover{
	background-color: #CEF6F5;
}
</style>
<html>
<body>
	<!-- Start Align Area -->
	<div class="whole-wrap">
		<div class="container box_1170">
			<div class="section-top-border">
				<h3 class="mb-30">합격 자기소개서</h3>
				<div class="progress-table-wrap">
				<div class=button>
					<a href="../selfletter/insert.do" class="genric-btn success circle">새글쓰기</a>
				</div>
				<br>
					<table class="table">
						<tr>
							<th class="text-center" width=10%>번호</th>
							<th class="text-center" width=30%>지원직무</th>
							<th class="text-center" width=60%>제목</th>
						</tr>
						<c:forEach var="vo" items="${list }" end="9">
						<tr class="line">
							<td class="text-center" width=10%>${vo.sno }</td>
							<td class="text-center" width=30%>${vo.sindutype }</td>
							<td class="text-center" width=60%>
								<a href="../selfletter/detail.do?sno=${vo.sno }" style="color:black;">${vo.ssubject }</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<br>
					<table class="text-center"  style="margin: 0px auto;">
				        <tr>
				          <td class="text-center">
				            <a href="letter.do?page=${curpage>1?curpage-1:curpage }" class="genric-btn danger circle">이전</a>
				              ${curpage } page / ${totalpage } pages
				            <a href="letter.do?page=${curpage<totalpage?curpage+1:curpage }" class="genric-btn danger circle">다음</a>
				          </td>
				        </tr>
				    </table>
				</div>
			</div>
		</div>
	</div>
	<!-- End Align Area -->
      
</body>
</html>