package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.CreateSqlSessionFactory;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import vo.JobKnowledgeScrapVO;
import vo.JobKnowledgeVO;
import vo.JobKnowledge_CommentVO;

public class JobKnowledgeDAO {
	
	private static SqlSessionFactory ssf;
	
	static
	  {
		 ssf=CreateSqlSessionFactory.getSsf();
	  }
	
	// 게시글 리스트 출력하는 메소드 ===============================================================================================
	public static List<JobKnowledgeVO> jobknowledgeListData(Map map) {
		SqlSession session = ssf.openSession();
		List<JobKnowledgeVO> list = new ArrayList<JobKnowledgeVO>();
		
		try {
			list = session.selectList("jobknowledgeListData", map);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	
	// 게시글 전체태그 총 페이지 구하는 메소드 ==============================================================================================
	public static int jobknowledgeTatalPage() {
		SqlSession session = ssf.openSession();
		int total = 0;
		try {
			total = session.selectOne("jobknowledgeTatalPage");
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return total;
	}
	
	
	// 태그별 게시글 리스트 출력하는 메소드 ===============================================================================================
	public static List<JobKnowledgeVO> jobknowledgeListDataByTag(Map map) {
		SqlSession session = ssf.openSession();
		List<JobKnowledgeVO> list = new ArrayList<JobKnowledgeVO>();
		
		try {
			list = session.selectList("jobknowledgeListDataByTag", map);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	// 태그별 게시글 총 페이지 구하는 메소드 ==============================================================================================
	public static int jobknowledgeTatalPageByTag(String tag) {
		SqlSession session = ssf.openSession();
		int total = 0;
		try {
			total = session.selectOne("jobknowledgeTatalPageByTag", tag);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return total;
	}
	
	
	
	
	// 게시글 상세보기 ================================================================================================================
	public static JobKnowledgeVO jobknowledgeDetail(int no) {
		JobKnowledgeVO vo = new JobKnowledgeVO();
		SqlSession session = ssf.openSession();
		
		try {
			session.update("jobknowledgeIncrementHit", no);
			session.commit();
			vo = session.selectOne("jobknowledgeDetail", no);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	// 상세보기에 해당하는 답변글 가져오기 ====================================================================================================
	public static List<JobKnowledgeVO> jobknowledgeDetailReply(int no) {
		List<JobKnowledgeVO> list = new ArrayList<JobKnowledgeVO>();
		SqlSession session = ssf.openSession();
		
		try {
			list = session.selectList("jobknowledgeDetailReply", no);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	// 질문하기 =======================================================================================================================
	public static void jobknowledgeInsertAnswer(JobKnowledgeVO vo) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.insert("jobknowledgeInsertAnswer", vo);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// 답변달기 ========================================================================================================================
	public static void jobknowledgeReply(Map map) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.insert("jobknowledgeReply", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 답변달면 원 질문글 답변수 증가 ==========================================================================================================
	public static void jobknowledgeUpdateReply(int no) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.update("jobknowledgeUpdateReply", no);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 답변달면 group_step 증가 ==========================================================================================================
	public static void jobknowledgeUpdateGroupStep(Map map) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.update("jobknowledgeUpdateGroupStep", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 답변달면 질문글의 noti 증가 ===========================================================================================================
	public static void incrementNoti(int board_no) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.update("incrementNoti", board_no);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	// 게시글 수정 전 내용 가져오기 =============================================================================================================
	public static JobKnowledgeVO jobknowledgeModifyBoard(int no) {
		JobKnowledgeVO vo = new JobKnowledgeVO();
		SqlSession session = ssf.openSession();
		
		try {
			vo = session.selectOne("jobknowledgeDetail", no);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	// 게시글 수정하기 =======================================================================================================================
	public static void jobknowledgeModifyBoard_ok(Map map) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.update("jobknowledgeModifyBoard_ok", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// 답변 수정 전 내용 가져오기 =============================================================================================================
		public static JobKnowledgeVO getReply(int no) {
			JobKnowledgeVO vo = new JobKnowledgeVO();
			SqlSession session = ssf.openSession();
			
			try {
				vo = session.selectOne("getReply", no);
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return vo;
		}
	// 답변 수정하기 =======================================================================================================================
	public static void ModifyReply(Map map) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.update("ModifyReply", map);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// 게시글과 답변과 댓글 삭제하기 ================================================================================================================
	public static void jobknowledgeDeleteAll(int no) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.delete("jobknowledgeDeleteBoard", no);		// 게시글 삭제
			session.delete("jobknowledgeDeleteReply", no);		// 답변 삭제
			session.delete("deleteCommentWithBoard", no);		// 댓글 삭제
			session.delete("deleteBoardFromScrap", no);			// 스크랩 목록에서 삭제
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 답변과 댓글 삭제하기 =====================================================================================================================
	public static void deleteReplyAlone(int rno, int bno) {
		SqlSession session = ssf.openSession(true);
		
		try {
			
			session.update("declineBoardHit", bno);			// 질문글의 답변수 감소
			session.delete("deleteReplyAlone", rno);		// 답변 삭제
			session.delete("deleteCommentWithReply", rno);	// 답변에 딸린 댓글 삭제
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 답변과 댓글 삭제하기 전에 비밀번호 확인	 ==========================================================================================================
	public static String getReplyPwd(String id) {
		SqlSession session = ssf.openSession(true);
		String db_pwd = "";
		
		try {
			
			db_pwd = session.selectOne("getReplyPwd", id);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return db_pwd;
	}
	
	
	
	// 댓글만 삭제하기 ======================================================================================================================
	public static void deleteCommentAlone(int no) {
		SqlSession session =ssf.openSession(true);
		
		try {
			session.delete("deleteCommentAlone", no); 		// 댓글 삭제하기
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// 질문글 검색 =================================================================================================searchBoard
	public static List<JobKnowledgeVO> searchBoard(Map map) {
		SqlSession session = ssf.openSession();
		List<JobKnowledgeVO> list = new ArrayList<JobKnowledgeVO>();
		
		try {
			list = session.selectList("searchBoard", map);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	// 검색시에 페이지 구하는 메소드 ==============================================================================================
	public static int searchTotalPage(Map map) {
		SqlSession session = ssf.openSession();
		int total = 0;
		try {
			total = session.selectOne("searchTotalPage", map);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return total;
	}
	
	
	
	
	
	// 스크랩 ================================================================================================================
	
	// 스크랩하기 =========================================================================================================
	public static void scrapInsert(JobKnowledgeScrapVO vo)
	{
	 SqlSession session=ssf.openSession(true);
	 session.update("scrapInsert", vo);
	 session.close();
	}

	// 스크랩목록 가져오기 =========================================================================================================
	public static List<JobKnowledgeScrapVO> scrapListData(String id)
	{
	 SqlSession session=ssf.openSession();
	 List<JobKnowledgeScrapVO> list=session.selectList("scrapListData",id);
	 session.close();
	 return list;
	}

	// 스크랩 여부 확인 =========================================================================================================
	public static int scrapCount(JobKnowledgeScrapVO vo)
	{
	 SqlSession session=ssf.openSession();
	 int count=session.selectOne("scrapCount",vo);
	 session.close();
	 return count;
	}

	// 스크랩 취소 =========================================================================================================
	public static void scrapDelete(int no)
	{
	 SqlSession session=ssf.openSession(true);
	 session.delete("scrapDelete", no);
	 session.close();
	}
	
	
	
	
	
	
	
	// 댓글 달기 ===========================================================================================================
	public static void commentInsert(JobKnowledge_CommentVO vo, int reply_no){
	   SqlSession session=ssf.openSession(true);// commit(X)
	   // commit() ==> DML
	   session.insert("commentInsert",vo);
	   session.update("incrementReplyReply", reply_no);
	   session.close();
   }
	
	/*
	 * <select id="commentListData" resultType="JobKnowledge_CommentVO" parameterType="hashmap">
	    SELECT no, reply_no, id, content, TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,
	    comment_tab FROM jobknowledge_comment 
	    WHERE reply_no=#{reply_no} AND board_no = #{board_no}
	    ORDER BY comment_id DESC , comment_step ASC
	  </select>
	 * */
	// 댓글목록 가져오기 ======================================================================================================
	public static List<JobKnowledge_CommentVO> commentListData(Map map){
	   SqlSession session=ssf.openSession();
	   List<JobKnowledge_CommentVO> list=session.selectList("commentListData",map);
	   session.close();
	   return list;
   }
	
	// 대댓글 달기 ========================================================================================================
	public static void commentCommentInsert(int root,JobKnowledge_CommentVO vo){		// root(부모댓글번호), 입력한 대댓글vo 필요
		   SqlSession session=ssf.openSession();
		   JobKnowledge_CommentVO pvo=session.selectOne("commentParentData",root);		// 부모댓글번호를 통해 부모댓글의 comment_id,comment_step,comment_tab 가져오기
		   session.update("commentStepIncrement", pvo);									// 가져온 부모댓글의  comment_id,comment_step,comment_tab를 통해 부모댓글 내의 다른 댓글들 순서를 1씩 증가
		   vo.setComment_id(pvo.getComment_id());										// 입력한 대댓글의 comment_id는 부모댓글과 동일
		   vo.setComment_step(pvo.getComment_step()+1);									// 입력한 대댓글의 순서는 부모댓글순서 + 1
		   vo.setComment_tab(pvo.getComment_tab()+1);									// 입력한 대댓글의 들여쓰기도 부모댓글 + 1
		   vo.setRoot(root);															// 입력한 대댓글의 부모댓글번호는 동일
		   
		   session.insert("commentCommentInsert", vo);									// 입력한 대댓글 vo를 삽입
		   session.update("commentDepthIncrement", root);								// 부모댓글의 depth 증가
		   session.commit();
		   session.close();
	   }
	
	
	
	
	
	// 채택하기 ==========================================================================================================
	public static void adopt(Map map, int reply_no) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.update("sendAdoptPoint", map);
			session.update("declineAnswerPoint", map);
			session.update("yesAdopt", reply_no);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 상세보기할 때 채택된 답변글 수 가져오기 ===========================================================================================
	public static int getAdoptCount(int no) {
		SqlSession session = ssf.openSession(true);
		int count = 0;
		try {
			count = session.selectOne("getAdoptCount", no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
	// 유저 포인트 표시 (사이드바에) ===========================================================================================
	public static int indicatePoint(String id) {
		SqlSession session = ssf.openSession();
		int user_point = 0;
		try {
			user_point = session.selectOne("indicatePoint", id);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user_point;
	}
	// 최근 답변달린 질문 표시(사이드바에) =======================================================================================
	public static List<JobKnowledgeVO> indicateNotiBoard(String id) {
		SqlSession session = ssf.openSession();
		List<JobKnowledgeVO> list = new ArrayList<JobKnowledgeVO>();
		try {
			list = session.selectList("indicateNotiBoard", id);
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	
	
	// 사이드바에서 알람 클릭시 noti 감소
	public static void declineNoti(int no) {
		SqlSession session = ssf.openSession(true);
		
		try {
			session.update("declineNoti", no);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	// 테스트 ===============================================================================================
		public static List<JobKnowledgeVO> test(String tag) {
			SqlSession session = ssf.openSession();
			List<JobKnowledgeVO> list = new ArrayList<JobKnowledgeVO>();
			
			try {
				list = session.selectList("jobknowledgeListData", tag);
				session.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return list;
		}
}
