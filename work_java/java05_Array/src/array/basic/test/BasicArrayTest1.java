package array.basic.test;

class Person
{
	String name;
	int age;
}

public class BasicArrayTest1 {

	public static void main(String[] args) {
		Person p = new Person();
		
		// 1. 배열 선언 + 생성
		int[] arr = new int[3];	//사이즈 명시 ... 주소값 ... 묵시적 초기화
		for(int i = 0 ; i < arr.length ; i++)
		{
			System.out.println(arr[i] + " ");
		}
		System.out.println("배열의 주소값 :: "+arr);
		System.out.println("객체의 주소값 :: "+p);
		
		// 2. 명시적 초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		// 뭐가 어디에서 도는가?
		for(int n : arr)
		{
			System.out.println(n);
		}
		
		System.out.println("=======================================");
		
		arr = new int[5];
		arr[3]=44;
		arr[4]=55;
		
		for(int i : arr)
			System.out.println(i);
		
	}

}
