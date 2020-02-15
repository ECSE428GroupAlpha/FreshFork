/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package main.java.com.freshfork.backend.models;
import java.util.*;

// line 3 "../../../../../../Untitled.ump"
public class Recipe
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Recipe Attributes
  private String rname;
  private String recipe;
  private String rating;

  //Recipe Associations
  private List<User> users;
  private List<Diet> diets;
  private List<IngredientUsage> ingredientUsages;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Recipe(String aRname, String aRecipe, String aRating)
  {
    rname = aRname;
    recipe = aRecipe;
    rating = aRating;
    users = new ArrayList<User>();
    diets = new ArrayList<Diet>();
    ingredientUsages = new ArrayList<IngredientUsage>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRname(String aRname)
  {
    boolean wasSet = false;
    rname = aRname;
    wasSet = true;
    return wasSet;
  }

  public boolean setRecipe(String aRecipe)
  {
    boolean wasSet = false;
    recipe = aRecipe;
    wasSet = true;
    return wasSet;
  }

  public boolean setRating(String aRating)
  {
    boolean wasSet = false;
    rating = aRating;
    wasSet = true;
    return wasSet;
  }

  public String getRname()
  {
    return rname;
  }

  /**
   * instruction
   */
  public String getRecipe()
  {
    return recipe;
  }

  public String getRating()
  {
    return rating;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  /**
   * favorite
   */
  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }
  /* Code from template association_GetMany_clear */
  protected void clear_users()
  {
    users.clear();
  }
  /* Code from template association_GetOne_relatedSpecialization */
  public User getUser_OneUser()
  {
    return (User)user.get(0);
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
  public IngredientUsage getIngredientUsage(int index)
  {
    IngredientUsage aIngredientUsage = ingredientUsages.get(index);
    return aIngredientUsage;
  }

  public List<IngredientUsage> getIngredientUsages()
  {
    List<IngredientUsage> newIngredientUsages = Collections.unmodifiableList(ingredientUsages);
    return newIngredientUsages;
  }

  public int numberOfIngredientUsages()
  {
    int number = ingredientUsages.size();
    return number;
  }

  public boolean hasIngredientUsages()
  {
    boolean has = ingredientUsages.size() > 0;
    return has;
  }

  public int indexOfIngredientUsage(IngredientUsage aIngredientUsage)
  {
    int index = ingredientUsages.indexOf(aIngredientUsage);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    users.add(aUser);
    if (aUser.indexOfRecipe(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUser.addRecipe(this);
      if (!wasAdded)
      {
        users.remove(aUser);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    if (!users.contains(aUser))
    {
      return wasRemoved;
    }

    int oldIndex = users.indexOf(aUser);
    users.remove(oldIndex);
    if (aUser.indexOfRecipe(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUser.removeRecipe(this);
      if (!wasRemoved)
      {
        users.add(oldIndex,aUser);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_set_specialization_reqCommonCode */  /* Code from template association_SetOneToMany_relatedSpecialization */
  public boolean setUser_User(User aUser)
  {
    boolean wasSet = false;
    if (aUser == null)
    {
      return wasSet;
    }

    User existingUser = getUser_OneUser();
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser))
    {
      existingUser.removeRecipe(this);
    }
    user.addRecipe(this);
    wasSet = true;
    return wasSet;
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
    if (aDiet.indexOfRecipe(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDiet.addRecipe(this);
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
    if (aDiet.indexOfRecipe(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDiet.removeRecipe(this);
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
  public static int minimumNumberOfIngredientUsages()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public IngredientUsage addIngredientUsage(int aUnitQuantity, Ingredient aIngredient)
  {
    return new IngredientUsage(aUnitQuantity, this, aIngredient);
  }

  public boolean addIngredientUsage(IngredientUsage aIngredientUsage)
  {
    boolean wasAdded = false;
    if (ingredientUsages.contains(aIngredientUsage)) { return false; }
    Recipe existingRecipe = aIngredientUsage.getRecipe();
    boolean isNewRecipe = existingRecipe != null && !this.equals(existingRecipe);
    if (isNewRecipe)
    {
      aIngredientUsage.setRecipe(this);
    }
    else
    {
      ingredientUsages.add(aIngredientUsage);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIngredientUsage(IngredientUsage aIngredientUsage)
  {
    boolean wasRemoved = false;
    //Unable to remove aIngredientUsage, as it must always have a recipe
    if (!this.equals(aIngredientUsage.getRecipe()))
    {
      ingredientUsages.remove(aIngredientUsage);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addIngredientUsageAt(IngredientUsage aIngredientUsage, int index)
  {  
    boolean wasAdded = false;
    if(addIngredientUsage(aIngredientUsage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredientUsages()) { index = numberOfIngredientUsages() - 1; }
      ingredientUsages.remove(aIngredientUsage);
      ingredientUsages.add(index, aIngredientUsage);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIngredientUsageAt(IngredientUsage aIngredientUsage, int index)
  {
    boolean wasAdded = false;
    if(ingredientUsages.contains(aIngredientUsage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredientUsages()) { index = numberOfIngredientUsages() - 1; }
      ingredientUsages.remove(aIngredientUsage);
      ingredientUsages.add(index, aIngredientUsage);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIngredientUsageAt(aIngredientUsage, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<User> copyOfUsers = new ArrayList<User>(users);
    users.clear();
    for(User aUser : copyOfUsers)
    {
      aUser.removeRecipe(this);
    }
    ArrayList<Diet> copyOfDiets = new ArrayList<Diet>(diets);
    diets.clear();
    for(Diet aDiet : copyOfDiets)
    {
      aDiet.removeRecipe(this);
    }
    for(int i=ingredientUsages.size(); i > 0; i--)
    {
      IngredientUsage aIngredientUsage = ingredientUsages.get(i - 1);
      aIngredientUsage.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "rname" + ":" + getRname()+ "," +
            "recipe" + ":" + getRecipe()+ "," +
            "rating" + ":" + getRating()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null");
  }
}