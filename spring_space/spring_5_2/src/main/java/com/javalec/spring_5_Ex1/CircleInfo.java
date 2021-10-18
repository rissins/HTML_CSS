package com.javalec.spring_5_Ex1;

public class CircleInfo {
	private Circle circle;


	
	
	public CircleInfo(Circle circle) {
		this.circle = circle;
	}

	public void getCircleInfo() {
		if (circle != null) {
			System.out.println("반지름 :" + circle.getRadius());
			System.out.println("원의면적 : " + circle.process());
		}
	}


	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	
}
