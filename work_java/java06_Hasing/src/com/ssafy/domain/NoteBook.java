package com.ssafy.domain;

import com.ssafy.util.MyDate;

public class NoteBook {
	String maker;
	String brandName;
	int price;
	
	public NoteBook() {}	//worker.. 기본생성자

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
