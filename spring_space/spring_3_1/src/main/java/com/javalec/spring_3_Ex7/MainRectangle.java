package com.javalec.spring_3_Ex7;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainRectangle {
	public static void main(String[] args) {
		String configLoc = "classpath:rectangleCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyRectangle rectangle = ctx.getBean("myRectangle", MyRectangle.class);
		rectangle.proces();
	}
}
 