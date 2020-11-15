package vo;

import java.util.*;

/*기업명
공고 제목
지원 자격
근무 조건
마감일 등록일
경력
학력
근무형태
급여
근무일시
근무지역
내용
 *  MNO                                                NUMBER(3)
 TITLE                                              VARCHAR2(300)
 SINGER                                             VARCHAR2(100)
 ALBUM                                              VARCHAR2(200)
 POSTER                                             VARCHAR2(1000)
 STATE                                              CHAR(6)
 IDCREMENT                                          NUMBER(3)
 KEY          
  ccname VARCHAR2(100),
    cctype VARCHAR2(100),
    cindutype VARCHAR2(100),
    cdeadline VARCHAR2(100),
    ccomscale VARCHAR2(100),
    c_content CLOB,
    c_hit NUMBER(100),
    c_logo VARCHAR2(100)d                                      VARCHAR2(50)
 */
/*
 * do
name
title
app_qual1
app_qual2
deadline
sal
workspace
 */
public class WorkBVO {
   private int l_no;
   private String ldo;
   private int lcateno;
   private String lname;
   private String ltitle;
   private String lapp_qual1;
   private String lapp_qual2;
   private String lapp_con;
   private String ldeadline;
   private String lsal;
   private String lworkspace;
   private String l_like;
   public int getL_no() {
      return l_no;
   }
   public void setL_no(int l_no) {
      this.l_no = l_no;
   }
   public String getLdo() {
      return ldo;
   }
   public void setLdo(String ldo) {
      this.ldo = ldo;
   }
   public int getLcateno() {
      return lcateno;
   }
   public void setLcateno(int lcateno) {
      this.lcateno = lcateno;
   }
   public String getLname() {
      return lname;
   }
   public void setLname(String lname) {
      this.lname = lname;
   }
   public String getLtitle() {
      return ltitle;
   }
   public void setLtitle(String ltitle) {
      this.ltitle = ltitle;
   }

   public String getLapp_qual1() {
      return lapp_qual1;
   }
   public void setLapp_qual1(String lapp_qual1) {
      this.lapp_qual1 = lapp_qual1;
   }
   public String getLapp_qual2() {
      return lapp_qual2;
   }
   public void setLapp_qual2(String lapp_qual2) {
      this.lapp_qual2 = lapp_qual2;
   }
   
   public String getLapp_con() {
      return lapp_con;
   }
   public void setLapp_con(String lapp_con) {
      this.lapp_con = lapp_con;
   }
   public String getLdeadline() {
      return ldeadline;
   }
   public void setLdeadline(String ldeadline) {
      this.ldeadline = ldeadline;
   }
   public String getLsal() {
      return lsal;
   }
   public void setLsal(String lsal) {
      this.lsal = lsal;
   }
   public String getLworkspace() {
      return lworkspace;
   }
   public void setLworkspace(String lworkspace) {
      this.lworkspace = lworkspace;
   }
   public String getL_like() {
	   return l_like;
   }
   public void setL_like(String l_like) {
	   this.l_like = l_like;
   } 
}