package com.javalec.spring_ex6_3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainSinger {
    public static void main(String[] args) {
        String configLoc1 = "classpath:singerCTX.xml";
        String configLoc2 = "classpath:singerCTX2.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1, configLoc2);

        Singer singer1 = ctx.getBean("singer1", Singer.class);
        System.out.println("singer1.getName() = " + singer1.getName());
        System.out.println("singer1.getMember() = " + singer1.getMember());
        System.out.println("singer1.getSong() = " + singer1.getSong());
        System.out.println();


        SingerInfo singerInfo = ctx.getBean("singerInfo1", SingerInfo.class);
        Singer singer2 = singerInfo.getSinger();
        System.out.println("singer1.getName() = " + singer2.getName());
        System.out.println("singer1.getMember() = " + singer2.getMember());
        System.out.println("singer1.getSong() = " + singer2.getSong());

        Singer singer3 = ctx.getBean("singer3", Singer.class);
        System.out.println("singer1.getName() = " + singer3.getName());
        System.out.println("singer1.getMember() = " + singer3.getMember());
        System.out.println("singer1.getSong() = " + singer3.getSong());
        System.out.println();
    }
}
