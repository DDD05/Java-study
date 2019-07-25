package test;

class Call
{
	int value;
	Call(int value)
	{
		this.value = value;
	}
}

public class CallByReferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Call c1 = new Call(10);
		Call c2 = new Call(20);
		
		System.out.println("call() 호출전 : c1=" + c1.value + ", c2=" + c2.value);
		System.out.println(c1);
		call(c1,c2);	// calling...
		System.out.println("call() 호출후 : c1=" + c1.value + ", c2=" + c2.value);
		
		
		
	}

	private static void call(Call c1, Call c2) {
		System.out.println(c1);
		// TODO Auto-generated method stub
		int tmp = c1.value;
		c1.value = c2.value;
		c2.value = tmp;
	}

}
