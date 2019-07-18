package condition.test;

import java.util.Scanner;

/*
 * Operator
 * ::
 * 
 */
public class PatternGaneTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String result = "";
		boolean check = false;
		if((num / 10) % 3 == 0)
		{
			result += "@";
			check = true;
		}
		if((num % 10) % 3 == 0)
		{
			result += "@";
			check = true;
		}
		
		if(check)
			System.out.println(result);
		else
			System.out.println(num);
	}

}
