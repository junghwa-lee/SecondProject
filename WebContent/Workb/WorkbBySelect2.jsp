<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!-- 태그별 게시글 목록 출력하는 페이지 ============================================================================================================= -->
<!DOCTYPE html>
<html>
<body>
	<div class="whole-wrap">
		<div class="container box_1170">
			<div class="section-top-border">
				<h3 class="mb-30">채용공고</h3>
				<div class="list_option" style="text-align: right;">					
						<form method="post" style="display: inline;">
						<select class="selectpicker" onchange="window.open(value,'_self');"
							style="display: inline; width: 50px; height:10px; font-size:10px;">						<!-- 태그 셀렉트박스 (태그별 게시글 출력) -->
							<option>태그 선택</option>		
							<option value="WorkbBySelect2.do?lcateno=11">경영.사무</option>
							<option value="WorkbBySelect2.do?lcateno=12">영업.CS</option>
							<option value="WorkbBySelect2.do?lcateno=13">IT</option>
							<option value="WorkbBySelect2.do?lcateno=14">디자인</option>
							<option value="WorkbBySelect2.do?lcateno=15">전문직</option>
							<option value="WorkbBySelect2.do?lcateno=16">의료</option>
							<option value="WorkbBySelect2.do?lcateno=17">생산</option>
							<option value="WorkbBySelect2.do?lcateno=18">건설</option>
							<option value="WorkbBySelect2.do?lcateno=19">미디어</option>
							<option value="WorkbBySelect2.do?lcateno=20">교육</option>
							<tr>
								<td>
       								<input type=text id="keyword" size=15 placeholder="검색어 입력">
     							 </td>
     						</tr>
						</select>
						</form>
					</div>
				</div>
				<div class="progress-table-wrap">
					<table class="table">
						<tr>
							<th class="text-center" width=5%>번호</th>
							<th class="text-center" width=15%>회사명</th>
							<th class="text-center" width=30%>채용공고</th>
							<!-- <th class="text-center" width=30%>경력</th>
							<th class="text-center" width=60%>학력</th> -->
							<th class="text-center" width=10%>근무형태</th>
							<th class="text-center" width=10%>마감일</th>
							<th class="text-center" width=10%>연봉</th>
							<th class="text-center" width=10%>근무지</th>
						</tr>
						<c:forEach var="vo" items="${list }" end="9">
						<tr>
							<td class="text-center" width=5%>${vo.l_no }</td>
							<td class="text-center" width=15%>${vo.lname }</td>
							<td class   ="text-center" width=30%>
								<a href="../Workb/detail2.do?l_no=${vo.l_no }" style="color:black;">${vo.ltitle }</a>
							</td>
							<td class="text-center" width=10%>${vo.lapp_con }</td>
							<td class="text-center" width=10%>${vo.ldeadline }</td>
							<td class="text-center" width=10%>${vo.lsal }</td>
							<td class="text-center" width=10%>${vo.lworkspace }</td>
						</tr>
						</c:forEach>
					</table>
					<table>
				        <tr>
				          <td class="text-right">
				            <a href="workb.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-xs btn-danger">이전</a>
				              ${curpage } page / ${totalpage } pages
				            <a href="workb.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-xs btn-primary">다음</a>
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