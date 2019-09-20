package com.ssafy.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbUtil.DBInfo;

public class LoginDAO  {
	// 싱글톤
			private static LoginDAO loginDAO = new LoginDAO(); 
			private LoginDAO() {};
			public static LoginDAO getLoginDAOInstance()
			{
				return loginDAO;
			}
			
			public Connection getConnect() throws SQLException
			{
				Connection conn = DriverManager.getConnection(DBInfo.URL,DBInfo.USER,DBInfo.PASSWORD);
				System.out.println("디비 연결 성공~");
				
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
			static {
				try {
					Class.forName(DBInfo.DRIVER_NAME);
					System.out.println("드라이버 로딩 성공...");
				}catch(ClassNotFoundException e)
				{
					System.out.println("드라이버 로딩 실패...");
				}
			}
			public boolean loginCheck(String user, String pass) throws SQLException
			{
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				boolean result = false;
				
				try
				{
					
				conn = getConnect();
				String query = "SELECT * FROM User WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, user);
				rs = ps.executeQuery();
				if(rs.next())
				{
					if(pass.equals(rs.getString("pwd")))
						result = true;
				}
				}finally {
					try {
						closeAll(rs,ps,conn);
					}catch(Exception e)
					{
						System.out.println(e);
					}
				}
				System.out.println(result);
				return result;
			}
			public static void main(String[] args) throws SQLException
			{
				LoginDAO dao = getLoginDAOInstance();
				System.out.println(dao.loginCheck("ssafy", "1111"));
			}
}
