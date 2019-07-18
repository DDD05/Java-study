package scanner.test;

import java.util.Scanner;

public class ScannerTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		// nextLine 과 next
		// sc.nextLine();
		// String nextLine = sc.nextLine();
		String next = sc.next();
		
		double num3 = sc.nextDouble();
		
		System.out.println(num1 + "," + num2 + "," + num3);
		
	}

}
