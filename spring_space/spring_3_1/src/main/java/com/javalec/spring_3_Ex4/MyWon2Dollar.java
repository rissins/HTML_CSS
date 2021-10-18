package com.javalec.spring_3_Ex4;

public class MyWon2Dollar {
	private int money;
	private Won2Dollar won2Dollar;
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Won2Dollar getWon2Dollar() {
		return won2Dollar;
	}
	public void setWon2Dollar(Won2Dollar won2Dollar) {
		this.won2Dollar = won2Dollar;
	}
	
	public void exch() {
		won2Dollar.exchange(money);
	}

}
