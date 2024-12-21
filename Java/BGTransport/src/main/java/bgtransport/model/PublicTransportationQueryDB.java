package bgtransport.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Record5;
import org.jooq.Record6;
import org.jooq.Record7;
import org.jooq.Result;
import org.jxmapviewer.viewer.GeoPosition;

import transportation.jooq.generated.tables.Company;
import transportation.jooq.generated.tables.Funicularstation;
import transportation.jooq.generated.tables.Funiculartimetable;
import transportation.jooq.generated.tables.Pullmanstop;
import transportation.jooq.generated.tables.Pullmantimetable;
import transportation.jooq.generated.tables.Trainstation;
import transportation.jooq.generated.tables.Traintimetable;
import transportation.jooq.generated.tables.Tramstop;
import transportation.jooq.generated.tables.Tramtimetable;

public class PublicTransportationQueryDB {
	public static List<List<String>> getInfo(String departure) throws SQLException {
	    DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);

	    Result<Record7<String, String, String, String, String, String, String>> data = create
	            .select(Pullmantimetable.PULLMANTIMETABLE.LINE,
	                    Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME, 
	                    Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP, 
	                    Pullmantimetable.PULLMANTIMETABLE.TIMESTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.TYPE)
	            .from(Pullmantimetable.PULLMANTIMETABLE)
	            .where(Pullmantimetable.PULLMANTIMETABLE.DEPARTUREPULLMANSTOP.eq(departure))
	            .fetch();

