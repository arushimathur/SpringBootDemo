package com.example.SpringBootDemo;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.example.SpringBootDemo.AlienController.getAliensNew())")
    public void logBefore()
    {
        LOGGER.info("getAliens method called from aspect");
    }


    //this will execute after the method execution irrespective of the error message.
    @After("execution(public * com.example.SpringBootDemo.AlienController.getAliensNew())")
    public void logAfter()
    {
        LOGGER.info("getAliens method called after");
    }


    //this will execute only after the successfull method execution, in case of error , will not be executed.
    @AfterReturning("execution(public * com.example.SpringBootDemo.AlienController.getAliensNew())")
    public void logAfterReturn()
    {
        LOGGER.info("getAliens method called after successfull executions");
    }


    //this will execute only in case of any  exception
    @AfterThrowing("execution(public * com.example.SpringBootDemo.AlienController.getAliensNew())")
    public void logAfterThrowing()
    {
        LOGGER.info("issue");
    }


}
