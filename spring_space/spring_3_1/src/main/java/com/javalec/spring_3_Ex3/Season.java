package com.javalec.spring_3_Ex3;

public class Season {
	public void rsltSeason(int month) {
		if (month == 3 || month == 4 || month == 5) {
			System.out.println("봄");
		}
		if (month == 6 || month == 7 || month == 8) {
			System.out.println("여름");
		}
		if (month == 9 || month == 10 || month == 11) {
			System.out.println("가을");
		}
		if (month == 12 || month == 1 || month == 2) {
			System.out.println("겨울");
		}
	}
}