	    List<List<String>> allInfo = new ArrayList<>();
	    for (Record7<String, String, String, String, String, String, String> list : data) {
	        List<String> info = new ArrayList<>();
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.LINE));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.TIMESTOP));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.TYPE));
	        allInfo.add(info);
	    }
	    return allInfo;
	}
	
	public static List<List<String>> getInfo1(String departuretime, String departure) throws SQLException {
	    DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);

	    Result<Record6<String, String, String, String, String, String>> data = create
	            .select(Pullmantimetable.PULLMANTIMETABLE.LINE,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME, 
	                    Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP, 
	                    Pullmantimetable.PULLMANTIMETABLE.TIMESTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.TYPE)
	            .from(Pullmantimetable.PULLMANTIMETABLE)
	            .where(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME.eq(departuretime)).and(Pullmantimetable.PULLMANTIMETABLE.DEPARTUREPULLMANSTOP.eq(departure))
	            .fetch();

	    List<List<String>> allInfo = new ArrayList<>();
	    for (Record6<String, String, String, String, String, String> list : data) {
	        List<String> info = new ArrayList<>();
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.LINE));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.TIMESTOP));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.TYPE));
	        allInfo.add(info);
	    }
	    return allInfo;
	}
	
	public static List<List<String>> getInfo2(String arrival, String departuretime, String departure) throws SQLException{
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		
		Result<Record5<String, String, String, String, String >> data = create
	            .select(Pullmantimetable.PULLMANTIMETABLE.LINE,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME, 
	                    Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP, 
	                    Pullmantimetable.PULLMANTIMETABLE.TIMESTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.TYPE)
	            .from(Pullmantimetable.PULLMANTIMETABLE)
	            .where(Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP.eq(arrival)).and(Pullmantimetable.PULLMANTIMETABLE.DEPARTUREPULLMANSTOP.eq(departure)).and(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME.eq(departuretime))
	            .fetch();
		
		List<List<String>> allInfo = new ArrayList<>();
	    for (Record5<String, String, String, String, String> list : data) {
	        List<String> info = new ArrayList<>();
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.LINE));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.TIMESTOP));
	        info.add(list.get(Pullmantimetable.PULLMANTIMETABLE.TYPE));
	        allInfo.add(info);
	    }
	    return allInfo;
	}

	public static void deleteAll(DSLContext create, List<String> myList) throws IOException {
		ArrayList<String> modifiedList = new ArrayList<>();

		for (String item : myList) {
			String modified = item.replace("json/", "").replace(".json", "");
			modifiedList.add(modified);
		}

		for (String tableName : modifiedList) {
			if (tableName.equals(ConstantString1.COMPANY)) {
				create.deleteFrom(Company.COMPANY).execute();
				InsertDataDB.company(create);
			}
			if (tableName.equals(ConstantString1.FUNICULAR_STATION)) {
				create.deleteFrom(Funicularstation.FUNICULARSTATION).execute();
				InsertDataDB.funicularStation(create);
			}
			if (tableName.equals(ConstantString2.TRAIN_STATION)) {
				create.deleteFrom(Trainstation.TRAINSTATION).execute();
				InsertDataDB.trainStation(create);
			}
			if (tableName.equals(ConstantString2.TRAM_STOP)) {
				create.deleteFrom(Tramstop.TRAMSTOP).execute();
				InsertDataDB.tramStop(create);
			}
			if (tableName.equals(ConstantString2.PULLMAN_STOP)) {
				create.deleteFrom(Pullmanstop.PULLMANSTOP).execute();
				InsertDataDB.pullmanStop(create);
			}
			if (tableName.equals(ConstantString1.FUNICULAR_TIMETABLE)) {
				create.deleteFrom(Funiculartimetable.FUNICULARTIMETABLE).execute();
				InsertDataDB.funicularTimetable(create);
			}
			if (tableName.equals(ConstantString2.TRAM_TIMETABLE)) {
				create.deleteFrom(Tramtimetable.TRAMTIMETABLE).execute();
				InsertDataDB.tramTimetable(create);
			}
			if (tableName.equals(ConstantString2.TRAIN_TIMETABLE)) {
				create.deleteFrom(Traintimetable.TRAINTIMETABLE).execute();
				InsertDataDB.trainTimetable(create);
			}
			if (tableName.equals(ConstantString2.PULLMAN_TIMETABLE)) {
				create.deleteFrom(Pullmantimetable.PULLMANTIMETABLE).execute();
				InsertDataDB.pullmanTimetable(create);
			}
		}
		System.out.println("Data updated");
	}
	
	public static List<String> getLatFunicularStation() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> latitude = new ArrayList<String>();

		@NotNull
		Result<Record1<String>> result = create.select(Funicularstation.FUNICULARSTATION.LAT)
				.from(Funicularstation.FUNICULARSTATION).fetch();

		for (Record1<String> funicularStationLat : result) {
			String lat = funicularStationLat.value1();
			latitude.add(lat);
		}
		return latitude;
	}

	public static List<String> getLonFunicularStation() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> longitude = new ArrayList<String>();

		@NotNull
		Result<Record1<String>> result = create.select(Funicularstation.FUNICULARSTATION.LON)
				.from(Funicularstation.FUNICULARSTATION).fetch();

		for (Record1<String> funicularStationLon : result) {
			String lon = funicularStationLon.value1();
			longitude.add(lon);
		}
		return longitude;
	}

	public static List<GeoPosition> getFunicularGeopositions() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<GeoPosition> geopositions = new ArrayList<>();

		@NotNull
		Result<Record2<String, String>> result = create
				.select(Funicularstation.FUNICULARSTATION.LAT, Funicularstation.FUNICULARSTATION.LON)
				.from(Funicularstation.FUNICULARSTATION).fetch();

		for (Record2<String, String> funicularStationLatLon : result) {
			double lat = Double.parseDouble(funicularStationLatLon.value1());
			double lon = Double.parseDouble(funicularStationLatLon.value2());
			System.out.println("Lat: " + lat + "Long" + lon);
			geopositions.add(new GeoPosition(lat, lon));
		}

		return geopositions;
	}

	public static List<GeoPosition> getPullmanGeopositions() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<GeoPosition> geopositions = new ArrayList<>();

		@NotNull
		Result<Record2<String, String>> result = create.select(Pullmanstop.PULLMANSTOP.LAT, Pullmanstop.PULLMANSTOP.LON)
				.from(Pullmanstop.PULLMANSTOP).fetch();

		for (Record2<String, String> pullmanStopLatLon : result) {
			double lat = Double.parseDouble(pullmanStopLatLon.value1());
			double lon = Double.parseDouble(pullmanStopLatLon.value2());
			GeoPosition geoPosition = new GeoPosition(lat, lon);
			geopositions.add(geoPosition);
		}

		return geopositions;
	}

	public static List<GeoPosition> getTrainGeopositions() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<GeoPosition> geopositions = new ArrayList<>();

		@NotNull
		Result<Record2<String, String>> result = create
				.select(Trainstation.TRAINSTATION.LAT, Trainstation.TRAINSTATION.LON).from(Trainstation.TRAINSTATION)
				.fetch();

		for (Record2<String, String> trainStationLatLon : result) {
			double lat = Double.parseDouble(trainStationLatLon.value1());
			double lon = Double.parseDouble(trainStationLatLon.value2());
			GeoPosition geoPosition = new GeoPosition(lat, lon);
			geopositions.add(geoPosition);
		}

		return geopositions;
	}

	public static List<GeoPosition> getTramGeopositions() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<GeoPosition> geopositions = new ArrayList<>();

		@NotNull
		Result<Record2<String, String>> result = create.select(Tramstop.TRAMSTOP.LAT, Tramstop.TRAMSTOP.LON)
				.from(Tramstop.TRAMSTOP).fetch();

		for (Record2<String, String> tramStopLatLon : result) {
			double lat = Double.parseDouble(tramStopLatLon.value1());
			double lon = Double.parseDouble(tramStopLatLon.value2());
			GeoPosition geoPosition = new GeoPosition(lat, lon);
			geopositions.add(geoPosition);
		}

		return geopositions;
	}

	public static List<String> getNameStation() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> geopositions = new ArrayList<>();

		@NotNull
		Result<Record1<String>> result = create.select(Pullmanstop.PULLMANSTOP.NAME).from(Pullmanstop.PULLMANSTOP)
				.fetch();

		for (Record1<String> nameStation : result) {
			geopositions.add(nameStation.value1());
		}

		return geopositions;
	}
	
	public static List<String> getLineList() throws SQLException{
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> geopositions = new ArrayList<>();
		
		@NotNull
		Result<Record1<String>> result = create.selectDistinct(Pullmantimetable.PULLMANTIMETABLE.LINE).from(Pullmantimetable.PULLMANTIMETABLE)
				.fetch();

		for (Record1<String> line : result) {
			geopositions.add(line.value1());
		}
		
		return geopositions;
	}
	
	public static List<String> getTimeList() throws SQLException{
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> geopositions = new ArrayList<>();
		
		@NotNull
		Result<Record1<String>> result = create.selectDistinct(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME).from(Pullmantimetable.PULLMANTIMETABLE).orderBy(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME)
				.fetch();

		for (Record1<String> time : result) {
			geopositions.add(time.value1());
		}
		return geopositions;
	}
	
	public static List<String> getWeekList() throws SQLException{
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> geopositions = new ArrayList<>();
		
		@NotNull
		Result<Record1<String>> result = create.selectDistinct(Pullmantimetable.PULLMANTIMETABLE.TYPE).from(Pullmantimetable.PULLMANTIMETABLE)
				.fetch();

		for (Record1<String> weekDay : result) {
			geopositions.add(weekDay.value1());
		}
		return geopositions;
	}
}
