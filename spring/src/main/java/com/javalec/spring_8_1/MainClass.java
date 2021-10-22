package com.javalec.spring_8_1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx =  new GenericXmlApplicationContext();
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
        System.out.println(env.getProperty("admin.id"));
        System.out.println(env.getProperty("admin.pw"));

        GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
        gCtx.load("applicationCTX5.xml");
        gCtx.refresh();
        AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
        System.out.println("id = "+adminConnection.getAdminId());
        System.out.println("pw = "+adminConnection.getAdminPw());


    }
}
