package BGTransport.BGTransport;

import javax.swing.SwingUtilities;

import view.MainView;


public class App {
    public static void main(String[] args) {
        System.out.println("BGTransport!");
        SwingUtilities.invokeLater(() -> {new MainView().setVisible(true); });
    }
}
