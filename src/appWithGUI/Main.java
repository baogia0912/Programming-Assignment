package appWithGUI;

public class Main {
    public static void main(String[] args) {
        Validation validation = new Validation();
        ManageInteraction manageInteraction = new ManageInteraction(validation);

        new GUI(validation, new ManageLeads(validation, manageInteraction), manageInteraction, new Summary()).gui();
    }
}
