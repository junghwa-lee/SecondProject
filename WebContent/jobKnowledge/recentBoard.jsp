<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
	<h3 style="text-align: center;">최근 방문한 질문글</h3>
					<div style="width:100%; height:10px; margin-bottom: 10px; border-bottom: 1px solid #797979;">
					</div>
	<div class="recentVisit" style="width: 100%; text-align: left;">
					<div class="recentVisitList" style="width:100%;">
						<div class="recentVisitBox">
							<c:forEach var="cvo" items="${cList }" varStatus="s">
								<c:if test="${s.index < 5 }">
								<div class="answer_box_header">																<!-- 최근 방문한 질문글 -->
									<c:if test="${fn:length(cvo.subject)>22 }">
										<div class="recentVisitButton" onclick="location.href='../jobKnowledge/detail.do?no=${cvo.no }';"
										style="cursor:pointer; height: 30px; width: 100%;  border-radius: 5px; margin-top: 10px; margin-bottom: 10px; padding:5px;">
											<a href="../jobKnowledge/detail.do?no=${cvo.no }" style="text-decoration: none; line-height: 20px; font-size: 12px;">
											${fn:substring(cvo.subject, 0, 22) }...
											</a>
										</div>
									</c:if>
									<c:if test="${fn:length(cvo.subject)<=22 }">
										<div class="recentVisitButton" onclick="location.href='../jobKnowledge/detail.do?no=${cvo.no }';"
										style="cursor:pointer; height: 30px; width: 100%; border-radius: 5px; margin-top: 10px; margin-bottom: 10px; padding:5px;">
											<a href="../jobKnowledge/detail.do?no=${cvo.no }" style="text-decoration: none; line-height: 20px; font-size: 12px;">
											${cvo.subject }
											</a>
										</div>
									</c:if>
								</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
</body>
</html>