package Assignment01;

import java.util.Scanner;

/**
 * Add, search, remove, and display all of the names and phone numbers in the
 * database.
 * 
 * @author Junsang (Jason) Yoo
 * @version 2022
 * 
 */
public class Main {

    /** Database */
    private String[] database;

    /** Input */
    private Scanner input;

    /**
     * Constructor sets the database, and input.
     */
    public Main() {
        database = new String[0];
        input = new Scanner(System.in);
    }

    /**
     * Add the name to the database.
     * 
     * @param name a string representing the adding name and phone number.
     */
    public void add(final String name) {
        int size = database.length + 1;
        String[] temp = database;
        database = new String[size];
        for (int i = 0; i < temp.length; i++) {
            database[i] = temp[i];
        }
        database[size - 1] = name;
    }

    /**
     * Search the name in the database.
     * 
     * @param name a string representing the searching name
     * @return the index number in the database as an integer
     */
    public int search(final String name) {
        int n = -1;
        for (int i = 0; i < database.length; i++) {
            if (database[i].toLowerCase().equals(name.toLowerCase())) {
                n = i;
            }
        }
        return n;
    }

    /**
     * Display all of names and phone numbers in the database.
     */
    public void displayAll() {
        System.out.println("Name\t\t PhoneNumber");
        for (int i = 0; i < database.length; i++) {
            System.out.println(database[i]);
        }
    }

    /**
     * Remove the typed name from the database.
     * 
     * @param name a string representing removing name in the database
     * @return true if the name is in the database
     *         false if the name is not in the database
     */
    public boolean remove(final String name) {
        int pos = search(name);
        if (pos >= 0) {
            String[] temp = new String[database.length - 1];
            System.arraycopy(database, 0, temp, 0, pos);
            System.arraycopy(database, pos + 1, temp, pos, database.length - pos - 1);
            database = temp;
            return true;
        }
        return false;
    }

    /**
     * Displays the menu.
     */
    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }

    /**
     * Gets the user's choice.
     * 
     * @return choice of the user that a number of the menu as an integer
     */
    public int getChoice() {
        int choice = 4;// default
        boolean done = false;
        while (!done) {
            System.out.print("choice? ");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
            }
            if (choice > 0 && choice <= 5)
                done = true;
            else
                System.out.println("\nYour choice is incorrect, please try again");
        }
        return choice;
    }

    /**
     * Adds the person's name and phone number in the database.
     */
    public void addPerson() {
        String name = "";
        String phone = "";
        boolean done = false;
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.print("\nEnter the persons phone number ");
            phone = input.next();
            System.out.println("");
        } catch (Exception e) {
        }
        add(name.substring(0, 1).toUpperCase() + name.substring(1) + "\t\t " + phone.substring(0, 3) + "-"
                + phone.substring(3));
    }

    /**
     * Deletes the typed name and phone number from the database
     */
    public void deletePerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
        }
        if (!remove(name))
            System.out.println("Could not delete " + name);
        else
            System.out.println(name + " was deleted successfully");
    }

    /**
     * Finds the person's name in the database.
     */
    public void findPerson() {
        String name = "";
        try {
            System.out.print("Enter the persons name ");
            name = input.next();
            System.out.println("");
        } catch (Exception e) {
        }
        int pos = search(name);
        if (pos >= 0) {
            System.out.println(pos);
        } else {
            System.out.println("No such person");
        }
    }

    /**
     * Runs the program.
     */
    public void run() {
        int choice = 0;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    deletePerson();
                    break;
                case 3:
                    findPerson();
                    break;
                case 4:
                    displayAll();
                default:
                    // should not get here
            }

        } while (choice != 5);
    }

    /**
     * Drives the program.
     * 
     * @param args the arguments
     */
    public static void main(String[] args) {
        new Main().run();
    }
}
