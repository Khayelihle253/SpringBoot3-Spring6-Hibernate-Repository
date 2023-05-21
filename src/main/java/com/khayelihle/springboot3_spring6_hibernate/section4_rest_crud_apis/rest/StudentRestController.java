package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.rest;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadStudentData(){
        theStudents.add(new Student("Khaye1","Ngcobo1"));
        theStudents.add(new Student("Khaye2","Ngcobo2"));
        theStudents.add(new Student("Khaye3","Ngcobo3"));
    }

    //define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    //define endpoint for "/students/{studentIndex}"
    @GetMapping("/students/{studentIndex}")
    public Student getStudents(@PathVariable int studentIndex){

        return theStudents.get(studentIndex);

    }


}
