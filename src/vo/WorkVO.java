package vo;

import java.util.Date;

/* workreview 테이블 (재직자후기)
RNO    NOT NULL NUMBER        //리뷰번호
RTYPE           VARCHAR2(200) //직종
RLOC            VARCHAR2(200) //근무지역
RDATE  			DATE 		  //작성일
RSCORE NOT NULL VARCHAR2(20)  //평점
RSUB   NOT NULL CLOB          //리뷰내용
RGOOD           CLOB          //장점
RBAD            CLOB          //단점
RWISH           CLOB           //바라는점
CNO				NUMBER			//기업번호(외래키 대신)

 */



public class WorkVO {
   private int rno;
   private String rtype;
   private String rloc;
   private String rdate;
   private String rscore;
   private String rsub;
   private String rgood;
   private String rbad;
   private String rwish;
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}
public String getRtype() {
	return rtype;
}
public void setRtype(String rtype) {
	this.rtype = rtype;
}
public String getRloc() {
	return rloc;
}
public void setRloc(String rloc) {
	this.rloc = rloc;
}
public String getRdate() {
	return rdate;
}
public void setRdate(String rdate) {
	this.rdate = rdate;
}
public String getRscore() {
	return rscore;
}
public void setRscore(String rscore) {
	this.rscore = rscore;
}
public String getRsub() {
	return rsub;
}
public void setRsub(String rsub) {
	this.rsub = rsub;
}
public String getRgood() {
	return rgood;
}
public void setRgood(String rgood) {
	this.rgood = rgood;
}
public String getRbad() {
	return rbad;
}
public void setRbad(String rbad) {
	this.rbad = rbad;
}
public String getRwish() {
	return rwish;
}
public void setRwish(String rwish) {
	this.rwish = rwish;
}
   

   
  
   
}