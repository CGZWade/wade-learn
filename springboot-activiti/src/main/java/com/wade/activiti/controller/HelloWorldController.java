package com.wade.activiti.controller;

import com.wade.activiti.entity.Activiti;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/cgz")
    public Activiti helloWorld() {
        Activiti activiti = new Activiti();
        activiti.setName("hello world!");
        return activiti;
    }

}
