package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

import BGTransport.BGTransport.App;
import controller.ThemeController;
import controller.SignUpController;

public class SignUpWindow extends JFrame {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblSignUp;
	private JTextField textEmail;
	private JPasswordField passwordFirst;
	private JPasswordField passwordConfirm;
	private JTextField textUsername;
	private JTextField textAddress;
	private JTextField textCity;
	private JTextField textZIP;
	private JLabel lblPassword_2;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblZip;
	JButton signUpButton = new JButton("SignUp");
	private JTextField textBirthday;
	private JTextField textSurname;
	private JTextField textName;
	
	
	public SignUpWindow() {		
		setResizable(false);
		System.out.println("signup" + ThemeController.getTheme());
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
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(580, 900));
		frame.getContentPane().add(panel);
		
		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(new Color(210, 105, 30));
		lblSignUp.setFont(new Font("SansSerif", Font.BOLD, 50));
		lblSignUp.setBounds(141, 11, 301, 95);
		panel.add(lblSignUp);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(185, 338, 216, 50);
		panel.add(textEmail);
		
		passwordFirst = new JPasswordField();
		passwordFirst.setBounds(185, 462, 216, 50);
		panel.add(passwordFirst);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setBounds(185, 524, 216, 50);
		panel.add(passwordConfirm);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(185, 400, 216, 50);
		panel.add(textUsername);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(185, 586, 216, 50);
		panel.add(textAddress);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(185, 648, 216, 50);
		panel.add(textCity);
		
		textZIP = new JTextField();
		textZIP.setColumns(10);
		textZIP.setBounds(185, 710, 216, 50);
		panel.add(textZIP);
		
		
		signUpButton.setForeground(Color.WHITE);
		signUpButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		signUpButton.setBackground(new Color(210, 105, 30));
		signUpButton.setBounds(216, 805, 150, 50);
		signUpButton.addActionListener(e -> {
			try {
				SignUpController.SignUp(textName, textSurname, textBirthday,textEmail, passwordFirst, passwordConfirm, textUsername, textAddress, textCity, textZIP);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		panel.add(signUpButton);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(210, 105, 30));
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblEmail.setBounds(75, 344, 105, 35);
		panel.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(210, 105, 30));
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblUsername.setBounds(75, 406, 105, 35);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(210, 105, 30));
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPassword.setBounds(75, 468, 105, 35);
		panel.add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("Confirm");
		lblPassword_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword_1.setForeground(new Color(210, 105, 30));
		lblPassword_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPassword_1.setBounds(75, 524, 105, 21);
		panel.add(lblPassword_1);
		
		lblPassword_2 = new JLabel("Password");
		lblPassword_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword_2.setForeground(new Color(210, 105, 30));
		lblPassword_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPassword_2.setBounds(75, 546, 105, 28);
		panel.add(lblPassword_2);
		
		lblAddress = new JLabel("Indirizzo");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(new Color(210, 105, 30));
		lblAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblAddress.setBounds(75, 592, 105, 35);
		panel.add(lblAddress);
		
		lblCity = new JLabel("Città");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setForeground(new Color(210, 105, 30));
		lblCity.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblCity.setBounds(75, 654, 105, 35);
		panel.add(lblCity);
		
		lblZip = new JLabel("CAP");
		lblZip.setHorizontalAlignment(SwingConstants.CENTER);
		lblZip.setForeground(new Color(210, 105, 30));
		lblZip.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblZip.setBounds(75, 716, 105, 35);
		panel.add(lblZip);
		
		JLabel lblBirthday = new JLabel("Data di Nascita");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setForeground(new Color(210, 105, 30));
		lblBirthday.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblBirthday.setBounds(60, 282, 120, 35);
		panel.add(lblBirthday);
		
		textBirthday = new JTextField();
		textBirthday.setColumns(10);
		textBirthday.setBounds(185, 276, 216, 50);
		panel.add(textBirthday);
		
		JLabel lblSurname = new JLabel("Cognome");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(new Color(210, 105, 30));
		lblSurname.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblSurname.setBounds(75, 220, 105, 35);
		panel.add(lblSurname);
		
		textSurname = new JTextField();
		textSurname.setColumns(10);
		textSurname.setBounds(185, 214, 216, 50);
		panel.add(textSurname);
		
		JLabel lblName = new JLabel("Nome");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(210, 105, 30));
		lblName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblName.setBounds(75, 155, 105, 35);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(185, 149, 216, 50);
		panel.add(textName);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 600, 500);
        getContentPane().add(scrollPane);
		initComponents();
	}

	private void initComponents() 
	{
		setTitle("BGTransport");
        setSize(600,500);       
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SwingUtilities.updateComponentTreeUI(this);
        setLocationRelativeTo(null);        	
	}
}
