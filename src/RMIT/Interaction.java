package RMIT;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Interaction {
    private String id;
    private String date;
    private String leadID;
    private String meansOfContact;
    private String potential;

    public Interaction() {

    }

    public Interaction(String id, String date, String leadID, String meansOfContact, String potential) {
        this.id = id;
        this.date = date;
        this.leadID = leadID;
        this.meansOfContact = meansOfContact;
        this.potential = potential;
    }

    public String getId() {
        try {
            return nextInteractionID();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeadID() {
        return leadID;
    }

    public void setLeadID(String leadID) {
        this.leadID = leadID;
    }

    public String getMeansOfContact() {
        return meansOfContact;
    }

    public void setMeansOfContact(String meansOfContact) {
        this.meansOfContact = meansOfContact;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    public static String nextInteractionID() throws IOException {
        long interactionNum;
        String interactionID;
        try {
            interactionNum = Files.lines(Paths.get("interactions.csv")).count() + 1;

            String zeroes = "";
            for (int i = 0; i<3-String.valueOf(interactionNum).length();i++) {
                zeroes += "0";
            }
            interactionID = "inter_" + zeroes + String.valueOf(interactionNum);

            return interactionID;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
