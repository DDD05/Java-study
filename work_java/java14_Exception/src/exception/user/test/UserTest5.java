package exception.user.test;

class ZeroBoom extends Exception
{
	ZeroBoom(){	
		this("zeroBoom");
	}
	ZeroBoom(String str)
	{
		super(str);
	}
}
class User{
	public void solv(int i, int j) throws ZeroBoom
	{
		System.out.println("solv() call...");
		
		if(j==0)	//  ArithmeticException 을 여기서 발생시켜라!
			throw new ZeroBoom("yaya");
		
		System.out.println("ing...");
		System.out.println(i/j);
		// 연산... (i/j)
	}
}
public class UserTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			user.solv(1, 0);
		}catch(ZeroBoom e)
		{
			System.out.println(e);
		}
	}

}
