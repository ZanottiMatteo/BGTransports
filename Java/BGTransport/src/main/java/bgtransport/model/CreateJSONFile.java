package bgtransport.model;

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
	
	public static List<Map<String, String>> readExcelFile(String filePath) throws Exception {
	    List<Map<String, String>> dataList = new ArrayList<>();
	    FileInputStream file = new FileInputStream(new File(filePath));

	    Workbook workbook = new XSSFWorkbook(file);
	    Sheet sheet = workbook.getSheetAt(0);

	    Row headerRow = sheet.getRow(0);
	    List<String> headers = new ArrayList<>();
	    if (headerRow != null) {
	        for (Cell cell : headerRow) {
	            headers.add(cell.getStringCellValue());
	        }
	    }

	    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	        Row row = sheet.getRow(i);

	        if (row == null) {
	            continue;
	        }

	        Map<String, String> rowData = new LinkedHashMap<>();
	        boolean hasNonEmptyValue = false;

	        for (int j = 0; j < headers.size(); j++) {
	            String columnName = headers.get(j);
	            Cell cell = (row.getCell(j) != null) ? row.getCell(j) : null;
	            
	            String cellValue = (cell != null) ? getCellValue(cell, columnName) : ""; 
	            rowData.put(columnName, cellValue);

	            if (!cellValue.isEmpty()) {
	                hasNonEmptyValue = true;
	            }
	        }

	        if (hasNonEmptyValue) {
	            dataList.add(rowData);
	        }
	    }

	    workbook.close();
	    file.close();

	    return dataList;
	}

	public static String getCellValue(Cell cell, String columnName) {
	    if (cell == null) {
	        return "";
	    }

	    if (columnName.equalsIgnoreCase("lat") || columnName.equalsIgnoreCase("lon")) {
	        if (cell.getCellType() == CellType.NUMERIC) {
	            return String.valueOf(cell.getNumericCellValue());
	        } else if (cell.getCellType() == CellType.STRING) {
	            return cell.getStringCellValue();
	        }
	    }

	    if (cell.getCellType() == CellType.NUMERIC) {
	        double numericValue = cell.getNumericCellValue();
	        
	        if (numericValue >= 0 && numericValue < 1) {
	            Date time = cell.getDateCellValue();
	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	            return sdf.format(time);
	        }
	    }

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
