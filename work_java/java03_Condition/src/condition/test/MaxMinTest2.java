package condition.test;

import java.util.Random;

public class MaxMinTest2 {

	public static void main(String[] args) {
		String result = "";
		Random myRandom = new Random();
		
		System.out.println("======큰수? 혹은 작은수? =========");
		int num1 = myRandom.nextInt(100) +1;
		if(num1 > 50)
			result = "큰수";
		else 
			result = "작은수";
		
		System.out.printf("%d(은)는 %s이다.\n",num1,result);
		
		System.out.println("\n================================\n");
		System.out.println("===========짝수? 혹은 홀수?==============");
		
		int num2 = myRandom.nextInt(10);	// 0~9
		if(num2 % 2 == 0)
			result = "짝수";
		else 
			result = "홀수";
		
		System.out.printf("%d(은)는 %s이다.\n",num2,result);
		
		System.out.println("\n================================\n");
		System.out.println("===========삼항연산자==============");
		
		result = (num2 % 2 == 0) ? "짝수" : "홀수";
		System.out.printf("%d(은)는 %s이다.\n",num2,result);
	}

}
