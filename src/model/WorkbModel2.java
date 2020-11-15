package model;
import java.util.*;

import vo.*;
import dao.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import javax.servlet.http.HttpSession;

public class WorkbModel2 {
	@RequestMapping("Workb/workb2.do")
	public String workb(HttpServletRequest request) {
		try {
		String page=request.getParameter("page");
		String lcateno = request.getParameter("lcateno");	
		if(page==null) 
			page="1";
		
		int curpage=Integer.parseInt(page);
		int totalpage=WorkbDAO2.workbTotalPage2();
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
		
		List<WorkBVO> list=WorkbDAO2.workbListData2(map);
		
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("block", block);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("main_jsp", "../Workb/workb2.jsp");
		
		
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
								WorkBVO vo=WorkbDAO2.workbDetailData2(Integer.parseInt(no));		// vo에 상세보기를 담아서
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
			request.setAttribute("Workb2_jsp", "../Workb/workb2.jsp");
			System.out.println("채용 공고 메인 페이지");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return "../main/main.jsp";
	}	
	// 태그별 게시물 출력 
		@RequestMapping("Workb/WorkbBySelect2.do")
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
				int totalpage = WorkbDAO2.workbTotalPage2();	// 총 페이지
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
				
				List<WorkBVO> list = WorkbDAO2.workbListDataBySelect2(map);	// DAO의 메소드 리턴값을 받는 List 변수
				// 쿠키 ---------------------------------------------------------------------------------------
//				HttpSession session=request.getSession();
//				String id=(String)session.getAttribute("id");
//				// 쿠키 읽기
//				Cookie[] cookies=request.getCookies();							// 쿠키 배열 생성
//				List<WorkBVO> cList=new ArrayList<WorkBVO>();					// 쿠키를 담을 리스트 생성
//				if(cookies!=null)												// 쿠키가 비어있지 않으면
//				{
//					for(int i=cookies.length-1;i>=0;i--)						// (쿠키길이 - 1)부터 0까지 i를 1씩 감소 (그래야 최신 쿠키가 맨앞에 옴)
//					{
//						if(cookies[i].getName().startsWith(id))							// 쿠키배열의 이름이 id를 시작하면
//						{
//							String no=cookies[i].getValue();								// 변수 no에 쿠키값 넣기
//							WorkBVO vo=WorkbDAO.workbDetailData(Integer.parseInt(no));		// vo에 상세보기를 담아서
//							cList.add(vo);													// 쿠키배열에 vo 담기
//						}
//					}
//				}
//				request.setAttribute("cList", cList);										// 쿠키값이 담긴 리스트를 전송
				// 페이지로 보낼 파라미터들 -----------------------------------------------------------
				request.setAttribute("list", list);
				request.setAttribute("currpage", currpage);
				request.setAttribute("totalpage", totalpage);
				request.setAttribute("block", block);
				request.setAttribute("startpage", startpage);
				request.setAttribute("endpage", endpage);
				request.setAttribute("lcateno", lcateno);
				// 태그 파라미터 보내기
//				request.setAttribute("Workb_jsp","../Workb/WorkbBySelect.jsp");
				request.setAttribute("main_jsp", "../Workb/workb2.jsp");
				System.out.println("채용 공고");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return "../main/main.jsp";
		}
		
		/*
		 * // 상세보기 전에 쿠키 생성
		 * 
		 * @RequestMapping("Workb/detail_before2.do") public String
		 * workb_detail_before2(HttpServletRequest request, HttpServletResponse
		 * response) { String no = ""; try { System.out.println("쿠키생성 모델");
		 * 
		 * // 글번호 no와 세션의 id 가져오기 no = request.getParameter("no"); HttpSession session =
		 * request.getSession(); String id = (String)session.getAttribute("id");
		 * 
		 * // 쿠키 생성 Cookie cookie = new Cookie(id + no, no); // 쿠키의 키는 (세션아이디 + 글번호) 값은
		 * 글번호 cookie.setMaxAge(60*60*24); cookie.setPath("/");
		 * response.addCookie(cookie); System.out.println("쿠키이름 : " + cookie.getName() +
		 * "값 : " + cookie.getValue()); } catch (Exception e) { e.printStackTrace(); }
		 * return "redirect:../Workb/detail2.do?no=" + no; // 글번호에 해당하는 detail.do로 리다이렉트
		 * }
		 */

	//채용공고 상세보기
	   @RequestMapping("Workb/detail2.do")
	   public String workb_detail2(HttpServletRequest request) {
	      String l_no=request.getParameter("l_no");
	      String lcateno=request.getParameter("lcateno");

	      WorkBVO vo=WorkbDAO2.workbDetailData2(Integer.parseInt(l_no));
	      request.setAttribute("vo", vo);
	      
	      request.setAttribute("main_jsp", "../Workb/detail2.jsp");
	      return "../main/main.jsp";
	   }
}