package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.rest;

import com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /**
     * Field injection...no longer cool, it has fallen out of favor
     *  - It makes the code harder to unit test.
     *  - hence the spring.io team no longer recommends this type of injection, however it is still used in legacy projects
     * @return
     *
     * Field injection is accomplished by injecting the dependency by setting field values on the class directly (as shown below)
     *  - even 'private' fields and this is accomplished by java reflection, no need for constructors or setter methods.
     */
    @Autowired
    private Coach myCoach;

//    //define a private field for the dependency
//    private Coach myCoach;
//
//    /**
//     * define the constructor for dependency injection (constructor injection)
//     * - @Autowired annotation is optional when we have 1 constructor
//     *
//     * On object construction:
//     *  - Coach theCoach = new CricketCoach();
//     *  - DemoController demoController = new DemoController(theCoach);
//     */
//    @Autowired
//    public DemoController(Coach myCoach) {
//        this.myCoach = myCoach;
//    }

    //daily workout endpoint
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
