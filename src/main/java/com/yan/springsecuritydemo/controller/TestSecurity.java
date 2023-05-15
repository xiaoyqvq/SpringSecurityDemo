package com.yan.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestSecurity {

    @GetMapping("/test")
    public String HelloWorld(){
        return "hello world";
    }
}
