package com.ssafy.book;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbUtil.DBInfo;
import dbUtil.QueryInfo;

public class BookMgr  {
	// 싱글톤
		private static BookMgr bookDAO = new BookMgr(); 
		private BookMgr() {};
		public static BookMgr getInstance()
		{
			return bookDAO;
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
		
		//비지니스 로직 
		public void insertBook(String id , Book book) throws SQLException
		{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnect();
				
				String query = QueryInfo.insertBook;
				ps = conn.prepareStatement(query);
				
				
				ps.setString(1, book.getIsbn());
				ps.setString(2, book.getTitle());
				ps.setString(3, book.getCatalogue());	//
				ps.setString(4, book.getNation());
				ps.setString(5, book.getPublishDate());
				ps.setString(6, book.getPublisher());	//
				ps.setString(7, book.getAuthor());
				ps.setInt(8, book.getPrice());
				ps.setString(9, book.getCurrency());	//
				ps.setString(10, book.getDescription());
				System.out.println(ps.executeUpdate() + "행이 추가 되었습니다.");
				ps = conn.prepareStatement(QueryInfo.userByBook);
				ps.setString(1, id);
				ps.setString(2, book.getIsbn());
				ps.executeUpdate();
			}finally{
				try {
					closeAll(ps,conn);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		public List<Book> searchAll(String id) throws SQLException
		{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Book> list = new ArrayList<>();
			
			try
			{
				
			conn = getConnect();
			String query = QueryInfo.searchBookList;
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Book(rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("catalogue"),
						rs.getString("nation"),
						rs.getString("publishDate"),
						rs.getString("publisher"),
						rs.getString("author"),
						rs.getInt("price"),
						rs.getString("currency"),
						rs.getString("description")
						));
			}
			}finally {
				try {
					closeAll(rs,ps,conn);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
			return list;
		}
		public List<Book> searchByTitle(String title) throws SQLException
		{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Book> list = new ArrayList<>();
			
			try
			{
				
			conn = getConnect();
			String query ="SELECT * FROM book WHERE title=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Book(rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("catalogue"),
						rs.getString("nation"),
						rs.getString("publishDate"),
						rs.getString("publisher"),
						rs.getString("author"),
						rs.getInt("price"),
						rs.getString("currency"),
						rs.getString("description")
						));
			}
			}finally {
				try {
					closeAll(rs,ps,conn);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
			return list;
		}
		public List<Book> searchByPublisher(String publisher) throws SQLException
		{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Book> list = new ArrayList<>();
			
			try
			{
				
			conn = getConnect();
			String query ="SELECT * FROM book WHERE publisher=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, publisher);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Book(rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("catalogue"),
						rs.getString("nation"),
						rs.getString("publishDate"),
						rs.getString("publisher"),
						rs.getString("author"),
						rs.getInt("price"),
						rs.getString("currency"),
						rs.getString("description")
						));
			}
			}finally {
				try {
					closeAll(rs,ps,conn);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
			return list;
		}
		public List<Book> searchByPrice(int price) throws SQLException
		{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Book> list = new ArrayList<>();
			
			try
			{
				
			conn = getConnect();
			String query ="SELECT * FROM book WHERE price=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, price);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new Book(rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("catalogue"),
						rs.getString("nation"),
						rs.getString("publishDate"),
						rs.getString("publisher"),
						rs.getString("author"),
						rs.getInt("price"),
						rs.getString("currency"),
						rs.getString("description")
						));
			}
			}finally {
				try {
					closeAll(rs,ps,conn);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
			return list;
		}
		public Book search(String isbn) throws SQLException
		{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Book book = null;
			try
			{
				
			conn = getConnect();
			String query = QueryInfo.searchBookByIsbn;
			ps = conn.prepareStatement(query);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			if(rs.next())
			{
				book = new Book(rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("catalogue"),
						rs.getString("nation"),
						rs.getString("publishDate"),
						rs.getString("publisher"),
						rs.getString("author"),
						rs.getInt("price"),
						rs.getString("currency"),
						rs.getString("description")
						);
			}
			}finally {
				try {
					closeAll(rs,ps,conn);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
			return book;
		}
		public void update(Book b) throws SQLException
		{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnect();
				
				String query = QueryInfo.updateBook;
				ps = conn.prepareStatement(query);
				
				
				ps.setString(1, b.getTitle());
				ps.setString(2, b.getCatalogue());
				ps.setString(3, b.getNation());
				ps.setString(4, b.getPublishDate());
				ps.setString(5, b.getAuthor());
				ps.setInt(6, b.getPrice());
				ps.setString(7, b.getCurrency());
				ps.setString(8, b.getDescription());
				ps.setString(9, b.getIsbn());
				System.out.println(ps.executeUpdate() + "행이 수정 되었습니다.");
			}finally{
				try {
					closeAll(ps,conn);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		public void delete(String isbn) throws SQLException
		{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnect();
				
				String query = "DELETE FROM book WHERE isbn=?";
				ps = conn.prepareStatement(query);
				
				
				ps.setString(1, isbn);
				System.out.println(ps.executeUpdate() + "행이 삭제 되었습니다.");
			}finally{
				try {
					closeAll(ps,conn);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			}
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
}
