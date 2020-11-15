package model;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.LetterDAO;
import vo.*;
import dao.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import javax.servlet.http.HttpSession;


public class LetterModel {
	@RequestMapping("selfletter/letter.do")
	//합격자소서 리스트 출력
	public String letter(HttpServletRequest request) {
		String page=request.getParameter("page");
		if(page==null) 
			page="1";
		
		Map map=new HashMap();
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<SelfVO> list=LetterDAO.letterListData(map);
		int totalpage=LetterDAO.letterTotalPage();
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		request.setAttribute("main_jsp", "../selfletter/letter.jsp");
		return "../main/main.jsp";
	}
	
	//자소서 리스트 상세보기
	@RequestMapping("selfletter/detail.do")
	public String letter_detail(HttpServletRequest request) {
		try {
			String sno=request.getParameter("sno");
			SelfVO vo=LetterDAO.letterDetailData(Integer.parseInt(sno));		// DAO의 메소드 실행하여 VO에 담기
			request.setAttribute("vo", vo);										// VO를 request에 담아서 전송
			///
			Map map=new HashMap();
			int start=1;
			int end=3;
			map.put("start", start);
			map.put("end", end);
			
			List<SelfVO> pList=LetterDAO.popular(map);
			request.setAttribute("pList", pList);
			///
			request.setAttribute("main_jsp", "../selfletter/detail.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "../main/main.jsp";
	}
	//자소서 새글 작성
	@RequestMapping("selfletter/insert.do")
	public String letter_insert(HttpServletRequest request) {
		request.setAttribute("main_jsp", "../selfletter/insert.jsp");
		return "../main/main.jsp";
	}
	//자소서 새글 입력
	@RequestMapping("selfletter/insert_ok.do")
	public String letterInsert_ok(HttpServletRequest request) {
		System.out.println("insert_ok!!");
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			String ssubject=request.getParameter("ssubject");
			String sname=request.getParameter("sname");
			String sindutype=request.getParameter("sindutype");
			String sq1=request.getParameter("sq1");
			String sa1=request.getParameter("sa1");
			String sq2=request.getParameter("sq2");
			String sa2=request.getParameter("sa2");
			String sq3=request.getParameter("sq3");
			String sa3=request.getParameter("sa3");
			
			SelfVO vo=new SelfVO();
			vo.setSsubject(ssubject);
			vo.setSname(sname);
			vo.setSindutype(sindutype);
			vo.setSq1(sq1);
			vo.setSa1(sa1);
			vo.setSq2(sq2);
			vo.setSa2(sa2);
			vo.setSq3(sq3);
			vo.setSa3(sa3);
			
			LetterDAO.letterInsert(vo);
			return "../selfletter/insert_ok.jsp";
	}
	//자소서 수정
	//수정 전 내용 가져오기
	/*
	 * @RequestMapping("selfletter/update.do") public String
	 * letter_update(HttpServletRequest request) { try { String
	 * sno=request.getParameter("sno"); SelfVO
	 * vo=LetterDAO.letterupdate(Integer.parseInt(sno)); request.setAttribute("vo",
	 * vo); request.setAttribute("main_jsp", "../selfletter/update.jsp");
	 * }catch(Exception ex) { ex.printStackTrace(); } return "../main/main.jsp"; }
	 */
	
	
	
	
	
	
	
	
	
	
	
}
