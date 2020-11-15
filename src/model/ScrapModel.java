package model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;

import dao.NewsDAO;
import vo.*;

public class ScrapModel {
	@RequestMapping("mypage/scrap.do")
	 public String my_main(HttpServletRequest request)
	 {
		  request.setAttribute("mypage_jsp", "../mypage/scrap.jsp");
		  return "../mypage/mymain.jsp";
	 }
	 
	 // 뉴스 스크랩 출력
	 @RequestMapping("mypage/newsscrap.do")
	 public String news_scrap_mypage(HttpServletRequest request){
		 HttpSession session=request.getSession();
		 String id=(String)session.getAttribute("id");
		  
	 	 List<NewsScrapVO> sList=NewsDAO.newsScrapListData(id);
		 List<NewsVO> nList=new ArrayList<NewsVO>();
		 for(NewsScrapVO vo:sList) {
			NewsVO nvo=NewsDAO.newsDetailData(vo.getNno());
			nvo.setN_sno(vo.getNo());
			nList.add(nvo);
		 }
		 request.setAttribute("nList", nList);
		 request.setAttribute("mypage_jsp", "../mypage/newsscrap.jsp");
		 return "../mypage/mymain.jsp";
	 }
	 
	// 팁 스크랩 출력
	@RequestMapping("mypage/tipscrap.do")
	public String tip_scrap_mypage(HttpServletRequest request){
		 HttpSession session=request.getSession();
		 String id=(String)session.getAttribute("id");
				  
		 List<TipScrapVO> sList=NewsDAO.tipScrapListData(id);
		 List<TipVO> tList=new ArrayList<TipVO>();
		 for(TipScrapVO vo:sList) {
			TipVO tvo=NewsDAO.tipDetailData(vo.getTno());
			tvo.setT_sno(vo.getNo());
			tList.add(tvo);
		 }
		 request.setAttribute("tList", tList);
		 request.setAttribute("mypage_jsp", "../mypage/tipscrap.jsp");
		 return "../mypage/mymain.jsp";
	}
	
	// 비디오 스크랩 출력
	@RequestMapping("mypage/videoscrap.do")
	public String video_scrap_mypage(HttpServletRequest request){
		 HttpSession session=request.getSession();
		 String id=(String)session.getAttribute("id");
			  
	 	 List<VideoScrapVO> sList=NewsDAO.videoScrapListData(id);
		 List<VideoVO> vList=new ArrayList<VideoVO>();
		 for(VideoScrapVO vo:sList) {
			VideoVO vvo=NewsDAO.videoDetailData(vo.getVno());
			vvo.setV_sno(vo.getNo());
			vList.add(vvo);
		 }
		 request.setAttribute("vList", vList);
		 request.setAttribute("mypage_jsp", "../mypage/videoscrap.jsp");
		 return "../mypage/mymain.jsp";
	}
	 
	
}
