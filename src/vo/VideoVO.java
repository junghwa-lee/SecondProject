package vo;
/*
 * Table VIDEO이(가) 생성되었습니다.

이름        널?       유형             
--------- -------- -------------- 
V_NO      NOT NULL NUMBER         
V_TITLE   NOT NULL VARCHAR2(1000) 
V_POSTER  NOT NULL VARCHAR2(1000) 
V_VIDEO   NOT NULL VARCHAR2(1000) 
V_REGDATE          VARCHAR2(500)  
V_CONTENT          CLOB           
V_WRITER           VARCHAR2(500)  
V_HIT              NUMBER         
V_TAG              VARCHAR2(500)  
V_CNO              NUMBER         
V_COMMENT          CLOB           
V_ID               VARCHAR2(500)  
V_PWD              VARCHAR2(500)  
 */
public class VideoVO {
	private int v_no;
	private String v_title;
	private String v_poster;
	private String v_video;
	private String v_regdate;
	private String v_content;
	private String v_writer;
	private int v_hit;
	private int v_replyCount;
	private int v_sno;
	
	public int getV_sno() {
		return v_sno;
	}
	public void setV_sno(int v_sno) {
		this.v_sno = v_sno;
	}
	public int getV_hit() {
		return v_hit;
	}
	public void setV_hit(int v_hit) {
		this.v_hit = v_hit;
	}
	public int getV_no() {
		return v_no;
	}
	public void setV_no(int v_no) {
		this.v_no = v_no;
	}
	public String getV_title() {
		return v_title;
	}
	public void setV_title(String v_title) {
		this.v_title = v_title;
	}
	public String getV_poster() {
		return v_poster;
	}
	public void setV_poster(String v_poster) {
		this.v_poster = v_poster;
	}
	public String getV_video() {
		return v_video;
	}
	public void setV_video(String v_video) {
		this.v_video = v_video;
	}
	public String getV_regdate() {
		return v_regdate;
	}
	public void setV_regdate(String v_regdate) {
		this.v_regdate = v_regdate;
	}
	public String getV_content() {
		return v_content;
	}
	public void setV_content(String v_content) {
		this.v_content = v_content;
	}
	public String getV_writer() {
		return v_writer;
	}
	public void setV_writer(String v_writer) {
		this.v_writer = v_writer;
	}
	public int getV_replyCount() {
		return v_replyCount;
	}
	public void setV_replyCount(int v_replyCount) {
		this.v_replyCount = v_replyCount;
	}
	
}