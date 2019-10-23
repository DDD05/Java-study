package com.ssafy.service;


import com.ssafy.model.UserVO;

public interface UserService 
{
	void addUser(UserVO user) throws Exception;
	UserVO isCheck(UserVO user) throws Exception;
	void deleteUser(String id) throws Exception;
	void updateUser(UserVO user) throws Exception;
}
