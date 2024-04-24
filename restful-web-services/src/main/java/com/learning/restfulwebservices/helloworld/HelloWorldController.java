package com.learning.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloworld(){
        return "HELLO PEOPLE";
    }

    @GetMapping("/hellojson")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("Hello PEOPLE");
    }

    //parameter
    @GetMapping("/hello/{id}")
    public HelloWorldBean HelloWorldBeanPath(@PathVariable String id){
        //return new HelloWorldBean("Hello " + id);
        return new HelloWorldBean(String.format("Hello friend %s", id));
    }

}
