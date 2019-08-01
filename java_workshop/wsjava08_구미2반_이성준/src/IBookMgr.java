import java.util.ArrayList;

public interface IBookMgr {
	public void addBook(Book b);
	public Book searchBookByIsbn(String isbn);
	public ArrayList<Book> searchBookByTitle(String title);
	public ArrayList<Book> getAllBook();
	public ArrayList<Book> getAllOnlyBook();
	public ArrayList<Book> getAllMagazine();
	public ArrayList<Book> searchBookByPublisher(String publisher);
	public ArrayList<Book> searchBookByLowPrice(int price);
	public int getSumPrice();
	public int getAvgPrice();
}
