package RMIT;

public class Main {
    public static void main(String[] args) {
        Validation validation = new Validation();
        ManageInteraction manageInteraction = new ManageInteraction(validation);
        ManageLeads manageLeads = new ManageLeads(validation, manageInteraction);
        Summary summary = new Summary();
        new Menu(validation, manageLeads, manageInteraction, summary).menu();
    }
}
