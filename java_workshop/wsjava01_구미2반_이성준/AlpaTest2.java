package com.ssafy.java;

/**
 * @author 이성준
 * @Date   2019. 7. 18.
 */
public class AlpaTest2 {
	private char alpa;
	public AlpaTest2() {
		// TODO Auto-generated constructor stub
		this.alpa = 'A';
	}
	public void print()
	{
		for(int i = 1 ; i <= 5 ; i++ )
		{
			for(int j = 5 ; j >= 1 ; j--)
			{
				if(i >= j)
					System.out.printf("%c\t",this.alpa++);
				else
					System.out.printf("\t");
			}
			System.out.println();
		}
	}
}
