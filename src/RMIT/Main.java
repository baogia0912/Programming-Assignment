package RMIT;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("(1: manage leads), (2: manage interactions), (3: view summary), (4: Exit)");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next(); // this is important!
            }
            option = scanner.nextInt();

            if (option == 1) {
                do {
                    System.out.println("(1: view leads), (2: add leads), (3: delete leads), (4: update leads), (5: Back)");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number!");
                        scanner.next(); // this is important!
                    }
                    option = scanner.nextInt();

                    if (option == 1) {
                        option = 0;
                        viewLeads();
                    } else if (option == 2) {
                        option = 0;
                        addLeads(getLeadInput());
                    } else if (option == 3) {
                        option = 0;
                        scanner = new Scanner(System.in);
                        System.out.println("Enter LeadID: ");
                        String leadID = scanner.nextLine();
                        while (!isValidLeadID(leadID) || !isLeadExist(leadID)) {
                            System.out.println("Invalid! \nEnter LeadID: ");
                            leadID = scanner.nextLine();
                        }
                        deleteLeads(leadID);
                    } else if (option == 4) {
                        option = 0;
                        scanner = new Scanner(System.in);
                        System.out.println("Enter LeadID: ");
                        String leadID = scanner.nextLine();
                        while (!isValidLeadID(leadID) || !isLeadExist(leadID)) {
                            System.out.println("Invalid! \nEnter LeadID: ");
                            leadID = scanner.nextLine();
                        }
                        System.out.println("Enter index (1: name), (2: date), (3: gender), (4: phone#), (5: email), (6: address): ");
                        String index = scanner.nextLine();
                        while (!isValidLeadIndex(index)) {
                            System.out.println("Invalid! \nEnter index (1: name), (2: date), (3: gender), (4: phone#), (5: email), (6: address): ");
                            index = scanner.nextLine();
                        }
                        if (Integer.parseInt(index) == 1) {
                            System.out.println("Enter Name: ");
                            String editedContent = scanner.nextLine();
                            while (!isValidName(editedContent)) {
                                System.out.println("Invalid! \nEnter Name: ");
                                editedContent = scanner.nextLine();
                            }
                            updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 2) {

                            System.out.println("Enter Date of Birth(YYYY-MM-DD): ");
                            String editedContent = scanner.nextLine();
                            while (!isValidDate(editedContent)) {
                                System.out.println("Invalid! \nEnter Date of Birth(YYYY-MM-DD): ");
                                editedContent = scanner.nextLine();
                            }
                            updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 3) {

                            System.out.println("Enter Gender(True = Male/False = Female): ");
                            String editedContent = scanner.nextLine();
                            while (!editedContent.equalsIgnoreCase("true") && !editedContent.equalsIgnoreCase("false")) {
                                System.out.println("Invalid! \n(true/false): ");
                                editedContent = scanner.nextLine();
                            }
                            updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 4) {

                            System.out.println("Enter Phone Number: ");
                            String editedContent = scanner.nextLine();
                            while (!isValidPhoneNumber(editedContent)) {
                                System.out.println("Invalid! \nEnter Phone Number: ");
                                editedContent = scanner.nextLine();
                            }
                            updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 5) {
                            System.out.println("Enter Email: ");
                            String editedContent = scanner.nextLine();
                            while (!isValidEmail(editedContent)) {
                                System.out.println("Invalid! \nEnter Email: ");
                                editedContent = scanner.nextLine();
                            }
                            updateLeads(leadID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 6) {

                            System.out.println("Enter Address ");
                            String editedContent = scanner.nextLine();
                            while (!isValidAddress(editedContent)) {
                                System.out.println("Invalid! \nEnter Address: ");
                                editedContent = scanner.nextLine();
                            }
                            updateLeads(leadID, Integer.parseInt(index), editedContent);
                        }
                    }
                } while (option != 5);
                option = 0;

            } else if (option == 2) {
                do {
                    System.out.println("(1: view interactions), (2: add interactions), (3: delete interactions), (4: update interactions), (5: Back)");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number!");
                        scanner.next(); // this is important!
                    }
                    option = scanner.nextInt();

                    if (option == 1) {
                        option = 0;
                        viewInteractions();
                    } else if (option == 2) {
                        option = 0;
                        addInteractions(getInteractionInput());
                    } else if (option == 3) {
                        option = 0;
                        scanner = new Scanner(System.in);
                        System.out.println("Enter InteractionID: ");
                        String interactionID = scanner.nextLine();
                        while (!isValidInteractionID(interactionID) || !isInteractionExist(interactionID)) {
                            System.out.println("Invalid! \nEnter InteractionID: ");
                            interactionID = scanner.nextLine();
                        }
                        deleteInteractions(interactionID);
                    } else if (option == 4) {
                        option = 0;
                        scanner = new Scanner(System.in);
                        System.out.println("Enter InteractionID: ");
                        String interactionID = scanner.nextLine();
                        while (!isValidInteractionID(interactionID) || !isInteractionExist(interactionID)) {
                            System.out.println("Invalid! \nEnter InteractionID: ");
                            interactionID = scanner.nextLine();
                        }
                        System.out.println("Enter index (1: date), (2: leadID), (3: means of contact), (4: potential)");
                        String index = scanner.nextLine();
                        while (!isValidInteractionIndex(index)) {
                            System.out.println("Invalid! \nEnter index (1: date), (2: leadID), (3: means of contact), (4: potential)");
                            index = scanner.nextLine();
                        }
                        if (Integer.parseInt(index) == 1) {

                            System.out.println("Enter Date of Interaction(YYYY-MM-DD): ");
                            String editedContent = scanner.nextLine();
                            while (!isValidDate(editedContent)) {
                                System.out.println("Invalid! \nEnter Date of Interaction(YYYY-MM-DD): ");
                                editedContent = scanner.nextLine();
                            }
                            updateInteractions(interactionID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 2) {

                            System.out.println("Enter LeadID: ");
                            String editedContent = scanner.nextLine();
                            while (!isValidLeadID(editedContent) || !isLeadExist(editedContent)) {
                                System.out.println("Invalid! \nEnter LeadID: ");
                                editedContent = scanner.nextLine();
                            }
                            updateInteractions(interactionID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 3) {

                            System.out.println("Enter Means Of Contact: ");
                            String editedContent = scanner.nextLine();
                            updateInteractions(interactionID, Integer.parseInt(index), editedContent);

                        } else if (Integer.parseInt(index) == 4) {
                            System.out.println("Enter potential(positive,neutral,negative): ");
                            String editedContent = scanner.nextLine();
                            while (!(editedContent.equalsIgnoreCase("positive") || editedContent.equalsIgnoreCase("neutral") || editedContent.equalsIgnoreCase("negative"))) {
                                System.out.println("Invalid! \nEnter potential(positive,neutral,negative): ");
                                editedContent = scanner.nextLine();
                            }
                            updateInteractions(interactionID, Integer.parseInt(index), editedContent);
                        }
                    }
                } while (option != 5);
                option = 0;
            } else if (option == 3) {
                option = 0;
            }
        } while (option != 4);
    }


    public static void viewLeads() {
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

    public static void viewInteractions() {
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

    public static void addLeads(Lead lead) {
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

    public static void addInteractions(Interaction interaction) {
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

    public static void deleteLeads(String leadID) {
        String currentLine;

        try {
            File leadsFile = new File("leads.csv");
            File tempLeadFile = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(leadsFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempLeadFile));

            while ((currentLine = reader.readLine()) != null) {
                // Trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.contains(leadID)) continue;
                // Write contents of source file into temp file except for the line with user input id
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            reader.close();
            writer.close();

            boolean deleted = leadsFile.delete();
            boolean renamed = tempLeadFile.renameTo(leadsFile);

            if (deleted && renamed) {
                System.out.println(leadID + " has been deleted!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteInteractions(String interactionID) {
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

    public static Lead getLeadInput() {
        Scanner scanner = new Scanner(System.in);
        Lead lead = new Lead();

        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        while (!isValidName(name)) {
            System.out.println("Invalid! \nEnter Name: ");
            name = scanner.nextLine();
        }
        lead.setName(name);

        System.out.println("Enter Date of Birth(YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        while (!isValidDate(dob)) {
            System.out.println("Invalid! \nEnter Date of Birth(YYYY-MM-DD): ");
            dob = scanner.nextLine();
        }
        lead.setDob(dob);

        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        while (!isValidPhoneNumber(phone)) {
            System.out.println("Invalid! \nEnter Phone Number: ");
            phone = scanner.nextLine();
        }
        lead.setPhone(phone);

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        while (!isValidEmail(email)) {
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
        while (!isValidAddress(address)) {
            System.out.println("Invalid! \nEnter Address: ");
            address = scanner.nextLine();
        }
        lead.setAddress(address);

        return lead;
    }

    public static Interaction getInteractionInput() {
        Scanner scanner = new Scanner(System.in);
        Interaction interaction = new Interaction();

        System.out.println("Enter Date Of Interaction(YYYY-MM-DD): ");
        String date = scanner.nextLine();
        while (!isValidDate(date)) {
            System.out.println("Invalid! \nEnter Date of Interaction(YYYY-MM-DD): ");
            date = scanner.nextLine();
        }
        interaction.setDate(date);

        System.out.println("Enter LeadID: ");
        String leadID = scanner.nextLine();
        while (!isValidLeadID(leadID) || !isLeadExist(leadID)) {
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

    public static void updateLeads(String leadID, int index, String editedContent) {
        File lead = new File("leads.csv");
        File tempLead = new File("editedLeads.csv");

        try {

            BufferedReader reader = new BufferedReader(new FileReader(lead));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempLead));

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

            lead.delete();
            tempLead.renameTo(lead);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateInteractions(String interactionID, int index, String editedContent) {
        File interaction = new File("interactions.csv");
        File tempInteraction = new File("editedInteractions.csv");

        try {

            BufferedReader reader = new BufferedReader(new FileReader(interaction));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempInteraction));

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

            interaction.delete();
            tempInteraction.renameTo(interaction);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static

    static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean isValidAddress(String address) {
        String regex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
        return address.matches(regex);
    }

    public static boolean isValidPhoneNumber(String phone) {
        String regex = "\\d{8,12}";
        return phone.matches(regex);
    }

    public static boolean isValidName(String name) {
        String regex = "[aA-zZ]\\w{2,29}";
        return name.matches(regex);
    }

    public static boolean isValidDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            Date newDate = df.parse(date);
            Date now = new Date();

            if (newDate.after(now)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean isValidLeadID(String leadID) {
        String regex = "^(lead_)\\d{3}$";
        return leadID.matches(regex);
    }

    public static boolean isValidInteractionID(String interactionID) {
        String regex = "^(inter_)\\d{3}$";
        return interactionID.matches(regex);
    }

    public static boolean isValidLeadIndex(String leadID) {
        String regex = "^[1-6]$";
        return leadID.matches(regex);
    }

    public static boolean isValidInteractionIndex(String interactionID) {
        String regex = "^[1-4]$";
        return interactionID.matches(regex);
    }

    public static boolean isLeadExist(String leadID) {
        File lead = new File("leads.csv");

        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(lead));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                // Find the cell
                if (leadID.equalsIgnoreCase(tokens[0])) {
                    count = 1;
                } else {
                    count = 0;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInteractionExist(String interactionID) {
        File interaction = new File("interactions.csv");

        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(interaction));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                // Find the cell
                if (interactionID.equalsIgnoreCase(tokens[0])) {
                    count = 1;
                } else {
                    count = 0;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
