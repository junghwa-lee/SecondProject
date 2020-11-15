package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import dao.UserDAO;
import vo.UserformVO;

import java.util.*;

public class UserModel {
	 @RequestMapping("user/join.do")
	   public String user_join(HttpServletRequest request)
	   {
		   request.setAttribute("main_jsp", "../user/join.jsp");//include(메인에 들어갈 파일 지정)
		   return "../main/main.jsp";//include
	   }
	 
	 @RequestMapping("user/idcheck.do")
	   public String user_idcheck(HttpServletRequest request)
	   {
		   return "../user/idcheck.jsp";// 새로운 창을 연다 ==> Ajax 
	   }
	   @RequestMapping("user/idcheck_ok.do")
	   public String user_idcheck_ok(HttpServletRequest request)
	   {
		    String id=request.getParameter("id");
		    // DB연동
		    int count=UserDAO.userIdCheck(id);
		    request.setAttribute("count", count);
		    return "../user/idcheck_ok.jsp";
	   }
	   @RequestMapping("user/join_ok.do")
	   public String user_join_ok(HttpServletRequest request)
	   {
		   System.out.println("join_ok...");
		   try
		   {
			   //한글 변환 
			   request.setCharacterEncoding("UTF-8");
			 
			   String id=request.getParameter("id");
			   String pwd=request.getParameter("pwd");
			   String name=request.getParameter("name");
			   String email=request.getParameter("email");
			   String birthday=request.getParameter("birthday");
			   String sex=request.getParameter("sex");
			   String post=request.getParameter("post");
			   String addr1=request.getParameter("addr1");
			   String addr2=request.getParameter("addr2");
			   String tel=request.getParameter("tel");
			   
			   UserformVO vo=new UserformVO();
			   vo.setId(id);
			   vo.setPwd(pwd);
			   vo.setName(name);
			   vo.setEmail(email);
			   vo.setBirthday(birthday);
			   vo.setSex(sex);
			   vo.setPost(post);
			   vo.setAddr1(addr1);
			   vo.setAddr2(addr2);
			   vo.setTel(tel);

			   UserDAO.userInsert(vo);
		   }catch(Exception ex){}
		   
		   return "../user/join_ok.jsp";
	   }
	   
	   
	   
	   @RequestMapping("user/login.do")
	   public String user_login(HttpServletRequest request)
	   {
		   request.setAttribute("main_jsp", "../user/login.jsp");//include(메인에 들어갈 파일 지정)
		   return "../main/main.jsp";//include
	   }
	 
	   
	   @RequestMapping("user/login_ok.do")
	   public String user_login_ok(HttpServletRequest request)
	   {
		   String id=request.getParameter("id");
		   String pwd=request.getParameter("pwd");
		   UserformVO vo=UserDAO.userLogin(id, pwd);
		   if(vo.getMsg().equals("OK"))
		   {
			   HttpSession session=request.getSession();
			   session.setAttribute("id", vo.getId());
			   session.setAttribute("name", vo.getName());
			   session.setAttribute("admin", vo.getAdmin());
		   }
		   
		   request.setAttribute("msg", vo.getMsg());
		   return "../user/login_ok.jsp";
	   }
	   @RequestMapping("user/logout.do")
	   public String user_logout(HttpServletRequest request)
	   {
		   HttpSession session=request.getSession();
		   session.invalidate();
		   return "../user/logout.jsp";
	   }
	   
	   @RequestMapping("user/update.do")
	   public String user_update(HttpServletRequest request)
	   {	
		   //※
		   HttpSession session=request.getSession();
		   String id=(String)session.getAttribute("id");
		   UserformVO vo=UserDAO.userUpdateData(id);
		   request.setAttribute("vo",vo);
		   request.setAttribute("mypage_jsp", "../user/update.jsp");
		   return "../mypage/mymain.jsp";
	   }
	   
	   @RequestMapping("user/update_ok.do")
	   public String user_update_ok(HttpServletRequest request)
	   {
		   try
		   {
			   request.setCharacterEncoding("UTF-8");
			   String id=request.getParameter("id");
			   String pwd=request.getParameter("pwd");
			   String name=request.getParameter("name");
			   String email=request.getParameter("email");
			   String birthday=request.getParameter("birthday");
			   String sex=request.getParameter("sex");
			   String post=request.getParameter("post");
			   String addr1=request.getParameter("addr1");
			   String addr2=request.getParameter("addr2");
			   String tel=request.getParameter("tel");
		  
			   UserformVO vo=new UserformVO();
			   vo.setId(id);
			   vo.setPwd(pwd);
			   vo.setName(name);
			   vo.setEmail(email);
			   vo.setBirthday(birthday);
			   vo.setSex(sex);
			   vo.setPost(post);
			   vo.setAddr1(addr1);
			   vo.setAddr2(addr2);
			   vo.setTel(tel);
			   
			   UserDAO.userUpdate(vo);
			   
		   }catch(Exception ex){}
		   
		   return "../user/update_ok.jsp";
	   }
}
