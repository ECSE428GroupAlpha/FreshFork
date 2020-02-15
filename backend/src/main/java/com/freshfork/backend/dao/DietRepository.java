package com.freshfork.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.freshfork.backend.model.Diet;

public interface DietRepository extends CrudRepository<Diet, String> {

}
