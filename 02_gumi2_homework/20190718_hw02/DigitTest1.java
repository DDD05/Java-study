package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(true)
		{
			int tmp = sc.nextInt();
			if(tmp == 0)
				break;
			arr.add(tmp);
		}
		int[] counting = new int[10];
		for(int i = 0 ; i < arr.size() ; i++)
		{
			if(arr.get(i) < 10)
				counting[0]++;
			else
				counting[arr.get(i)/10]++;
		}
		
		for(int i = 0 ; i < counting.length ; i++)
			if(counting[i] != 0)
				System.out.println(i+" : " + counting[i] + "개");
		
	}
}
