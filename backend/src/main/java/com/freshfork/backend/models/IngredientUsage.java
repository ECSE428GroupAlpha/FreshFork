/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package main.java.com.freshfork.backend.models;

// line 43 "../../../../../../Untitled.ump"
public class IngredientUsage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IngredientUsage Attributes
  private int unitQuantity;

  //IngredientUsage Associations
  private Recipe recipe;
  private Ingredient ingredient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IngredientUsage(int aUnitQuantity, Recipe aRecipe, Ingredient aIngredient)
  {
    unitQuantity = aUnitQuantity;
    boolean didAddRecipe = setRecipe(aRecipe);
    if (!didAddRecipe)
    {
      throw new RuntimeException("Unable to create ingredientUsage due to recipe");
    }
    boolean didAddIngredient = setIngredient(aIngredient);
    if (!didAddIngredient)
    {
      throw new RuntimeException("Unable to create ingredientUsage due to ingredient");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUnitQuantity(int aUnitQuantity)
  {
    boolean wasSet = false;
    unitQuantity = aUnitQuantity;
    wasSet = true;
    return wasSet;
  }

  public int getUnitQuantity()
  {
    return unitQuantity;
  }
  /* Code from template association_GetOne */
  public Recipe getRecipe()
  {
    return recipe;
  }
  /* Code from template association_GetOne */
  public Ingredient getIngredient()
  {
    return ingredient;
  }
  /* Code from template association_SetOneToMany */
  public boolean setRecipe(Recipe aRecipe)
  {
    boolean wasSet = false;
    if (aRecipe == null)
    {
      return wasSet;
    }

    Recipe existingRecipe = recipe;
    recipe = aRecipe;
    if (existingRecipe != null && !existingRecipe.equals(aRecipe))
    {
      existingRecipe.removeIngredientUsage(this);
    }
    recipe.addIngredientUsage(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setIngredient(Ingredient aIngredient)
  {
    boolean wasSet = false;
    if (aIngredient == null)
    {
      return wasSet;
    }

    Ingredient existingIngredient = ingredient;
    ingredient = aIngredient;
    if (existingIngredient != null && !existingIngredient.equals(aIngredient))
    {
      existingIngredient.removeIngredientUsage(this);
    }
    ingredient.addIngredientUsage(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Recipe placeholderRecipe = recipe;
    this.recipe = null;
    if(placeholderRecipe != null)
    {
      placeholderRecipe.removeIngredientUsage(this);
    }
    Ingredient placeholderIngredient = ingredient;
    this.ingredient = null;
    if(placeholderIngredient != null)
    {
      placeholderIngredient.removeIngredientUsage(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "unitQuantity" + ":" + getUnitQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "recipe = "+(getRecipe()!=null?Integer.toHexString(System.identityHashCode(getRecipe())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "ingredient = "+(getIngredient()!=null?Integer.toHexString(System.identityHashCode(getIngredient())):"null");
  }
}