import java.util.ArrayList;
import java.util.Arrays;

public class BookManager {
	private static final int MAX_SIZE = 10;
	private Book[] bookList = new Book[MAX_SIZE];
	private int index;
	
	public BookManager() {}
	
	public void addBook(Book b)
	{
		if(index < MAX_SIZE)
			bookList[index++] = b;
		else
			return;
	}
	
	public Book searchBookByIsbn(String isbn)
	{
		for(Book b : bookList)
		{
			if(b.getIsbn().equals(isbn))
				return b;
		}
		return null;
	}
	
	public Book[] searchBookByTitle(String title)
	{
		Book[] bList = new Book[MAX_SIZE];
		int idx = 0;
		
		for(Book b : bookList)
		{
			if(b != null && b.getTitle().contains(title))
			{
				bList[idx++] = b;
			}
		}
		return bList;
	}
	
	public Book[] getAllBook()
	{
		
		Book[] bList = new Book[MAX_SIZE];
		int idx = 0;
		
		for(Book b : bookList)
		{
			if(!(b instanceof Magazine))
			{
				bList[idx++] = b;
			}
		}
		return bList;
	}
	
	public Book[] getAllMagazine()
	{
		Book[] bList = new Book[MAX_SIZE];
		int idx = 0;
		
		for(Book b : bookList)
		{
			if(b instanceof Magazine)
			{
				bList[idx++] = b;
			}
		}
		return bList;
	}
	
	public Book[] searchBookByPublisher(String publisher)
	{
		Book[] bList = new Book[MAX_SIZE];
		int idx = 0;
		
		for(Book b : bookList)
		{
			if(b != null && b.getPublisher().contains(publisher))
			{
				bList[idx++] = b;
			}
		}
		return bList;
	}
	
	public Book[] searchBookByLowPrice(int price)
	{
		Book[] bList = new Book[MAX_SIZE];
		int idx = 0;
		
		for(Book b : bookList)
		{
			if(b != null && b.getPrice() <= price)
				bList[idx++] = b;
		}
		return bList;
	}
	
	public int getSumPrice()
	{
		int sum = 0;
		for(Book b : bookList)
		{
			if(b != null)
				sum += b.getPrice();
		}
		return sum;
	}
	
	public int getAvgPrice()
	{
		int sum = getSumPrice();
		return sum/this.index;
	}
	
}

