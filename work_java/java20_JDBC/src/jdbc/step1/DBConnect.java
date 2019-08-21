package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * 데이터베이스 서버에 연결
 * 쿼리문을 실행하기 위한 준비작업을 위한
 * 로직을 작성
 * ::
 * 1. 서버에 대한 정보를 가지고 있는 Driver를 메모리에 로딩
 * 2. 디비서버에 연결 - - Connection 객체를 리턴 받는다. Connection conn = DriverManager.getConnection(url,user,pwd);
 * 3. PreparedStatement를 하나 생성 - - - PreparedStatement ps = conn.prepareStatement(sql); // 쿼리문이 컴파일된다.
 * 4. 쿼리문을 실행
 * 	1) int row = ps.executeUpdate() :: DML
 *  2) ResultSet rs = executeQuery() :: SELECT
 */
public class DBConnect {
	public DBConnect()
	{
		for(int i = 81 ; i <= 105 ; i++)
		{
		String url2 = "jdbc:mysql://192.168.32."+ String.valueOf(i) +":3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			try {
				//1. 드라이버 로딩
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("1. Driver Loading ....");

				//2. 디비서버 연결
				String url = url2;
//				String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
				String user = "root";
				String password = "1234";
				Connection conn = DriverManager.getConnection(url,user,password);
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
		}
	}
	public static void main(String[] args) {
		new DBConnect();
	}
}
