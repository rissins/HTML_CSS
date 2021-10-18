package com.javalec.spring_3_Ex8;

public class Median {
	public void process(int number1, int number2, int number3) {
		if (number2 > number1 && number2 < number3) {
			System.out.println(number2);
		} else if (number1 > number2 && number1 < number3) {
			System.out.println(number1);
		} else if (number3 > number1 && number3 < number2) {
			System.out.println(number3);
		}
		
	}

}
