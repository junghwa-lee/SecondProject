package vo;
/* 지역별 공고
WNO           NUMBER  
L_NAME        VARCHAR2(100) 
L_TYPE        VARCHAR2(100) 
L_LOC         VARCHAR2(100) 
L_SIDO        VARCHAR2(100) 
L_DEADLINE    VARCHAR2(100) 
L_INDUTYPE    VARCHAR2(100) 
L_GLOANN      VARCHAR2(100) 
L_HIREDATE    VARCHAR2(100) 
L_CONTENT     CLOB          
L_HIT         NUMBER        
L_LOGO        VARCHAR2(100) 
 */
public class LocAnnVO {
   private int wno;
   private String l_name;
   private String l_type;
   private String l_loc;
   private String l_sido;
   private String l_deadline;
   private String l_indutype;
   private String l_gloann;
   private String l_hiredate;
   private String l_content;
   private int l_hit;
   private String l_logo;
   
   public int getWno() {
      return wno;
   }
   public void setWno(int wno) {
      this.wno = wno;
   }
   public String getL_name() {
      return l_name;
   }
   public void setL_name(String l_name) {
      this.l_name = l_name;
   }
   public String getL_type() {
      return l_type;
   }
   public void setL_type(String l_type) {
      this.l_type = l_type;
   }
   public String getL_loc() {
      return l_loc;
   }
   public void setL_loc(String l_loc) {
      this.l_loc = l_loc;
   }
   public String getL_sido() {
      return l_sido;
   }
   public void setL_sido(String l_sido) {
      this.l_sido = l_sido;
   }
   public String getL_deadline() {
      return l_deadline;
   }
   public void setL_deadline(String l_deadline) {
      this.l_deadline = l_deadline;
   }
   public String getL_indutype() {
      return l_indutype;
   }
   public void setL_indutype(String l_indutype) {
      this.l_indutype = l_indutype;
   }
   public String getL_gloann() {
      return l_gloann;
   }
   public void setL_gloann(String l_gloann) {
      this.l_gloann = l_gloann;
   }
   public String getL_hiredate() {
      return l_hiredate;
   }
   public void setL_hiredate(String l_hiredate) {
      this.l_hiredate = l_hiredate;
   }
   public String getL_content() {
      return l_content;
   }
   public void setL_content(String l_content) {
      this.l_content = l_content;
   }
   public int getL_hit() {
      return l_hit;
   }
   public void setL_hit(int l_hit) {
      this.l_hit = l_hit;
   }
   public String getL_logo() {
      return l_logo;
   }
   public void setL_logo(String l_logo) {
      this.l_logo = l_logo;
   }
   
}