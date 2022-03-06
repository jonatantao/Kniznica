package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private List<UserDto> users;

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/users") //filtered users with user last name
    public List<UserDto> getUsers(@RequestParam(required = false) String userlastName){
        return userService.getUsers(userlastName);
    }

    @GetMapping("/api/userid") //filtered users with user last name
    public List<UserDto> getUsersId(@RequestParam(required = false) String userId){
        return userService.getUsersId(userId);
    }

    @PostMapping("/api/users") //creating new user
    public Long createUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/api/users/{userId}")
    public void putUser(@PathVariable int userId, @RequestBody UserDto user){
        userService.putUser(userId, user);
    }
}