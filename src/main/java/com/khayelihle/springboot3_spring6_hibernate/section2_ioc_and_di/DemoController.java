package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach myCoach;

    /**
     * define the constructor for dependency injection (constructor injection)
     * - @Autowired annotation is optional when we have 1 constructor
     *
     * On object costruction:
     *  - Coach theCoach = new CricketCoach();
     *  - DemoController demoController = new DemoController(theCoach);
     */
    @Autowired
    public DemoController(Coach myCoach) {
        this.myCoach = myCoach;
    }

    //daily workout endpoint
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
