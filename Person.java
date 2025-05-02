import java.util.Scanner;


public class Person {
    
    // Attributes
    private String name;
    private Scanner input = new Scanner(System.in);


    /**
     * constructor for person
     * @param name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * accesses the name of person
     * @return name
     */
    public String getName() {
        return name;
    }
    
}

