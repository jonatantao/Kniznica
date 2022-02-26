package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controllerUser {

    private List<User> users;

    private UserService userService;

    public controllerUser(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/users") //filtered users with user last name
    public List<User> getUsers(@RequestParam(required = false) String userlastName){
        return userService.getUsers(userlastName);
    }

    @GetMapping("/api/userid") //filtered users with user last name
    public List<User> getUsersId(@RequestParam(required = false) String userId){
        return userService.getUsersId(userId);
    }

    @PostMapping("/api/users") //creating new user
    public List<User> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/api/users/{userId}")
    public List<User> putUser(@PathVariable Integer userId, @RequestBody User user){
        return userService.putUser(userId, user);
    }
}
