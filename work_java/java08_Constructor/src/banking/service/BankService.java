package banking.service;

import banking.Customer;

/*
 * 고객을 저장하고
 * 관리하는 기능만을 모아놓은 서비스 클래스...
 * ~Service | ~Manage	| ~Manager
 */
public class BankService {

	public static final int MAX_CUSTOMER = 10;
	private Customer[] customers;
	private int numberOffCustomers;		// 고객 인덱스 
	
	public BankService()
	{
		customers = new Customer[MAX_CUSTOMER];
		numberOffCustomers = 0;
	}
	
	public void addCustomer(String f, String l)	// 인자값 알아서 주세요...
	{
		customers[numberOffCustomers++] = new Customer(f,l);
	}
	
	public int getNumOfCustomers()
	{
		return this.numberOffCustomers;
	}
	
	public Customer getCustomer(int index)
	{
		return customers[index];
	}
}
