package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private static UserDto mapToUserDto(UserEntity userEntity){
        UserDto userDto = new UserDto();

        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());

        return userDto;
    }

    @Transactional
    public List<UserDto> getUsers(String userlastName){
        List<UserDto> ret = new LinkedList<>();
        for (UserEntity b1 : userRepository.findAll()){
            UserDto b2 = mapToUserDto(b1);
            ret.add(b2);
        }
        return ret;
    }

    @Transactional
    public List<UserDto> getUsersId(String userId){
        List<UserDto> ret = new LinkedList<>();
        for (UserEntity b1 : userRepository.findAll()){
            UserDto b2 = mapToUserDto(b1);
            ret.add(b2);
        }
        return ret;
    }

    @Transactional
    public Long createUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setId(userDto.getId());
        userEntity.setEmail(userDto.getEmail());

        this.userRepository.save(userEntity);

        return userEntity.getId();
    }

    @Transactional
    public void deleteUser(int userId){
        Optional<UserEntity> byId = userRepository.findById((long)userId);
        if(byId.isPresent()){
            userRepository.delete(byId.get());
        }
    }

    @Transactional
    public void putUser(int userId, UserDto userDto){
        Optional<UserEntity> byId = userRepository.findById((long)userId);
        if(byId.isPresent()){
            byId.get().setFirstName(userDto.getFirstName());
            byId.get().setLastName(userDto.getLastName());
            byId.get().setId(userDto.getId());
            byId.get().setEmail(userDto.getEmail());
        }
    }
}