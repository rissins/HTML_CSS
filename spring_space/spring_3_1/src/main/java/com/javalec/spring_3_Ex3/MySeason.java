package com.javalec.spring_3_Ex3;

public class MySeason {
	private int month;
	private Season season;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	
	public void result() {
		season.rsltSeason(month);
	}
}
