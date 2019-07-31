package test;

import java.util.Scanner;

class SSAFYCompany{
	private String companyName = "";
//	1.
	private static SSAFYCompany ssafy = new SSAFYCompany();
	
//	2.
	private SSAFYCompany()
	{
		this.companyName = "SSAFY ASSCOIATION";
	}
	
//	3.
	public static SSAFYCompany getInstance()
	{
		return ssafy;
	}
}
public class SSAFYCompanyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SSAFYCompany com = SSAFYCompany.getInstance();
		System.out.println(com.hashCode());
		Scanner sc = new Scanner(System.in);	// system 역시 static 
	}

}
