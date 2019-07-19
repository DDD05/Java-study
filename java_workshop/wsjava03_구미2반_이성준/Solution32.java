package com.ssafy.algo;

import java.util.Scanner;

public class Solution32 {

	public static class Person
	{
		int i;
		int j;
		int cnt;
		int cal;
		public Person(int i , int j , int cnt, int cal)
		{
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.cal = cal;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int n,m,pNum;
			n = sc.nextInt();
			m = sc.nextInt();
			pNum = sc.nextInt();

			int[][] arr = new int[n+2][m+2];
			for(int i = 1; i<= n; i++)
			{
				for(int j = 1; j <= m ; j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Person[] p = new Person[pNum];
			for(int i = 0 ; i < pNum ; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt();
				p[i] = new Person(x,y,c,-1000);
			}
			int boom = sc.nextInt();
			for(int i = 0 ; i < boom ; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 0;
			}
			int sum = 0;
			for(Person tmpPerson : p)
			{
				boolean pass = true;
				while(tmpPerson.cnt > 0)
				{
					
					int x = tmpPerson.i;
					int y = tmpPerson.j;
					
					if(x <= 0 || x >= n+1 || y <= 0 || y >= m+1 )
					{
						pass = false;
						break;
					}
					
					int go = arr[x][y] / 10;
					int jump = arr[x][y]%10;
					
					if(go == 1)
					{
						tmpPerson.j += jump;
					}
					else if(go == 2)
					{
						tmpPerson.i += jump;
					}
					else if(go == 3)
					{
						tmpPerson.j -= jump;
					}
					else if(go == 4)
					{
						tmpPerson.i -= jump;
					}
					
					tmpPerson.cnt--;
				}
				int output = tmpPerson.cal;  
				if(pass)
					output += arr[tmpPerson.i][tmpPerson.j] * 100;
				
				sum += output;
			}
			System.out.println(sum);
			T--;
		}
		
		
	}

}
