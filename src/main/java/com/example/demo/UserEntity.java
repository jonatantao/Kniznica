package com.example.demo;

import javax.persistance.Entity;
import javax.persistance.GeneratedValue;
import javax.persistance.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
