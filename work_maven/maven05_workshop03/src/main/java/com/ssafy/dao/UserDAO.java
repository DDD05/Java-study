package com.ssafy.dao;

import com.ssafy.model.UserVO;

public interface UserDAO {
	void addUser(UserVO user) throws Exception;
	UserVO isCheck(UserVO user) throws Exception;
	void deleteUser(String id) throws Exception;
	void updateUser(UserVO user) throws Exception;
}
