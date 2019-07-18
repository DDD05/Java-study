package com.java.first;

import java.util.Scanner;

/**
 * @author 이성준
 * @Date   2019. 7. 18.
 */
public class CheckPoint {
	private int weight;
	private int hight;
	public CheckPoint() {
		// TODO Auto-generated constructor stub
		Scanner input = new Scanner(System.in);
		this.hight = input.nextInt();
		this.weight = input.nextInt();
	}
	public void printing()
	{
		int obesity = this.weight + 100 - this.hight;
		System.out.printf("비만수치는 %d입니다.\n",obesity);
		if(obesity > 0)
		{
			System.out.println("당신은 비만이군요");
		}
	}
}
