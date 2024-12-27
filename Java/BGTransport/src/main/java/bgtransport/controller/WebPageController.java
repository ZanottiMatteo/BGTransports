package bgtransport.controller;

import java.awt.Desktop;
import java.net.URI;

public class WebPageController {
	
	public static void openWebPage(String url) {
        try {
            // Verifica se il sistema supporta l'operazione di apertura nel browser
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                URI uri = new URI(url);
                desktop.browse(uri);
            } else {
                System.out.println("Il sistema non supporta l'operazione di apertura nel browser.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
