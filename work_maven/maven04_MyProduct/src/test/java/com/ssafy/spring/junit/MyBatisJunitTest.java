package com.ssafy.spring.junit;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssafy.vo.MyProductVO;

// using class for MyBatis framework unit test   .... very important unit test. 
public class MyBatisJunitTest {
	
	@Test
	public void unit() throws Exception
	{
		Reader r = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		/*
		//Session이 쿼리문을 실행하는 메소드를 가지고 있다.
		MyProductVO pvo = new MyProductVO("손빨래 세탁기", "LG" , 5600000);
		session.insert("ProductMapper.addProduct",pvo);
		session.commit();
		
		System.out.println("Product Insert Ok");
		System.out.println(pvo.getId()+", " + pvo.getName());
		*/
		
		List<MyProductVO> list = session.selectList("ProductMapper.findAll", "세탁기");
		for(MyProductVO v : list)
			System.out.println(v);
	}
}
