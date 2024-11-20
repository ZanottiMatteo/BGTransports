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

import transportation.jooq.generated.tables.Company;
import transportation.jooq.generated.tables.Funicular;
import transportation.jooq.generated.tables.FunicularStation;
import transportation.jooq.generated.tables.PullmanStop;
import transportation.jooq.generated.tables.TrainStation;
import transportation.jooq.generated.tables.Tram;
import transportation.jooq.generated.tables.TramStop;
import transportation.jooq.generated.tables.records.CompanyRecord;
import transportation.jooq.generated.tables.records.FunicularRecord;
import transportation.jooq.generated.tables.records.FunicularStationRecord;
import transportation.jooq.generated.tables.records.PullmanRecord;
import transportation.jooq.generated.tables.records.PullmanStopRecord;
import transportation.jooq.generated.tables.records.TrainStationRecord;
import transportation.jooq.generated.tables.records.TramRecord;
import transportation.jooq.generated.tables.records.TramStopRecord;

public class InsertData_PublicTransportation {

	public static JSONArray fileReader(File jsonFile) throws IOException {
		FileReader fileReader = new FileReader(jsonFile);
		StringBuilder jsonContent = new StringBuilder();

		int i;
		while ((i = fileReader.read()) != -1) {
			jsonContent.append((char) i);
		}
		fileReader.close();

		// Converti il contenuto JSON in un JSONArray
		JSONArray companiesJsonArray = new JSONArray(jsonContent.toString());

		return companiesJsonArray;
	}

