package RMIT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Lead {
    private String id;
    private String name;
    private String dob;
    private boolean gender;
    private String phone;
    private String email;
    private String address;

    public Lead() {

    }
    public Lead(String id, String name, String dob, boolean gender, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        try {
            return nextLeadID();
        } catch (IOException e) {
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public static String nextLeadID() throws IOException {
        long leadNum;
        String leadID;
        try {
            leadNum = Files.lines(Paths.get("leads.csv")).count() + 1;

            String zeroes = "";
            for (int i = 0; i<3-String.valueOf(leadNum).length();i++) {
                zeroes += "0";
            }
            leadID = "lead_" + zeroes + String.valueOf(leadNum);

            return leadID;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
