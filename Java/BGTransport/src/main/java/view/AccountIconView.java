package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.UserInfoController;
import model.ConstantString;
import controller.LoginController;

public class AccountIconView extends JFrame {

	public static final JLabel lblSignUp = new JLabel("Immagine Profilo");
	public static final JButton button1Label = new JButton();
	public static final JButton button2Label = new JButton();
	public static final JButton button3Label = new JButton();
	public static final JButton button4Label = new JButton();
	public static final JButton button5Label = new JButton();
	public static final JButton button6Label = new JButton();
	public static final JButton button7Label = new JButton();
	public static final JButton button8Label = new JButton();
	public static final JButton button9Label = new JButton();
	public static final JButton button10Label = new JButton();
	public static final JButton button11Label = new JButton();
	public static final JButton button12Label = new JButton();

	private JFrame frame;
	private JPanel panel;
	JButton confirmButton = new JButton("Conferma");

	// Create a list to hold all the JLabels
	private static List<JButton> buttonList = new ArrayList<>();

	private int iconNumber;

	public AccountIconView() {
		setResizable(false);

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 800);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(580, 900));
		frame.getContentPane().add(panel);

		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(new Color(210, 105, 30));
		lblSignUp.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 50));
		lblSignUp.setBounds(84, 11, 412, 95);
		panel.add(lblSignUp);

		JScrollPane scrollPane = new JScrollPane(panel);

		confirmButton.setForeground(Color.WHITE);
		confirmButton.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 16));
		confirmButton.setBackground(new Color(210, 105, 30));
		confirmButton.setBounds(215, 805, 150, 50);
		confirmButton.addActionListener(e -> {
		});
		panel.add(confirmButton);

		// Declare and add each JLabel to the panel and the list
		button1Label.setBackground(new Color(192, 192, 192));
		button1Label.setBounds(30, 213, 128, 128);
		button1Label.setBorderPainted(false);
		panel.add(button1Label);
		buttonList.add(button1Label);

		button2Label.setBackground(new Color(192, 192, 192));
		button2Label.setBounds(223, 213, 128, 128);
		button2Label.setBorderPainted(false);
		panel.add(button2Label);
		buttonList.add(button2Label);

		button3Label.setBackground(new Color(192, 192, 192));
		button3Label.setBounds(424, 213, 128, 128);
		button3Label.setBorderPainted(false);
		panel.add(button3Label);
		buttonList.add(button3Label);

		button4Label.setBackground(new Color(192, 192, 192));
		button4Label.setBounds(223, 353, 128, 128);
		button4Label.setBorderPainted(false);
		panel.add(button4Label);
		buttonList.add(button4Label);

		button5Label.setBackground(new Color(192, 192, 192));
		button5Label.setBounds(30, 353, 128, 128);
		button5Label.setBorderPainted(false);
		panel.add(button5Label);
		buttonList.add(button5Label);

		button6Label.setBackground(new Color(192, 192, 192));
		button6Label.setBounds(424, 353, 128, 128);
		button6Label.setBorderPainted(false);
		panel.add(button6Label);
		buttonList.add(button6Label);

		button7Label.setBackground(Color.LIGHT_GRAY);
		button7Label.setBounds(30, 493, 128, 128);
		button7Label.setBorderPainted(false);
		panel.add(button7Label);
		buttonList.add(button7Label);

		button8Label.setBackground(Color.LIGHT_GRAY);
		button8Label.setBounds(30, 633, 128, 128);
		button8Label.setBorderPainted(false);
		panel.add(button8Label);
		buttonList.add(button8Label);

		button9Label.setBackground(Color.LIGHT_GRAY);
		button9Label.setBounds(223, 633, 128, 128);
		button9Label.setBorderPainted(false);
		panel.add(button9Label);
		buttonList.add(button9Label);

		button10Label.setBackground(Color.LIGHT_GRAY);
		button10Label.setBounds(223, 493, 128, 128);
		button10Label.setBorderPainted(false);
		panel.add(button10Label);
		buttonList.add(button10Label);

		button11Label.setBackground(Color.LIGHT_GRAY);
		button11Label.setBounds(424, 493, 128, 128);
		button11Label.setBorderPainted(false);
		panel.add(button11Label);
		buttonList.add(button11Label);

		button12Label.setBackground(Color.LIGHT_GRAY);
		button12Label.setBounds(424, 633, 128, 128);
		button12Label.setBorderPainted(false);
		panel.add(button12Label);
		buttonList.add(button12Label);

		JLabel lblScegliLaTua = new JLabel("Scegli la tua immagine profilo per l'account");
		lblScegliLaTua.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliLaTua.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 16));
		lblScegliLaTua.setBounds(84, 106, 412, 95);
		panel.add(lblScegliLaTua);

		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.setUnitIncrement(16); // Unit scroll speed (higher value = faster scroll)
		verticalScrollBar.setBlockIncrement(32);

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 600, 500);
		getContentPane().add(scrollPane);

		initializeButtonListeners();

		initComponents();
	}

	private void initComponents() {
		setTitle("BGTransport");
		setSize(600, 700);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		SwingUtilities.updateComponentTreeUI(this);
		setLocationRelativeTo(null);
	}

	// Method to return the list of JLabels
	public static List<JButton> getButtonList() {
		return buttonList;
	}

	private void initializeButtonListeners() {

		button1Label.addActionListener(e -> iconNumber = 1);

		button2Label.addActionListener(e -> iconNumber = 2);

		button3Label.addActionListener(e -> iconNumber = 3);

		button4Label.addActionListener(e -> iconNumber = 4);

		button5Label.addActionListener(e -> iconNumber = 5);

		button6Label.addActionListener(e -> iconNumber = 6);

		button7Label.addActionListener(e -> iconNumber = 7);

		button8Label.addActionListener(e -> iconNumber = 8);

		button9Label.addActionListener(e -> iconNumber = 9);

		button10Label.addActionListener(e -> iconNumber = 10);

		button11Label.addActionListener(e -> iconNumber = 11);

		button12Label.addActionListener(e -> iconNumber = 12);

		confirmButton.addActionListener(e -> {
			try {
				LoginController.userlogged.setImageAccount(iconNumber);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			UserInfoController.setProfileIcon();
			setVisible(false);
			System.out.println("Confermato: icona " + iconNumber);
		});

	}
}
