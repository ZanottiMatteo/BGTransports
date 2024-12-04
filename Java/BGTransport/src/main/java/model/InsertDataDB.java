package model;

import java.io.File;
import java.io.IOException;
import org.jooq.DSLContext;
import org.json.JSONArray;
import org.json.JSONObject;

import transportation.jooq.generated.tables.Company;
import transportation.jooq.generated.tables.Funicularstation;
import transportation.jooq.generated.tables.Funiculartimetable;
import transportation.jooq.generated.tables.Pullmanstop;
import transportation.jooq.generated.tables.Pullmantimetable;
import transportation.jooq.generated.tables.Trainstation;
import transportation.jooq.generated.tables.Traintimetable;
import transportation.jooq.generated.tables.Tramstop;
import transportation.jooq.generated.tables.Tramtimetable;
import transportation.jooq.generated.tables.records.CompanyRecord;
import transportation.jooq.generated.tables.records.FunicularstationRecord;
import transportation.jooq.generated.tables.records.FuniculartimetableRecord;
import transportation.jooq.generated.tables.records.PullmanstopRecord;
import transportation.jooq.generated.tables.records.PullmantimetableRecord;
import transportation.jooq.generated.tables.records.TrainstationRecord;
import transportation.jooq.generated.tables.records.TraintimetableRecord;
import transportation.jooq.generated.tables.records.TramstopRecord;
import transportation.jooq.generated.tables.records.TramtimetableRecord;

public class InsertDataDB {

	public static void company(DSLContext create) throws IOException {
		// Leggere il file JSON dalla cartella "json"
		File jsonFile = new File(Constant.jsonCompany);
		JSONArray companiesJsonArray = Utility.fileReader(jsonFile);
		// Ciclo su ogni oggetto del JSONArray e inserimento nel database
		for (int j = 0; j < companiesJsonArray.length(); j++) {
			JSONObject companyJson = companiesJsonArray.getJSONObject(j);

			// Estrai i valori dal JSON
			String name = companyJson.getString(Constant.name);
			String legalStructure = companyJson.getString(Constant.legalStructure);
			String businessTaxCode = companyJson.getString(Constant.businessTaxCode);
			String companyRegistrationNumber = companyJson.getString(Constant.companyRegistrationNumber);
			String incorporationDate = companyJson.getString(Constant.incorporationDate);
			String legalRepresentative = companyJson.optString(Constant.legalRepresentative, "");
			String numberOfEmployees = companyJson.getString(Constant.numberOfEmployees);
			String atecoCode = companyJson.getString(Constant.atecoCode);
			String registeredOffice = companyJson.getString(Constant.registeredOffice);
			String province = companyJson.getString(Constant.province);
			String cap = companyJson.getString(Constant.CAP);
			String address = companyJson.getString(Constant.address);
			String streetNumber = companyJson.getString(Constant.streetNumber);
			String telephone = companyJson.getString(Constant.telephone);
			String mail = companyJson.getString(Constant.mail);
			String social = companyJson.getString(Constant.social);
			String webSite = companyJson.getString(Constant.webSite);

			CompanyRecord companyRecord = new CompanyRecord(name, legalStructure, businessTaxCode,
					companyRegistrationNumber, incorporationDate, legalRepresentative, numberOfEmployees, atecoCode,
					registeredOffice, province, cap, address, streetNumber, telephone, mail, social, webSite);
			create.insertInto(Company.COMPANY).set(companyRecord).execute();
		}
		System.out.println("Add data in " + Constant.company + " with success!");
	}

