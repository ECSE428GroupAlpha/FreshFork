package com.freshfork.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.freshfork.backend.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
