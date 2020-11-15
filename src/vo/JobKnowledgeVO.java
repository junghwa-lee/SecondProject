package vo;

/*
NO            NUMBER        
ID            VARCHAR2(30)  
SUBJECT       VARCHAR2(500) 
CONTENT       CLOB          
REGDATE       DATE          
HIT           NUMBER        
GROUP_ID      NUMBER        
GROUP_STEP    NUMBER        
ROOT          NUMBER        
DEPTH         NUMBER        
COMMENT_ID    NUMBER        
TAG           VARCHAR2(30)  
ADOPT         NUMBER      
 */

import java.util.*;

// 잡지식인 게시글 VO ==================================================

public class JobKnowledgeVO {
	private int no;				// 게시글번호
	private String id;			// 작성자 아이디
	private String subject;		// 제목
	private String content;		// 내용
	private Date regdate;		// 작성일
	private int	hit;			// 조회수
	private int group_id;		// 게시글그룹
	private int group_step;		// 그룹내순서
	private int root;			// 뿌리글
	private int depth;			// 깊이
	private int comment_id;		// 댓글그룹
	private String tag;			// 태그
	private int adopt;			// 채택여부
	private int reply;
	private int scrap_no;		// 스크랩번호
	private int point;			// 채택시 답변자에게 부여할 점수
	private int noti;			// 새로운 답변 갯수
	
	
	
	
	public int getNoti() {
		return noti;
	}
	public void setNoti(int noti) {
		this.noti = noti;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getScrap_no() {
		return scrap_no;
	}
	public void setScrap_no(int scrap_no) {
		this.scrap_no = scrap_no;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getGroup_step() {
		return group_step;
	}
	public void setGroup_step(int group_step) {
		this.group_step = group_step;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getAdopt() {
		return adopt;
	}
	public void setAdopt(int adopt) {
		this.adopt = adopt;
	}
	
	
}
