package com.ssafy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;

public class BookDAO {
	private static BookDAO dao = new BookDAO();
	private BookDAO() {}
	public static BookDAO getInstance()
	{		return dao;		}
	public Connection getConntion() throws SQLException 
	{
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("DB Connection Success !!");
		return conn;
	}
	public void close(Connection connection) throws SQLException
	{
		if(connection != null) connection.close();
	}
	public void close(Statement statement) throws SQLException
	{
		if(statement != null) statement.close();
	}
	public void close(ResultSet resultSet) throws SQLException
	{
		if(resultSet != null) resultSet.close();
	}
	public void insertBook(Book book) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = getConntion();
			String query = "INSERT INTO book VALUES(?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublisher());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getDescription());
			System.out.println(ps.executeUpdate() + " row insert success !! ");
		}
		finally
		{
			close(ps);
			close(conn);
		}
	}
	public void updateBook(Book book) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			conn = getConntion();
			String query = "UPDATE book "
					+ "SET title=?, author=?, publisher=?, price=?, description=? "
					+ "WHERE isbn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getIsbn());
			System.out.println(ps.executeUpdate() + " row update success !!");
		}finally{
			close(ps);
			close(conn);
		}
	}
	public void deleteBook(String isbn) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			 conn = getConntion();
			 String query = "DELETE FROM book WHERE isbn=?";
			 ps = conn.prepareStatement(query);
			 ps.setString(1, isbn);
			 System.out.println(ps.executeUpdate() + " row delete success !!");
		}finally {
			close(ps);
			close(conn);
		}
	}
	public Book findBook(String isbn) throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		try
		{
			conn = getConntion();
			String query = "SELECT * FROM book WHERE isbn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			if(!rs.next())  
			{ 
				System.out.println("do not find isbn...");
			}
			else
			{
				book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
			}
		}finally {
			close(rs);
			close(ps);
			close(conn);
		}
		return book;
	}
	public List<Book> listBooks() throws SQLException
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<>();
		try
		{
			conn = getConntion();
			String query = "SELECT * FROM book";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())  
			{ 
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
				list.add(book);
			}
		}finally {
			close(rs);
			close(ps);
			close(conn);
		}
		return list;
	}
	public int count() throws NumberFormatException, SQLException
	{	
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<>();
		int count = 0;
		try
		{
			conn = getConntion();
			String query = "SELECT COUNT(*) Count FROM book;";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			count = rs.getInt("Count");
		}finally {
			close(rs);
			close(ps);
			close(conn);
		}
		return count;
	}
}
