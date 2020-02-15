package com.freshfork.backend.model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class Recipe{
private Set<Diet> diet;

@ManyToMany(mappedBy="recipe")
public Set<Diet> getDiet() {
   return this.diet;
}

public void setDiet(Set<Diet> diets) {
   this.diet = diets;
}

private User author;

@ManyToOne(optional=false)
public User getAuthor() {
   return this.author;
}

public void setAuthor(User author) {
   this.author = author;
}

private Set<User> favoritedBy;

@ManyToMany(mappedBy="favoriteREcipes")
public Set<User> getFavoritedBy() {
   return this.favoritedBy;
}

public void setFavoritedBy(Set<User> favoritedBys) {
   this.favoritedBy = favoritedBys;
}

private Set<IngredientUsage> ingredientUsage;

@OneToMany(mappedBy="recipe")
public Set<IngredientUsage> getIngredientUsage() {
   return this.ingredientUsage;
}

public void setIngredientUsage(Set<IngredientUsage> ingredientUsages) {
   this.ingredientUsage = ingredientUsages;
}

private String name;

public void setName(String value) {
this.name = value;
    }
@Id
public String getName() {
return this.name;
    }
private String recipeSteps;

public void setRecipeSteps(String value) {
this.recipeSteps = value;
    }
public String getRecipeSteps() {
return this.recipeSteps;
    }
private String rating;

public void setRating(String value) {
this.rating = value;
    }
public String getRating() {
return this.rating;
       }
   }
