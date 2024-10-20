package Voting.Authentication;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Voting.Utils.RandomNumberGenerator;

public class RegisterFrame extends JFrame {

    private JLabel NameLabel, IDLabel, EmailLabel, HashedPasswordLabel, VoterLabel, VoterLabel2;
    private JTextField NameField, IDField, EmailField, HashedPasswordField;
    private JButton RegisterButton, LoginButton;
    private JPanel panel;

    RandomNumberGenerator random = new RandomNumberGenerator();

    // CREATE LOGIN FRAME    EEEETEST

    RegisterFrame() {
        super("Register");
        setSize(450, 450);
        addComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    public void addComponents() {

        panel = new JPanel();
        panel.setLayout(null);

        VoterLabel2 = new JLabel();
        VoterLabel2.setBounds(280, 10, 100, 700);
        VoterLabel2.setText("Voter ID: ");
        VoterLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(VoterLabel2);

        VoterLabel = new JLabel();
        VoterLabel.setBounds(370, 10, 150, 700);
        VoterLabel.setText(random.generateRandomNumber() + "");
        VoterLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(VoterLabel);

        NameLabel = new JLabel();
        NameLabel.setBounds(50, 50, 100, 30);
        NameLabel.setText("Name: ");
        NameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(NameLabel);

        NameField = new JTextField();
        NameField.setBounds(150, 50, 200, 30);
        panel.add(NameField);

        IDLabel = new JLabel();
        IDLabel.setBounds(50, 100, 100, 30);
        IDLabel.setText("ID: ");
        IDLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(IDLabel);

        IDField = new JTextField();
        IDField.setBounds(150, 100, 200, 30);
        panel.add(IDField);

        EmailLabel = new JLabel();
        EmailLabel.setBounds(50, 150, 100, 30);
        EmailLabel.setText("Email: ");
        EmailLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(EmailLabel);

        EmailField = new JTextField();
        EmailField.setBounds(150, 150, 200, 30);
        panel.add(EmailField);

        HashedPasswordLabel = new JLabel();
        HashedPasswordLabel.setBounds(45, 200, 150, 30);
        HashedPasswordLabel.setText("Password: ");
        HashedPasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(HashedPasswordLabel);

        HashedPasswordField = new JTextField();
        HashedPasswordField.setBounds(150, 200, 200, 30);
        panel.add(HashedPasswordField);

        RegisterButton = new JButton("Register");
        RegisterButton.setBounds(150, 250, 100, 30);
        RegisterButton.setFocusable(false);
        panel.add(RegisterButton);

        LoginButton = new JButton("Login");
        LoginButton.setBounds(150, 300, 100, 30);
        LoginButton.setFocusable(false);
        panel.add(LoginButton);

        add(panel);
    }

    public static void main(String[] args) {
        RegisterFrame frame = new RegisterFrame();
    }

}
