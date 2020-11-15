package vo;
/* 직업별공고
WNO           NUMBER        
J_NAME        VARCHAR2(100) 
J_TYPE        VARCHAR2(100) 
J_INDUTYPE    VARCHAR2(100) 
J_DEADLINE    VARCHAR2(100) 
J_JOBKINDS    VARCHAR2(100) 
J_HIREDATE    VARCHAR2(100) 
J_CONTENT     CLOB          
J_HIT         NUMBER        
J_LOGO        VARCHAR2(100) 
 */
public class JobAnnVO {
   private int wno;
   private String j_name;
   private String j_type;
   private String j_indutype;
   private String j_deadline;
   private String j_jobkinds;
   private String j_hiredate;
   private String j_content;
   private int j_hit;
   private String j_logo;
   public int getWno() {
      return wno;
   }
   public void setWno(int wno) {
      this.wno = wno;
   }
   public String getJ_name() {
      return j_name;
   }
   public void setJ_name(String j_name) {
      this.j_name = j_name;
   }
   public String getJ_type() {
      return j_type;
   }
   public void setJ_type(String j_type) {
      this.j_type = j_type;
   }
   public String getJ_indutype() {
      return j_indutype;
   }
   public void setJ_indutype(String j_indutype) {
      this.j_indutype = j_indutype;
   }
   public String getJ_deadline() {
      return j_deadline;
   }
   public void setJ_deadline(String j_deadline) {
      this.j_deadline = j_deadline;
   }
   public String getJ_jobkinds() {
      return j_jobkinds;
   }
   public void setJ_jobkinds(String j_jobkinds) {
      this.j_jobkinds = j_jobkinds;
   }
   public String getJ_hiredate() {
      return j_hiredate;
   }
   public void setJ_hiredate(String j_hiredate) {
      this.j_hiredate = j_hiredate;
   }
   public String getJ_content() {
      return j_content;
   }
   public void setJ_content(String j_content) {
      this.j_content = j_content;
   }
   public int getJ_hit() {
      return j_hit;
   }
   public void setJ_hit(int j_hit) {
      this.j_hit = j_hit;
   }
   public String getJ_logo() {
      return j_logo;
   }
   public void setJ_logo(String j_logo) {
      this.j_logo = j_logo;
   }
   
}