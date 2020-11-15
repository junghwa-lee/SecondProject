package vo;
/* selfletter 테이블 (합격자소서)
SNO       NOT NULL NUMBER        //자소서번호 
SSUBJECT  NOT NULL VARCHAR2(100) //자소서제목
SNAME              VARCHAR2(100) //기업명
SINDUTYPE          VARCHAR2(100) //직종
SQ1                CLOB          //항목1
SA1                CLOB          //답변1
SQ2                CLOB          //항목2
SA2                CLOB          //답변2
SQ3                CLOB          //항목3
SA3                CLOB          //답변3
HIT				   NUMBER		//조회수
 */
public class SelfVO {
   private int sno;
   private String ssubject;
   private String sname;
   private String sindutype;
   private String sq1;
   private String sa1;
   private String sq2;
   private String sa2;
   private String sq3;
   private String sa3;
   private int hit;
   
   public int getHit() {
	return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getSno() {
	      return sno;
	   }
   public void setSno(int sno) {
      this.sno = sno;
   }
   public String getSsubject() {
      return ssubject;
   }
   public void setSsubject(String ssubject) {
      this.ssubject = ssubject;
   }
   public String getSname() {
      return sname;
   }
   public void setSname(String sname) {
      this.sname = sname;
   }
   public String getSindutype() {
      return sindutype;
   }
   public void setSindutype(String sindutype) {
      this.sindutype = sindutype;
   }
   public String getSq1() {
      return sq1;
   }
   public void setSq1(String sq1) {
      this.sq1 = sq1;
   }
   public String getSa1() {
      return sa1;
   }
   public void setSa1(String sa1) {
      this.sa1 = sa1;
   }
   public String getSq2() {
      return sq2;
   }
   public void setSq2(String sq2) {
      this.sq2 = sq2;
   }
   public String getSa2() {
      return sa2;
   }
   public void setSa2(String sa2) {
      this.sa2 = sa2;
   }
   public String getSq3() {
      return sq3;
   }
   public void setSq3(String sq3) {
      this.sq3 = sq3;
   }
   public String getSa3() {
      return sa3;
   }
   public void setSa3(String sa3) {
      this.sa3 = sa3;
   }
   
   
   
}