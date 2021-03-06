package AppWithConsoleUI;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;

public class Lead {
    private String id;
    private String name;
    private LocalDate dob;
    private boolean gender;
    private String phone;
    private String email;
    private String address;

    public Lead() {

    }
    public Lead(String id, String name, LocalDate dob, boolean gender, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        //calling the next ID method
        try {
            return nextLeadID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String nextLeadID() {
        //finding next lead ID
        String leadID;
        try {
            File leadIdTracker = new File("LeadIDTracker.txt");
            File tempLeadIdTracker = new File("tempLeadIDTracker.txt");

            BufferedReader reader = new BufferedReader(new FileReader(leadIdTracker));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempLeadIdTracker));

            // Get ID number
            leadID = reader.readLine();
            String[] tokens = leadID.split("_");
            int idNum = Integer.valueOf(tokens[1]);
            int newId = idNum + 1;

            String zeroes = "";
            // Count the number of zeros needed
            for (int i = 0; i<3-String.valueOf(newId).length();i++) {
                zeroes += "0";
            }

            writer.write("lead_" + zeroes + newId); // Copy new lead id to the temp file
            leadID = "lead_" + zeroes + newId;

            reader.close();
            writer.close();

            // Replace the original tracker file with the temp file containing new id
            leadIdTracker.delete();
            tempLeadIdTracker.renameTo(leadIdTracker);

            return leadID;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAge(){
        LocalDate dob = this.dob;
        LocalDate now = LocalDate.now();
        Period diff = Period.between(dob, now);
        int age = diff.getYears();
        return age;
    }

}
