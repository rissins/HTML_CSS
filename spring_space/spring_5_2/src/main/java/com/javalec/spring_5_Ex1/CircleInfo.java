package com.javalec.spring_5_Ex1;

public class CircleInfo {
	private Circle circle;


	
	
	public CircleInfo(Circle circle) {
		this.circle = circle;
	}

	public void getCircleInfo() {
		if (circle != null) {
			System.out.println("������ :" + circle.getRadius());
			System.out.println("���Ǹ��� : " + circle.process());
		}
	}


	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	
}
