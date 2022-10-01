package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    private static ArrayList<User> users = new ArrayList<User>();

    static{
        users.add(new User(1,"Do minh tuan","tuan@gmail.com","782364722","avatar.img","123123"));
        users.add(new User(2,"Do minh tri","tri@gmail.com","21312312312","avatar2.img","323122"));
        users.add(new User(3,"Do minh duy","duy@gmail.com","111111","avatar3.img","99999999"));
        users.add(new User(4,"Do minh phuc","phuc@gmail.com","222222","avatar4.img","0009099"));

    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user: users
             ) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id){
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User Not Found in system!!!");

    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user : users){
            if (user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }
}
