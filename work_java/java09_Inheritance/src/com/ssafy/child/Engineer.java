package com.ssafy.child;

import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

public class Engineer extends Employee {
	private String tech;
	private int bonus;

	public Engineer(String name, double salary, MyDate birthDate, String tech) {
		super(name,salary,birthDate);
		this.tech = tech;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString() + " Engineer [tech=" + tech + ", bonus=" + bonus + "]";
	}
	
	
}
