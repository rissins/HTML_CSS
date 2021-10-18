package com.javalec.spring_ex2_1;

public class Rectangle {
	private int height;
	private int weight;
	
	
	
	public void rectangleArea() {
		System.out.println(height * weight);
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
