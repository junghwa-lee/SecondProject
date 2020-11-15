package model;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;

import dao.ResumeDAO;
import dao.UserDAO;
import vo.ResumeVO;
import vo.UserformVO;


public class ResumeModel {

	@RequestMapping("mypage/mymain.do")
	 public String my_main(HttpServletRequest request)
	 {
		 HttpSession session=request.getSession(); 
		 String id=(String)session.getAttribute("id");
		 List<ResumeVO> list=ResumeDAO.resumeListData(id);
		 request.setAttribute("list", list);
		 request.setAttribute("mypage_jsp", "../resume/list.jsp");
		  return "../mypage/mymain.jsp";
	 }
	
	 @RequestMapping("resume/list.do")
	 public String resume_list(HttpServletRequest request)
	 { 
		 HttpSession session=request.getSession(); 
		 String id=(String)session.getAttribute("id");
		 List<ResumeVO> list=ResumeDAO.resumeListData(id);
		 request.setAttribute("list", list);
		 request.setAttribute("mypage_jsp", "../resume/list.jsp");
	     return "../mypage/mymain.jsp";
	 }
	 
	 @RequestMapping("resume/resume.do")
	 public String resume_resume(HttpServletRequest request)
	 {
		  request.setAttribute("mypage_jsp", "../resume/resume.jsp");
		  return "../mypage/mymain.jsp";
	 }
	 
	 
	 @RequestMapping("resume/resume_ok.do")
	 public String resume_resume_ok(HttpServletRequest request)
	 {
		 try {
			 request.setCharacterEncoding("UTF-8");
		 }catch (Exception ex) {}
		 String subject=request.getParameter("subject");
		 String stype=request.getParameter("stype");
		 String sname=request.getParameter("sname");
		 String smajor=request.getParameter("smajor");
		 String sdate1=request.getParameter("sdate1");
		 String sdate2=request.getParameter("sdate2");
		 String state=request.getParameter("state");
		 String btype=request.getParameter("btype");
		 String bname=request.getParameter("bname");
		 String bgrade=request.getParameter("bgrade");
		 String bdate=request.getParameter("bdate");
		 String cname=request.getParameter("cname");
		 String cdate=request.getParameter("cdate");
		 String cl=request.getParameter("cl");
			
		 HttpSession session=request.getSession(); 
		 String id=(String)session.getAttribute("id");
			
		 ResumeVO vo=new ResumeVO();
		 vo.setId(id);
		 vo.setSubject(subject);
		 vo.setStype(stype);
		 vo.setSname(sname);
		 vo.setSmajor(smajor);
		 vo.setSdate1(sdate1);
		 vo.setSdate2(sdate2);
		 vo.setState(state);
		 vo.setBtype(btype);
		 vo.setBname(bname);
		 vo.setBgrade(bgrade);
		 vo.setBdate(bdate);
		 vo.setCname(cname);
		 vo.setCdate(cdate);
		 vo.setCl(cl);
		 
		 ResumeDAO.resumeInsert(vo);
		 
		 return "../resume/resume_ok.jsp";
	 }
	 
	 @RequestMapping("resume/resumeUpdate.do")
	 public String resume_update(HttpServletRequest request)
	 {
		 String no=request.getParameter("no");
		 ResumeVO vo=ResumeDAO.resumeUpdateData(Integer.parseInt(no));
		 request.setAttribute("vo", vo);
		 request.setAttribute("mypage_jsp", "../resume/resumeUpdate.jsp");
		 return "../mypage/mymain.jsp";
	 }
	
	 @RequestMapping("resume/resumeUpdate_ok.do")
	 public String resume_update_ok(HttpServletRequest request)
	 {
		 try {
			 request.setCharacterEncoding("UTF-8");
			 
		 String no=request.getParameter("no");
		 String subject=request.getParameter("subject");
		 String stype=request.getParameter("stype");
		 String sname=request.getParameter("sname");
		 String smajor=request.getParameter("smajor");
		 String sdate1=request.getParameter("sdate1");
		 String sdate2=request.getParameter("sdate2");
		 String state=request.getParameter("state");
		 String btype=request.getParameter("btype");
		 String bname=request.getParameter("bname");
		 String bgrade=request.getParameter("bgrade");
		 String bdate=request.getParameter("bdate");
		 String cname=request.getParameter("cname");
		 String cdate=request.getParameter("cdate");
		 String cl=request.getParameter("cl");
			
		 HttpSession session=request.getSession(); 
		 String id=(String)session.getAttribute("id");
			
		 ResumeVO vo=new ResumeVO();
		 vo.setId(id);
		 vo.setNo(Integer.parseInt(no));
		 vo.setSubject(subject);
		 vo.setStype(stype);
		 vo.setSname(sname);
		 vo.setSmajor(smajor);
		 vo.setSdate1(sdate1);
		 vo.setSdate2(sdate2);
		 vo.setState(state);
		 vo.setBtype(btype);
		 vo.setBname(bname);
		 vo.setBgrade(bgrade);
		 vo.setBdate(bdate);
		 vo.setCname(cname);
		 vo.setCdate(cdate);
		 vo.setCl(cl);
		 
		 ResumeDAO.resumeUpdate(vo);
		 
		 }catch (Exception ex) {
			 System.out.println(ex.getMessage());
		 }
		 
		 return "../resume/resumeUpdate_ok.jsp";
	 }
	 
	 
	 @RequestMapping("resume/delete.do")
	   public String resume_delete(HttpServletRequest request)
	   {
		   String no=request.getParameter("no");
		   ResumeDAO.resumeDelete(Integer.parseInt(no));
		   return "../resume/delete.jsp";
	   }
	

	
	 @RequestMapping("resume/print.do")
	 public String resume_print(HttpServletRequest request)
	 {
		 String no=request.getParameter("no");
		 ResumeVO vo=ResumeDAO.resumePrint(Integer.parseInt(no));
		 request.setAttribute("vo", vo);
		 
		 HttpSession session=request.getSession();
	     String id=(String)session.getAttribute("id");
	     UserformVO uvo=UserDAO.userUpdateData(id);
	     request.setAttribute("uvo",uvo);
		 
		 
		 return "../resume/print.jsp";
	 }
}
