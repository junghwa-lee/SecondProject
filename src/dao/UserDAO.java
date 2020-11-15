package dao;


import java.nio.channels.SeekableByteChannel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.UserformVO;

public class UserDAO {
	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	/*
	  <select id="userIdcheck" resultType="int" parameterType="string">
	    SELECT COUNT(*) FROM userform
	    WHERE id=#{id}
	  </select>
	*/
	public static int userIdCheck(String id)
	{
		SqlSession session=ssf.openSession();
		int count=session.selectOne("userIdcheck", id);
		session.close();
		return count;
	}
	
	//<insert id="userInsert" parameterType="vo.UserformVO">
	 public static void userInsert(UserformVO vo)
	 {
		 SqlSession session=ssf.openSession(true);
		 session.insert("userInsert", vo);
		 session.close();
	 }
	 
	 public static UserformVO userLogin(String id,String pwd)
	  {
		  UserformVO vo=new UserformVO();
		  SqlSession session=ssf.openSession();
		  int count=session.selectOne("userIdcheck", id);
		  if(count==0)
		  {
			  vo.setMsg("NOID");
		  }
		  else
		  {
			  UserformVO dVO=session.selectOne("userLogin", id);
			  if(pwd.equals(dVO.getPwd()))
			  {
				  vo.setMsg("OK");
				  vo.setId(dVO.getId());
				  vo.setName(dVO.getName());
				  vo.setAdmin(dVO.getAdmin());
			  }
			  else
			  {
				  vo.setMsg("NOPWD");
			  }
		  }
		  session.close();
		  
		  return vo;
	  }
	 
	 
	 //수정할 데이터 읽기
	 public static UserformVO userUpdateData(String id)
	 {
		 UserformVO vo=new UserformVO();
		 SqlSession session=ssf.openSession();
		 vo=session.selectOne("userUpdate_ok",id); 
		 session.close();
		 return vo;
	 }
	 
	 //수정하기
	 public static void userUpdate(UserformVO vo)
	 {
		 SqlSession session=ssf.openSession();
		 session.update("userUpdate", vo);
		 session.commit();
		 session.close();
	 }
}
