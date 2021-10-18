package com.javalec.spring_3_Ex4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWon2Dollar {
	public static void main(String[] args) {
		String configLoc = "classpath:won2DollarCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyWon2Dollar myWon2Dollar = ctx.getBean("myWon2Dollar",MyWon2Dollar.class);
		myWon2Dollar.exch();
	}
}
