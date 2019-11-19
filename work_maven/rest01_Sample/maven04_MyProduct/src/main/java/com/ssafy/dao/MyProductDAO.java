package com.ssafy.dao;

import java.util.List;

import com.ssafy.vo.MyProductVO;

// 메소드 이름은 mapping의 id , parameter type이 인자값, return type 반환형
public interface MyProductDAO {
	void addProduct(MyProductVO vo) throws Exception;
	List<MyProductVO> findAll() throws Exception;
	List<MyProductVO> findName(String name) throws Exception;
}
