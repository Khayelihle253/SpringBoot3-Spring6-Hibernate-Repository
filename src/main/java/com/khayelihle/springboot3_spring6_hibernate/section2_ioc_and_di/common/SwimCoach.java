package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("In SwimCoach constructor - "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim for 4 hours";
    }
}
