package com.javalec.spring_3_Ex7;

public class Rectangle {
	public void process(int x, int y) {
		
		if ((100 < x && x < 200) && (100 < y && y < 200)) {
			
			System.out.println(x+","+y+"�� �ȿ� �ֽ��ϴ�..");
		} else {
			System.out.println(x+","+y+"�� �ȿ� �����ϴ�..");
		}
	}

}
