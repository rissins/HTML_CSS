package com.javalec.spring_6_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc1 = "classpath:applicationCTX.xml";
		String configLoc2 = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1, configLoc2);
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());
		System.out.println(student3.getHobbys());
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamaName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
	}
}
