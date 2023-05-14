package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * For prototype scope, there will be a new object for each injection, unlike singleton which uses
 * or points to only one instance.
 *
 * Prototype beans are lazy by default. There is no need to use the @Lazy annotation for prototype scopes beans.
 */
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class RugbyCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Play rugby for 1 hour";
    }

    //define the init method
    @PostConstruct
    public void doStartupStuff(){
        System.out.println("In the init method: "+getClass().getSimpleName());
    }

    //define the destroy method
    @PreDestroy
    public void doCleanupStuff(){
        System.out.println("In the destroy method: "+getClass().getSimpleName());
    }
}
