package model;

import java.util.*;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.*;
import dao.*;

import com.sist.controller.RequestMapping;

// 잡지식인 Model ===================================================================================================

public class JobKnowledgeModel {

	
	// 잡지식인 메인페이지 출력 (전체태그 게시물 출력) ============================================================================================
	@RequestMapping("jobKnowledge/box.do")
	public String jobKnowledge_box(HttpServletRequest request) {
		
		
		return "../jobKnowledge/box.jsp";
	}
	
	
	
	
	
	// 전체태그 게시물 출력 ============================================================================================
	@RequestMapping("jobKnowledge/list.do")
	public String jobKnowledge_list(HttpServletRequest request) {
		
		
		try {
			
			// 변수 -------------------------------------------------------------
			String page = request.getParameter("page");					// 사용자로부터 받는 페이지
			if(page == null) {		
				page = "1";
			}
			int currpage = Integer.parseInt(page);						// 현재 페이지
			int totalpage = JobKnowledgeDAO.jobknowledgeTatalPage();	// 총 페이지
			int rowSize = 10;											// 한번에 출력될 게시글
			int start = (rowSize*currpage) - (rowSize - 1);				
			int end = (rowSize*currpage);
			int block = 5;												// 페이지 블록
			int startpage=((currpage-1)/block*block)+1;					
			int endpage=((currpage-1)/block*block)+block;
			if(endpage>totalpage) {
				endpage=totalpage;
			}
			
			// 해쉬맵에 시작 / 끝 변수 담기 ------------------------------------------------------
			Map map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			
			
			List<JobKnowledgeVO> list = JobKnowledgeDAO.jobknowledgeListData(map);			// DAO의 메소드 리턴값을 받는 List 변수
			
			// 쿠키 ---------------------------------------------------------------------------------------------------
			HttpSession session=request.getSession();
			String id=(String)session.getAttribute("id");
			// 쿠키 읽기
			Cookie[] cookies=request.getCookies();							// 쿠키 배열 생성
			List<JobKnowledgeVO> cList=new ArrayList<JobKnowledgeVO>();					// 쿠키를 담을 리스트 생성
			if(cookies!=null)												// 쿠키가 비어있지 않으면
			{
				for(int i=cookies.length-1;i>=0;i--)						// (쿠키길이 - 1)부터 0까지 i를 1씩 감소 (그래야 최신 쿠키가 맨앞에 옴)
				{
					if(cookies[i].getName().startsWith(id))							// 쿠키배열의 이름이 id를 시작하면
					{
						String no=cookies[i].getValue();								// 변수 no에 쿠키값 넣기
						JobKnowledgeVO vo=JobKnowledgeDAO.jobknowledgeDetail(Integer.parseInt(no));		// vo에 상세보기를 담아서
						cList.add(vo);													// 쿠키배열에 vo 담기
					}
				}
			}
			request.setAttribute("cList", cList);										// 쿠키값이 담긴 리스트를 전송
			
			// 페이지로 보낼 파라미터들 -----------------------------------------------------------
			request.setAttribute("list", list);
			request.setAttribute("currpage", currpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("block", block);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/list.jsp");
			System.out.println("잡지식인 메인페이지");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "../jobKnowledge/box.jsp";
	}
// 태그별 게시물 출력 ============================================================================================
	@RequestMapping("jobKnowledge/listByTag.do")
	public String jobKnowledge_listByTag(HttpServletRequest request) {
		
		
		try {
			System.out.println("태그별 게시물출력 모델");
			
			// 변수 -------------------------------------------------------------
			String page = request.getParameter("page");					// 사용자로부터 받는 페이지
			String tag = request.getParameter("tag");					// 사용자로부터 받는 태그
			if(page == null) {		
				page = "1";
			}
			if(tag == null) {
				tag = "취업지원";
			}
			
			int currpage = Integer.parseInt(page);								// 현재 페이지
			int totalpage = JobKnowledgeDAO.jobknowledgeTatalPageByTag(tag);	// 총 페이지
			int rowSize = 10;													// 한번에 출력될 게시글
			int start = (rowSize*currpage) - (rowSize - 1);				
			int end = (rowSize*currpage);
			int block = 5;														// 페이지 블록
			int startpage=((currpage-1)/block*block)+1;					
			int endpage=((currpage-1)/block*block)+block;
			if(endpage>totalpage) {
				endpage=totalpage;
			}
			
			// 해쉬맵에 시작 / 끝 변수 담기 ------------------------------------------------------
			Map map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			map.put("tag", tag);
			
			List<JobKnowledgeVO> list = JobKnowledgeDAO.jobknowledgeListDataByTag(map);			// DAO의 메소드 리턴값을 받는 List 변수
			
			// 쿠키 ---------------------------------------------------------------------------------------
			HttpSession session=request.getSession();
			String id=(String)session.getAttribute("id");
			// 쿠키 읽기
			Cookie[] cookies=request.getCookies();							// 쿠키 배열 생성
			List<JobKnowledgeVO> cList=new ArrayList<JobKnowledgeVO>();					// 쿠키를 담을 리스트 생성
			if(cookies!=null)												// 쿠키가 비어있지 않으면
			{
				for(int i=cookies.length-1;i>=0;i--)						// (쿠키길이 - 1)부터 0까지 i를 1씩 감소 (그래야 최신 쿠키가 맨앞에 옴)
				{
					if(cookies[i].getName().startsWith(id))							// 쿠키배열의 이름이 id를 시작하면
					{
						String no=cookies[i].getValue();								// 변수 no에 쿠키값 넣기
						JobKnowledgeVO vo=JobKnowledgeDAO.jobknowledgeDetail(Integer.parseInt(no));		// vo에 상세보기를 담아서
						cList.add(vo);													// 쿠키배열에 vo 담기
					}
				}
			}
			request.setAttribute("cList", cList);										// 쿠키값이 담긴 리스트를 전송
			
			
			// 페이지로 보낼 파라미터들 -----------------------------------------------------------
			request.setAttribute("list", list);
			request.setAttribute("currpage", currpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("block", block);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("tag", tag); 													// 태그 파라미터 보내기
			request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/listByTag.jsp");
			System.out.println("잡지식인 메인페이지");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "../jobKnowledge/box.jsp";
	}
	

	// 상세보기 전에 쿠키 생성하기
	@RequestMapping("jobKnowledge/detail_before.do")
	public String jobKnowledge_detail_before(HttpServletRequest request, HttpServletResponse response) {
			String no = "";
		try {
			
			
			System.out.println("쿠키생성 모델");
			
			// 글번호 no와 세션의 id 가져오기-----------------------------
			
			no = request.getParameter("no");
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
			
			// 쿠키 생성 ----------------------------------------------
			Cookie cookie = new Cookie(id + no, no);				// 쿠키의 키는 (세션아이디 + 글번호)  값은 글번호
			cookie.setMaxAge(60);
			cookie.setPath("/");
			response.addCookie(cookie);
			System.out.println("쿠키이름 : " + cookie.getName() + "값 : " + cookie.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "redirect:../jobKnowledge/detail.do?no=" + no;		// 글번호에 해당하는 detail.do로 리다이렉트
	}
	
	
	// 게시글 상세보기 ========================================================================================================
	@RequestMapping("jobKnowledge/detail.do")
	public String jobKnowledge_detail(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
			System.out.println("게시글 상세페이지");
			
			String no = request.getParameter("no");					// 사용자로부터 받는 글번호 no
			
			JobKnowledgeVO vo = JobKnowledgeDAO.jobknowledgeDetail(Integer.parseInt(no));				// DAO의 상세보기 메소드 리턴값을 vo에 담기 
			
			List<JobKnowledgeVO> list = JobKnowledgeDAO.jobknowledgeDetailReply(Integer.parseInt(no));	// list에 답변글들을 담기
			
			
			
			
			// 스크랩 버튼 활성화 여부 -------------------------------------
			HttpSession session=request.getSession();
			String id=(String)session.getAttribute("id");
			JobKnowledgeScrapVO svo=new JobKnowledgeScrapVO();
			svo.setId(id);
			svo.setMno(Integer.parseInt(no));
			int count=JobKnowledgeDAO.scrapCount(svo);
			
			request.setAttribute("count", count);
			
			// 채택된 답변글 수 가져오기 (채택버튼 활성화 / 비활성화 관련) ---------------------------------------------------------
			int adoptCount = JobKnowledgeDAO.getAdoptCount(Integer.parseInt(no));
			request.setAttribute("adoptCount", adoptCount);
			
			
			
			request.setAttribute("vo", vo);
			request.setAttribute("list", list);
			request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/detail.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "../jobKnowledge/box.jsp";
	}
	
	// 상세보기시에 답변글의 댓글들 가져오기 ===========================================================================================
	@RequestMapping("jobKnowledge/bringComment.do")
	public String jobKnowledge_bringComment(HttpServletRequest request) {
			
			String board_no = "";
			
		try {
			board_no = request.getParameter("board_no");
			String reply_no = request.getParameter("reply_no");
			
			Map map = new HashMap();
			map.put("board_no", board_no);
			map.put("reply_no", reply_no);
			
			List<JobKnowledge_CommentVO> comment_list = JobKnowledgeDAO.commentListData(map);
			
			request.setAttribute("comment_list", comment_list);
//			request.setAttribute("comment_list_jsp", "../jobKnowledge/bringComment.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "../jobKnowledge/bringComment.jsp";
//		return "redirect:../jobKnowledge/detail.do?no=" + board_no;
	}
	
	
	
	
	
	
	// 질문하기 페이지 출력하는 메소드 ============================================================================================
	@RequestMapping("jobKnowledge/answer.do")
	public String jobKnowledge_answer(HttpServletRequest request) {
		
		try {
			System.out.println("질문하기");
			
			request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/answer.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "../jobKnowledge/box.jsp";
	}
	// 질문하기 메소드 ========================================================================================================
	/*
	 * no, id, subject, content, regdate, hit, group_id, group_step, root, depth, comment_id, tag, adopt 
	 */
	@RequestMapping("jobKnowledge/answer_ok.do")
	public String jobknowledge_InsertAnswer(HttpServletRequest request) {
		
		try {
			System.out.println("질문하기 모델");			
			request.setCharacterEncoding("utf-8");
			
			// 세션 -------------------------------------------------------
			HttpSession session = request.getSession();									// 세션 가져오기
			
			
			// answer.jsp 페이지로부터 받는 파라미터들 ----------------------------
//			String id = request.getParameter("id");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String tag = request.getParameter("tag");
			String point = request.getParameter("point");
			
			// VO에 파라미터를 담아서 DAO의 질문하기 메소드 실행 -------------------------
			JobKnowledgeVO vo = new JobKnowledgeVO();
			vo.setId((String)session.getAttribute("id"));								// 아이디를 세션id로 지정 ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
			
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setTag(tag);
			vo.setPoint(Integer.parseInt(point));
			JobKnowledgeDAO.jobknowledgeInsertAnswer(vo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "../jobKnowledge/answer_ok.jsp";
	}
	
	
	
	
	
	
	
	// 답변달기 메소드 ====================================================================================================
	@RequestMapping("jobKnowledge/reply.do")
	public String jobknowledge_Reply(HttpServletRequest request) {
			
		
		
		// 세션 --------------------------------------------------------------
		HttpSession session = request.getSession();
		
		// 게시글 페이지로부터 받는 파라미터들 ----------------------------------------------
		String no = "";
		String content = "";							// 아이디를 세션id로 지정 ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★	
		String sessionID = "";
		String board_no = "";
		
		try {
			System.out.println("답변달기 모델");
			request.setCharacterEncoding("utf-8");
			board_no = request.getParameter("board_no");
			// 게시글 페이지로부터 받는 파라미터들 ----------------------------------------------
			no = request.getParameter("no");
			content = request.getParameter("content");							// 아이디를 세션id로 지정 ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★	
			sessionID = (String)session.getAttribute("id");
			
			
			
			// Map에 파라미터 담아서 DAO 메소드 실행 --------------------------------------------
			Map map = new HashMap();
			map.put("id", sessionID);
			map.put("content", content);
			map.put("no", no);
			
			JobKnowledgeDAO.jobknowledgeUpdateReply(Integer.parseInt(no));
			JobKnowledgeDAO.jobknowledgeReply(map);
			JobKnowledgeDAO.incrementNoti(Integer.parseInt(board_no));				// 답변달리면 질문글의 noti 증가
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:../jobKnowledge/detail.do?no=" + no;
//		return "../jobKnowledge/reply_ok.jsp";
	}
	
	
	
	
	
	
	// 게시글 수정 전 내용 가져오기 =================================================================================================================
	@RequestMapping("jobKnowledge/modify_board.do")
	public String jobknowledgeModifyBoard(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			
			// 사용자로부터 받는  파라미터 -----------------------------------------------
			String no = request.getParameter("no");
			
			// DAO 메소드 결과를 vo에 담아서 전송
			JobKnowledgeVO vo = JobKnowledgeDAO.jobknowledgeModifyBoard(Integer.parseInt(no));
			request.setAttribute("vo", vo);
			request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/modify_board.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../jobKnowledge/box.jsp";			// ????????????????????????????????????????????????????????????????????????????
	}
	// 게시글 수정하기 ===========================================================================================================================
	@RequestMapping("jobKnowledge/modify_board_ok.do")
	public String jobknowledgeModifyBoard_ok(HttpServletRequest request) {
		
		try {
			System.out.println("게시글 수정하기 모델");
			request.setCharacterEncoding("utf-8");
			
			// 사용자로부터 받는 파라미터 ----------------------------------------------------
			String no = request.getParameter("no");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			
			// Map에 파라미터 넣기 ---------------------------------------------------------
			Map map = new HashMap();
			map.put("no", Integer.parseInt(no));
			map.put("subject", subject);
			map.put("content", content);
			
			// DAO 메소드 실행 -----------------------------------------------------------
			JobKnowledgeDAO.jobknowledgeModifyBoard_ok(map);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "../jobKnowledge/modify_board_ok.jsp";
	}
	
	
	
	
	// 답변 수정 전 내용 가져오기 ==============================================================================================================
	@RequestMapping("jobKnowledge/modifyReply.do")
	public String getReply(HttpServletRequest request) {
		try {
			System.out.println("답변 수정 전 내용 가져오기");
			String board_no = request.getParameter("board_no");
			String reply_no = request.getParameter("reply_no");
			
			JobKnowledgeVO vo = JobKnowledgeDAO.jobknowledgeModifyBoard(Integer.parseInt(board_no));		// 질문글 
			JobKnowledgeVO rVO = JobKnowledgeDAO.getReply(Integer.parseInt(reply_no));						// 답변글
			
			request.setAttribute("vo", vo);
			request.setAttribute("rVO", rVO);
			request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/modifyReply.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "../jobKnowledge/box.jsp";
	}
	// 답변 수정하기 =========================================================================================================================
	@RequestMapping("jobKnowledge/modifyReply_ok.do")
	public String modifyReply_ok(HttpServletRequest request) {
		String board_no = "";
		try {
			System.out.println("답변 수정하기");
			request.setCharacterEncoding("utf-8");
			board_no = request.getParameter("board_no");
			String reply_no = request.getParameter("reply_no");
			String reply_content = request.getParameter("reply_content");
			
			Map map = new HashMap();
			map.put("reply_no", reply_no);
			map.put("reply_content", reply_content);
			
			JobKnowledgeDAO.ModifyReply(map);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:../jobKnowledge/detail.do?no=" + board_no;
	}
	
	
	
	
	
	
	// 게시글과 답변과 댓글 삭제하기 =======================================================================================================
	@RequestMapping("jobKnowledge/deleteAll.do")
	public String jobKnowledgeDeleteAll(HttpServletRequest request) {
		
		try {
			System.out.println("게시글과 답변 삭제하기");
			
			// 사용자로부터 받는 파라미터 --------------------------------------
			String no = request.getParameter("no");
			System.out.println(no);
			
			// DAO 메소드 실행
			JobKnowledgeDAO.jobknowledgeDeleteAll(Integer.parseInt(no));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "../jobKnowledge/deleteAll.jsp";
	}
	// 삭제 확인창 띄우기 ===========================================================================================================
	@RequestMapping("jobKnowledge/deleteReally.do")
	public String jobKnowledgeDeleteReally(HttpServletRequest request) {
		return "../jobKnowledge/deleteReally.jsp";
	}
	
	
	

	// 답변과 댓글만 삭제하기 =======================================================================================================
	@RequestMapping("jobKnowledge/delete_reply.do")
	public String jobKnowledgeDeleteReplyAlone(HttpServletRequest request) {
		
			String bno = "";
			
		
		try {
			System.out.println("답변과 댓글만 삭제하기");
			
			// 사용자로부터 받는 파라미터 --------------------------------------
			String rno = request.getParameter("rno");		// 답변의 번호
			bno = request.getParameter("bno");		// 질문글 번호
//			String content = request.getParameter("content");
			HttpSession session = request.getSession();			
			String id = (String)session.getAttribute("id");		// id는 세션아이디
			String pwd = request.getParameter("pwd");
			
			System.out.println("답변 : " + rno);
			System.out.println("질문 : " + bno);
												
			JobKnowledgeDAO.deleteReplyAlone(Integer.parseInt(rno), Integer.parseInt(bno));
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:../jobKnowledge/detail.do?no=" + bno;
			
//		return "../jobKnowledge/delete_reply.jsp";
	}
	// 답변만 삭제 확인창 띄우기 ===========================================================================================================
	@RequestMapping("jobKnowledge/deleteReally_reply.do")
	public String jobKnowledgeDeleteReally_reply(HttpServletRequest request) {
		return "../jobKnowledge/deleteReally_reply.jsp";
	}
	
	
	// 댓글만 삭제하기 =================================================================================================================
	@RequestMapping("jobKnowledge/deleteCommentAlone.do")
	public String jobKnowledge_delete_comment_alone(HttpServletRequest request) {
		
//			String board_no = "";
		try {
//			board_no = request.getParameter("board_no");
			String no = request.getParameter("no");
			
			JobKnowledgeDAO.deleteCommentAlone(Integer.parseInt(no));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "../jobKnowledge/list.jsp";
	}
	
	
	
	
	// 댓글달기 ==========================================================================================================================
//	@RequestMapping("jobKnowledge/comment.do")
//	public String jobknowledge_InsertComment(HttpServletRequest request) {
//		
//		HttpSession session = request.getSession();
//		String id = (String)session.getAttribute("id");						// id는 세션에서 받으면됨
//		String content = request.getParameter("content");
//		String rno = request.getParameter("rno");			// 답변글번호
//		String bno = request.getParameter("bno");			// 질문글번호
//		
//		Map map = new HashMap();
//		map.put("id", id);
//		map.put("content", content);
//		map.put("rno", rno);
//		
//		request.setAttribute("bno", bno);					// 질문글번호는 comment.jsp로 넘기고 바로 detail.do?no=${bno} 리다이렉트
//		
//		JobKnowledgeDAO.jobknowledgeInsertComment(map);
//		
//		return "../jobKnowledge/comment.jsp";
//	}
	// 댓글창 보이기 =========================================================================================================================
	@RequestMapping("jobKnowledge/commentInsertTab.do")
	public String jobknowledge_commentButton(HttpServletRequest request) {
		
		return "../jobKnowledge/commentInsertTab.jsp";
	}
	
	
	
	
	
	
	// 검색한 게시물 출력 ============================================================================================
	@RequestMapping("jobKnowledge/search.do")
	public String jobKnowledge_search(HttpServletRequest request) {
		
		
		try {
			
			// 변수 -------------------------------------------------------------
			String page = request.getParameter("page");					// 사용자로부터 받는 페이지
			if(page == null) {		
				page = "1";
			}
			String finding = request.getParameter("finding");
			String voca = request.getParameter("voca");
			
			
			int currpage = Integer.parseInt(page);						// 현재 페이지
			
			int rowSize = 10;											// 한번에 출력될 게시글
			int start = (rowSize*currpage) - (rowSize - 1);				
			int end = (rowSize*currpage);
			int block = 5;												// 페이지 블록
			int startpage=((currpage-1)/block*block)+1;					
			int endpage=((currpage-1)/block*block)+block;
			
			System.out.println("태그 : " + finding);
			System.out.println("검색어 : " + voca);
			
			
			// 해쉬맵에 시작 / 끝 변수 담기 ------------------------------------------------------
			Map map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			map.put("finding", finding);
			map.put("voca", voca);
			
			int totalpage = JobKnowledgeDAO.searchTotalPage(map);	// 총 페이지
			if(endpage>totalpage) {
				endpage=totalpage;
			}
			List<JobKnowledgeVO> list = JobKnowledgeDAO.searchBoard(map);			// DAO의 메소드 리턴값을 받는 List 변수
			
			// 페이지로 보낼 파라미터들 -----------------------------------------------------------
			request.setAttribute("list", list);
			request.setAttribute("currpage", currpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("block", block);
			request.setAttribute("startpage", startpage);
			request.setAttribute("endpage", endpage);
			request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/search.jsp");
			System.out.println("검색");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "../jobKnowledge/box.jsp";
	}

	
	
	
	
	
	
	// 스크랩하기 ==============================================================================================================
	@RequestMapping("jobKnowledge/scrap.do")
	public String jobKnowledge_scrap(HttpServletRequest request)
	{
		System.out.println("스크랩하기");
		String no=request.getParameter("no");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		JobKnowledgeScrapVO vo=new JobKnowledgeScrapVO();
		vo.setId(id);
		vo.setMno(Integer.parseInt(no));
		JobKnowledgeDAO.scrapInsert(vo);
		return "redirect:../jobKnowledge/detail.do?no="+no;
	}
	
	// 스크랩 취소 ==============================================================================================================
	@RequestMapping("jobKnowledge/scrap_cancel.do")
	public String jobKnowledge_scrap_cancel(HttpServletRequest request)
	{
		String no=request.getParameter("no");
		JobKnowledgeDAO.scrapDelete(Integer.parseInt(no));
		return "redirect:../jobKnowledge/scrapList2.do";
	}
	
	// 스크랩목록 가져오기 ==========================================================================================================
	@RequestMapping("jobKnowledge/scrapList2.do")
	public String jobKnowledge_scrapList(HttpServletRequest request)
	{
		HttpSession session=request.getSession();					// 세션 생성
		String id=(String)session.getAttribute("id");				// id를 세션id로 
		
		  
		List<JobKnowledgeScrapVO> scrap_List=JobKnowledgeDAO.scrapListData(id);				// 찜 리스트 가져오기
		List<JobKnowledgeVO> boardList=new ArrayList<JobKnowledgeVO>();						// boardList(게시글VO 리스트 객체) 생성
		for(JobKnowledgeScrapVO scrap_vo : scrap_List) {											// 스크랩리스트 전부 for문 돌리기
		JobKnowledgeVO board_vo=JobKnowledgeDAO.jobknowledgeDetail(scrap_vo.getMno());				// board_vo(게시글 VO 객체)에 detail 메소드 넣기 (파라미터는 스크랩VO의 mno컬럼(글번호))
//		String story=mvo.getStory();								
		board_vo.setScrap_no(scrap_vo.getNo());														// board_vo(게시글VO)의 scrap_no(찜번호 컬럼)에 scrap_vo의 번호(no) 넣기
//		if(story.length()>150) {
//		  
//		story=story.substring(0,150)+"...";
//		mvo.setStory(story);
//		}
		boardList.add(board_vo);											// 게시글VO리스트에 게시글VO객체 넣기
		}
		request.setAttribute("boardList", boardList);							// 게시글VO리스트를 전송
		  
		
		request.setAttribute("mypage_jsp", "../jobKnowledge/scrapList2.jsp");
	    return "../mypage/mymain.jsp";
//		  request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/scrapList2.jsp");
		
//		return "../jobKnowledge/box.jsp";
	}
	
	
	
	
	// 답변에 댓글달기 ==============================================================================================================================
	   @RequestMapping("jobKnowledge/comment_insert.do")
	   public String reply_insert(HttpServletRequest request)
	   {
		   
		   String board_no = "";
		   
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
			   board_no = request.getParameter("board_no");
			   String reply_no=request.getParameter("reply_no");			// 답변글번호
			   String content=request.getParameter("content");				// 내용
			   HttpSession session=request.getSession();
			   String id=(String)session.getAttribute("id");				// 세션아이디
//			   String name=(String)session.getAttribute("name");
			   // VO에 담아서 => DAO
			   JobKnowledge_CommentVO vo=new JobKnowledge_CommentVO();		// 댓글VO객체 생성
			   vo.setReply_no(Integer.parseInt(reply_no));					// 답변글번호 setter
			   vo.setId(id);												// 아이디 setter
			   vo.setContent(content);										// 내용 setter
			   vo.setBoard_no(Integer.parseInt(board_no));
//			   vo.setName(name);
			   // DAO연결 
			   JobKnowledgeDAO.commentInsert(vo, Integer.parseInt(reply_no));
			   
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   
		   return "redirect:../jobKnowledge/detail.do?no="+board_no;	// 수정 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆
	   }
	   
	   
	   // 대댓글 달기 =======================================================================================================================
	   @RequestMapping("jobKnowledge/comment_comment_insert.do")
	   public String comment_comment_insert(HttpServletRequest request)
	   {
		   String board_no = "";
		   
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
			   
			   board_no = request.getParameter("board_no");					// 질문글번호			ㅁㅁㅁ
			   String no=request.getParameter("no");						// 부모 댓글번호			ㅁㅁㅁ	
			   System.out.println("no="+no);
			   String reply_no=request.getParameter("reply_no");			// 답변글 번호			ㅁㅁㅁ
			   System.out.println("reply_no="+reply_no);
			   String content=request.getParameter("content");				// 내용				ㅁㅁㅁ
			   JobKnowledge_CommentVO vo=new JobKnowledge_CommentVO();		// 댓글VO 객체 생성
			   //vo.setRoot(Integer.parseInt(no));
			   vo.setReply_no(Integer.parseInt(reply_no));					// 답변글번호 setter
			   vo.setContent(content);										// 내용 setter
			   vo.setBoard_no(Integer.parseInt(board_no));					// 질문글번호 setter
			   HttpSession session=request.getSession();
			   String id=(String)session.getAttribute("id");				// 세션아이디
//			   String name=(String)session.getAttribute("name");
			   vo.setId(id);												// 세션아이디 setter
//			   vo.setName(name);
			   // DB연동 
			   JobKnowledgeDAO.commentCommentInsert(Integer.parseInt(no), vo);		// 대댓글 메소드 수행
			   
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		   
		   
		   return "redirect:../jobKnowledge/detail.do?no="+board_no;
	   }
	  
	
	
	   
	   
	   
	   // 사이드바에 최근 방문한 게시글 출력 =====================================================================================================
	   @RequestMapping("jobKnowledge/recentBoard.do")
	   public String jobKnowledge_sideBar(HttpServletRequest request) {
		   
		// 쿠키 ---------------------------------------------------------------------------------------------------
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		// 쿠키 읽기
		Cookie[] cookies=request.getCookies();										// 쿠키 배열 생성
		List<JobKnowledgeVO> cList=new ArrayList<JobKnowledgeVO>();					// 쿠키를 담을 리스트 생성
		if(cookies!=null)															// 쿠키가 비어있지 않으면
		{
			for(int i=cookies.length-1;i>=0;i--)									// (쿠키길이 - 1)부터 0까지 i를 1씩 감소 (그래야 최신 쿠키가 맨앞에 옴)
			{
				if(cookies[i].getName().startsWith(id))								// 쿠키배열의 이름이 id를 시작하면
				{
					String no=cookies[i].getValue();								// 변수 no에 쿠키값 넣기
					JobKnowledgeVO vo=JobKnowledgeDAO.jobknowledgeDetail(Integer.parseInt(no));		// vo에 상세보기를 담아서
					cList.add(vo);													// 쿠키배열에 vo 담기
				}
			}
		}
		request.setAttribute("cList", cList);										// 쿠키값이 담긴 리스트를 전송
		
		   return "../jobKnowledge/recentBoard.jsp";
	   }
	   // 사이드바에 유저 포인트 표시 =====================================================================================================
	   @RequestMapping("jobKnowledge/user_point.do")
	   public String jobKnowledge_user_point(HttpServletRequest request) {
		   
		   HttpSession session = request.getSession();
		   String id = (String)session.getAttribute("id");
		   int user_point = JobKnowledgeDAO.indicatePoint(id);
		   
		   request.setAttribute("user_point", user_point);
		   
		   return "../jobKnowledge/user_point.jsp";
	   }
	   // 사이드바에 답변달린 질문 표시 ==================================================================================================
	   @RequestMapping("jobKnowledge/noti.do")
	   public String jobKnowledge_noti(HttpServletRequest request) {
		   
		   try {
			   HttpSession session = request.getSession();
			   String id = (String)session.getAttribute("id");
			   List<JobKnowledgeVO> noti_list = JobKnowledgeDAO.indicateNotiBoard(id);
			   
			   request.setAttribute("noti_list", noti_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
		   
		   return "../jobKnowledge/noti.jsp";
	   }
	   
	   
	   
	   
	   
	   // 답변글 채택하기 ============================================================================================================
	   @RequestMapping("jobKnowledge/adopt.do")
	   public String jobKnowledge_adopt(HttpServletRequest request) {
		   
		   System.out.println("채택하기");
		   String board_no = "";
		try {
			
			HttpSession session = request.getSession();
			board_no = request.getParameter("board_no");		// 질문글 번호
			String board_id = (String)session.getAttribute("id");	// 질문자 아이디
			String reply_id = request.getParameter("reply_id");		// 답변자 아이디
			String reply_no = request.getParameter("reply_no");		// 답변글 번호
			
			
			
			Map map = new HashMap();
			map.put("board_no", board_no);
			map.put("board_id", board_id);
			map.put("reply_id", reply_id);
			
			JobKnowledgeDAO.adopt(map, Integer.parseInt(reply_no));
			
			System.out.println("board_no : " + board_no);
			System.out.println("reply_no : " + reply_id);
			System.out.println(board_id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		   
		   return "redirect:../jobKnowledge/list.do";
	   }
	   
	   
	   
	   
	   // 사이드바 알람 클릭시 질문의 noti 감소 ============================================================================================================
	   @RequestMapping("jobKnowledge/declineNoti.do")
	   public String declineNoti(HttpServletRequest request) {
		   String no = "";
		   try {
			no = request.getParameter("no");
			JobKnowledgeDAO.declineNoti(Integer.parseInt(no));
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		   
		   return "redirect:../jobKnowledge/detail.do?no=" + no;
		   }
	   
	
	
	
	
	   // 잡지식인 프로필 페이지 출력하는 메소드 ==========================================================================================
		@RequestMapping("jobKnowledge/profile.do")
		public String jobKnowledge_profile(HttpServletRequest request) {
			
			try {
				System.out.println("프로필");
				
				request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/profile.jsp");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			return "../jobKnowledge/box.jsp";
		}
	
	
	
	
	// 테스트 ============================================================================================
		@RequestMapping("jobKnowledge/test.do")
		public String test(HttpServletRequest request) {
			
			
			
			try {
				HttpSession session = request.getSession();
				String id=(String)session.getAttribute("id");
//				if(session.getAttribute("id") != null) {
					
					// 쿠키
					
					// 쿠키 읽기
					Cookie[] cookies=request.getCookies();							// 쿠키 배열 생성
					List<JobKnowledgeVO> cList=new ArrayList<JobKnowledgeVO>();					// 쿠키를 담을 리스트 생성
					
						for(int i=cookies.length-1;i>=0;i--)						// (쿠키길이 - 1)부터 0까지 i를 1씩 감소 (그래야 최신 쿠키가 맨앞에 옴)
						{
							if(cookies[i].getName().startsWith(id))							// 쿠키배열의 이름이 id를 시작하면
							{
								String no=cookies[i].getValue();								// 변수 no에 쿠키값 넣기
								JobKnowledgeVO vo=JobKnowledgeDAO.jobknowledgeDetail(Integer.parseInt(no));		// vo에 상세보기를 담아서
								cList.add(vo);													// 쿠키배열에 vo 담기
								System.out.println("출력 이름 : " + cookies[i].getName() + "출력 값 : " + cookies[i].getValue());
							}
						}
					
					request.setAttribute("cList", cList);										// 쿠키값이 담긴 리스트를 전송
					
					System.out.println("테스트");
					
					request.setAttribute("id", id);
					
					request.setAttribute("jobKnowledge_jsp", "../jobKnowledge/test.jsp");
				
//				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "../jobKnowledge/box.jsp";
		}
		
		
	
	
}
