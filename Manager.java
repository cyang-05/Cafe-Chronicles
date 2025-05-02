import java.util.Scanner;
// import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.Collections;

public class Manager extends Person{
    //Attributes
    protected static String Berta; //name
    public static Scanner input = new Scanner(System.in); //scanner
    private String question; // riddle question
    private String correctAnswer; // answer
    private Room managerLocation; // getting all the locations (might need to change)
    private Map map;

    private static ArrayList <String> riddles = new ArrayList<>();

    
    /** Constructor that also gives Berta her positions
     * @param Berta
     * @param map
     * @param row
     * @param col
     */
    public Manager (String Berta, Map map, int row, int col) { 
        super(Berta);
        // this.x = x;
        // this.y = y;
        this.managerLocation = map.getArrayMap()[row][col];
    }

    /**
     * getter for the manager's location
     * @return
     */
    public Room getManagerLocation(){
        return managerLocation;
    }

    
    /**
     * setter for the manager's location
     * @param row
     * @param col
     */
    public void setManagerLocation(int row, int col){
        this.managerLocation = map.getArrayMap()[row][col];
    }


    /**
     * checking if the barista is at the same location as manager
     * @param barista
     * @return
     */
    public boolean sameLocation(Barista barista){
        return barista.getCurrentRoom().equals(managerLocation); //if the locations are the same, returns boolean
    }


    /**
     * adds riddles to riddle list
     */
    public static void addRiddle() {
        Manager.riddles.add("When the sun climbs high and thirst grips the realm, what sacred liquid do mortals most often crave to cool their flame—brewed from beans, dark as night?");
        Manager.riddles.add("Morning magic in a steaming swirl. Dark as night with a bitter curl. Sip me slowly, I chase the yawn. Guess my name before I'm gone.");
        Manager.riddles.add("I'm not your regular latte crew. I come in green, not brown or blue. I don't get brewed, I get whipped to glow. In every café I steal the show. What am I?");
    }


    /**
     * checks riddle question and assigns answer to correctAnswer attribute according to riddle
     */
    public void checkRiddle() {
        if (question.equals("When the sun climbs high and thirst grips the realm, what sacred liquid do mortals most often crave to cool their flame—brewed from beans, dark as night?")) {
            correctAnswer = "cold brew";
        } else if (question.equals("Morning magic in a steaming swirl. Dark as night with a bitter curl. Sip me slowly, I chase the yawn. Guess my name before I'm gone.")) {
            correctAnswer = "coffee";
        } else {
            correctAnswer = "matcha";
        }
    }


    /**
     * Dialogue between manager and barista according to their locations
     * @param barista
     * @param drink
     */
    public void talk(Barista barista, Drink drink){
        // System.out.println("Normal riddle list:");
        // for (String r : riddles) {
        //     System.out.println(r);
        // }

        // if barista needs help finding ingredients
        if ((sameLocation(barista)) && (Barista.getBaristaIngre().isEmpty())) { //if the barista's location is the same as the manager and barista's inventory isn't empty
        
            Collections.shuffle(Manager.riddles);
            question = Manager.riddles.get(0);
            checkRiddle();
            
            // System.out.println("Shuffled riddles:");
            // for (String r : riddles) {
            //     System.out.println(r);
            // }

            System.out.println("Berta: I'm Berta, your manager. Answer this trivia question right and you wil get a hint to find the ingredients for your " + drink.getName());//print greeting
            System.out.println("Berta: " + question); //print question

            String response_1 = input.nextLine(); // user inputs answer to question

            if (response_1.trim().equalsIgnoreCase(correctAnswer)){ //if the user's response is the correct answer; IgnoreCase ignores the caps and such
                giveHint(drink, barista); //call the giveHint method which print the clue according to the drink
            }
            else { //if answers is wrong, print wrong
                System.out.println("Wrong answer, no hint for you!");
            }
        }

        // if barista already has ingredients and need help getting back to cafe
        if (sameLocation(barista) && (!Barista.getBaristaIngre().isEmpty()) && (barista.getCurrentRoom().getName().equals("Willowhush Forest"))){
            System.out.println("Berta: Hi! Would you like a hint to find your way back to the Cafe?"); ;// asking
            String response_2 = input.nextLine();

            if(response_2.trim().equalsIgnoreCase("yes")){
                System.out.println("Berta: Go in the directions that start with 'N' then 'W'.");
            }
            else if (response_2.trim().equalsIgnoreCase("no")){
                System.out.println("Berta: Fine.");
            }
        }
            
        if (sameLocation(barista) && (!Barista.getBaristaIngre().isEmpty()) && (barista.getCurrentRoom().getName().equals("Brooknest Cavern"))){
            System.out.println("Berta: Hi! Would you like a hint to find your way back to the Cafe?"); ;// asking if they want a hint
            String response_3 = input.nextLine();

            if(response_3.trim().equalsIgnoreCase("yes")){
                System.out.println("Berta: Go in the directions that start with 'N' twice, then 'W' twice. ");
            }
            else if (response_3.trim().equalsIgnoreCase("no")){
                System.out.println("Berta: Fine.");
            }
        }
        else{ //if barista is not in the same location as manager, then return nothing
            return;
        }
    }


    /**
     * Gives hint according to the drink
     * @param drink
     */
    public void giveHint(Drink drink, Barista barista){
        if ((drink.getName().equals("Latte")) && (barista.getCurrentRoom().getIndicies().equals("[1, 1]"))) { //if the drink chosen is the same as matcha
            System.out.println("To find the ingredients for " + drink.getName() + ", go in the direction that starts with 'N' then go in the direction that starts with 'E'"); //give hint
        } else if ((drink.getName().equals("Latte")) && (barista.getCurrentRoom().getIndicies().equals("[2, 2]"))) {
            System.out.println("To find the ingredients for " + drink.getName() + ", go in the direction that starts with 'N' two times.");
        }
         
        if((drink.getName().equals("Matcha")) && (barista.getCurrentRoom().getIndicies().equals("[1, 1]"))){
            System.out.println("To find the ingredients for " + drink.getName() + ", go in the direction that starts with 'S'");
        } else if ((drink.getName().equals("Matcha")) && (barista.getCurrentRoom().getIndicies().equals("[2, 2]"))) {
            System.out.println("To find the ingredients for " + drink.getName() + ", go in the direction that starts with 'W'");
        }
          
        if ((drink.getName().equals("Americano")) && (barista.getCurrentRoom().getIndicies().equals("[1, 1]"))){
            System.out.println("To find the ingredients for " + drink.getName() + ", go in the direction that starts with 'E'"); //add drinks as needed, not finished yet
        } else if ((drink.getName().equals("Americano")) && (barista.getCurrentRoom().getIndicies().equals("[2, 2]"))) {
            System.out.println("To find the ingredients for " + drink.getName() + ", go in the direction that starts with 'N'");
        }
        
    }



    // public static void main(String[] args) {
    //     List<String> mLocations = Arrays.asList("Forest, Pond");
    //     Manager manager = new Manager("Berta", mLocations);
    // }
}

//make a map but for the barrista so it sets the barrista's location