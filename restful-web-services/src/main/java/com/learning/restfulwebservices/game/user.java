package com.learning.restfulwebservices.game;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class user {
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;

    @Past(message = "Birthdate should be in past")
    private LocalDate birthDate;
    
    public user(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        //return "[id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
        return super.toString();
    }

   
}
