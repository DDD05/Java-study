package staticexam.test;

public class StaticExamTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main method static block ........"+i);

	}
	static
	{
		StaticExamTest3.i++;
		System.out.println("static 초기화 (Initializtion) block -..........."+StaticExamTest3.i);
	}
	static int i;
}
