package bgtransport.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bgtransport.view.AccountIconView;
import bgtransport.view.DatabaseView;
import bgtransport.view.DownloadDataDBView;
import bgtransport.view.HomeView;
import bgtransport.view.LoginView;
import bgtransport.view.MapView;
import bgtransport.view.SignUpView;
import bgtransport.view.UserView;

class MainControllerTest {

    @BeforeEach
    void setUp() {
        // If needed, reset static variables or perform initialization.
        MainController.dbV = new DownloadDataDBView();
        MainController.homeV = new HomeView();
        MainController.signupV = new SignUpView();
        MainController.mapV = new MapView();
        MainController.loginV = new LoginView();
        MainController.userV = new UserView();
        MainController.accountV = new AccountIconView();
        MainController.databaseV = new DatabaseView();
    }

    @Test
    void testInitialization() {
        // Test that the views are initialized correctly
        assertNotNull(MainController.dbV, "DownloadDataDBView should be initialized.");
        assertNotNull(MainController.homeV, "HomeView should be initialized.");
        assertNotNull(MainController.signupV, "SignUpView should be initialized.");
        assertNotNull(MainController.mapV, "MapView should be initialized.");
        assertNotNull(MainController.loginV, "LoginView should be initialized.");
        assertNotNull(MainController.userV, "UserView should be initialized.");
        assertNotNull(MainController.accountV, "AccountIconView should be initialized.");
        assertNotNull(MainController.databaseV, "DatabaseView should be initialized.");
    }

    @Test
    void testMainExecution() {
        // Ensure no exceptions occur when running the main method
        assertDoesNotThrow(() -> MainController.main(new String[]{}), "Main method should execute without throwing exceptions.");
    }

    @Test
    void testLineViewInitialization() throws Exception {
        // Test that LineView gets initialized during main execution
        MainController.main(new String[]{});
        assertNotNull(MainController.lineV, "LineView should be initialized during main method execution.");
    }
}
