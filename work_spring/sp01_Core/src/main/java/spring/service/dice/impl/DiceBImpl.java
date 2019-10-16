package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceBImpl implements Dice{

	///Field
	private int value;
	
	

	public DiceBImpl() {
		System.out.println(getClass().getName() + "() 생성자 호출 ....");
	}
	public DiceBImpl(int value) {
		super();
		this.value = value;
	}
	@Override
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;		
	}

}
