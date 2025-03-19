package controller;

import view.AdminView;

public class AdminController {
    AdminView adminView = new AdminView();

    public AdminController() {
        this.adminView.setVisibility(true);
        this.adminView.setAdminController(this);
    }

    public void seeTracksButtonClicked() {
        TrackController trackController = new TrackController();
        trackController.getAllTracksAndDisplay();
    }

    public void seeReviewsButtonClicked() {
        adminView.setVisibility(false);
        ReviewsController reviewsController = new ReviewsController();
        reviewsController.getAllReviewsAndDisplay();
    }

    public void backButtonClicked() {
        adminView.setVisibility(false);
        PersonController personController = new PersonController();
    }
}