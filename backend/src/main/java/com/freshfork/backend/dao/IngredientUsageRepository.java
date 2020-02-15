package com.freshfork.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.freshfork.backend.model.IngredientUsage;

public interface IngredientUsageRepository extends CrudRepository<IngredientUsage, Integer> {

}
