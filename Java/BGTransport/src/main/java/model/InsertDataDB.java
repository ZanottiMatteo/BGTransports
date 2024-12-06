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

	public static int company(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_COMPANY);
		JSONArray companiesJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < companiesJsonArray.length(); j++) {
			JSONObject companyJson = companiesJsonArray.getJSONObject(j);

			String name = companyJson.getString(Constant.NAME);
			String legalStructure = companyJson.getString(Constant.LEGAL_STRUCTURE);
			String businessTaxCode = companyJson.getString(Constant.BUSINESS_TAX_CODE);
			String companyRegistrationNumber = companyJson.getString(Constant.COMPANY_REGISTRATION_NUMBER);
			String incorporationDate = companyJson.getString(Constant.INCORPORATION_DATE);
			String legalRepresentative = companyJson.optString(Constant.LEGAL_REPRESENTATIVE, "");
			String numberOfEmployees = companyJson.getString(Constant.NUMBER_OF_EMPLOYEES);
			String atecoCode = companyJson.getString(Constant.ATECO_CODE);
			String registeredOffice = companyJson.getString(Constant.REGISTERED_OFFICE);
			String province = companyJson.getString(Constant.PROVINCE);
			String cap = companyJson.getString(Constant.CAP);
			String address = companyJson.getString(Constant.ADDRESS);
			String streetNumber = companyJson.getString(Constant.STREET_NUMBER);
			String telephone = companyJson.getString(Constant.TELEPHONE);
			String mail = companyJson.getString(Constant.MAIL);
			String social = companyJson.getString(Constant.SOCIAL);
			String webSite = companyJson.getString(Constant.WEB_SITE);

			CompanyRecord companyRecord = new CompanyRecord(name, legalStructure, businessTaxCode,
					companyRegistrationNumber, incorporationDate, legalRepresentative, numberOfEmployees, atecoCode,
					registeredOffice, province, cap, address, streetNumber, telephone, mail, social, webSite);
			create.insertInto(Company.COMPANY).set(companyRecord).execute();
		}
		return Constant.NUMBER_COMPANY_RECORD;
	}

	public static int pullmanStop(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_PULLMAN_STOP);
		JSONArray pullmanStopJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < pullmanStopJsonArray.length(); j++) {
			JSONObject pullmanStopJson = pullmanStopJsonArray.getJSONObject(j);

			String name = pullmanStopJson.getString(Constant.NAME);
			String town = pullmanStopJson.getString(Constant.TOWN);
			String province = pullmanStopJson.getString(Constant.PROVINCE);
			String latitude = pullmanStopJson.getString(Constant.LATITUDE);
			String longitude = pullmanStopJson.getString(Constant.LONGITUDE);
			
			PullmanstopRecord pullmanStopRecord = new PullmanstopRecord(name, town, province, latitude, longitude);
			create.insertInto(Pullmanstop.PULLMANSTOP).set(pullmanStopRecord).execute();
		}
		return Constant.NUMBER_PULLMAN_STOP_RECORD;
	}

	public static int funicularStation(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_FUNICULAR_STATION);
		JSONArray funicularStationJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < funicularStationJsonArray.length(); j++) {
			JSONObject funicularStationJson = funicularStationJsonArray.getJSONObject(j);

			String name = funicularStationJson.getString(Constant.NAME);
			String address = funicularStationJson.getString(Constant.ADDRESS);
			String town = funicularStationJson.getString(Constant.TOWN);
			String province = funicularStationJson.getString(Constant.PROVINCE);
			String latitude = funicularStationJson.getString(Constant.LATITUDE);
			String longitude = funicularStationJson.getString(Constant.LONGITUDE);

			FunicularstationRecord funicularStationRecord = new FunicularstationRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Funicularstation.FUNICULARSTATION).set(funicularStationRecord).execute();
		}
		return Constant.NUMBER_FUNICULAR_STATION_RECORD;
	}

	public static int tramStop(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_TRAM_STOP);
		JSONArray tramStopJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < tramStopJsonArray.length(); j++) {
			JSONObject tramStopJson = tramStopJsonArray.getJSONObject(j);

			String name = tramStopJson.getString(Constant.NAME);
			String address = tramStopJson.getString(Constant.ADDRESS);
			String town = tramStopJson.getString(Constant.TOWN);
			String province = tramStopJson.getString(Constant.PROVINCE);
			String latitude = tramStopJson.getString(Constant.LATITUDE);
			String longitude = tramStopJson.getString(Constant.LONGITUDE);

			TramstopRecord tramStopRecord = new TramstopRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Tramstop.TRAMSTOP).set(tramStopRecord).execute();
		}
		return Constant.NUMBER_TRAM_STOP_RECORD;
	}

	public static int trainStation(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_TRAIN_STATION);
		JSONArray trainStationJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < trainStationJsonArray.length(); j++) {
			JSONObject trainStationJson = trainStationJsonArray.getJSONObject(j);

			String name = trainStationJson.getString(Constant.NAME);
			String address = trainStationJson.getString(Constant.ADDRESS);
			String town = trainStationJson.getString(Constant.TOWN);
			String province = trainStationJson.getString(Constant.PROVINCE);
			String latitude = trainStationJson.getString(Constant.LATITUDE);
			String longitude = trainStationJson.getString(Constant.LONGITUDE);

			TrainstationRecord trainStationRecord = new TrainstationRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Trainstation.TRAINSTATION).set(trainStationRecord).execute();
		}
		return Constant.NUMBER_TRAIN_STATION_RECORD;
	}

	public static int funicularTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_FUNICULAR_TIMETABLE);
		JSONArray funicularJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < funicularJsonArray.length(); j++) {
			JSONObject funicularJson = funicularJsonArray.getJSONObject(j);

			int id = funicularJson.getInt(Constant.ID);
			String companyName = funicularJson.getString(Constant.COMPANY_NAME);
			String name = funicularJson.getString(Constant.NAME);
			String departureFunicularStation = funicularJson.getString(Constant.DEPARTURE_FUNICULAR_STATION);
			String departureTime = funicularJson.getString(Constant.DEPARTURE_TIME);
			String arrivalFunicularStation = funicularJson.getString(Constant.ARRIVAL_FUNICULAR_STATION);
			String arrivalTime = funicularJson.getString(Constant.ARRIVAL_TIME);
			String type = funicularJson.getString(Constant.TYPE);
			String numberOfSeats = funicularJson.getString(Constant.NUMBER_OF_SEATS);

			FuniculartimetableRecord funicularRecord = new FuniculartimetableRecord(id, companyName, name, departureFunicularStation,
					departureTime, arrivalFunicularStation, arrivalTime, type, numberOfSeats);
			create.insertInto(Funiculartimetable.FUNICULARTIMETABLE).set(funicularRecord).execute();
		}
		return Constant.NUMBER_FUNICULAR_TIMETABLE_RECORD;
	}

	public static int tramTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_TRAM_TIMETABLE);
		JSONArray tramJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < tramJsonArray.length(); j++) {
			JSONObject tramJson = tramJsonArray.getJSONObject(j);

			int id = tramJson.getInt(Constant.ID);
			String companyName = tramJson.getString(Constant.COMPANY_NAME);
			String name = tramJson.getString(Constant.NAME);
			String departureTramStation = tramJson.getString(Constant.DEPARTURE_TRAM_STATION);
			String departureTime = tramJson.getString(Constant.DEPARTURE_TIME);
			String arrivalTramStation = tramJson.getString(Constant.ARRIVAL_TRAM_STATION);
			String arrivalTime = tramJson.getString(Constant.ARRIVAL_TIME);
			String nextStop = tramJson.getString(Constant.NEXT_STOP);
			String timeStop = tramJson.getString(Constant.TIME_STOP);
			String type = tramJson.getString(Constant.TYPE);
			String numberOfSeats = tramJson.getString(Constant.NUMBER_OF_SEATS);
			String numberOfCarriages = tramJson.getString(Constant.NUMBER_OF_CARRIAGES);

			TramtimetableRecord tramRecord = new TramtimetableRecord(id, companyName, name, departureTramStation, departureTime,
					arrivalTramStation, arrivalTime, nextStop, timeStop, type, numberOfSeats, numberOfCarriages);
			create.insertInto(Tramtimetable.TRAMTIMETABLE).set(tramRecord).execute();
		}
		return Constant.NUMBER_TRAM_TIMETABLE_RECORD;
	}
	
	public static int trainTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(Constant.JSON_TRAIN_TIMETABLE);
		JSONArray trainJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < trainJsonArray.length(); j++) {
			JSONObject trainJson = trainJsonArray.getJSONObject(j);

			int id = trainJson.getInt(Constant.ID);
			String companyName = trainJson.getString(Constant.COMPANY_NAME);
			String name = trainJson.getString(Constant.NAME);
			String departureTrainStation = trainJson.getString(Constant.DEPARTURE_TRAIN_STATION);
			String departureTime = trainJson.getString(Constant.DEPARTURE_TIME);
			String arrivalTrainStation = trainJson.getString(Constant.ARRIVAL_TRAIN_STATION);
			String arrivalTime = trainJson.getString(Constant.ARRIVAL_TIME);
			String nextStop = trainJson.getString(Constant.NEXT_STOP);
			String timeStop = trainJson.getString(Constant.TIME_STOP);

			TraintimetableRecord trainRecord = new TraintimetableRecord(id, companyName, name, departureTrainStation, departureTime,
					arrivalTrainStation, arrivalTime, nextStop, timeStop);
			create.insertInto(Traintimetable.TRAINTIMETABLE).set(trainRecord).execute();
		}
		return Constant.NUMBER_TRAIN_TIMETABLE_RECORD;
	}
	
	public static int pullmanTimetable(DSLContext create) throws IOException{
		File jsonFile = new File(Constant.JSON_PULLMAN_TIMETABLE);
		JSONArray pullmanJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < pullmanJsonArray.length(); j++) {
			JSONObject pullmanJson = pullmanJsonArray.getJSONObject(j);
			
			int id = pullmanJson.getInt(Constant.ID);
			String companyName = pullmanJson.getString(Constant.COMPANY_NAME);
			String line = pullmanJson.getString(Constant.LINE);
			String departurePullmanStop = pullmanJson.getString(Constant.DEPARTURE_PULLMAN_STOP);
			String departureTime = pullmanJson.getString(Constant.DEPARTURE_TIME);
			String arrivalPullmanStop = pullmanJson.getString(Constant.ARRIVAL_PULLMAN_STOP);
			String arrivalTime = pullmanJson.getString(Constant.ARRIVAL_TIME);
			String nextStop = pullmanJson.getString(Constant.NEXT_STOP);
			String timeStop = pullmanJson.getString(Constant.TIME_STOP);
			String type = pullmanJson.getString(Constant.TYPE);

			PullmantimetableRecord pullmanRecord = new PullmantimetableRecord(id, companyName, line, departurePullmanStop, departureTime,
					arrivalPullmanStop, arrivalTime, nextStop, timeStop, type);
			create.insertInto(Pullmantimetable.PULLMANTIMETABLE).set(pullmanRecord).execute();
		}
		return Constant.NUMBER_PULLMAN_TIMETABLE_RECORD;
	}
}
