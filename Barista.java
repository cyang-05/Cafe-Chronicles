import java.util.ArrayList;
import java.util.Scanner;


public class Barista extends Person {
    
    // Attributes 
    private static Scanner input = new Scanner(System.in);
   
    // holds the location of barista 
    private int rowIndex;
    private int colIndex;
   
    // if player enters quit
    private boolean quitFlag = false; 

    // related to map 
    private Map myMap; // map player is in 
    private Room currentRoom; // holds player's current room location
    
    private String answer; // holds player's answer
    private String direction; // holds player's answer to which direction they'd like to move

    // barista/player's inventory, will hold ingredients that barista grabs
    private static ArrayList<Ingredient> baristaIngre;

    private Drink myDrink; // drink that is created in makeDrink method

    private static Drink custDrink; // drink that customer chooses, will be a randomized drink

    private static ArrayList<Ingredient> customerIngredient = new ArrayList<>(); // customer inventory for ingredients

    private boolean hasLeftCafe = false; // tracks if player left cafe, will turn true if player leaves
    
   


    /**
     * constructor for barista
     * @param name
     */
    public Barista (String name) {
        super(name);
        this.myMap = new Map();
        this.currentRoom = myMap.getArrayMap()[0][0];
        Barista.baristaIngre = new ArrayList<>();
    }

    /**
     * accesses boolean value of quitFlag
     * @return quitFlag
     */    
    public boolean getQuit() {
        return quitFlag;
    }

    /**
     * accesses the map
     * @return bMap
     */
    public Map getMap() {
        return myMap;
    }

    /**
     * accesses the player's current room
     * @return currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * accesses the player's current answer
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * accesses barista's inventory 
     * @return baristaIngre
     */
    public static ArrayList <Ingredient> getBaristaIngre() {
        return Barista.baristaIngre;
    }

    /**
     * accesses the customer drink
     * @return custDrink
     */
    public static Drink getCustDrink() {
        return custDrink;
    }


    /**
     * sets custDrink equal to drink
     * @param drink
     */
    public static void setCustDrink(Drink drink) {
        custDrink = drink;
    }

    /**
     * accesses customer inventory 
     * @return customerIngredient 
     */
    public static ArrayList<Ingredient> getCustomerIngredient(){
        return customerIngredient;
    }

    /**
     * adds ingredients to customer inventory for drink
     * @param custIngre
     */
    public static void addCustIngre(Ingredient custIngre){
        customerIngredient.add(custIngre);
        customerIngredient.add(custIngre);
        customerIngredient.add(custIngre);
        customerIngredient.add(custIngre);

    }



    // Works!!
    /**
     * lets barista talk with manager 
     * @param Berta
     */
    public void talk(Manager Berta, Drink custDrink) {
        // System.out.println(custDrink.getName());
        if (((currentRoom.getIndicies().equals("[1, 1]")) || (currentRoom.getIndicies().equals("[2, 2]"))) && (baristaIngre.isEmpty())) {
            System.out.println("You come across Oak & Ember Cafe's notorious manager, Berta.");
            Berta.talk(this, custDrink);
        } 
        // if ((currentRoom.getIndicies().equals("[2, 2]")) && (baristaIngre.isEmpty())) {
        //     System.out.println("You come across Oak & Ember Cafe's notorious manager, Berta.");
        //     Berta.talk(this, custDrink);
        // }
        if (((currentRoom.getIndicies().equals("[1, 1]")) || (currentRoom.getIndicies().equals("[2, 2]"))) && (!baristaIngre.isEmpty())) {
            // System.out.println(currentRoom.getIndicies());
            System.out.println("You come across Oak & Ember Cafe's notorious manager, Berta.");
            Berta.talk(this, custDrink);
        }
    } 


