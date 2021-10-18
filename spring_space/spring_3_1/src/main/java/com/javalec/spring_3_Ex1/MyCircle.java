package com.javalec.spring_3_Ex1;

public class MyCircle {
	private Circle circle;
	private int radius;
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void ar() {
		circle.circleArea(radius);
	}
	

}
