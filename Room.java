import java.util.Arrays;

public class Room {
    
    // Attributes 
    private String roomName;
    private Ingredient ingre_1;
    private Ingredient ingre_2;
    private Ingredient ingre_3;
    private Ingredient ingre_4;
    private Person aPerson;
    private int[] location = new int[2];


    /**
     * constructor with room name and person
     * @param rName
     * @param anyPerson
     */
    public Room(String rName, Person anyPerson) {
        this.roomName = rName;
        this.aPerson = anyPerson;
    }


    /**
     * constructor with just room name, for when room does not have ingredients 
     * @param rName
     */
    public Room(String rName) {
        this.roomName = rName;
    }

    /**
     * full constructor for room w/multiple ingredients 
     * @param rName
     * @param ingre_1
     */
    public Room(String rName, Ingredient ingre, Ingredient ingre2, Ingredient ingre3, Ingredient ingre4) {
        this.roomName = rName;
        this.ingre_1 = ingre;
        this.ingre_2 = ingre2;
        this.ingre_3 = ingre3;
        this.ingre_4 = ingre4;
    }



    /**
     * accessor for name of room
     * @return roomName
     */
    public String getName() {
        return roomName;
    }



    /**
     * accessor for ingredient 1
     * @return ingre
     */
    public Ingredient getIngre1() {
        return ingre_1;
    }

    /**
     * accessor for ingredient 2
     * @return
     */
    public Ingredient getIngre2() {
        return ingre_2;
    }

    /**
     * accessor for ingredient 3
     * @return
     */
    public Ingredient getIngre3() {
        return ingre_3;
    }

    /**
     * accessor for ingredient 4
     * @return
     */
    public Ingredient getIngre4() {
        return ingre_4;
    }


    /**
     * converts roomName to a String
     * @return roomName
     */
    public String toString() {
        return "You are now at " + this.roomName;
    }

    /**
     * gets room indicies and stores in location array 
     * @param row
     * @param col
     */
    public void setLocation(int row, int col) {
        this.location[0] = row;
        this.location[1] = col;
    }
    

    /**
     * converts room indicies into string  
     * @return String location
     */
    public String getIndicies() {
        return Arrays.toString(location);
    }



}
