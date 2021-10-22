package com.javalec.spring_ex7_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx= new GenericXmlApplicationContext();
        ctx.load("applicationCTX2.xml");
        ctx.refresh();
        Student student = ctx.getBean("student", Student.class);
        System.out.println("student.getName() = " + student.getName());
        System.out.println("student.getAge() = " + student.getAge());
        ctx.close();
    }
}
