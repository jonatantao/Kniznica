package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<UserDto> users;

    private UserService userService;

    public UserService(){
        this.users = init2();
    }

    public List<UserDto> init2(){ //init2 list of users
        List<UserDto> users = new ArrayList<>();

        UserDto user1 = new UserDto();
        user1.setId("1");
        user1.setFirstName("Jožo");
        user1.setLastName("Alvaréz");
        user1.setEmail("j.alvarez@gmail.com");
        users.add(user1);

        UserDto user2 = new UserDto();
        user2.setId("2");
        user2.setFirstName("Jano");
        user2.setLastName("Odvedľa");
        user2.setEmail("odvedla@gmail.com");
        users.add(user2);

        return users;
    }
    @GetMapping("/api/users") //filtered users with user last name
    public List<UserDto> getUsers(String userlastName){
        if (userlastName == null){
            return this.users;
        }

        List<UserDto> filteredUsers = new ArrayList<>();

        for (UserDto user : users){
            if (user.getLastName().equals(userlastName)){
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    @GetMapping("/api/userid") //filtered users with user last name
    public List<UserDto> getUsersId(String userId){
        if (userId == null){
            return this.users;
        }

        List<UserDto> filteredUsers = new ArrayList<>();

        for (UserDto user : users){
            if (user.getId().equals(userId)){
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    @PostMapping("/api/users") //creating new user
    public List<UserDto> createUser(UserDto user){
        this.users.add(user);

        return users;
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(Integer userId){
        this.users.remove(this.users.get(userId));
    }

    @PutMapping("/api/users/{userId}")
    public List<UserDto> putUser(Integer userId, UserDto user){
        this.users.get(userId).setId(user.getId());
        this.users.get(userId).setFirstName(user.getFirstName());
        this.users.get(userId).setLastName(user.getLastName());
        this.users.get(userId).setEmail(user.getEmail());
        return users;
    }
}
