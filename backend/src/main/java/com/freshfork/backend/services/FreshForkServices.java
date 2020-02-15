package com.freshfork.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freshfork.backend.dao.DietRepository;
import com.freshfork.backend.dao.IngredientRepository;
import com.freshfork.backend.dao.IngredientUsageRepository;
import com.freshfork.backend.dao.RecipeRepository;
import com.freshfork.backend.dao.UserRepository;

@Service
public class FreshForkServices {
	@Autowired
	DietRepository dietRepository;
	
	@Autowired
	IngredientUsageRepository ingredientUsageRepository;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	//USER METHODS
	
	@Transactional
	public User createUser(String name, String email, String password, boolean isPro) {
		
	}
	
	
	//RECIPE METHODS
	
	@Transactional
	public Recipe createRecipe() {
		
	}
	
	@Transactional
	public Recipe deleteRecipe(String recipeName) {
		
	}
	
	@Transactional
	public Recipe filterRecipeByDiet(String dietName) {
		
	}
	
	
	//AUTHENTICATION
	
	@Transactional
	public boolean authenticateUser() {
		
	}
	
	
}
