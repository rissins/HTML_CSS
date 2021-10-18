package com.javalec.spring_ex2_2;

public class Won2dollar {
	private int money;
	
	public void dollar() {
		System.out.println("$"+(money / 1200.0));
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
