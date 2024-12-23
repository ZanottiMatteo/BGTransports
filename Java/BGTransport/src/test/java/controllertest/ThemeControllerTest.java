package controllertest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bgtransport.controller.MainController;
import bgtransport.controller.ThemeController;
import bgtransport.view.DatabaseView;
import bgtransport.view.HomeView;
import bgtransport.view.LineView;
import bgtransport.view.LoginView;
import bgtransport.view.MapView;
import bgtransport.view.UserView;

class ThemeControllerTest {

    private HomeView homeView;
    private MapView mapView;
    private UserView userView;
    private LineView lineView;
    private DatabaseView databaseView;
    private LoginView loginView;

    @BeforeEach
    void setUp() {
        // Initialize all views
        homeView = new HomeView();
        mapView = new MapView();
        userView = new UserView();
        lineView = new LineView();
        databaseView = new DatabaseView();
        loginView = new LoginView();

        // Set mock instances in MainController
        MainController.homeV = homeView;
        MainController.mapV = mapView;
        MainController.userV = userView;
        MainController.lineV = lineView;
        MainController.databaseV = databaseView;
        MainController.loginV = loginView;
    }

    @Test
    void testSetThemeHomePanel() {
        // Test with dark theme
        ThemeController.themeDark = true;
        ThemeController.setThemeHomePanel(homeView);
        assertEquals(new Color(0, 0, 0, 40), homeView.homePanel.getBackground());
        assertFalse(homeView.infoPanel.logoLabelD.isVisible());
        assertTrue(homeView.infoPanel.logoLabel.isVisible());

        // Test with light theme
        ThemeController.themeDark = false;
        ThemeController.setThemeHomePanel(homeView);
        assertEquals(new Color(0, 0, 0, 80), homeView.homePanel.getBackground());
        assertTrue(homeView.infoPanel.logoLabelD.isVisible());
        assertFalse(homeView.infoPanel.logoLabel.isVisible());
    }

    @Test
    void testSetThemeMapPanel() {
        // Test with dark theme
        ThemeController.themeDark = true;
        ThemeController.setThemeMapPanel(mapView);
        assertEquals(new Color(0, 0, 0, 40), mapView.homePanel.getBackground());

        // Test with light theme
        ThemeController.themeDark = false;
        ThemeController.setThemeMapPanel(mapView);
        assertEquals(new Color(0, 0, 0, 80), mapView.homePanel.getBackground());
    }

    @Test
    void testSetThemeUserPanel() {
        // Test with dark theme
        ThemeController.themeDark = true;
        ThemeController.setThemeUserPanel(userView);
        assertEquals(new Color(0, 0, 0, 40), userView.homePanel.getBackground());

        // Test with light theme
        ThemeController.themeDark = false;
        ThemeController.setThemeUserPanel(userView);
        assertEquals(new Color(0, 0, 0, 80), userView.homePanel.getBackground());
    }

    @Test
    void testSetThemeLinePanel() {
        // Test with dark theme
        ThemeController.themeDark = true;
        ThemeController.setThemeLinePanel(lineView);
        assertEquals(new Color(0, 0, 0, 40), lineView.homePanel.getBackground());

        // Test with light theme
        ThemeController.themeDark = false;
        ThemeController.setThemeLinePanel(lineView);
        assertEquals(new Color(0, 0, 0, 80), lineView.homePanel.getBackground());
    }

    @Test
    void testSetThemeDatabasePanel() {
        // Test with dark theme
        ThemeController.themeDark = true;
        ThemeController.setThemeDatabasePanel(databaseView);
        assertEquals(new Color(0, 0, 0, 40), databaseView.homePanel.getBackground());

        // Test with light theme
        ThemeController.themeDark = false;
        ThemeController.setThemeDatabasePanel(databaseView);
        assertEquals(new Color(0, 0, 0, 80), databaseView.homePanel.getBackground());
    }

    @Test
    void testSetThemeLoginPanel() {
        // Test with dark theme
        ThemeController.themeDark = true;
        ThemeController.setThemeLoginPanel(loginView);
        assertFalse(loginView.logoLabelD.isVisible());
        assertTrue(loginView.logoLabel.isVisible());

        // Test with light theme
        ThemeController.themeDark = false;
        ThemeController.setThemeLoginPanel(loginView);
        assertTrue(loginView.logoLabelD.isVisible());
        assertFalse(loginView.logoLabel.isVisible());
    }

    @Test
    void testUpdateThemes() {
        // Start with dark theme
        ThemeController.themeDark = true;

        // Call updateThemes to toggle the theme
        ThemeController.updateThemes();
        assertFalse(ThemeController.themeDark, "Theme should be toggled to light");

        // Verify UI updates for each view
        assertEquals(new Color(0, 0, 0, 80), homeView.homePanel.getBackground());
        assertEquals(new Color(0, 0, 0, 80), mapView.homePanel.getBackground());
        assertTrue(loginView.logoLabelD.isVisible());
        assertFalse(loginView.logoLabel.isVisible());

        // Call updateThemes to toggle back to dark theme
        ThemeController.updateThemes();
        assertTrue(ThemeController.themeDark, "Theme should be toggled back to dark");

        // Verify UI updates for each view
        assertEquals(new Color(0, 0, 0, 40), homeView.homePanel.getBackground());
        assertEquals(new Color(0, 0, 0, 40), mapView.homePanel.getBackground());
        assertFalse(loginView.logoLabelD.isVisible());
        assertTrue(loginView.logoLabel.isVisible());
    }
}
