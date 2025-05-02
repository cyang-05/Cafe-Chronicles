
public class Customer {
    //Attributes
    String name;

    /**
     * Constructor for customer
     * @param name
     */
    public Customer(String name) {
        this.name = name;
    }

    
    /**
     * Prints out ordered drink from customer
     * @param customerDrink
     */
    public void orderDrink(Drink customerDrink) {
        System.out.println("You need to create a");
        System.out.println(customerDrink.getName());
        customerDrink.printIngredients();

    }

    /**
     * Getter for customer name
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * toString method to print customer name
     * @return customer name
     */
    public String toString() {
        return name;
    }



}
