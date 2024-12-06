package model;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class MyLighterLaf extends FlatLightLaf {
    public static boolean setup() {
        // Load the custom properties file
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

    @Override
    public String getName() {
        return "MyLighterLaf";
    }
}