package ua.tarastom.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.tarastom.aopdemo.service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService fortuneService = applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("\nMain Program: AroundDemoApp");

        myLogger.info("Calling getFortune");

        boolean flag= true;

        String data = fortuneService.getFortune(flag);

        myLogger.info("\nMy fortune is: " + data);

        myLogger.info("Finished");

        applicationContext.close();
    }
}
