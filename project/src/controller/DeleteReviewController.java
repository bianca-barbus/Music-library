package controller;

import repository.ReviewRepository;
import view.DeleteReviewView;

import java.sql.SQLException;

public class DeleteReviewController {
    ReviewRepository reviewRepository;
    DeleteReviewView deleteReviewView = new DeleteReviewView();

    public DeleteReviewController() {
        this.reviewRepository = new ReviewRepository();
        this.deleteReviewView.setVisibility(true);
        this.deleteReviewView.setDeleteReviewController(this);
    }

    public void deleteReview() {
        try {
            reviewRepository.deleteReview(this.deleteReviewView.getId());
            this.deleteReviewView.showMessage("Review deleted successfully!", 1);
        } catch (SQLException e) {
            this.deleteReviewView.showMessage("Error deleting track: " + e.getMessage(), 0);
        }
    }
}
