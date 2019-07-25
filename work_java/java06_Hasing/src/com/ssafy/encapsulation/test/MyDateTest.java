package com.ssafy.encapsulation.test;

import java.util.Scanner;

/*
 * Encapsulation에 대해서
 * Data(필드)를 보호하려는 목적 . /필드에 직접적으로 접근하는 것을 막아야 하낟.
 * 
 * 1. private - 필드 앞에 지정
 * 2. public void setXXX(o)
 * 		public XXX getXXX()
 *		메소드를 통해서 같은 클래스의 필드에 접근하는 통로를 만든다.
 * 3. setXXX() { 첫라인(필드 초기화 직전에)에서 제어문을 작성하여
 * 		타당한 값만 필드에 할당되도록 로직을 작성 
 */
class MyDate
{
	private int month;
	private int day;
	
	MyDate()
	{}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(0 < month && month <= 12)
		{
			this.month = month;
		}
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		int limitDay = 31;
		switch(month)
		{
		case 2: 
			limitDay = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			limitDay = 30;
			break;
		}
		if(limitDay - day >= 0)
			this.day = day;
	}
}
public class MyDateTest {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		int month, day;
		System.out.print("월 입력 :: ");
		month = sc.nextInt();
		System.out.print("일 입력 :: ");
		day = sc.nextInt();
		MyDate md = new MyDate();
		md.setMonth(month);
		md.setDay(day);
//		직접적으로 접근...필드에 접근... invalid한 값을 할당
//		md.setMonth(33);
//		md.setDay(22);
		
		/* 
		 * 1. Scanner를 이용해서 월 ,일에 해당하는 값을 직접 받으세요
		 * 2. setMonth(), setDay() 호출/ worker메소드에서 제어문을 잘 작성
		 * 	1,3,5,7,8,10,12 = 31
		 * 	2 = 28
		 * 	2,4,6,9,11 = 30
		 * 3. 오늘은 x월 x일 입니다. 정상적으로 출력
		 * 
		 * 예외) 33월 1일 ---> 잘못된 ~~~ 입니다
		 * 					0월 1일입니다... 이렇게 출력되지 않도록
		 */
		if(md.getMonth() == 0 || md.getDay() == 0)
			System.out.println(md.getMonth()+"월 	"+md.getDay()+"일은 잘못됬다");
		else
			System.out.println(md.getMonth()+"월 "+md.getDay()+"일은 잘됬다");
		
	}
}
