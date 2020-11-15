package dao;

// 메인페이지 출력하는 클래스 ================================================================================================================

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.*;
public class MainDAO {
	
private static SqlSessionFactory ssf;
	
	static
	  {
		 ssf=CreateSqlSessionFactory.getSsf();
	  }
	
	
	
	// 채용공고 가져오기 ============================================================================================================ 채용공고 가져오기
	public static List<WorkBVO> mainGetAnnounce(){
		SqlSession session = ssf.openSession();
		List<WorkBVO> list = new ArrayList<WorkBVO>();
		
		try {
			list = session.selectList("mainGetAnnounce");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	// 팁 가져오기 ============================================================================================================ 팁 가져오기
	public static List<vo.TipVO> mainGetTip(){
		SqlSession session = ssf.openSession();
		List<vo.TipVO> list = new ArrayList<TipVO>();
		
		try {
			list = session.selectList("mainGetTip");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	// 지식인 가져오기 ============================================================================================================ 지식인 가져오기
	public static List<JobKnowledgeVO> mainGetJobknowledge(){
		SqlSession session = ssf.openSession();
		List<JobKnowledgeVO> list = new ArrayList<JobKnowledgeVO>();
		
		try {
			list = session.selectList("mainGetJobknowledge");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	} 
	
	
	// 비디오 가져오기 ============================================================================================================ 팁 가져오기
	public static List<vo.VideoVO> mainGetVideo(){
		SqlSession session = ssf.openSession();
		List<vo.VideoVO> list = new ArrayList<vo.VideoVO>();
		
		try {
			list = session.selectList("mainGetVideo");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	// 공모전 가져오기 ====================================================================================================================
	public static List<GongmoVO> mainGetGongmo(){
		SqlSession session = ssf.openSession();
		List<GongmoVO> list = new ArrayList<GongmoVO>();
		
		try {
			list = session.selectList("mainGetGongmo");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
}
