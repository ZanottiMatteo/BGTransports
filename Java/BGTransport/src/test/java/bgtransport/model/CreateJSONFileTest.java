package bgtransport.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CreateJSONFileTest {
    private static final String JSON_FILE_PATH = "src/test/resources/output.json";

    @Test
    void testReadExcelFile() throws Exception {
        List<Map<String, String>> data = CreateJSONFile.readExcelFile(ConstantFile.EXCEL_COMPANY);
        assertNotNull(data, "La lettura del file Excel ha restituito null!");
        assertFalse(data.isEmpty(), "I dati letti dal file Excel sono vuoti!");
        Map<String, String> firstRow = data.get(0);
        assertTrue(firstRow.containsKey("name"), "La colonna 'name' non è presente nella prima riga");
    }

    @Test
    void testWriteJsonToFile() throws Exception {
        List<Map<String, String>> data = CreateJSONFile.readExcelFile(ConstantFile.EXCEL_COMPANY);
        CreateJSONFile.writeJsonToFile(data, JSON_FILE_PATH);
        File jsonFile = new File(JSON_FILE_PATH);
        assertTrue(jsonFile.exists(), "Il file JSON non è stato creato!");
    }
}