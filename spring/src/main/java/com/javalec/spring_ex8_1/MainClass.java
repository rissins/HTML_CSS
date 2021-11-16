package com.javalec.spring_ex8_1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();

        try {
            propertySources.addLast(new ResourcePropertySource("classpath:oracle.account"));
            System.out.println(env.getProperty("emp.id"));
            System.out.println(env.getProperty("emp.pw"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
        gCtx.load("applicationCTX6.xml");
        gCtx.refresh();
        EmpConnection empConnection = gCtx.getBean("empConnection", EmpConnection.class);
        System.out.println("empConnection.getEmpId() = " + empConnection.getEmpId());
        System.out.println("empConnection.getEmpPw() = " + empConnection.getEmpPw());

    }
}
