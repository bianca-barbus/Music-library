package view;

import controller.ChangePasswordController;

import javax.swing.*;
import java.awt.*;

public class ChangePasswordView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JLabel label1 = new JLabel("Enter email");
    JLabel label2 = new JLabel("Enter password");
    JLabel label3 = new JLabel("Enter new password");
    JTextField textFieldEmail = new JTextField();
    JTextField textFieldPassword = new JTextField();
    JTextField textFieldNewPassword = new JTextField();
    JButton saveButton = new JButton("Save");
    ChangePasswordController changePasswordController;

    public ChangePasswordView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        textFieldEmail.setPreferredSize(new Dimension(300, 20));
        textFieldPassword.setPreferredSize(new Dimension(300, 20));
        textFieldNewPassword.setPreferredSize(new Dimension(300, 20));

        panel1.add(label1);
        panel1.add(textFieldEmail);
        panel2.add(label2);
        panel2.add(textFieldPassword);
        panel3.add(label3);
        panel3.add(textFieldNewPassword);
        saveButton.addActionListener(e -> changePasswordController.saveNewPassword());
        panel4.add(saveButton);

        panel4.add(saveButton);
        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        frame.setContentPane(panel);
        frame.add(panel4, BorderLayout.SOUTH);
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

    public String getNewPassword() {
        return textFieldNewPassword.getText();
    }

    public void showMessage(String message, int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if (option == 1) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public ChangePasswordController getChangePasswordController() {
        return changePasswordController;
    }

    public void setChangePasswordController(ChangePasswordController changePasswordController) {
        this.changePasswordController = changePasswordController;
    }
}
