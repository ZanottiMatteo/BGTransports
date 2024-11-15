package view;

import javax.swing.*;
import javax.swing.border.Border;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import controller.MainController;
import controller.NewWindowController;
import controller.ResizeController;
import controller.ThemeController;
import view.RoundedPanel;

public class HomeView extends JFrame {

	public JPanel mainPanel = new JPanel();	
	public JButton switchThemeButton;
	public JButton userButton;
	public ResizableImage lblBGwallpaper = new ResizableImage(LoginView.class.getResource("/images/BG.png")); 
	public ImageIcon iconUser = new ImageIcon(HomeView.class.getResource("/images/User.png"));
	
	public Map<Component, Rectangle> componentBounds = new HashMap<>();
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension MinPanelSize = new Dimension(1075, 615);
	
    public HomeView() {
    	
    	setExtendedState(Frame.MAXIMIZED_BOTH);
    	setMinimumSize(MinPanelSize);
    	
    	mainPanel = new JPanel() {
         	@Override
         	public void paintComponent(Graphics g) {
         		super.paintComponent(g);
         		g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);
         	}
         };
         
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
        
    	RoundedPanel homePanel = new RoundedPanel();
        homePanel.setLayout(null);
        homePanel.setBounds(180, 90, 1700, 900);
        mainPanel.add(homePanel);
        
        RoundedPanel  menuPanel = new RoundedPanel();
        menuPanel.setBackground(new Color(210, 105, 30));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        menuPanel.setBounds(41, 90, 101, 900);

        mainPanel.add(menuPanel);
        menuPanel.setLayout(null);
                
        userButton = new JButton();
        userButton.setBounds(22, 22, 62, 62);
        userButton.setRolloverEnabled(false);
        userButton.setBorderPainted(false);
        userButton.setIcon(iconUser);
        userButton.setBackground(new Color(0,0,0,0));
        userButton.addActionListener(e -> NewWindowController.openUserPanel(MainController.mainV));
        menuPanel.add(userButton);
        
        switchThemeButton = new JButton();
        switchThemeButton.setBounds(1855, 1000, 44, 35);
        mainPanel.add(switchThemeButton);
        switchThemeButton.setBackground(new Color(0,0,0,0));
        switchThemeButton.setIcon(new ImageIcon(HomeView.class.getResource("/images/LDMode.png")));
        switchThemeButton.setForeground(new Color(230, 230, 250));    	
        switchThemeButton.setRolloverEnabled(false);
        switchThemeButton.setBorderPainted(false);
        switchThemeButton.addActionListener(e -> ThemeController.setTheme());
        
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        for (Component comp : menuPanel.getComponents()) {
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



