package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONFile_TIMETABLE {
    public static void main(String[] args) {
        // Creare il file JSON nella cartella "json"
        File file = new File(utility.Constant.JSON_TIMETABLE);
        
        // Creare il contenuto JSON con tutti gli orari della giornata
        StringBuilder jsonData = new StringBuilder("[\n");

        // Loop per generare tutti gli orari da "00:00" a "23:59"
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Formattare l'orario come "HH:mm"
                String time = String.format("%02d:%02d", hour, minute);
                jsonData.append("  {\n")
                        .append("    \"time\": \"").append(time).append("\"\n")
                        .append("  }");

                // Aggiungi una virgola a meno che non sia l'ultimo elemento
                if (hour != 23 || minute != 59) {
                    jsonData.append(",\n");
                }
            }
        }

        jsonData.append("\n]");

        // Scrivere i dati nel file JSON
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonData.toString());
            System.out.println("File JSON creato con successo in: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}