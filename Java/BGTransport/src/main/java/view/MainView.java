package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.Frame;
import java.awt.BorderLayout;

public class MainView extends JFrame{

	JPanel mainPanel = new JPanel();	
	JLabel LogoLabel = new JLabel(new ImageIcon(MainView.class.getResource("/images/Logo.png"))); 
	private JPasswordField passwordField;
	private JButton switchThemeButton;
	JButton signupButton = new JButton("Sign Up");
	
	private Map<Component, Rectangle> componentBounds = new HashMap<>();
	private final Dimension originalPanelSize = new Dimension(1920, 1080);
	private final Dimension MinPanelSize = new Dimension(945, 655);
	private JTextField textField;
	
    public MainView() {
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
	       	
    	JButton sendButton = new JButton("Sign In");
    	sendButton.setForeground(new Color(255, 255, 255));
    	sendButton.setFont(new Font("SansSerif", Font.BOLD, 16));
    	sendButton.setBackground(new Color(210, 105, 30));
    	sendButton.setBounds(817, 741, 150, 50);
    	mainPanel.add(sendButton);
    	
    	switchThemeButton = new JButton();
    	switchThemeButton.setLocation(1797, 944);
    	switchThemeButton.setSize(70, 70);
    	switchThemeButton.setIcon(new ImageIcon(MainView.class.getResource("/images/LDMode.png")));
    	switchThemeButton.setForeground(new Color(230, 230, 250));    	
    	switchThemeButton.setRolloverEnabled(false);
    	switchThemeButton.setBorderPainted(false);
        switchThemeButton.addActionListener(e -> setTheme());
        mainPanel.add(switchThemeButton);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(784, 595, 216, 50);
        mainPanel.add(passwordField);
        
        textField = new JTextField();
        textField.setBounds(784, 502, 216, 50);
        mainPanel.add(textField);
        textField.setColumns(10);
        
        JLabel textEmail = new JLabel("Email");
       // textEmail.setForeground(Color.GRAY);
        textEmail.setHorizontalAlignment(SwingConstants.CENTER);
        textEmail.setBounds(784, 477, 55, 16);
        mainPanel.add(textEmail);
        
        JLabel lblPassword = new JLabel("Password");
       // lblPassword.setForeground(Color.GRAY);
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(784, 567, 80, 16);
        mainPanel.add(lblPassword);
        
        
        signupButton.setRolloverEnabled(false);
        signupButton.setBorderPainted(false);
    	
    	signupButton.setBounds(769, 657, 75, 16);
        mainPanel.add(signupButton);
        
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
               resizeComponents();
            }
        });
        initComponents();
    }
    
    //Da spostare in controller  
    private void resizeComponents() {
    	double widthRatio = (double) getWidth() / originalPanelSize.width;
        double heightRatio = (double) getHeight() / originalPanelSize.height;        
       // System.out.println("W: " + getWidth() + "H: " + getHeight());     
        
        for (Map.Entry<Component, Rectangle> entry : componentBounds.entrySet()) {
            Component comp = entry.getKey();
            Rectangle originalBounds = entry.getValue();
            comp.setBounds((int)(originalBounds.x * widthRatio), (int)(originalBounds.y * heightRatio), (int)(originalBounds.width * widthRatio), (int)(originalBounds.height * heightRatio));
        }       
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    //Da spostare in controller 
    private void setTheme() {
        if (UIManager.getLookAndFeel() instanceof FlatDarkLaf) 
        {
            FlatLightLaf.setup();
            LogoLabel.setIcon(new ImageIcon(MainView.class.getResource("/images/Logo.png")));
            signupButton.setBackground(Color.WHITE);
            switchThemeButton.setBackground(Color.WHITE);
        } 
        else 
        {
            FlatDarkLaf.setup();
            LogoLabel.setIcon(new ImageIcon(MainView.class.getResource("/images/LogoDark.png")));
            signupButton.setBackground(new Color(60, 63, 65));
            switchThemeButton.setBackground(new Color(60, 63, 65));
        }            
        SwingUtilities.updateComponentTreeUI(this);          
    }

    private void initComponents() {
        setTitle("BGTransport");
        setSize(1920,1080);
        SwingUtilities.updateComponentTreeUI(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}



