package banking.test;

import banking.service.BankService;

public class BankingTest2 {

	public static void main(String[] args) {
		
		BankService service = new BankService();
		//1. 은행 고객을 5명정도 추가...
		//2. 고객의 명수만큼 for문을 돌면서 고객의 정보를 콘솔로 출력하는 로직을 작성
		
		service.addCustomer("일", "김");
		service.addCustomer("이", "박");
		service.addCustomer("삼", "이");
		service.addCustomer("사", "강");
		service.addCustomer("오", "신");
		for(int i = 0 ; i < 5 ; i++)
		{
			System.out.println(service.getCustomer(i).getCustomerInfo());
		}
	}

}
