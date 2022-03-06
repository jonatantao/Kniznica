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
    public List<UserDto> createUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/api/users/{userId}")
    public List<UserDto> putUser(@PathVariable Integer userId, @RequestBody UserDto user){
        return userService.putUser(userId, user);
    }
}