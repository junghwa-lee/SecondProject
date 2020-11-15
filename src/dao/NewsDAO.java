package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.*;
import vo.*;
public class NewsDAO {
   private static SqlSessionFactory ssf;
   static {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
  
   /*
    <!-- 뉴스 인기순 -->
	<select id="newHitList" resultType="vo.NewsVO" parameterType="hashmap">
	
    <!-- 뉴스 리스트 -->
	<select id="newsListData" resultType="vo.NewsVO" parameterType="hashmap">
	
	<!-- 뉴스 페이지 수 -->
	<select id="newsTotalPage" resultType="int" parameterType="int">
	
	<!-- 뉴스 상세페이지 -->
	<select id="newsDetailData" resultType="vo.NewsVO" parameterType="int">
	
	<!-- 뉴스 조회수 -->
	<update id="newsHitIncrement" parameterType="int">
    * 
    */
   public static List<NewsVO> newsHitList(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<NewsVO> list=session.selectList("newsHitList",map);
	   session.close();
	   return list;
   }
   public static List<NewsVO> newsListData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<NewsVO> list=session.selectList("newsListData",map);
	   session.close();
	   return list;
   }
   
   public static int newsTotalPage()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("newsTotalPage");
	   session.close();
	   return total;
   }
   
   public static NewsVO newsDetailData(int no) {
 		SqlSession session=ssf.openSession();
 		session.update("newsHitIncrement", no);
 		session.commit();
 		NewsVO vo=session.selectOne("newsDetailData", no);
 		session.close();
 		return vo;
 	}
   /*
   <!-- 뉴스 글 갯수 -->
	<select id="newsCount" resultType="int" parameterType="int">
	*/
   public static int newsCount() {
	   SqlSession session=ssf.openSession();
	   int count=session.selectOne("newsCount");
	   session.close();
	   return count;
   }
   /*
   <!-- 뉴스 검색글 갯수 -->
	<select id="newsSearchCount" resultType="int" parameterType="hashmap">
	*/
   public static int newsSearchCount(Map map) {
	   SqlSession session=ssf.openSession();
	   int count=session.selectOne("newsSearchCount",map);
	   session.close();
	   return count;
   }
   /*
    <!-- 뉴스 검색하기 -->
	<select id="newsSearch" resultType="vo.NewsVO" parameterType="hashmap">
	*/
	public static List<NewsVO> newsSearch(Map map){
		SqlSession session=ssf.openSession();
		List<NewsVO> list=session.selectList("newsSearch",map);
		session.close();
		return list;
	}
   
   /*
	<!-- 뉴스 검색페이지 수 -->
	<select id="newsSearchTotalPage" resultType="int" parameterType="hashmap">
	*/
	public static int newsSearchTotalPage(Map map) {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("newsSearchTotalPage", map);
		session.close();
		return total;
	}
   
	
	// 뉴스 댓글
	// <insert id="newsReplyInsert" parameterType="vo.newsReplyVO">
	public static void newsReplyInsert(newsReplyVO vo)
	   {
		   SqlSession session=ssf.openSession(true);
		   session.insert("newsReplyInsert",vo);
		   session.close();
	   }
	// <select id="newsReplyListData" resultType="vo.newsReplyVO" parameterType="int">
	public static List<newsReplyVO> newsReplyListData(int bno)
	   {
		   SqlSession session=ssf.openSession();
		   List<newsReplyVO> list=session.selectList("newsReplyListData",bno);
		   session.close();
		   return list;
	   }
	 
	
	/*
	 * <select id="newsReplyParentData" parameterType="int" resultType="vo.newsReplyVO">
	 * <update id="newsReplyStepIncrement" parameterType="vo.newsReplyVO">
	 *  <insert id="newsReplyReplyInsert" parameterType="vo.newsReplyVO">
	 *  <update id="newsReplyDepthIncrement" parameterType="int">
	 */
	public static void newsReplyReplyInsert(int root,newsReplyVO vo)
	   {
		   SqlSession session=ssf.openSession();
		   newsReplyVO pvo=session.selectOne("newsReplyParentData",root);
		   session.update("newsReplyStepIncrement", pvo);
		   vo.setGroup_id(pvo.getGroup_id());
		   vo.setGroup_step(pvo.getGroup_step()+1);
		   vo.setGroup_tab(pvo.getGroup_tab()+1);
		   vo.setRoot(root);
		   
		   session.insert("newsReplyReplyInsert", vo);
		   session.update("newsReplyDepthIncrement", root);
		   session.commit();
		   session.close();
	   }
	
	// <update id="newsReplyUpdate" parameterType="vo.newsReplyVO">
	
	   public static void newsReplyUpdate(newsReplyVO vo)
	   {
		   SqlSession session=ssf.openSession(true);
		   session.update("newsReplyUpdate",vo);
		   session.close();
		   
	   }
	   /*
	    *  
	  <!-- 삭제 -->
	  <select id="newsReplyInfoData" resultType="vo.newsReplyVO" parameterType="int">
		  
	  <!-- depth==0 -->
	  <delete id="newsReplyDelete" parameterType="int">

	  <!-- depth!=0 -->
	  <update id="newsReplyMsgUpdate" parameterType="int">
	  
	  <update id="newsReplyDepthDecrement" parameterType="int">
	    */
	   
	   public static void newsReplyDelete(int no)
	   {
		   SqlSession session=ssf.openSession();
		   // depth,root
		   newsReplyVO vo=session.selectOne("newsReplyInfoData", no);
		   if(vo.getDepth()==0)
		   {
			   session.delete("newsReplyDelete", no);
		   }
		   else
		   {
			   session.update("newsReplyMsgUpdate",no);
		   }
		   session.update("newsReplyDepthDecrement",vo.getRoot());
		   
		   session.commit();
		   session.close();
	   }
	   /*
	    *  <select id="newsReplyCount" resultType="int" parameterType="int">
	    */
	   public static int newsReplyCount(int bno)
	   {
		   SqlSession session=ssf.openSession();
		   int count=session.selectOne("newsReplyCount", bno);
		   session.close();
		   return count;
	   }
	
	
   /*
    <!-- 팁 인기순 -->
	<select id="tipHitList" resultType="vo.TipVO" parameterType="hashmap">
    
    <!-- 팁 리스트 -->
	<select id="tipListData" resultType="vo.TipVO" parameterType="hashmap">
	
	<!-- 팁 페이지 수 -->
	<select id="tipTotalPage" resultType="int" parameterType="int">
	
	<!-- 팁 상세페이지 -->
	<select id="tipDetailData" resultType="vo.TipVO" parameterType="int">
	
	<!-- 팁 조회수 -->
	<update id="tipHitIncrement" parameterType="int">
	*/
   public static List<TipVO> tipHitList(Map map){
	   SqlSession session=ssf.openSession();
	   List<TipVO> hlist=session.selectList("tipHitList",map);
	   session.close();
	   return hlist;
   }
   
   public static List<TipVO> tipListData(Map map){
	   SqlSession session=ssf.openSession();
	   List<TipVO> list=session.selectList("tipListData",map);
	   session.close();
	   return list;
   }
   
   public static int tipTotalPage() {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("tipTotalPage");
	   session.close();
	   return total;
   }
   
   public static TipVO tipDetailData(int no) {
		SqlSession session=ssf.openSession();
		session.update("tipHitIncrement", no);
		session.commit();
		TipVO vo=session.selectOne("tipDetailData", no);
		session.close();
		return vo;
	}
   /*
   <!-- 팁 글 갯수 -->
	<select id="tipCount" resultType="int" parameterType="int">
	  	SELECT COUNT(*) FROM tip
 	</select>
	*/
    public static int tipCount() {
	   SqlSession session=ssf.openSession();
	   int count=session.selectOne("tipCount");
	   session.close();
	   return count;
   }
   /*
   <!-- 팁 검색글 갯수 -->
	<select id="newsSearchCount" resultType="int" parameterType="hashmap">
	*/
    public static int tipSearchCount(Map map) {
	   SqlSession session=ssf.openSession();
	   int count=session.selectOne("tipSearchCount",map);
	   session.close();
	   return count;
    }
	
   /*
   <!-- 팁 검색하기 -->
	<select id="tipSearch" resultType="vo.TipVO" parameterType="hashmap">
	*/
	public static List<TipVO> tipSearch(Map map){
		SqlSession session=ssf.openSession();
		List<TipVO> list=session.selectList("tipSearch",map);
		session.close();
		return list;
	}
  
  /*
	<!-- 팁 검색페이지 수 -->
	<select id="tipSearchTotalPage" resultType="int" parameterType="hashmap">
	*/
	public static int tipSearchTotalPage(Map map) {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("tipSearchTotalPage", map);
		session.close();
		return total;
	}
	
	
	// 팁 댓글
		// <insert id="tipReplyInsert" parameterType="vo.tipReplyVO">
		public static void tipReplyInsert(tipReplyVO vo)
		   {
			   SqlSession session=ssf.openSession(true);
			   session.insert("tipReplyInsert",vo);
			   session.close();
		   }
		// <select id="tipReplyListData" resultType="vo.tipReplyVO" parameterType="int">
		public static List<tipReplyVO> tipReplyListData(int bno)
		   {
			   SqlSession session=ssf.openSession();
			   List<tipReplyVO> list=session.selectList("tipReplyListData",bno);
			   session.close();
			   return list;
		   }
		 
		
		/*
		 * <select id="tipReplyParentData" parameterType="int" resultType="vo.tipReplyVO">
		 * <update id="tipReplyStepIncrement" parameterType="vo.tipReplyVO">
		 *  <insert id="tipReplyReplyInsert" parameterType="vo.tipReplyVO">
		 *  <update id="tipReplyDepthIncrement" parameterType="int">
		 */
		public static void tipReplyReplyInsert(int root,tipReplyVO vo)
		   {
			   SqlSession session=ssf.openSession();
			   tipReplyVO pvo=session.selectOne("tipReplyParentData",root);
			   session.update("tipReplyStepIncrement", pvo);
			   vo.setGroup_id(pvo.getGroup_id());
			   vo.setGroup_step(pvo.getGroup_step()+1);
			   vo.setGroup_tab(pvo.getGroup_tab()+1);
			   vo.setRoot(root);
			   
			   session.insert("tipReplyReplyInsert", vo);
			   session.update("tipReplyDepthIncrement", root);
			   session.commit();
			   session.close();
		   }
		
		// <update id="tipReplyUpdate" parameterType="vo.tipReplyVO">
		
		   public static void tipReplyUpdate(tipReplyVO vo)
		   {
			   SqlSession session=ssf.openSession(true);
			   session.update("tipReplyUpdate",vo);
			   session.close();
			   
		   }
		   /*
		    *  
		  <!-- 삭제 -->
		  <select id="tipReplyInfoData" resultType="vo.tipReplyVO" parameterType="int">
			  
		  <!-- depth==0 -->
		  <delete id="tipReplyDelete" parameterType="int">

		  <!-- depth!=0 -->
		  <update id="tipReplyMsgUpdate" parameterType="int">
		  
		  <update id="tipReplyDepthDecrement" parameterType="int">
		    */
		   
		   public static void tipReplyDelete(int no)
		   {
			   SqlSession session=ssf.openSession();
			   // depth,root
			   tipReplyVO vo=session.selectOne("tipReplyInfoData", no);
			   if(vo.getDepth()==0)
			   {
				   session.delete("tipReplyDelete", no);
			   }
			   else
			   {
				   session.update("tipReplyMsgUpdate",no);
			   }
			   session.update("tipReplyDepthDecrement",vo.getRoot());
			   
			   session.commit();
			   session.close();
		   }
		   /*
		    *  <select id="tipReplyCount" resultType="int" parameterType="int">
		    */
		   public static int tipReplyCount(int bno)
		   {
			   SqlSession session=ssf.openSession();
			   int count=session.selectOne("tipReplyCount", bno);
			   session.close();
			   return count;
		   }
	
	
   
   /*
    <!-- 비디오 인기순 -->
	<select id="newsHitList" resultType="vo.VideoVO" parameterType="hashmap">
	
	<!-- 비디오 리스트 -->
	<select id="videoListData" resultType="vo.VideoVO" parameterType="hashmap">
	
	<!-- 비디오 페이지 수 -->
	<select id="videoTotalPage" resultType="int" parameterType="int">
	
	<!-- 비디오 상세페이지 -->
	<select id="videoDetailData" resultType="vo.VideoVO" parameterType="int">
	
	<!-- 비디오 조회수 -->
	<update id="videoHitIncrement" parameterType="int">
   */
   
   public static List<VideoVO> videoHitList(Map map){
	   SqlSession session=ssf.openSession();
	   List<VideoVO> hlist=session.selectList("videoHitList",map);
	   session.close();
	   return hlist;
   }
   
   public static List<VideoVO> videoListData(Map map){
	   SqlSession session=ssf.openSession();
	   List<VideoVO> list=session.selectList("videoListData",map);
	   session.close();
	   return list;
   }
   
   public static int videoTotalPage() {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("videoTotalPage");
	   session.close();
	   return total;
   }
   
   public static VideoVO videoDetailData(int no) {
		SqlSession session=ssf.openSession();
		session.update("videoHitIncrement", no);
		session.commit();
		VideoVO vo=session.selectOne("videoDetailData", no);
		session.close();
		return vo;
	}
   /*
   <!-- 비디오 글 갯수 -->
	<select id="videoCount" resultType="int" parameterType="int">
	  	SELECT COUNT(*) FROM video 
 	</select>
	*/
   public static int videoCount() {
	   SqlSession session=ssf.openSession();
	   int count=session.selectOne("videoCount");
	   session.close();
	   return count;
   }
   
   /*
   <!-- 비디오 검색글 갯수 -->
	<select id="newsSearchCount" resultType="int" parameterType="hashmap">
	*/
    public static int videoSearchCount(Map map) {
	   SqlSession session=ssf.openSession();
	   int count=session.selectOne("videoSearchCount",map);
	   session.close();
	   return count;
    }
    
   /*
   <!-- 비디오 검색하기 -->
	<select id="videoSearch" resultType="vo.VideoVO" parameterType="hashmap">
	*/
	public static List<VideoVO> videoSearch(Map map){
		SqlSession session=ssf.openSession();
		List<VideoVO> list=session.selectList("videoSearch",map);
		session.close();
		return list;
	}
  
  /*
	<!-- 비디오 검색페이지 수 -->
	<select id="videoSearchTotalPage" resultType="int" parameterType="hashmap">
	*/
	public static int videoSearchTotalPage(Map map) {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("videoSearchTotalPage", map);
		session.close();
		return total;
	}
	
   
	// 비디오 댓글
			// <insert id="videoReplyInsert" parameterType="vo.videoReplyVO">
			public static void videoReplyInsert(videoReplyVO vo)
			   {
				   SqlSession session=ssf.openSession(true);
				   session.insert("videoReplyInsert",vo);
				   session.close();
			   }
			// <select id="videoReplyListData" resultType="vo.videoReplyVO" parameterType="int">
			public static List<videoReplyVO> videoReplyListData(int bno)
			   {
				   SqlSession session=ssf.openSession();
				   List<videoReplyVO> list=session.selectList("videoReplyListData",bno);
				   session.close();
				   return list;
			   }
			 
			
			/*
			 * <select id="videoReplyParentData" parameterType="int" resultType="vo.videoReplyVO">
			 * <update id="videoReplyStepIncrement" parameterType="vo.videoReplyVO">
			 *  <insert id="videoReplyReplyInsert" parameterType="vo.videoReplyVO">
			 *  <update id="videoReplyDepthIncrement" parameterType="int">
			 */
			public static void videoReplyReplyInsert(int root,videoReplyVO vo)
			   {
				   SqlSession session=ssf.openSession();
				   videoReplyVO pvo=session.selectOne("videoReplyParentData",root);
				   session.update("videoReplyStepIncrement", pvo);
				   vo.setGroup_id(pvo.getGroup_id());
				   vo.setGroup_step(pvo.getGroup_step()+1);
				   vo.setGroup_tab(pvo.getGroup_tab()+1);
				   vo.setRoot(root);
				   
				   session.insert("videoReplyReplyInsert", vo);
				   session.update("videoReplyDepthIncrement", root);
				   session.commit();
				   session.close();
			   }
			
			// <update id="videoReplyUpdate" parameterType="vo.videoReplyVO">
			
			   public static void videoReplyUpdate(videoReplyVO vo)
			   {
				   SqlSession session=ssf.openSession(true);
				   session.update("videoReplyUpdate",vo);
				   session.close();
				   
			   }
			   /*
			    *  
			  <!-- 삭제 -->
			  <select id="videoReplyInfoData" resultType="vo.videoReplyVO" parameterType="int">
				  
			  <!-- depth==0 -->
			  <delete id="videoReplyDelete" parameterType="int">

			  <!-- depth!=0 -->
			  <update id="videoReplyMsgUpdate" parameterType="int">
			  
			  <update id="videoReplyDepthDecrement" parameterType="int">
			    */
			   
			   public static void videoReplyDelete(int no)
			   {
				   SqlSession session=ssf.openSession();
				   // depth,root
				   videoReplyVO vo=session.selectOne("videoReplyInfoData", no);
				   if(vo.getDepth()==0)
				   {
					   session.delete("videoReplyDelete", no);
				   }
				   else
				   {
					   session.update("videoReplyMsgUpdate",no);
				   }
				   session.update("videoReplyDepthDecrement",vo.getRoot());
				   
				   session.commit();
				   session.close();
			   }
			   /*
			    *  <select id="videoReplyCount" resultType="int" parameterType="int">
			    */
			   public static int videoReplyCount(int bno)
			   {
				   SqlSession session=ssf.openSession();
				   int count=session.selectOne("videoReplyCount", bno);
				   session.close();
				   return count;
			   }
	
			   
	/*
	<!-- 뉴스 스크랩 저장 -->
	<insert id="newsScrapInsert" parameterType="vo.NewsScrapVO">
	*/		   
	public static void newsScrapInsert(NewsScrapVO vo) {
	   SqlSession session=ssf.openSession(true); //insert, update, delete는 autocommit해줘야됨
	   session.update("newsScrapInsert", vo);
	   session.close();
   }
	
	/*
	<!-- 팁 스크랩 저장 -->
	<insert id="tipScrapInsert" parameterType="vo.TipScrapVO">
	*/
	public static void tipScrapInsert(TipScrapVO vo) {
		SqlSession session=ssf.openSession(true);
		session.update("tipScrapInsert", vo);
		session.close();
	}
	   
	/*
	<!-- 비디오 스크랩 저장 -->
	<insert id="videoScrapInsert" parameterType="vo.VideoScrapVO">
	*/   
	public static void videoScrapInsert(VideoScrapVO vo) {
		SqlSession session=ssf.openSession(true); 
		session.update("videoScrapInsert", vo);
		session.close();
	}
	
	/*		
	<!-- 뉴스스크랩 데이터 읽기(스크랩 목록) -->
	<select id="newsScrapListData" parameterType="String" resultType="vo.NewsScrapVO">
	*/
	public static List<NewsScrapVO> newsScrapListData(String id) {
		SqlSession session=ssf.openSession();
		List<NewsScrapVO> list=session.selectList("newsScrapListData",id);
		session.close();
		return list;
	}
	 
	/*
	<!-- 팁스크랩 데이터 읽기(스크랩 목록) -->
	<select id="tipScrapListData" parameterType="String" resultType="vo.TipScrapVO">
	*/
	public static List<TipScrapVO> tipScrapListData(String id) {
		SqlSession session=ssf.openSession();
		List<TipScrapVO> list=session.selectList("tipScrapListData",id);
		session.close();
		return list;
	}
	
	/*
	<!-- 비디오스크랩 데이터 읽기(스크랩 목록) -->
	<select id="videoScrapListData" parameterType="String" resultType="vo.VideoScrapVO">
	*/
	public static List<VideoScrapVO> videoScrapListData(String id) {
		SqlSession session=ssf.openSession();
		List<VideoScrapVO> list=session.selectList("videoScrapListData",id);
		session.close();
		return list;
	}
	
	/*
	<!-- 뉴스 스크랩 여부 확인: 같은 것 스크랩 불가능하게끔 -->
	<select id="newsScrapCount" parameterType="vo.NewsScrapVO" resultType="int">
	*/
	public static int newsScrapCount(NewsScrapVO vo) {
		SqlSession session=ssf.openSession();
		int count=session.selectOne("newsScrapCount",vo);
		session.close();
		return count;
	}
	
	
	/*
	<!-- 팁 스크랩 여부 확인 -->
	<select id="tipScrapCount" parameterType="vo.TipScrapVO" resultType="int">
	*/
	public static int tipScrapCount(TipScrapVO vo) {
		SqlSession session=ssf.openSession();
		int count=session.selectOne("tipScrapCount",vo);
		session.close();
		return count;
	}
	
	/*
	<!-- 비디오 스크랩 여부 확인 -->
	<select id="videoScrapCount" parameterType="vo.VideoScrapVO" resultType="int">
	*/
	public static int videoScrapCount(VideoScrapVO vo) {
		SqlSession session=ssf.openSession();
		int count=session.selectOne("videoScrapCount",vo);
		session.close();
		return count;
	}
	
	
	/*
	<!-- 뉴스 스크랩 취소 -->
	<delete id="newsScrapDelete" parameterType="int">
	*/
	public static void newsScrapDelete(int no) {
	   SqlSession session=ssf.openSession(true);
	   session.delete("newsScrapDelete", no);
	   session.close();
    }
   	
	/*
	<!-- 팁 스크랩 취소 -->
	<delete id="tipScrapDelete" parameterType="int">
	*/
	public static void tipScrapDelete(int no) {
		   SqlSession session=ssf.openSession(true);
		   session.delete("tipScrapDelete", no);
		   session.close();
	}
	
	/*
	<!-- 비디오 스크랩 취소 -->
	<delete id="videoScrapDelete" parameterType="int">
	*/
	public static void videoScrapDelete(int no) {
		   SqlSession session=ssf.openSession(true);
		   session.delete("videoScrapDelete", no);
		   session.close();
	}

   
}