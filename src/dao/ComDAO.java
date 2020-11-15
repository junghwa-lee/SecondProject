package dao;
import java.io.Reader;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.CreateSqlSessionFactory;

import vo.*;
public class ComDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	//기업 리스트
	//<select id="comListData" resultType="ComVO" parameterType="hashmap">
	public static List<ComVO> comListData(Map map){
		SqlSession session=ssf.openSession();
		List<ComVO> list=session.selectList("comListData",map);
		session.close();
		return list;
	}
	//기업 총페이지
	//<select id="comTotalPage" resultType="int">
	public static int comTotalPage(int cateno){
		SqlSession session=ssf.openSession();
		int total=session.selectOne("comTotalPage",cateno);
		session.close();
		return total;
	}
	//기업 상세보기
	//<select id="comDetailData" resultType="ComVO" parameterType="int">
	public static ComVO comDetailData(int cno) {
		SqlSession session=ssf.openSession();
		ComVO vo=new ComVO();
		try {
			vo=session.selectOne("comDetailData",cno);
			session.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
		return vo;
	}

	//기업 후기보기
	//<select id="workReviewListData" resultType="WorkVO" parameterType="hashmap">
	public static List<WorkVO> workReviewListData(int cno){
		SqlSession session=ssf.openSession();
		List<WorkVO> list=new ArrayList<WorkVO>();
		try {
			list=session.selectList("workReviewListData",cno);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//기업후기 총페이지
	//<select id="workReviewTotalPage" resultType="int"	parameterType="int">
	public static int workReviewTotalPage(int cno) {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("workReviewTotalPage",cno);
		session.close();
		return total;
	}
	
	
	
	//면접 후기보기
	//<select id="intReviewListData" resultType="IntVO" parameterType="hashmap">
	public static List<IntVO> intReviewListData(int cno){
		SqlSession session=ssf.openSession();
		List<IntVO> list=session.selectList("intReviewListData",cno);
		session.close();
		return list;
	}
	
	//기업후기작성
	//<insert id="workReviewInsert" parameterType="WorkVO">
	public static void workReviewInsert(WorkVO vo) {
		try {
			SqlSession session=ssf.openSession(true);
			session.insert("workReviewInsert",vo);
			session.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//면접후기작성
	//<insert id="intReviewInsert" parameterType="IntVO">
	public static void intReviewInsert(IntVO vo) {
		try {
			SqlSession session=ssf.openSession(true);
			session.insert("intReviewInsert",vo);
			session.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	//기업 검색===============================================================
	//<select id="comFindData" resultType="ComVO" parameterType="hashmap">
	public static List<ComVO> comFindData(Map map){
		SqlSession session=ssf.openSession();
		List<ComVO> list=new ArrayList<ComVO>();
		try{
			list=session.selectList("comFindData",map);
			session.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
	//검색된 글 페이징
	//<select id="comFindTotalPage" resultType="int" parameterType="hashmap">
	public static int comFindTotalPage(Map map) {
		SqlSession session=ssf.openSession();
		int total=0;
		try {
			total=session.selectOne("comFindTotalPage",map);
			session.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
		return total;
	}
	
	
}
