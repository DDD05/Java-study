package com.ssafy.algo;

import java.util.Scanner;

class Salt 
{
	Salt(int _i ,int _j ,int _go)
	{
		i = _i;
		j = _j;
		go= _go;
	}
	int i;
	int j;
	int go;
}

public class Solution21 {
	public static void main(String[] args)
	{
		int[] cnt = { 3, 2, 1};
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tNum = 0 ; tNum < T ; tNum++)
		{
			
			
			
			int N  = sc.nextInt();
			int saltNum = sc.nextInt();
			boolean pass = true;
			
			Salt[] salt = new Salt[saltNum];
			int[][] arr = new int[N][N];
			for(int c = 0 ; c < saltNum ; c++)
			{
				int i = sc.nextInt();
				int j = sc.nextInt();
				int go = sc.nextInt();
				salt[c] = new Salt(i,j,go);
				arr[i][j] = 1;
			}
			
			aaa:for(int i = 0 ; i < salt.length ; i++)
			{
				Salt s = salt[i];
				for(int goCnt : cnt)
				{
					if(s.go == 1)
					{
						s.i += goCnt;
					}
					else
					{
						s.j += goCnt;
					}
					if(0 <= s.i && s.i < N &&
							0 <= s.j && s.j < N)
					{
						if(arr[s.i][s.j] == 1)
						{
							pass = false;
							System.out.printf("#%d %d\n",(tNum+1),(i+1));
							break aaa;
						}
						else
						{
							arr[s.i][s.j]++;
						}
					}
				}
			}
			
			if(pass == true)
				System.out.printf("#%d 0\n",(tNum+1));
		}
	}
}
