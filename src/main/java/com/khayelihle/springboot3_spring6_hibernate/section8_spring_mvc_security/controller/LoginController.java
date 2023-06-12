package com.khayelihle.springboot3_spring6_hibernate.section8_spring_mvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

        //return "security/plain-login";
        return "security/fancy-login";
    }
}
