<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="text-align: center;">최근 방문한 질문글</h3>

	<div class="recentVisit"">
					<div class="recentVisitList">
						<div class="recentVisitBox">
							<c:forEach var="vo" items="${cList }" varStatus="s">
								<c:if test="${s.index<6 }">
								      <div class="col-md-2">
									    <div class="thumbnail">
									        <img src="${vo.gm_poster }" alt="Lights" style="width:100%">
									        <div class="caption">
									          <p>${vo.gm_subject }</p>
									        </div>
								       </div>
								     </div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
</body>
</html>