package model;

import java.util.*;

import dao.ComDAO;
import vo.*;
import dao.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import com.sist.controller.RequestMapping;
import javax.servlet.http.HttpSession;

public class ComModel {
	// 기업목록 보기(카테고리별)
		@RequestMapping("company/company.do")
		public String company(HttpServletRequest request) {
			String page = request.getParameter("page");
			if (page == null)
				page = "1";
			String cateno = request.getParameter("cateno");
			if (cateno == null)
				cateno = "100";
			int curpage = Integer.parseInt(page);
			int rowSize = 8;
			int start = (rowSize * curpage) - (rowSize - 1);
			int end = rowSize * curpage;
			// map에 저장
			Map map = new HashMap();
			map.put("cateno", cateno);
			map.put("start", start);
			map.put("end", end);

			List<ComVO> list = ComDAO.comListData(map);
			int totalpage = ComDAO.comTotalPage(Integer.parseInt(cateno));

			request.setAttribute("list", list);
			request.setAttribute("curpage", curpage);
			request.setAttribute("totalpage", totalpage);
			// ======================================================
			// 쿠키
			
			 //HttpSession session=request.getSession(); 
			 //String id=(String)session.getAttribute("id"); 
			 //쿠키읽기
			 //Cookie[] cookies=request.getCookies(); 
			 //List<ComVO> cList=new ArrayList<ComVO>();
			 //if(cookies!=null) { 
				 //for(int i=cookies.length-1;i>=0;i--) {
					 //if(cookies[i].getName().startsWith(id)) { 
						 //String cno=cookies[i].getValue();
						 //ComVO vo=ComDAO.comDetailData(Integer.parseInt(cno));
						 //cList.add(vo); 
					 //} 
				 //} 
			//}
			//request.setAttribute("cList", cList);
			 
			// ==========================================================

			request.setAttribute("main_jsp", "../company/company.jsp");
			return "../main/main.jsp";
		}

	// 기업 상세보기
	@RequestMapping("company/detail.do")
	public String company_detail(HttpServletRequest request) {

		try {
			String cno = request.getParameter("cno");

			ComVO vo = ComDAO.comDetailData(Integer.parseInt(cno));
			request.setAttribute("vo", vo);

			// ------------------------------------------------------------------------------
			// 기업 후기
			//////////////////////총페이지 구하는 메소드
			/*
			 * String page = request.getParameter("page"); if (page == null) page = "1";
			 * String cateno = request.getParameter("cateno"); if (cateno == null) cateno =
			 * "100"; int curpage = Integer.parseInt(page); int rowSize = 2; int start =
			 * (rowSize * curpage) - (rowSize - 1); int end = rowSize * curpage; // map에 저장
			 * Map map = new HashMap(); map.put("cateno", cateno); map.put("start", start);
			 * map.put("end", end);
			 * 
			 * //List<ComVO> list = ComDAO.comListData(map); int totalpage =
			 * ComDAO.comTotalPage(Integer.parseInt(cateno));
			 * 
			 * //request.setAttribute("list", list); request.setAttribute("curpage",
			 * curpage); request.setAttribute("totalpage", totalpage);
			 */
			/////////////////////////////
			List<WorkVO> work_list = ComDAO.workReviewListData(Integer.parseInt(cno));
			request.setAttribute("work_list", work_list);

			// 면접 후기
			List<IntVO> int_list = ComDAO.intReviewListData(Integer.parseInt(cno));
			request.setAttribute("int_list", int_list);
			// ------------------------------------------------------------------------------

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("main_jsp", "../company/detail.jsp");
		return "../main/main.jsp";
	}

	// 면접후기 새글 작성
	@RequestMapping("company/insert.do")
	public String workreview_insert(HttpServletRequest request) {
		request.setAttribute("main_jsp", "../company/insert.jsp");
		return "../main/main.jsp";
	}

	// 면접후기 새글 입력
	@RequestMapping("company/insert_ok.do")
	public String workreview_insert_ok(HttpServletRequest request) {
		System.out.println("면접후기 insert ok!!");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String rtype = request.getParameter("rtype");
		String rloc = request.getParameter("rloc");
		String rdate = request.getParameter("rdate");
		String rscore = request.getParameter("rscore");
		String rsub = request.getParameter("rsub");
		String rgood = request.getParameter("rgood");
		String rbad = request.getParameter("rbad");
		String rwish = request.getParameter("rwish");

		WorkVO vo = new WorkVO();
		vo.setRtype(rtype);
		vo.setRloc(rloc);
		vo.setRdate(rdate);
		vo.setRscore(rscore);
		vo.setRsub(rsub);
		vo.setRgood(rgood);
		vo.setRbad(rbad);
		vo.setRwish(rwish);

		ComDAO.workReviewInsert(vo);
		return "../company/insert_ok.jsp";

	}

	
	  //기업 검색하기  
	  @RequestMapping("company/find.do") public String
	  company_find(HttpServletRequest request) { 
		  try { 
			  String page=request.getParameter("page"); 
			  if(page==null) 
				  page="1";
			  //request.setCharacterEncoding("UTF-8"); 
			  String fname=request.getParameter("fname"); 
			  //String ss=request.getParameter("ss");
	 
			  int curpage=Integer.parseInt(page); 
			  int rowSize=10; 
			  int start=(rowSize*curpage)-(rowSize-1); 
			  int end=(rowSize*curpage);
	  
			  System.out.println("fname:"+fname); 
			  //System.out.println("ss:"+ss);
	  
	  
			  Map map=new HashMap(); 
			  map.put("start",start); 
			  map.put("end",end);
			  map.put("fname",fname); 
			  //map.put("ss",ss);
			  
			  int totalpage=ComDAO.comFindTotalPage(map);
			  
			  
			  List<ComVO> fList=ComDAO.comFindData(map);
	  
			  request.setAttribute("fList", fList); 
			  request.setAttribute("curpage",curpage);
			  request.setAttribute("totalpage",totalpage);
			  
			  request.setAttribute("main_jsp", "../company/find.jsp");
			  System.out.println("검색");
			  
			  }catch(Exception ex) { 
				  ex.getMessage(); }
		  return "../main/main.jsp"; 
	  }
			 

}