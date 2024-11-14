package BGTransport.BGTransport;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SwingUtilities;

import controller.ResizeController;
import view.LogInWindow;
import view.MainView;


public class App {
    public static void main(String[] args) {
        System.out.println("BGTransport!");
        MainView mainV = new MainView(); 
        SwingUtilities.invokeLater(() -> {mainV.setVisible(true); });
        mainV.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
               ResizeController.resizeComponents(mainV.originalPanelSize, mainV, mainV.componentBounds, mainV.mainPanel);
            }
        });
    }
}
