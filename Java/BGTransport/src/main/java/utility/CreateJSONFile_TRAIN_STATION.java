package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile_TRAIN_STATION {

	public static void main(String[] args) {
        // Dati JSON da scrivere nel file
        String jsonData = "[\n" +
                "  {\n" +
                "    \"name\": \"Albano S.Alessandro\",\n" +
                "    \"address\": \"V. Santuario, 19\",\n" +
                "    \"town\": \"Albano Sant'alessandro\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Ambivere-Mapello\",\n" +
                "    \"address\": \"V. Donizetti, 1\",\n" +
                "    \"town\": \"Ambivere\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Arcene\",\n" +
                "    \"address\": \"Strada Provinciale Ex Ss 42 Del Tonale/Sempione\",\n" +
                "    \"town\": \"Arcene\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Bergamo\",\n" +
                "    \"address\": \"Piazza Marconi, 7\",\n" +
                "    \"town\": \"Bergamo\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Bergamo Ospedale\",\n" +
                "    \"address\": \"Via Martin Luther King\",\n" +
                "    \"town\": \"Bergamo\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Calusco\",\n" +
                "    \"address\": \"V. Trieste, 22\",\n" +
                "    \"town\": \"Calusco D'adda\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Caravaggio\",\n" +
                "    \"address\": \"Viale Papa Giovanni Xxiii\",\n" +
                "    \"town\": \"Caravaggio\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Chiuduno\",\n" +
                "    \"address\": \"V. Monsignor Valoti\",\n" +
                "    \"town\": \"Chiuduno\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Cisano-Caprino Bergamasco\",\n" +
                "    \"address\": \"Piazza Martiri Della Libertà, 5\",\n" +
                "    \"town\": \"Cisano Bergamasco\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Cividate-Calcio\",\n" +
                "    \"address\": \"V. Stazione\",\n" +
                "    \"town\": \"Cividate Al Piano\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Grumello del Monte\",\n" +
                "    \"address\": \"Viale Vittorio Veneto, 42\",\n" +
                "    \"town\": \"Grumello Del Monte\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Levate\",\n" +
                "    \"address\": \"Via S.Maria\",\n" +
                "    \"town\": \"Levate\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Montello-Gorlago\",\n" +
                "    \"address\": \"V. Stazione, 6\",\n" +
                "    \"town\": \"Montello\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Morengo-Bariano\",\n" +
                "    \"address\": \"V. Locatelli\",\n" +
                "    \"town\": \"Bariano\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Ponte S.Pietro\",\n" +
                "    \"address\": \"Piazza Dante, 8\",\n" +
                "    \"town\": \"Ponte San Pietro\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Pontida\",\n" +
                "    \"address\": \"V. Stazione\",\n" +
                "    \"town\": \"Pontida\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Romano\",\n" +
                "    \"address\": \"Piazza Stazione, 6\",\n" +
                "    \"town\": \"Romano Di Lombardia\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Seriate\",\n" +
                "    \"address\": \"V. Stazione, 2\",\n" +
                "    \"town\": \"Seriate\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Stezzano\",\n" +
                "    \"address\": \"Via Santuario\",\n" +
                "    \"town\": \"Stezzano\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Terno\",\n" +
                "    \"address\": \"V. Marconi, 14\",\n" +
                "    \"town\": \"Terno D'isola\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Treviglio\",\n" +
                "    \"address\": \"Piazza Verdi, 4\",\n" +
                "    \"town\": \"Treviglio\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Treviglio Ovest\",\n" +
                "    \"address\": \"Piazzale Mazzini\",\n" +
                "    \"town\": \"Treviglio\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Verdello-Dalmine\",\n" +
                "    \"address\": \"V. Marconi, 54\",\n" +
                "    \"town\": \"Verdellino\",\n" +
                "    \"province\": \"BG\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Vidalengo\",\n" +
                "    \"address\": \"V. Donizetti\",\n" +
                "    \"town\": \"Caravaggio\",\n" +
                "    \"province\": \"BG\"\n" +
                "  }\n" +
                "]";

        // Creare il file JSON nella cartella "json"
        File file = new File(utility.Constant.JSON_TRAIN_STATION);

        // Scrivere i dati nel file JSON
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonData);
            System.out.println("File JSON creato con successo in: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
