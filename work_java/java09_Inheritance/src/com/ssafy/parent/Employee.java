package com.ssafy.parent;

import com.ssafy.util.MyDate;

/*
 * Employee에 대한 정보를 저장하고 있는 클래스
 */

public class Employee {
	private String name;
	private double salary;
	private MyDate birthDate;
	
	private Employee() {}
	public Employee(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", birthDate=" + birthDate + "]";
	}


	
	
}
