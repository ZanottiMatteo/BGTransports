package bgtransport.view;

import javax.swing.*;
import bgtransport.controller.LoginController;
import bgtransport.controller.MainController;
import bgtransport.controller.NewWindowController;
import bgtransport.controller.ThemeController;
import bgtransport.controller.UserInfoController;
import bgtransport.model.ConstantString2;
import bgtransport.model.ResizableImage;
import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * The UserView class represents the graphical user interface for the user profile screen.
 * It allows users to view and edit their personal information, manage their profile picture,
 * and log out of the system.
 */
public class UserView extends JFrame {

    private static final long serialVersionUID = 6180578220567180030L;

    public JPanel mainPanel = new JPanel();
    public MenuPanel menuPanel = new MenuPanel();
    public RoundedPanel homePanel = new RoundedPanel();
    public RoundedPanel weatherPanel = new RoundedPanel();
    public CircleLabel lblweatherimg = new CircleLabel("");
    public JLabel lblweathertxt = new JLabel("🏠 Bergamo");
    public RoundedPanel centerPanel = new RoundedPanel();
    public final Point centerpanelpoint = new Point(200, 30);

    public static CircleLabel profilePhoto = new CircleLabel();
    private BigLabel titlePersonalInfo = new BigLabel("Dati Personali");

    private MediumLabel titleUsername = new MediumLabel("Username");
    private MediumLabel titleEmail = new MediumLabel("Email");
    private MediumLabel titleName = new MediumLabel("Nome");
    private MediumLabel titleSurname = new MediumLabel("Cognome");
    private MediumLabel titleBirthday = new MediumLabel("Data di Nascita");
    private MediumLabel titleAddress = new MediumLabel("Indirizzo");
    private MediumLabel titleCity = new MediumLabel("Città");
    private MediumLabel titleZip = new MediumLabel("CAP");

    public static JTextField tfUsername = new JTextField();
    public static JTextField tfEmail = new JTextField();
    public static JTextField tfName = new JTextField();
    public static JTextField tfSurname = new JTextField();
    public static JTextField tfBirthday = new JTextField();
    public static JTextField tfAddress = new JTextField();
    public static JTextField tfCity = new JTextField();
    public static JTextField tfZip = new JTextField();

    public JButton changeData = new JButton();
    public JButton saveData = new JButton();
    public JButton discardData = new JButton();
    public static JButton chooseIcon = new JButton();
    public JButton logoutbutton = new JButton();

    public static ImageIcon image = new ImageIcon();
    public final transient ResizableImage lblBGwallpaper = new ResizableImage(new File("src/main/resources/images/BG.png"));

    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();

    public final Dimension originalPanelSize = new Dimension(1920, 1080);
    public final Dimension menuPanelSize = new Dimension(100, 900);
    public final Dimension minPanelSize = new Dimension(1085, 615);
    public final Dimension centerPanelSize = new Dimension(1600, 900);

