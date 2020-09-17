package AppWithGUI;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {
    public String[][] readFile(String fileName) {
        try {
            String currentLine;

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int lines = 0;
            int items = 0;

            while ((currentLine = reader.readLine()) != null) {
                currentLine.split(",");
                items = currentLine.length();
                lines++;
            }
            reader.close();

            String[][] fileData = new String[lines][items];

            reader = new BufferedReader(new FileReader(fileName));
            int i = 0;
            while ((currentLine = reader.readLine()) != null) {
                String[] tokens = currentLine.split(",");
                fileData[i++] = tokens;
            }
            reader.close();

            return fileData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
