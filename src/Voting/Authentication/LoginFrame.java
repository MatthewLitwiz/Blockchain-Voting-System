package Voting.Authentication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Voting.Models.User;
import Voting.Utils.FileReaderUtility;

public class LoginFrame extends JFrame implements ActionListener {

    private JButton LoginButton, RegisterButton;
    private JLabel emailLabel, passwordLabel, titleLabel;
    private JTextField emailField, passwordField;

    public LoginFrame() {
        super("Login");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addComponents();
        setVisible(true);
    }

    public void addComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setBounds(150, -320, 250, 700);
        titleLabel.setText("Login:");
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        panel.add(titleLabel);

        emailLabel = new JLabel();
        emailLabel.setBounds(50, 100, 100, 30);
        emailLabel.setText("Email: ");
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 200, 30);
        panel.add(emailField);

        passwordLabel = new JLabel();
        passwordLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setText("Password: ");
        panel.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(150, 150, 200, 30);
        panel.add(passwordField);

        LoginButton = new JButton("Login");
        LoginButton.setBounds(50, 225, 100, 30);
        LoginButton.setFocusable(false);
        LoginButton.addActionListener(this);
        panel.add(LoginButton);

        RegisterButton = new JButton("Register");
        RegisterButton.setBounds(200, 225, 100, 30);
        RegisterButton.setFocusable(false);
        RegisterButton.addActionListener(this);
        panel.add(RegisterButton);

        add(panel);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (e.getSource() == LoginButton) {
            // Retrieve user by email
            User user = FileReaderUtility.getUserByEmail(email);

            // Check if user exists and the password matches
            if (user != null && user.getHashedPassword().equals(password)) {
                // Successful login
                JOptionPane.showMessageDialog(null, "Login successful.");
                // You can add code here to redirect to another frame or dashboard
            } else {
                // Invalid credentials
                JOptionPane.showMessageDialog(null, "Invalid email or password.");
            }
        } else if (e.getSource() == RegisterButton) {
            setVisible(false);
            new RegisterFrame();
        }
    }

}
