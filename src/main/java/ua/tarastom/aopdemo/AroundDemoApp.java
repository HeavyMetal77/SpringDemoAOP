package ua.tarastom.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.tarastom.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println(fortuneService.getFortune());

        applicationContext.close();
    }
}