    // Works!
    /**
     * makes the drink that customer ordered
     * @param drink
     */
    public void makeDrink(Drink custDrink) {
        if ((baristaIngre.toString().equals(custDrink.getIngredients().toString()))) {
            System.out.println("To make the " + custDrink.getName() + " type 'make.'");
            answer = input.nextLine().toLowerCase();

            if (answer.equals("help")) {
                Cafe.help();
            }

            
            if (answer.equals("make")) {
                System.out.println("One " + custDrink.getName() + " coming right up!");
                
                if (custDrink.getName().equals("Latte")) {
                    System.out.println("Making latte...");
                    myDrink = Cafe.makeLatte();
                    System.out.println(myDrink.getName() + " created. To hand the drink to the customer, type 'hand.'");
                    answer = input.nextLine().toLowerCase();
                    if (answer.equals("hand")) {
                        handDrink(myDrink);
                    } while (!answer.equals("hand")) {
                        System.out.println("You did not type 'hand.' Try again.");
                        answer = input.nextLine().toLowerCase();
                        if (answer.equals("hand")) {
                            handDrink(myDrink);
                        }
                    }
                }
                if (custDrink.getName().equals("Matcha")) {
                    System.out.println("Making matcha...");
                    myDrink = Cafe.makeMatcha();
                    System.out.println(myDrink.getName() + " created. To hand the drink to the customer, type 'hand.'");
                    answer = input.nextLine().toLowerCase();
                    if (answer.equals("hand")) {
                        handDrink(myDrink);
                    } while (!answer.equals("hand")) {
                        System.out.println("You did not type 'hand.' Try again.");
                        answer = input.nextLine().toLowerCase();
                        if (answer.equals("hand")) {
                            handDrink(myDrink);
                        }
                    }
                    
                }
                if (custDrink.getName().equals("Americano")) {
                    System.out.println("Making americano...");
                    myDrink = Cafe.makeAmericano();
                    System.out.println(myDrink.getName() + " created. To hand the drink to the customer, type 'hand.'");
                    answer = input.nextLine().toLowerCase();
                    if (answer.equals("hand")) {
                        handDrink(myDrink);
                    } while (!answer.equals("hand")) {
                        System.out.println("You did not type 'hand.' Try again.");
                        answer = input.nextLine().toLowerCase();
                        if (answer.equals("hand")) {
                            handDrink(myDrink);
                        }
                    }
                }

            } else {
                System.out.println("You did not type 'make.' Try again.");
                makeDrink(custDrink);
            }
        }
    }
    

    // works!
    /**
     * "hand" drink to customer
     * @param drink
     */
    public void handDrink(Drink drink) {
        System.out.println("Barista: Here is your " + drink.getName() + "! Enjoy!");
        getCustomerIngredient().clear();
        getCustomerIngredient().addAll(baristaIngre);
    }


