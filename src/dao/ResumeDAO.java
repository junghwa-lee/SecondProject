package dao;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.controller.RequestMapping;

import vo.ResumeVO;

public class ResumeDAO {
	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	//이력서관리 목록
	public static List<ResumeVO> resumeListData(String id)
	{
		SqlSession session=ssf.openSession();
		List<ResumeVO> list=session.selectList("resumeListData",id);
		session.close();
		return list;
	}
	
	//이력서 입력
	 public static void resumeInsert(ResumeVO vo)
	 {
		 SqlSession session=ssf.openSession(true);
		 session.insert("resumeInsert", vo);
		 session.close();
	 }
	 
	 //이력서 수정할 데이터 가져오기
	 public static ResumeVO resumeUpdateData(int no)
	 {
		 ResumeVO vo=new ResumeVO();
		 SqlSession session=ssf.openSession();
		 vo=session.selectOne("resumeUpdate_ok",no);
		 session.close();
		 return vo;
	 }
	 
	 //이력서 수정하기
	 public static void resumeUpdate(ResumeVO vo)
	 {
		 SqlSession session=ssf.openSession(true);
		 session.update("resumeUpdate", vo);
		 session.close();
	 }
	
	 
	 //이력서 삭제
	 public static void resumeDelete(int no)
	   {
		   SqlSession session=ssf.openSession();
		   session.delete("resumeDelete",no);
		   session.commit();
		   session.close();
	   }
	 
	 public static ResumeVO resumePrint(int no)
	 {
		 ResumeVO vo=new ResumeVO();
		 SqlSession session=ssf.openSession(true);
		 vo=session.selectOne("resumePrint",no);
		 return vo;
	 }
}
