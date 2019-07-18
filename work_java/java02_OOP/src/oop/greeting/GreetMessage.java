package oop.greeting;

/*
 * 인사말의 정보와 기능을 담고 있는 클래스...
 */
// 자바의 클래스의 구성 요소 : 필드, 메소드
public class GreetMessage {	//Camel case
	// 자바 용어 ( 필드  ) , 맴버변수
	public String message = "방가방가";	//초기화(initialization) : 새로운 값을 할당
										// 암시적 초기화, 명시적 초기화
	
	public GreetMessage() {}	//구성요소로 포함하지 않는다.. (그냥 메소드)
	
	//	선언부 + 구현부 = 정의
	public String greet()	//메소드의 선언부 ( 선언 타입, 매개변수(parameter) , 이름 )
	{
		return message;	// 메소드의 구현부 (body)
	}
	
	
	
}
