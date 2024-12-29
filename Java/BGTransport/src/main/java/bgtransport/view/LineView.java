package bgtransport.view;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import bgtransport.controller.LineController;
import bgtransport.controller.MainController;
import bgtransport.controller.NewWindowController;
import bgtransport.controller.ThemeController;
import bgtransport.model.ConstantString2;
import bgtransport.model.ResizableImage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.io.File;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;

/**
 * The LineView class represents the main user interface of the BGTransport application.
 * It is responsible for setting up and managing various UI components such as panels,
 * labels, combo boxes, and buttons.
 */
public class LineView extends JFrame {

    private static final long serialVersionUID = -8777186420120442479L;

    // Panels and UI components
    public JPanel mainPanel = new JPanel();
    public MenuPanel menuPanel = new MenuPanel();
    public RoundedPanel homePanel = new RoundedPanel();
    public final Point mappoint = new Point(100, 50);
    public RoundedPanel centerPanel = new RoundedPanel();
    public final Point centerpanelpoint = new Point(200, 30);
    public final transient ResizableImage lblBGwallpaper = new ResizableImage(new File("src/main/resources/images/BG.png"));
    public transient Map<Component, Rectangle> componentBounds = new HashMap<>();

    // Dimensions for panels
    public final Dimension originalPanelSize = new Dimension(1920, 1080);
    public final Dimension menuPanelSize = new Dimension(100, 900);
    public final Dimension minPanelSize = new Dimension(1085, 615);
    public final Dimension linePanelSize = new Dimension(1600, 900);
    public final Dimension lineSize = new Dimension(1450, 800);
    public final Dimension centerPanelSize = new Dimension(1600, 900);

    // Labels
    private final BigLabel titlelabel = new BigLabel("Trova la tua fermata");
    private final MediumLabel departurelabel = new MediumLabel("Punto di Partenza:");
    private final MediumLabel arrivelabel = new MediumLabel("Punto di Arrivo:");
    private final MediumLabel departuretimelabel = new MediumLabel("Orario di Partenza:");
    private final MediumLabel arrivaltimelabel = new MediumLabel("Orario di Arrivo:");
    private final MediumLabel finallabel1 = new MediumLabel("");
    private final MediumLabel finallabel2 = new MediumLabel("");

    // Buttons and ComboBoxes
    public JButton selectbutton = new JButton();
    public JComboBox<String> depaturestation;
    public JComboBox<String> arrivestation;
    public JComboBox<String> arrivetime;
    public JComboBox<String> departuretime;

    // Data Lists
    public static List<String> station;
    public static List<String> timelist;
    public static List<String> allValueList = new ArrayList<>();
    public static List<List<String>> departureList;
    public static List<List<String>> timeListList;
    public static List<List<String>> arriveList;

    /**
     * Constructor for LineView.
     * Sets up the window and UI components.
     */
    public LineView() {
        configureWindow();
        setupComponentArcs();
        setupMainPanel();
        setupCenterPanel();
        setupActionListeners();
        storeComponentBounds();
    }

    /**
     * Configures the window settings (e.g., title, size, close operation).
     */
    private void configureWindow() {
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setMinimumSize(minPanelSize);
        setTitle("BGTransport");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Sets rounded corners for UI components like buttons and text fields.
     */
    private void setupComponentArcs() {
        UIManager.put("Button.arc", 999);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("Component.arc", 15);
    }

    /**
     * Configures the main panel with a background image and layout.
     */
    private void setupMainPanel() {
        mainPanel = new JPanel() {
            private static final long serialVersionUID = 65337158073054498L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);
            }
        };