    // fully works now!
    /**
     * allows player (barista) to move
     */
    public void move(Drink custDrink) {
        
        System.out.println("Where would you like to go? Your options are north, east, south, or west. Type a direction.");
        System.out.println("If you would like to quit the game, type 'quit'.");
        direction = input.nextLine().toLowerCase();

        if (direction.equals("quit")) {
            quitFlag = true;
            System.out.println("Thanks for playing!");
            return;
        } if (direction.equals("help")) {
            Cafe.help();
        } else if (direction.equals("drop")) {
            dropIngre();
        }


        if (direction.equals("north")) {
            // System.out.println("The indicies before moving are " + currentRoom.getIndicies());
            int tempRow = rowIndex - 1;
            // System.out.println("this is tempRow:" + tempRow);
            
            if ((tempRow <= myMap.getMaxRow()) && (tempRow >= myMap.getLeastRow())) {
                // System.out.println("valid tempRow");
                rowIndex = tempRow;
                // System.out.println("new rowIndex:" + rowIndex);
                // System.out.println("current colIndex:" + colIndex);
                currentRoom = myMap.getArrayMap()[rowIndex][colIndex];
                leftCafe();
                if (!currentRoom.getIndicies().equals("[0, 0]")) {
                    System.out.println(currentRoom.toString());
                }
                // System.out.println("Current room indicies" + currentRoom.getIndicies());
                enterCafe();
                checkRoomIngre(custDrink);
                if (currentRoom.getIndicies().equals("[1, 1]")) {
                    talk(new Manager("Berta", myMap, 1, 1), custDrink);
                }
                // talk(new Manager("Berta", myMap, 1, 1), custDrink);
                System.out.println("To empty your inventory, type 'drop' at any point in your adventure.");
                finished(custDrink);
            } else {
                // System.out.println("invalid tempRow. did not move north");
                System.out.println("Invalid direction. You cannot move north.");
            }
        
    }

        if (direction.equals("south")) {
            // System.out.println("The indicies before moving are " + currentRoom.getIndicies());
            int tempRow = rowIndex + 1;
            // System.out.println("this is tempRow:" + tempRow);
            
            if ((tempRow <= myMap.getMaxRow()) && (tempRow >= myMap.getLeastRow())) {
                // System.out.println("valid tempRow");
                rowIndex = tempRow;
                // System.out.println("new rowIndex:" + rowIndex);
                // System.out.println("current colIndex:" + colIndex);
                currentRoom = myMap.getArrayMap()[rowIndex][colIndex];
                leftCafe();
                System.out.println(currentRoom.toString());
                // System.out.println("Current room indicies" + currentRoom.getIndicies());
                enterCafe();
                checkRoomIngre(custDrink);
                if (currentRoom.getIndicies().equals("[1, 1]")) {
                    talk(new Manager("Berta", myMap, 1, 1), custDrink);
                } else if (currentRoom.getIndicies().equals("[2, 2]")) {
                    talk(new Manager("Berta", myMap, 2, 2), custDrink);
                }
                System.out.println("To empty your inventory, type 'drop' at any point in your adventure.");
                finished(custDrink);
            } else {
                // System.out.println("invalid tempRow. did not move south");
                System.out.println("Invalid direction. You cannot move south.");
            }
    }


        if (direction.equals("west")) {
            // System.out.println("The indicies before moving are " + currentRoom.getIndicies());
            int tempCol = colIndex - 1;
            // System.out.println("this is tempCol:" + tempCol);
            
            if ((tempCol <= myMap.getMaxCol()) && (tempCol >= myMap.getLeastCol())) {
                // System.out.println("valid tempCol");
                colIndex = tempCol;
                // System.out.println("new colIndex:" + colIndex);
                // System.out.println("current rowIndex:" + rowIndex);
                currentRoom = myMap.getArrayMap()[rowIndex][colIndex];
                leftCafe();
                if (!currentRoom.getIndicies().equals("[0, 0]")) {
                    System.out.println(currentRoom.toString());
                }
                // System.out.println("Current room indicies" + currentRoom.getIndicies());
                enterCafe();
                checkRoomIngre(custDrink);
                if (currentRoom.getIndicies().equals("[1, 1]")) {
                    talk(new Manager("Berta", myMap, 1, 1), custDrink);
                } 
                System.out.println("To empty your inventory, type 'drop' at any point in your adventure.");
                finished(custDrink);
            } else {
                // System.out.println("invalid tempRow. did not move south");
                System.out.println("Invalid direction. You cannot move west.");
            }

    }

        
        if (direction.equals("east")) {
            // System.out.println("The indicies before moving are " + currentRoom.getIndicies());
            int tempCol = colIndex + 1;
            // System.out.println("this is tempCol:" + tempCol);
            
            if ((tempCol <= myMap.getMaxCol()) && (tempCol >= myMap.getLeastCol())) {
                // System.out.println("valid tempCol");
                colIndex = tempCol;
                // System.out.println("new colIndex:" + colIndex);
                // System.out.println("current rowIndex:" + rowIndex);
                currentRoom = myMap.getArrayMap()[rowIndex][colIndex];
                leftCafe();
                System.out.println(currentRoom.toString());
                // System.out.println("Current room indicies" + currentRoom.getIndicies());
                enterCafe();
                checkRoomIngre(custDrink);
                if (currentRoom.getIndicies().equals("[1, 1]")) {
                    talk(new Manager("Berta", myMap, 1, 1), custDrink);
                } else if (currentRoom.getIndicies().equals("[2, 2]")) {
                    talk(new Manager("Berta", myMap, 2, 2), custDrink);
                }
                System.out.println("To empty your inventory, type 'drop' at any point in your adventure.");
                finished(custDrink);

            } else {
                // System.out.println("invalid tempCol. did not move east");
                System.out.println("Invalid direction. You cannot move east.");
            }
   

        }
                
    }


