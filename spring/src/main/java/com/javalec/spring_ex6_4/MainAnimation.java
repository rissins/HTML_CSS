package com.javalec.spring_ex6_4;

import com.javalec.spring_ex6_3.Singer;
import com.javalec.spring_ex6_3.SingerInfo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAnimation {
    public static void main(String[] args) {
        String configLoc1 = "classpath:animationCTX.xml";
        String configLoc2 = "classpath:animationCTX2.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1, configLoc2);

        Animation animation1 = ctx.getBean("animation1", Animation.class);
        System.out.println("singer1.getName() = " + animation1.getTitle());
        System.out.println("singer1.getMember() = " + animation1.getMember());
        System.out.println("singer1.getSong() = " + animation1.getDate());
        System.out.println();


        AnimationInfo animationInfo = ctx.getBean("animationInfo1", AnimationInfo.class);
        Animation animation2 = animationInfo.getAnimation();
        System.out.println("singer1.getName() = " + animation2.getTitle());
        System.out.println("singer1.getMember() = " + animation2.getMember());
        System.out.println("singer1.getSong() = " + animation2.getDate());

        Animation animation3 = ctx.getBean("animation3", Animation.class);
        System.out.println("singer1.getName() = " + animation3.getTitle());
        System.out.println("singer1.getMember() = " + animation3.getMember());
        System.out.println("singer1.getSong() = " + animation3.getDate());
        System.out.println();
    }
}
