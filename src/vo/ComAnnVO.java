package vo;
/*기업별공고
WNO           NUMBER        
C_CNAME       VARCHAR2(100) 
C_CTYPE       VARCHAR2(100) 
C_INDUTYPE    VARCHAR2(100) 
C_DEADLINE    VARCHAR2(100) 
C_COMSCALE    VARCHAR2(100) 
C_CONTENT     CLOB          
C_HIT         NUMBER        
C_LOGO        VARCHAR2(100) 
 */
public class ComAnnVO {
   private int wno;
   private String c_cname;
   private String c_ctype;
   private String c_indutype;
   private String c_deadline;
   private String c_comscale;
   private String c_content;
   private int c_hit;
   private String c_logo;
   public int getWno() {
      return wno;
   }
   public void setWno(int wno) {
      this.wno = wno;
   }
   public String getC_cname() {
      return c_cname;
   }
   public void setC_cname(String c_cname) {
      this.c_cname = c_cname;
   }
   public String getC_ctype() {
      return c_ctype;
   }
   public void setC_ctype(String c_ctype) {
      this.c_ctype = c_ctype;
   }
   public String getC_indutype() {
      return c_indutype;
   }
   public void setC_indutype(String c_indutype) {
      this.c_indutype = c_indutype;
   }
   public String getC_deadline() {
      return c_deadline;
   }
   public void setC_deadline(String c_deadline) {
      this.c_deadline = c_deadline;
   }
   public String getC_comscale() {
      return c_comscale;
   }
   public void setC_comscale(String c_comscale) {
      this.c_comscale = c_comscale;
   }
   public String getC_content() {
      return c_content;
   }
   public void setC_content(String c_content) {
      this.c_content = c_content;
   }
   public int getC_hit() {
      return c_hit;
   }
   public void setC_hit(int c_hit) {
      this.c_hit = c_hit;
   }
   public String getC_logo() {
      return c_logo;
   }
   public void setC_logo(String c_logo) {
      this.c_logo = c_logo;
   }
   
   
}