package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;

import dao.GongmoDAO;
import vo.GongmoScrapVO;
import vo.GongmoVO;

public class ScarpModel {
	@RequestMapping("mypage/scrap.do")
	 public String my_main(HttpServletRequest request)
	 {
		
		  request.setAttribute("mypage_jsp", "../mypage/scrap.jsp");
		  return "../mypage/mymain.jsp";
	 }
	
	 // 마이페이지 스크랩 출력
	 @RequestMapping("mypage/gongmoscrap.do")
	 public String gongmo_scrap_mypage(HttpServletRequest request){
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
		 request.setAttribute("mypage_jsp", "../mypage/gongmoscrap.jsp");
		 return "../mypage/mymain.jsp";
	 }
	
}
