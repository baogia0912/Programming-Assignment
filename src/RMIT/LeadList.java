package RMIT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeadList {
    private Lead[] lead = new Lead[100000];
    private int size;

    public LeadList() {
    }

    public Lead[] getLead() {
        return lead;
    }

    public void setLead(Lead[] lead) {
        this.lead = lead;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static Scanner open() throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File("leads.csv"));
            return scanner;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    public static void display() throws FileNotFoundException {
        Scanner scanner = open();

        while(scanner.hasNext()){
            String line =  scanner.nextLine();
            String[] tokens = line.split(",");
            //go home: change it by using StringTokenizer

            System.out.println("ID: "+tokens[0]);
            System.out.println("Name: "+tokens[1]);
            System.out.println("Email: "+tokens[5]);


        }

    }
}
