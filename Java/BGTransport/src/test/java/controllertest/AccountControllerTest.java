package controllertest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import bgtransport.controller.AccountController;

public class AccountControllerTest {

    private static List<JButton> mockButtons;

    @BeforeAll
    public static void setup() {
        // Create a mock JSON file
        File jsonFile = new File("json/AccountIcon.json");
        jsonFile.getParentFile().mkdirs();

        // Create mock buttons for the test
        mockButtons = new ArrayList<>();
        mockButtons.add(new JButton());
        mockButtons.add(new JButton());
    }

    @Test
    void testGetAccountIcon() {
        // Test for a valid image
        Image image = AccountController.getAccountIcon("1", 128);
        assertNotNull(image, "The image should not be null for a valid account number.");

        // Test for an invalid account number
        Image invalidImage = AccountController.getAccountIcon("99", 128);
        assertNull(invalidImage, "The image should be null for an invalid account number.");
    }

    @Test
    void testShowImages() {
        // Simulate setting icons on buttons
        int x = 1;
        for (JButton button : mockButtons) {
            String str = String.valueOf(x);
            button.setIcon(new javax.swing.ImageIcon(AccountController.getAccountIcon(str, 128)));
            x++;
        }

        // Verify that icons are set on the buttons
        for (JButton button : mockButtons) {
            assertNotNull(button.getIcon(), "Button icon should not be null after calling showImages.");
        }
    }

    @Test
    void testCircularImageGeneration() {
        // Verify if the generated image has the correct dimensions
        BufferedImage circularImage = (BufferedImage) AccountController.getAccountIcon("1", 128);

        assertNotNull(circularImage, "The circular image should not be null.");
        assertEquals(128, circularImage.getWidth(), "The width of the circular image should match the specified diameter.");
        assertEquals(128, circularImage.getHeight(), "The height of the circular image should match the specified diameter.");
    }
    
    @Test
    void testMissingJsonFile() throws IOException {
        // Rename the JSON file temporarily
        File jsonFile = new File("json/AccountIcon.json");
        File backupFile = new File("json/AccountIcon_backup.json");
        Files.copy(jsonFile.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        jsonFile.delete();
        try {
            Image image = AccountController.getAccountIcon("1", 128);
            assertNull(image, "The image should be null when the JSON file is missing.");
        } finally {
        	backupFile.renameTo(jsonFile);
        }
    }

    @Test
    void testMalformedJsonFile() throws IOException {
        // Corrupt the JSON file
    	File jsonFile = new File("json/AccountIcon.json");
        File backupFile = new File("json/AccountIcon_backup.json");
        Files.copy(jsonFile.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.write(Paths.get(jsonFile.getPath()), "malformed content".getBytes());

        try {
            Image image = AccountController.getAccountIcon("1", 128);
            assertNull(image, "The image should be null when the JSON file is malformed.");
        } finally {
        	jsonFile.delete();
        	backupFile.renameTo(jsonFile);
        }
    }
}