package com.javalec.spring_ex2_5;

public class Multiple {
	private int number;
	
	public void process() {
		if (number % 3 == 0) {
			System.out.println("3�� ����Դϴ�.");
		}
		if (number % 5 == 0) {
			System.out.println("5�� ����Դϴ�.");
		}
		if (number % 8 == 0) {
			System.out.println("8�� ����Դϴ�.");
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
