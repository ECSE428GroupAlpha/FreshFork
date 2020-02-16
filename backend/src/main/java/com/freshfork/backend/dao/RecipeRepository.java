package com.freshfork.backend.dao;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.freshfork.backend.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
    Recipe findByRecipeID(int id);
    List<Recipe> listByDiet(String diet);
}
