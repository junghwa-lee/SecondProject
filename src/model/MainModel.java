package model;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import com.sist.controller.RequestMapping;

import dao.MainDAO;
import vo.*;
import java.util.*;

public class MainModel {
	
	@RequestMapping("main/main.do")
	public String main_page(HttpServletRequest request) {

		try {
			System.out.println("메인모델");
			
			
			
			
			
			request.setAttribute("main_jsp", "../main/content.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../main/main.jsp";
	
	}
	
	
	
	// 채용공고 가져오는 메소드 ==================================================================================================== 채용공고 가져오기
	@RequestMapping("main/announce.do")
	public String main_getAnnounce(HttpServletRequest request) {

		try {
			System.out.println("메인페이지 채용공고");
			
			List<WorkBVO> list = MainDAO.mainGetAnnounce();						// 채용공고 가져오기
			
			
			request.setAttribute("list", list);								// 채용공고 보내기
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../main/announce.jsp";
	
	}
	
	
	
	
	// 팁 가져오는 메소드 ==================================================================================================== 팁 가져오기
	@RequestMapping("main/tip.do")
	public String content_page(HttpServletRequest request) {

		try {
			System.out.println("메인페이지 팁");
			
			List<vo.TipVO> tlist = MainDAO.mainGetTip();						// 팁 가져오기
			
			
			request.setAttribute("tlist", tlist);								// 팁 보내기
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../main/tip.jsp";
	
	}
	
	
	
	// 지식인 가져오는 메소드 ==================================================================================================== 지식인 가져오기
	@RequestMapping("main/jobknowledge.do")
	public String main_getJobknowledge(HttpServletRequest request) {

		try {
			System.out.println("메인페이지 지식인");
			
			List<JobKnowledgeVO> jlist = MainDAO.mainGetJobknowledge();					// 지식인 가져오기
			
			
			request.setAttribute("jlist", jlist);								// 지식인 보내기
			request.setAttribute("aa", "aaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../main/jobknowledge.jsp";
	
	}
	
	
	
	// 비디오 가져오는 메소드 ==================================================================================================== 비디오 가져오기
	@RequestMapping("main/video.do")
	public String main_getVideo(HttpServletRequest request) {

		try {
			System.out.println("메인페이지 비디오");
			
			List<VideoVO> vlist = MainDAO.mainGetVideo();					// 지식인 가져오기
			
			
			request.setAttribute("vlist", vlist);								// 지식인 보내기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../main/video.jsp";
	
	}
	
	
	// 공모전 가져오는 메소드 ==================================================================================================== 공모전 가져오기
	@RequestMapping("main/gongmo.do")
	public String main_getGongmo(HttpServletRequest request) {

		try {
			System.out.println("메인페이지 공모전");
			
			List<GongmoVO> glist = MainDAO.mainGetGongmo();					// 지식인 가져오기
			
			
			request.setAttribute("glist", glist);								// 지식인 보내기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "../main/gongmo.jsp";
	
	}
	
}
