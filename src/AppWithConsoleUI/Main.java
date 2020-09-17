package AppWithConsoleUI;

public class Main {
    public static void main(String[] args) {
        //creating necessary objects and pass them as parameters into menu class
        Validation validation = new Validation();
        ManageInteraction manageInteraction = new ManageInteraction(validation);

        new Menu(validation, new ManageLeads(validation, manageInteraction), manageInteraction, new Summary()).menu();//calling menu method
    }
}
