package com.ssafy.util;

public class MyDate {
	int year;
	int month;
	int day;
	public MyDate() {}
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
}
