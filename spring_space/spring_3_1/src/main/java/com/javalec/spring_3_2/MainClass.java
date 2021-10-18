package com.javalec.spring_3_2;

public class MainClass {
	public static void main(String[] args) {
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());

		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);

		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	}
}
