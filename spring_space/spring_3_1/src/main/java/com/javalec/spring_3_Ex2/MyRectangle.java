package com.javalec.spring_3_Ex2;

public class MyRectangle {
	private int height;
	private int width;
	private Rectangle rectangle;
	
	
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void ar() {
		rectangle.area(height, width);
	}
}
