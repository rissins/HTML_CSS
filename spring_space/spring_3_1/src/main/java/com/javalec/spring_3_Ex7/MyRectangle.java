package com.javalec.spring_3_Ex7;

public class MyRectangle {
	private int x;
	private int y;
	private Rectangle rectangle;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public void proces() {
		rectangle.process(x, y);
	}
}
