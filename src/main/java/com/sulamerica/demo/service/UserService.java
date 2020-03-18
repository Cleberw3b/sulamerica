package com.sulamerica.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.sulamerica.demo.model.User;
import com.sulamerica.demo.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        log.info("Listando usuários...");
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        users.forEach(user -> log.info(user.toString()));
        return users;
    }

    public User getUserById(int id) {
        User user = userRepository.findById(id).get();
        log.info("Usuário recuperado" + System.lineSeparator() + user.toString());
        return user;
    }

    public void saveOrUpdate(User user) {
        log.info("Salvando usuário" + System.lineSeparator() + user.toString());
        userRepository.save(user);
    }

    public void delete(int id) {
        log.info("Delentando usuário com ID=" + id);
        userRepository.deleteById(id);
    }
}