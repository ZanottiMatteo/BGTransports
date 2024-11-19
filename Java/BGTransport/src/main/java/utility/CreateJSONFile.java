package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateJSONFile {

	public static void main(String[] args) {
		try {

			List<Map<String, String>> funicularStation = readExcelFile(utility.Constant.EXCEL_FUNICULAR_STATION_LIST);
			writeJsonToFile(funicularStation, utility.Constant.JSON_FUNICULAR_STATION);

			List<Map<String, String>> companies = readExcelFile(utility.Constant.EXCEL_COMPANIES_LIST);
			writeJsonToFile(companies, utility.Constant.JSON_COMPANY);

			List<Map<String, String>> pullmanStop = readExcelFile(utility.Constant.EXCEL_PULLMAN_STOP_LIST);
			writeJsonToFile(pullmanStop, utility.Constant.JSON_PULLMAN_STOP);

			List<Map<String, String>> trainStation = readExcelFile(utility.Constant.EXCEL_TRAIN_STATION_LIST);
			writeJsonToFile(trainStation, utility.Constant.JSON_TRAIN_STATION);

			List<Map<String, String>> tramStop = readExcelFile(utility.Constant.EXCEL_TRAM_STOP_LIST);
			writeJsonToFile(tramStop, utility.Constant.JSON_TRAM_STOP);

			System.out.println("Conversione completata con successo!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Funzione che legge il file Excel e restituisce i dati come lista di Map
	public static List<Map<String, String>> readExcelFile(String filePath) throws Exception {
		List<Map<String, String>> dataList = new ArrayList<>();
		FileInputStream file = new FileInputStream(new File(filePath));

		// Crea un workbook (cartella di lavoro) a partire dal file Excel
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0); // Legge il primo foglio

		// Ottiene le intestazioni (prima riga del foglio)
		Row headerRow = sheet.getRow(0);
		List<String> headers = new ArrayList<>();
		if (headerRow != null) { // Controlla se la riga delle intestazioni esiste
			for (Cell cell : headerRow) {
				headers.add(cell.getStringCellValue());
			}
		}

		// Legge tutte le righe restanti
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);

			// Se la riga è nulla, salta questa iterazione
			if (row == null) {
				continue; // Salta righe vuote
			}

			Map<String, String> rowData = new LinkedHashMap<>(); // Utilizziamo LinkedHashMap per preservare l'ordine

			// Assegna i valori delle celle alle rispettive intestazioni mantenendo l'ordine
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				String cellValue = getCellValue(row.getCell(j));
				rowData.put(headers.get(j), cellValue);
			}

			// Verifica se la riga contiene almeno un valore non vuoto
			if (rowData.values().stream().anyMatch(value -> !value.isEmpty())) {
				dataList.add(rowData); // Aggiungi la riga solo se contiene valori non vuoti
			}
		}

		workbook.close();
		file.close();

		return dataList;
	}

	// Funzione che ottiene il valore di una cella e lo converte correttamente
	public static String getCellValue(Cell cell) {
		if (cell == null) {
			return ""; // Se la cella è vuota, restituiamo una stringa vuota
		}

		switch (cell.getCellType()) {
		case NUMERIC:
			// Leggi il valore come stringa, per evitare la conversione in numeri decimali
			return String.valueOf((long) cell.getNumericCellValue()); // Usa getRawValue() per ottenere il testo
		case STRING:
			return cell.getStringCellValue(); // Restituisce la stringa
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue()); // Restituisce il valore booleano come stringa
		case FORMULA:
			return String.valueOf(cell.getCellFormula()); // Restituisce la formula come stringa
		default:
			return ""; // Se la cella contiene un tipo non gestito, restituisce una stringa vuota
		}
	}

	// Funzione che scrive i dati in formato JSON nel file
	public static void writeJsonToFile(List<Map<String, String>> data, String filePath) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		// Scrive il JSON nel file
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
	}
}
