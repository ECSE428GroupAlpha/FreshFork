/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package main.java.com.freshfork.backend.models;
import java.util.*;

// line 28 "../../../../../../Untitled.ump"
public class Ingredient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ingredient Attributes
  private int calories;
  private double protein;
  private double carb;
  private int sugar;
  private double fats;
  private double iron;
  private String iname;
  private int quantity;
  private String unitSI;

  //Ingredient Associations
  private List<IngredientUsage> ingredientUsages;
  private List<User> users;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ingredient(int aCalories, double aProtein, double aCarb, int aSugar, double aFats, double aIron, String aIname, int aQuantity, String aUnitSI)
  {
    calories = aCalories;
    protein = aProtein;
    carb = aCarb;
    sugar = aSugar;
    fats = aFats;
    iron = aIron;
    iname = aIname;
    quantity = aQuantity;
    unitSI = aUnitSI;
    ingredientUsages = new ArrayList<IngredientUsage>();
    users = new ArrayList<User>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCalories(int aCalories)
  {
    boolean wasSet = false;
    calories = aCalories;
    wasSet = true;
    return wasSet;
  }

  public boolean setProtein(double aProtein)
  {
    boolean wasSet = false;
    protein = aProtein;
    wasSet = true;
    return wasSet;
  }

  public boolean setCarb(double aCarb)
  {
    boolean wasSet = false;
    carb = aCarb;
    wasSet = true;
    return wasSet;
  }

  public boolean setSugar(int aSugar)
  {
    boolean wasSet = false;
    sugar = aSugar;
    wasSet = true;
    return wasSet;
  }

  public boolean setFats(double aFats)
  {
    boolean wasSet = false;
    fats = aFats;
    wasSet = true;
    return wasSet;
  }

  public boolean setIron(double aIron)
  {
    boolean wasSet = false;
    iron = aIron;
    wasSet = true;
    return wasSet;
  }

  public boolean setIname(String aIname)
  {
    boolean wasSet = false;
    iname = aIname;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public boolean setUnitSI(String aUnitSI)
  {
    boolean wasSet = false;
    unitSI = aUnitSI;
    wasSet = true;
    return wasSet;
  }

  public int getCalories()
  {
    return calories;
  }

  public double getProtein()
  {
    return protein;
  }

  public double getCarb()
  {
    return carb;
  }

  public int getSugar()
  {
    return sugar;
  }

  public double getFats()
  {
    return fats;
  }

  public double getIron()
  {
    return iron;
  }

  public String getIname()
  {
    return iname;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public String getUnitSI()
  {
    return unitSI;
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
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  /**
   * allergies
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfIngredientUsages()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public IngredientUsage addIngredientUsage(int aUnitQuantity, Recipe aRecipe)
  {
    return new IngredientUsage(aUnitQuantity, aRecipe, this);
  }

  public boolean addIngredientUsage(IngredientUsage aIngredientUsage)
  {
    boolean wasAdded = false;
    if (ingredientUsages.contains(aIngredientUsage)) { return false; }
    Ingredient existingIngredient = aIngredientUsage.getIngredient();
    boolean isNewIngredient = existingIngredient != null && !this.equals(existingIngredient);
    if (isNewIngredient)
    {
      aIngredientUsage.setIngredient(this);
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
    //Unable to remove aIngredientUsage, as it must always have a ingredient
    if (!this.equals(aIngredientUsage.getIngredient()))
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
    if (aUser.indexOfIngredient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUser.addIngredient(this);
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
    if (aUser.indexOfIngredient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUser.removeIngredient(this);
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

  public void delete()
  {
    for(int i=ingredientUsages.size(); i > 0; i--)
    {
      IngredientUsage aIngredientUsage = ingredientUsages.get(i - 1);
      aIngredientUsage.delete();
    }
    ArrayList<User> copyOfUsers = new ArrayList<User>(users);
    users.clear();
    for(User aUser : copyOfUsers)
    {
      aUser.removeIngredient(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "calories" + ":" + getCalories()+ "," +
            "protein" + ":" + getProtein()+ "," +
            "carb" + ":" + getCarb()+ "," +
            "sugar" + ":" + getSugar()+ "," +
            "fats" + ":" + getFats()+ "," +
            "iron" + ":" + getIron()+ "," +
            "iname" + ":" + getIname()+ "," +
            "quantity" + ":" + getQuantity()+ "," +
            "unitSI" + ":" + getUnitSI()+ "]";
  }
}