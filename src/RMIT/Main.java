package RMIT;

public class Main {
    public static void main(String[] args) {
        Validation validation = new Validation();
        ManageLeads manageLeads = new ManageLeads(validation);
        ManageInteraction manageInteraction = new ManageInteraction(validation);
        Summary summary = new Summary();
        new Menu(validation, manageLeads, manageInteraction, summary).menu();
    }
}
