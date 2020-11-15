package vo;
/* 인기공고
CNO         NUMBER        
CNAME       VARCHAR2(100) 
CTYPE       VARCHAR2(100) 
INDUTYPE    VARCHAR2(100) 
CLOC        VARCHAR2(100) 
WORKNUM     VARCHAR2(100) 
AVGSAL      VARCHAR2(100) 
AVGEDU      VARCHAR2(100) 
DEADLINE    VARCHAR2(100) 
COVER       VARCHAR2(100) 
SITE        VARCHAR2(100) 
 */
public class Top100VO {
   private int cno;
   private String cname;
   private String ctype;
   private String indutype;
   private String cloc;
   private String worknum;
   private String avgsal;
   private String avgedu;
   private String deadline;
   private String cover;
   private String site;
   public int getCno() {
      return cno;
   }
   public void setCno(int cno) {
      this.cno = cno;
   }
   public String getCname() {
      return cname;
   }
   public void setCname(String cname) {
      this.cname = cname;
   }
   public String getCtype() {
      return ctype;
   }
   public void setCtype(String ctype) {
      this.ctype = ctype;
   }
   public String getIndutype() {
      return indutype;
   }
   public void setIndutype(String indutype) {
      this.indutype = indutype;
   }
   public String getCloc() {
      return cloc;
   }
   public void setCloc(String cloc) {
      this.cloc = cloc;
   }
   public String getWorknum() {
      return worknum;
   }
   public void setWorknum(String worknum) {
      this.worknum = worknum;
   }
   public String getAvgsal() {
      return avgsal;
   }
   public void setAvgsal(String avgsal) {
      this.avgsal = avgsal;
   }
   public String getAvgedu() {
      return avgedu;
   }
   public void setAvgedu(String avgedu) {
      this.avgedu = avgedu;
   }
   public String getDeadline() {
      return deadline;
   }
   public void setDeadline(String deadline) {
      this.deadline = deadline;
   }
   public String getCover() {
      return cover;
   }
   public void setCover(String cover) {
      this.cover = cover;
   }
   public String getSite() {
      return site;
   }
   public void setSite(String site) {
      this.site = site;
   }
   
}