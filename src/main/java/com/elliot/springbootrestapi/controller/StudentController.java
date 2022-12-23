package com.elliot.springbootrestapi.controller;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // RequestParam
    // http://localhost:8080/students/query?id=1&firstName=minkyu&lastName=kim
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    // POST Request - create new resource
    // @PostMapping, @RequestBody
    // @PostMapping : HTTP POST 요청 처리
    // @RequestBody : HTTP requestbody -> Java Object로 변환 (내부적으로 HttpMessageConverter 사용)
    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // @PutMapping - updating existing resource
    @PutMapping("/student/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // @DeleteMapping - deleting the existing resource
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student deleted successfully!";
    }
}
