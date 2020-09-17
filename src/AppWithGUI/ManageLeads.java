package AppWithGUI;

public class ManageLeads {
    private final Validation validation;
    private final ManageInteraction manageInteraction;

    public ManageLeads(Validation validation, ManageInteraction manageInteraction) {
        this.validation = validation;
        this.manageInteraction = manageInteraction;
    }

    public void viewLeads() {
        String[][] fileData = new ReadFile().readFile("leads.csv");

        for (int i = 0; i < fileData.length; ++i) {
            for (int j = 0; j < fileData[i].length; ++j) {
                System.out.println(fileData[i][j]);
            }
        }
    }
}
