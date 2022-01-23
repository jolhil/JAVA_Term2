import java.util.Scanner;

public class ConsoleUI implements UI {
    private final Scanner input;
    private AddressBook addressBook;

    public ConsoleUI() {
        input = new Scanner(System.in);
    }

    public int readChoice() {
        int choice = 1;
        boolean done = false;
        while (!done) {
            System.out.println("What is your choice? ");
            try {
                choice = input.nextInt();
            } catch (Exception e) {
            }
            if (choice > 0 && choice <= 5) {
                done = true;
            } else {
                System.out.println("\nYour choice is incorrect, please try again.");
            }
        }
        return choice;
    }

    @Override
    public Person readPerson() {
        String name = "";
        String ph = "";
        try {
            System.out.println("Enter the person's name: ");
            name = input.next();
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            System.out.println("\nEnter the person's phone number: ");
            ph = input.next();
            ph = ph.substring(0, 3) + "-" + ph.substring(3);
            System.out.println("");
        } catch (Exception e) {
        }

        Person person = new Person(name, ph);

        return person;
    }

    @Override
    public String readName() {
        String name = "";
        System.out.println("Enter the person's name: ");
        name = input.next();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    }

    @Override
    public void display(Person person) {
        String name = person.getName();
        String ph = person.getPhoneNumber();
        System.out.println("Name: " + name + "\tPhone number:" + ph);
    }

    @Override
    public void displayAll(Person[] people) {
        System.out.println("Name\t\t PhoneNumber");
        for (int i = 0; i < people.length; i++) {
            display(people[i]);
        }

    }

    @Override
    public void run(AddressBook book) {
        addressBook = book;
        int choice = 0;
        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
                case 1:
                    addressBook.addPerson();
                    break;
                case 2:
                    addressBook.deletePerson();
                    break;
                case 3:
                    addressBook.findPerson();
                    break;
                case 4:
                    addressBook.displayAll();
                default:
                    // should not get here
            }

        } while (choice != 5);
    }

    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }

    @Override
    public void displayErrorMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void displayMsg(String msg) {
        System.out.println(msg);
    }

}
