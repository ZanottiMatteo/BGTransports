package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import controller.MainController;
import controller.NewWindowController;
import controller.ThemeController;
import controller.ResizeController;
import controller.LoginController;
import view.RoundedPanel;


public class LoginView extends JFrame {

	public JPanel mainPanel;	
	public JLabel LogoLabel = new JLabel(new ImageIcon(LoginView.class.getResource("/images/Logo.png")));
	public ImageIcon iconLDmode = new ImageIcon(LoginView.class.getResource("/images/LDMode.png"));
	public ResizableImage lblBGwallpaper = new ResizableImage(LoginView.class.getResource("/images/BG.png")); 
	public JPasswordField passwordField = new JPasswordField();;
	public JButton switchThemeButton;
	public JButton returnButton = new JButton();
	public ImageIcon iconReturn = new ImageIcon(LoginView.class.getResource("/images/Return.png"));
	public JPanel BGpanel;
	public JTextField textField = new JTextField();
	
	public Map<Component, Rectangle> componentBounds = new HashMap<>();
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension MinPanelSize = new Dimension(1075, 615);
	
	
    public LoginView() {
    	 mainPanel = new JPanel() {
         	@Override
         	public void paintComponent(Graphics g) {
         		super.paintComponent(g);
         		g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);
         	}
         };      
    	setExtendedState(Frame.MAXIMIZED_BOTH);
    	setMinimumSize(MinPanelSize);    	    
    	System.out.println("login" + ThemeController.getTheme());
    	if (ThemeController.getTheme()) {
			try {
		        UIManager.setLookAndFeel(new FlatLightLaf());
		    } catch (UnsupportedLookAndFeelException e) {
		        e.printStackTrace();
		    }}
		else {
			try {
	            UIManager.setLookAndFeel(new FlatDarkLaf());
	        } catch (UnsupportedLookAndFeelException e) {
	            e.printStackTrace();
	        }
		}
 	
    	UIManager.put("Button.arc", 999);         
        UIManager.put("TextComponent.arc", 15); 
        UIManager.put("Component.arc", 15);
    	getContentPane().setLayout(null);
    	
    	returnButton.setBounds(30, 30, 60, 60);
    	returnButton.setBorderPainted(false);
    	returnButton.setBackground(new Color(0, 0, 0, 0));
    	returnButton.setIcon(iconReturn);
    	mainPanel.add(returnButton);
    	
    	JButton signInButton = new JButton();
    	signInButton.setText("Sign In");
    	signInButton.setForeground(new Color(255, 255, 255));
    	signInButton.setFont(new Font("SansSerif", Font.BOLD, 16));
    	signInButton.setBackground(new Color(210, 105, 30));
    	signInButton.setBounds(885, 645, 150, 60);	
    	signInButton.addActionListener(e -> LoginController.Login(textField, passwordField));
    	mainPanel.add(signInButton);
    	
    	JButton signupButton = new JButton("Sign Up");
    	signupButton.setForeground(new Color(210, 105, 30));
    	signupButton.setRolloverEnabled(false);
    	signupButton.setBounds(885, 730, 150, 35);
    	signupButton.setPreferredSize(null);
    	signupButton.setFont(new Font("SansSerif", Font.BOLD, 15));
    	signupButton.setBorderPainted(false);       
    	signupButton.setBackground(new Color(0,0,0,0));
    	signupButton.addActionListener(e -> NewWindowController.openSignUp(MainController.signupV));
    	mainPanel.add(signupButton);
    	
    	mainPanel.setBounds(0, 0, 1920, 1080);      
    	mainPanel.setLayout(null);
    	getContentPane().add(mainPanel);   	
    	
    	JLabel textEmail = new JLabel("Email");
    	textEmail.setHorizontalAlignment(SwingConstants.LEFT);
    	textEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
    	textEmail.setBounds(852, 405, 150, 30);
    	mainPanel.add(textEmail);
	        	
    	LogoLabel.setBounds(662, 167, 596, 260);
    	mainPanel.add(LogoLabel);
	       	   	
    	switchThemeButton = new JButton();
    	switchThemeButton.setBackground(new Color(0,0,0,0));
    	switchThemeButton.setBounds(938, 850, 44, 35);
    	switchThemeButton.setIcon(iconLDmode);
    	switchThemeButton.setForeground(new Color(230, 230, 250));    	
    	switchThemeButton.setRolloverEnabled(false);
    	switchThemeButton.setBorderPainted(false);
    	 switchThemeButton.addActionListener(e -> ThemeController.updateThemes(MainController.homeV, MainController.mapV, MainController.loginV,
 				MainController.signupV));
        mainPanel.add(switchThemeButton);
        
        passwordField.setBounds(852, 550, 216, 50);
        mainPanel.add(passwordField);
        
        textField.setBounds(852, 445, 216, 50);
        mainPanel.add(textField);
        textField.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lblPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblPassword.setBounds(852, 515, 150, 30);
        mainPanel.add(lblPassword);
        
        RoundedPanel panel = new RoundedPanel();
        panel.setLayout(null);
        panel.setBounds(580, 167, 760, 644);
        mainPanel.add(panel);
    	           
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        } 
        initComponents();
    }
    
    private void initComponents() {
        setTitle("BGTransport");
        setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.updateComponentTreeUI(this); 
        setLocationRelativeTo(null);
    }
}



