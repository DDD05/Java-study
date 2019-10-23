package  com.ssafy.model;

public class BookVO {
	public String isbn;
	public String title;
	public String categori;
	public String nation;
	public String publishDay;
	public String publisher;
	public String author;
	public String price;
	public String description;
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookVO(String isbn, String title, String categori, String nation, String publishDay, String publisher,
			String author, String price, String description) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.categori = categori;
		this.nation = nation;
		this.publishDay = publishDay;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.description = description;
	}
	@Override
	public String toString() {
		return "BookVO [isbn=" + isbn + ", title=" + title + ", categori=" + categori + ", nation=" + nation
				+ ", publishDay=" + publishDay + ", publisher=" + publisher + ", author=" + author + ", price=" + price
				+ ", description=" + description + "]";
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
	public String getCategori() {
		return categori;
	}
	public void setCategori(String categori) {
		this.categori = categori;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPublishDay() {
		return publishDay;
	}
	public void setPublishDay(String publishDay) {
		this.publishDay = publishDay;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
