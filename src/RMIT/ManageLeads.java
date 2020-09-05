package RMIT;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class ManageLeads {
    private final Validation validation;
    private final ManageInteraction manageInteraction;

    public ManageLeads(Validation validation, ManageInteraction manageInteraction) {
        this.validation = validation;
        this.manageInteraction = manageInteraction;
    }

    public void viewLeads() {
        try {
            File leadsFile = new File("leads.csv");
            Scanner leadsContent = new Scanner(leadsFile);
            while (leadsContent.hasNextLine()) {
                String line = leadsContent.nextLine();
                String[] tokens = line.split(",");
                //go home: change it by using StringTokenizer

                System.out.println("\nID: " + tokens[0]);
                System.out.println("Name: " + tokens[1]);
                System.out.println("Date of birth: " + tokens[2]);
                System.out.println("Gender: " + Boolean.parseBoolean(tokens[3]));
                System.out.println("Phone number: " + tokens[4]);
                System.out.println("Email: " + tokens[5]);
                System.out.println("Address: " + tokens[6]);

            }
            leadsContent.close();
        } catch (FileNotFoundException e) {
            System.out.println("File can not be found");
            e.printStackTrace();
        }
    }

    public void addLeads(Lead lead) {
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;

        try {
            fw = new FileWriter("leads.csv", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(Lead.nextLeadID() + "," + lead.getName() + "," + lead.getDob() + "," + lead.isGender() + "," + lead.getPhone() + "," + lead.getEmail() + "," + lead.getAddress());

            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLeads(String leadID, boolean deleteInteraction) {
        String currentLine;
        try {
            File leadsFile = new File("leads.csv");
            File tempLeadFile = new File("temp.csv");

            BufferedReader leadsReader = new BufferedReader(new FileReader(leadsFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempLeadFile));

            while ((currentLine = leadsReader.readLine()) != null) {
                // Trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.contains(leadID)) continue;
                // Write contents of source file into temp file except for the line with user input id
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            leadsReader.close();
            writer.close();

            boolean deleted = leadsFile.delete();
            boolean renamed = tempLeadFile.renameTo(leadsFile);

            if (deleted && renamed) {
                System.out.println(leadID + " has been deleted!");
            }

            if (deleteInteraction) {
                File interactionFile = new File("interactions.csv");
                BufferedReader interactionsReader = new BufferedReader(new FileReader(interactionFile));

                String[] interactionToRemove = new String[1000];
                int index = 0;
                while ((currentLine = interactionsReader.readLine()) != null) {
                    // Trim newline when comparing with lineToRemove
                    String trimmedLine = currentLine.trim();
                    if (trimmedLine.contains(leadID)) {
                        String[] tokens = currentLine.split(",");
                        interactionToRemove[index] = tokens[0];
                        index += 1;
                    }
                }
                for (int i = 0; i < index; i++) {
                    manageInteraction.deleteInteractions(interactionToRemove[i]);
                }

                interactionsReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateLeads(String leadID, int index, String editedContent) {
        File leadsFile = new File("leads.csv");
        File tempLeadsFile = new File("editedLeads.csv");

        try {

            BufferedReader reader = new BufferedReader(new FileReader(leadsFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempLeadsFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                // Find the cell for editing
                if (leadID.equalsIgnoreCase(tokens[0])) {
                    for (int i = 0; i < 7; i++) {
                        // Apply edited input to targeted line
                        if (i == index) {
                            tokens[i] = editedContent;
                        }
                        // Write the remaining lines
                        if (i != 6) {
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

            boolean deleted = leadsFile.delete();
            boolean renamed = tempLeadsFile.renameTo(leadsFile);

            if (deleted && renamed) {
                System.out.println(leadID + " has been updated!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Lead getLeadInput() {
        Scanner scanner = new Scanner(System.in);
        Lead lead = new Lead();

        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        while (!validation.isValidName(name)) {
            System.out.println("Invalid! \nEnter Name: ");
            name = scanner.nextLine();
        }
        lead.setName(name);

        System.out.println("Enter Date of Birth(YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        while (!validation.isValidDate(dob)) {
            System.out.println("Invalid! \nEnter Date of Birth(YYYY-MM-DD): ");
            dob = scanner.nextLine();
        }
        lead.setDob(dob);

        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        while (!validation.isValidPhoneNumber(phone)) {
            System.out.println("Invalid! \nEnter Phone Number: ");
            phone = scanner.nextLine();
        }
        lead.setPhone(phone);

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        while (!validation.isValidEmail(email)) {
            System.out.println("Invalid! \nEnter Email: ");
            email = scanner.nextLine();
        }
        lead.setEmail(email);


        System.out.println("Enter Gender(True = Male/False = Female): ");
        String gender = scanner.nextLine();
        while (!gender.equalsIgnoreCase("true") && !gender.equalsIgnoreCase("false")) {
            System.out.println("Invalid! \n(true/false): ");
            gender = scanner.nextLine();
        }
        lead.setGender(Boolean.parseBoolean(gender));

        System.out.println("Enter Address ");
        String address = scanner.nextLine();
        while (!validation.isValidAddress(address)) {
            System.out.println("Invalid! \nEnter Address: ");
            address = scanner.nextLine();
        }
        lead.setAddress(address);

        return lead;
    }
}
