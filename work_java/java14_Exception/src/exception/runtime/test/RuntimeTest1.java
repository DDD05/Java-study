package exception.runtime.test;

import sun.reflect.generics.tree.ArrayTypeSignature;

public class RuntimeTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] message = 
			{
					"Hello java",
					"No, I mean it",
					"Good Morning"
			};
		
		int i = 0;
		while(i <= 3)
		{
			try {
				System.out.println(message[i]);
			}catch(ArithmeticException e){
				System.out.println(e);
			}finally {
				System.out.println("i :  " + i);
			}
			i++;
		}
		
		System.out.println("hello");
	}//main

}
