package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

/*
 * G =2  가로 , 세로 , 대각선
 * B = 1 로 초기화 
 * 	나중에 업데이트
 */

public class Solution13 {
	public static class Idx
	{
		int i ;
		int j ;
		public Idx(int _i , int _j)
		{
			this.i = _i;
			this.j = _j;
		}
	}
	
	public static void main(String[] args)
	{
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int tNum =1;
		
		while(T > 0)
		{
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][] arr2 = new int[N][N];
			Stack<Idx> s = new Stack();
			Stack<Idx> s2 = new Stack();
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < N ; j++)
				{
					String tmp = sc.next();
					if(tmp.equals("G"))
					{
						arr[i][j]= arr2[i][j] = 2;
						s.push(new Idx(i,j));
					}
					else
					{
						arr[i][j] = arr2[i][j] = 1;
						s2.push(new Idx(i,j));
					}
				}
			}
			
//			for(int i = 0 ; i < N ; i++)
//			{
//				for(int j = 0 ; j < N ; j++)
//					System.out.print(arr[i][j] + " ");
//				System.out.println();
//			}
			
			int[] indexI = { 1,-1,0,0,1,1,-1,-1};
			int[] indexJ = { 0,0,1,-1,1,-1,1,-1};

			for(Idx index : s)
			{
//				System.out.println("i : " + index.i );
//				System.out.println("j : " + index.j );
				for(int i = 0 ; i < indexI.length; i++)
				{
					int checkI = index.i + indexI[i];
					int checkJ = index.j + indexJ[i];
//					System.out.println("index i : " + checkI );
//					System.out.println("index j : " + checkJ );
					if(checkI >= 0 && checkI < N && 
							checkJ >= 0 && checkJ < N)
					{
						arr[checkI][checkJ] = 2;
					}
				}
			}
			
	
			for(Idx index : s2)
			{
				if(arr[index.i][index.j] == 1)
				{
					int sum = 0;
					for(int i = 0 ; i < N ; i++)
					{
						if(arr2[index.i][i] == 1)
							sum++;
						if(arr2[i][index.j] == 1)
							sum++;
					}
					sum--;
					
					arr[index.i][index.j] = sum;
				}
			}
			
			int maximum = 0;
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < N ; j++)
					if(maximum < arr[i][j])
						maximum = arr[i][j];
			}
			
			System.out.println("#"+ (tNum++) +" "+maximum);
			T--;
		}
	}
}
