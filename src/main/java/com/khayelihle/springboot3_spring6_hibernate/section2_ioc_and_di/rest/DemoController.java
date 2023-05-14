package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.rest;

import com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Struct;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach myCoach;

    private Coach anotherCoach;

    /**
     * define the constructor for dependency injection (constructor injection)
     * - @Autowired annotation is optional when we have 1 constructor
     *
     * On object construction:
     *  - Coach theCoach = new CricketCoach();
     *  - DemoController demoController = new DemoController(theCoach);
     */
    @Autowired
    public DemoController(@Qualifier("rugbyCoach") Coach myCoach,
                          @Qualifier("rugbyCoach") Coach anotherCoach) {
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    //daily workout endpoint
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    //check the beans scopes
    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach " + (myCoach == anotherCoach); //Singleton:true & Prototype:false
    }
}
