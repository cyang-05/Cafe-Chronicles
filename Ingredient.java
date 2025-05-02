public class Ingredient {
    //Attributes 
    private String name;
    private String units;
    private double amount;
    
    public Ingredient(String name, String units, double amount){
        this.name = name;
        this.units = units;
        this.amount = amount;

    }

    /**
     * Getter for ingredient name
     * @return name of ingredient
     */

    public String getName() {
        return name;
    }

    /**
     * Getter for type of units of ingredient
     * @return units
     */

    public String getUnits() {
        return units;
    }

    /**
     * Getter for amount of each ingredient
     * @return amount
     */

    public double getAmt() {
        return amount;
    }


    /**
     * toString method for printing out ingredient concisely 
     * @return toString output
     */
    // right now used for debugging
    @Override
    public String toString() {
        return amount + " " + units + " " + "of" + " " + name ;
    }

    /**
     * main method for ingredient class
     * @param args
     */
    
    public static void main(String[] args) {
        Ingredient myMatcha = new Ingredient("Matcha Powder", "teaspoons", 3);
        System.out.println(myMatcha);
    }

}
