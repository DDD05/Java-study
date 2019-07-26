
public class Magazine extends Book{
	private Book book;
	private int year;
	private int month;
	public Magazine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
		// TODO Auto-generated constructor stub
	}
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc) {
		super(isbn, title, author, publisher, price, desc);
		// TODO Auto-generated constructor stub
	}
	public Magazine(Book book, int year, int month) {
		super();
		this.book = book;
		this.year = year;
		this.month = month;
	}
	@Override
	public String toString() {
		return "Magazine [book=" + book + ", year=" + year + ", month=" + month + "]";
	}

	
}
