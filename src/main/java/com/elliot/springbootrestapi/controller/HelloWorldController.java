package com.elliot.springbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller //Controller 역할
// @ResponseBody //JSON으로 리턴
@RestController // @Controller + @ResponseBody
public class HelloWorldController {
    
    // HTTP GET 요청
    // http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }
}
