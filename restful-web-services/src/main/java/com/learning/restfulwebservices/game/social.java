package com.learning.restfulwebservices.game;

import java.time.LocalDate;

public class social {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    
    public social(Integer id, String name, LocalDate birthDate) {
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
