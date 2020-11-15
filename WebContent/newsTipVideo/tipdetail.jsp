<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;
let u=0;
$(function(){
	$('.tip_reply_reply').click(function(){
	  $('.rIn').hide();
	  $('.rUp').hide();
	  $('.tip_reply_reply').text("대댓글");
	  let no=$(this).attr('value');
	  if(i==0)
	  {
		    
			$('#rIn'+no).show();
			$(this).text("취소");
			i=1;
	  }
	  else
	  {
		    $('#rIn'+no).hide();
		    $(this).text("대댓글");
			i=0;
	  }
		
	});
	
	$('.tip_reply_update').click(function(){
		let no=$(this).attr("value");
		$('.rIn').hide();
		$('.rUp').hide();
		if(u==0)
		{
			$('#rUp'+no).show();
			u=1;
		}
		else
		{
			$('#rUp'+no).hide();
			u=0;
		}
	})
	let d=0;
	$('#delBtn').click(function(){
		if(d==0)
		{
			$('#delTr').show();
			d=1;
		}
		else
		{
			$('#delTr').hide();
			d=0;
		}
	});
});
</script>
 <script>
 $(function(){  
    $('#link').click(function(){
        $( "#dialog" ).dialog();
    })
  });
  </script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
.detailcontainer {text-align:center;}
.viewPage .viewAtc .infoBx {padding:13px 30px 35px; margin-bottom:60px; border:1px solid #e6e6e6; position:relative;}
.viewPage .viewAtc .viewWrap{padding:0 60px; line-height:1.8;word-break:keep-all; word-wrap:break-word; color:#333;}
.viewPage .viewAtc .viewWrap img{max-width:100%;}
.viewPage .viewAtc .viewWrap table{width:auto !important; table-layout:fixed !important;}
.viewPage .viewAtc .infoBx .tit{padding-top:21px; font-size:35px; line-height:1.2; color:#000; word-break:keep-all; word-wrap:break-word; letter-spacing:-3px;}
.viewPage-passassay .viewAtc .infoBx .tit{font-size:0; line-height:1.33;}
.viewPage .viewAtc .infoBx .infoTx{font-size:12px; line-height:22px; margin-top:12px; color:#888; letter-spacing:0; padding-left:2px; overflow:hidden; position:relative;}
.viewPage .viewAtc .infoBx .infoTx > span{position:relative; vertical-align:top; font-size:13px; color:#999; padding-left:11px; margin-left:8px; }
.viewPage .viewAtc .infoBx .infoTx > span:after{content:""; display:block; width:1px; height:12px; background-color:#dadada; position:absolute; left:0; top:4px;}
.viewPage .viewAtc .infoBx .infoTx > span:first-child:after{display:none;}
.viewPage .viewAtc .infoBx .infoTx > span:first-child{margin-left:0; padding-left:0;}
.viewPage .viewAtc .infoBx .infoTx > span:first-child:before{display:none;}
.viewPage .viewAtc .infoBx .infoTx .txViewNum .stSpImg{display:inline-block; width:20px; height:14px; background-position:-480px -20px; overflow:hidden; text-indent:-9999px; vertical-align:-3px; margin-right:2px;}
.viewPage .viewAtc .infoBx .infoTx .cate{color:#39f;}
.viewPage .viewAtc .infoBx .infoTx .cate + span:before{display:none;}
</style>
</head>
<body>
<div class="btn-group btn-group-justified">
    <a href="../selfletter/letter.do" class="btn btn-primary">합격자소서</a>
    <a href="../company/company.do" class="btn btn-primary">기업·면접후기</a>
    <a href="../newsTipVideo/news.do" class="btn btn-primary">취업뉴스</a>
    <a href="../newsTipVideo/tip.do" class="btn btn-light">취업꿀팁</a>
    <a href="../newsTipVideo/video.do" class="btn btn-primary">취업영상</a>
</div>
<div style="height:30px"></div>
<div class="detailcontainer">
<article class="viewPage">
  <article class="viewAtc">
    <div class="infoBx">
	    <h3 class="tit">${vo.t_title }</h3>
	     <p class="infoTx">
	      <span class="cate">${vo.t_writer }</span>
	      <span class="date">${vo.t_regdate }</span>
	      <span class="txViewNum"><i class="glyphicon glyphicon-user" style="color:#336699"></i>&nbsp;${vo.t_hit }
	      <div style="height:5px"></div>
	      </span>
	     </p>
	      <div class="funcBtn" style="float: right;">
	      <c:if test="${count==0 }">
	       <button type="button" class="btnPrint" title="스크랩" onclick="location.href='tipScrapInsert.do?no=${vo.t_no }'"><span><i class="glyphicon glyphicon-thumbs-up"></i> 스크랩</span></button>
	       </c:if>
	       <button type="button" id="link" title="공유하기"><span><i class="glyphicon glyphicon-cloud"></i> 퍼가기</span></button>
	      </div>
    </div>
    
    <div id="dialog" title="링크 주소" style="display:none; background-color:white; border:1px solid #e6e6e6; text-align:center;">
     <p>http://localhost:8080/Team4thProject/<br>newsTipVideo/tipdetail.do?no=${vo.t_no }</p>
    </div>

<div class="viewWrap" id="view_text" style="font-size: 17px;" data-scrollcheck="True">
<p><img style="display: block; margin: 0 auto;" src="${vo.t_poster2 }">&nbsp;</p>
<p style="text-align:justify;">
    ${vo.t_content }
</p>
 <button type="button" title="목록" style="float: right;" onclick="location.href='../newsTipVideo/tip.do'"><span>돌아가기</span></button>
</div>
</article>
<div style="height:50px"></div>
   

<div class="col-lg-12">
    <h3>댓글목록</h3>
    <hr>
    <c:forEach var="rvo" items="${rList }">
      <table class="table">
        <tr>
          <td class="text-left">
           <c:if test="${rvo.group_tab>0 }">
             <c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp;&nbsp;&nbsp;
             </c:forEach>
             <img src=https://www.shareicon.net/data/512x512/2015/08/12/84291_reply_512x512.png width=30 height=30>
           </c:if>
           &nbsp;${rvo.id }(${rvo.dbday })
          </td>
          <td class="text-right">
            <c:if test="${sessionScope.id==rvo.id }">
            <button type="button" style="background-color:#99ffc9; border:1px solid #bfbfbf; border-radius:5px; padding:5px 5px" class="tip_reply_update" title="수정" value="${rvo.no }"><span>수정</span></button>
            <button type="button" style="background-color:#ffd6cc; border:1px solid #bfbfbf; border-radius:5px; padding:5px 5px" onclick="location.href='../newsTipVideo/tip_reply_delete.do?no=${rvo.no }&bno=${vo.t_no}'" title="삭제"><span>삭제</span></button>
            </c:if>
            <button type="button" style="background-color:#ccd8ff; border:1px solid #bfbfbf; border-radius:5px; padding:5px 5px" class="tip_reply_reply" title="대댓글" value="${rvo.no }"><span>대댓글</span></button>
          </td>
        </tr>
        <tr>
          <td class="text-left" colspan="2">
            <c:if test="${rvo.group_tab>0 }">
             <c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp; &nbsp;&nbsp;
             </c:forEach>
           </c:if>
            <pre style="white-space: pre-wrap;background-color: white;border:none">${rvo.msg }</pre>
          </td>
        </tr>
       <tr class="rIn" id="rIn${rvo.no }" value="${rvo.no }" style="display:none">
       <td colspan="2">
        <form method=post action="../newsTipVideo/tip_reply_reply_insert.do">
            <input type=hidden name="no" value="${rvo.no }">
            <input type=hidden name="bno" value="${vo.t_no }">
	        <textarea rows="3" cols="80" name="msg" style="float: left; width:970px; height:100px;"></textarea>
	        <button type="submit" value="대댓글달기" style="background-color:#ccd8ff; border:1px solid #bfbfbf; border-radius:5px; padding:38px 30px;"><span>댓글달기</span></button>
        </form>
       </td>
      </tr>
      <tr class="rUp" id="rUp${rvo.no }" value="${rvo.no }" style="display:none">
       <td colspan="2">
        <form method=post action="../newsTipVideo/tip_reply_update.do">
            <input type=hidden name="no" value="${rvo.no }">
            <input type=hidden name="bno" value="${vo.t_no }">
	        <textarea rows="3" cols="80" name="msg" style="float: left; width:970px; height:100px;">${rvo.msg }</textarea>
	        <button type="submit" value="댓글수정" style="background-color:#99ffc9; border:1px solid #bfbfbf; border-radius:5px; padding:38px 30px;"><span>수정하기</span></button>
        </form>
       </td>
      </tr>
      </table>
    </c:forEach>
    <hr>
    <table class="table">
      <tr>
       <td>
        <form method=post action="../newsTipVideo/tip_reply_insert.do">
            <input type=hidden name="bno" value="${vo.t_no }">
	        <textarea rows="3" cols="80" name="msg" style="float: left; width:970px; height:100px;"></textarea>
	        <button type="submit" value="댓글쓰기" style="background-color:#f2f2f2; border:1px solid black; border-radius:5px; padding:38px 30px;;"><span>댓글쓰기</span></button>
        </form>
       </td>
      </tr>
    </table>
  </div>
    
</article>
</div>
</body>
</html>