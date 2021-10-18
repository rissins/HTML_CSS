package com.javalec.spring_ex2_5;

public class Triangle {
	private int number1;
	private int number2;
	private int number3;
	
	public void process() {
		if (number1 > number2 && number1 > number3) {
			if (number1 < number2+number3) {
				System.out.println("삼각항이 됩니다.");
			} else {
				System.out.println("삼각형이 안됩니다.");
			}
		}
		if (number2 > number2 && number2 > number3) {
			if (number2 < number1+number3) {
				System.out.println("삼각항이 됩니다.");
			} else {
				System.out.println("삼각형이 안됩니다.");
			}
		}
		if (number3 > number2 && number3 > number1) {
			if (number3 < number2+number1) {
				System.out.println("삼각항이 됩니다.");
			} else {
				System.out.println("삼각형이 안됩니다.");
			}
		}
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public int getNumber3() {
		return number3;
	}

	public void setNumber3(int number3) {
		this.number3 = number3;
	}
	
	
	
}
