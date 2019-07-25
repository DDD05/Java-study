package banking;


/*
 * 오버로딩 :: 생성자 | 메소드
 * 하는 일은 같지만 ------------ 이름은 동일
 * 처리하는 데이터를 달리할때 쓰이는 기법 ---------인자값이 순서, 타입, 갯수중 하나라도 달라야한다.
 * 
 * 
 * this::
 * 1) 필드명과 로컬변수의 이름이 같을때 구분하기 위해서 필드앞에 지정
 * 		객체의 레퍼런스값을 가지고 있기 때문에 가능...
 * 2) this() ---- 생성자 앞에 쓰이는 this
 * 		하나의 클래스 내에서 또다른 생성자를 호출할때 사용
 */
public class Account {
	
	public final static int DEFAULT_ACCOUNT_NO = 111;
	public final static double DEFAULT_BALANCE_NO = 111;
	private double balance;
	private int accountNo;	//계좌번호
	
	public Account() 
	{
		this(DEFAULT_BALANCE_NO,DEFAULT_ACCOUNT_NO);
	}
	public Account(double init_balance)
	{
//		this.balance = init_balance;
		this(init_balance,DEFAULT_ACCOUNT_NO);
	}
	public Account(double init_balance , int accountNo)
	{
		this.balance = init_balance;
		this.accountNo = accountNo;
	}
	public double getBalance()
	{	return this.balance;	}
	public void deposit(double amt)
	{
		this.balance += amt;
	}
	public void withdraw(double amt)
	{
		if(amt <= balance)
		{
			this.balance -= amt;
		}
	}
	public int getAccountNo() {
		return accountNo;
	}
	
}
