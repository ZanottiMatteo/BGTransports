package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateJSONFile_COMPANY {
    public static void main(String[] args) {
        // Dati JSON da scrivere nel file
        String jsonData = "[\n" +
                "  {\n" +
                "    \"name\": \"ATB SERVIZI\",\n" +
                "    \"legal_structure\": \"SP\",\n" +
                "    \"business_tax_code\": \"02967830163\",\n" +
                "    \"company_registration_number\": \"02967830163\",\n" +
                "    \"incorporation_date\": \"2003\",\n" +
                "    \"legal_representative\": \"Enrico Felli\",\n" +
                "    \"number_of_employees\": \"332\",\n" +
                "    \"ateco_code\": \"4931\",\n" +
                "    \"registered_office\": \"Bergamo\",\n" +
                "    \"province\": \"BG\",\n" +
                "    \"cap\": \"24125\",\n" +
                "    \"address\": \"Via Monte Gleno\",\n" +
                "    \"street_number\": \"13\",\n" +
                "    \"telephone\": \"035 236026\",\n" +
                "    \"mail\": \"atbservizispa@legalmail.it\",\n" +
                "    \"social\": \"https://www.instagram.com/atbaziendatrasporti/\",\n" +
                "    \"web_site\": \"https://atb.bergamo.it/\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"ARRIVA ITALIA\",\n" +
                "    \"legal_structure\": \"Società a Responsabilità Limitata\",\n" +
                "    \"business_tax_code\": \"5950660968\",\n" +
                "    \"company_registration_number\": \"5950660968\",\n" +
                "    \"incorporation_date\": \"2002\",\n" +
                "    \"legal_representative\": \"\",\n" +
                "    \"number_of_employees\": \"1510\",\n" +
                "    \"ateco_code\": \"493\",\n" +
                "    \"registered_office\": \"Milano\",\n" +
                "    \"province\": \"MI\",\n" +
                "    \"cap\": \"20132\",\n" +
                "    \"address\": \"Via Ludovico D’Aragona\",\n" +
                "    \"street_number\": \"11\",\n" +
                "    \"telephone\": \"028 4121000\",\n" +
                "    \"mail\": \"arriva@pec.arriva.it\",\n" +
                "    \"social\": \"https://www.instagram.com/arriva_italia/\",\n" +
                "    \"web_site\": \"https://arriva.it/\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"AUTOSERVIZI LOCATELLI\",\n" +
                "    \"legal_structure\": \"SR\",\n" +
                "    \"business_tax_code\": \"2605730163\",\n" +
                "    \"company_registration_number\": \"2605730163\",\n" +
                "    \"incorporation_date\": \"1998\",\n" +
                "    \"legal_representative\": \"Angela Locatelli\",\n" +
                "    \"number_of_employees\": \"126\",\n" +
                "    \"ateco_code\": \"4931\",\n" +
                "    \"registered_office\": \"Bergamo\",\n" +
                "    \"province\": \"BG\",\n" +
                "    \"cap\": \"24126\",\n" +
                "    \"address\": \"Via Furietti\",\n" +
                "    \"street_number\": \"17\",\n" +
                "    \"telephone\": \"035 319366\",\n" +
                "    \"mail\": \"info@autoservizilocatelli.it\",\n" +
                "    \"social\": \"https://www.instagram.com/gruppo_locatelli/?hl=it\",\n" +
                "    \"web_site\": \"https://www.autoservizilocatelli.it/default.asp\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"TRENORD\",\n" +
                "    \"legal_structure\": \"Società a Responsabilità Limitata\",\n" +
                "    \"business_tax_code\": \"06705490966\",\n" +
                "    \"company_registration_number\": \"06705490966\",\n" +
                "    \"incorporation_date\": \"2011\",\n" +
                "    \"legal_representative\": \"\",\n" +
                "    \"number_of_employees\": \"4708\",\n" +
                "    \"ateco_code\": \"491\",\n" +
                "    \"registered_office\": \"Milano\",\n" +
                "    \"province\": \"MI\",\n" +
                "    \"cap\": \"20123\",\n" +
                "    \"address\": \"Piazzale Luigi Cadorna\",\n" +
                "    \"street_number\": \"14\",\n" +
                "    \"telephone\": \"02 72494949\",\n" +
                "    \"mail\": \"reclami.trenord@legalmail.it\",\n" +
                "    \"social\": \"https://www.instagram.com/trenord/\",\n" +
                "    \"web_site\": \"https://www.trenord.it/\"\n" +
                "  }\n" +
                "]";

        // Creare il file JSON nella cartella "json"
        File file = new File("json/COMPANY.json");

        // Scrivere i dati nel file JSON
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonData);
            System.out.println("File JSON creato con successo in: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}