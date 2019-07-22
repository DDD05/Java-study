package day3;

public class BitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int b = 7;
//		00000111
//		00001000
//		--------
//		
		System.out.println("output : " + (b<<-1));
		
		
		int a = 100;	// 10진수
		System.out.println(a);
		a = 0x100;	// 16진수
		System.out.println(a);
		a = 0100;	// 8진수
		System.out.println(a);
		a = 0b100;	// 2진수
		System.out.println(a);
	}

}
