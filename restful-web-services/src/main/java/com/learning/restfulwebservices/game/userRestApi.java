package com.learning.restfulwebservices.game;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userRestApi {

    private userFunctions service;

    public userRestApi(userFunctions service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<user> getAll(){
        return service.returnAll();
    }

    @GetMapping("/getbyid/{id}")
    public user getbyid(@PathVariable Integer id){
        return service.findbyid(id);
    }
    @PostMapping("/createUser")
    public void newUser(@RequestBody user user){
        service.createUser(user);    
    }

}
