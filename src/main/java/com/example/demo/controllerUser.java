package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controllerUser {
    List<User> users;

    public controllerUser(){
        this.users = init2();
    }

    public List<User> init2(){ //init2 list of users
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId("1");
        user1.setFirstName("Jožo");
        user1.setLastName("Alvaréz");
        user1.setEmail("j.alvarez@gmail.com");
        users.add(user1);

        User user2 = new User();
        user2.setId("2");
        user2.setFirstName("Jano");
        user2.setLastName("Odvedľa");
        user2.setEmail("odvedla@gmail.com");
        users.add(user2);
        return users;
    }

    @GetMapping("/api/users") //filtered users with user last name
    public List<User> getUsers(@RequestParam(required = false) String userlastName){
        if (userlastName == null){
            return this.users;
        }

        List<User> filteredUsers = new ArrayList<>();

        for (User user : users){
            if (user.getLastName().equals(userlastName)){
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    @GetMapping("/api/userid") //filtered users with user last name
    public List<User> getUsersId(@RequestParam(required = false) String userId){
        if (userId == null){
            return this.users;
        }

        List<User> filteredUsers = new ArrayList<>();

        for (User user : users){
            if (user.getId().equals(userId)){
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    @PostMapping("/api/users") //creating new user
    public List<User> createUser(@RequestBody User user){
        this.users.add(user);

        return users;
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable Integer userId){
        this.users.remove(this.users.get(userId));
    }

    @PutMapping("/api/users/{userId}")
    public List<User> putUser(@PathVariable Integer userId, @RequestBody User user){
        this.users.get(userId).setId(user.getId());
        this.users.get(userId).setFirstName(user.getFirstName());
        this.users.get(userId).setLastName(user.getLastName());
        this.users.get(userId).setEmail(user.getEmail());
        return users;
    }
}
