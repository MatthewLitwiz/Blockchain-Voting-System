package Voting.Authentication;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Voting.Utils.RandomNumberGenerator;

public class RegisterFrame extends JFrame implements ActionListener {

    private JLabel NameLabel, IDLabel, EmailLabel, HashedPasswordLabel, VoterLabel, VoterLabel2, TitleLabel;
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
        setResizable(false);
        setVisible(true);
    }

    public void addComponents() {

        panel = new JPanel();
        panel.setLayout(null);

        TitleLabel = new JLabel();
        TitleLabel.setBounds(150, -320, 250, 700);
        TitleLabel.setText("Register:");
        TitleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        panel.add(TitleLabel);

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
        NameLabel.setBounds(50, 100, 100, 30);
        NameLabel.setText("Name: ");
        NameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(NameLabel);

        NameField = new JTextField();
        NameField.setBounds(150, 100, 200, 30);
        panel.add(NameField);

        IDLabel = new JLabel();
        IDLabel.setBounds(50, 150, 100, 30);
        IDLabel.setText("ID: ");
        IDLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(IDLabel);

        IDField = new JTextField();
        IDField.setBounds(150, 150, 200, 30);
        panel.add(IDField);

        EmailLabel = new JLabel();
        EmailLabel.setBounds(50, 200, 100, 30);
        EmailLabel.setText("Email: ");
        EmailLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(EmailLabel);

        EmailField = new JTextField();
        EmailField.setBounds(150, 200, 200, 30);
        panel.add(EmailField);

        HashedPasswordLabel = new JLabel();
        HashedPasswordLabel.setBounds(45, 250, 150, 30);
        HashedPasswordLabel.setText("Password: ");
        HashedPasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(HashedPasswordLabel);

        HashedPasswordField = new JTextField();
        HashedPasswordField.setBounds(150, 250, 200, 30);
        panel.add(HashedPasswordField);

        RegisterButton = new JButton("Register");
        RegisterButton.setBounds(250, 300, 100, 30);
        RegisterButton.setFocusable(false);
        RegisterButton.addActionListener(this);
        panel.add(RegisterButton);

        LoginButton = new JButton("Login");
        LoginButton.setBounds(125, 300, 100, 30);
        LoginButton.setFocusable(false);
        LoginButton.addActionListener(this);
        panel.add(LoginButton);

        add(panel);
    }

    public static void main(String[] args) {
        RegisterFrame frame = new RegisterFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = NameField.getText();
        String id = IDField.getText();
        String email = EmailField.getText();
        String password = HashedPasswordField.getText();
    
        if (e.getSource() == RegisterButton) {
            // Register
            if (name.isEmpty() || id.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }
        
            // Write user details to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Resources/password/user.txt", true))) {
                writer.write(id + "," + name + "," + email + "," + password);
                writer.newLine();
                JOptionPane.showMessageDialog(null, "User registered successfully.");
                setVisible(false);
                new LoginFrame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
        } else if (e.getSource() == LoginButton) {
            setVisible(false);
            new LoginFrame();
        }
    }

}
