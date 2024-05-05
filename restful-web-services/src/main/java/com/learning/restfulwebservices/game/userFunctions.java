package com.learning.restfulwebservices.game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class userFunctions {

    private static List<user> users = new ArrayList<>();

    static{
        users.add(new user(1, "Vikas", LocalDate.now().minusYears(30)));
        users.add(new user(1, "PQR", LocalDate.now().minusYears(10)));
        users.add(new user(2, "ABC", LocalDate.now().minusYears(20)));
    }

    public List<user> returnAll(){
        return users;
    }

    public user findbyid(Integer id){
        return users.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }

    public user createUser(user user){
        users.add(user);
        return user;
    }

}
