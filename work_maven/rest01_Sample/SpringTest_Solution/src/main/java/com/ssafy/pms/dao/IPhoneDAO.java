package com.ssafy.pms.dao;

import java.util.List;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;

public interface IPhoneDAO {
	int insert(Phone phone) throws Exception;
	int delete(List<String> list) throws Exception;
	Phone select(Phone phone) throws Exception;
	List<Phone> select() throws Exception;
	UserInfo select(UserInfo user) throws Exception;
}
