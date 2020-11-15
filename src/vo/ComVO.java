package vo;
/*
 * company 테이블 (기업정보)
CNO       NOT NULL NUMBER         //기업번호
CATENO			   NUMBER		  //카테고리번호 (100~1000)
CNAME     NOT NULL VARCHAR2(100)  //기업명
CLOGO              VARCHAR2(500)  //기업로고
CTYPE              VARCHAR2(100)  //기업형태
CINDUTYPE          VARCHAR2(100)  //산업군
CLOC               VARCHAR2(100)  //기업주소
CSCORE             VARCHAR2(10)   //총평점
CDATE              VARCHAR2(100)  //설립일
WORKNUM            VARCHAR2(100)  //사원수
BNAME              VARCHAR2(100)  //대표이름
SALE               VARCHAR2(100)  //매출
COVER              CLOB           //기업소개
SITE1              VARCHAR2(500)  //웹사이트
HISTORY            VARCHAR2(1000) //연혁
 */
public class ComVO {
	private int cno;
	private int cateno;
	private String cname;
	private String clogo;
	private String ctype;
	private String cindutype;
	private String cloc;
	private String cscore;
	private String cdate;
	private String worknum;
	private String bname;
	private String sale;
	private String cover;
	private String site1;
	private String history;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getCateno() {
		return cateno;
	}
	public void setCateno(int cateno) {
		this.cateno = cateno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getClogo() {
		return clogo;
	}
	public void setClogo(String clogo) {
		this.clogo = clogo;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCindutype() {
		return cindutype;
	}
	public void setCindutype(String cindutype) {
		this.cindutype = cindutype;
	}
	public String getCloc() {
		return cloc;
	}
	public void setCloc(String cloc) {
		this.cloc = cloc;
	}
	public String getCscore() {
		return cscore;
	}
	public void setCscore(String cscore) {
		this.cscore = cscore;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getWorknum() {
		return worknum;
	}
	public void setWorknum(String worknum) {
		this.worknum = worknum;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getSite1() {
		return site1;
	}
	public void setSite1(String site1) {
		this.site1 = site1;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
	
	
	
}
