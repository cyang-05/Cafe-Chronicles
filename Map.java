// import java.util.Arrays;

public class Map {

    private Room[][] arrayMap;
    // bounds of the rows and columns 
    private int maxRow = 2;
    private int maxCol = 2;
    private int leastRow = 0;
    private int leastCol = 0;

    public Map() {
        this.arrayMap = new Room[3][3];


        arrayMap[0][0] = new Room("Oak & Ember Cafe");
        arrayMap[0][0].setLocation(0,0);

        arrayMap[0][1] = new Room("Willowhush Forest");
        arrayMap[0][1].setLocation(0,1);

        arrayMap[0][2] = new Room("Willowhush Forest", new Ingredient("Caramel Syrup", "pumps", 2), new Ingredient("Brown Sugar", "teaspoons", 10), new Ingredient("Whole Milk", "Cups", 0.5), new Ingredient("Espresso", "shots", 2));
        arrayMap[0][2].setLocation(0,2);

        arrayMap[1][0] = new Room("Stillmist Valley");
        arrayMap[1][0].setLocation(1,0);

        arrayMap[1][1] = new Room("Willowhush Forest", new Person("Berta"));
        arrayMap[1][1].setLocation(1,1);

        arrayMap[1][2] = new Room("Brooknest Cavern", new Ingredient("Espresso", "shots", 3), new Ingredient("Water", "Cups", 0.25), new Ingredient("Ice", "cubes", 15), new Ingredient("N/A", "N/A", 0));
        arrayMap[1][2].setLocation(1,2);

        arrayMap[2][0] = new Room("Stillmist Valley");
        arrayMap[2][0].setLocation(2,0);

        arrayMap[2][1] = new Room("Moonrest Cove", new Ingredient("Vanilla Syrup", "pumps", 2), new Ingredient("Normal Sugar", "teaspoons", 10), new Ingredient("Oat Milk", "Cups", 0.5), new Ingredient("Matcha Powder", "teaspoons", 3));
        arrayMap[2][1].setLocation(2,1);

        arrayMap[2][2] = new Room("Brooknest Cavern", new Person("Berta"));
        arrayMap[2][2].setLocation(2,2);

    }



    /**
     * accesses the actual 2D array map, not the object map
     * @return
     */
    public Room [][] getArrayMap() {
        return arrayMap;
    }

    /**
     * accesses max number of rows
     * @return maxRow
     */
    public int getMaxRow() {
        return maxRow;
    }


    /**
     * accesses max number of columns
     * @return maxCol
     */
    public int getMaxCol() {
        return maxCol;
    }


    /**
     * accesses least number of rows
     * @return leastRow
     */
    public int getLeastRow() {
        return leastRow;
    }


    /**
     * accesses least number of columns
     * @return leastCol
     */
    public int getLeastCol() {
        return leastCol;
    }


}