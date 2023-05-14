package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common;

import org.springframework.stereotype.Component;

/**
 * Annotate this class as a component (@Component) to mark it as a spring bean
 *  - this makes the class available for dependency injection...will be scanned during component scanning
 *
 * Behind the scenes when running the application the spring container will create an instance of this class 'CricketCoach'
 *  - Coach theCoach = new CricketCoach();
 */
@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("CricketCoach.CricketCoach constructor - "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }
}
