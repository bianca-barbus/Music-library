package view;

import controller.SignInController;

import javax.swing.*;
import java.awt.*;

public class SignInView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JLabel label1 = new JLabel("SIGN IN");
    JLabel label2 = new JLabel("email:");
    JLabel label3 = new JLabel("password:");
    JLabel label4 = new JLabel("First name:");
    JLabel label5 = new JLabel("Last name:");
    JTextField textFieldEmail = new JTextField();
    JTextField textFieldPassword = new JTextField();
    JTextField textFieldFirstName = new JTextField();
    JTextField textFieldLastName = new JTextField();
    JButton createAccountButton = new JButton("Create account");
    SignInController signInController;

    public SignInView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        textFieldEmail.setPreferredSize(new Dimension(300, 20));
        textFieldPassword.setPreferredSize(new Dimension(300, 20));
        textFieldFirstName.setPreferredSize(new Dimension(300, 20));
        textFieldLastName.setPreferredSize(new Dimension(300, 20));

        panel1.add(label1);
        panel2.add(textFieldEmail);
        panel2.add(label2);
        panel3.add(textFieldFirstName);
        panel3.add(label4);
        panel4.add(textFieldLastName);
        panel4.add(label5);
        panel5.add(textFieldPassword);
        panel5.add(label3);
        createAccountButton.addActionListener(e -> signInController.createAccount());
        panel6.add(createAccountButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        panel.add(panel6);

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

    public String getFirstName() {
        return textFieldFirstName.getText();
    }

    public String getLastName() {
        return textFieldLastName.getText();
    }

    public void showMessage(String message, int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if (option == 1) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public SignInController getSignInController() {
        return signInController;
    }

    public void setSignInController(SignInController signInController) {
        this.signInController = signInController;
    }
}
