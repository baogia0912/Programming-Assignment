package appWithConsoleUI;

public class Main {
    public static void main(String[] args) {
        Validation validation = new Validation();
        ManageInteraction manageInteraction = new ManageInteraction(validation);

        new Menu(validation, new ManageLeads(validation, manageInteraction), manageInteraction, new Summary()).menu();
    }
}
