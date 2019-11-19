package com.ssafy.spring.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssafy.model.UserVO;

public class UserJUnitTest {

	@Test
	public void Unit() throws Exception
	{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession sqlSession = factory.openSession();
		
		UserVO user = new UserVO("test","123");
		
//		//addUser ok
//		sqlSession.insert("UserMapper.addUser",user);
//		sqlSession.commit();
		
		
//		//deleteUser ok
//		sqlSession.delete("UserMapper.deleteUser",user.getUserID());
//		sqlSession.commit();
		
//		//updateUser
//		sqlSession.update("UserMapper.updateUser",user);
//		sqlSession.commit();

		
		//isCheck ok
//		UserVO result = sqlSession.selectOne("UserMapper.isCheck",user);
//		System.out.println(result);
	}
}
