package bgtransport.controller;

import bgtransport.view.TimeWidget;
import bgtransport.view.VeryBigLabel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;



class TimestampControllerTest {

    @BeforeEach
    void setUp() {
        // Inizializza le JLabel di TimeWidget
        TimeWidget.lbltime = new VeryBigLabel();
        TimeWidget.lbldate = new JLabel();
    }

    @Test
    void testGetTime() throws Exception {
        // Avvia il metodo getTime
        TimestampController.getTime();

        // Aspetta che il thread aggiorni lbltime
        Thread.sleep(2000); // Attendi abbastanza tempo per almeno un aggiornamento

        // Recupera l'ora corrente formattata
        String expectedTime = new SimpleDateFormat("HH:mm").format(System.currentTimeMillis());

        // Recupera il valore aggiornato di lbltime
        String actualTime = TimeWidget.lbltime.getText();

        // Verifica che lbltime non sia vuoto
        assertNotNull(actualTime, "lbltime dovrebbe essere aggiornato con un valore non nullo.");

        // Verifica che l'ora mostrata nell'etichetta sia corretta
        assertEquals(expectedTime, actualTime, "lbltime non mostra l'ora corretta.");
    }

    @Test
    void testGetDate() throws Exception {
        // Avvia il metodo getDate
        TimestampController.getDate();

        // Aspetta che il thread aggiorni lbldate
        Thread.sleep(2000); // Attendi abbastanza tempo per almeno un aggiornamento

        // Recupera la data corrente formattata
        String expectedDate = new SimpleDateFormat("dd MMMM yyyy", Locale.ITALIAN).format(System.currentTimeMillis());

        // Recupera il valore aggiornato di lbldate
        String actualDate = TimeWidget.lbldate.getText();

        // Verifica che lbldate non sia vuoto
        assertNotNull(actualDate, "lbldate dovrebbe essere aggiornato con un valore non nullo.");

        // Verifica che la data mostrata nell'etichetta sia corretta
        assertEquals(expectedDate, actualDate, "lbldate non mostra la data corretta.");
    }
}

