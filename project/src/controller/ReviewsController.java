package controller;

import model.ReviewModel;
import repository.ReviewRepository;
import view.ReviewsView;

import java.util.List;

public class ReviewsController {
    ReviewRepository reviewRepository;
    ReviewsView reviewsView = new ReviewsView();

    public ReviewsController() {
        this.reviewRepository = new ReviewRepository();
        this.reviewsView.setVisibility(true);
        this.reviewsView.setReviewsController(this);
    }

    public void getAllReviewsAndDisplay() {
        List<ReviewModel> reviews = reviewRepository.getAllReviews();
        reviewsView.displayReviews(reviews);
    }

    public void backButtonClicked() {
        this.reviewsView.setVisibility(false);
        AdminController adminController = new AdminController();
    }

    public void deleteReviewButtonClicked() {
        DeleteReviewController deleteReviewController = new DeleteReviewController();
    }
}
