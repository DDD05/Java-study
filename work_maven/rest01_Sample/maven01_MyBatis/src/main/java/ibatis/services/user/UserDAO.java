package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;

//비즈니스 로직의 템플릿
//메소드 이름은 mapping10.xml의 쿼리문 id값으로 한다..
public interface UserDAO {
	
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String user) throws Exception;
	User getUser(String user) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
