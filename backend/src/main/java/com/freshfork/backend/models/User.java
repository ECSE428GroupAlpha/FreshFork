/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package main.java.com.freshfork.backend.models;
import java.util.*;

// line 11 "../../../../../../Untitled.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private int uid;
  private String name;
  private String email;
  private String password;
  private boolean isPro;

  //User Associations
  private List<Recipe> recipes;
  private List<Diet> diets;
  private List<Ingredient> ingredients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(int aUid, String aName, String aEmail, String aPassword, boolean aIsPro)
  {
    uid = aUid;
    name = aName;
    email = aEmail;
    password = aPassword;
    isPro = aIsPro;
    recipes = new ArrayList<Recipe>();
    diets = new ArrayList<Diet>();
    ingredients = new ArrayList<Ingredient>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUid(int aUid)
  {
    boolean wasSet = false;
    uid = aUid;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsPro(boolean aIsPro)
  {
    boolean wasSet = false;
    isPro = aIsPro;
    wasSet = true;
    return wasSet;
  }

  public int getUid()
  {
    return uid;
  }

  public String getName()
  {
    return name;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPassword()
  {
    return password;
  }

  public boolean getIsPro()
  {
    return isPro;
  }
  /* Code from template association_GetMany_relatedSpecialization */
  public Recipe getRecipe_Recipe(int index)
  {
    Recipe aRecipe = (Recipe)recipes.get(index);
    return aRecipe;
  }

  /* required for Java 7. */
  @SuppressWarnings("unchecked")
  public List<Recipe> getRecipes_Recipe()
  {
    List<? extends Recipe> newRecipes = Collections.unmodifiableList(recipes);
    return (List<Recipe>)newRecipes;
  }
  /* Code from template association_GetMany */
  public Recipe getRecipe(int index)
  {
    Recipe aRecipe = recipes.get(index);
    return aRecipe;
  }

  public List<Recipe> getRecipes()
  {
    List<Recipe> newRecipes = Collections.unmodifiableList(recipes);
    return newRecipes;
  }

  public int numberOfRecipes()
  {
    int number = recipes.size();
    return number;
  }

  public boolean hasRecipes()
  {
    boolean has = recipes.size() > 0;
    return has;
  }

  public int indexOfRecipe(Recipe aRecipe)
  {
    int index = recipes.indexOf(aRecipe);
    return index;
  }
  /* Code from template association_GetMany_clear */
  protected void clear_recipes()
  {
    recipes.clear();
  }
  /* Code from template association_GetMany */
  public Diet getDiet(int index)
  {
    Diet aDiet = diets.get(index);
    return aDiet;
  }

  public List<Diet> getDiets()
  {
    List<Diet> newDiets = Collections.unmodifiableList(diets);
    return newDiets;
  }

  public int numberOfDiets()
  {
    int number = diets.size();
    return number;
  }

  public boolean hasDiets()
  {
    boolean has = diets.size() > 0;
    return has;
  }

  public int indexOfDiet(Diet aDiet)
  {
    int index = diets.indexOf(aDiet);
    return index;
  }
  /* Code from template association_GetMany */
  public Ingredient getIngredient(int index)
  {
    Ingredient aIngredient = ingredients.get(index);
    return aIngredient;
  }

  public List<Ingredient> getIngredients()
  {
    List<Ingredient> newIngredients = Collections.unmodifiableList(ingredients);
    return newIngredients;
  }

  public int numberOfIngredients()
  {
    int number = ingredients.size();
    return number;
  }

  public boolean hasIngredients()
  {
    boolean has = ingredients.size() > 0;
    return has;
  }

  public int indexOfIngredient(Ingredient aIngredient)
  {
    int index = ingredients.indexOf(aIngredient);
    return index;
  }
  /* Code from template association_set_specialization_reqCommonCode */  /* Code from template association_MinimumNumberOfMethod_relatedSpecialization */
  public static int minimumNumberOfRecipes_Recipe()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne_relatedSpecialization */
  public Recipe addRecipe(String aRname, String aRecipe, String aRating)
  {
    return new Recipe(aRname, aRecipe, aRating);
  }

  public boolean addRecipe(Recipe aRecipe)
  {
    boolean wasAdded = false;
    if (recipes.contains(aRecipe)) { return false; }
    if (recipes.contains(aRecipe)) { return false; }
    User existingUser = aRecipe.getUser_OneUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aRecipe.setUser(this);
    }
    else
    {
      recipes.add(aRecipe);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRecipe(Recipe aRecipe)
  {
    boolean wasRemoved = false;
    //Unable to remove aRecipe, as it must always have a user
    if (!this.equals(aRecipe.getUser_OneUser()))
    {
      recipes.remove(aRecipe);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions_relatedSpecialization */
  public boolean addRecipeAt(Recipe aRecipe, int index)
  {  
    boolean wasAdded = false;
    if(addRecipe(aRecipe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipes()) { index = numberOfRecipes() - 1; }
      recipes.remove(aRecipe);
      recipes.add(index, aRecipe);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRecipeAt(Recipe aRecipe, int index)
  {
    boolean wasAdded = false;
    if(recipes.contains(aRecipe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipes()) { index = numberOfRecipes() - 1; }
      recipes.remove(aRecipe);
      recipes.add(index, aRecipe);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRecipeAt(aRecipe, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRecipes()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addRecipe(Recipe aRecipe)
  {
    boolean wasAdded = false;
    if (recipes.contains(aRecipe)) { return false; }
    if (recipes.contains(aRecipe)) { return false; }
    recipes.add(aRecipe);
    if (aRecipe.indexOfUser(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRecipe.addUser(this);
      if (!wasAdded)
      {
        recipes.remove(aRecipe);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeRecipe(Recipe aRecipe)
  {
    boolean wasRemoved = false;
    if (!recipes.contains(aRecipe))
    {
      return wasRemoved;
    }

    int oldIndex = recipes.indexOf(aRecipe);
    recipes.remove(oldIndex);
    if (aRecipe.indexOfUser(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRecipe.removeUser(this);
      if (!wasRemoved)
      {
        recipes.add(oldIndex,aRecipe);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRecipeAt(Recipe aRecipe, int index)
  {  
    boolean wasAdded = false;
    if(addRecipe(aRecipe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipes()) { index = numberOfRecipes() - 1; }
      recipes.remove(aRecipe);
      recipes.add(index, aRecipe);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRecipeAt(Recipe aRecipe, int index)
  {
    boolean wasAdded = false;
    if(recipes.contains(aRecipe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipes()) { index = numberOfRecipes() - 1; }
      recipes.remove(aRecipe);
      recipes.add(index, aRecipe);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRecipeAt(aRecipe, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDiets()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDiet(Diet aDiet)
  {
    boolean wasAdded = false;
    if (diets.contains(aDiet)) { return false; }
    diets.add(aDiet);
    if (aDiet.indexOfUser(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDiet.addUser(this);
      if (!wasAdded)
      {
        diets.remove(aDiet);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDiet(Diet aDiet)
  {
    boolean wasRemoved = false;
    if (!diets.contains(aDiet))
    {
      return wasRemoved;
    }

    int oldIndex = diets.indexOf(aDiet);
    diets.remove(oldIndex);
    if (aDiet.indexOfUser(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDiet.removeUser(this);
      if (!wasRemoved)
      {
        diets.add(oldIndex,aDiet);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDietAt(Diet aDiet, int index)
  {  
    boolean wasAdded = false;
    if(addDiet(aDiet))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDiets()) { index = numberOfDiets() - 1; }
      diets.remove(aDiet);
      diets.add(index, aDiet);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDietAt(Diet aDiet, int index)
  {
    boolean wasAdded = false;
    if(diets.contains(aDiet))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDiets()) { index = numberOfDiets() - 1; }
      diets.remove(aDiet);
      diets.add(index, aDiet);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDietAt(aDiet, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfIngredients()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addIngredient(Ingredient aIngredient)
  {
    boolean wasAdded = false;
    if (ingredients.contains(aIngredient)) { return false; }
    ingredients.add(aIngredient);
    if (aIngredient.indexOfUser(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aIngredient.addUser(this);
      if (!wasAdded)
      {
        ingredients.remove(aIngredient);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeIngredient(Ingredient aIngredient)
  {
    boolean wasRemoved = false;
    if (!ingredients.contains(aIngredient))
    {
      return wasRemoved;
    }

    int oldIndex = ingredients.indexOf(aIngredient);
    ingredients.remove(oldIndex);
    if (aIngredient.indexOfUser(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aIngredient.removeUser(this);
      if (!wasRemoved)
      {
        ingredients.add(oldIndex,aIngredient);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addIngredientAt(Ingredient aIngredient, int index)
  {  
    boolean wasAdded = false;
    if(addIngredient(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredients()) { index = numberOfIngredients() - 1; }
      ingredients.remove(aIngredient);
      ingredients.add(index, aIngredient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIngredientAt(Ingredient aIngredient, int index)
  {
    boolean wasAdded = false;
    if(ingredients.contains(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredients()) { index = numberOfIngredients() - 1; }
      ingredients.remove(aIngredient);
      ingredients.add(index, aIngredient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIngredientAt(aIngredient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Recipe> copyOfRecipes = new ArrayList<Recipe>(recipes);
    recipes.clear();
    for(Recipe aRecipe : copyOfRecipes)
    {
      aRecipe.removeUser(this);
    }
    ArrayList<Diet> copyOfDiets = new ArrayList<Diet>(diets);
    diets.clear();
    for(Diet aDiet : copyOfDiets)
    {
      aDiet.removeUser(this);
    }
    ArrayList<Ingredient> copyOfIngredients = new ArrayList<Ingredient>(ingredients);
    ingredients.clear();
    for(Ingredient aIngredient : copyOfIngredients)
    {
      aIngredient.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "uid" + ":" + getUid()+ "," +
            "name" + ":" + getName()+ "," +
            "email" + ":" + getEmail()+ "," +
            "password" + ":" + getPassword()+ "," +
            "isPro" + ":" + getIsPro()+ "]";
  }
}