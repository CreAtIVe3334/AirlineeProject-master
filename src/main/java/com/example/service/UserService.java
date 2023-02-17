package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User registration(User user){ return userRepository.save(user); }

    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }

    public User getUserByUsername(String name){  return userRepository.findByUserName(name); }

    public User update(User user){
        return userRepository.save(user);
    }

    public boolean login(String username,String password){
        User user = getUserByUsername(username);
        return user != null? user.getPassword().equals(password):false;
    }

}
