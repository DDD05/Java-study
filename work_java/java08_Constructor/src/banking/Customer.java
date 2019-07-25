package banking;

public class Customer {
	private String firstName;
	private String lastName;
	private int ssn;
	private Account acct;
	
	public Customer(String f, String l)
	{
		this.firstName = f;
		this.lastName = l;
	}
	public void setSSN(int ssn)
	{
		this.ssn = ssn;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public Account getAccount()
	{
		return this.acct;
	}
	public void setAccount(Account acct)
	{
		this.acct = acct;
	}
	public String getCustomerInfo()
	{
		return this.lastName+" "+this.firstName+", "+ssn;
	}
}
