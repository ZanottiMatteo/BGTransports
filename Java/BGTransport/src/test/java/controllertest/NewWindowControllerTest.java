package controllertest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;

import javax.swing.*;

import bgtransport.view.AccountIconView;
import bgtransport.view.DatabaseView;
import bgtransport.view.DownloadDataDBView;
import bgtransport.view.HomeView;
import bgtransport.view.LineView;
import bgtransport.view.LoginView;
import bgtransport.view.MapView;
import bgtransport.view.SignUpView;
import bgtransport.view.UserView;
import bgtransport.controller.NewWindowController;

public class NewWindowControllerTest {

     HomeView homeView;
     MapView mapView;
     UserView userView;
     LoginView loginView;
     LineView lineView;
     DatabaseView databaseView;
     SignUpView signUpView;
     DownloadDataDBView dbView;
     AccountIconView accountIconView;

    @BeforeEach
    public void setUp() {
        // Inizializzare le viste reali
        homeView = new HomeView();
        mapView = new MapView();
        userView = new UserView();
        loginView = new LoginView();
        lineView = new LineView();
        databaseView = new DatabaseView();
        signUpView = new SignUpView();
        dbView = new DownloadDataDBView();
        accountIconView = new AccountIconView();
    }

    @Test
    public void testSimpleHomeViewVisibility() {
        HomeView homeView = new HomeView();
        NewWindowController.openHomePanel(homeView);
        assertTrue(homeView.isVisible(), "La finestra HomeView dovrebbe essere visibile");
    }

    @Test
    public void testOpenMapPanel() {
        // Esegui il metodo di apertura della finestra
        SwingUtilities.invokeLater(() -> NewWindowController.openMapPanel(mapView));
        try { Thread.sleep(100); } catch (InterruptedException e) {} // Aspetta che la finestra venga aperta

        // Verifica se la finestra è visibile
        assertTrue(mapView.isVisible(), "La finestra MapView dovrebbe essere visibile");
    }

    @Test
    public void testOpenUserPanel() {
        // Esegui il metodo di apertura della finestra
        SwingUtilities.invokeLater(() -> NewWindowController.openUserPanel(userView));
        try { Thread.sleep(100); } catch (InterruptedException e) {} // Aspetta che la finestra venga aperta

        // Verifica se la finestra è visibile
        assertTrue(userView.isVisible(), "La finestra UserView dovrebbe essere visibile");
    }

    @Test
    public void testOpenLoginPanel() {
        // Esegui il metodo di apertura della finestra
        SwingUtilities.invokeLater(() -> NewWindowController.openLoginPanel(loginView));
        try { Thread.sleep(100); } catch (InterruptedException e) {} // Aspetta che la finestra venga aperta

        // Verifica se la finestra è visibile
        assertTrue(loginView.isVisible(), "La finestra LoginView dovrebbe essere visibile");
    }

    @Test
    public void testOpenLinePanel() {
        // Esegui il metodo di apertura della finestra
        SwingUtilities.invokeLater(() -> NewWindowController.openLinePanel(lineView));
        try { Thread.sleep(100); } catch (InterruptedException e) {} // Aspetta che la finestra venga aperta

        // Verifica se la finestra è visibile
        assertTrue(lineView.isVisible(), "La finestra LineView dovrebbe essere visibile");
    }

    @Test
    public void testOpenDatabasePanel() {
        // Esegui il metodo di apertura della finestra
        SwingUtilities.invokeLater(() -> NewWindowController.openDatabasePanel(databaseView));
        try { Thread.sleep(100); } catch (InterruptedException e) {} // Aspetta che la finestra venga aperta

        // Verifica se la finestra è visibile
        assertTrue(databaseView.isVisible(), "La finestra DatabaseView dovrebbe essere visibile");
    }

    @Test
    public void testOpenSignUp() {
        // Esegui il metodo di apertura della finestra
        SwingUtilities.invokeLater(() -> NewWindowController.openSignUp(signUpView));
        try { Thread.sleep(100); } catch (InterruptedException e) {} // Aspetta che la finestra venga aperta

        // Verifica se la finestra è visibile
        assertTrue(signUpView.isVisible(), "La finestra SignUpView dovrebbe essere visibile");
    }

    @Test
    public void testOpenDBloader() {
        // Esegui il metodo di apertura della finestra
        SwingUtilities.invokeLater(() -> NewWindowController.openDBloader(dbView));
        try { Thread.sleep(100); } catch (InterruptedException e) {} // Aspetta che la finestra venga aperta

        // Verifica se la finestra è visibile
        assertTrue(dbView.isVisible(), "La finestra DownloadDataDBView dovrebbe essere visibile");
    }

    @Test
    public void testOpenAccountIconPanel() {
        // Esegui il metodo di apertura della finestra
        SwingUtilities.invokeLater(() -> NewWindowController.openAccountIconPanel(accountIconView));
        try { Thread.sleep(100); } catch (InterruptedException e) {} // Aspetta che la finestra venga aperta

        // Verifica se la finestra è visibile
        assertTrue(accountIconView.isVisible(), "La finestra AccountIconView dovrebbe essere visibile");
    }
}
