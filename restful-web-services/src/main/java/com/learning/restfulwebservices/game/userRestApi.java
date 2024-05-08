package com.learning.restfulwebservices.game;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
        user u1 = service.findbyid(id);
        if ( u1 == null)
            throw new UserNotFoundException("id:" + id);
        return u1;
    }

    @DeleteMapping("/delete/{id}")
    public void removeByid(@PathVariable int id){
        service.deleteByid(id);
    }

    @PostMapping("/createUser")
    public ResponseEntity<user> newUser(@Valid @RequestBody user user){
        user savedUser = service.createUser(user); 
        URI location = ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/getbyid/{id}")
                        .buildAndExpand(savedUser.getId()).toUri(); 
        return ResponseEntity.created(location).build();   //return 201 code for new creation
    }

}
