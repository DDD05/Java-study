package com.java.first;

import java.util.Scanner;

/**
 * @author 이성준
 * @Date   2019. 7. 18.
 */
public class Compute {
	private int fNum;
	private int sNum;
	public Compute()
	{
		Scanner input = new Scanner(System.in);
		this.fNum = input.nextInt();
		this.sNum = input.nextInt();
	}
	public int multi()
	{
		return this.fNum * this.sNum;
	}
	public int divi()
	{
		return this.fNum / this.sNum;
	}
	public void printing()
	{
		System.out.println("곱=" + multi());
		System.out.println("몫=" + divi());
	}
	
}