    /**
     * turns hasLeftCafe boolean true when player has left cafe 
     */
    public void leftCafe() {
        //System.out.println(hasLeftCafe);
        if (!currentRoom.getIndicies().equals("[0, 0]")) {
            hasLeftCafe = true;
            // System.out.println(hasLeftCafe);
        }
    }


    /**
     * does not allow player to enter cafe if they did not collect ingredients yet 
     * ingredients are the "key" to enter the cafe again
     */
    public void enterCafe() {
        // System.out.println(direction);
        if ((hasLeftCafe) && (baristaIngre.isEmpty()) && (currentRoom.getIndicies().equals("[0, 0]"))) {
            System.out.println("You cannot enter the Cafe until you collect the ingredients!");
            // System.out.println("The direction entered is " + direction);
            if (direction.equals("north")) {
                rowIndex = 1;
                colIndex = 0;
                // System.out.println(rowIndex);
                // System.out.println(colIndex);
                currentRoom = myMap.getArrayMap()[1][0];
                // System.out.println(currentRoom.getIndicies());
                System.out.println("You are still in the " + currentRoom.getName());
            } else if (direction.equals("west")) {
                rowIndex = 0;
                colIndex = 1;
                // System.out.println(rowIndex);
                // System.out.println(colIndex);
                currentRoom = myMap.getArrayMap()[0][1];
                // System.out.println(currentRoom.getIndicies());
                System.out.println("You are still in the " + currentRoom.getName());

            }
        }
    }


    // works
    // Drink custDrink is a placeholder for the actual drink that will be passed in as a parameter when using this method
    /**
     * allows player (barista) to grab ingredients 
     * @param custDrink
     */
    public void grabIngre(Drink custDrink) {

            // System.out.println("These are the ingredients you will need to pick up " + custDrink.getIngredients()); // w/this method, the ingredients list is empty
            if ((!baristaIngre.contains(custDrink.getIngredients().get(0)))) {
                // System.out.println("This is w/out toString: " + custDrink.getIngredients().get(0));
                // System.out.println("This is w/toString: " + custDrink.getIngredients().get(0).toString());
                
                baristaIngre.add(currentRoom.getIngre1());
                // System.out.println("This is w/out toString: " + baristaIngre.get(0));
                // System.out.println("This is w/toString: " + baristaIngre.get(0).toString());
                // System.out.println(baristaIngre.toString());
            }

            if ((!baristaIngre.contains(custDrink.getIngredients().get(1)))) {
                // System.out.println("This is w/out toString: " + custDrink.getIngredients().get(1));
                // System.out.println("This is w/toString: " + custDrink.getIngredients().get(1).toString());
                
                baristaIngre.add(currentRoom.getIngre2());
                // System.out.println("This is w/out toString: " + baristaIngre.get(1));
                // System.out.println("This is w/toString: " + baristaIngre.get(1).toString());
                // System.out.println(baristaIngre.toString());

            }

            if ((!baristaIngre.contains(custDrink.getIngredients().get(2)))) {
                // System.out.println("This is w/out toString: " + custDrink.getIngredients().get(2));
                // System.out.println("This is w/toString: " + custDrink.getIngredients().get(2).toString());

                baristaIngre.add(currentRoom.getIngre3());
                // System.out.println("This is w/out toString: " + baristaIngre.get(2));
                // System.out.println("This is w/toString: " + baristaIngre.get(2).toString());
                // System.out.println(baristaIngre.toString());
            }

            if ((!baristaIngre.contains(custDrink.getIngredients().get(3)))) {
                // System.out.println("This is w/out toString: " + custDrink.getIngredients().get(3));
                // System.out.println("This is w/toString: " + custDrink.getIngredients().get(3).toString());

                baristaIngre.add(currentRoom.getIngre4());
                // System.out.println("This is w/out toString: " + baristaIngre.get(3));
                // System.out.println("This is w/toString: " + baristaIngre.get(3).toString());
                System.out.println("Updated inventory: " + baristaIngre.toString());
                System.out.println("Find your way back to the Cafe to make the " + custDrink.getName().toString() + ".");
            }

        }

    

