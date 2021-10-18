package com.javalec.spring_ex2_1;

public class Draw {
	public static void main(String[] args) {
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		
		circle.setRadius(10);
		rectangle.setHeight(20);
		rectangle.setWeight(30);
		
		circle.circleArea();
		rectangle.rectangleArea();
		
	}
}
