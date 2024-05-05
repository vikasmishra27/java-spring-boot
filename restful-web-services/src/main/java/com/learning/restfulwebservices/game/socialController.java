package com.learning.restfulwebservices.game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class socialController {

    private static List<social> users = new ArrayList<>();

    static{
        users.add(new social(1, "Vikas", LocalDate.now().minusYears(30)));
        users.add(new social(1, "PQR", LocalDate.now().minusYears(10)));
        users.add(new social(2, "ABC", LocalDate.now().minusYears(20)));
    }

    @GetMapping("/getAll")
    public List<social> getAll(){
        return users;
    }
    @GetMapping("/getbyid/{id}")
    public social getbyid(@PathVariable Integer id){
        return users.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }
    @PostMapping("/createUser")
    public void createUser(@RequestBody social user){
        users.add(user);
    }
}
