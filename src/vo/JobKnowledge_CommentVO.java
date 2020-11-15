package vo;




/*
NO              NUMBER         
ID              VARCHAR2(30)   
COMMENT_ID      NUMBER         
CONTENT         VARCHAR2(1000) 
REGDATE         DATE           
COMMENT_STEP    NUMBER         
ROOT            NUMBER  
 */


//잡지식인 댓글 VO ==================================================

import java.util.*;
public class JobKnowledge_CommentVO {
	
	private int no;				// 댓글번호
	private int reply_no;		// 답변글 번호
	private int board_no;		// 질문글 번호
	private String id;			// 작성자 아이디
	private String content;		// 내용
	private Date regdate;		// 작성일
	private int comment_id;		// 댓글그룹
	private int comment_step;	// 그룹내순서
	private int comment_tab;	// 댓글 들여쓰기
	private int root;			// 뿌리글
	private int depth;			// 대댓글 개수
	private String dbday;
	
	
	
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getComment_tab() {
		return comment_tab;
	}
	public void setComment_tab(int comment_tab) {
		this.comment_tab = comment_tab;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getNo() {		
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getComment_step() {
		return comment_step;
	}
	public void setComment_step(int comment_step) {
		this.comment_step = comment_step;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	
	
	
	
}
