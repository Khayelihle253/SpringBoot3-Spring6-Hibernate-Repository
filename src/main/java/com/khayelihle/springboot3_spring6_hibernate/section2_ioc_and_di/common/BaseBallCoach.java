package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Played  baseball for 2 hours";
    }
}
