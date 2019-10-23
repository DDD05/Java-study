package com.ssafy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.UserVO;

@Repository
public class UserDAOImpl implements UserDAO 
{
	private String ns = "UserMapper.";
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void addUser(UserVO user) throws Exception {
		sqlSession.insert(ns+"addUser",user);
	}

	@Override
	public UserVO isCheck(UserVO user) throws Exception {
		return sqlSession.selectOne(ns+"isCheck",user);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		sqlSession.delete(ns+"deleteUser",id);
	}

	@Override
	public void updateUser(UserVO user) throws Exception {
		sqlSession.update(ns+"updateUser",user);
	}

}
