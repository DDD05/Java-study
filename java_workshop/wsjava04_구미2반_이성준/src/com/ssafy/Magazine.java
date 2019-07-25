package com.ssafy;

public class Magazine {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int month;
	private int price;
	private String desc;
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Magazine [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", year=" + year + ", month=" + month + ", price=" + price + ", desc=" + desc + "]";
	}
}
