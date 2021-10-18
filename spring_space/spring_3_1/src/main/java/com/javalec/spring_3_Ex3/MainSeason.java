package com.javalec.spring_3_Ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainSeason {
	public static void main(String[] args) {
		String configLog = "classpath:seasonCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLog);
		MySeason mySeason = ctx.getBean("mySeason", MySeason.class);
		mySeason.result();
	}
}
