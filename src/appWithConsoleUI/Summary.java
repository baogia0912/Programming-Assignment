package appWithConsoleUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Summary {
    public void ageSummary() {
        String currentLine;

        int count0to10 = 0;
        int count10to20 = 0;
        int count20to60 = 0;
        int count60toDeath = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("leads.csv"));
            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                Lead lead = new Lead();
                lead.setDob(LocalDate.parse(tokens[2])); // Set date taken from file to a lead object
                int age = lead.getAge();

                if(age < 10){ count0to10++;}
                else if (age < 20) { count10to20++; }
                else if (age < 60) { count20to60++; }
                else if (age > 60) { count60toDeath++; }
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        System.out.println("Number of leads by age");
        System.out.println("0 to 10 (years old): " + count0to10);
        System.out.println("10 to 20 (years old): " + count10to20);
        System.out.println("20 to 60 (years old): " + count20to60);
        System.out.println("60+ (years old): " + count60toDeath);

    }

    public void potentialSummary(String startDate, String endDate) {
        int positiveCount = 0;
        int negativeCount = 0;
        int neutralCount = 0;

        LocalDate sDate = LocalDate.parse(startDate);
        LocalDate edDate = LocalDate.parse(endDate);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("interactions.csv"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                Interaction inter = new Interaction();
                LocalDate date = LocalDate.parse(tokens[1]);

                // Check if the date is between the input dates
                if(date.isAfter(sDate) && date.isBefore(edDate) || date.isEqual(sDate) || date.isEqual(edDate)){
                    if(tokens[4].equalsIgnoreCase("positive")){ positiveCount++; }
                    else if(tokens[4].equalsIgnoreCase("negative")){ negativeCount++; }
                    else { neutralCount++; }
                }
            }

        }
        catch(IOException ex){
            ex.printStackTrace();
        }

        System.out.println("Number of interactions by potential");
        System.out.println("Positive: " + positiveCount);
        System.out.println("Negative: " + negativeCount);
        System.out.println("Neutral: " + neutralCount);

    }

    public void interactionSummary(String startDate, String endDate) {
        String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] interCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        LocalDate sDate = LocalDate.parse(startDate);
        LocalDate edDate = LocalDate.parse(endDate);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("interactions" +
                    ".csv"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                String[] month = tokens[1].split("-");
                Interaction inter = new Interaction();
                LocalDate date = LocalDate.parse(tokens[1]);

                // Check if the date is between the input dates
                if(date.isAfter(sDate) && date.isBefore(edDate) || date.isEqual(sDate) || date.isEqual(edDate)){
                    // Loop through the months array
                    for(int i = 0; i < 12; i++){
                        if(Integer.parseInt(month[1]) == i + 1) {
                            interCount[i]++;
                            break;
                        }
                    }
                }
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        for(int i = 0; i < 12; i++){
            if(interCount[i] != 0){
                System.out.println(months[i] + ": " + interCount[i]);
            }
        }

    }
}
