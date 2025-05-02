
import java.util.ArrayList;
//Attributes
public class Drink {
String name;
ArrayList<Ingredient>ingredients;

/**
 * Constructor for drink
 * @param name of drink
 */
public Drink(String name){
   this.name = name;
   this.ingredients = new ArrayList<>();
}
 
/**
 * Method to add ingredients for each drink
 */
public void addIngredient(String name, String units, double amount){
    ingredients.add(new Ingredient(name, units, amount));
}
/**
 * I'll do this eventually
 */
public void printIngredients() {
    System.out.println(name +" " + "Ingredients:");
    for (Ingredient ingredient: ingredients ){
        System.out.println(ingredient);
    }

} 
/**
 * toString method for ingredients
 * @return ingredients
 */
public String toString() {
    return ingredients.toString();
}

/**
 * arrayList to hold all drink ingredients
 * @return ingredients
 */

public ArrayList<Ingredient>getIngredients(){
    return ingredients;
}


/**
 * Getter for drink name
 * @return name
 */
public String getName(){
    return name;
}


}