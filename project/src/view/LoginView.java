package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JLabel label1 = new JLabel("LOG IN");
    JLabel label2 = new JLabel("email:");
    JLabel label3 = new JLabel("password:");
    JTextField textFieldEmail = new JTextField();
    JTextField textFieldPassword = new JTextField();
    JButton loginButton = new JButton("Log in");
    LoginController loginController;

    public LoginView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        textFieldEmail.setPreferredSize(new Dimension(300, 20));
        textFieldPassword.setPreferredSize(new Dimension(300, 20));

        panel1.add(label1);
        panel2.add(label2);
        panel2.add(textFieldEmail);
        panel3.add(label3);
        panel3.add(textFieldPassword);
        loginButton.addActionListener(e -> loginController.attemptLogin());
        panel4.add(loginButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);

        frame.setContentPane(panel);
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public String getEmail() {
        return textFieldEmail.getText();
    }

    public String getPassword() {
        return textFieldPassword.getText();
    }

    public void showMessage(String message, int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if (option == 1) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
