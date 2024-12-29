package bgtransport.view;

import javax.swing.*;
import bgtransport.controller.LoginController;
import bgtransport.controller.MainController;
import bgtransport.controller.NewWindowController;
import bgtransport.controller.ThemeController;
import bgtransport.model.ConstantString2;
import bgtransport.model.ResizableImage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.awt.Frame;

/**
 * This class represents the Login View of the BGTransport application.
 * It is responsible for displaying the login screen, where users can sign in or sign up.
 */
public class LoginView extends JFrame {

    private static final long serialVersionUID = -4391409465142244190L;

    // Declare UI components
    public JPanel mainPanel;
    public JLabel logoLabel = new JLabel();
    public JLabel logoLabelD = new JLabel();
    public final ImageIcon iconLogo = new ImageIcon(LoginView.class.getResource("/images/Logo.png"));
    public final ImageIcon iconLogoD = new ImageIcon(LoginView.class.getResource("/images/LogoDark.png"));
    public final ImageIcon iconLDmode = new ImageIcon(LoginView.class.getResource("/images/LDMode.png"));
    public final ImageIcon iconLDmodeD = new ImageIcon(LoginView.class.getResource("/images/LDModeDark.png"));
    public final transient ResizableImage lblBGwallpaper = new ResizableImage(new File("src/main/resources/images/BG.png"));
    public JPasswordField passwordField = new JPasswordField();
    public JButton switchThemeButton;
    public JButton returnButton = new JButton();
    public ImageIcon iconReturn = new ImageIcon(LoginView.class.getResource("/images/Return.png"));
    public ImageIcon iconReturnD = new ImageIcon(LoginView.class.getResource("/images/ReturnDark.png"));
    public JPanel bgPanel;
    public JTextField textField = new JTextField();
    public JButton signInButton = new JButton();
    public LittleLabel textEmail = new LittleLabel("Email");
    public JButton signupButton = new JButton("Sign Up");
    public RoundedPanel centerPanel = new RoundedPanel();
    public final Point centerPanelpoint = new Point(580, 167);
    public LittleLabel lblPassword = new LittleLabel("Password");
    public MiniLabel errorLabel = new MiniLabel();

    // Map to store component bounds for later resizing
    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();
    
    // Define dimensions for the frame and panel
    public final Dimension originalPanelSize = new Dimension(1920, 1080);
    public final Dimension minPanelSize = new Dimension(1150, 660);
    public final Dimension centralPanelSize = new Dimension(760, 644);

    /**
     * Constructs the LoginView and initializes all the UI components.
     * It sets up the layout, action listeners, and the general appearance of the view.
     */
    public LoginView() {
        initializeMainPanel();
        initializeReturnButton();
        initializeSignInButton();
        initializeSignUpButton();
        initializeThemeSwitchButton();
        initializeTextFields();
        initializeLabels();
        initializeLogo();
        initializeCentralPanel();
        storeComponentBounds();
        initComponents();
    }

    /**
     * Initializes the main panel and sets its layout and background image.
     */
    private void initializeMainPanel() {
        mainPanel = new JPanel() {
            private static final long serialVersionUID = -2563297190423775145L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);
            }
        };

        mainPanel.setBounds(0, 0, 1920, 1080);
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);
        centerPanel.setLayout(null);
        centerPanel.setBounds(580, 167, 760, 644);
        mainPanel.add(centerPanel);
    }

    /**
     * Initializes the central panel where the login form and controls are displayed.
     */
    private void initializeCentralPanel() {
        centerPanel.setLayout(null);
        centerPanel.setBounds(580, 167, 760, 644);
        mainPanel.add(centerPanel);
    }

    /**
     * Initializes the "Return" button that navigates back to the Home View.
     */
    private void initializeReturnButton() {
        returnButton.setBounds(30, 30, 60, 60);
        returnButton.setBorderPainted(false);
        returnButton.setBackground(new Color(0, 0, 0, 0));
        returnButton.addActionListener(e -> {
            NewWindowController.openHomePanel(MainController.homeV);
            setVisible(false);
        });
        mainPanel.add(returnButton);
    }

    /**
     * Initializes the "Sign In" button that attempts to log the user in using the entered credentials.
     */
    private void initializeSignInButton() {
        signInButton.setText("Sign In");
        signInButton.setForeground(new Color(255, 255, 255));
        signInButton.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
        signInButton.setBackground(new Color(210, 105, 30));
        signInButton.setBounds(885, 645, 150, 60);
        signInButton.addActionListener(e -> LoginController.login(textField, passwordField));
        mainPanel.add(signInButton);
    }

    /**
     * Initializes the "Sign Up" button that navigates to the Sign Up view.
     */
    private void initializeSignUpButton() {
        signupButton.setForeground(new Color(210, 105, 30));
        signupButton.setRolloverEnabled(false);
        signupButton.setBounds(885, 730, 150, 35);
        signupButton.setPreferredSize(null);
        signupButton.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 15));
        signupButton.setBorderPainted(false);
        signupButton.setBackground(new Color(0, 0, 0, 0));
        signupButton.addActionListener(e -> NewWindowController.openSignUp(MainController.signupV));
        mainPanel.add(signupButton);
    }

    /**
     * Initializes the theme switch button to toggle between light and dark modes.
     */
    private void initializeThemeSwitchButton() {
        switchThemeButton = new JButton();
        switchThemeButton.setBackground(new Color(0, 0, 0, 0));
        switchThemeButton.setBounds(938, 850, 44, 35);
        switchThemeButton.setForeground(new Color(230, 230, 250));
        switchThemeButton.setRolloverEnabled(false);
        switchThemeButton.setBorderPainted(false);
        switchThemeButton.addActionListener(e -> ThemeController.toggleThemes());
        mainPanel.add(switchThemeButton);
    }

    /**
     * Initializes the text fields for entering email and password.
     */
    private void initializeTextFields() {
        textField.setBounds(852, 445, 216, 50);
        textField.setColumns(10);
        mainPanel.add(textField);

        passwordField.setBounds(852, 550, 216, 50);
        mainPanel.add(passwordField);
    }

    /**
     * Initializes the labels for the email and password fields, as well as the error label.
     */
    private void initializeLabels() {
        textEmail.setHorizontalAlignment(SwingConstants.LEFT);
        textEmail.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
        textEmail.setBounds(852, 405, 150, 30);
        mainPanel.add(textEmail);

        lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lblPassword.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
        lblPassword.setBounds(852, 515, 150, 30);
        mainPanel.add(lblPassword);
        
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
        errorLabel.setForeground(new Color(255, 0, 0));
        errorLabel.setBounds(580, 605, 760, 30);
        errorLabel.setVisible(false);
        mainPanel.add(errorLabel);
    }

    /**
     * Initializes the logo images, setting them to be displayed in the center of the screen.
     */
    private void initializeLogo() {
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBounds(662, 167, 596, 240);
        mainPanel.add(logoLabel);
        logoLabelD.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabelD.setBounds(662, 167, 596, 240);
        mainPanel.add(logoLabelD);
    }

    /**
     * Stores the bounds of all components in the main panel for potential resizing.
     */
    private void storeComponentBounds() {
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }

    /**
     * Initializes the frame properties such as size, title, and close operation.
     */
    private void initComponents() {
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setMinimumSize(minPanelSize);
        setTitle("BGTransport");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
