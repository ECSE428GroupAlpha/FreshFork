package com.freshfork.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freshfork.backend.dao.DietRepository;
import com.freshfork.backend.dao.IngredientRepository;
import com.freshfork.backend.dao.IngredientUsageRepository;
import com.freshfork.backend.dao.RecipeRepository;
import com.freshfork.backend.dao.UserRepository;
import com.freshfork.backend.model.Recipe;
import com.freshfork.backend.model.User;

import com.freshfork.backend.model.*;
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
		User user = new User();
		
		if(userRepository.findAllByEmail(email).size() == 1) {
			throw new IllegalArgumentException("Email is already taken.");
		}
		else {
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setIsPro(isPro);
		}
		
		return userRepository.save(user);
	}
	
	
	//RECIPE METHODS
	
	@Transactional
	public Recipe createRecipe() {
		
	}
	
	@Transactional
	public String deleteRecipe(int recipeID) {
		String recipeName;
		
		Recipe recipeToDelete = recipeRepository.findByRecipeID(recipeID);
		if(recipeToDelete == null) {
			//Recipe could not be found, returning null
			return null;
		}
		else {
			//Store recipeName in new string before deleting recipe
			recipeName = new String(recipeToDelete.getName());
			recipeRepository.delete(recipeToDelete);
		}
		
		return recipeName;
	}
	
	@Transactional
	public Recipe filterRecipeByDiet(String dietName) {
		
	}
	
	
	//AUTHENTICATION
	
	@Transactional
	public boolean authenticateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new IllegalArgumentException("Account with given email does not exist.");
		}
		else {
			if(password.equals(user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	
}
