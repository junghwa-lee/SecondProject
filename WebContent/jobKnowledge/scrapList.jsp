<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/* .scrapItem{
		background-color: #4F80B8; 
		color: white;
		transition-property: background-color, color;
		transition-duration: 0.3s;
	}
	.scrapItem:hover{
		background-color: white; 
		color: black;
		cursor: pointer;
	} */
	
	#scrap_cancel_button_td{
		background-color: #9EC1E8;
		padding: 2px;
	}
	
	#scrap_calcel_button{
		background-color: #FD9999; 
		color: white;
		height: 20px;
		border: none;
		border-radius: 5px;
		transition-property: background-color;
		transition-duration: 0.3s;
	}
	#scrap_calcel_button:hover{
		background-color: #FF5757; 
	}
	
	
	#scrap_subject:hover{
		cursor: pointer;
	}
	
	
</style>
</head>
<body>
	
	
	
	
	
	
	<div class="col-lg-12" style="background-color: #9EC1E8; border-radius: 5px; min-height: 800px; border: 1px solid #437EC0;">
			<div class="scrap_area" style="padding: 40px;">						<!-- 전체 목록 div -->
				
				<h3>스크랩한 질문</h3>
				
				<div class="segment_line" style="width:100%; height: 15px; margin-bottom: 50px; border-bottom: 1px solid #797979;">
				</div>
				
				<div class="scrap_list" style="width:100%; padding:10px;">
				
					
						<table style="width:750px; font-size: 12px; background-color: white; border-radius: 5px;">
							<tr style="height: 30px;border-bottom: 1px solid #797979;">
								<th style="text-align: center; width: 15%;">글번호</th>
								<th style="text-align: center; width: 60%;">제목</th>
								<th style="text-align: center; width: 15%;">답변수</th>
								<th style="text-align: center; width: 10%;">&nbsp;</th>
							</tr>
							<tr>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
							</tr>
							<c:forEach var="scrap_vo" items="${boardList }">
								<tr class="scrapItem" 
									style="height:30px;">
									<td style="text-align: center">${scrap_vo.no }</td>
									<td id="scrap_subject" style="text-align: left" onclick="location.href='../jobKnowledge/detail.do?no=${scrap_vo.no}'">${scrap_vo.subject}</td>
									<td style="text-align: center">${scrap_vo.reply }</td>
									<td id="scrap_calcel_button_td">
										<input id="scrap_calcel_button" type=button value="취소"
												onclick="location.href='../jobKnowledge/scrap_cancel.do?no=${scrap_vo.no}'">
									</td>
								</tr>
							</c:forEach>
						</table>
					
				
				</div>
				
				<%-- <table style="border:1px solid black;">
					<c:forEach var="scrap_vo" items="${boardList }">
					<tr>
						<th>번호</th>
						<td>${scrap_vo.no }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${scrap_vo.subject}</td>
					</tr>
					<tr>
						<th>답변수</th>
						<td>${scrap_vo.reply }</td>
					</tr>
						<input type="button" value="스크랩취소${scrap_vo.no }" onclick="location.href='../jobKnowledge/scrap_cancel.do?no=${scrap_vo.no}'">
					</c:forEach>
				</table> --%>
				
																													
				
				
				
				
				
				
			</div>
		</div>
	
</body>
</html>