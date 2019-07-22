package day3;

public class RecursionTest {
	public static int sum1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1부터 10까지의 숫자를 차례로 출력하라
		for(int i = 1 ; i <= 10; i++)
		{
			System.out.println(i);
		}
		printNum(10);
		
		int sum = 0;
		for(int i = 0; i <= 10 ; i++)
		{
			sum += i;
		}
		System.out.println(sum);
		
		
		System.out.println();
		sum = doSum(10);
		System.out.println(sum);
	
		doSum1(100);
		System.out.println("sum1 : " + sum1);
		
//		1부터 n까지의 곱의 결과를 구하여라
//		5 => 5 * 4* 3 * 2 * 1		5!
		
		int result = 1;
		for(int i = 5 ; i >= 1; i--)
		{
			result *= i;
		}
		System.out.println("result1 : " + result);
		
		int result2 = 1;
		result2 = factory(5);
		System.out.println("result2 : " + result2);
		
//		1! = 1 0! => 1
//		-3!
//		숫자의 각 자릿수의 합을 구하여 출력하라
		int num = 12345;
		result = 0;
		int remainder;
		while(num > 10)
		{
			remainder = num % 10;
			result += num;
			num /= 10;
		}
		
		result = digitSum(12345,0);
		System.out.println(result); 	//15
//		result = digitSum2(12345);
		System.out.println(result); 	//15
	
//		피보나치 수열
//		1,1,2,3,5,8,13,21
//		8번째ㅑ 수는?
		int n = 8;
		result = fibo(n);
		System.out.println("fibo : " + result);
		
		fiboFor(5);
		
//		자릿수를 입력받아서 모든 가능한 이진수 문자열을 출력하라 (재귀로)
//		3
//		000 001 010 011 100 101 110 111
		doMakeBinary("",0);
	}
//	자릿수를 입력받아서 모든 가능한 이진수 문자열을 출력하라 (재귀로)
//	3
//	000 001 010 011 100 101 110 111
	public static void doMakeBinary(String str, int cnt)
	{
		if(cnt == 3)
			System.out.println("str : " + str);
		else
		{
			doMakeBinary(str+"0",cnt+1);
			doMakeBinary(str+"1",cnt+1);
		}
	}
	
	/*
	 * 피보나치 반복문
	 */
	public static void fiboFor(int num)
	{
		int[] ar = new int[2];
		ar[0] = ar[1] = 1;
		for(int i = 0 ; i < num-1 ; i++)
		{
			int f = 0;
			for(int j = 0 ; j < 2; j++)
			{
				f += ar[j];
			}
			ar[0] = ar[1];
			ar[1] = f;
		}
		
		System.out.println("ar[0] : " + ar[0]);
	}
	
	/*
	 * 피보나치 재귀함수
	 */
	public static int fibo(int num)
	{
		if(num == 0 || num == 1)
			return 1;
		return fibo(num-1)+fibo(num-2);
	}
	
	/*
	 * 각 자릿수의 합을 구하는 함수
	 */
	public static int digitSum2(int num)
	{
		int sum = num%10;
		sum += digitSum2(num/10);
		return sum;
	}
	static int digitSum(int num, int sum)
	{
		if(num == 0)
			return sum;
		int nam = num % 10;
		int mok = num / 10;
		sum += nam;
		return digitSum(mok,sum);
	}
	
	/*
	 * Factory함수
	 */
	static int factory(int n)
	{
//		종료 조건
		if(n == 0 || n == 1)
			return 1;
//		한번에 한번씩 실행할 내용
//		같은 이름의 메소드 재호출
		
		return n * factory(n-1);
	}
	
	/*
	 * 1. void형의 참조의 의한 변수 값 변경
	 * 2. return값을 이용한 변수 값 변경
	 */
	public static void doSum1(int a)
	{
		if( a <= 0)
			return;
		
		sum1 += a;
		doSum1(a-1);
	}
	
	public static int doSum(int a)
	{
		if(a <= 0)
			return 0;
		
		
		return doSum(a-1) + doSum(a-2) + doSum(a-3)	;
	}

	/*
	 * 이것이 재귀함수이다.
	 * 재귀함수를 사용한다면 종료시점을 먼저 만들어라.
	 */
	static void printNum(int num)
	{
//		기저대역 (base , case)
		if(num <= 0)
		{
			return;
		}
		
		System.out.println(num);
		
		printNum(num-1);
	}

}