    /**
     * allows player (barista) to drop ingredients
     */
    public void dropIngre() {
        System.out.println("This is your current inventory: " + baristaIngre.toString());

        if ((direction.equals("drop")) && (!baristaIngre.isEmpty())) {
            baristaIngre.removeIf(n -> true); // removes ingredients according to parameter
            System.out.println("You have dropped all of your ingredients!");
            System.out.println("Updated inventory: " + baristaIngre.toString());
        } else {
            System.out.println("Guess you don't want to empty your inventory!");
        }

    }

    // works!
    /**
     * checks if barista made it back to cafe and if inventory is equivalent to drink ingredients 
     * @param custDrink
     */
    public void finished(Drink custDrink) {
        // System.out.println("This is the finished method");
        // System.out.println("This is the barista inventory " + baristaIngre.toString());
        // System.out.println("This is the custDrink list " + custDrink.getIngredients().toString());
        if ((currentRoom.getIndicies().equals("[0, 0]")) && (baristaIngre.toString().equals(custDrink.getIngredients().toString()))) {
            System.out.println("Congrats! You have made it back to the Cafe and have all your ingredients!");
            makeDrink(custDrink);
    }}


    // works!
    /**
     * checks if current room has ingredients 
     * @param custDrink
     */
    public void checkRoomIngre(Drink custDrink) {
        if ((currentRoom.getIndicies().equals("[0, 2]")) && (custDrink.getName().toString().equals("Latte")) && (baristaIngre.isEmpty())) {
            System.out.println("The " + currentRoom.getName() + " has ingredients for a " + custDrink.getName() + ". Would you like to pick it up? If so, type 'grab'. If not, type 'no'.");
            answer = input.nextLine().toLowerCase();

            if ((answer.equals("grab"))) {
                Drink latte = Cafe.makeLatte();
                grabIngre(latte);
            } else if (answer.equals("help")) {
                Cafe.help();
            }
        }

        if ((currentRoom.getIndicies().equals("[1, 2]")) && (custDrink.getName().toString().equals("Americano")) && (baristaIngre.isEmpty())) {
            System.out.println("The " + currentRoom.getName() + " has ingredients for a " + custDrink.getName() + ". Would you like to pick it up? If so, type 'grab'. If not, type 'no'.");
            answer = input.nextLine().toLowerCase();

            if ((answer.equals("grab"))) {
                Drink americano = Cafe.makeAmericano();
                grabIngre(americano);
            } else if (answer.equals("help")) {
                Cafe.help();
            }
        }

        if ((currentRoom.getIndicies().equals("[2, 1]")) && (custDrink.getName().toString().equals("Matcha")) && (baristaIngre.isEmpty())) {
            System.out.println("The " + currentRoom.getName() + " has ingredients for a " + custDrink.getName() + ". Would you like to pick it up? If so, type 'grab'. If not, type 'no'.");
            answer = input.nextLine().toLowerCase();

            if ((answer.equals("grab"))) {
                Drink matcha = Cafe.makeMatcha();
                grabIngre(matcha);
            } else if (answer.equals("help")) {
                Cafe.help();
            }
        } 
    }



    // // will be in main class
    // public String toString() {
    //     return "Let's get started " + getName() + "! Type 'go' to start your adventure!";
    // }




    // // debugging purposes
    // public static void main(String[] args) {

    //     ArrayList<Ingredient>customerIngredient = new ArrayList<>();

    //     customerIngredient.add(new Ingredient("a", "b", 0));
    //     customerIngredient.add(new Ingredient("a", "b", 0));
    //     customerIngredient.add(new Ingredient("a", "b", 0));
    //     customerIngredient.add(new Ingredient("a", "b", 0));

    //     // System.out.println(customerIngredient);

    //     // System.out.println(customerIngredient.toString());
    //     System.out.println("Welcome to the game!");
    //     Barista myBarista = new Barista("Chiashi");
    //     System.out.println(myBarista);
    //     String startGame = input.nextLine().toLowerCase();
    //     if (startGame.equals("go")) {

    //         // while it is false, once it is true = breaks loop
    //         while (!myBarista.getQuit()) {
    //             myBarista.move(custDrink);
    //         }
    //     } else {
    //         System.out.println("Try answering again. Please enter 'go' or 'Go'");
    //         String start = input.nextLine();
    //     }


    // }

}