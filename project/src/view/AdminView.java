package view;

import controller.AdminController;

import javax.swing.*;

public class AdminView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JLabel label1 = new JLabel("What you want to do?");
    JButton seeReviewsButton = new JButton("See reviews");
    JButton seeTracksButton = new JButton("See tracks");
    JButton backButton = new JButton("Back");
    AdminController adminController;

    public AdminView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);

        panel1.add(label1);
        seeReviewsButton.addActionListener(e -> adminController.seeReviewsButtonClicked());
        panel4.add(seeReviewsButton);
        seeTracksButton.addActionListener(e -> adminController.seeTracksButtonClicked());
        panel2.add(seeTracksButton);
        backButton.addActionListener(e -> adminController.backButtonClicked());
        panel3.add(backButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel4);
        panel.add(panel3);

        frame.setContentPane(panel);
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public AdminController getAdminController() {
        return adminController;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }
}