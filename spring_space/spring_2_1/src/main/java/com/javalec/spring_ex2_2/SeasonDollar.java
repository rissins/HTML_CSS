package com.javalec.spring_ex2_2;

public class SeasonDollar {
	
	public static void main(String[] args) {
		
		Season season = new Season();
		Won2dollar won2dollar = new Won2dollar();
		won2dollar.setMoney(3300);
		season.setMonth(9);
		
		season.printSeason();
		won2dollar.dollar();
	}
}
