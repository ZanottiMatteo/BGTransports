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

import controller.NewWindowController;
import controller.ThemeController;
import controller.ResizeController;
import view.RoundedPanel;


public class MainView extends JFrame {

	public JPanel mainPanel;	
	public JLabel LogoLabel = new JLabel(new ImageIcon(MainView.class.getResource("/images/Logo.png"))); 
	public ResizableImage lblBGwallpaper = new ResizableImage(MainView.class.getResource("/images/BG.png")); 
	public JPasswordField passwordField;
	public JButton switchThemeButton;
	public JPanel BGpanel;
	
	public Map<Component, Rectangle> componentBounds = new HashMap<>();
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension MinPanelSize = new Dimension(945, 655);
	public JTextField textField;	
	
    public MainView() {
    	 mainPanel = new JPanel() {
         	@Override
         	public void paintComponent(Graphics g) {
         		super.paintComponent(g);
         		g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);
         	}
         };      
    	setExtendedState(Frame.MAXIMIZED_BOTH);
    	setMinimumSize(MinPanelSize);
    	      
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
    	SwingUtilities.updateComponentTreeUI(this);
    	UIManager.put("Button.arc", 999);         
        UIManager.put("TextComponent.arc", 15); 
        UIManager.put("Component.arc", 15);
    	getContentPane().setLayout(null);
    	
    	mainPanel.setBounds(0, 0, 1920, 1080);      
    	mainPanel.setLayout(null);
    	getContentPane().add(mainPanel);   	
    	
    	JLabel textEmail = new JLabel("Email");
    	textEmail.setHorizontalAlignment(SwingConstants.CENTER);
    	textEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
    	textEmail.setBounds(852, 422, 55, 16);
    	mainPanel.add(textEmail);
	        	
    	LogoLabel.setBounds(662, 167, 596, 260);
    	mainPanel.add(LogoLabel);
	       	
    	JButton signInButton = new JButton("Sign In");
    	signInButton.setForeground(new Color(255, 255, 255));
    	signInButton.setFont(new Font("SansSerif", Font.BOLD, 16));
    	signInButton.setBackground(new Color(210, 105, 30));
    	signInButton.setBounds(885, 684, 150, 50);
    	mainPanel.add(signInButton);
    	
    	switchThemeButton = new JButton();
    	switchThemeButton.setBackground(new Color(0,0,0,0));
    	switchThemeButton.setLocation(1797, 944);
    	switchThemeButton.setSize(70, 70);
    	switchThemeButton.setIcon(new ImageIcon(MainView.class.getResource("/images/LDMode.png")));
    	switchThemeButton.setForeground(new Color(230, 230, 250));    	
    	switchThemeButton.setRolloverEnabled(false);
    	switchThemeButton.setBorderPainted(false);
        switchThemeButton.addActionListener(e -> ThemeController.setTheme(LogoLabel));
        mainPanel.add(switchThemeButton);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(852, 538, 216, 50);
        mainPanel.add(passwordField);
        
        textField = new JTextField();
        textField.setBounds(852, 445, 216, 50);
        mainPanel.add(textField);
        textField.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblPassword.setBounds(852, 515, 80, 16);
        mainPanel.add(lblPassword);
        
        JButton signupButton = new JButton("Sign Up");
        signupButton.setHorizontalAlignment(SwingConstants.LEFT);
        signupButton.setRolloverEnabled(false);
        signupButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        signupButton.setBorderPainted(false);
        signupButton.setBounds(840, 595, 105, 25);
        signupButton.setBackground(new Color(0,0,0,0));
        signupButton.addActionListener(e -> NewWindowController.openSignUp());
        mainPanel.add(signupButton);
        
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
        SwingUtilities.updateComponentTreeUI(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}