    /**
     * Constructs the UserView and initializes all the components in the UI, 
     * including profile information fields, buttons, and layout.
     */
    public UserView() {
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setMinimumSize(minPanelSize);

        mainPanel = new JPanel() {
            private static final long serialVersionUID = 8925281806572340340L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);
            }
        };

        UIManager.put("Button.arc", 999);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("Component.arc", 15);

        getContentPane().setLayout(null);
        mainPanel.setBounds(0, 0, 1920, 1041);
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);

        homePanel.setLayout(null);
        homePanel.setOpaque(true);
        homePanel.setBounds(26, 40, 1854, 960);
        mainPanel.add(homePanel);

        homePanel.add(menuPanel);

        setupCenterPanel();
        storeComponentBounds();
        setupActionListeners();
        initComponents();
    }

    /**
     * Sets up the center panel with all the user profile fields and buttons.
     */
    private void setupCenterPanel() {
        centerPanel.setBounds(200, 30, 1600, 900);
        centerPanel.setLayout(null);
        homePanel.add(centerPanel);

        chooseIcon.setBounds(105, 70, 250, 250);
        chooseIcon.setBorderPainted(false);
        chooseIcon.setRolloverEnabled(false);
        chooseIcon.setBackground(new Color(0, 0, 0, 0));
        centerPanel.add(chooseIcon);

        profilePhoto.setBounds(110, 70, 250, 250);
        profilePhoto.setCircleColor(Color.GRAY);
        centerPanel.add(profilePhoto);

        int leftX = 500;
        int rightX = 1000;
        int yOffset = 40;
        int yPosition = 100;

        titlePersonalInfo.setBounds(leftX + 150, yPosition, 500, 50);
        centerPanel.add(titlePersonalInfo);
        yPosition += 80;

        titleUsername.setBounds(leftX, yPosition, 200, 25);
        tfUsername.setBounds(leftX, yPosition + yOffset, 300, 50);
        titleUsername.setHorizontalAlignment(SwingConstants.LEADING);
        tfUsername.setHorizontalAlignment(SwingConstants.LEADING);
        centerPanel.add(titleUsername);
        centerPanel.add(tfUsername);

        titleEmail.setBounds(rightX, yPosition, 200, 25);
        tfEmail.setBounds(rightX, yPosition + yOffset, 300, 50);
        titleEmail.setHorizontalAlignment(SwingConstants.LEADING);
        tfEmail.setHorizontalAlignment(SwingConstants.LEADING);
        centerPanel.add(titleEmail);
        centerPanel.add(tfEmail);
        yPosition += 150;

        titleName.setBounds(leftX, yPosition, 200, 25);
        tfName.setBounds(leftX, yPosition + yOffset, 300, 50);
        titleName.setHorizontalAlignment(SwingConstants.LEADING);
        tfName.setHorizontalAlignment(SwingConstants.LEADING);
        centerPanel.add(titleName);
        centerPanel.add(tfName);

        titleSurname.setBounds(rightX, yPosition, 200, 25);
        tfSurname.setBounds(rightX, yPosition + yOffset, 300, 50);
        titleSurname.setHorizontalAlignment(SwingConstants.LEADING);
        tfSurname.setHorizontalAlignment(SwingConstants.LEADING);
        centerPanel.add(titleSurname);
        centerPanel.add(tfSurname);
        yPosition += 150;

        titleBirthday.setBounds(leftX, yPosition, 200, 25);
        tfBirthday.setBounds(leftX, yPosition + yOffset, 300, 50);
        titleBirthday.setHorizontalAlignment(SwingConstants.LEADING);
        tfBirthday.setHorizontalAlignment(SwingConstants.LEADING);
        centerPanel.add(titleBirthday);
        centerPanel.add(tfBirthday);

        titleAddress.setBounds(rightX, yPosition, 200, 25);
        tfAddress.setBounds(rightX, yPosition + yOffset, 300, 50);
        titleAddress.setHorizontalAlignment(SwingConstants.LEADING);
        tfAddress.setHorizontalAlignment(SwingConstants.LEADING);
        centerPanel.add(titleAddress);
        centerPanel.add(tfAddress);
        yPosition += 150;

        titleCity.setBounds(leftX, yPosition, 200, 25);
        tfCity.setBounds(leftX, yPosition + yOffset, 300, 50);
        titleCity.setHorizontalAlignment(SwingConstants.LEADING);
        tfCity.setHorizontalAlignment(SwingConstants.LEADING);
        centerPanel.add(titleCity);
        centerPanel.add(tfCity);

        titleZip.setBounds(rightX, yPosition, 200, 25);
        tfZip.setBounds(rightX, yPosition + yOffset, 300, 50);
        titleZip.setHorizontalAlignment(SwingConstants.LEADING);
        tfZip.setHorizontalAlignment(SwingConstants.LEADING);
        centerPanel.add(titleZip);
        centerPanel.add(tfZip);
        yPosition += 150;

        changeData.setBounds(800, yPosition, 200, 50);
        changeData.setText("Modifica");
        changeData.setForeground(Color.WHITE);
        changeData.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
        changeData.setBackground(new Color(210, 105, 30));
        centerPanel.add(changeData);

        saveData.setBounds(650, yPosition, 200, 50);
        saveData.setVisible(false);
        saveData.setText("Salva");
        saveData.setForeground(Color.WHITE);
        saveData.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
        saveData.setBackground(new Color(210, 105, 30));
        centerPanel.add(saveData);

        discardData.setBounds(950, yPosition, 200, 50);
        discardData.setVisible(false);
        discardData.setText("Annulla");
        discardData.setForeground(Color.WHITE);
        discardData.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
        discardData.setBackground(new Color(210, 105, 30));
        centerPanel.add(discardData);

        logoutbutton.setBounds(1400, 50, 100, 50);
        logoutbutton.setText("Log Out");
        logoutbutton.setForeground(Color.WHITE);
        logoutbutton.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
        logoutbutton.setBackground(new Color(210, 105, 30));
        centerPanel.add(logoutbutton);
    }

    /**
     * Sets up action listeners for all buttons and interactions within the user view.
     */
    private void setupActionListeners() {
        menuPanel.homeButton.addActionListener(e -> {
            NewWindowController.openHomePanel(MainController.homeV);
            setVisible(false);
        });

        menuPanel.mapButton.addActionListener(e -> {
            NewWindowController.openMapPanel(MainController.mapV);
            setVisible(false);
        });

        menuPanel.lineButton.addActionListener(e -> {
            NewWindowController.openLinePanel(MainController.lineV);
            setVisible(false);
        });

        menuPanel.databaseButton.addActionListener(e -> {
            NewWindowController.openDatabasePanel(MainController.databaseV);
            setVisible(false);
        });

        menuPanel.switchThemeButton.addActionListener(e -> ThemeController.toggleThemes());

        changeData.addActionListener(e -> {
            UserInfoController.enableTextFields();
            saveData.setVisible(true);
            discardData.setVisible(true);
            changeData.setVisible(false);
        });

        saveData.addActionListener(e -> {
            try {
                UserInfoController.setDataFromTF();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            UserInfoController.disableTextFields();
            UserInfoController.showDataWidget();
            saveData.setVisible(false);
            discardData.setVisible(false);
            changeData.setVisible(true);
        });

        discardData.addActionListener(e -> {
            UserInfoController.disableTextFields();
            saveData.setVisible(false);
            discardData.setVisible(false);
            changeData.setVisible(true);
        });

        logoutbutton.addActionListener(e -> {
            LoginController.logout();
            setVisible(false);
        });

        chooseIcon.addActionListener(e -> NewWindowController.openAccountIconPanel(MainController.accountV));
    }

    /**
     * Stores the bounds of all components for resizing.
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
     * Initializes the basic properties of the window such as title, default close operation,
     * and location.
     */
    private void initComponents() {
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setMinimumSize(minPanelSize);
        setTitle("BGTransport");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
