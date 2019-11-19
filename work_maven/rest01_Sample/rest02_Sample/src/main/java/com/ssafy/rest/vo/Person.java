package com.ssafy.rest.vo;

public class Person {
	private String name;
	private String addr;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, String add) {
		super();
		this.name = name;
		this.addr = add;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", add=" + addr + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String add) {
		this.addr = add;
	}
	
}
