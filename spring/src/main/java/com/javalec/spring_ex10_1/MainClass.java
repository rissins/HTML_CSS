package com.javalec.spring_ex10_1;

import com.javalec.spring_10_1.Student;
import com.javalec.spring_10_1.Worker;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX10.xml");
        Car car = ctx.getBean("car", Car.class);
        car.getCarInfo();
        Graphic graphic = ctx.getBean("graphic", Graphic.class);
        graphic.getGraphicInfo();
    }
}
