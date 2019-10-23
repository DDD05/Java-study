package com.ssafy.service;

import java.util.List;

import com.ssafy.vo.MyProductVO;

public interface MyProductService {
	void addProduct(MyProductVO vo) throws Exception;
	List<MyProductVO> findAll() throws Exception;
	List<MyProductVO> findName(String name) throws Exception;
}
