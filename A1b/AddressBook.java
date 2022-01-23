/*
 * AddressBook.java

 */

public class AddressBook {
    private final Database database;
    private final UI ui;

    public AddressBook(final UI u) {
        ui = u;
        database = new Database();
    }

    public void addPerson() {
        database.add(ui.readPerson());
    }

    public void deletePerson() {
        String name = ui.readName();
        if (!remove(name)) {
            ui.displayErrorMsg("Could not delete " + name);
        } else {
            ui.displayMsg(name + " was deleted successfully");
        }

    }

    public void findPerson() {
        Person name = search(ui.readName());
        if (name != null) {
            display(name);
        } else {
            ui.displayErrorMsg("No such person");
        }

    }

    private boolean remove(final String name) {
        return (database.removeByName(name) != null);
    }

    private Person search(final String name) {
        return (database.findByName(name));
    }

    public void displayAll() {
        ui.displayAll(database.getAll());
    }

    private void display(final Person person) {
        ui.display(person);
    }
}
