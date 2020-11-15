package vo;


/*
	이름     널? 유형            
	------ -- ------------- 
	ID        VARCHAR2(20)  
	NO		  NUMBER
	PHOTO     VARCHAR2(100) 
	STYPE     VARCHAR2(50)  
	SNAME     VARCHAR2(50)  
	SMAJOR    VARCHAR2(100) 
	SDATE1    VARCHAR2(100) 
	SDATE2    VARCHAR2(100) 
	STATE     VARCHAR2(50)  
	BTYPE     VARCHAR2(100) 
	BNAME     VARCHAR2(100) 
	BGRADE    VARCHAR2(100) 
	BDATE     VARCHAR2(30)  
	CNAME     VARCHAR2(100) 
	CDATE     VARCHAR2(30)  
	CL        CLOB              
 */
public class ResumeVO {
	private String id;
	private int no;
	private String subject;
	private String stype;
	private String sname;
	private String smajor;
	private String sdate1;
	private String sdate2;
	private String state;
	private String btype;
	private String bname;
	private String bgrade;
	private String bdate;
	private String cname;
	private String cdate;
	private String cl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	public String getSdate1() {
		return sdate1;
	}
	public void setSdate1(String sdate1) {
		this.sdate1 = sdate1;
	}
	public String getSdate2() {
		return sdate2;
	}
	public void setSdate2(String sdate2) {
		this.sdate2 = sdate2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBgrade() {
		return bgrade;
	}
	public void setBgrade(String bgrade) {
		this.bgrade = bgrade;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCl() {
		return cl;
	}
	public void setCl(String cl) {
		this.cl = cl;
	}
	
	
	
	
}
