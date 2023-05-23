package com.khayelihle.springboot3_spring6_hibernate.section4_rest_crud_apis.rest;

/**
 * Custom exception class
 */
public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

}
