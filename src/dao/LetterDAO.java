package dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.CreateSqlSessionFactory;

import vo.*;
public class LetterDAO {
	private static SqlSessionFactory ssf;
	static {
			ssf=CreateSqlSessionFactory.getSsf();
	}
	//자소서리스트
	//<select id="letterListData" resultType="SelfVO" parameterType="hashmap">
	public static List<SelfVO> letterListData(Map map){
		SqlSession session=ssf.openSession();
		List<SelfVO> list=session.selectList("letterListData",map);
		session.close();
		return list;
	}
	//자소서 총페이지
	//<select id="letterTotalPage" resultType="int">
	public static int letterTotalPage() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("letterTotalPage");
		session.close();
		return total;
	}
	//많이 본 자소서
	//<select id="popular" resultType="SelfVO" parameterType="hashmap">
	public static List<SelfVO> popular(Map map){
		SqlSession session=ssf.openSession();
		List<SelfVO> list=session.selectList("popular",map);
		session.close();
		return list;
	}
	
	
	
	
	//자소서 상세보기
	//<select id="letterDetailData" resultType="SelfVO" parameterType="int">
	//조회수 증가
	//<update id="letterHitIncrement" parameterType="int">
	public static SelfVO letterDetailData(int sno) {
		SqlSession session=ssf.openSession();
		session.update("letterHitIncrement",sno);
		session.commit();
		SelfVO vo=new SelfVO();
		try {
			vo=session.selectOne("letterDetailData",sno);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	//자소서 작성
	//<insert id="letterInsert" parameterType="SelfVO">
	public static void letterInsert(SelfVO vo) {
		try {
			SqlSession session=ssf.openSession(true);
			session.insert("letterInsert",vo);
			session.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	//자소서 수정
	//<select id="letterupdate" parameterType="SelfVO">
	//수정 전 데이터 읽기
	public static SelfVO letterupdate(int sno) {
		SqlSession session=ssf.openSession();
		SelfVO vo=new SelfVO();
		try{
			vo=session.selectOne("letterDetailData",sno);
			session.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
		return vo;
	}
	//수정하기
	public static void letterupdate_ok(SelfVO vo) {
		SqlSession session=ssf.openSession(true);
		try {
			session.update("letterupdate_ok",vo);
			session.close();
		}catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
