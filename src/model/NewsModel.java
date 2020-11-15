package model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;

import java.util.*;
import dao.*;
import vo.*;

public class NewsModel {
	
	// 뉴스리스트, 인기글, 페이지나누기, 전체글갯수, 쿠키
	@RequestMapping("newsTipVideo/news.do")
	public String newsList(HttpServletRequest request) {
		String page=request.getParameter("page");
		if(page==null)
		  page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=6;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		Map map=new HashMap();
		map.put("start",start);
		map.put("end", end);
		List<NewsVO> list=NewsDAO.newsListData(map);
		for(NewsVO vo:list) {
			int rc=NewsDAO.newsReplyCount(vo.getN_no());
			vo.setN_replyCount(rc);
		}
		// 인기글
		List<NewsVO> hlist=NewsDAO.newsHitList(map);
		
		// 전체글갯수
		int newscount=NewsDAO.newsCount();
		
		// 총페이지
		int totalpage=NewsDAO.newsTotalPage();
		if(endPage>totalpage)
			endPage=totalpage;
		request.setAttribute("newscount", newscount);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("hlist", hlist);
		request.setAttribute("list", list);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		// 쿠키 읽기
		Cookie[] cookies=request.getCookies();
		List<NewsVO> cList=new ArrayList<NewsVO>();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith(id)) {
					String no=cookies[i].getValue();
					NewsVO vo=NewsDAO.newsDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		request.setAttribute("cList", cList);
		request.setAttribute("news_container", "../newsTipVideo/news.jsp");
		return "../newsTipVideo/newscontainer.jsp";
	}
	
	// 뉴스 쿠키
	@RequestMapping("newsTipVideo/news_before.do")
	public String news_detail_before(HttpServletRequest request, HttpServletResponse response) {
	   String no=request.getParameter("no");
	   HttpSession session=request.getSession();
	   String id=(String)session.getAttribute("id");
	   Cookie cookie=new Cookie(id+no, no);
	   // 기간
	   cookie.setMaxAge(60*60*24);
	   // 전송
	   response.addCookie(cookie);
	   return "redirect:../newsTipVideo/news.do?no="+no; // 재요청 
	}
	
	// 뉴스 검색
	@RequestMapping("newsTipVideo/newsSearch.do")
	public String news_search(HttpServletRequest request) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		String searchkey=request.getParameter("searchkey");
		
		int curpage=Integer.parseInt(page);
		int rowSize=6;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("searchkey", searchkey);
		
		int searchcount=NewsDAO.newsSearchCount(map);
		int totalpage=NewsDAO.newsSearchTotalPage(map);
		if(endPage>totalpage)
			endPage=totalpage;
		List<NewsVO> list=NewsDAO.newsSearch(map);
		
