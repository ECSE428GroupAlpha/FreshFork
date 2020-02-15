package com.freshfork.backend.dao;

import org.springframework.data.repository.CrudRepository;
import com.freshfork.backend.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
