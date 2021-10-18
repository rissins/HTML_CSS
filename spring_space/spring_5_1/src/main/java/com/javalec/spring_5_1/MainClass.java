package com.javalec.spring_5_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.getStudent();
		
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2);
		studentInfo.getStudent();
		
		ctx.close();
	}

}
