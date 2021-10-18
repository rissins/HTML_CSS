package com.javalec.spring_3_Ex8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainMedian {
	public static void main(String[] args) {
		String configLog = "classpath:medianCTX.xml";
		AbstractApplicationContext ctx = new  GenericXmlApplicationContext(configLog);
		MyMedian myMedian = ctx.getBean("myMedian", MyMedian.class);
		myMedian.process();
	}
}
