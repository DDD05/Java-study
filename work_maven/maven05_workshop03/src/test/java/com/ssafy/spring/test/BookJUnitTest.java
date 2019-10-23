package com.ssafy.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssafy.model.BookVO;

public class BookJUnitTest 
{
	@Test
	public void unit() throws Exception
	{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession sqlSession = factory.openSession();
		
		BookVO book = new BookVO("77777-1231-1234", "C언어 함께 춤을", "댄싱", "한국", "2019-10-23", "2019-10-24", "돼에지", "1000", "너무너무 재미있당~");

		//findBookByTitle test ok
//		List<BookVO> list = sqlSession.selectList("bookMapper.findBookByTitle","Java");
//		for(BookVO b : list)
//			System.out.println(b);
		
		//deleteBook test
		
		
		//updateBook test
		
		
		//addBook test
		int result = sqlSession.insert("bookMapper.addBook",book);
		sqlSession.commit();
		System.out.println("result : " + result);
		
		// findAllBook test ok
//		List<BookVO> list = sqlSession.selectList("bookMapper.findAllBook");
//		for(BookVO b : list)
//			System.out.println(b);
	}
}
