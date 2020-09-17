package AppWithConsoleUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    public boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean isValidAddress(String address) {
        String regex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
        return address.matches(regex);
    }

    public boolean isValidPhoneNumber(String phone) {
        String regex = "\\d{8,12}";
        return phone.matches(regex);
    }

    public boolean isValidName(String name) {
        String regex = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z])+";
        return name.matches(regex);
    }

    public boolean isValidMeansOfContact(String means) {
        String regex = "([a-zA-Z0-9]+|[a-zA-Z0-9]+\\s[a-zA-Z0-9])+";
        return means.matches(regex);
    }

    public boolean isValidDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            Date newDate = df.parse(date);
            Date now = new Date();

            return !newDate.after(now);
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isValidLeadID(String leadID) {
        String regex = "^(lead_)\\d{3}$";
        return leadID.matches(regex);
    }

    public boolean isValidInteractionID(String interactionID) {
        String regex = "^(inter_)\\d{3}$";
        return interactionID.matches(regex);
    }

    public boolean isValidLeadIndex(String leadID) {
        String regex = "^[1-6]$";
        return leadID.matches(regex);
    }

    public boolean isValidInteractionIndex(String interactionID) {
        String regex = "^[1-4]$";
        return interactionID.matches(regex);
    }

    public boolean isLeadExist(String leadID) {
        File lead = new File("leads.csv");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(lead));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                // Find the cell
                if (leadID.equalsIgnoreCase(tokens[0])) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Lead's ID does not exist!");
        return false;
    }

    public boolean isInteractionExist(String interactionID) {
        File interaction = new File("interactions.csv");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(interaction));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                // Find the cell
                if (interactionID.equalsIgnoreCase(tokens[0])) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Interaction's ID does not exist!");
        return false;
    }
}
