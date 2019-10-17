package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;

/*
 * 
 * Service Layer Component
 * ::
 * Service Layer는 데이타를 조작, 가동하는 것과 연관된 레이어
 * 대표적으로 페이징처리가 여기에 해당된다.
 * 
 */

public interface UserService {
	
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	User getUser(String user) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
