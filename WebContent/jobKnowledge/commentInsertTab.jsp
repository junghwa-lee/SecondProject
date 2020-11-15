<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$('#aaaaa').click(function(){
		location.reload();
	})
	
	$(function(){
		$('#rnoo').val(rno);
		$('#bnoo').val(bno);
		$('#sessionIDD').val(sessionID);
	});
</script>

</head>
<body>
	<%-- <div style="width:500px; hight: 150px; background-color: white; border: 1px solid black; border-radius: 5px; padding: 10px; margin-top: 20px;">
		<form action="../jobKnowledge/test.jsp" method="post">
			<textarea rows="6" cols="10" name=content
			style="background-color: white; font-size: 15px; border: none; resize: none; overflow-y:"></textarea>
			<div class="comment_bottom" style="text-align: right; width:100%;">
				<input type=submit value=댓글등록 id="aaaaa"
					style="height:30px; width:50px; background-color: #5A91CF; color:white; font-size: 13px; border: none; border-radius: 5px;">
			</div>
			<input type=hidden name=rno value="${rno}" id=rnoo>
			<input type=hidden name=id value="${sessionID}" id=sessionIDD>
			<input type=hidden name=bno value="${bno}" id=bnoo>
		</form>
	</div> --%>
	<div style="height:100px; width:100px; background-color: red;"></div>
</body>
</html>