package databases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.generated.tables.Company;
import com.example.generated.tables.records.CompanyRecord;

public class InsertData_PublicTransportation {

	public static void main(String[] args) throws SQLException, IOException {
        // Connessione al database
        Connection conn = DriverManager.getConnection(utility.Constant.DB_URL_PUBLIC_TRANSPORTATION);
        DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

        // Leggere il file JSON dalla cartella "json"
        File jsonFile = new File("json/COMPANY.json");
        FileReader fileReader = new FileReader(jsonFile);
        StringBuilder jsonContent = new StringBuilder();

        int i;
        while ((i = fileReader.read()) != -1) {
            jsonContent.append((char) i);
        }
        fileReader.close();

        // Converti il contenuto JSON in un JSONArray
        JSONArray companiesJsonArray = new JSONArray(jsonContent.toString());

        // Ciclo su ogni oggetto del JSONArray e inserimento nel database
        for (int j = 0; j < companiesJsonArray.length(); j++) {
            JSONObject companyJson = companiesJsonArray.getJSONObject(j);

            // Estrai i valori dal JSON
            String name = companyJson.getString("name");
            String legalStructure = companyJson.getString("legal_structure");
            String businessTaxCode = companyJson.getString("business_tax_code");
            String companyRegistrationNumber = companyJson.getString("company_registration_number");
            String incorporationDate = companyJson.getString("incorporation_date");
            String legalRepresentative = companyJson.optString("legal_representative", "");
            String numberOfEmployees = companyJson.getString("number_of_employees");
            String atecoCode = companyJson.getString("ateco_code");
            String registeredOffice = companyJson.getString("registered_office");
            String province = companyJson.getString("province");
            String cap = companyJson.getString("cap");
            String address = companyJson.getString("address");
            String streetNumber = companyJson.getString("street_number");
            String telephone = companyJson.getString("telephone");
            String mail = companyJson.getString("mail");
            String social = companyJson.getString("social");
            String webSite = companyJson.getString("web_site");
            
         // Crea un CompanyRecord con i dati estratti
            CompanyRecord companyRecord = new CompanyRecord(
                    name,
                    legalStructure,
                    businessTaxCode,
                    companyRegistrationNumber,
                    incorporationDate,
                    legalRepresentative,
                    numberOfEmployees,
                    atecoCode,
                    registeredOffice,
                    province,
                    cap,
                    address,
                    streetNumber,
                    telephone,
                    mail,
                    social,
                    webSite
            );

            // Inserisci i dati nel database
            create.insertInto(Company.COMPANY).set(companyRecord).execute();
        }

        System.out.println("Dati inseriti con successo!");
    }
}