        mainPanel.setBounds(0, 0, 1920, 1080);
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);
        mainPanel.add(homePanel);

        homePanel.setLayout(null);
        homePanel.setBounds(26, 40, 1854, 960);
        homePanel.add(menuPanel);

        centerPanel.setBounds(200, 30, 1600, 900);
        centerPanel.setLayout(null);
        homePanel.add(centerPanel);
        titlelabel.setForeground(new Color(210, 105, 30));
        titlelabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titlelabel.setBounds(0, 50, 1600, 60);
        
        centerPanel.add(titlelabel);
    }

	
    /**
     * Sets up the components of the center panel for the user interface, including labels, combo boxes,
     * and the confirm button. It positions and sizes each element within the center panel.
     */
    private void setupCenterPanel() {
        depaturestation = createSearchableComboBox(station);
        arrivestation = createSearchableComboBox(station);
        arrivetime = createSearchableComboBox(timelist);
        departuretime = createSearchableComboBox(timelist);

        int y = 150;
        departurelabel.setLocation(330, y);
        departurelabel.setSize(500, 50);
        centerPanel.add(departurelabel);
        depaturestation.setLocation(330, y + 70);
        depaturestation.setSize(500, 50);
        centerPanel.add(depaturestation);

        departuretimelabel.setLocation(790, y);
        departuretimelabel.setSize(500, 50);
        centerPanel.add(departuretimelabel);
        departuretime.setLocation(940, y + 70);
        departuretime.setSize(200, 50);
        centerPanel.add(departuretime);

        arrivelabel.setLocation(330, y + 140);
        arrivelabel.setSize(500, 50);        
        centerPanel.add(arrivelabel);
        arrivestation.setLocation(330, y + 210);
        arrivestation.setSize(500, 50);
        centerPanel.add(arrivestation);

        arrivaltimelabel.setLocation(790, y + 140);
        arrivaltimelabel.setSize(500, 50);
        centerPanel.add(arrivaltimelabel);
        arrivetime.setLocation(940, y + 210);
        arrivetime.setSize(200, 50);
        centerPanel.add(arrivetime);

        finallabel1.setHorizontalAlignment(SwingConstants.LEFT);
        finallabel1.setLocation(280, y + 270);
        finallabel1.setSize(600, 400);
        centerPanel.add(finallabel1);

        finallabel2.setHorizontalAlignment(SwingConstants.LEFT);
        finallabel2.setLocation(840, y + 270);
        finallabel2.setSize(600, 400);
        centerPanel.add(finallabel2);

        selectbutton.setText("Conferma");
        selectbutton.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
        selectbutton.setHorizontalAlignment(SwingConstants.CENTER);
        selectbutton.setBackground(new Color(210, 105, 30));
        selectbutton.setForeground(new Color(255, 255, 255));
        selectbutton.setLocation(650, 800);
        selectbutton.setSize(300, 70);
        selectbutton.setEnabled(false);
        centerPanel.add(selectbutton);
    }

    /**
     * Creates a searchable combo box where the user can select from a list of options. The combo box 
     * allows for typing and filtering of options based on the user's input.
     *
     * @param options List of options to be added to the combo box.
     * @return The JComboBox component with searchable capabilities.
     */
    private static JComboBox<String> createSearchableComboBox(List<String> options) {
        JComboBox<String> comboBox = new JComboBox<>();
        for (int i = 0; i < options.size(); i++) comboBox.addItem(options.get(i));
        comboBox.setEditable(true);

        JTextComponent editor = (JTextComponent) comboBox.getEditor().getEditorComponent();
        editor.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                String input = editor.getText();
                comboBox.removeAllItems();
                options.stream()
                        .filter(option -> option.toLowerCase().contains(input.toLowerCase()))
                        .forEach(comboBox::addItem);

                editor.setText(input);
                comboBox.showPopup();
            }
        });

        return comboBox;
    }

    /**
     * Sets up action listeners for the various buttons and combo boxes in the UI. These listeners handle
     * user interactions and trigger the necessary actions, such as updating combo boxes or switching views.
     */
    private void setupActionListeners() {
        menuPanel.userButton.addActionListener(e -> {
            NewWindowController.choseUserLogin(MainController.userV, MainController.loginV);
            this.setVisible(false);
        });

        menuPanel.mapButton.addActionListener(e -> {
            NewWindowController.openMapPanel(MainController.mapV);
            setVisible(false);
        });

        menuPanel.homeButton.addActionListener(e -> {
            NewWindowController.openHomePanel(MainController.homeV);
            setVisible(false);
        });

        menuPanel.databaseButton.addActionListener(e -> {
            NewWindowController.openDatabasePanel(MainController.databaseV);
            setVisible(false);
        });

        depaturestation.addActionListener(e -> {
            try {
                LineController.getComboboxSelectionStation(depaturestation);
                LineController.updateComboBoxes(departuretime, arrivestation, arrivetime, departureList);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        departuretime.addActionListener(e -> {
            try {
                LineController.getComboboxSelectionTime(departuretime);
                LineController.updateComboBoxes1(arrivestation, arrivetime, timeListList);
                selectbutton.setEnabled(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        arrivestation.addActionListener(e -> {
            try {
                LineController.getComboboxSelectionFinalStation(arrivestation);
                LineController.updateComboBoxes2(arrivetime, arriveList);
                selectbutton.setEnabled(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        selectbutton.addActionListener(e -> {
            allValueList.clear();
            LineController.getValuesOfComboBox(depaturestation, departuretime, arrivestation, arrivetime);
            try {
                LineController.selectValues();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            String result = calculateTimeDifference(allValueList.get(1), allValueList.get(3));
            System.out.println("Valori: " + allValueList);
            finallabel1.setText("<html>" +
                    "<table>" +
                    "<tr><td><b><font style='font-size:12px;'>Partenza:</font></b></td><td><font style='font-size:18px;'>" + String.join(" ", allValueList.get(0)) + "</font></td></tr>" +
                    "<tr><td><b><font style='font-size:12px;'>Orario:</font></b></td><td><font style='font-size:18px;'>" + String.join(" ", allValueList.get(1)) + "</font></td></tr>" +
                    "<tr><td><b><font style='font-size:12px;'>Arrivo:</font></b></td><td><font style='font-size:18px;'>" + String.join(" ", allValueList.get(2)) + "</font></td></tr>" +
                    "<tr><td><b><font style='font-size:12px;'>Orario:</font></b></td><td><font style='font-size:18px;'>" + String.join(" ", allValueList.get(3)) + "</font></td></tr>" +
                    "<tr><td><b><font style='font-size:12px;'>Fermata:</font></b></td><td><font style='font-size:18px;'>" + String.join(" ", allValueList.get(5)) + "</font></td></tr>" +
                    "<tr><td><b><font style='font-size:12px;'>Orario:</font></b></td><td><font style='font-size:18px;'>" + String.join(" ", allValueList.get(6)) + "</font></td></tr>" +
                    "</html>");

            finallabel2.setText("<html>" +
                    "<table>" +
                    "<tr><td><b><font style='font-size:12px;'>Linea:</font></b></td><td><font style='font-size:18px;'>" + String.join(" ", allValueList.get(4)) + "</font></td></tr>" +
                    "<tr><td><b><font style='font-size:12px;'>Periodo:</font></b></td><td><font style='font-size:18px;'>" + String.join(" ", allValueList.get(7)) + "</font></td></tr>" +
                    "<tr><td><b><font style='font-size:12px;'>Tempo necessario:</font></b></td><td><font style='font-size:18px;'>" + result + "</font></td></tr>" +
                    "</table>" +
                    "</html>");
        });

        menuPanel.switchThemeButton.addActionListener(e -> ThemeController.toggleThemes());
    }

    /**
     * Stores the bounds (position and size) of all components in the main panel, menu panel, and center panel.
     * This is useful for restoring the component layout when the window is resized.
     */
    private void storeComponentBounds() {
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        for (Component comp : menuPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        for (Component comp : centerPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }

    /**
     * Calculates the time difference between the departure and arrival times.
     * 
     * @param departureTimeStr The departure time as a string in HH:mm format.
     * @param arrivalTimeStr The arrival time as a string in HH:mm format.
     * @return A string representing the time difference in hours and minutes.
     */
    public static String calculateTimeDifference(String departureTimeStr, String arrivalTimeStr) {
        LocalTime departureTime = LocalTime.parse(departureTimeStr);
        LocalTime arrivalTime = LocalTime.parse(arrivalTimeStr);
        Duration duration = Duration.between(departureTime, arrivalTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        StringBuilder result = new StringBuilder();
        
        if (hours > 0) {
            result.append(String.format("%d ore", hours));
        }
        if (minutes > 0) {
            if (hours > 0) {
                result.append(" e ");
            }
            result.append(String.format("%d minuti", minutes));
        }
        return result.toString();
    }


}
