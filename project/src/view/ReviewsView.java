package view;

import controller.ReviewsController;
import model.ReviewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class ReviewsView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JTable reviewTable = new JTable();
    JScrollPane scrollPane = new JScrollPane(reviewTable);
    JButton refreshButton = new JButton("Refresh");
    JButton deleteButton = new JButton("Delete review");
    JButton backButton = new JButton("Back");
    ReviewsController reviewsController;

    public ReviewsView() {
        frame.setTitle("Music Library - Reviews");
        frame.setSize(900, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(scrollPane, BorderLayout.CENTER);

        deleteButton.addActionListener(e -> reviewsController.deleteReviewButtonClicked());
        panel1.add(deleteButton);
        refreshButton.addActionListener(e -> reviewsController.getAllReviewsAndDisplay());
        panel1.add(refreshButton);
        backButton.addActionListener(e -> reviewsController.backButtonClicked());
        panel1.add(backButton);
        frame.add(panel1, BorderLayout.SOUTH);
    }

    public void displayReviews(List<ReviewModel> reviews) {
        String[] columnNames = {"Title", "Artist", "Album", "Rating", "Comment", "Review ID"};
        Object[][] data = new Object[reviews.size()][6];

        for (int i = 0; i < reviews.size(); i++) {
            ReviewModel review = reviews.get(i);
            data[i][0] = review.getTrack();
            data[i][1] = review.getArtist();
            data[i][2] = review.getAlbum();
            data[i][3] = review.getRating();
            data[i][4] = review.getComment();
            data[i][5] = review.getReviewId();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        reviewTable.setModel(model);
        JTableHeader header = reviewTable.getTableHeader();
        frame.add(header, BorderLayout.NORTH);
        frame.add(reviewTable);
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public ReviewsController getReviewsController() {
        return reviewsController;
    }

    public void setReviewsController(ReviewsController reviewsController) {
        this.reviewsController = reviewsController;
    }
}
