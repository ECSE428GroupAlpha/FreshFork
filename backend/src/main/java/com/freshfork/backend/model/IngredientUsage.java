package com.freshfork.backend.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class IngredientUsage{
private Recipe recipe;

@ManyToOne(optional=false)
public Recipe getRecipe() {
   return this.recipe;
}

public void setRecipe(Recipe recipe) {
   this.recipe = recipe;
}

private Ingredient ingredient;

@ManyToOne(optional=false)
public Ingredient getIngredient() {
   return this.ingredient;
}

public void setIngredient(Ingredient ingredient) {
   this.ingredient = ingredient;
}

private String unitQuantity;

public void setUnitQuantity(String value) {
this.unitQuantity = value;
    }
public String getUnitQuantity() {
return this.unitQuantity;
    }
private int ingedientUsageID;

public void setIngedientUsageID(int value) {
this.ingedientUsageID = value;
    }
@Id
public int getIngedientUsageID() {
return this.ingedientUsageID;
       }
   }
