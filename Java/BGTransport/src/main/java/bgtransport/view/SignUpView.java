package bgtransport.view;

import javax.swing.*;

import bgtransport.controller.SignUpController;
import bgtransport.model.ConstantString2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

/**
 * The SignUpView class creates and manages the graphical user interface (GUI) for the sign-up screen.
 * It contains fields for user input such as email, username, password, and more.
 */
public class SignUpView extends JFrame {

	private static final long serialVersionUID = 6878992684117226389L;
	private JFrame frame;
	private JPanel panel;
	private JLabel lblSignUp;
	public JLabel errorLabel = new JLabel();
	private JTextField textEmail;
	private JPasswordField passwordFirst;
	private JPasswordField passwordConfirm;
	private JTextField textUsername;
	private JTextField textAddress;
	private JTextField textCity;
	private JTextField textZIP;
	private JLabel lblPassword2;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblZip;
	JButton signUpButton = new JButton("SignUp");
	private JTextField textBirthday;
	private JTextField textSurname;
	private JTextField textName;

	/**
	 * Constructor for the SignUpView that initializes the graphical user interface.
	 * It adds all elements such as text fields, labels, and the sign-up button.
	 */
	public SignUpView() {
		setResizable(false);

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 800);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(580, 900));
		frame.getContentPane().add(panel);

		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(new Color(210, 105, 30));
		lblSignUp.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 50));
		lblSignUp.setBounds(141, 11, 301, 95);
		panel.add(lblSignUp);

		// Text fields for user input
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(185, 149, 216, 50);
		panel.add(textName);
		
		textSurname = new JTextField();
		textSurname.setColumns(10);
		textSurname.setBounds(185, 214, 216, 50);
		panel.add(textSurname);
		
		textBirthday = new JTextField();
		textBirthday.setToolTipText("es. GG/MM/AAAA oppure GG-MM-AAAA");
		textBirthday.setColumns(10);
		textBirthday.setBounds(185, 276, 216, 50);
		panel.add(textBirthday);
		
		textEmail = new JTextField();
		textEmail.setToolTipText("es. piero.rossi@gmail.com");
		textEmail.setColumns(10);
		textEmail.setBounds(185, 338, 216, 50);
		panel.add(textEmail);

		passwordFirst = new JPasswordField();
		passwordFirst.setToolTipText("Le password devono coincidere");
		passwordFirst.setBounds(185, 462, 216, 50);
		panel.add(passwordFirst);

		passwordConfirm = new JPasswordField();
		passwordConfirm.setToolTipText("Le password devono coincidere");
		passwordConfirm.setBounds(185, 524, 216, 50);
		panel.add(passwordConfirm);

		JScrollPane scrollPane = new JScrollPane(panel);

		textUsername = new JTextField();
		textUsername.setToolTipText("es. GigiRiva44 \nIl nome NON deve contenere spazi");
		textUsername.setColumns(10);
		textUsername.setBounds(185, 400, 216, 50);
		panel.add(textUsername);

		textAddress = new JTextField();
		textAddress.setToolTipText("es. via Roma, 20");
		textAddress.setColumns(10);
		textAddress.setBounds(185, 586, 216, 50);
		panel.add(textAddress);

		textCity = new JTextField();
		textCity.setToolTipText("es. Bergamo");
		textCity.setColumns(10);
		textCity.setBounds(185, 648, 216, 50);
		panel.add(textCity);

		textZIP = new JTextField();
		textZIP.setToolTipText("es. 24048");
		textZIP.setColumns(10);
		textZIP.setBounds(185, 710, 216, 50);
		panel.add(textZIP);

		// Sign-up button
		signUpButton.setForeground(Color.WHITE);
		signUpButton.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
		signUpButton.setBackground(new Color(210, 105, 30));
		signUpButton.setBounds(216, 823, 150, 50);
		signUpButton.addActionListener(e -> {
			try {
				SignUpController.signUp(textName, textSurname, textBirthday, textEmail, passwordFirst, passwordConfirm,
						textUsername, textAddress, textCity, textZIP);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		panel.add(signUpButton);

		// Labels for each input field
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(210, 105, 30));
		lblEmail.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblEmail.setBounds(75, 344, 105, 35);
		panel.add(lblEmail);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(210, 105, 30));
		lblUsername.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblUsername.setBounds(75, 406, 105, 35);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(210, 105, 30));
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPassword.setBounds(75, 468, 105, 35);
		panel.add(lblPassword);

		JLabel lblPassword1 = new JLabel("Confirm");
		lblPassword1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword1.setForeground(new Color(210, 105, 30));
		lblPassword1.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblPassword1.setBounds(75, 524, 105, 21);
		panel.add(lblPassword1);

		lblPassword2 = new JLabel("Password");
		lblPassword2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword2.setForeground(new Color(210, 105, 30));
		lblPassword2.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblPassword2.setBounds(75, 546, 105, 28);
		panel.add(lblPassword2);

		lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setForeground(new Color(210, 105, 30));
		lblAddress.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblAddress.setBounds(75, 592, 105, 35);
		panel.add(lblAddress);

		lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setForeground(new Color(210, 105, 30));
		lblCity.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblCity.setBounds(75, 654, 105, 35);
		panel.add(lblCity);

		lblZip = new JLabel("ZIP");
		lblZip.setHorizontalAlignment(SwingConstants.CENTER);
		lblZip.setForeground(new Color(210, 105, 30));
		lblZip.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblZip.setBounds(75, 716, 105, 35);
		panel.add(lblZip);

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setForeground(new Color(210, 105, 30));
		lblBirthday.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblBirthday.setBounds(60, 282, 120, 35);
		panel.add(lblBirthday);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(new Color(210, 105, 30));
		lblSurname.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblSurname.setBounds(75, 220, 105, 35);
		panel.add(lblSurname);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(210, 105, 30));
		lblName.setFont(new Font(ConstantString2.SANSSERIF, Font.PLAIN, 16));
		lblName.setBounds(75, 155, 105, 35);
		panel.add(lblName);
		
		
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(140, 783, 301, 29);
        errorLabel.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
        errorLabel.setForeground(new Color(255, 0, 0));
        errorLabel.setVisible(false);
		panel.add(errorLabel);

		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.setUnitIncrement(16); // Scroll speed (higher value = faster scroll)
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 600, 500);
		getContentPane().add(scrollPane);
		initComponents();
	}

	/**
	 * Initializes the window components and configures the settings for the frame.
	 */
	private void initComponents() {
		setTitle("BGTransport");
		setSize(600, 700);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		SwingUtilities.updateComponentTreeUI(this);
		setLocationRelativeTo(null);
	}
}
