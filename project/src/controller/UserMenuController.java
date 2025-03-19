package controller;

import view.UserMenuView;

public class UserMenuController {
    UserMenuView userMenuView = new UserMenuView();

    public UserMenuController() {
        this.userMenuView.setVisibility(true);
        this.userMenuView.setUserMenuController(this);
    }

    public void leaveReviewButtonClicked() {
        userMenuView.setVisibility(false);
        LeaveReviewController leaveReviewController = new LeaveReviewController();
    }

    public void seeTracksButtonClicked() {
        TrackController trackController = new TrackController();
        trackController.getAllTracksAndDisplay();
    }

    public void seePlaylistsButtonClicked() {
        userMenuView.setVisibility(false);
        PlaylistController playlistController = new PlaylistController();
        playlistController.seePlaylistsButtonClicked();
    }

    public void logOutButtonClicked() {
        userMenuView.setVisibility(false);
        UserController userController = new UserController();
    }
}
