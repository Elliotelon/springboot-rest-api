package com.elliot.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elliot.springbootrestapi.bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    
    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1, "minkyu", "kim");
        return student;
    }

    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "minkyu", "kim"));
        students.add(new Student(2, "minkyu2", "kim"));
        students.add(new Student(3, "minkyu3", "kim"));
        students.add(new Student(4, "minkyu4", "kim"));

        return students;
    }
}
