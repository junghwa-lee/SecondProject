package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;




import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.sist.controller.RequestMapping;
import dao.CreateSqlSessionFactory;
import dao.*;
import vo.*;

// 공모전 Model ===================================================================================================

public class GongmoModel {
		
		// 잡지식인 메인페이지 출력 (전체태그 게시물 출력) ============================================================================================
		@RequestMapping("gongmo/gongmocontainer.do")
		public String gongmocontainer(HttpServletRequest request) {
			
			
			return "../gongmo/gongmocontainer.jsp";
		}
		
	   // 공모전 전체보기 출력  =====================================================================================================
	   @RequestMapping("gongmo/gongmo_all.do")
	   public String gongmo_all(HttpServletRequest request)
	   {
		   //변수 -------------------------------------------------------------------------------------
		   String page=request.getParameter("page");
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   Map map=new HashMap();
		   int rowSize=12;
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=rowSize*curpage;
		   map.put("start", start);
		   map.put("end",end);
		   List<GongmoVO> list=GongmoDAO.gongmoTotalData(map);
		   int totalpage=GongmoDAO.gongmoTotalPage2();
		   
		   int BLOCK=5;
		   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
			HttpSession session=request.getSession();
			String id=(String)session.getAttribute("id");
			// 쿠키 읽기
			Cookie[] cookies=request.getCookies();
			List<GongmoVO> cList=new ArrayList<GongmoVO>();
			if(cookies!=null) {
				for(int i=cookies.length-1;i>0;i--) {
					if(cookies[i].getName().startsWith(id)) {
						cookies[i].setPath("/");
						String gm_no=cookies[i].getValue();
						GongmoVO vo=GongmoDAO.gongmoDetailData(Integer.parseInt(gm_no));
						cList.add(vo);
					}
				}
			}
			request.setAttribute("cList", cList);								
//		   
		   // request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
		   request.setAttribute("list", list);
		   request.setAttribute("curpage", curpage);
		   request.setAttribute("totalpage", totalpage);
		   request.setAttribute("BLOCK", BLOCK);
		   request.setAttribute("startPage", startPage);
		   request.setAttribute("endPage", endPage);
		   request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_all.jsp");

		   return "../gongmo/gongmocontainer.jsp";
	   }
	   
	   
		@RequestMapping("gongmo/gongmo_all_before.do") 
		public String gongmo_all_before(HttpServletRequest request, HttpServletResponse response) {
			   String gm_no=request.getParameter("gm_no");
			   HttpSession session=request.getSession();
			   String id=(String)session.getAttribute("id");
			   Cookie cookie=new Cookie(id+"_cookie"+gm_no,gm_no);
			   // 기간
			   cookie.setMaxAge(60*60*24);
			   cookie.setPath("/");
			   // 전송
			   response.addCookie(cookie);
			   return "redirect:../gongmo/gongmo_detail.do?no="+gm_no; // 재요청 
		}
	   
	   
		// 공모전 메인페이지 출력  =====================================================================================================
		   @RequestMapping("gongmo/gongmo_home.do")
		   public String gongmo_home(HttpServletRequest request)
		   {
			   //변수 -------------------------------------------------------------------------------------
			   String page=request.getParameter("page");
			   if(page==null)
				   page="1";
			   int curpage=Integer.parseInt(page);
			   Map map=new HashMap();
			   int rowSize=12;
			   int start=(rowSize*curpage)-(rowSize-1);
			   int end=rowSize*curpage;
			   map.put("start", start);
			   map.put("end",end);
			   List<GongmoVO> list=GongmoDAO.gongmoTotalData(map);
			   int totalpage=GongmoDAO.gongmoTotalPage2();
			   
			   int BLOCK=5;
			   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			   if(endPage>totalpage)
				   endPage=totalpage;
			   
			// 쿠키 ---------------------------------------------------------------------------------------------------
						HttpSession session=request.getSession();
						String id=(String)session.getAttribute("id");
						// 쿠키 읽기
						Cookie[] cookies=request.getCookies();									
						List<GongmoVO> cList=new ArrayList<GongmoVO>();					
						if(cookies!=null)														
						{
							for(int i=cookies.length-1;i>=0;i--)								
							{
								if(cookies[i].getName().startsWith(id))								
								{
									String gm_no=cookies[i].getValue();						
									GongmoVO vo=GongmoDAO.gongmoDetailData(Integer.parseInt(gm_no));		
									cList.add(vo);													
								}
							}
						}
						request.setAttribute("cList", cList);		
			   
			   // request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
			   request.setAttribute("list", list);
			   request.setAttribute("curpage", curpage);
			   request.setAttribute("totalpage", totalpage);
			   request.setAttribute("BLOCK", BLOCK);
			   request.setAttribute("startPage", startPage);
			   request.setAttribute("endPage", endPage);
			   request.setAttribute("main_jsp", "../gongmo/gongmo_home.jsp");
			   request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_home.jsp");
			   
			   return "../gongmo/gongmocontainer.jsp";
		   }
	   
