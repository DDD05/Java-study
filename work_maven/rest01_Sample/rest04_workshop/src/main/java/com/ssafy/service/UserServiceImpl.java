package com.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.UserDAO;
import com.ssafy.model.UserVO;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDAO dao;
	
	@Override
	public void addUser(UserVO user) throws Exception {
		dao.addUser(user);
	}

	@Override
	public UserVO isCheck(UserVO user) throws Exception {
		return dao.isCheck(user);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		dao.deleteUser(id);
	}

	@Override
	public void updateUser(UserVO user) throws Exception {
		dao.updateUser(user);
	}

}
