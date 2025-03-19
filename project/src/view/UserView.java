package view;

import controller.UserController;

import javax.swing.*;

public class UserView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel("Don't have an account? Create one");
    JButton loginButton = new JButton("Log in");
    JButton signInButton = new JButton("Sign in");
    JButton changePasswordButton = new JButton("Change password");
    JButton backButton = new JButton("Back");
    UserController userController;

    public UserView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);

        loginButton.addActionListener(e -> userController.loginButtonClicked());
        panel1.add(loginButton);
        changePasswordButton.addActionListener(e -> userController.changePasswordButtonClicked());
        panel1.add(changePasswordButton);
        panel2.add(label1);
        signInButton.addActionListener(e -> userController.signInButtonClicked());
        panel2.add(signInButton);
        backButton.addActionListener(e -> userController.backButtonClicked());
        panel3.add(backButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        frame.setContentPane(panel);
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

}
