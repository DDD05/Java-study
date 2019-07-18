package com.java.first;
/**
 * @author 이성준
 * @Date   2019. 7. 18.
 */
public class CircleArea {
	private int circle_area;
	
	public CircleArea(int circle_area)
	{
		this.circle_area = circle_area;
	}
	public void printing()
	{ 
		System.out.printf("반지름이 %dCm인 원의 넓이는 %.2f*%dCm2입니다.\n",this.circle_area,Math.PI,this.circle_area);
	}
}
