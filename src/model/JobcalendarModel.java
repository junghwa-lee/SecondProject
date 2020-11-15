package model;

import java.util.*;
import vo.JjimVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.sist.controller.RequestMapping;
import dao.WorkbDAO;
import vo.WorkBVO;
import java.text.SimpleDateFormat;

public class JobcalendarModel {
   @RequestMapping("jobcalendar/jobcalendar.do")
   public String jobcalendar_main(HttpServletRequest request) {
      try {
      String page=request.getParameter("page");
      String lcateno = request.getParameter("lcateno");   
      if(page==null) 
         page="1";
      
      Map map=new HashMap();
      int curpage=Integer.parseInt(page);
      int rowSize=10;
      int start=(rowSize*curpage)-(rowSize-1);
      int end=rowSize*curpage;
      map.put("start", start);
      map.put("end", end);
      map.put("lcateno", lcateno);
      List<WorkBVO> list=WorkbDAO.workbListData(map);

      int totalpage=WorkbDAO.workbTotalPage();

      request.setAttribute("currpage", curpage);
      request.setAttribute("totalpage", totalpage);
      request.setAttribute("list", list);
      request.setAttribute("lcateno", lcateno);
      request.setAttribute("main_jsp", "../jobcalendar/jobcalendar.jsp");
      }catch(Exception ex) {
         ex.printStackTrace();
      }
      return "../main/main.jsp";
   }

   @RequestMapping("jobcalendar/date.do")
   public String jobcalendar_list(HttpServletRequest request) {
      String strYear  = request.getParameter("year");
      String strMonth = request.getParameter("month");
      String tno = request.getParameter("l_no");
      if (tno == null)
         tno = "1";

      Date date = null;
      try {
         date = new Date();
      } catch (Exception e) {
         e.printStackTrace();
      }

      // 2020-10
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
      
      // MM dd (X) M d 01 ~ 09 10 11 12 09
      // 1 2 3 .... 10 11 12
      String today = sdf.format(date);
      StringTokenizer st = new StringTokenizer(today, "-");

      if (strYear == null) {
         strYear = st.nextToken();// yyyy
      }

      if (strMonth == null) {
         strMonth = st.nextToken();
      }

      int day = Integer.parseInt(st.nextToken());// 화면
      int year = Integer.parseInt(strYear);
      int month = Integer.parseInt(strMonth);
      

      Calendar cal = Calendar.getInstance();// Calendar클래스 생성
      cal.set(Calendar.YEAR, year);
      cal.set(Calendar.MONTH, month - 1);// month=>0~11
      cal.set(Calendar.DATE, 1);

      // 요일을 구한다
      int week = cal.get(Calendar.DAY_OF_WEEK);// 1~7 ==> week-1
      int lastday = cal.getActualMaximum(Calendar.DATE);
      String[] strWeek = { "일", "월", "화", "수", "목", "금", "토" };
      System.out.println("요일:" + strWeek[week - 1]);
      System.out.println("마지막날:" + lastday);
      String ldeadline = request.getParameter("ldeadline");
      int[] rdays=new int[31];
      
      List<WorkBVO> list = WorkbDAO.jobcalendar_list();
      
      try {
         for(WorkBVO vo: list) {
            String deadline = vo.getLdeadline();
            String s = deadline.substring(deadline.indexOf('~') + 1,deadline.indexOf('('));
            int a = s.indexOf("/");
            
            //11/26
            if(a >= 0)
            {   
               st = new StringTokenizer(s.trim(),"/");
               int m = Integer.parseInt(st.nextToken());
               int d = Integer.parseInt(st.nextToken());
               
               if(month == m) {
                  rdays[d-1] = d;   
               }
            }
         }
      }catch (Exception ex) {
         ex.printStackTrace();
      }
      
      for(int k:rdays) {
         System.out.println(k);
      }
      // jsp로 전송 
        request.setAttribute("rdays", rdays);
         request.setAttribute("year", year);
         request.setAttribute("month", month);
         request.setAttribute("day", day);
         request.setAttribute("week", week-1);
         request.setAttribute("strWeek", strWeek);
         request.setAttribute("lastday", lastday);
         
       return "../jobcalendar/date.jsp";
   }

   // jobcalendar => list 데이터자르기
   @RequestMapping("jobcalendar/jobcalendar2.do")
   public String jobcalendar_list2(HttpServletRequest request) {
      String rday = request.getParameter("rday");
      System.out.println("rday출력");
      System.out.println(rday);
      String month = request.getParameter("month");
      
         // MM dd (X)  M d 01 ~ 09 10 11 12   09
         // 1 2 3 .... 10 11 12
      Map map = new HashMap();
      map.put("ss", rday);
      List<WorkBVO> list = WorkbDAO.jobcalendar2_listdata(map);
      System.out.println("list사이즈"+list.size());
      request.setAttribute("list", list);
//      request.setAttribute("jobcalendar2_jsp", "../jobcalendar/jobcalendar2.jsp");
   
      return "../jobcalendar/jobcalendar2.jsp";
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