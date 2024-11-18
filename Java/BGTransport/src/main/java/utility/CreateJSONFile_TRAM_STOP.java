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
                "  { \"name\": \"ALBINO\", \"address\": \"Piazza Giovanni XXIII\", \"town\": \"Albino\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"ALZANO CENTRO\", \"address\": \"Via Bonomelli\", \"town\": \"Alzano Lombardo\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"ALZANO SOPRA\", \"address\": \"Via San Giovanni\", \"town\": \"Alzano Sopra\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"BG BIANZANA\", \"address\": \"Via Bianzana\", \"town\": \"Bergamo\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"BG BORGO PALAZZO\", \"address\": \"Via Borgo Palazzo\", \"town\": \"Bergamo\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"BG MARTINELLA\", \"address\": \"Via Martinella\", \"town\": \"Bergamo\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"BG NEGRISOLI\", \"address\": \"Via Negrisoli\", \"town\": \"Bergamo\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"BG REDONA\", \"address\": \"Via Redona\", \"town\": \"Bergamo\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"BG SAN FERMO\", \"address\": \"Via San Fermo\", \"town\": \"Bergamo\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"BERGAMO FS\", \"address\": \"Piazza Marconi\", \"town\": \"Bergamo\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"NEMBRO CAMOZZI\", \"address\": \"Via Camozzi\", \"town\": \"Nembro\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"NEMBRO CENTRO\", \"address\": \"Via Gianetti\", \"town\": \"Nembro\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"NEMBRO SALETTI\", \"address\": \"Via Saletti\", \"town\": \"Nembro\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"PRADALUNGA\", \"address\": \"Via dei Martiri\", \"town\": \"Pradalunga\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"RANICA\", \"address\": \"Via Cimitero\", \"town\": \"Ranica\", \"province\": \"BG\" },\n" +
                "  { \"name\": \"TORRE BOLDONE\", \"address\": \"Via Fratelli Calvi\", \"town\": \"Torre Boldone\", \"province\": \"BG\" }\n" +
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
