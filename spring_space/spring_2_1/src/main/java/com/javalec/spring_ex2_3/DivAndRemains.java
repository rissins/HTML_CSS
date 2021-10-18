package com.javalec.spring_ex2_3;

public class DivAndRemains {
	private int number;
	
	public void resultDiv(){
		if (number / 10 == number % 10) {
			System.out.println("10의 자리와 1의 자리가 같습니다.");
		} else {
			System.out.println("10의 자리와 1의 자리가 다릅니다.");
			
		}
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
