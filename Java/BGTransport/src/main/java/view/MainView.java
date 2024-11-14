package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Frame;

import controller.NewWindowController;
import controller.ThemeController;
import controller.ResizeController;

public class MainView extends JFrame {

	public JPanel mainPanel = new JPanel();	
	public JLabel LogoLabel = new JLabel(new ImageIcon(MainView.class.getResource("/images/Logo.png"))); 
	public JPasswordField passwordField;
	public JButton switchThemeButton;
	public JButton signupButton = new JButton("Sign Up");
	
	public Map<Component, Rectangle> componentBounds = new HashMap<>();
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension MinPanelSize = new Dimension(945, 655);
	public JTextField textField;
	
	
	
    public MainView() {
    	List<JButton> buttons = new ArrayList<>();
    	setExtendedState(Frame.MAXIMIZED_BOTH);
    	setMinimumSize(MinPanelSize);
    	
    	try {
            UIManager.setLookAndFeel(new FlatLightLaf());           
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    	
    	UIManager.put("Button.arc", 999);         
        UIManager.put("TextComponent.arc", 15); 
        UIManager.put("Component.arc", 15);
    	getContentPane().setLayout(null);
    	
    	mainPanel.setBounds(0, 0, 1920, 1080);
    	
        
    	mainPanel.setLayout(null);
    	getContentPane().add(mainPanel);    	
	        	
    	LogoLabel.setBounds(207, 35, 1386, 366);
    	mainPanel.add(LogoLabel);
	       	
    	JButton signInButton = new JButton("Sign In");
    	signInButton.setForeground(new Color(255, 255, 255));
    	signInButton.setFont(new Font("SansSerif", Font.BOLD, 16));
    	signInButton.setBackground(new Color(210, 105, 30));
    	signInButton.setBounds(817, 741, 150, 50);
    	mainPanel.add(signInButton);
    	
    	switchThemeButton = new JButton();
    	buttons.add(switchThemeButton);
    	buttons.add(signupButton);
    	switchThemeButton.setLocation(1797, 944);
    	switchThemeButton.setSize(70, 70);
    	switchThemeButton.setIcon(new ImageIcon(MainView.class.getResource("/images/LDMode.png")));
    	switchThemeButton.setForeground(new Color(230, 230, 250));    	
    	switchThemeButton.setRolloverEnabled(false);
    	switchThemeButton.setBorderPainted(false);
        switchThemeButton.addActionListener(e -> ThemeController.setTheme(LogoLabel, buttons));

        mainPanel.add(switchThemeButton);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(784, 595, 216, 50);
        mainPanel.add(passwordField);
        
        textField = new JTextField();
        textField.setBounds(784, 502, 216, 50);
        mainPanel.add(textField);
        textField.setColumns(10);
        
        JLabel textEmail = new JLabel("Email");
        textEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
       // textEmail.setForeground(Color.GRAY);
        textEmail.setHorizontalAlignment(SwingConstants.CENTER);
        textEmail.setBounds(784, 477, 55, 16);
        mainPanel.add(textEmail);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
       // lblPassword.setForeground(Color.GRAY);
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(784, 567, 80, 16);
        mainPanel.add(lblPassword);
        
        signupButton.setFont(new Font("SansSerif", Font.BOLD, 12));       
        signupButton.setRolloverEnabled(false);
        signupButton.setBorderPainted(false);   	
    	signupButton.setBounds(769, 657, 75, 26);
    	signupButton.addActionListener(e -> NewWindowController.openSignUp());
        mainPanel.add(signupButton);
        
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        initComponents();
    }

    private void initComponents() {
        setTitle("BGTransport");
        setSize(1920,1080);
        SwingUtilities.updateComponentTreeUI(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}



