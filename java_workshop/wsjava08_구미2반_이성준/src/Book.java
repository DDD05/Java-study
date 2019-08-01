
public class Book {

	private String isbn;	// 도서 번호
	private String title;	// 도서명
	private int price;		// 가격
	private int quantity;	// 재고
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String isbn, String title, int price, int quantity)
	{
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void plusQuantity(int quantity)
	{
		this.quantity += quantity;
	}
	public void minusQuantity(int quantity) throws QuantityException
	{
		if(this.quantity < quantity)
			throw new QuantityException();
		this.quantity -= quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		String output = "\t" + this.getClass().getName() + "\tisbn= " + isbn + "\ttitle= " + title + "\t\tprice= " + price + "\tquantity= " + quantity;
		if(!(this instanceof Magazine))
			output = "\t" + this.getClass().getName() + "\t\tisbn= " + isbn + "\ttitle= " + title + "\t\tprice= " + price + "\tquantity= " + quantity + "\n";
		return output;
	}
	
	

}
