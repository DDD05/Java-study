package com.ssafy.java;

/**
 * @author 이성준
 * @Date   2019. 7. 18.
 */
public class AlpaTest1 {
	private char alpa;
	public AlpaTest1() {
		// TODO Auto-generated constructor stub
		this.alpa = 'A';
	}
	public void print()
	{
		for(int i = 1 ; i <= 5 ; i++ )
		{
			for(int j = 1 ; j <= i ; j++)
			{
				System.out.printf("%c\t",this.alpa++);
			}
			System.out.println();
		}
	}
}
