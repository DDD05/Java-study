package com.ssafy.java;

import java.util.Arrays;

public class ArrayTest {
	private static int[] list;
	
	public static void print()
	{
		System.out.println(Arrays.toString(list));
		total();
		average();
		minimum();
	}
	public static void total()
	{
		int sum = 0;
		for(int i : list)
			sum += i;
		System.out.println("배열의 합 : " + sum);
	}
	public static void average()
	{
		int sum = 0;
		for(int i : list)
			sum += i;
		System.out.println("배열의 평균 : " + sum/list.length);
	}
	public static void minimum()
	{
		int minimum = 987654321;
		for(int i : list)
			if(minimum > i)
				minimum = i;
		System.out.println("배열의 최소값 : " + minimum);
	}
	public static void main(String[] args)
	{
		list = new int[] {34,23,64,25,12,75,22,88,53,37};
		print();
	}
}