	public static void pullman_stop(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.jsonPullmanStop);
		JSONArray pullmanStopJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < pullmanStopJsonArray.length(); j++) {
			JSONObject pullmanStopJson = pullmanStopJsonArray.getJSONObject(j);

			String name = pullmanStopJson.getString(Constant.name);
			String town = pullmanStopJson.getString(Constant.town);
			String province = pullmanStopJson.getString(Constant.province);
			String latitude = pullmanStopJson.getString(Constant.latitude);
			String longitude = pullmanStopJson.getString(Constant.longitude);
			
			PullmanstopRecord pullmanStopRecord = new PullmanstopRecord(name, town, province, latitude, longitude);
			create.insertInto(Pullmanstop.PULLMANSTOP).set(pullmanStopRecord).execute();
		}
		System.out.println("Add data in " + Constant.pullmanStop + " with success!");
	}

	public static void funicular_station(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.jsonFunicularStation);
		JSONArray funicularStationJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < funicularStationJsonArray.length(); j++) {
			JSONObject funicularStationJson = funicularStationJsonArray.getJSONObject(j);

			String name = funicularStationJson.getString(Constant.name);
			String address = funicularStationJson.getString(Constant.address);
			String town = funicularStationJson.getString(Constant.town);
			String province = funicularStationJson.getString(Constant.province);
			String latitude = funicularStationJson.getString(Constant.latitude);
			String longitude = funicularStationJson.getString(Constant.longitude);

			FunicularstationRecord funicularStationRecord = new FunicularstationRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Funicularstation.FUNICULARSTATION).set(funicularStationRecord).execute();
		}
		System.out.println("Add data in " + Constant.funicularStation + " with success!");
	}

	public static void tram_stop(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.jsonTramStop);
		JSONArray tramStopJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < tramStopJsonArray.length(); j++) {
			JSONObject tramStopJson = tramStopJsonArray.getJSONObject(j);

			String name = tramStopJson.getString(Constant.name);
			String address = tramStopJson.getString(Constant.address);
			String town = tramStopJson.getString(Constant.town);
			String province = tramStopJson.getString(Constant.province);
			String latitude = tramStopJson.getString(Constant.latitude);
			String longitude = tramStopJson.getString(Constant.longitude);

			TramstopRecord tramStopRecord = new TramstopRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Tramstop.TRAMSTOP).set(tramStopRecord).execute();
		}
		System.out.println("Add data in " + Constant.tramStop + " with success!");
	}

	public static void train_station(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.jsonTrainStation);
		JSONArray trainStationJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < trainStationJsonArray.length(); j++) {
			JSONObject trainStationJson = trainStationJsonArray.getJSONObject(j);

			String name = trainStationJson.getString(Constant.name);
			String address = trainStationJson.getString(Constant.address);
			String town = trainStationJson.getString(Constant.town);
			String province = trainStationJson.getString(Constant.province);
			String latitude = trainStationJson.getString(Constant.latitude);
			String longitude = trainStationJson.getString(Constant.longitude);

			TrainstationRecord trainStationRecord = new TrainstationRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Trainstation.TRAINSTATION).set(trainStationRecord).execute();
		}
		System.out.println("Add data in " + Constant.trainStation + " with success!");
	}

	public static void funicularTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.jsonFunicularTimetable);
		JSONArray funicularJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < funicularJsonArray.length(); j++) {
			JSONObject funicularJson = funicularJsonArray.getJSONObject(j);

			int id = funicularJson.getInt(Constant.id);
			String company_name = funicularJson.getString(Constant.companyName);
			String name = funicularJson.getString(Constant.name);
			String departureFunicularStation = funicularJson.getString(Constant.departureFunicularStation);
			String departureTime = funicularJson.getString(Constant.departureTime);
			String arrivalFunicularStation = funicularJson.getString(Constant.arrivalFunicularStation);
			String arrivalTime = funicularJson.getString(Constant.arrivalTime);
			String type = funicularJson.getString(Constant.type);
			String numberOfSeats = funicularJson.getString(Constant.numberOfSeats);

			FuniculartimetableRecord funicularRecord = new FuniculartimetableRecord(id, company_name, name, departureFunicularStation,
					departureTime, arrivalFunicularStation, arrivalTime, type, numberOfSeats);
			create.insertInto(Funiculartimetable.FUNICULARTIMETABLE).set(funicularRecord).execute();
		}
		System.out.println("Add data in " + Constant.funicularTimetable + " with success!");
	}

	public static void tramTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.jsonTramTimetable);
		JSONArray tramJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < tramJsonArray.length(); j++) {
			JSONObject tramJson = tramJsonArray.getJSONObject(j);

			int id = tramJson.getInt(Constant.id);
			String company_name = tramJson.getString(Constant.companyName);
			String name = tramJson.getString(Constant.name);
			String departureTramStation = tramJson.getString(Constant.departureTramStation);
			String departureTime = tramJson.getString(Constant.departureTime);
			String arrivalTramStation = tramJson.getString(Constant.arrivalTramStation);
			String arrivalTime = tramJson.getString(Constant.arrivalTime);
			String nextStop = tramJson.getString(Constant.nextStop);
			String timeStop = tramJson.getString(Constant.timeStop);
			String type = tramJson.getString(Constant.type);
			String numberOfSeats = tramJson.getString(Constant.numberOfSeats);
			String numberOfCarriages = tramJson.getString(Constant.numberOfCarriages);

			TramtimetableRecord tramRecord = new TramtimetableRecord(id, company_name, name, departureTramStation, departureTime,
					arrivalTramStation, arrivalTime, nextStop, timeStop, type, numberOfSeats, numberOfCarriages);
			create.insertInto(Tramtimetable.TRAMTIMETABLE).set(tramRecord).execute();
		}
		System.out.println("Add data in " + Constant.tramTimetable + " with success!");
	}
	
	public static void trainTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.jsonTrainTimetable);
		JSONArray trainJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < trainJsonArray.length(); j++) {
			JSONObject trainJson = trainJsonArray.getJSONObject(j);

			int id = trainJson.getInt(Constant.id);
			String company_name = trainJson.getString(Constant.companyName);
			String name = trainJson.getString(Constant.name);
			String departureTrainStation = trainJson.getString(Constant.departureTrainStation);
			String departureTime = trainJson.getString(Constant.departureTime);
			String arrivalTrainStation = trainJson.getString(Constant.arrivalTrainStation);
			String arrivalTime = trainJson.getString(Constant.arrivalTime);
			String nextStop = trainJson.getString(Constant.nextStop);
			String timeStop = trainJson.getString(Constant.timeStop);

			TraintimetableRecord trainRecord = new TraintimetableRecord(id, company_name, name, departureTrainStation, departureTime,
					arrivalTrainStation, arrivalTime, nextStop, timeStop);
			create.insertInto(Traintimetable.TRAINTIMETABLE).set(trainRecord).execute();
		}
		System.out.println("Add data in " + Constant.trainTimetable + " with success!");
	}
	
	public static void pullmanTimetable(DSLContext create) throws IOException{
		File jsonFile = new File(Constant.jsonPullmanTimetable);
		JSONArray pullmanJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < pullmanJsonArray.length(); j++) {
			JSONObject pullmanJson = pullmanJsonArray.getJSONObject(j);
			
			int id = pullmanJson.getInt(Constant.id);
			String company_name = pullmanJson.getString(Constant.companyName);
			String line = pullmanJson.getString(Constant.line);
			String departurePullmanStop = pullmanJson.getString(Constant.departurePullmanStop);
			String departureTime = pullmanJson.getString(Constant.departureTime);
			String arrivalPullmanStop = pullmanJson.getString(Constant.arrivalPullmanStop);
			String arrivalTime = pullmanJson.getString(Constant.arrivalTime);
			String nextStop = pullmanJson.getString(Constant.nextStop);
			String timeStop = pullmanJson.getString(Constant.timeStop);
			String type = pullmanJson.getString(Constant.type);

			PullmantimetableRecord pullmanRecord = new PullmantimetableRecord(id, company_name, line, departurePullmanStop, departureTime,
					arrivalPullmanStop, arrivalTime, nextStop, timeStop, type);
			create.insertInto(Pullmantimetable.PULLMANTIMETABLE).set(pullmanRecord).execute();
		}
		System.out.println("Add data in " + Constant.pullmanTimetable + " with success!");
	}

}
