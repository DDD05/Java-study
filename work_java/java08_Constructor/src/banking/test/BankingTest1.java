package banking.test;

import banking.Account;
import banking.Customer;

public class BankingTest1 {

	public static void main(String[] args) {
		
		Customer james = new Customer("james","chris");
		james.setAccount(new Account(100000,12345));
		
		james.getAccount().deposit(5000);
		james.getAccount().deposit(500);
		james.getAccount().deposit(8000);
		james.getAccount().withdraw(12000);
		james.getAccount().withdraw(40000);
		int output = (int) james.getAccount().getBalance();
		System.out.println(output);
		
		
		/*
		 * 1. Customer 객체를 생성 ... James
		 * 2. James가 통장을 하나 개설...12345, 100000
		 * 3. James가 개설한 통장을 하나 발급받아서
		 * 4. 통장을 지금부터 사용합니다...
		 * 		5000원 입금
		 * 		500원 입금
		 * 		8000원 입금
		 * 		12000원 출금
		 * 		40000원 출금
		 * 5. 최종적으로 James의 통장 잔액을 콘솔로 출력하는 로직을 작성
		 */
	}

}
