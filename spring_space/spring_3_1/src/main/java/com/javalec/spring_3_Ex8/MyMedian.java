package com.javalec.spring_3_Ex8;

public class MyMedian {
	private int number1;
	private int number2;
	private int number3;
	private Median median;
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public int getNumber3() {
		return number3;
	}
	public void setNumber3(int number3) {
		this.number3 = number3;
	}
	public Median getMedian() {
		return median;
	}
	public void setMedian(Median median) {
		this.median = median;
	}
	
	
	public void process() {
		median.process(number1, number2, number3);
	}
	

}
