package controller;

import model.ReviewModel;
import repository.ReviewRepository;
import view.LeaveReviewView;

import java.sql.SQLException;

public class LeaveReviewController {
    ReviewRepository reviewRepository;
    LeaveReviewView leaveReviewView = new LeaveReviewView();

    public LeaveReviewController() {
        this.reviewRepository = new ReviewRepository();
        this.leaveReviewView.setVisibility(true);
        this.leaveReviewView.setLeaveReviewController(this);
    }

    public void addReview() {
        try {
            ReviewModel model = new ReviewModel();
            model.setTrack(this.leaveReviewView.getTitle());
            model.setArtist(this.leaveReviewView.getArtist());
            model.setRating(this.leaveReviewView.getRating());
            model.setComment(this.leaveReviewView.getComment());
            reviewRepository.leaveReview(model);
            leaveReviewView.showMessage("Review submitted successfully!", 1);
        } catch (SQLException e) {
            leaveReviewView.showMessage("Rating must be between 1-5", 0);
            //e.printStackTrace();
        }
    }

    public void backButtonClicked() {
        this.leaveReviewView.setVisibility(false);
        UserMenuController userMenuController = new UserMenuController();
    }
}
