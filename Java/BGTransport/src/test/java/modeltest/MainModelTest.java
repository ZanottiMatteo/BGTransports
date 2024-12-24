package modeltest;

import org.junit.jupiter.api.Test;

import bgtransport.model.ConstantDB;
import bgtransport.model.ConstantFile;
import bgtransport.model.MainModel;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MainModel.
 */
class MainModelTest {

    @Test
    void testMainMethodExecution() throws Exception {
        // Run the main method
        MainModel.main(new String[]{});

        // Assert that the ControlDB methods were triggered (this assumes 
        // the methods generate or interact with files/databases)
        
        // Verify that the expected files exist after the method runs (without modifying original files)
        assertTrue(new File(ConstantFile.EXCEL_FUNICULAR_STATION).exists(), 
                "Excel file for Funicular Station should exist.");
        assertTrue(new File(ConstantFile.EXCEL_COMPANY).exists(), 
                "Excel file for Company should exist.");
        assertTrue(new File(ConstantFile.EXCEL_PULLMAN_STOP).exists(), 
                "Excel file for Pullman Stop should exist.");
        assertTrue(new File(ConstantFile.EXCEL_TRAIN_STATION).exists(), 
                "Excel file for Train Station should exist.");
        assertTrue(new File(ConstantFile.EXCEL_TRAM_STOP).exists(), 
                "Excel file for Tram Stop should exist.");
    }
}
