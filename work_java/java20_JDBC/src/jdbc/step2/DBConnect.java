package jdbc.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

/*
 * step1에서는 디비서버에 대한 정보가 소스코드 상에 하드코딩되어져 있엇다.
 * 보안적/ 재사용적인 측면에서 지양되어져야 하는 부분.
 * ::
 * 해결책
 * 서버정보를 외부자원으로 모듈화시키자
 * 메타데이타
 */

public class DBConnect {
	public DBConnect()
	{
			try {
				//1. 드라이버 로딩
				Class.forName(ServerInfo.DRIVER_NAME);
				System.out.println("1. Driver Loading ....");

				//2. 디비서버 연결
				Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
				System.out.println("2. DB Server Connection Success ....");

				//3. PreparedStatement 생성... 쿼리문이 인자값으로 들어감.
				String query = "INSERT INTO MEMBER VALUES (?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);

				ps.setString(1, "( o .o) /) ~" );
				ps.setString(2, "빠그");
				ps.setString(3, "뭐야 월클이야 뭐야 mysql 플렉스 했지뭐야 ~");

				//4. 쿼리문 실행	
				ps.executeUpdate();
				System.out.println("3. INSERT INTO Success ....");

			} catch (ClassNotFoundException e) {
				System.out.println(e);
				System.out.println("1. Driver Loading Fail ....");
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("2. DB Server Connection Fail ....");
			}
//		}
	}
	public static void main(String[] args) {
		new DBConnect();
	}
}
