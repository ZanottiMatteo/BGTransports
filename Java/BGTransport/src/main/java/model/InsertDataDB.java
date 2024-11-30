package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.jooq.DSLContext;
import org.json.JSONArray;
import org.json.JSONObject;

import transportation.jooq.generated.tables.Company;
import transportation.jooq.generated.tables.Funicular;
import transportation.jooq.generated.tables.FunicularStation;
import transportation.jooq.generated.tables.Pullman;
import transportation.jooq.generated.tables.PullmanStop;
import transportation.jooq.generated.tables.Train;
import transportation.jooq.generated.tables.TrainStation;
import transportation.jooq.generated.tables.Tram;
import transportation.jooq.generated.tables.TramStop;
import transportation.jooq.generated.tables.records.CompanyRecord;
import transportation.jooq.generated.tables.records.FunicularRecord;
import transportation.jooq.generated.tables.records.FunicularStationRecord;
import transportation.jooq.generated.tables.records.PullmanRecord;
import transportation.jooq.generated.tables.records.PullmanStopRecord;
import transportation.jooq.generated.tables.records.TrainRecord;
import transportation.jooq.generated.tables.records.TrainStationRecord;
import transportation.jooq.generated.tables.records.TramRecord;
import transportation.jooq.generated.tables.records.TramStopRecord;

