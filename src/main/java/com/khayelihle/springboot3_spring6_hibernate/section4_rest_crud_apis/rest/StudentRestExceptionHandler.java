package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.rest;

import com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.entity.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This class will handle global exceptions
 *  - BEST PRACTICE for large scale projects where the exception handler need to be re-used
 *    instead of duplicating them. Also, good for real-time projects
 */
@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code here (from the student rest controller)

    /**
     * Add the exception handler using @ExceptionHandler spring annotation
     * - This will be returned to the rest client, whenever the StudentNotFoundException is thrown
     * - JSON response as other responses handled by Jackson
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){

        //create a StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    //handle any exception that is can be thrown (generic handler)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){

        //create a StudentErrorResponse
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
