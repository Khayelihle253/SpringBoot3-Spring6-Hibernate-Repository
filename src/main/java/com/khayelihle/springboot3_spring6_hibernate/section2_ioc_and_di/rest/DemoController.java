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
    /**
     * define the constructor for dependency injection (constructor injection)
     * - @Autowired annotation is optional when we have 1 constructor
     *
     * On object construction:
     *  - Coach theCoach = new CricketCoach();
     *  - DemoController demoController = new DemoController(theCoach);
     */
    @Autowired
    public DemoController(@Qualifier("swimmingTrainer") Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
