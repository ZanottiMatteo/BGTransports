package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.awt.Frame;

import controller.MainController;
import controller.NewWindowController;
import controller.ThemeController;
import model.ResizableImage;
import controller.LoginController;
import view.RoundedPanel;

public class LoginView extends JFrame {

    // Declare UI components
    public JPanel mainPanel;
    public JLabel LogoLabel = new JLabel(new ImageIcon(LoginView.class.getResource("/images/Logo.png")));
    public ImageIcon iconLDmode = new ImageIcon(LoginView.class.getResource("/images/LDMode.png"));
    public ResizableImage lblBGwallpaper = new ResizableImage(new File("src/main/resources/images/BG.png"));
    public JPasswordField passwordField = new JPasswordField();
    public JButton switchThemeButton;
    public JButton returnButton = new JButton();
    public ImageIcon iconReturn = new ImageIcon(LoginView.class.getResource("/images/Return.png"));
    public JPanel BGpanel;
    public JTextField textField = new JTextField();
    public JButton signInButton = new JButton();
    public LittleLabel textEmail = new LittleLabel("Email");
    public JButton signupButton = new JButton("Sign Up");
    public RoundedPanel centerPanel = new RoundedPanel();
    public final Point centerPanelpoint = new Point(580, 167);
    public LittleLabel lblPassword = new LittleLabel("Password");
    public MiniLabel ErrorLabel = new MiniLabel();

    // Map to store component bounds for later resizing
    public Map<Component, Rectangle> componentBounds = new HashMap<>();
    
    // Define dimensions for the frame and panel
    public final Dimension originalPanelSize = new Dimension(1920, 1080);
    public final Dimension MinPanelSize = new Dimension(1150, 660);
    public final Dimension CentralPanelSize = new Dimension(760, 644);
    
    
    public LoginView() {
        // Initialize main panel
        initializeMainPanel();

        // Initialize buttons and actions
        initializeReturnButton();
        initializeSignInButton();
        initializeSignUpButton();
        initializeThemeSwitchButton();

        // Initialize text fields and labels
        initializeTextFields();
        initializeLabels();

        // Initialize logo
        initializeLogo();
        
        // Initailize Central Panel
        initializeCentralPanel();
        
        // Store bounds for resizing
        storeComponentBounds();
        
        // Set frame properties and layout
        initComponents();
    }

    /**
     * Initializes the main panel with the background wallpaper.
     */
    private void initializeMainPanel() {
        mainPanel = new JPanel() {
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
     * Initializes the main panel with the background wallpaper.
     */
    private void initializeCentralPanel() {
        centerPanel.setLayout(null);
        centerPanel.setBounds(580, 167, 760, 644);
        mainPanel.add(centerPanel);
    }

    /**
     * Configures the return button (back to home screen).
     */
    private void initializeReturnButton() {
        returnButton.setBounds(30, 30, 60, 60);
        returnButton.setBorderPainted(false);
        returnButton.setBackground(new Color(0, 0, 0, 0));
        returnButton.setIcon(iconReturn);
        returnButton.addActionListener(e -> {
            NewWindowController.openHomePanel(MainController.homeV);
            setVisible(false);
        });
        mainPanel.add(returnButton);
    }

    /**
     * Configures the "Sign In" button and its action.
     */
    private void initializeSignInButton() {
        signInButton.setText("Sign In");
        signInButton.setForeground(new Color(255, 255, 255));
        signInButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        signInButton.setBackground(new Color(210, 105, 30));
        signInButton.setBounds(885, 645, 150, 60);
        signInButton.addActionListener(e -> LoginController.Login(textField, passwordField));
        mainPanel.add(signInButton);
    }

    /**
     * Configures the "Sign Up" button and its action.
     */
    private void initializeSignUpButton() {
        signupButton.setForeground(new Color(210, 105, 30));
        signupButton.setRolloverEnabled(false);
        signupButton.setBounds(885, 730, 150, 35);
        signupButton.setPreferredSize(null);
        signupButton.setFont(new Font("SansSerif", Font.BOLD, 15));
        signupButton.setBorderPainted(false);
        signupButton.setBackground(new Color(0, 0, 0, 0));
        signupButton.addActionListener(e -> NewWindowController.openSignUp(MainController.signupV));
        mainPanel.add(signupButton);
    }

    /**
     * Configures the theme switching button.
     */
    private void initializeThemeSwitchButton() {
        switchThemeButton = new JButton();
        switchThemeButton.setBackground(new Color(0, 0, 0, 0));
        switchThemeButton.setBounds(938, 850, 44, 35);
        switchThemeButton.setIcon(iconLDmode);
        switchThemeButton.setForeground(new Color(230, 230, 250));
        switchThemeButton.setRolloverEnabled(false);
        switchThemeButton.setBorderPainted(false);
        switchThemeButton.addActionListener(e -> ThemeController.updateThemes());
        mainPanel.add(switchThemeButton);
    }

    /**
     * Initializes the text fields (email and password).
     */
    private void initializeTextFields() {
        textField.setBounds(852, 445, 216, 50);
        textField.setColumns(10);
        mainPanel.add(textField);

        passwordField.setBounds(852, 550, 216, 50);
        mainPanel.add(passwordField);
    }

    /**
     * Configures the labels for the email and password fields.
     */
    private void initializeLabels() {
        textEmail.setHorizontalAlignment(SwingConstants.LEFT);
        textEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
        textEmail.setBounds(852, 405, 150, 30);
        mainPanel.add(textEmail);

        lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lblPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblPassword.setBounds(852, 515, 150, 30);
        mainPanel.add(lblPassword);
        
        ErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ErrorLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        ErrorLabel.setForeground(new Color(255, 0, 0));
        ErrorLabel.setBounds(580, 605, 760, 30);
        ErrorLabel.setVisible(false);
        mainPanel.add(ErrorLabel);
    }

    /**
     * Initializes the logo label.
     */
    private void initializeLogo() {
        LogoLabel.setBounds(662, 167, 596, 260);
        mainPanel.add(LogoLabel);
    }

    /**
     * Stores the component bounds for later resizing purposes.
     */
    private void storeComponentBounds() {
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }

    /**
     * Initializes the frame properties such as title, size, close operation, and location.
     */
    private void initComponents() {
    	setExtendedState(Frame.MAXIMIZED_BOTH); // Maximize the window at startup
        setMinimumSize(MinPanelSize); // Set minimum window size
        setTitle("BGTransport"); // Set window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
    }
}
