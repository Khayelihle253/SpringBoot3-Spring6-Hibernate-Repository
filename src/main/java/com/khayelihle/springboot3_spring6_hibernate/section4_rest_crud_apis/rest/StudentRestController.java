package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.rest;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.Student;
import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if (studentIndex<0 || studentIndex>theStudents.size()-1){
            throw new StudentNotFoundException("Could not find a student with index: " + studentIndex);
        }
        return theStudents.get(studentIndex);

    }
}
