package com.javalec.spring_10_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX9.xml");
        Student student = ctx.getBean("student", Student.class);
        student.getStudentInfo();
        Worker worker = ctx.getBean("worker", Worker.class);
        worker.getWorkerInfo();
    }
}
