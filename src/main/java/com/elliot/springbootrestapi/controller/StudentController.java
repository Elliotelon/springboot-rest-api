package com.elliot.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elliot.springbootrestapi.bean.Student;

@RestController
public class StudentController {
    
    // http://localhost:8080/student

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1, "minkyu", "kim");
        return student;
    }
}