public class InsertDataDB {

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
		File jsonFile = new File(Constant.JSON_COMPANY);
		JSONArray companiesJsonArray = fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < companiesJsonArray.length(); j++) {
			JSONObject companyJson = companiesJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			String name = companyJson.getString(Constant.name);
			String legalStructure = companyJson.getString(Constant.legal_structure);
			String businessTaxCode = companyJson.getString(Constant.business_tax_code);
			String companyRegistrationNumber = companyJson.getString(Constant.company_registration_number);
			String incorporationDate = companyJson.getString(Constant.incorporation_date);
			String legalRepresentative = companyJson.optString(Constant.legal_representative, "");
			String numberOfEmployees = companyJson.getString(Constant.number_of_employees);
			String atecoCode = companyJson.getString(Constant.ATECO_code);
			String registeredOffice = companyJson.getString(Constant.registered_office);
			String province = companyJson.getString(Constant.province);
			String cap = companyJson.getString(Constant.CAP);
			String address = companyJson.getString(Constant.address);
			String streetNumber = companyJson.getString(Constant.street_number);
			String telephone = companyJson.getString(Constant.telephone);
			String mail = companyJson.getString(Constant.mail);
			String social = companyJson.getString(Constant.social);
			String webSite = companyJson.getString(Constant.web_site);

			CompanyRecord companyRecord = new CompanyRecord(name, legalStructure, businessTaxCode,
					companyRegistrationNumber, incorporationDate, legalRepresentative, numberOfEmployees, atecoCode,
					registeredOffice, province, cap, address, streetNumber, telephone, mail, social, webSite);
			create.insertInto(Company.COMPANY).set(companyRecord).execute();
		}
		System.out.println("Add data in " + Constant.company + " with success!");
	}

	public static void pullman_stop(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_PULLMAN_STOP);
		JSONArray pullmanStopJsonArray = fileReader(jsonFile);
		for (int j = 0; j < pullmanStopJsonArray.length(); j++) {
			JSONObject pullmanStopJson = pullmanStopJsonArray.getJSONObject(j);

			String name = pullmanStopJson.getString(Constant.name);
			String town = pullmanStopJson.getString(Constant.town);
			String province = pullmanStopJson.getString(Constant.province);
			String latitude = pullmanStopJson.getString(Constant.latitude);
			String longitude = pullmanStopJson.getString(Constant.longitude);
			
			PullmanStopRecord pullmanStopRecord = new PullmanStopRecord(name, town, province, latitude, longitude);
			create.insertInto(PullmanStop.PULLMAN_STOP).set(pullmanStopRecord).execute();
		}
		System.out.println("Add data in " + Constant.pullman_stop + " with success!");
	}

	public static void funicular_station(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_FUNICULAR_STATION);
		JSONArray funicularStationJsonArray = fileReader(jsonFile);
		for (int j = 0; j < funicularStationJsonArray.length(); j++) {
			JSONObject funicularStationJson = funicularStationJsonArray.getJSONObject(j);

			String name = funicularStationJson.getString(Constant.name);
			String address = funicularStationJson.getString(Constant.address);
			String town = funicularStationJson.getString(Constant.town);
			String province = funicularStationJson.getString(Constant.province);
			String latitude = funicularStationJson.getString(Constant.latitude);
			String longitude = funicularStationJson.getString(Constant.longitude);

			FunicularStationRecord funicularStationRecord = new FunicularStationRecord(name, address, town, province, latitude, longitude);
			create.insertInto(FunicularStation.FUNICULAR_STATION).set(funicularStationRecord).execute();
		}
		System.out.println("Add data in " + Constant.funicular_station + " with success!");
	}

	public static void tram_stop(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_TRAM_STOP);
		JSONArray tramStopJsonArray = fileReader(jsonFile);
		for (int j = 0; j < tramStopJsonArray.length(); j++) {
			JSONObject tramStopJson = tramStopJsonArray.getJSONObject(j);

			String name = tramStopJson.getString(Constant.name);
			String address = tramStopJson.getString(Constant.address);
			String town = tramStopJson.getString(Constant.town);
			String province = tramStopJson.getString(Constant.province);
			String latitude = tramStopJson.getString(Constant.latitude);
			String longitude = tramStopJson.getString(Constant.longitude);

			TramStopRecord tramStopRecord = new TramStopRecord(name, address, town, province, latitude, longitude);
			create.insertInto(TramStop.TRAM_STOP).set(tramStopRecord).execute();
		}
		System.out.println("Add data in " + Constant.tram_stop + " with success!");
	}

	public static void train_station(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_TRAIN_STATION);
		JSONArray trainStationJsonArray = fileReader(jsonFile);
		for (int j = 0; j < trainStationJsonArray.length(); j++) {
			JSONObject trainStationJson = trainStationJsonArray.getJSONObject(j);

			String name = trainStationJson.getString(Constant.name);
			String address = trainStationJson.getString(Constant.address);
			String town = trainStationJson.getString(Constant.town);
			String province = trainStationJson.getString(Constant.province);
			String latitude = trainStationJson.getString(Constant.latitude);
			String longitude = trainStationJson.getString(Constant.longitude);

			TrainStationRecord trainStationRecord = new TrainStationRecord(name, address, town, province, latitude, longitude);
			create.insertInto(TrainStation.TRAIN_STATION).set(trainStationRecord).execute();
		}
		System.out.println("Add data in " + Constant.train_station + " with success!");
	}

	public static void funicularTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_FUNICULAR_TIMETABLE);
		JSONArray funicularJsonArray = fileReader(jsonFile);
		for (int j = 0; j < funicularJsonArray.length(); j++) {
			JSONObject funicularJson = funicularJsonArray.getJSONObject(j);

			int id = funicularJson.getInt(Constant.id);
			String company_name = funicularJson.getString(Constant.company_name);
			String name = funicularJson.getString(Constant.name);
			String departureFunicularStation = funicularJson.getString(Constant.departure_funicular_station);
			String departureTime = funicularJson.getString(Constant.departure_time);
			String arrivalFunicularStation = funicularJson.getString(Constant.arrival_funicular_station);
			String arrivalTime = funicularJson.getString(Constant.arrival_time);
			String type = funicularJson.getString(Constant.type);
			String numberOfSeats = funicularJson.getString(Constant.number_of_seats);

			FunicularRecord funicularRecord = new FunicularRecord(id, company_name, name, departureFunicularStation,
					departureTime, arrivalFunicularStation, arrivalTime, type, numberOfSeats);
			create.insertInto(Funicular.FUNICULAR).set(funicularRecord).execute();
		}
		System.out.println("Add data in " + Constant.funicular + " with success!");
	}

	public static void tramTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_TRAM_TIMETABLE);
		JSONArray tramJsonArray = fileReader(jsonFile);
		for (int j = 0; j < tramJsonArray.length(); j++) {
			JSONObject tramJson = tramJsonArray.getJSONObject(j);

			int id = tramJson.getInt(Constant.id);
			String company_name = tramJson.getString(Constant.company_name);
			String name = tramJson.getString(Constant.name);
			String departureTramStation = tramJson.getString(Constant.departure_tram_station);
			String departureTime = tramJson.getString(Constant.departure_time);
			String arrivalTramStation = tramJson.getString(Constant.arrival_tram_station);
			String arrivalTime = tramJson.getString(Constant.arrival_time);
			String nextStop = tramJson.getString(Constant.next_stop);
			String timeStop = tramJson.getString(Constant.time_stop);
			String type = tramJson.getString(Constant.type);
			String numberOfSeats = tramJson.getString(Constant.number_of_seats);
			String numberOfCarriages = tramJson.getString(Constant.number_of_carriages);

			TramRecord tramRecord = new TramRecord(id, company_name, name, departureTramStation, departureTime,
					arrivalTramStation, arrivalTime, nextStop, timeStop, type, numberOfSeats, numberOfCarriages);
			create.insertInto(Tram.TRAM).set(tramRecord).execute();
		}
		System.out.println("Add data in " + Constant.tram + " with success!");
	}
	
	public static void trainTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_TRAIN_TIMETABLE);
		JSONArray trainJsonArray = fileReader(jsonFile);
		for (int j = 0; j < trainJsonArray.length(); j++) {
			JSONObject trainJson = trainJsonArray.getJSONObject(j);

			int id = trainJson.getInt(Constant.id);
			String company_name = trainJson.getString(Constant.company_name);
			String name = trainJson.getString(Constant.name);
			String departureTrainStation = trainJson.getString(Constant.departure_train_station);
			String departureTime = trainJson.getString(Constant.departure_time);
			String arrivalTrainStation = trainJson.getString(Constant.arrival_train_station);
			String arrivalTime = trainJson.getString(Constant.arrival_time);
			String nextStop = trainJson.getString(Constant.next_stop);
			String timeStop = trainJson.getString(Constant.time_stop);

			TrainRecord trainRecord = new TrainRecord(id, company_name, name, departureTrainStation, departureTime,
					arrivalTrainStation, arrivalTime, nextStop, timeStop);
			create.insertInto(Train.TRAIN).set(trainRecord).execute();
		}
		System.out.println("Add data in " + Constant.train + " with success!");
	}
	
	public static void pullmanTimetable(DSLContext create) throws IOException{
		File jsonFile = new File(Constant.JSON_PULLMAN_TIMETABLE);
		JSONArray pullmanJsonArray = fileReader(jsonFile);
		for (int j = 0; j < pullmanJsonArray.length(); j++) {
			JSONObject pullmanJson = pullmanJsonArray.getJSONObject(j);
			
			int id = pullmanJson.getInt(Constant.id);
			String company_name = pullmanJson.getString(Constant.company_name);
			String line = pullmanJson.getString(Constant.line);
			String departurePullmanStop = pullmanJson.getString(Constant.departure_pullman_stop);
			String departureTime = pullmanJson.getString(Constant.departure_time);
			String arrivalPullmanStop = pullmanJson.getString(Constant.arrival_pullman_stop);
			String arrivalTime = pullmanJson.getString(Constant.arrival_time);
			String nextStop = pullmanJson.getString(Constant.next_stop);
			String timeStop = pullmanJson.getString(Constant.time_stop);
			String type = pullmanJson.getString(Constant.type);

			PullmanRecord pullmanRecord = new PullmanRecord(id, company_name, line, departurePullmanStop, departureTime,
					arrivalPullmanStop, arrivalTime, nextStop, timeStop, type);
			create.insertInto(Pullman.PULLMAN).set(pullmanRecord).execute();
		}
		System.out.println("Add data in " + Constant.pullman + " with success!");
	}

}
