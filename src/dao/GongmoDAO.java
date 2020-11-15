package dao;
import java.util.*;
import java.io.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import dao.CreateSqlSessionFactory;
import vo.*;

public class GongmoDAO {
	
	  private static SqlSessionFactory ssf;
	   static
	   {
		   ssf=CreateSqlSessionFactory.getSsf();
	   }
	   
	   // 공모전 리스트 데이터 출력하는 메소드 ==============================================================================================
	   public static List<GongmoVO> gongmoListData(Map map)
	   {
		   SqlSession session=ssf.openSession();
		   List<GongmoVO> list=session.selectList("gongmoListData",map);
		   session.close();// 반환
		   return list;
	   }
	   
	   // 공모전 카테고리별(gm_cate) 데이터 출력 메소드 ==============================================================================================
	   public static int gongmoTotalPage(int gm_cate)
	   {
		   SqlSession session=ssf.openSession();
		   int total = 0;
		   try {
			   
			   total=session.selectOne("gongmoTotalPage", gm_cate);
			   session.close();
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return total;
		   
	   }

	   // 카테고리넘버별(gm_cate)총 페이지 나누기 메소드 ==============================================================================================
	   public static List<GongmoVO> gongmoTotalData(Map map)
	   {
		   SqlSession session=ssf.openSession();
		   List<GongmoVO> list =  new ArrayList<GongmoVO>();
		   try {
			   list=session.selectList("gongmoTotalData",map);
			   session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return list;
	   }
	   
	   // 전체 보기 페이지 메소드 =================================================================================================================
	   public static int gongmoTotalPage2()
	   {
		   SqlSession session=ssf.openSession();
		   int total=session.selectOne("gongmoTotalPage2");
		   session.close();
		   return total;
	   }
	   
	   // 공모전 게시글 상세보기 메소드 =============================================================================================================
	   public static GongmoVO gongmoDetailData(int gm_no) 
	   {
		   SqlSession session=ssf.openSession();
		   GongmoVO vo = new GongmoVO();
		   try {
			   session.update("gongmoHitIncrement", gm_no);
			   session.commit();
			   vo=session.selectOne("gongmoDetailData", gm_no);
			   session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
		   return vo;
		} 

		
	   // 질문글 검색 =================================================================================================searchBoard
		public static List<GongmoVO> gongmoSearchBoard(Map map) {
			SqlSession session = ssf.openSession();
			List<GongmoVO> list = new ArrayList<GongmoVO>();
			
			try {
				list = session.selectList("gongmoSearchBoard", map);
				session.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return list;
		}
		// 검색시에 페이지 구하는 메소드 ==============================================================================================
		public static int gongmoSearchTotalPage(Map map) {
			SqlSession session = ssf.openSession();
			int total = 0;
			try {
				total = session.selectOne("gongmoSearchTotalPage", map);
				session.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return total;
		}
		
		
		//좋아요========================================================
		   public static void gongmoLikeIncrement(int gm_no)
		   {
			   SqlSession session=ssf.openSession(true);
			   session.update("gongmoLikeIncrement", gm_no);
			   session.close();
		   }		
		   
		// 스크랩 ================================================================================================================
			
			public static void gongmoScrapInsert(GongmoScrapVO vo)
			{
			 SqlSession session=ssf.openSession(true);
			 session.update("gongmoScrapInsert", vo);
			 session.close();
			}

			// 찜목록 가져오기 =========================================================================================================
			public static List<vo.GongmoScrapVO> gongmoScrapListData(String id)
			{
			 SqlSession session=ssf.openSession();
			 List<GongmoScrapVO> list=session.selectList("gongmoScrapListData",id);
			 session.close();
			 return list;
			}

			// 찜 여부 확인 =========================================================================================================
			public static int gongmoScrapCount(GongmoScrapVO vo)
			{
			 SqlSession session=ssf.openSession();
			 int count=session.selectOne("gongmoScrapCount",vo);
			 session.close();
			 return count;
			}

			// 찜 취소 =========================================================================================================
			public static void gongmoScrapCancel(int no)
			{
			 SqlSession session=ssf.openSession(true);
			 session.delete("gongmoScrapCancel", no);
			 session.close();
			}
		   
	}