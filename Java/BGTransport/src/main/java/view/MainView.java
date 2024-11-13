package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class MainView extends JFrame{

	private JButton switchThemeButton;
	JLabel LogoLabel = new JLabel(new ImageIcon(MainView.class.getResource("/images/Logo.png")));
	
    public MainView() {
    	try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    	
    	UIManager.put("Button.arc", 75);         
        UIManager.put("TextComponent.arc", 75); 
        UIManager.put("Component.arc", 75);
    	getContentPane().setLayout(null);
    	
    	JPanel mainPanel = new JPanel();
    	mainPanel.setBounds(0, 0, 1800, 900);
    	mainPanel.setLayout(null);
    	getContentPane().add(mainPanel);    	
	        	
    	/*JLabel maintitle = new JLabel("BGTransport");
    	maintitle.setForeground(new Color(210, 105, 30));
    	maintitle.setHorizontalAlignment(SwingConstants.CENTER);
    	maintitle.setFont(new Font("Gadugi", Font.BOLD, 75));
    	maintitle.setBounds(710, 120, 500, 179);
    	mainPanel.add(maintitle);*/
    	
    	LogoLabel.setBounds(242, 158, 1286, 366);
    	mainPanel.add(LogoLabel);
	       	
    	JButton sendButton = new JButton("Invia");
    	sendButton.setForeground(new Color(255, 255, 255));
    	sendButton.setFont(new Font("SansSerif", Font.BOLD, 16));
    	sendButton.setBackground(new Color(210, 105, 30));
    	sendButton.setBounds(930, 755, 80, 63);
    	mainPanel.add(sendButton);
    	
    	switchThemeButton = new JButton("Switch Theme");
    	switchThemeButton.setLocation(1600, 750);
    	switchThemeButton.setForeground(new Color(230, 230, 250));
    	switchThemeButton.setSize(122, 63);;
    	switchThemeButton.setBackground(new Color(210, 105, 30));
        switchThemeButton.addActionListener(e -> switchTheme());
        mainPanel.add(switchThemeButton);

        initComponents();
    }

    //Da spostare in controller
    private void switchTheme() {
        if (UIManager.getLookAndFeel() instanceof FlatDarkLaf) 
        {
            FlatLightLaf.setup();
            LogoLabel.setIcon(new ImageIcon(MainView.class.getResource("/images/Logo.png")));
        } 
        else 
        {
            FlatDarkLaf.setup();
            LogoLabel.setIcon(new ImageIcon(MainView.class.getResource("/images/LogoDark.png")));
        }            
        SwingUtilities.updateComponentTreeUI(this);          
    }

    private void initComponents() {
        setTitle("BGTransport");
        setSize(1800, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
}



