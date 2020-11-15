package vo;
/*
 * Table NEWS이(가) 생성되었습니다.

이름           널?       유형             
------------ -------- -------------- 
N_NO         NOT NULL NUMBER         
N_TITLE      NOT NULL VARCHAR2(1000) 
N_POSTER     NOT NULL VARCHAR2(1000) 
N_POSTER2             VARCHAR2(1000) 
N_REGDATE    NOT NULL VARCHAR2(500)  
N_PRECONTENT NOT NULL VARCHAR2(2000) 
N_CONTENT    NOT NULL CLOB           
N_WRITER     NOT NULL VARCHAR2(500)  
N_HIT                 NUMBER         
N_TAG                 VARCHAR2(500)  
N_CNO                 NUMBER         
N_COMMENT             CLOB           
N_ID                  VARCHAR2(500)  
N_PWD                 VARCHAR2(500)  

 */
public class NewsVO {
	private int n_no;
	private String n_title;
	private String n_poster;
	private String n_poster2;
	private String n_regdate;
	private String n_precontent;
	private String n_content;
	private String n_writer;
	private int n_hit;
	private int n_replyCount;
	private int n_sno;
	
	public int getN_sno() {
		return n_sno;
	}
	public void setN_sno(int n_sno) {
		this.n_sno = n_sno;
	}
	public int getN_replyCount() {
		return n_replyCount;
	}
	public void setN_replyCount(int n_replyCount) {
		this.n_replyCount = n_replyCount;
	}
	public int getN_no() {
		return n_no;
	}
	public void setN_no(int n_no) {
		this.n_no = n_no;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_poster() {
		return n_poster;
	}
	public void setN_poster(String n_poster) {
		this.n_poster = n_poster;
	}
	public String getN_poster2() {
		return n_poster2;
	}
	public void setN_poster2(String n_poster2) {
		this.n_poster2 = n_poster2;
	}
	public String getN_regdate() {
		return n_regdate;
	}
	public void setN_regdate(String n_regdate) {
		this.n_regdate = n_regdate;
	}
	public String getN_precontent() {
		return n_precontent;
	}
	public void setN_precontent(String n_precontent) {
		this.n_precontent = n_precontent;
	}
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	public String getN_writer() {
		return n_writer;
	}
	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}
	public int getN_hit() {
		return n_hit;
	}
	public void setN_hit(int n_hit) {
		this.n_hit = n_hit;
	}
}