		request.setAttribute("searchcount", searchcount);
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("searchkey", searchkey);
		request.setAttribute("news_container", "../newsTipVideo/newssearch.jsp");
		return "../newsTipVideo/newscontainer.jsp";
	}
	
	// 뉴스 상세페이지
	@RequestMapping("newsTipVideo/newsdetail.do")
	public String newsDetail(HttpServletRequest request) {
		String no=request.getParameter("no");
		NewsVO vo=NewsDAO.newsDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		// 리플
		List<newsReplyVO> list=NewsDAO.newsReplyListData(Integer.parseInt(no));
		request.setAttribute("rList", list);
		
		NewsScrapVO ns=new NewsScrapVO();
		ns.setId(id);
		ns.setNno(Integer.parseInt(no));
		int count=NewsDAO.newsScrapCount(ns);
		request.setAttribute("count", count);
		request.setAttribute("news_container", "../newsTipVideo/newsdetail.jsp");
		return "../newsTipVideo/newscontainer.jsp";
	}
	
	// 게시물에 댓글 
	   @RequestMapping("newsTipVideo/news_reply_insert.do")
	   public String news_reply_insert(HttpServletRequest request)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
			   
		   }catch(Exception ex) {}
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   HttpSession session=request.getSession();
		   String id=(String)session.getAttribute("id");
		   // VO에 담아서 => DAO
		   newsReplyVO vo=new newsReplyVO();
		   vo.setBno(Integer.parseInt(bno));
		   vo.setId(id);
		   vo.setMsg(msg);
		   // DAO연결 
		   NewsDAO.newsReplyInsert(vo);
		   return "redirect:../newsTipVideo/newsdetail.do?no="+bno;
	   }
	   @RequestMapping("newsTipVideo/news_reply_reply_insert.do")
	   public String news_reply_reply_insert(HttpServletRequest request)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
		   }catch(Exception ex) {}
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   newsReplyVO vo=new newsReplyVO();
		   //vo.setRoot(Integer.parseInt(no));
		   vo.setBno(Integer.parseInt(bno));
		   vo.setMsg(msg);
		   HttpSession session=request.getSession();
		   String id=(String)session.getAttribute("id");
		   vo.setId(id);
		   // DB연동 
		   NewsDAO.newsReplyReplyInsert(Integer.parseInt(no), vo);
		   return "redirect:../newsTipVideo/newsdetail.do?no="+bno;
	   }
	   
	   @RequestMapping("newsTipVideo/news_reply_update.do")
	   public String news_reply_update(HttpServletRequest request)
	   {
		   // 데이터 받기
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
		   }catch(Exception ex) {}
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   // DB => UPDATE
		   newsReplyVO vo=new newsReplyVO();
		   vo.setNo(Integer.parseInt(no));
		   vo.setMsg(msg);
		   
		   NewsDAO.newsReplyUpdate(vo);
		   return "redirect:../newsTipVideo/newsdetail.do?no="+bno;
	   }
	   
	   @RequestMapping("newsTipVideo/news_reply_delete.do")
	   public String news_reply_delete(HttpServletRequest request)
	   {
		   // 데이터 받기
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   NewsDAO.newsReplyDelete(Integer.parseInt(no));
		   return "redirect:../newsTipVideo/newsdetail.do?no="+bno;
	   }
	
	// 팁리스트, 인기글, 페이지나누기, 전체글갯수, 쿠키
	@RequestMapping("newsTipVideo/tip.do")
	public String tipList(HttpServletRequest request) {
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=6;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   Map map=new HashMap();
	   map.put("start",start);
	   map.put("end", end);
	   List<TipVO> list=NewsDAO.tipListData(map);
	   
	   for(TipVO vo:list) {
			int rc=NewsDAO.tipReplyCount(vo.getT_no());
			vo.setT_replyCount(rc);
		}
	   
	   // 인기글
	   List<TipVO> hlist=NewsDAO.tipHitList(map);
	   // 총페이지
	   int totalpage=NewsDAO.tipTotalPage();
	   int tipcount=NewsDAO.tipCount();
	   
	   int BLOCK=5;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   request.setAttribute("BLOCK", BLOCK);
	   request.setAttribute("startPage", startPage);
	   request.setAttribute("endPage", endPage);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   request.setAttribute("list", list);
	   request.setAttribute("hlist", hlist);
	   request.setAttribute("tipcount", tipcount);
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		// 쿠키 읽기
		Cookie[] cookies=request.getCookies();
		List<TipVO> cList=new ArrayList<TipVO>();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith(id)) {
					String no=cookies[i].getValue();
					TipVO vo=NewsDAO.tipDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		request.setAttribute("cList", cList);
	   
	   request.setAttribute("news_container", "../newsTipVideo/tip.jsp");
	   return "../newsTipVideo/newscontainer.jsp";
	}
	
	// 팁 쿠키
	@RequestMapping("newsTipVideo/tip_before.do")
	public String tip_detail_before(HttpServletRequest request, HttpServletResponse response) {
	   String no=request.getParameter("no");
	   HttpSession session=request.getSession();
	   String id=(String)session.getAttribute("id");
	   Cookie cookie=new Cookie(id+no, no);
	   // 기간
	   cookie.setMaxAge(60*60*24);
	   // 전송
	   response.addCookie(cookie);
	   return "redirect:../newsTipVideo/tip.do?no="+no; // 재요청 
	}
	
	// 팁 검색
		@RequestMapping("newsTipVideo/tipSearch.do")
		public String tip_search(HttpServletRequest request) {
			String page=request.getParameter("page");
			if(page==null)
				page="1";
			String searchkey=request.getParameter("searchkey");
			
			int curpage=Integer.parseInt(page);
			int rowSize=6;
			int start=(rowSize*curpage)-(rowSize-1);
			int end=rowSize*curpage;
			int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
				
			Map map=new HashMap();
			map.put("start", start);
			map.put("end", end);
			map.put("searchkey", searchkey);
			
			int searchcount=NewsDAO.tipSearchCount(map);
			int totalpage=NewsDAO.tipSearchTotalPage(map);
			if(endPage>totalpage)
				endPage=totalpage;
			List<TipVO> list=NewsDAO.tipSearch(map);
			
			request.setAttribute("searchcount", searchcount);
			request.setAttribute("searchkey", searchkey);
			request.setAttribute("list", list);
			request.setAttribute("curpage", curpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("BLOCK", BLOCK);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("news_container", "../newsTipVideo/tipsearch.jsp");
			return "../newsTipVideo/newscontainer.jsp";
		}
	 
	// 팁 상세페이지
	@RequestMapping("newsTipVideo/tipdetail.do")
	public String tipDetail(HttpServletRequest request) {
		String no=request.getParameter("no");
		TipVO vo=NewsDAO.tipDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		List<tipReplyVO> list=NewsDAO.tipReplyListData(Integer.parseInt(no));
		request.setAttribute("rList", list);
		
		TipScrapVO ts=new TipScrapVO();
		ts.setId(id);
		ts.setTno(Integer.parseInt(no));
		int count=NewsDAO.tipScrapCount(ts);
		request.setAttribute("count", count);
		request.setAttribute("news_container", "../newsTipVideo/tipdetail.jsp");
		return "../newsTipVideo/newscontainer.jsp";
	}
	
	// 팁 게시물에 댓글 
	   @RequestMapping("newsTipVideo/tip_reply_insert.do")
	   public String tip_reply_insert(HttpServletRequest request)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
			   
		   }catch(Exception ex) {}
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   HttpSession session=request.getSession();
		   String id=(String)session.getAttribute("id");
		   // VO에 담아서 => DAO
		   tipReplyVO vo=new tipReplyVO();
		   vo.setBno(Integer.parseInt(bno));
		   vo.setId(id);
		   vo.setMsg(msg);
		   // DAO연결 
		   NewsDAO.tipReplyInsert(vo);
		   return "redirect:../newsTipVideo/tipdetail.do?no="+bno;
	   }
	   @RequestMapping("newsTipVideo/tip_reply_reply_insert.do")
	   public String tip_reply_reply_insert(HttpServletRequest request)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
		   }catch(Exception ex) {}
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   tipReplyVO vo=new tipReplyVO();
		   //vo.setRoot(Integer.parseInt(no));
		   vo.setBno(Integer.parseInt(bno));
		   vo.setMsg(msg);
		   HttpSession session=request.getSession();
		   String id=(String)session.getAttribute("id");
		   vo.setId(id);
		   // DB연동 
		   NewsDAO.tipReplyReplyInsert(Integer.parseInt(no), vo);
		   return "redirect:../newsTipVideo/tipdetail.do?no="+bno;
	   }
	   
	   @RequestMapping("newsTipVideo/tip_reply_update.do")
	   public String tip_reply_update(HttpServletRequest request)
	   {
		   // 데이터 받기
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
		   }catch(Exception ex) {}
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   // DB => UPDATE
		   tipReplyVO vo=new tipReplyVO();
		   vo.setNo(Integer.parseInt(no));
		   vo.setMsg(msg);
		   
		   NewsDAO.tipReplyUpdate(vo);
		   return "redirect:../newsTipVideo/tipdetail.do?no="+bno;
	   }
	   
	   @RequestMapping("newsTipVideo/tip_reply_delete.do")
	   public String tip_reply_delete(HttpServletRequest request)
	   {
		   // 데이터 받기
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   NewsDAO.tipReplyDelete(Integer.parseInt(no));
		   return "redirect:../newsTipVideo/tipdetail.do?no="+bno;
	   }
	
	
	// 비디오리스트, 인기글, 페이지나누기, 전체글갯수, 쿠키
	@RequestMapping("newsTipVideo/video.do")
	public String videoList(HttpServletRequest request) {
		String page=request.getParameter("page");
		if(page==null)
		  page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		   
		map.put("start",start);
		map.put("end", end);
		List<VideoVO> list=NewsDAO.videoListData(map);
		
		for(VideoVO vo:list) {
			int rc=NewsDAO.videoReplyCount(vo.getV_no());
			vo.setV_replyCount(rc);
		}
		
		// 인기글
		List<VideoVO> hlist=NewsDAO.videoHitList(map);
		// 총페이지
		int totalpage=NewsDAO.videoTotalPage();
		// 전체글갯수
		int videocount=NewsDAO.videoCount();
		int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		request.setAttribute("hlist", hlist);
		request.setAttribute("videocount", videocount);
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		// 쿠키 읽기
		Cookie[] cookies=request.getCookies();
		List<VideoVO> cList=new ArrayList<VideoVO>();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith(id)) {
					String no=cookies[i].getValue();
					VideoVO vo=NewsDAO.videoDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		request.setAttribute("cList", cList);
		
		request.setAttribute("news_container", "../newsTipVideo/video.jsp");
		return "../newsTipVideo/newscontainer.jsp";
	}
	
	// 비디오 쿠키
	@RequestMapping("newsTipVideo/video_before.do")
	public String video_detail_before(HttpServletRequest request, HttpServletResponse response) {
	   String no=request.getParameter("no");
	   HttpSession session=request.getSession();
	   String id=(String)session.getAttribute("id");
	   Cookie cookie=new Cookie(id+no, no);
	   // 기간
	   cookie.setMaxAge(60*60*24);
	   // 전송
	   response.addCookie(cookie);
	   return "redirect:../newsTipVideo/video.do?no="+no; // 재요청 
	}
	
	// 비디오 검색
		@RequestMapping("newsTipVideo/videoSearch.do")
		public String video_search(HttpServletRequest request) {
			String page=request.getParameter("page");
			if(page==null)
				page="1";
			String searchkey=request.getParameter("searchkey");
			
			int curpage=Integer.parseInt(page);
			int rowSize=12;
			int start=(rowSize*curpage)-(rowSize-1);
			int end=rowSize*curpage;
			int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
				
			Map map=new HashMap();
			map.put("start", start);
			map.put("end", end);
			map.put("searchkey", searchkey);
			
			int searchcount=NewsDAO.videoSearchCount(map);
			int totalpage=NewsDAO.videoSearchTotalPage(map);
			if(endPage>totalpage)
				endPage=totalpage;
			List<VideoVO> list=NewsDAO.videoSearch(map);
			
			request.setAttribute("searchcount", searchcount);
			request.setAttribute("searchkey", searchkey);
			request.setAttribute("list", list);
			request.setAttribute("curpage", curpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("BLOCK", BLOCK);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("news_container", "../newsTipVideo/videosearch.jsp");
			return "../newsTipVideo/newscontainer.jsp";
		}
	
	// 비디오 상세페이지
	@RequestMapping("newsTipVideo/videodetail.do")
	public String videoDetail(HttpServletRequest request) {
		String no=request.getParameter("no");
		VideoVO vo=NewsDAO.videoDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		// 리플
		List<videoReplyVO> list=NewsDAO.videoReplyListData(Integer.parseInt(no));
		request.setAttribute("rList", list);
		
		// 스크랩
		VideoScrapVO vs=new VideoScrapVO();
		vs.setId(id);
		vs.setVno(Integer.parseInt(no));
		int count=NewsDAO.videoScrapCount(vs);
		request.setAttribute("count", count);
		request.setAttribute("news_container", "../newsTipVideo/videodetail.jsp");
		return "../newsTipVideo/newscontainer.jsp";
	}
	
	
	// 비디오 게시물에 댓글 
	   @RequestMapping("newsTipVideo/video_reply_insert.do")
	   public String video_reply_insert(HttpServletRequest request)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
			   
		   }catch(Exception ex) {}
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   HttpSession session=request.getSession();
		   String id=(String)session.getAttribute("id");
		   // VO에 담아서 => DAO
		   videoReplyVO vo=new videoReplyVO();
		   vo.setBno(Integer.parseInt(bno));
		   vo.setId(id);
		   vo.setMsg(msg);
		   // DAO연결 
		   NewsDAO.videoReplyInsert(vo);
		   return "redirect:../newsTipVideo/videodetail.do?no="+bno;
	   }
	   @RequestMapping("newsTipVideo/video_reply_reply_insert.do")
	   public String video_reply_reply_insert(HttpServletRequest request)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
		   }catch(Exception ex) {}
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   videoReplyVO vo=new videoReplyVO();
		   //vo.setRoot(Integer.parseInt(no));
		   vo.setBno(Integer.parseInt(bno));
		   vo.setMsg(msg);
		   HttpSession session=request.getSession();
		   String id=(String)session.getAttribute("id");
		   vo.setId(id);
		   // DB연동 
		   NewsDAO.videoReplyReplyInsert(Integer.parseInt(no), vo);
		   return "redirect:../newsTipVideo/videodetail.do?no="+bno;
	   }
	   
	   @RequestMapping("newsTipVideo/video_reply_update.do")
	   public String video_reply_update(HttpServletRequest request)
	   {
		   // 데이터 받기
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
		   }catch(Exception ex) {}
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   String msg=request.getParameter("msg");
		   // DB => UPDATE
		   videoReplyVO vo=new videoReplyVO();
		   vo.setNo(Integer.parseInt(no));
		   vo.setMsg(msg);
		   
		   NewsDAO.videoReplyUpdate(vo);
		   return "redirect:../newsTipVideo/videodetail.do?no="+bno;
	   }
	   
	   @RequestMapping("newsTipVideo/video_reply_delete.do")
	   public String video_reply_delete(HttpServletRequest request)
	   {
		   // 데이터 받기
		   String no=request.getParameter("no");
		   String bno=request.getParameter("bno");
		   NewsDAO.videoReplyDelete(Integer.parseInt(no));
		   return "redirect:../newsTipVideo/videodetail.do?no="+bno;
	   }
	
	
	// 뉴스 스크랩
	@RequestMapping("newsTipVideo/newsScrapInsert.do")
	public String news_scrap_insert(HttpServletRequest request) {
		String no=request.getParameter("no");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		NewsScrapVO vo=new NewsScrapVO();
		vo.setId(id);
		vo.setNno(Integer.parseInt(no));
		NewsDAO.newsScrapInsert(vo);
		return "redirect:../newsTipVideo/newsdetail.do?no="+no;
	 }
	
	// 팁 스크랩
	@RequestMapping("newsTipVideo/tipScrapInsert.do")
	public String tip_scrap_insert(HttpServletRequest request) {
		String no=request.getParameter("no");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		TipScrapVO vo=new TipScrapVO();
		vo.setId(id);
		vo.setTno(Integer.parseInt(no));
		NewsDAO.tipScrapInsert(vo);
		return "redirect:../newsTipVideo/tipdetail.do?no="+no;
	 }
	
	// 비디오 스크랩
	@RequestMapping("newsTipVideo/videoScrapInsert.do")
	public String video_scrap_insert(HttpServletRequest request) {
		String no=request.getParameter("no");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		VideoScrapVO vo=new VideoScrapVO();
		vo.setId(id);
		vo.setVno(Integer.parseInt(no));
		NewsDAO.videoScrapInsert(vo);
		return "redirect:../newsTipVideo/videodetail.do?no="+no;
	 }
	
	// 뉴스 스크랩 삭제
	@RequestMapping("newsTipVideo/newsScrapCancel.do")
	public String news_scrap_cancel(HttpServletRequest request) {
		String no=request.getParameter("no");
		NewsDAO.newsScrapDelete(Integer.parseInt(no));
		return "redirect:../mypage/newsscrap.do";
	}
	
	// 팁 스크랩 삭제
	@RequestMapping("newsTipVideo/tipScrapCancel.do")
	public String tip_scrap_cancel(HttpServletRequest request) {
		String no=request.getParameter("no");
		NewsDAO.tipScrapDelete(Integer.parseInt(no));
		return "redirect:../mypage/tipscrap.do";
	}
		
	// 비디오 스크랩 삭제
	@RequestMapping("newsTipVideo/videoScrapCancel.do")
	public String video_scrap_cancel(HttpServletRequest request) {
		String no=request.getParameter("no");
		NewsDAO.videoScrapDelete(Integer.parseInt(no));
		return "redirect:../mypage/videoscrap.do";
	}

}