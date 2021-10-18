package com.javalec.spring_ex2_3;

public class Three {
	private int number;
	
	public void mulThree() {
		if (number % 3 == 0 ) {
			System.out.println("3의 배수입니다.");
		} else { 
			System.out.println("3의 배수가 아닙니다.");
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
