package staticexam.test;

public class StaticExamTest1 {
	static String name = "홍길동";
	int age = 19;
	String address = "진평동";
	
	static void member()
	{
		name = "김민정";	// static은 파일 로더 중에 메모리에 올라가지만 String name = "홍길동"; 은 실행 될 때 메모리가 할당된다.
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		static int value = 200;
		StaticExamTest1 test1 = new StaticExamTest1();
		System.out.println(StaticExamTest1.name);
		
		System.out.println(test1.name);
		test1.name = "hh";
		System.out.println(StaticExamTest1.name);
		StaticExamTest1.name = "ww";
		System.out.println(test1.name);
		
	}

}