	public static void company(DSLContext create) throws IOException {
		// Leggere il file JSON dalla cartella "json"
		File jsonFile = new File(utility.Constant.JSON_COMPANY);
		JSONArray companiesJsonArray = fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < companiesJsonArray.length(); j++) {
			JSONObject companyJson = companiesJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			String name = companyJson.getString(utility.Constant.name);
			String legalStructure = companyJson.getString(utility.Constant.legal_structure);
			String businessTaxCode = companyJson.getString(utility.Constant.business_tax_code);
			String companyRegistrationNumber = companyJson.getString(utility.Constant.company_registration_number);
			String incorporationDate = companyJson.getString(utility.Constant.incorporation_date);
			String legalRepresentative = companyJson.optString(utility.Constant.legal_representative, "");
			String numberOfEmployees = companyJson.getString(utility.Constant.number_of_employees);
			String atecoCode = companyJson.getString(utility.Constant.ATECO_code);
			String registeredOffice = companyJson.getString(utility.Constant.registered_office);
			String province = companyJson.getString(utility.Constant.province);
			String cap = companyJson.getString(utility.Constant.CAP);
			String address = companyJson.getString(utility.Constant.address);
			String streetNumber = companyJson.getString(utility.Constant.street_number);
			String telephone = companyJson.getString(utility.Constant.telephone);
			String mail = companyJson.getString(utility.Constant.mail);
			String social = companyJson.getString(utility.Constant.social);
			String webSite = companyJson.getString(utility.Constant.web_site);

			// Crea un CompanyRecord con i dati estratti
			CompanyRecord companyRecord = new CompanyRecord(name, legalStructure, businessTaxCode,
					companyRegistrationNumber, incorporationDate, legalRepresentative, numberOfEmployees, atecoCode,
					registeredOffice, province, cap, address, streetNumber, telephone, mail, social, webSite);
			// Inserisci i dati nel database
			create.insertInto(Company.COMPANY).set(companyRecord).execute();
		}
		System.out.println("Dati inseriti in " + utility.Constant.company + " con successo!");
	}

	public static void pullman_stop(DSLContext create) throws IOException {
		// Leggere il file JSON dalla cartella "json"
		File jsonFile = new File(utility.Constant.JSON_PULLMAN_STOP);
		JSONArray pullmanStopJsonArray = fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < pullmanStopJsonArray.length(); j++) {
			JSONObject pullmanStopJson = pullmanStopJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			String name = pullmanStopJson.getString(utility.Constant.name);
			String town = pullmanStopJson.getString(utility.Constant.town);
			String province = pullmanStopJson.getString(utility.Constant.province);

			// Crea un StateRecord con i dati estratti
			PullmanStopRecord pullmanStopRecord = new PullmanStopRecord(name, town, province);
			// Inserisci i dati nel database
			create.insertInto(PullmanStop.PULLMAN_STOP).set(pullmanStopRecord).execute();
		}
		System.out.println("Dati inseriti in " + utility.Constant.pullman_stop + " con successo!");
	}

	public static void funicular_station(DSLContext create) throws IOException {
		// Leggere il file JSON dalla cartella "json"
		File jsonFile = new File(utility.Constant.JSON_FUNICULAR_STATION);
		JSONArray funicularStationJsonArray = fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < funicularStationJsonArray.length(); j++) {
			JSONObject funicularStationJson = funicularStationJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			String name = funicularStationJson.getString(utility.Constant.name);
			String address = funicularStationJson.getString(utility.Constant.address);
			String town = funicularStationJson.getString(utility.Constant.town);
			String province = funicularStationJson.getString(utility.Constant.province);

			// Crea un StateRecord con i dati estratti
			FunicularStationRecord funicularStationRecord = new FunicularStationRecord(name, address, town, province);
			// Inserisci i dati nel database
			create.insertInto(FunicularStation.FUNICULAR_STATION).set(funicularStationRecord).execute();
		}
		System.out.println("Dati inseriti in " + utility.Constant.funicular_station + " con successo!");
	}

	public static void tram_stop(DSLContext create) throws IOException {
		// Leggere il file JSON dalla cartella "json"
		File jsonFile = new File(utility.Constant.JSON_TRAM_STOP);
		JSONArray tramStopJsonArray = fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < tramStopJsonArray.length(); j++) {
			JSONObject tramStopJson = tramStopJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			String name = tramStopJson.getString(utility.Constant.name);
			String address = tramStopJson.getString(utility.Constant.address);
			String town = tramStopJson.getString(utility.Constant.town);
			String province = tramStopJson.getString(utility.Constant.province);

			// Crea un StateRecord con i dati estratti
			TramStopRecord tramStopRecord = new TramStopRecord(name, address, town, province);
			// Inserisci i dati nel database
			create.insertInto(TramStop.TRAM_STOP).set(tramStopRecord).execute();
		}
		System.out.println("Dati inseriti in " + utility.Constant.tram_stop + " con successo!");
	}

	public static void train_station(DSLContext create) throws IOException {
		// Leggere il file JSON dalla cartella "json"
		File jsonFile = new File(utility.Constant.JSON_TRAIN_STATION);
		JSONArray trainStationJsonArray = fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < trainStationJsonArray.length(); j++) {
			JSONObject trainStationJson = trainStationJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			String name = trainStationJson.getString(utility.Constant.name);
			String address = trainStationJson.getString(utility.Constant.address);
			String town = trainStationJson.getString(utility.Constant.town);
			String province = trainStationJson.getString(utility.Constant.province);

			// Crea un CompanyRecord con i dati estratti
			TrainStationRecord trainStationRecord = new TrainStationRecord(name, address, town, province);
			// Inserisci i dati nel database
			create.insertInto(TrainStation.TRAIN_STATION).set(trainStationRecord).execute();
		}
		System.out.println("Dati inseriti in " + utility.Constant.train_station + " con successo!");
	}
	
	public static void funicular(DSLContext create) throws IOException {
		File jsonFile = new File(utility.Constant.JSON_FUNICULAR_TIMETABLE);
		JSONArray funicularJsonArray = fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < funicularJsonArray.length(); j++) {
			JSONObject funicularJson = funicularJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			int id = funicularJson.getInt(utility.Constant.id);
			String company_name = funicularJson.getString(utility.Constant.company_name);
			String name = funicularJson.getString(utility.Constant.name);
			String departureFunicularStation = funicularJson.getString(utility.Constant.departure_funicular_station);
			String departureTime = funicularJson.getString(utility.Constant.departure_time);
			String arrivalFunicularStation = funicularJson.getString(utility.Constant.arrival_funicular_station);
			String arrivalTime = funicularJson.getString(utility.Constant.arrival_time);
			String type = funicularJson.getString(utility.Constant.type);
			String numberOfSeats = funicularJson.getString(utility.Constant.number_of_seats);

			// Crea un CompanyRecord con i dati estratti
			FunicularRecord funicularRecord = new FunicularRecord(id, company_name, name, departureFunicularStation, departureTime, arrivalFunicularStation, arrivalTime, type, numberOfSeats);
			// Inserisci i dati nel database
			create.insertInto(Funicular.FUNICULAR).set(funicularRecord).execute();
		}
		System.out.println("Dati inseriti in " + utility.Constant.funicular + " con successo!");
	}
	
	public static void tram(DSLContext create) throws IOException {
		File jsonFile = new File(utility.Constant.JSON_TRAM_TIMETABLE);
		JSONArray tramJsonArray = fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < tramJsonArray.length(); j++) {
			JSONObject tramJson = tramJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			int id = tramJson.getInt(utility.Constant.id);
			String company_name = tramJson.getString(utility.Constant.company_name);
			String name = tramJson.getString(utility.Constant.name);
			String departureTramStation = tramJson.getString(utility.Constant.departure_tram_station);
			String departureTime = tramJson.getString(utility.Constant.departure_time);
			String arrivalTramStation = tramJson.getString(utility.Constant.arrival_tram_station);
			String arrivalTime = tramJson.getString(utility.Constant.arrival_time);
			String nextStop = tramJson.getString(utility.Constant.next_stop);
			String timeStop = tramJson.getString(utility.Constant.time_stop);
			String type = tramJson.getString(utility.Constant.type);
			String numberOfSeats = tramJson.getString(utility.Constant.number_of_seats);
			String numberOfCarriages = tramJson.getString(utility.Constant.number_of_carriages);

			// Crea un CompanyRecord con i dati estratti
			TramRecord tramRecord = new TramRecord(id, company_name, name, departureTramStation, departureTime, arrivalTramStation, arrivalTime, nextStop, timeStop, type, numberOfSeats, numberOfCarriages);
			// Inserisci i dati nel database
			create.insertInto(Tram.TRAM).set(tramRecord).execute();
		}
		System.out.println("Dati inseriti in " + utility.Constant.tram + " con successo!");
	}

	public static void main(String[] args) throws SQLException, IOException {
		// Connessione al database
		Connection conn = DriverManager.getConnection(utility.Constant.DB_URL_PUBLIC_TRANSPORTATION);
		DSLContext create = DSL.using(conn, SQLDialect.SQLITE);

		company(create);
		funicular_station(create);
		train_station(create);
		tram_stop(create);
		pullman_stop(create);
		funicular(create);
		tram(create);
	}
}