	   // 공모전 기획/아이디어(1번) 출력  =====================================================================================================
	   @RequestMapping("gongmo/gongmo_cno1.do")
	   public String gongmo_cno1(HttpServletRequest request)
	   {
		   //변수 -------------------------------------------------------------------------------------
			String page = request.getParameter("page");
			if (page == null)
				page = "1";
			String gm_cate=request.getParameter("cno");
			int curpage = Integer.parseInt(page);
			int rowSize = 12;
			int start = (rowSize * curpage) - (rowSize - 1);
			int end = rowSize * curpage;
			
			//검색기능 ---------------------------------------------------------------------------------
			

			// Map에 저장 ------------------------------------------------------------------------------
			Map map = new HashMap();
			map.put("gm_cate", gm_cate);
			map.put("start", start);
			map.put("end", end);
			
			
			// 데이터베이스 연결
			List<GongmoVO> list = GongmoDAO.gongmoListData(map);			
			int totalpage = GongmoDAO.gongmoTotalPage(Integer.parseInt(gm_cate));
			
		
			
			int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				   endPage=totalpage;
			   
			
							
						
			   // request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
			   request.setAttribute("list", list);
			   request.setAttribute("curpage", curpage);
			   request.setAttribute("totalpage", totalpage);
			   request.setAttribute("BLOCK", BLOCK);
			   request.setAttribute("startPage", startPage);
			   request.setAttribute("endPage", endPage);
			  
			   
			request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_cno1.jsp");
			return "../gongmo/gongmocontainer.jsp";
	   }
	   
	   // 공모전 디자인(2번) 출력  =====================================================================================================
	   @RequestMapping("gongmo/gongmo_cno2.do")
	   public String gongmo_cno2(HttpServletRequest request)
	   {
		    //변수 -------------------------------------------------------------------------------------
		   	String gm_cate = request.getParameter("cno");
			String page = request.getParameter("page");
			if (page == null)
				page = "1";
	
			int curpage = Integer.parseInt(page);
			int rowSize = 12;
			int start = (rowSize * curpage) - (rowSize - 1);
			int end = rowSize * curpage;
			
			// Map에 저장 ------------------------------------------------------------------------------
			Map map = new HashMap();
			map.put("gm_cate", gm_cate);
			map.put("start", start);
			map.put("end", end);
			
			List<GongmoVO> list = GongmoDAO.gongmoListData(map);
			
			int totalpage = GongmoDAO.gongmoTotalPage(Integer.parseInt(gm_cate));
			
			int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				   endPage=totalpage;
									
			
			
			   // request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
			   request.setAttribute("list", list);
			   request.setAttribute("curpage", curpage);
			   request.setAttribute("totalpage", totalpage);
			   request.setAttribute("BLOCK", BLOCK);
			   request.setAttribute("startPage", startPage);
			   request.setAttribute("endPage", endPage);
			
			request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_cno2.jsp");
			return "../gongmo/gongmocontainer.jsp";
	   }
	   
	   // 공모전 광고/마케팅(3번) 출력  =====================================================================================================
	   @RequestMapping("gongmo/gongmo_cno3.do")
	   public String gongmo_cno3(HttpServletRequest request)
	   {
		   	//변수 -------------------------------------------------------------------------------------
		   	String gm_cate = request.getParameter("cno");
			String page = request.getParameter("page");
			if (page == null)
				page = "1";
			
			int curpage = Integer.parseInt(page);
			int rowSize = 12;
			int start = (rowSize * curpage) - (rowSize - 1);
			int end = rowSize * curpage;
			
			// Map에 저장 ------------------------------------------------------------------------------
			Map map = new HashMap();
			map.put("gm_cate", gm_cate);
			map.put("start", start);
			map.put("end", end);			
			List<GongmoVO> list = GongmoDAO.gongmoListData(map);
			
			int totalpage = GongmoDAO.gongmoTotalPage(Integer.parseInt(gm_cate));
			
			int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				   endPage=totalpage;

			   
			   // request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
			   request.setAttribute("list", list);
			   request.setAttribute("curpage", curpage);
			   request.setAttribute("totalpage", totalpage);
			   request.setAttribute("BLOCK", BLOCK);
			   request.setAttribute("startPage", startPage);
			   request.setAttribute("endPage", endPage);
			
			request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_cno3.jsp");
			return "../gongmo/gongmocontainer.jsp";
	   }
	   
