package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateJSONFile {
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
	    for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Usa getLastRowNum per evitare problemi con righe vuote in fondo
	        Row row = sheet.getRow(i);

	        // Se la riga è nulla, salta questa iterazione
	        if (row == null) {
	            continue;
	        }

	        Map<String, String> rowData = new LinkedHashMap<>(); // Utilizziamo LinkedHashMap per preservare l'ordine
	        boolean hasNonEmptyValue = false; // Controllo se la riga ha almeno un valore non vuoto

	        // Assegna i valori delle celle alle rispettive intestazioni mantenendo l'ordine
	        for (int j = 0; j < headers.size(); j++) {
	            String columnName = headers.get(j); // Ottieni il nome della colonna
	            Cell cell = (row.getCell(j) != null) ? row.getCell(j) : null;
	            
	            // Passa il nome della colonna alla funzione getCellValue
	            String cellValue = (cell != null) ? getCellValue(cell, columnName) : ""; 
	            rowData.put(columnName, cellValue);

	            // Verifica se almeno una cella della riga contiene un valore non vuoto
	            if (!cellValue.isEmpty()) {
	                hasNonEmptyValue = true;
	            }
	        }

	        // Aggiungi la riga alla lista solo se ha almeno un valore non vuoto
	        if (hasNonEmptyValue) {
	            dataList.add(rowData);
	        }
	    }

	    workbook.close();
	    file.close();

	    return dataList;
	}

	// Funzione che ottiene il valore di una cella e lo converte correttamente
	public static String getCellValue(Cell cell, String columnName) {
	    if (cell == null) {
	        return ""; // Se la cella è vuota, restituiamo una stringa vuota
	    }

	    // Se la colonna è 'lat' o 'lon', trattiamo il valore come un numero decimale
	    if (columnName.equalsIgnoreCase("lat") || columnName.equalsIgnoreCase("lon")) {
	        if (cell.getCellType() == CellType.NUMERIC) {
	            // Se la cella è numerica, la trattiamo come un numero decimale
	            return String.valueOf(cell.getNumericCellValue()); // Manteniamo il valore come decimale
	        } else if (cell.getCellType() == CellType.STRING) {
	            return cell.getStringCellValue(); // Restituiamo la stringa se è già una stringa
	        }
	    }

	    // Se la cella contiene un orario (time), lo trattiamo come tale
	    if (cell.getCellType() == CellType.NUMERIC) {
	        double numericValue = cell.getNumericCellValue();
	        
	        // Se il numero è una frazione di giorno (indica un orario)
	        if (numericValue >= 0 && numericValue < 1) {
	            Date time = cell.getDateCellValue();
	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // Modifica il formato dell'orario
	            return sdf.format(time); // Restituiamo l'orario formattato come stringa
	        }
	    }

	    // Gestione delle celle con valore numerico per altre colonne (id e altre)
	    if (cell.getCellType() == CellType.NUMERIC) {
	        double numericValue = cell.getNumericCellValue();
	        
	        // Se il numero è intero (es. 1.0 deve diventare 1), restituiamo come intero
	        if (numericValue == Math.floor(numericValue)) {
	            return String.valueOf((int) numericValue); // Convertiamo in intero, senza decimali
	        } else {
	            // Altrimenti restituiamo il numero come stringa
	            return String.valueOf((long) numericValue); // Se è decimale, lo trattiamo come numero intero
	        }
	    } else if (cell.getCellType() == CellType.STRING) {
	        return cell.getStringCellValue(); // Restituiamo la stringa direttamente se è già una stringa
	    } else if (cell.getCellType() == CellType.BOOLEAN) {
	        return String.valueOf(cell.getBooleanCellValue()); // Restituiamo il valore booleano come stringa
	    } else if (cell.getCellType() == CellType.FORMULA) {
	        // Calcoliamo il valore della formula
	        CellValue cellValue = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator()
	                .evaluate(cell);
	        switch (cellValue.getCellType()) {
	        case NUMERIC:
	            double formulaNumericValue = cellValue.getNumberValue();
	            if (formulaNumericValue == Math.floor(formulaNumericValue)) {
	                return String.valueOf((int) formulaNumericValue); // Intero senza decimali
	            } else {
	                return String.valueOf(formulaNumericValue); // Decimale se non intero
	            }
	        case STRING:
	            return cellValue.getStringValue(); // Restituisce la stringa
	        case BOOLEAN:
	            return String.valueOf(cellValue.getBooleanValue()); // Restituisce il valore booleano come stringa
	        default:
	            return ""; // Nel caso in cui il tipo di risultato non è previsto
	        }
	    }

	    return ""; // Se la cella contiene un tipo non gestito, restituiamo una stringa vuota
	}

	// Funzione che scrive i dati in formato JSON nel file
	public static void writeJsonToFile(List<Map<String, String>> data, String filePath) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		// Scrive il JSON nel file
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
	}
}
