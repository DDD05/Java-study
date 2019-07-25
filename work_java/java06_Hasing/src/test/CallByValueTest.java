package test;

import com.sun.org.apache.bcel.internal.generic.Type;

public class CallByValueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		System.out.println("call() 호출전 : a=" + a + ", b=" + b);
		call(a,b);	// calling...
		System.out.println("call() 호출후 : a=" + a + ", b=" + b);
		
	}
	
	public static void call(int a, int b)
	{
		int tmp = a;
		a = b;
		b = tmp;
	}

}
