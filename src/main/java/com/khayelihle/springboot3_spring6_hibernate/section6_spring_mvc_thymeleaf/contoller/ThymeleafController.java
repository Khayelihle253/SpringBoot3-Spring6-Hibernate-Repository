package com.khayelihle.springboot3_spring6_hibernate.section6_spring_mvc_thymeleaf.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/hello")
    public String sayHello(Model theModel){

        theModel.addAttribute("theDate", new java.util.Date());

        return "helloworld"; //spring with auto-configure to use Thymeleaf...src/main/resources/templates/helloworld.html
    }
}
