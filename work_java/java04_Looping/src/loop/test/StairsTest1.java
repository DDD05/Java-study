package loop.test;

import java.util.Scanner;

public class StairsTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		stairscase(n);
	}

	private static void stairscase(int n) {	// 가독성
		// TODO Auto-generated method stub
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j <= i ; j++)
			{
				System.out.print("#");
			}
			System.out.println();
		}
	}

}
