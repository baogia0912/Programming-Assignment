package RMIT;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        Date now = new Date();

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        String date = DATE_FORMAT.format(now);

        Address here = new Address("958", "Ly Thuong Kiet");

        Lead lead = new Lead("lead_003","Bao",date,false,"0702899015","baogia0912@gmail.com",here);


        int option = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("(1: view leads), (2: add new lead), (3: delete lead), (4: ), (5: Exit)");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next(); // this is important!
            }
            option = scanner.nextInt();

            if (option == 1) {
                printLeadsFile();
            } else if (option == 2) {
                addLeads(getLeadInput(scanner));
            } else if (option == 3) {
                deleteLeads();
            }

        } while(option !=5);

    }


    public static void printLeadsFile() {
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

    public static void addLeads(Lead lead) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("leads.csv", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(lead.getId() + "," + lead.getName() + "," + lead.getDob() + "," + lead.isGender() + "," + lead.getPhone() + "," + lead.getEmail() + "," + lead.getAddress().getHouseNumber()+" "+lead.getAddress().getStreetName());

            pw.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteLeads() {
        
    }

    public static Lead getLeadInput(Scanner scanner) {
        scanner = new Scanner(System.in);
        Lead lead = new Lead();

        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        lead.setName(name);

        System.out.println("Enter Date of Birth(YYYY/MM/DD): ");
        String dob = scanner.nextLine();
        lead.setDob(dob);

        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        lead.setPhone(phone);

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        while(!email.contains("@")){
            System.out.println("Invalid Please Enter Email Again: ");
            email = scanner.nextLine();
        }
        lead.setEmail(email);


        System.out.println("Enter Gender(True = Male/False = Female): ");
        Boolean gender = scanner.nextBoolean();
        lead.setGender(gender);
        /*Boolean setGender = false;

        if(gender.equalsIgnoreCase("male")){
            setGender = true;
        }
        else if (gender.equalsIgnoreCase("female")){
            setGender = false;
        }
        while (!gender.equalsIgnoreCase("female") || !gender.equalsIgnoreCase("male") );*/

        System.out.println("Enter Address (Format: HouseNumber StreetName: ");
        String houseNum = scanner.nextLine();
        String streetName = scanner.nextLine();
        Address address =  new Address(houseNum, streetName);
        lead.setAddress(address);

        return lead;
    }
}
