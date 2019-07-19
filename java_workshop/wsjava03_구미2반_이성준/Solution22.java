package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

public class Solution22 {

	public static class Salt
	{
		int i;
		int j;
		int go;
		int die;
		Salt(int _i, int _j , int _go, int _die)
		{
			i=_i;
			j = _j;
			go=_go;
			die=_die;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); int tNum = 1;
		
		while(T>0)
		{
			int N = sc.nextInt();
			int saltNum = sc.nextInt();
//			int[][] arr= new int[N+2][N+2];
			Salt[] salt = new Salt[saltNum];
//			for(int i = 0 ; i< N+2 ; i++)
//			{
//				arr[0][i] = 1;
//				arr[N+1][i] = 1;
//				arr[i][0] = 1;
//				arr[i][N+1]= 1;
//			}
			
			for(int k = 0 ; k < saltNum ; k++)
			{
				int i = sc.nextInt();
				int j = sc.nextInt();
				int go = sc.nextInt();
				salt[k] = new Salt(i,j,go,0);
			}
			int[] jump = {3,2,1};
			aaa:for(Salt s : salt)
			{
				for(int j : jump)
				{
//					System.out.println("salt : "+ s.i + " " + s.j + " " + s.go + "die : " + s.die );
//					System.out.println("j" + j);
					if(s.die == 1 )
					{
//						System.out.println("죽은애");
						continue aaa;
					}
					if(s.go == 1)
					{
						s.i -= j;
					}
					else if(s.go == 2)
					{
						s.i += j;
					}
					else if(s.go == 3)
					{
						s.j -= j;
					}
					else if(s.go == 4)
					{
						s.j += j;
					}
					if(s.i >= 0 && s.i < N && s.j >= 0 && s.j < N)
					{
						for(Salt s2 : salt)
						{
							if(!s2.equals(s))
								if(s.i == s2.i && s.j == s2.j)
									s.die = 1;
						}
					}
					else 
						s.die = 1;
				}
			}
			int saltCnt = 0;
			for(Salt s3 : salt)
				if(s3.die == 0)
					saltCnt++;
			
			System.out.println("#"+(tNum++) + " " +saltCnt);
			T--;
		}
	}

}
