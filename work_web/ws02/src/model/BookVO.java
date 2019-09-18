package model;

public class BookVO {
	public String number;
	public String title;
	public String categori;
	public String from;
	public String publishDay;
	public String publisher;
	public String author;
	public String price;
	public String desc;
	public BookVO(String number, String title, String categori, String from, String publishDay, String publisher,
			String author, String price, String desc) {
		super();
		this.number = number;
		this.title = title;
		this.categori = categori;
		this.from = from;
		this.publishDay = publishDay;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.desc = desc;
	}
	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "BookVO [number=" + number + ", title=" + title + ", categori=" + categori + ", from=" + from
				+ ", publishDay=" + publishDay + ", publisher=" + publisher + ", author=" + author + ", price=" + price
				+ ", desc=" + desc + "]";
	}
}
