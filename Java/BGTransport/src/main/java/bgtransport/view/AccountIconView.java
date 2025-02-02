package bgtransport.view;

import javax.swing.*;
import bgtransport.controller.MainController;
import bgtransport.controller.UserInfoController;
import bgtransport.model.ConstantString2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the view for selecting an account profile image.
 * It provides a user interface with buttons that allow the user to select a profile image.
 * The user can choose one of the 12 available images, and confirm their selection.
 */
public class AccountIconView extends JFrame {

    private static final long serialVersionUID = -6035159057813854015L;

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
    private JButton confirmButton = new JButton("Conferma");

    private static List<JButton> buttonList = new ArrayList<>();
    private int iconNumber;

    /**
     * Constructs the AccountIconView by setting up the user interface components,
     * including the buttons for selecting a profile image.
     * It initializes the frame, panel, labels, and buttons, and configures their layout and appearance.
     */
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
        lblSignUp.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 50));
        lblSignUp.setBounds(84, 11, 412, 95);
        panel.add(lblSignUp);

        JScrollPane scrollPane = new JScrollPane(panel);

        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
        confirmButton.setBackground(new Color(210, 105, 30));
        confirmButton.setBounds(215, 805, 150, 50);
        confirmButton.addActionListener(e -> {
        });
        panel.add(confirmButton);

        initializeButtons();

        JLabel lblScegliLaTua = new JLabel("Scegli la tua immagine profilo per l'account");
        lblScegliLaTua.setHorizontalAlignment(SwingConstants.CENTER);
        lblScegliLaTua.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
        lblScegliLaTua.setBounds(84, 106, 412, 95);
        panel.add(lblScegliLaTua);

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);
        verticalScrollBar.setBlockIncrement(32);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 600, 500);
        getContentPane().add(scrollPane);

        initializeButtonListeners();
        initComponents();
    }

    /**
     * Initializes the buttons that represent different profile image choices.
     * The buttons are added to the panel and buttonList, each with a default background color.
     */
    private void initializeButtons() {
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
    }

    /**
     * Initializes the action listeners for the buttons that allow the user to select a profile image.
     * Each button has an action listener associated with it that will handle the selection process.
     */
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
        	MainController.userlogged.setImageAccount(iconNumber);
            UserInfoController.setProfileIcon();
            setVisible(false);
        });
    }

    /**
     * Initializes additional components for the view.
     * This method sets the title, size, close operation, and updates the component tree.
     */
    private void initComponents() {
        setTitle("BGTransport");
        setSize(600, 700);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        SwingUtilities.updateComponentTreeUI(this);
        setLocationRelativeTo(null);
    }

    /**
     * Returns the list of buttons representing the profile images.
     * @return The list of buttons.
     */
    public static List<JButton> getButtonList() {
        return buttonList;
    }
}
