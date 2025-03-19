package view;

import controller.PersonController;
import controller.UserController;

import javax.swing.*;

public class PersonView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel label1 = new JLabel("Choose your role");
    JButton adminButton = new JButton("Admin");
    JButton userButton = new JButton("User");
    PersonController personController;
    UserController userController;

    public PersonView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        panel1.add(label1);

        adminButton.addActionListener(e -> personController.adminButtonClicked());
        panel2.add(adminButton);
        userButton.addActionListener(e -> personController.userButtonClicked());
        panel2.add(userButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);

        frame.setContentPane(panel);
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public PersonController getPersonController() {
        return personController;
    }

    public void setPersonController(PersonController personController) {
        this.personController = personController;
    }
}