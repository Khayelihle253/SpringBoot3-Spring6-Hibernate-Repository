package com.khayelihle.springboot3_spring6_hibernate.section2_ioc_and_di.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Played tennis for 30 minutes";
    }
}
