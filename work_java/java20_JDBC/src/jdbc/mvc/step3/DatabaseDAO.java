package jdbc.mvc.step3;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class DatabaseDAO implements Serializable {
	private static DatabaseDAO dao = new DatabaseDAO();
	private DatabaseDAO() {};
	public static DatabaseDAO getInstance()
	{
		return dao;
	}
	// 고정적으로 반복되는 기능을 정의... 비지니스 로직에서는 정의된 기능을 호출....
	public Connection getConnect() throws SQLException
	{
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("디비연결 성공....");
		
		return conn;
	}
	public void closeAll(PreparedStatement ps , Connection conn) throws SQLException
	{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps , Connection conn) throws SQLException
	{
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	//비지니스 로직을 정의
	public void addMemeber(Member mem) throws SQLException
	{
		/*
		 * 디비서버 연결 ... Connection
		 * PreparedStatement 생성 ... 쿼리문 작성
		 * 바인딩
		 * 쿼리문 수행
		 */
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "INSERT INTO member VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, mem.getId());
			ps.setString(2, mem.getName());
			ps.setString(3, mem.getAddress());
			System.out.println(ps.executeUpdate()+ " row insert ok!!!");
		}finally
		{
			closeAll(ps, conn);
		}
		
	}
	public ArrayList<Member> getAllMember() throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();
		
		try
		{
			conn = getConnect();

			String query = "SELECT * FROM member";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				list.add(new Member(id,name,address));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}
	public void updateMember(Member mem) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();

			String query = "UPDATE member SET name=?, address=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, mem.getName());
			ps.setString(2, mem.getAddress());
			ps.setString(3, mem.getId());
			System.out.println(ps.executeUpdate() + " row UPDATE OK !!!");
			
		}finally {
			closeAll(ps, conn);
		}
	}
	public void removeMember(Member mem) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnect();
			
			String query = "DELETE FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, mem.getId());
			System.out.println(ps.executeUpdate() + " row DELETE OK !!!");
		}finally{
			closeAll(ps,conn);
		}
	}
}
