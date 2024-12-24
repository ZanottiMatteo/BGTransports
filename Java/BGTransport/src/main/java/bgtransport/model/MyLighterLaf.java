package bgtransport.model;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * A custom Look and Feel class that extends the FlatLightLaf provided by FlatLaf library.
 * This class is designed to initialize and apply a "lighter" theme for the user interface.
 * It is useful for setting up a custom theme for Java Swing applications.
 */
public class MyLighterLaf extends FlatLightLaf {
    private static final long serialVersionUID = 8352985710899805956L;

    /**
     * Initializes the custom Look and Feel (MyLighterLaf) and applies it to the application.
     * This method is typically called at the beginning of the application to set up the theme.
     *
     * @return boolean true if the Look and Feel is successfully set up, false otherwise.
     */
    public static boolean setup() {
        try {
            System.out.println("Initializing MyLighterLaf...");
            FlatLaf.setup(new MyLighterLaf());
            return true;
        } catch (Exception ex) {
            System.err.println("Failed to initialize MyLighterLaf");
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Gets the name of the custom Look and Feel.
     * This is used to identify the Look and Feel in the Swing application.
     *
     * @return the name of the Look and Feel as a string, which is "MyLighterLaf".
     */
    @Override
    public String getName() {
        return "MyLighterLaf";
    }
}
