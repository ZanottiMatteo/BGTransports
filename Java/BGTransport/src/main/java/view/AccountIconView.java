package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BGTransport.BGTransport.App;
import controller.ThemeController;
import controller.SignUpController;

public class AccountIconView extends JFrame {

    // Move the JLabel declarations here and make them public static
    public static JLabel lblSignUp;
    public static JLabel Image1Label;
    public static JLabel Image2Label;
    public static JLabel Image3Label;
    public static JLabel Image4Label;
    public static JLabel Image5Label;
    public static JLabel Image6Label;
    public static JLabel Image7Label;
    public static JLabel Image8Label;
    public static JLabel Image9Label;
    public static JLabel Image10Label;
    public static JLabel Image11Label;
    public static JLabel Image12Label;
    
    private JFrame frame;
    private JPanel panel;
    JButton ConfirmButton = new JButton("Conferma");
    
    // Create a list to hold all the JLabels
    private static List<JLabel> labelList = new ArrayList<>();

    public AccountIconView() {        
        setResizable(false);
        
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(580, 900));
        frame.getContentPane().add(panel);
        
        lblSignUp = new JLabel("Immagine Profilo");
        lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
        lblSignUp.setForeground(new Color(210, 105, 30));
        lblSignUp.setFont(new Font("SansSerif", Font.BOLD, 50));
        lblSignUp.setBounds(84, 11, 412, 95);
        panel.add(lblSignUp);
                
        JScrollPane scrollPane = new JScrollPane(panel);
        
        ConfirmButton.setForeground(Color.WHITE);
        ConfirmButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        ConfirmButton.setBackground(new Color(210, 105, 30));
        ConfirmButton.setBounds(215, 805, 150, 50);
        ConfirmButton.addActionListener(e -> {
        });
        panel.add(ConfirmButton);
        
        // Declare and add each JLabel to the panel and the list
        Image1Label = new JLabel("");
        Image1Label.setBackground(new Color(192, 192, 192));
        Image1Label.setBounds(30, 213, 128, 128);
        panel.add(Image1Label);
        labelList.add(Image1Label);
        
        Image2Label = new JLabel("");
        Image2Label.setBackground(new Color(192, 192, 192));
        Image2Label.setBounds(223, 213, 128, 128);
        panel.add(Image2Label);
        labelList.add(Image2Label);
        
        Image3Label = new JLabel("");
        Image3Label.setBackground(new Color(192, 192, 192));
        Image3Label.setBounds(424, 213, 128, 128);
        panel.add(Image3Label);
        labelList.add(Image3Label);
        
        Image4Label = new JLabel("");
        Image4Label.setBackground(new Color(192, 192, 192));
        Image4Label.setBounds(223, 353, 128, 128);
        panel.add(Image4Label);
        labelList.add(Image4Label);
        
        Image5Label = new JLabel("");
        Image5Label.setBackground(new Color(192, 192, 192));
        Image5Label.setBounds(30, 353, 128, 128);
        panel.add(Image5Label);
        labelList.add(Image5Label);
        
        Image6Label = new JLabel("");
        Image6Label.setBackground(new Color(192, 192, 192));
        Image6Label.setBounds(424, 353, 128, 128);
        panel.add(Image6Label);
        labelList.add(Image6Label);
        
        Image7Label = new JLabel("");
        Image7Label.setBackground(Color.LIGHT_GRAY);
        Image7Label.setBounds(30, 493, 128, 128);
        panel.add(Image7Label);
        labelList.add(Image7Label);
        
        Image8Label = new JLabel("");
        Image8Label.setBackground(Color.LIGHT_GRAY);
        Image8Label.setBounds(30, 633, 128, 128);
        panel.add(Image8Label);
        labelList.add(Image8Label);
        
        Image9Label = new JLabel("");
        Image9Label.setBackground(Color.LIGHT_GRAY);
        Image9Label.setBounds(223, 633, 128, 128);
        panel.add(Image9Label);
        labelList.add(Image9Label);
        
        Image10Label = new JLabel("");
        Image10Label.setBackground(Color.LIGHT_GRAY);
        Image10Label.setBounds(223, 493, 128, 128);
        panel.add(Image10Label);
        labelList.add(Image10Label);
        
        Image11Label = new JLabel("");
        Image11Label.setBackground(Color.LIGHT_GRAY);
        Image11Label.setBounds(424, 493, 128, 128);
        panel.add(Image11Label);
        labelList.add(Image11Label);
        
        Image12Label = new JLabel("");
        Image12Label.setBackground(Color.LIGHT_GRAY);
        Image12Label.setBounds(424, 633, 128, 128);
        panel.add(Image12Label);
        labelList.add(Image12Label);
        
        JLabel lblScegliLaTua = new JLabel("Scegli la tua immagine profilo per l'account");
        lblScegliLaTua.setHorizontalAlignment(SwingConstants.CENTER);
        lblScegliLaTua.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblScegliLaTua.setBounds(84, 106, 412, 95);
        panel.add(lblScegliLaTua);
        
        
		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.setUnitIncrement(16); // Unit scroll speed (higher value = faster scroll)
		verticalScrollBar.setBlockIncrement(32);
        
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 600, 500);
        getContentPane().add(scrollPane);
        
        initComponents();
    }

    private void initComponents() 
    {
        setTitle("BGTransport");
        setSize(600, 700);       
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SwingUtilities.updateComponentTreeUI(this);
        setLocationRelativeTo(null);        	
    }

    // Method to return the list of JLabels
    public static List<JLabel> getLabelList() {
        return labelList;
    }
}
