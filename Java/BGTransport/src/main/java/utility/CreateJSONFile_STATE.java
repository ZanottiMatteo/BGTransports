package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile_STATE {

	public static void main(String[] args) {
		// Dati JSON da scrivere nel file
        String jsonData = "[\n" +
                "  {\n" +
                "    \"description\": \"In stock\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"description\": \"Under repair\"\n" + 
                "  },\n" + 
                "  {\n" +
                "    \"description\": \"In service\"\n" + 
                "  },\n" + 
                "]";

        // Creare il file JSON nella cartella "json"
        File file = new File(utility.Constant.JSON_STATE);

        // Scrivere i dati nel file JSON
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonData);
            System.out.println("File JSON creato con successo in: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 
