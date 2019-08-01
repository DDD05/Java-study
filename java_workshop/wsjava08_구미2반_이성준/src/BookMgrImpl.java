import java.util.ArrayList;
import java.util.List;

class BookMgrImpl implements IBookMgr{
	
	private static BookMgrImpl mgr = new BookMgrImpl();
	private List<Book> bookList;
	private BookMgrImpl() 
	{
		bookList = new ArrayList<Book>();
	}
	
	public static BookMgrImpl getInstance()
	{
		return mgr;
	}
	
	public void addBook(Book b)
	{
		bookList.add(b);
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
	
	public ArrayList<Book> searchBookByTitle(String title)
	{
		ArrayList<Book> bList = new ArrayList<>();
		
		for(Book b : bookList)
		{
			if(b != null && b.getTitle().contains(title))
			{
				bList.add(b);
			}
		}
		return bList;
	}
	
	public ArrayList<Book> getAllBook()
	{
		
		ArrayList<Book> bList = new ArrayList<>();
		for(Book b : bookList)
		{
			if(!(b instanceof Magazine))
			{
				bList.add(b);
			}
		}
		return bList;
	}
	
	public ArrayList<Book> getAllMagazine()
	{
		ArrayList<Book> bList = new ArrayList<>();
		for(Book b : bookList)
		{
			if(b instanceof Magazine)
			{
				bList.add(b);
			}
		}
		return bList;
	}
	
	public ArrayList<Book> searchBookByPublisher(String publisher)
	{
		ArrayList<Book> bList = new ArrayList<>();
		for(Book b : bookList)
		{
			if(b != null && b.getPublisher().contains(publisher))
			{
				bList.add(b);
			}
		}
		return bList;
	}
	
	public ArrayList<Book> searchBookByLowPrice(int price)
	{
		ArrayList<Book> bList = new ArrayList<>();
		for(Book b : bookList)
		{
			if(b != null && b.getPrice() <= price)
				bList.add(b);
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
		return sum/bookList.size();
	}

	@Override
	public ArrayList<Book> getAllOnlyBook() {
		ArrayList<Book> bList = new ArrayList<>();
		for(Book b : bookList)
		{
			if(!(b instanceof Magazine))
			{
				bList.add(b);
			}
		}
		return bList;
	}
}
