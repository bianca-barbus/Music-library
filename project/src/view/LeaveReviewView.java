package view;

import controller.LeaveReviewController;

import javax.swing.*;
import java.awt.*;

public class LeaveReviewView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JLabel labelTitle = new JLabel("Track Title:");
    JTextField textFieldTitle = new JTextField();
    JLabel labelArtist = new JLabel("Artist:");
    JTextField textFieldArtist = new JTextField();
    JLabel labelRating = new JLabel("Rating:");
    JTextField textFieldRating = new JTextField();
    JLabel labelComment = new JLabel("Comment:");
    JTextField textFieldComment = new JTextField();
    JButton addButton = new JButton("Submit");
    JButton backButton = new JButton("Back");
    LeaveReviewController leaveReviewController;

    public LeaveReviewView() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        textFieldRating.setPreferredSize(new Dimension(300, 20));
        textFieldArtist.setPreferredSize(new Dimension(300, 20));
        textFieldComment.setPreferredSize(new Dimension(300, 20));
        textFieldTitle.setPreferredSize(new Dimension(300, 20));

        panel1.add(labelTitle);
        panel1.add(textFieldTitle);
        panel2.add(labelArtist);
        panel2.add(textFieldArtist);
        panel3.add(labelRating);
        panel3.add(textFieldRating);
        panel4.add(labelComment);
        panel4.add(textFieldComment);
        backButton.addActionListener(e -> leaveReviewController.backButtonClicked());
        panel5.add(backButton);
        addButton.addActionListener(e -> leaveReviewController.addReview());
        panel5.add(addButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        frame.setContentPane(panel);
    }

    public String getTitle() {
        return textFieldTitle.getText();
    }

    public String getArtist() {
        return textFieldArtist.getText();
    }

    public int getRating() {
        return Integer.parseInt(textFieldRating.getText());
    }

    public String getComment() {
        return textFieldComment.getText();
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public void showMessage(String message, int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if (option == 1) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public LeaveReviewController getLeaveReviewController() {
        return leaveReviewController;
    }

    public void setLeaveReviewController(LeaveReviewController leaveReviewController) {
        this.leaveReviewController = leaveReviewController;
    }
}
