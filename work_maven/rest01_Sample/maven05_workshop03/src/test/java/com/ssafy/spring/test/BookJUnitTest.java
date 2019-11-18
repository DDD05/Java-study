package com.ssafy.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssafy.dao.BookDAOImpl;
import com.ssafy.model.BookVO;

public class BookJUnitTest 
{
	@Test
	public void unit() throws Exception
	{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession sqlSession = factory.openSession();
		
		BookVO book = new BookVO("3-3-3", "DDD 함께 노래를", "댄싱", "한국", "2019-10-23", "2019-10-24", "돼에지", 1000,"원", "너무너무 재미있당~");

		
		//deleteBook test ok
//		sqlSession.delete("BookMapper.deleteBook","2-2-2");
//		sqlSession.commit();
		
		//updateBook test ok
//		sqlSession.update("BookMapper.updateBook",book);
//		sqlSession.commit();
		
//		//addBook test ok
//		int result = sqlSession.insert("bookMapper.addBook",book);
//		sqlSession.commit();
//		System.out.println("result : " + result);
//		
//		//findBookByTitle test ok
//		List<BookVO> list = sqlSession.selectList("bookMapper.findBookByTitle","Java");
//		for(BookVO b : list)
//			System.out.println(b);
		
		// findAllBook test ok
		List<BookVO> list = sqlSession.selectList("BookMapper.findAllBook");
		for(BookVO b : list)
			System.out.println(b);
	}
}
