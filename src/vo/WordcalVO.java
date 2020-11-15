package vo;
/*채용달력
WNO           NUMBER        
WLOC          VARCHAR2(100) 
WNAME         VARCHAR2(100) 
WDEADLINE     VARCHAR2(100) 
WSTARTDATE    VARCHAR2(100) 
WCOVER        VARCHAR2(100) 
WSITE         VARCHAR2(100) 
 */
public class WordcalVO {
   private int wno;
   private String wloc;
   private String wname;
   private String wdeadline;
   private String wstartdate;
   private String wcover;
   private String wsite;
   public int getWno() {
      return wno;
   }
   public void setWno(int wno) {
      this.wno = wno;
   }
   public String getWloc() {
      return wloc;
   }
   public void setWloc(String wloc) {
      this.wloc = wloc;
   }
   public String getWname() {
      return wname;
   }
   public void setWname(String wname) {
      this.wname = wname;
   }
   public String getWdeadline() {
      return wdeadline;
   }
   public void setWdeadline(String wdeadline) {
      this.wdeadline = wdeadline;
   }
   public String getWstartdate() {
      return wstartdate;
   }
   public void setWstartdate(String wstartdate) {
      this.wstartdate = wstartdate;
   }
   public String getWcover() {
      return wcover;
   }
   public void setWcover(String wcover) {
      this.wcover = wcover;
   }
   public String getWsite() {
      return wsite;
   }
   public void setWsite(String wsite) {
      this.wsite = wsite;
   }
   
}