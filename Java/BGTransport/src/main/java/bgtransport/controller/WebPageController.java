package bgtransport.controller;

import java.awt.Desktop;
import java.net.URI;

/**
 * WebPageController is a utility class that provides functionality to open a web page in the default browser.
 */
public class WebPageController {
    
    /**
     * Opens the specified URL in the system's default web browser.
     * 
     * @param url the URL of the web page to open
     * @throws Exception if an error occurs while attempting to open the web page
     */
    public static void openWebPage(String url) {
        try {
            // Check if the system supports the operation of opening a browser
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                URI uri = new URI(url);
                desktop.browse(uri);
            } else {
                System.out.println("The system does not support the operation of opening a browser.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
