package com.javalec.spring_ex2_3;

public class Three {
	private int number;
	
	public void mulThree() {
		if (number % 3 == 0 ) {
			System.out.println("3�� ����Դϴ�.");
		} else { 
			System.out.println("3�� ����� �ƴմϴ�.");
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
