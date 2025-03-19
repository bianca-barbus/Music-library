package view;

import controller.UserMenuController;

import javax.swing.*;
import java.awt.*;

public class UserMenuView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JLabel label1 = new JLabel("Home");
    JButton seeTracksButton = new JButton("See tracks");
    JButton reviewButton = new JButton("Leave a review");
    JButton seePlaylistsButton = new JButton("See playlists");
    JButton logOutButton = new JButton("Log out");

    UserMenuController userMenuController;

    public UserMenuView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        panel1.add(label1);
        seeTracksButton.addActionListener(e -> userMenuController.seeTracksButtonClicked());
        panel2.add(seeTracksButton);
        seePlaylistsButton.addActionListener(e -> userMenuController.seePlaylistsButtonClicked());
        panel3.add(seePlaylistsButton);
        reviewButton.addActionListener(e -> userMenuController.leaveReviewButtonClicked());
        panel4.add(reviewButton);
        logOutButton.addActionListener(e -> userMenuController.logOutButtonClicked());
        panel5.add(logOutButton);
        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);

        frame.setContentPane(panel);
        frame.add(panel5, BorderLayout.SOUTH);
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public UserMenuController getUserMenuController() {
        return userMenuController;
    }

    public void setUserMenuController(UserMenuController userMenuController) {
        this.userMenuController = userMenuController;
    }
}
