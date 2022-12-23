package com.elliot.springbootrestapi.controller;

import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.elliot.springbootrestapi.bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1, "minkyu", "kim");
        return student;
    }

    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "minkyu", "kim"));
        students.add(new Student(2, "minkyu2", "kim"));
        students.add(new Student(3, "minkyu3", "kim"));
        students.add(new Student(4, "minkyu4", "kim"));

        return students;
    }

    // PathVariable
    // http://localhost:8080/students/1/minkyu/kim
    // @PathVariable : url 변수와 바인딩 시켜주는 어노테이션
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
}
