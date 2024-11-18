package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile_FUNICULAR_STATION {

	public static void main(String[] args) {
        // Dati JSON da scrivere nel file
		String jsonData = "[\n" +
                "  {\n" +
                "    \"name\": \"FUNICOLARE\",\n" +
                "    \"address\": \"Viale Vittorio Emanuele II\",\n" +
                "    \"town\": \"Bergamo\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Staz.Sup.Fun.Città\",\n" +
                "    \"address\": \"Piazza Mercato delle Scarpe\",\n" +
                "    \"town\": \"Città Alta\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Staz.Inf.Fun.S.Vigilio\",\n" +
                "    \"address\": \"Largo di Porta S. Alessandro\",\n" +
                "    \"town\": \"Città Alta\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Staz.Sup.Fun.S.Vigilio\",\n" +
                "    \"address\": \"Piazza San Vigilio\",\n" +
                "    \"town\": \"Città Alta\",\n" +
                "    \"province\": \"BG\"\n" +
                "  }\n" +
                "]";

        // Creare il file JSON nella cartella "json"
        File file = new File(utility.Constant.JSON_FUNICULAR_STATION);

        // Scrivere i dati nel file JSON
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonData);
            System.out.println("File JSON creato con successo in: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
