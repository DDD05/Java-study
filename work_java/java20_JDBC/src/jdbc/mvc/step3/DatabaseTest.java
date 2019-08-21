package jdbc.mvc.step3;

import java.sql.SQLException;

import config.ServerInfo;

public class DatabaseTest {

	public static void main(String[] args) {

		DatabaseDAO dao = DatabaseDAO.getInstance();
		try
		{
			dao.addMemeber(new Member("333","아이유","여의도"));
		}catch(SQLException e){
			System.out.println(e);
		}
		try {
			for(Member m : dao.getAllMember())
				System.out.println(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dao.updateMember(new Member("333","에이유","여의도"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			dao.removeMember(new Member("333","에이유","여의도"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
		}catch(ClassNotFoundException e)
		{
			System.out.println("드라이버 로딩 실패...");
		}
	}
}
