package com.javalec.spring_ex2_3;

public class DivAndRemains {
	private int number;
	
	public void resultDiv(){
		if (number / 10 == number % 10) {
			System.out.println("10�� �ڸ��� 1�� �ڸ��� �����ϴ�.");
		} else {
			System.out.println("10�� �ڸ��� 1�� �ڸ��� �ٸ��ϴ�.");
			
		}
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
