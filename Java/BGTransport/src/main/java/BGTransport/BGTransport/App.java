package BGTransport.BGTransport;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SwingUtilities;

import controller.ResizeController;
import controller.ThemeController;
import view.SignUpWindow;
import view.HomeView;
import view.MainView;


public class App {
    public static void main(String[] args) {
        System.out.println("BGTransport!");
        MainView mainV = new MainView(); 
        HomeView homeV = new HomeView(); 
        SwingUtilities.invokeLater(() -> {mainV.setVisible(true); });
        mainV.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
               ResizeController.resizeComponents(mainV.originalPanelSize, mainV, mainV.componentBounds, mainV.mainPanel);
               ResizeController.resizeImage(mainV, mainV.lblBGwallpaper, mainV.mainPanel);            
            }
        });
        SwingUtilities.invokeLater(() -> {homeV.setVisible(true); });
        homeV.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
               ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.componentBounds, homeV.mainPanel);
               ResizeController.resizeImage(homeV, homeV.lblBGwallpaper, homeV.mainPanel);
            }
        });
    }
}
