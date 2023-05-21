package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    //add code for "/hello" endpoint
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
