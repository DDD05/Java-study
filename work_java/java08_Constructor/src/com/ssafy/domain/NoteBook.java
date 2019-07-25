package com.ssafy.domain;

import com.ssafy.util.MyDate;

/*
 * 필드에 앖이 주입되는통로
 * 1) setter
 * 2) 명시적 생성자
 */
public class NoteBook {
	private String maker;
	private String brandName;
	private int price;
	
	public NoteBook() {}	//worker.. 기본생성자
	public NoteBook(String maker, String brandName ,int price)	// 명시적 생성자
	{
		super();
		this.maker = maker;
		this.brandName = brandName;
		this.price = price;
	}
	public void setNoteBookInfo(String maker , String brandName, int price)
	{
		// 필드 초기화
		this.maker = maker;
		this.brandName = brandName;
		this.price = price;
	}
	
	public String getNoteBookInfo()
	{
		return maker+","+brandName+","+price;
	}
}
