package vo;
/* intreview 테이블 (면접후기)
INO      NOT NULL NUMBER        //리뷰번호
ISCORE   NOT NULL VARCHAR2(50)  //면접난이도
IREGDATE NOT NULL VARCHAR2(100) //작성일
IQ       NOT NULL CLOB          //면접질문
IA       NOT NULL CLOB          //면접답변
IREVIEW           CLOB          //면접후기
IRESULT           VARCHAR2(10)   //면접결과
 */
public class IntVO {
   private int ino;
   private String iscore;
   private String iregdate;
   private String iq;
   private String ia;
   private String ireview;
   private String iresult;
   public int getIno() {
      return ino;
   }
   public void setIno(int ino) {
      this.ino = ino;
   }
   public String getIscore() {
      return iscore;
   }
   public void setIscore(String iscore) {
      this.iscore = iscore;
   }
   public String getIregdate() {
      return iregdate;
   }
   public void setIregdate(String iregdate) {
      this.iregdate = iregdate;
   }
   public String getIq() {
      return iq;
   }
   public void setIq(String iq) {
      this.iq = iq;
   }
   public String getIa() {
      return ia;
   }
   public void setIa(String ia) {
      this.ia = ia;
   }
   public String getIreview() {
      return ireview;
   }
   public void setIreview(String ireview) {
      this.ireview = ireview;
   }
   public String getIresult() {
      return iresult;
   }
   public void setIresult(String iresult) {
      this.iresult = iresult;
   }
   
   
   
}