	   // 공모전 영상/사진/UCC(4번) 출력  =====================================================================================================
	   @RequestMapping("gongmo/gongmo_cno4.do")
	   public String gongmo_cno4(HttpServletRequest request)
	   {
		   	//변수 -------------------------------------------------------------------------------------
		   	String gm_cate = request.getParameter("cno");
			String page = request.getParameter("page");
			if (page == null)
				page = "1";
			
			int curpage = Integer.parseInt(page);
			int rowSize = 12;
			int start = (rowSize * curpage) - (rowSize - 1);
			int end = rowSize * curpage;
			
			// Map에 저장 ------------------------------------------------------------------------------
			Map map = new HashMap();
			map.put("gm_cate", gm_cate);
			map.put("start", start);
			map.put("end", end);	
			
			
			List<GongmoVO> list = GongmoDAO.gongmoListData(map);
			
			int totalpage = GongmoDAO.gongmoTotalPage(Integer.parseInt(gm_cate));
			
			int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				   endPage=totalpage;

			   
			   // request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
			   request.setAttribute("list", list);
			   request.setAttribute("curpage", curpage);
			   request.setAttribute("totalpage", totalpage);
			   request.setAttribute("BLOCK", BLOCK);
			   request.setAttribute("startPage", startPage);
			   request.setAttribute("endPage", endPage);
			
			request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_cno4.jsp");
			return "../gongmo/gongmocontainer.jsp";
	   }
	   
	   // 공모전 문학/사나리오(5번) 출력  =====================================================================================================
	   @RequestMapping("gongmo/gongmo_cno5.do")
	   public String gongmo_cno5(HttpServletRequest request)
	   {
		    //변수 -------------------------------------------------------------------------------------
		   	String gm_cate = request.getParameter("cno");
			String page = request.getParameter("page");
			if (page == null)
				page = "1";
			
			int curpage = Integer.parseInt(page);
			int rowSize = 12;
			int start = (rowSize * curpage) - (rowSize - 1);
			int end = rowSize * curpage;
			
			// Map에 저장 ------------------------------------------------------------------------------
			Map map = new HashMap();
			map.put("gm_cate", gm_cate);
			map.put("start", start);
			map.put("end", end);			
			List<GongmoVO> list = GongmoDAO.gongmoListData(map);
			
			int totalpage = GongmoDAO.gongmoTotalPage(Integer.parseInt(gm_cate));

			int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				   endPage=totalpage;

			   
			   // request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
			   request.setAttribute("list", list);
			   request.setAttribute("curpage", curpage);
			   request.setAttribute("totalpage", totalpage);
			   request.setAttribute("BLOCK", BLOCK);
			   request.setAttribute("startPage", startPage);
			   request.setAttribute("endPage", endPage);
			
			request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_cno5.jsp");
			return "../gongmo/gongmocontainer.jsp";
	   }
	   
