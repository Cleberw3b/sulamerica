package com.sulamerica.demo.repository;

import com.sulamerica.demo.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
