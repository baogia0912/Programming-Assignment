package appWithConsoleUI;

import java.io.*;

public class Interaction {
    private String id;
    private String date;
    private String interactionID;
    private String meansOfContact;
    private String potential;

    public Interaction() {

    }

    public Interaction(String id, String date, String interactionID, String meansOfContact, String potential) {
        this.id = id;
        this.date = date;
        this.interactionID = interactionID;
        this.meansOfContact = meansOfContact;
        this.potential = potential;
    }

    public String getId() {
        try {
            return nextInteractionID();
        } catch (Exception e) {
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
        return interactionID;
    }

    public void setLeadID(String interactionID) {
        this.interactionID = interactionID;
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

    public static String nextInteractionID() {
        String interactionID;
        try {
            File interactionIDTracker = new File("interactionIDTracker.txt");
            File tempinteractionIDTracker = new File("tempinteractionIDTracker.txt");

            BufferedReader reader = new BufferedReader(new FileReader(interactionIDTracker));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempinteractionIDTracker));

            // Get ID number
            interactionID = reader.readLine();
            String[] tokens = interactionID.split("_");
            int idNum = Integer.parseInt(tokens[1]);
            int newId = idNum + 1;

            StringBuilder zeroes = new StringBuilder();
            // Count the number of zeros needed
            zeroes.append("0".repeat(Math.max(0, 3 - String.valueOf(newId).length())));

            writer.write("inter_" + zeroes + newId); // Copy new lead id to the temp file
            interactionID = "inter_" + zeroes + newId;

            reader.close();
            writer.close();

            // Replace the original tracker file with the temp file containing new id
            interactionIDTracker.delete();
            tempinteractionIDTracker.renameTo(interactionIDTracker);

            return interactionID;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
