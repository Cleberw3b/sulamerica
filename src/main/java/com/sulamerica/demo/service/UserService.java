package com.sulamerica.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.sulamerica.demo.model.User;
import com.sulamerica.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}