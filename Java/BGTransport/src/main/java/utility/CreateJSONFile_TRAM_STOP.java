package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile_TRAM_STOP {
    public static void main(String[] args) {
        // Dati JSON da scrivere nel file
        String jsonData = "[\n" +
                "  {\n" +
                "    \"name\": \"ALBINO\"\n" + 
                "  },\n" + 
                "  {\n" +
                "    \"name\": \"ALZANO CENTRO\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ALZANO SOPRA\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BG BIANZANA\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BG BORGO PALAZZO\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BG MARTINELLA\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BG NEGRISOLI\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BG REDONA\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BG SAN FERMO\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"BERGAMO FS\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"NEMBRO CAMOZZI\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"NEMBRO CENTRO\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"NEMBRO SALETTI\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"PRADALUNGA\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"RANICA\"\n" + 
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TORRE BOLDONE\"\n" + 
                "  }\n" + 
                "]";

        // Creare il file JSON nella cartella "json"
        File file = new File(utility.Constant.JSON_TRAM_STOP);

        // Scrivere i dati nel file JSON
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonData);
            System.out.println("File JSON creato con successo in: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
