package com.ssafy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import config.ServerInfo;

public class Test {
	public static void printAllBooks(List<Book> list)
	{
		for(Book bTmp : list)
			System.out.println(bTmp);
	}
	public static void main(String[] args) {
		
		BookDAO dao = BookDAO.getInstance();
		
		try {
			
			// 데이터를 입력하세요.
			dao.insertBook(new Book("a1101",
					"JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000,"기본"));
			dao.insertBook(new Book("a1102",
					"JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000,"중급"));
			dao.insertBook(new Book("a1103",
					"JAVA 실전", "자앤 기술연구소", "자앤 출판사", 30000,"실전"));

			// 현재 도서 목록을 출력하세요.
			printAllBooks(dao.listBooks());
			
			// a1101 도서를 검색해보세요
			System.out.println(dao.findBook("a1101"));
			
			// a1104 도서를 추가하세요.
			dao.insertBook(new Book("a1104",
					"JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000,"심화"));

			// a1102 도서를 수정 후 목록을 출력하세요.
			dao.updateBook(new Book("a1101",
					"JAVA 기본", "자앤 기술연구소", "자앤 출판사", 20000,"기본"));
			printAllBooks(dao.listBooks());
			
			// a1103 도서를 삭제 후 목록을 출력하세요.
			dao.deleteBook("a1101");
			printAllBooks(dao.listBooks());
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	static 
	{
		try
		{
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("DB loading to memory..");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
			System.out.println("DB loading fail...");
		}
	}
}
