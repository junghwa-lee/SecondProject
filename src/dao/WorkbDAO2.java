package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import vo.WorkBVO;

public class WorkbDAO2 {
	private static SqlSessionFactory ssf;
	static {
			ssf=CreateSqlSessionFactory.getSsf();
	}
	//채용공고 리스트
	//<select id="workbListData" resultType="WorkBVO" parameterType="hashmap">
	public static List<WorkBVO> workbListData2(Map map){
		SqlSession session=ssf.openSession();
		List<WorkBVO> list=session.selectList("workbListData2",map);
		session.close();
		return list;
	}
	
	//채용공고 총페이지
	//<select id="workbTotalPage" resultType="int">
	public static int workbTotalPage2() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("workbTotalPage2");
		session.close();
		return total;
	}
	
	// <select>별 채용공고 리스트 출력
	public static List<WorkBVO> workbListDataBySelect2(Map map) {
		SqlSession session = ssf.openSession();
		List<WorkBVO> list = new ArrayList<WorkBVO>();
		
		try {
			list = session.selectList("workbListDataBySelect2", map);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	// 태그별 채용공고 총 페이지 
	public static int workbTotalPageBySelect2(String lcateno) {
		SqlSession session = ssf.openSession();
		int total = 0;
		try {
			total = session.selectOne("workbTotalPageBySelect2", lcateno);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return total;
	}

	//채용공고 상세보기
	//<select id="workbDetailData" resultType="WorkBVO" parameterType="int">
	public static WorkBVO workbDetailData2(int l_no) {
		SqlSession session=ssf.openSession();
		WorkBVO vo= new WorkBVO();
			try {vo=session.selectOne("workbDetailData2",l_no);
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return vo;
		}
}