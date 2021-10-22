package com.javalec.spring_ex7_3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainStudent {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX4.xml");
        Student student1 = ctx.getBean("student",Student.class);
        System.out.println("student1.getName() = " + student1.getName());
        System.out.println("student1.getAge() = " + student1.getAge());


        System.out.println("===========================================");
        Student student2 = ctx.getBean("student",Student.class);
        student1.setName("홍길자");
        student1.setAge(100);
        System.out.println("student1.getName() = " + student2.getName());
        System.out.println("student1.getAge() = " + student2.getAge());
    }
}