	   // 공모전 기타(6번) 출력  =====================================================================================================
	   @RequestMapping("gongmo/gongmo_cno6.do")
	   public String gongmo_cno6(HttpServletRequest request)
	   {
		    //변수 -------------------------------------------------------------------------------------
		   	String gm_cate = request.getParameter("cno");
			String page = request.getParameter("page");
			if (page == null)
				page = "1";
			
			int curpage = Integer.parseInt(page);
			int rowSize = 12;
			int start = (rowSize * curpage) - (rowSize - 1);
			int end = rowSize * curpage;
			
			// Map에 저장 ------------------------------------------------------------------------------
			Map map = new HashMap();
			map.put("gm_cate", gm_cate);
			map.put("start", start);
			map.put("end", end);			
			List<GongmoVO> list = GongmoDAO.gongmoListData(map);
			
			int totalpage = GongmoDAO.gongmoTotalPage(Integer.parseInt(gm_cate));

			int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				   endPage=totalpage;

			   
			   // request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
			   request.setAttribute("list", list);
			   request.setAttribute("curpage", curpage);
			   request.setAttribute("totalpage", totalpage);
			   request.setAttribute("BLOCK", BLOCK);
			   request.setAttribute("startPage", startPage);
			   request.setAttribute("endPage", endPage);
			
			request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_cno6.jsp");
			return "../gongmo/gongmocontainer.jsp";
	   }

  
	   // 공모전 디테일 출력  =====================================================================================================
	   @RequestMapping("gongmo/gongmo_detail.do")
	   public String gongmo_detail(HttpServletRequest request)
	   {
			   //페이지
			   String page=request.getParameter("page");
			   if(page==null)
				   page="1";
			   int curpage=Integer.parseInt(page);
			   Map map=new HashMap();
			   int rowSize=5;
			   int start=(rowSize*curpage)-(rowSize-1);
			   int end=rowSize*curpage;
			   map.put("start", start);
			   map.put("end",end);
			   List<GongmoVO> list=GongmoDAO.gongmoTotalData(map);
			   int totalpage=GongmoDAO.gongmoTotalPage2();
			
			   int BLOCK=5;
			   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			   if(endPage>totalpage)
				   endPage=totalpage;
			   
			   request.setAttribute("list", list);
			   request.setAttribute("curpage", curpage);
			   request.setAttribute("totalpage", totalpage);
			   request.setAttribute("BLOCK", BLOCK);
			   request.setAttribute("startPage", startPage);
			   request.setAttribute("endPage", endPage);
			
			   
			   String no=request.getParameter("no");
			   GongmoVO vo= GongmoDAO.gongmoDetailData(Integer.parseInt(no));
			   request.setAttribute("vo", vo);
			   
			   // 스크랩 버튼 활성화 여부
				HttpSession session=request.getSession();
				String id=(String)session.getAttribute("id");
				
				GongmoScrapVO gs=new GongmoScrapVO();
				gs.setId(id);
				gs.setGmno(Integer.parseInt(no));
				int count=GongmoDAO.gongmoScrapCount(gs);
				
				request.setAttribute("count", count);
				
				
				request.setAttribute("gongmocontainer_jsp", "../gongmo/gongmo_detail.jsp");
				return "../gongmo/gongmocontainer.jsp";
	    }
	   
	
			   
	   
		// 상세보기 전에 쿠키 생성하기 ==================================================================================================
//		@RequestMapping("gongmo/gongmo_before.do")
//		public String gongmo_detail_before(HttpServletRequest request, HttpServletResponse response) {
//				String no = "";
//			try {
//				
//				
//				System.out.println("쿠키생성 모델");
//				
//				// 글번호 no와 세션의 id 가져오기-----------------------------
//				
//				no = request.getParameter("no");
//				HttpSession session = request.getSession();
//				String id = (String)session.getAttribute("id");
//				
//				// 쿠키 생성 ----------------------------------------------
//				Cookie cookie = new Cookie(id + no, no);				// 쿠키의 키는 (세션아이디 + 글번호)  값은 글번호
//				cookie.setMaxAge(60*60*24);
//				cookie.setPath("/");
//				response.addCookie(cookie);
//				System.out.println("쿠키이름 : " + cookie.getName() + "값 : " + cookie.getValue());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			
//			
//			return "redirect:../gongmo/gongmo_detail.do?no=" + no;		// 글번호에 해당하는 detail.do로 리다이렉트
//		}
		

		
		
	   //========================================================================================================================
//	   
//	   // 공모전 기획/아이디어(1번) 리스트 출력  =====================================================================================================
//	   @RequestMapping("gongmo/gongmo_list_detail.do")
//	   public String gongmo_list_detail(HttpServletRequest request)
//	   {
//		   //변수 -------------------------------------------------------------------------------------
//			String page = request.getParameter("page");
//			if (page == null)
//				page = "1";
//			String gm_cate=request.getParameter("cno");
//			int curpage = Integer.parseInt(page);
//			int rowSize = 12;
//			int start = (rowSize * curpage) - (rowSize - 1);
//			int end = rowSize * curpage;
//
//			// Map에 저장 ------------------------------------------------------------------------------
//			Map map = new HashMap();
//			map.put("gm_cate", gm_cate);
//			map.put("start", start);
//			map.put("end", end);
//			
//			// 데이터베이스 연결
//			List<GongmoVO> list = GongmoDAO.gongmoListData(map);
//			
//			int totalpage = GongmoDAO.gongmoTotalPage(Integer.parseInt(gm_cate));
//			
//			// request에 값을 채운다 => JSP에서 필요한 데이터를 보내기 시작 --------------------------------------------
//			request.setAttribute("list", list);
//			request.setAttribute("curpage", curpage);
//			request.setAttribute("totalpage", totalpage);
//
//			request.setAttribute("main_jsp", "../gongmo/gongmo_list_detail.jsp");
//			return "../main/main.jsp";
//	   }
//	   
	   
