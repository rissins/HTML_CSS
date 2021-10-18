package com.javalec.spring_ex2_5;

public class MultipleTriangle {
	public static void main(String[] args) {
		Multiple multiple = new Multiple();
		Triangle triangle = new Triangle();
		multiple.setNumber(255);
		triangle.setNumber1(8);
		triangle.setNumber2(3);
		triangle.setNumber3(9);
		
		multiple.process();
		triangle.process();
		
	}
}
