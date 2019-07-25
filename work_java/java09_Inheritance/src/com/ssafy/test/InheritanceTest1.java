package com.ssafy.test;

import com.ssafy.child.Manager;
import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

class Test
{
	int aaa =0;
}
public class InheritanceTest1 {
	public static void main(String[] args)
	{
		Test t = new Test();
		System.out.println(t.hashCode());
		System.out.println(t.toString());
		
		Employee e = new Employee("James",40000.0,new MyDate(1960,2,3));
		Manager m  = new Manager("Gosling",34000.0,new MyDate(1983,4,12),"개발부");
		
		System.out.println(e.toString());
		System.out.println(m.toString());
	}
}