		// 검색한 게시물 출력 ============================================================================================
		@RequestMapping("gongmo/gongmo_find.do")
		public String gongmo_find(HttpServletRequest request) {
			
			
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
				
				int totalpage = GongmoDAO.gongmoSearchTotalPage(map);	// 총 페이지
				if(endpage>totalpage) {
					endpage=totalpage;
				}
				List<GongmoVO> list = GongmoDAO.gongmoSearchBoard(map);			// DAO의 메소드 리턴값을 받는 List 변수
				
				// 페이지로 보낼 파라미터들 -----------------------------------------------------------
				request.setAttribute("list", list);
				request.setAttribute("currpage", currpage);
				request.setAttribute("totalpage", totalpage);
				request.setAttribute("block", block);
				request.setAttribute("startpage", startpage);
				request.setAttribute("endpage", endpage);
				request.setAttribute("main_jsp", "../gongmo/gongmo_find.jsp");
				System.out.println("검색");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return "../main/main.jsp";
		}
		
		
		   
			
			
//			// 스크랩하기(추가) ==============================================================================================================
			@RequestMapping("gongmo/gongmoScrapInsert.do")
			public String gongmo_Scrap_insert(HttpServletRequest request)
			{
				String no=request.getParameter("no");
				HttpSession session=request.getSession();
				String id=(String)session.getAttribute("id");
				GongmoScrapVO vo=new GongmoScrapVO();
				vo.setId(id);
				vo.setGmno(Integer.parseInt(no));
				GongmoDAO.gongmoScrapInsert(vo);
				return "redirect:../gongmo/gongmo_detail.do?no="+no;
			}
			
			// 스크랩 삭제 ==============================================================================================================
			@RequestMapping("gongmo/gongmoScrapCancel.do")
			public String gongmo_scrap_cancel(HttpServletRequest request)
			{
				String no=request.getParameter("no");
				GongmoDAO.gongmoScrapCancel(Integer.parseInt(no));
				return "redirect:../mypage/gongmoscrap.do";
			}
			
			// 스크랩 출력 ==========================================================================================================
			@RequestMapping("mypage/gongmoscrap.do")
			public String gongmoscrap(HttpServletRequest request)
			{
				HttpSession session=request.getSession();				
				String id=(String)session.getAttribute("id");			
				
				  
				  List<GongmoScrapVO> sList=GongmoDAO.gongmoScrapListData(id);
				  List<GongmoVO> gList=new ArrayList<GongmoVO>();
				  for(GongmoScrapVO vo:sList)
				  {
					  GongmoVO gmno=GongmoDAO.gongmoDetailData(vo.getGmno());
					  gmno.setJjim_no(vo.getNo());
					  gList.add(gmno);
				  }
				  request.setAttribute("gList", gList);
				
				  request.setAttribute("gongmocontainer_jsp", "../mypage/gongmoscrap.jsp");
				
				  return "../gongmo/gongmocontainer.jsp";
			}
			
			 @RequestMapping("mypage/gongmo_scrap_mypage.do")
			 public String news_scrap_mypage(HttpServletRequest request){
				 HttpSession session=request.getSession();
				 String id=(String)session.getAttribute("id");
						  
				 List<GongmoScrapVO> sList=GongmoDAO.gongmoScrapListData(id);
				  List<GongmoVO> gList=new ArrayList<GongmoVO>();
				  for(GongmoScrapVO vo:sList)
				  {
					  GongmoVO gmno=GongmoDAO.gongmoDetailData(vo.getGmno());
					  gmno.setJjim_no(vo.getNo());
					  gList.add(gmno);
				  }
				  request.setAttribute("gList", gList);
				 request.setAttribute("gongmocontainer_jsp", "../mypage/gongmoscrap.jsp");
				 return "../gongmo/gongmocontainer.jsp";
			 }
			
}

			
	   
	 	

