package com.ssafy.child;

import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

/*
 * 자식 클래스 ... Child, Sub Class
 */
public class Manager extends Employee {
	private String dept;

	public Manager(String name, double salary, MyDate birthDate, String dept) {
//		super();	 부모 기본 생성자 호출
		super(name,salary,birthDate);
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() +  ", Manager [dept=" + dept + "]";
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
