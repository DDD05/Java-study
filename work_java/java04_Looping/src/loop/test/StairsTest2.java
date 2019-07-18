package loop.test;

import java.util.Scanner;

public class StairsTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		
		reverseStairs(n);
	
	
	
	
	
	
	
	}

	private static void reverseStairs(int n) {
		// TODO Auto-generated method stub
		for(int i = 1 ; i <= n ; i++)
		{
			String stair = "";
			for(int j = n ; j > 0 ; j--)
			{
				if(j > i)
					stair += " ";
				else
					stair += "#";
			}
			System.out.println(stair);
		}
		
	}

	

}
