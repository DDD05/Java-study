package day3;

public class BitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte a = 13 ,	b = 7;
//		00001101		00000111
		System.out.println(b<<3);	//b * (2^n)
		int c = a & b;
//		00001101
//		00000111 And
//		------------
//		00000101
		
		boolean flag = a > 20 && ++b > 3;	//짧은 단위의 연산 ( 앞의 수식이 거짓이면 뒤의 수식은 계산하지 않고 넘어간다. )
		System.out.println(flag + ", " + b);
		
		boolean flag2 = a > 20 && bbb() > 3;	//짧은 단위의 연산 ( 앞의 수식이 거짓이면 뒤의 수식은 계산하지 않고 넘어간다. )
		System.out.println(flag2 + ", " + b);

		// 짧은 단위의 연산의 응용
		String s = null;
		if(s != null && s.length() >= 10)
		{
			System.out.println("짧은 단위 연산의 출력 테스트");
		}
		
	}
	static int bbb()
	{
		return 0;
	}

}
