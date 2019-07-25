package com.ssafy.child;

import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

public class Secretary extends Employee {
	private String bossOfName;

	public Secretary(String name, double salary, MyDate birthDate, String bossOfName) {
		super(name,salary,birthDate);
		this.bossOfName = bossOfName;
	}


	@Override
	public String toString() {
		return super.toString() +  ", Secretary [bossOfName=" + bossOfName + "]";
	}
	
	
}
