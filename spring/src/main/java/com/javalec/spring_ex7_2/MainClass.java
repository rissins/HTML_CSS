package com.javalec.spring_ex7_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:applicationCTX3.xml");
        ctx.refresh();
        ctx.close();
    }
}
