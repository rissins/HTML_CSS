package com.javalec.spring_ex6_5;

import com.javalec.spring_ex6_4.Animation;
import com.javalec.spring_ex6_4.AnimationInfo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainNasdaq {
    public static void main(String[] args) {
        String configLoc1 = "classpath:nasdaqCTX.xml";
        String configLoc2 = "classpath:nasdaqCTX2.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1, configLoc2);

        Nasdaq nasdaq1 = ctx.getBean("nasdaq1", Nasdaq.class);
        System.out.println("singer1.getName() = " + nasdaq1.getStock());
        System.out.println("singer1.getMember() = " + nasdaq1.getNumber());
        System.out.println("singer1.getSong() = " + nasdaq1.getModel());
        System.out.println();


        NasdaqInfo nasdaqInfo = ctx.getBean("nasdaqInfo1", NasdaqInfo.class);
        Nasdaq nasdaq2 = nasdaqInfo.getNasdaq();
        System.out.println("singer1.getName() = " + nasdaq2.getStock());
        System.out.println("singer1.getMember() = " + nasdaq2.getNumber());
        System.out.println("singer1.getSong() = " + nasdaq2.getModel());

        Nasdaq nasdaq3 = ctx.getBean("nasdaq3", Nasdaq.class);
        System.out.println("singer1.getName() = " + nasdaq3.getStock());
        System.out.println("singer1.getMember() = " + nasdaq3.getNumber());
        System.out.println("singer1.getSong() = " + nasdaq3.getModel());
        System.out.println();
    }
}
