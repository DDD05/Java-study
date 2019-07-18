package oop.test;

import oop.greeting.GreetMessage;
import oop.person.Person;

/*
 * Test 클래스 역할
 * ::
 * 1. GreetMessage, Person 클래스를 메모리에 올린다. (인스턴스화)
 * 		== 객체생성 , 사용할려고 
 * 2. 사용한다는 것은?
 * 		필드		-- 값할당(Initialization)
 * 		메소드	-- 호출(Calling)
 */
public class GreetingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GreetMessage gm = new GreetMessage();
		Person p = new Person();
		p.name = "이성준";
		p.toYou = "하승현 강사님";
		
		gm.message = "두번째 날입니다... 오늘도 화이팅!!";
		gm.greet();
		
		
	}

}
