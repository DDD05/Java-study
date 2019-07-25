package com.ssafy.test;

import com.ssafy.child.Engineer;
import com.ssafy.child.Manager;
import com.ssafy.child.Secretary;
import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

public class InheritanceTest3 {
	public static void main(String[] args)
	{
		Employee e = new Employee("James",40000.0,new MyDate(1960,2,3));
		Manager m  = new Manager("Gosling",34000.0,new MyDate(1983,4,12),"개발부");
		
		
		Employee e1 = new Engineer("강호동",40000.0,new MyDate(1960,2,3), "오락부");
		Employee e2 = new Manager("제임스",45000.0,new MyDate(1964,4,3), "사업부");
		Employee e3 = new Secretary("이수근",65000.0,new MyDate(1950,2,12), "개발부");
		
		/*
		 * e1, e2 ,e3 객체변수는 Employee 타입으로 선언된 변수...
		 * 그렇기 때문에 Employee 클래스의 toString()이 호출된다... -name, birthDate, salary만 출력
		 * ::
		 * toString()이 상속관계의 클래스에서 오버라이딩되어진 매소드 이기 때문에
		 * 
		 * 부모타입으로 자식객체를 
		 * 
		 * Virtual Method Invocation
		 * 1) complie time type  -- -- 부모의 메소드를 호출
		 * 2) run time type --- --- 자식의 메소드를 호출
		 */
		Engineer eg = (Engineer)e1;
		eg.setBonus(300);
		
		Manager manager = (Manager)e2;
		m.setDept("기획부");
		System.out.println("========================Heterogeneous Collection=============================");
		System.out.println("========================이기종간의 집합체=============================");
		
		Employee[] earr = {e,m,e1,e2,e3};
		for(Employee emp : earr)
		{
			System.out.println(emp);
		}
		
		
		
	}
}

