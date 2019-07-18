package condition.test;

import java.util.Scanner;

public class ParentWithTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "";	// 메소드 블락 안에서 선언... 지역(로컬 변수)... 반드시 초기화 한다.
								// 로컬 변수는 기본값이 없기 때문에 초기화를 해주어야한다.
								// 전역 변수는 초기값이 존재
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력...");
		int age = sc.nextInt();
		
		System.out.println("보호자가 동반합니까?");
		boolean withParent = sc.nextBoolean();
		/*
		 * 19세 초과라면 ~세, 관람 가능합니다.
		 * 
		 * 19세 이하라면
		 * 	부모동반했다면 관람가능
		 *	부모동반 안했다면 관람불가
		 *	를 출력
		 *	if/ else if /else 
		 */
		if(age > 19)
			message = age + "세, 관람가능합니다.";
		else
		{
			if(withParent)
				message = "부모동반 "+ age +"세, 관람가능합니다.";
			else
				message = "부모 노동반" + age + "세, 관람불가능합니다.";
		}
		
		System.out.printf("나이: %d, 보호자 동반여부 : %b, 결과: %s",age,withParent,message);
	}

}
