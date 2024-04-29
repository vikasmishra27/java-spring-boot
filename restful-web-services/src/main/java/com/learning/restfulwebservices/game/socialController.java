package com.learning.restfulwebservices.game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class socialController {

    private static List<social> users = new ArrayList<>();

    static{
        users.add(new social(1, "Vikas", LocalDate.now().minusYears(30)));
    }

    @GetMapping("/getAll")
    public List<social> getAll(){

        return users;

    }
    
}
