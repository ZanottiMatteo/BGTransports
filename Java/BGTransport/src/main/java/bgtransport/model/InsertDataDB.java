package bgtransport.model;

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
		File jsonFile = new File(ConstantFile.JSON_COMPANY);
		JSONArray companiesJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < companiesJsonArray.length(); j++) {
			JSONObject companyJson = companiesJsonArray.getJSONObject(j);

			String name = companyJson.getString(ConstantString2.NAME);
			String legalStructure = companyJson.getString(ConstantString1.LEGAL_STRUCTURE);
			String businessTaxCode = companyJson.getString(ConstantString1.BUSINESS_TAX_CODE);
			String companyRegistrationNumber = companyJson.getString(ConstantString1.COMPANY_REGISTRATION_NUMBER);
			String incorporationDate = companyJson.getString(ConstantString1.INCORPORATION_DATE);
			String legalRepresentative = companyJson.optString(ConstantString1.LEGAL_REPRESENTATIVE, "");
			String numberOfEmployees = companyJson.getString(ConstantString2.NUMBER_OF_EMPLOYEES);
			String atecoCode = companyJson.getString(ConstantString1.ATECO_CODE);
			String registeredOffice = companyJson.getString(ConstantString2.REGISTERED_OFFICE);
			String province = companyJson.getString(ConstantString2.PROVINCE);
			String cap = companyJson.getString(ConstantString1.CAP);
			String address = companyJson.getString(ConstantString1.ADDRESS);
			String streetNumber = companyJson.getString(ConstantString2.STREET_NUMBER);
			String telephone = companyJson.getString(ConstantString2.TELEPHONE);
			String mail = companyJson.getString(ConstantString1.MAIL);
			String social = companyJson.getString(ConstantString2.SOCIAL);
			String webSite = companyJson.getString(ConstantString2.WEB_SITE);

			CompanyRecord companyRecord = new CompanyRecord(name, legalStructure, businessTaxCode,
					companyRegistrationNumber, incorporationDate, legalRepresentative, numberOfEmployees, atecoCode,
					registeredOffice, province, cap, address, streetNumber, telephone, mail, social, webSite);
			create.insertInto(Company.COMPANY).set(companyRecord).execute();
		}
		return ConstantInt.NUMBER_COMPANY_RECORD;
	}

	public static int pullmanStop(DSLContext create) throws IOException {
		File jsonFile = new File(ConstantFile.JSON_PULLMAN_STOP);
		JSONArray pullmanStopJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < pullmanStopJsonArray.length(); j++) {
			JSONObject pullmanStopJson = pullmanStopJsonArray.getJSONObject(j);

			String name = pullmanStopJson.getString(ConstantString2.NAME);
			String town = pullmanStopJson.getString(ConstantString2.TOWN);
			String province = pullmanStopJson.getString(ConstantString2.PROVINCE);
			String latitude = pullmanStopJson.getString(ConstantString2.LATITUDE);
			String longitude = pullmanStopJson.getString(ConstantString2.LONGITUDE);
			
			PullmanstopRecord pullmanStopRecord = new PullmanstopRecord(name, town, province, latitude, longitude);
			create.insertInto(Pullmanstop.PULLMANSTOP).set(pullmanStopRecord).execute();
		}
		return ConstantInt.NUMBER_PULLMAN_STOP_RECORD;
	}

	public static int funicularStation(DSLContext create) throws IOException {
		File jsonFile = new File(ConstantFile.JSON_FUNICULAR_STATION);
		JSONArray funicularStationJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < funicularStationJsonArray.length(); j++) {
			JSONObject funicularStationJson = funicularStationJsonArray.getJSONObject(j);

			String name = funicularStationJson.getString(ConstantString2.NAME);
			String address = funicularStationJson.getString(ConstantString1.ADDRESS);
			String town = funicularStationJson.getString(ConstantString2.TOWN);
			String province = funicularStationJson.getString(ConstantString2.PROVINCE);
			String latitude = funicularStationJson.getString(ConstantString2.LATITUDE);
			String longitude = funicularStationJson.getString(ConstantString2.LONGITUDE);

			FunicularstationRecord funicularStationRecord = new FunicularstationRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Funicularstation.FUNICULARSTATION).set(funicularStationRecord).execute();
		}
		return ConstantInt.NUMBER_FUNICULAR_STATION_RECORD;
	}

	public static int tramStop(DSLContext create) throws IOException {
		File jsonFile = new File(ConstantFile.JSON_TRAM_STOP);
		JSONArray tramStopJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < tramStopJsonArray.length(); j++) {
			JSONObject tramStopJson = tramStopJsonArray.getJSONObject(j);

			String name = tramStopJson.getString(ConstantString2.NAME);
			String address = tramStopJson.getString(ConstantString1.ADDRESS);
			String town = tramStopJson.getString(ConstantString2.TOWN);
			String province = tramStopJson.getString(ConstantString2.PROVINCE);
			String latitude = tramStopJson.getString(ConstantString2.LATITUDE);
			String longitude = tramStopJson.getString(ConstantString2.LONGITUDE);

			TramstopRecord tramStopRecord = new TramstopRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Tramstop.TRAMSTOP).set(tramStopRecord).execute();
		}
		return ConstantInt.NUMBER_TRAM_STOP_RECORD;
	}

	public static int trainStation(DSLContext create) throws IOException {
		File jsonFile = new File(ConstantFile.JSON_TRAIN_STATION);
		JSONArray trainStationJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < trainStationJsonArray.length(); j++) {
			JSONObject trainStationJson = trainStationJsonArray.getJSONObject(j);

			String name = trainStationJson.getString(ConstantString2.NAME);
			String address = trainStationJson.getString(ConstantString1.ADDRESS);
			String town = trainStationJson.getString(ConstantString2.TOWN);
			String province = trainStationJson.getString(ConstantString2.PROVINCE);
			String latitude = trainStationJson.getString(ConstantString2.LATITUDE);
			String longitude = trainStationJson.getString(ConstantString2.LONGITUDE);

			TrainstationRecord trainStationRecord = new TrainstationRecord(name, address, town, province, latitude, longitude);
			create.insertInto(Trainstation.TRAINSTATION).set(trainStationRecord).execute();
		}
		return ConstantInt.NUMBER_TRAIN_STATION_RECORD;
	}

	public static int funicularTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(ConstantFile.JSON_FUNICULAR_TIMETABLE);
		JSONArray funicularJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < funicularJsonArray.length(); j++) {
			JSONObject funicularJson = funicularJsonArray.getJSONObject(j);

			int id = funicularJson.getInt(ConstantString1.ID);
			String companyName = funicularJson.getString(ConstantString1.COMPANY_NAME);
			String name = funicularJson.getString(ConstantString2.NAME);
			String departureFunicularStation = funicularJson.getString(ConstantString1.DEPARTURE_FUNICULAR_STATION);
			String departureTime = funicularJson.getString(ConstantString1.DEPARTURE_TIME);
			String arrivalFunicularStation = funicularJson.getString(ConstantString1.ARRIVAL_FUNICULAR_STATION);
			String arrivalTime = funicularJson.getString(ConstantString1.ARRIVAL_TIME);
			String type = funicularJson.getString(ConstantString2.TYPE);
			String numberOfSeats = funicularJson.getString(ConstantString2.NUMBER_OF_SEATS);

			FuniculartimetableRecord funicularRecord = new FuniculartimetableRecord(id, companyName, name, departureFunicularStation,
					departureTime, arrivalFunicularStation, arrivalTime, type, numberOfSeats);
			create.insertInto(Funiculartimetable.FUNICULARTIMETABLE).set(funicularRecord).execute();
		}
		return ConstantInt.NUMBER_FUNICULAR_TIMETABLE_RECORD;
	}

	public static int tramTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(ConstantFile.JSON_TRAM_TIMETABLE);
		JSONArray tramJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < tramJsonArray.length(); j++) {
			JSONObject tramJson = tramJsonArray.getJSONObject(j);

			int id = tramJson.getInt(ConstantString1.ID);
			String companyName = tramJson.getString(ConstantString1.COMPANY_NAME);
			String name = tramJson.getString(ConstantString2.NAME);
			String departureTramStation = tramJson.getString(ConstantString1.DEPARTURE_TRAM_STATION);
			String departureTime = tramJson.getString(ConstantString1.DEPARTURE_TIME);
			String arrivalTramStation = tramJson.getString(ConstantString1.ARRIVAL_TRAM_STATION);
			String arrivalTime = tramJson.getString(ConstantString1.ARRIVAL_TIME);
			String nextStop = tramJson.getString(ConstantString2.NEXT_STOP);
			String timeStop = tramJson.getString(ConstantString2.TIME_STOP);
			String type = tramJson.getString(ConstantString2.TYPE);
			String numberOfSeats = tramJson.getString(ConstantString2.NUMBER_OF_SEATS);
			String numberOfCarriages = tramJson.getString(ConstantString2.NUMBER_OF_CARRIAGES);

			TramtimetableRecord tramRecord = new TramtimetableRecord(id, companyName, name, departureTramStation, departureTime,
					arrivalTramStation, arrivalTime, nextStop, timeStop, type, numberOfSeats, numberOfCarriages);
			create.insertInto(Tramtimetable.TRAMTIMETABLE).set(tramRecord).execute();
		}
		return ConstantInt.NUMBER_TRAM_TIMETABLE_RECORD;
	}
	
	public static int trainTimetable(DSLContext create) throws IOException {
		File jsonFile = new File(ConstantFile.JSON_TRAIN_TIMETABLE);
		JSONArray trainJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < trainJsonArray.length(); j++) {
			JSONObject trainJson = trainJsonArray.getJSONObject(j);

			int id = trainJson.getInt(ConstantString1.ID);
			String companyName = trainJson.getString(ConstantString1.COMPANY_NAME);
			String name = trainJson.getString(ConstantString2.NAME);
			String departureTrainStation = trainJson.getString(ConstantString1.DEPARTURE_TRAIN_STATION);
			String departureTime = trainJson.getString(ConstantString1.DEPARTURE_TIME);
			String arrivalTrainStation = trainJson.getString(ConstantString1.ARRIVAL_TRAIN_STATION);
			String arrivalTime = trainJson.getString(ConstantString1.ARRIVAL_TIME);
			String nextStop = trainJson.getString(ConstantString2.NEXT_STOP);
			String timeStop = trainJson.getString(ConstantString2.TIME_STOP);

			TraintimetableRecord trainRecord = new TraintimetableRecord(id, companyName, name, departureTrainStation, departureTime,
					arrivalTrainStation, arrivalTime, nextStop, timeStop);
			create.insertInto(Traintimetable.TRAINTIMETABLE).set(trainRecord).execute();
		}
		return ConstantInt.NUMBER_TRAIN_TIMETABLE_RECORD;
	}
	
	public static int pullmanTimetable(DSLContext create) throws IOException{
		File jsonFile = new File(ConstantFile.JSON_PULLMAN_TIMETABLE);
		JSONArray pullmanJsonArray = Utility.fileReader(jsonFile);
		for (int j = 0; j < pullmanJsonArray.length(); j++) {
			JSONObject pullmanJson = pullmanJsonArray.getJSONObject(j);
			
			int id = pullmanJson.getInt(ConstantString1.ID);
			String companyName = pullmanJson.getString(ConstantString1.COMPANY_NAME);
			String line = pullmanJson.getString(ConstantString1.LINE);
			String departurePullmanStop = pullmanJson.getString(ConstantString1.DEPARTURE_PULLMAN_STOP);
			String departureTime = pullmanJson.getString(ConstantString1.DEPARTURE_TIME);
			String arrivalPullmanStop = pullmanJson.getString(ConstantString1.ARRIVAL_PULLMAN_STOP);
			String arrivalTime = pullmanJson.getString(ConstantString1.ARRIVAL_TIME);
			String nextStop = pullmanJson.getString(ConstantString2.NEXT_STOP);
			String timeStop = pullmanJson.getString(ConstantString2.TIME_STOP);
			String type = pullmanJson.getString(ConstantString2.TYPE);

			PullmantimetableRecord pullmanRecord = new PullmantimetableRecord(id, companyName, line, departurePullmanStop, departureTime,
					arrivalPullmanStop, arrivalTime, nextStop, timeStop, type);
			create.insertInto(Pullmantimetable.PULLMANTIMETABLE).set(pullmanRecord).execute();
		}
		return ConstantInt.NUMBER_PULLMAN_TIMETABLE_RECORD;
	}
}
