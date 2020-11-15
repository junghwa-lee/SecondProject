package dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.controller.RequestMapping;
/*import com.sist.dao.MovieDAO;
import com.sist.vo.JjimVO;*/

import vo.JjimVO;
import vo.WorkBVO;

public class WorkbDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();
	}

	// 채용공고 리스트
	// <select id="workbListData" resultType="WorkBVO" parameterType="hashmap">
	public static List<WorkBVO> workbListData(Map map) {
		
		SqlSession session = null;
		List<WorkBVO> list = new ArrayList<WorkBVO>();
		try{
			session = ssf.openSession();
			list = session.selectList("workbListData", map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}

	// 채용공고 총페이지
	// <select id="workbTotalPage" resultType="int">
	public static int workbTotalPage() {
		SqlSession session = ssf.openSession();
		int total = session.selectOne("workbTotalPage");
		session.close();
		return total;
	}

	// <select>별 채용공고 리스트 출력
	public static List<WorkBVO> workbListDataBySelect(Map map) {
		SqlSession session = ssf.openSession();
		List<WorkBVO> list = new ArrayList<WorkBVO>();

		try {
			list = session.selectList("workbListDataBySelect", map);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	// 태그별 채용공고 총 페이지
	public static int workbTotalPageBySelect(String lcateno) {
		SqlSession session = ssf.openSession();
		int total = 0;
		try {
			total = session.selectOne("workbTotalPageBySelect", lcateno);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return total;
	}

	// 채용공고 상세보기
	// <select id="workbDetailData" resultType="WorkBVO" parameterType="int">
	public static WorkBVO workbDetailData(int l_no) {
		SqlSession session = ssf.openSession();
		WorkBVO vo = new WorkBVO();
		try {
			vo = session.selectOne("workbDetailData", l_no);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// jobcalendar => list
	public static List<WorkBVO> jobcalendar_list() {
		SqlSession session = ssf.openSession();
		List<WorkBVO> list = new ArrayList<WorkBVO>();
		try {
			list = session.selectList("jobcalendar_list");
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	/*
	 * <select id="jobcalendar2_listdata" resultType="vo.WorkBVO"
	 * parameterType="hashmap"> SELECT * FROM saramin_emp WHERE ldeadline LIKE
	 * '%'||#{ss}||'%' </select>
	 */
	public static List<WorkBVO> jobcalendar2_listdata(Map map) {
		SqlSession session = ssf.openSession();
		List<WorkBVO> list = new ArrayList<WorkBVO>();
		try {
			list = session.selectList("jobcalendar2_listdata", map);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	// 채용 달력 rday
	public static String jobcalendarDayData() {
		SqlSession session = ssf.openSession();
		String ldeadline = session.selectOne("jobcalendarDayData");
		session.close();
		return ldeadline;
	}

	// 채용달력 좋아요
	public static void likeIncrement(int no) {
		SqlSession session = ssf.openSession(true);
		session.update("likeIncrement", no);
		session.close();
	}

	// 채용달력 찜
	public static void jjimInsert(JjimVO vo) {
		SqlSession session = ssf.openSession(true);
		session.update("jjimInsert", vo);
		session.close();
	}

	// 채용 달력 찜 목록
	public static List<JjimVO> jjimListData(String id) {
		SqlSession session = ssf.openSession();
		List<JjimVO> list = session.selectList("jjimListData", id);
		session.close();
		return list;
	}

	// 찜 여부 확인
	public static int jjimCount(JjimVO vo) {
		SqlSession session = ssf.openSession();
		int count = session.selectOne("jjimCount", vo);
		session.close();
		return count;
	}

	// 찜 취소 시 에러처리
	public static void jjimDelete(int no) {
		SqlSession session = ssf.openSession(true);
		session.delete("jjimDelete", no);
		session.close();
	}
}