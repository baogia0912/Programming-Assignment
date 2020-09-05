package RMIT;

import java.io.*;
import java.util.Scanner;

public class ManageInteraction {
    private final Validation validation;

    public ManageInteraction(Validation validation) {
        this.validation = validation;
    }

    public void viewInteractions() {
        try {
            File leadsFile = new File("interactions.csv");
            Scanner leadsContent = new Scanner(leadsFile);
            while (leadsContent.hasNextLine()) {
                String line = leadsContent.nextLine();
                String[] tokens = line.split(",");
                //go home: change it by using StringTokenizer

                System.out.println("\nID: " + tokens[0]);
                System.out.println("Date: " + tokens[1]);
                System.out.println("Lead: " + tokens[2]);
                System.out.println("Contacted through: " + tokens[3]);
                System.out.println("Potential: " + tokens[4]);
            }
            leadsContent.close();
        } catch (FileNotFoundException e) {
            System.out.println("File can not be found.");
            e.printStackTrace();
        }
    }

    public void addInteractions(Interaction interaction) {
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;

        try {
            fw = new FileWriter("interactions.csv", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(interaction.getId() + "," + interaction.getDate() + "," + interaction.getLeadID() + "," + interaction.getMeansOfContact() + "," + interaction.getPotential());

            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteInteractions(String interactionID) {
        String currentLine;

        try {
            File interactionsFile = new File("interactions.csv");
            File tempInteractionsFile = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(interactionsFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempInteractionsFile));

            while ((currentLine = reader.readLine()) != null) {
                // Trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.contains(interactionID)) continue;
                // Write contents of source file into temp file except for the line with user input id
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            reader.close();
            writer.close();

            boolean deleted = interactionsFile.delete();
            boolean renamed = tempInteractionsFile.renameTo(interactionsFile);

            if (deleted && renamed) {
                System.out.println(interactionID + " has been deleted!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateInteractions(String interactionID, int index, String editedContent) {
        File interactionsFile = new File("interactions.csv");
        File tempInteractionsFile = new File("editedInteractions.csv");

        try {

            BufferedReader reader = new BufferedReader(new FileReader(interactionsFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempInteractionsFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                // Find the cell for editing
                if (interactionID.equalsIgnoreCase(tokens[0])) {
                    for (int i = 0; i < 5; i++) {
                        // Apply edited input to targeted line
                        if (i == index) {
                            tokens[i] = editedContent;
                        }
                        // Write the remaining lines
                        if (i != 4) {
                            writer.write(tokens[i] + ',');
                        } else {
                            writer.write(tokens[i]);
                        }

                    }
                    writer.write(System.getProperty("line.separator"));
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }

            }
            reader.close();
            writer.close();

            boolean deleted = interactionsFile.delete();
            boolean renamed = tempInteractionsFile.renameTo(interactionsFile);

            if (deleted && renamed) {
                System.out.println(interactionID + " has been updated!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Interaction getInteractionInput() {
        Scanner scanner = new Scanner(System.in);
        Interaction interaction = new Interaction();

        System.out.println("Enter Date Of Interaction(YYYY-MM-DD): ");
        String date = scanner.nextLine();
        while (!validation.isValidDate(date)) {
            System.out.println("Invalid! \nEnter Date of Interaction(YYYY-MM-DD): ");
            date = scanner.nextLine();
        }
        interaction.setDate(date);

        System.out.println("Enter LeadID: ");
        String leadID = scanner.nextLine();
        while (!validation.isValidLeadID(leadID) || !validation.isLeadExist(leadID)) {
            System.out.println("Invalid! \nEnter LeadID: ");
            leadID = scanner.nextLine();
        }
        interaction.setLeadID(leadID);

        System.out.println("Enter Means Of Contact: ");
        String means = scanner.nextLine();
        interaction.setMeansOfContact(means);

        System.out.println("Enter potential(positive,neutral,negative): ");
        String potential = scanner.nextLine();
        while (!(potential.equalsIgnoreCase("positive") || potential.equalsIgnoreCase("neutral") || potential.equalsIgnoreCase("negative"))) {
            System.out.println("Invalid! \nEnter potential(positive,neutral,negative): ");
            potential = scanner.nextLine();
        }
        interaction.setPotential(potential);

        return interaction;
    }
}
