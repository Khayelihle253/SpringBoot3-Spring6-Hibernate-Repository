package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Lazy initialization
 * A class annotated with @Lazy is only instantiated in the spring container ONLY when it is needed, or called
 */
@Lazy
@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("TennisCoach.TennisCoach constructor - "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Played tennis for 30 minutes";
    }
}
