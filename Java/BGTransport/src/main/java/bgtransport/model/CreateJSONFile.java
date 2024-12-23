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

/**
 * The CreateJSONFile class provides methods to read data from Excel files
 * and convert them into JSON format, as well as write the JSON data to a file.
 * 
 * It supports reading Excel files with specific columns, extracting the data, 
 * and storing it in a JSON format, which can be useful for data export or processing.
 */
public class CreateJSONFile {

    /**
     * Reads data from an Excel file and converts it into a list of maps, where each map
     * represents a row in the Excel file with column headers as keys.
     *
     * @param filePath The path of the Excel file to be read.
     * @return A list of maps containing the data from the Excel file.
     * @throws Exception If an error occurs while reading the file or processing its contents.
     */
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

    /**
     * Retrieves the value from a cell, ensuring correct formatting for various types of cell content.
     * 
     * @param cell The Excel cell to retrieve the value from.
     * @param columnName The name of the column (used to handle specific column formatting, such as lat/lon).
     * @return A string representation of the cell's value.
     */
    public static String getCellValue(Cell cell, String columnName) {
        if (cell == null) {
            return "";
        }

        // Handle lat/lon columns as numeric or string values
        if (columnName.equalsIgnoreCase("lat") || columnName.equalsIgnoreCase("lon")) {
            if (cell.getCellType() == CellType.NUMERIC) {
                return String.valueOf(cell.getNumericCellValue());
            } else if (cell.getCellType() == CellType.STRING) {
                return cell.getStringCellValue();
            }
        }

        // Handle time in numeric format (dates)
        if (cell.getCellType() == CellType.NUMERIC) {
            double numericValue = cell.getNumericCellValue();
            
            if (numericValue >= 0 && numericValue < 1) {
                Date time = cell.getDateCellValue();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                return sdf.format(time);
            }
        }

        // Handle numeric values (integers or long values)
        if (cell.getCellType() == CellType.NUMERIC) {
            double numericValue = cell.getNumericCellValue();
            if (numericValue == Math.floor(numericValue)) {
                return String.valueOf((int) numericValue);
            } else {
                return String.valueOf((long) numericValue);
            }
        } else if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == CellType.FORMULA) {
            CellValue cellValue = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator()
                    .evaluate(cell);
            switch (cellValue.getCellType()) {
            case NUMERIC:
                double formulaNumericValue = cellValue.getNumberValue();
                if (formulaNumericValue == Math.floor(formulaNumericValue)) {
                    return String.valueOf((int) formulaNumericValue);
                } else {
                    return String.valueOf(formulaNumericValue);
                }
            case STRING:
                return cellValue.getStringValue();
            case BOOLEAN:
                return String.valueOf(cellValue.getBooleanValue());
            default:
                return "";
            }
        }

        return "";
    }

    /**
     * Writes a list of maps to a JSON file. Each map represents a row of data, and the keys are the column names.
     *
     * @param data The data to be written to the file, represented as a list of maps.
     * @param filePath The path to the output JSON file.
     * @throws IOException If an error occurs while writing the JSON data to the file.
     */
    public static void writeJsonToFile(List<Map<String, String>> data, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
    }
}
