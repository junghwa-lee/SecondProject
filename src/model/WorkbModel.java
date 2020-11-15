package model;
import java.text.SimpleDateFormat;


import java.util.*;

import vo.*;
import dao.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.controller.RequestMapping;

import javax.servlet.http.HttpSession;

public class WorkbModel {
	@RequestMapping("Workb/workb.do")
	public String workb(HttpServletRequest request) {
		try {
		String page=request.getParameter("page");
		String lcateno = request.getParameter("lcateno");	
		if(page == null) 
			page = "1";
		
		
		int curpage=Integer.parseInt(page);
		int totalpage=WorkbDAO.workbTotalPage();
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = (rowSize*curpage);
		int block = 5;												// 페이지 블록
		int startpage=((curpage-1)/block*block)+1;					
		int endpage=((curpage-1)/block*block)+block;
		if(endpage>totalpage) {
			endpage=totalpage;
		}
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("lcateno", lcateno);
		
		List<WorkBVO> list=WorkbDAO.workbListData(map);
		
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("block", block);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("main_jsp", "../Workb/workb.jsp");
		
		
		// 쿠키
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		// 쿠키 읽기
					Cookie[] cookies=request.getCookies();							// 쿠키 배열 생성
					List<WorkBVO> cList=new ArrayList<WorkBVO>();					// 쿠키를 담을 리스트 생성
					if(cookies!=null)												// 쿠키가 비어있지 않으면
					{
						for(int i=cookies.length-1;i>=0;i--)						// (쿠키길이 - 1)부터 0까지 i를 1씩 감소 (그래야 최신 쿠키가 맨앞에 옴)
						{
							if(cookies[i].getName().startsWith(id))							// 쿠키배열의 이름이 id를 시작하면
							{
								String no=cookies[i].getValue();								// 변수 no에 쿠키값 넣기
								WorkBVO vo=WorkbDAO.workbDetailData(Integer.parseInt(no));		// vo에 상세보기를 담아서
								cList.add(vo);													// 쿠키배열에 vo 담기
							}
						}
					}
					request.setAttribute("cList", cList);			

			// 페이지로 보낼 파라미터들 -----------------------------------------------------------
			request.setAttribute("list", list);
			request.setAttribute("currpage", curpage);
			request.setAttribute("totalpage", totalpage);
			request.setAttribute("lcateno", lcateno);
			request.setAttribute("Workb_jsp", "../Workb/workb.jsp");
			System.out.println("채용 공고 메인 페이지");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return "../main/main.jsp";
	}	
	// 태그별 게시물 출력 
		@RequestMapping("Workb/WorkbBySelect.do")
		public String WorkbBySelect(HttpServletRequest request) {
			
			
			try {
				System.out.println("태그별 게시물출력 모델");
				
				// 변수 -------------------------------------------------------------
				String page = request.getParameter("page");					// 사용자로부터 받는 페이지
				String lcateno = request.getParameter("lcateno");					// 사용자로부터 받는 태그
				System.out.println("lcateno"+lcateno);
				if(page == null) {		
					page = "1";
				}
				if(lcateno == null) {
					lcateno = "채용 공고";
				}
				
				int currpage = Integer.parseInt(page);								// 현재 페이지
				int totalpage = WorkbDAO.workbTotalPage();	// 총 페이지
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
				map.put("lcateno",lcateno);
				
				List<WorkBVO> list = WorkbDAO.workbListDataBySelect(map);			// DAO의 메소드 리턴값을 받는 List 변수
			
				request.setAttribute("list", list);
				request.setAttribute("currpage", currpage);
				request.setAttribute("totalpage", totalpage);
				request.setAttribute("block", block);
				request.setAttribute("startpage", startpage);
				request.setAttribute("endpage", endpage);
				request.setAttribute("lcateno", lcateno);
				request.setAttribute("main_jsp", "../Workb/workb.jsp");
				System.out.println("채용 공고");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return "../main/main.jsp";
		}
		
	// 상세보기 전에 쿠키 생성
		@RequestMapping("Workb/detail_before.do")
		public String workb_detail_before(HttpServletRequest request, HttpServletResponse response) {
				String no = "";
			try {
				System.out.println("쿠키생성 모델");
				
				// 글번호 no와 세션의 id 가져오기
				no = request.getParameter("no");
				HttpSession session = request.getSession();
				String id = (String)session.getAttribute("id");
				
				// 쿠키 생성
				Cookie cookie = new Cookie(id + no, no);				// 쿠키의 키는 (세션아이디 + 글번호)  값은 글번호
				cookie.setMaxAge(60*60*24);
				cookie.setPath("/");
				response.addCookie(cookie);
				System.out.println("쿠키이름 : " + cookie.getName() + "값 : " + cookie.getValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:../Workb/detail.do?no=" + no;		// 글번호에 해당하는 detail.do로 리다이렉트
		}

	//채용공고 상세보기
	   @RequestMapping("Workb/detail.do")
	   public String workb_detail(HttpServletRequest request) {
	      String l_no=request.getParameter("l_no");
	      String lcateno=request.getParameter("lcateno");

	      WorkBVO vo=WorkbDAO.workbDetailData(Integer.parseInt(l_no));
	      request.setAttribute("vo", vo);
	      
	      request.setAttribute("main_jsp", "../Workb/detail.jsp");
	      return "../main/main.jsp";
	   }
	// 채용 달력
	   @RequestMapping("jobcalendar/date.do")
	   public String jobcalendar_date(HttpServletRequest request)
	   {
	 	  String strYear=request.getParameter("year");
	 	  String strMonth=request.getParameter("month");
	 	  String tno=request.getParameter("lno");
	 	  if(tno==null)
	 		  tno="1";
	 	  
	 	  Date date=null;
	 		try {
	 			date = new Date();
	 		} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 	  // 2020-10
	 	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
	 	  // MM dd (X)  M d 01 ~ 09 10 11 12   09
	 	  // 1 2 3 .... 10 11 12
	 	  String today=sdf.format(date);
	 	  StringTokenizer st=new StringTokenizer(today,"-");
	 	  
	 	  if(strYear==null)
	 	  {
	 		  strYear=st.nextToken();// yyyy
	 	  }
	 	  
	 	  if(strMonth==null)
	 	  {
	 		  strMonth=st.nextToken();
	 	  }
	 	  
	 	  int day=Integer.parseInt(st.nextToken());// 화면 
	 	  int year=Integer.parseInt(strYear);
	 	  int month=Integer.parseInt(strMonth);
	 	  
	 	  Calendar cal=Calendar.getInstance();// Calendar클래스 생성 
	 	  cal.set(Calendar.YEAR,year);
	 	  cal.set(Calendar.MONTH,month-1);// month=>0~11
	 	  cal.set(Calendar.DATE,1);
	 	  
	 	  // 요일을 구한다
	 	  int week=cal.get(Calendar.DAY_OF_WEEK);// 1~7 ==> week-1
	 	  int lastday=cal.getActualMaximum(Calendar.DATE);
	 	  String[] strWeek={"일","월","화","수","목","금","토"};
	 	  System.out.println("요일:"+strWeek[week-1]);
	 	  System.out.println("마지막날:"+lastday);
	 	  String rday=WorkbDAO.jobcalendarDayData();
	 	  System.out.println("ldeadline="+rday);
	 	  // jsp로 전송 
	 	  request.setAttribute("ldeadline", rday);
	 	  request.setAttribute("year", year);
	 	  request.setAttribute("month", month);
	 	  request.setAttribute("day", day);
	 	  request.setAttribute("week", week-1);
	 	  request.setAttribute("strWeek", strWeek);
	 	  request.setAttribute("lastday", lastday);
	 	  // 1일자의 요일 
	 	  return "../jobcalendar/date.jsp";
	   }
	   
	// 좋아요
		@RequestMapping("Workb/like.do")
		public String workb_like(HttpServletRequest request) {
			String no = request.getParameter("no");
			WorkbDAO.likeIncrement(Integer.parseInt(no));
			return "redirect:../Workb/detail.do?no=" + no;
		}

		// 스크랩
		@RequestMapping("Workb/jjim.do")
		public String workb_jjim(HttpServletRequest request) {
			String no = request.getParameter("no");
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			JjimVO vo = new JjimVO();
			vo.setId(id);
			vo.setL_no(Integer.parseInt(no));
			WorkbDAO.jjimInsert(vo);
			return "redirect:../Workb/detail.do?no=" + no;
		}
		// 찜 취소
		@RequestMapping("Workb/jjim_cancel.do")
		public String workb_jjim_cancel(HttpServletRequest request) {
			String no = request.getParameter("no");
			WorkbDAO.jjimDelete(Integer.parseInt(no));
			return "redirect:../jobcalendar/mypage.do";
		}

		// 마이페이지
		@RequestMapping("jobcalendar/mypage.do")
		public String jobcalendar_mypage(HttpServletRequest request) {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			request.setAttribute("main_jsp", "../jobcalendar/mypage.jsp");

			List<JjimVO> jList = WorkbDAO.jjimListData(id);
			List<WorkBVO> WList = new ArrayList<WorkBVO>();
			for (JjimVO vo : jList) {
				WorkBVO wvo = WorkbDAO.workbDetailData(vo.getL_no());
				String title = wvo.getLtitle();
				wvo.setL_no(vo.getNo());
				WList.add(wvo);
			}
			request.setAttribute("WList", WList);
			return "../main/main.jsp";
		}
	   
}