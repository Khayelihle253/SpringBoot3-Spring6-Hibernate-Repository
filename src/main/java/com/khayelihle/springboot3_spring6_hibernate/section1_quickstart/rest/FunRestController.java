package com.khayelihle.springboot3_spring6_hibernate.section1_quickstart.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose endpoint for coach and team name
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+coachName+"\n"+"Team: "+teamName;
    }

    //expose "/" endpoint that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World of Spring";
    }

    //expose an endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Ran a 5K";
    }

    //expose an endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day.";
    }

}
