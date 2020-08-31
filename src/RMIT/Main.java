package RMIT;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        int option = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("(1: manage leads), (2: manage interactions), (3: ), (4: Exit)");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next(); // this is important!
            }
            option = scanner.nextInt();

            if (option == 1) {
                int subOption = 0;
                do {
                    System.out.println("(1: view leads), (2: add leads), (3: delete leads), (4: update leads), (5: Back)");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number!");
                        scanner.next(); // this is important!
                    }
                    subOption = scanner.nextInt();

                    if (subOption == 1) {
                        viewLeads();
                    } else if (subOption == 2) {
                        addLeads(getLeadInput(scanner));
                    } else if (subOption == 3) {
                        deleteLeads();
                    } else if (subOption == 4) {
                        updateLeads();
                    }
                } while (subOption != 5);

            } else if (option == 2) {
                int subOption = 0;
                do {
                    System.out.println("(1: view interactions), (2: add interactions), (3: delete interactions), (4: update interactions), (5: Back)");
                    while (!scanner.hasNextInt()) {
                        System.out.println("That's not a number!");
                        scanner.next(); // this is important!
                    }
                    subOption = scanner.nextInt();

                    if (subOption == 1) {
                        viewInteractions();
                    } else if (subOption == 2) {
                        addInteractions(getInteractionInput(scanner));
                    } else if (subOption == 3) {
                        deleteInteractions();
                    } else if (subOption == 4) {
                        updateInteractions();
                    }
                } while (subOption != 5);
            } else if (option == 3) {
                deleteLeads();
            }

        } while(option !=4);

    }


    public static void viewLeads() {
        try {
            File leadsFile = new File("leads.csv");
            Scanner leadsContent = new Scanner(leadsFile);
            while (leadsContent.hasNextLine()) {
                String line = leadsContent.nextLine();
                String[] tokens = line.split(",");
                //go home: change it by using StringTokenizer

                System.out.println("\nID: "+tokens[0]);
                System.out.println("Name: "+tokens[1]);
                System.out.println("Date of birth: "+tokens[2]);
                System.out.println("Gender: "+Boolean.parseBoolean(tokens[3]));
                System.out.println("Phone number: "+tokens[4]);
                System.out.println("Email: "+tokens[5]);
                System.out.println("Address: "+tokens[6]);

            }
            leadsContent.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
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

                System.out.println("\nID: "+tokens[0]);
                System.out.println("Date: "+tokens[1]);
                System.out.println("Lead: "+tokens[2]);
                System.out.println("Contacted through: "+tokens[3]);
                System.out.println("Potential: "+tokens[4]);
            }
            leadsContent.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void addLeads(Lead lead) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("leads.csv", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(lead.getId() + "," + lead.getName() + "," + lead.getDob() + "," + lead.isGender() + "," + lead.getPhone() + "," + lead.getEmail() + "," + lead.getAddress());

            pw.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addInteractions(Interaction interaction) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("interactions.csv", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(interaction.getId() + "," + interaction.getDate() + "," + interaction.getLeadID() + "," + interaction.getMeansOfContact() + "," + interaction.getPotential());

            pw.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteLeads() {

    }

    public static void deleteInteractions() {

    }

    public static Lead getLeadInput(Scanner scanner) {
        scanner = new Scanner(System.in);
        Lead lead = new Lead();

        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        while(!isValidName(name)){
            System.out.println("Invalid! \nEnter Email: ");
            name = scanner.nextLine();
        }
        lead.setName(name);

        System.out.println("Enter Date of Birth(YYYY/MM/DD): ");
        String dob = scanner.nextLine();
        lead.setDob(dob);

        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        while(!isValidPhoneNumber(phone)){
            System.out.println("Invalid! \nEnter Email: ");
            phone = scanner.nextLine();
        }
        lead.setPhone(phone);

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        while(!isValidEmail(email)){
            System.out.println("Invalid! \nEnter Email: ");
            email = scanner.nextLine();
        }
        lead.setEmail(email);


        System.out.println("Enter Gender(True = Male/False = Female): ");
        String gender = scanner.nextLine();
        while(!gender.equalsIgnoreCase("true") && !gender.equalsIgnoreCase("false")){
            System.out.println("Invalid! \n(true/false): ");
            gender = scanner.nextLine();
        }
        lead.setGender(Boolean.parseBoolean(gender));

        System.out.println("Enter Address ");
        String address = scanner.nextLine();
        while(!isValidAddress(address)){
            System.out.println("Invalid! \nEnter Address: ");
            address = scanner.nextLine();
        }
        lead.setAddress(address);

        return lead;
    }

    public static Interaction getInteractionInput(Scanner scanner) {
        scanner = new Scanner(System.in);
        Interaction interaction = new Interaction();

        System.out.println("Enter Date Of Interaction(YYYY/MM/DD): ");
        String date = scanner.nextLine();
        interaction.setDate(date);

        System.out.println("Enter LeadID: ");
        String leadID = scanner.nextLine();
        interaction.setLeadID(leadID);

        System.out.println("Enter Means Of Contact: ");
        String means = scanner.nextLine();
        interaction.setMeansOfContact(means);

        System.out.println("Enter potential(positive,neutral,negative): ");
        String potential = scanner.nextLine();
        interaction.setPotential(potential);

        return interaction;
    }

    public static void updateLeads() {

    }

    public static void updateInteractions() {

    }

    static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean isValidAddress( String address ) {
        String regex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
        return address.matches(regex);
    }

    public static boolean isValidPhoneNumber(String phone ) {
        String regex = "(0/91)?[7-9][0-9]{9}";
        return phone.matches(regex);
    }

    public static boolean isValidName(String name ) {
        String regex = "^[aA-zZ]\\w{5,29}$";
        return name.matches(regex);
    }
}
