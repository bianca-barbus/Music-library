package view;

import controller.DeleteReviewController;

import javax.swing.*;
import java.awt.*;

public class DeleteReviewView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel labelId = new JLabel("Enter the ID of the review you want to delete:");
    JTextField textFieldId = new JTextField();
    JButton deleteButton = new JButton("Delete");
    DeleteReviewController deleteReviewController;

    public DeleteReviewView() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        textFieldId.setPreferredSize(new Dimension(30, 20));

        panel1.add(labelId);
        panel2.add(textFieldId);

        deleteButton.addActionListener(e -> deleteReviewController.deleteReview());
        panel3.add(deleteButton);
        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        frame.setContentPane(panel);
        frame.add(panel3, BorderLayout.SOUTH);
    }

    public int getId() {
        return Integer.parseInt(textFieldId.getText());
    }

    public void showMessage(String message, int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if (option == 1) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public DeleteReviewController getDeleteReviewController() {
        return deleteReviewController;
    }

    public void setDeleteReviewController(DeleteReviewController deleteReviewController) {
        this.deleteReviewController = deleteReviewController;
    }
}
