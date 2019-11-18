package ibatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO
{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert("User10.addUser" , user);
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update("User10.updateUser" , user);
		return 0;
	}

	@Override
	public int removeUser(String user) throws Exception {
		int result = sqlSession.delete("User10.removeUser" , user);
		return 0;
	}

	@Override
	public User getUser(String user) throws Exception {
		return  sqlSession.selectOne("User10.getUser" , user);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return  sqlSession.selectList("User10.getUserList" , user);
	}
	
}
