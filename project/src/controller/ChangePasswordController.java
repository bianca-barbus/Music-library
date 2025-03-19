package controller;

import repository.UserRepository;
import view.ChangePasswordView;

public class ChangePasswordController {
    ChangePasswordView changePasswordView = new ChangePasswordView();
    UserRepository userRepository;

    public ChangePasswordController() {
        this.userRepository = new UserRepository();
        this.changePasswordView.setVisibility(true);
        this.changePasswordView.setChangePasswordController(this);
    }

    public void saveNewPassword() {
        String email = this.changePasswordView.getEmail();
        String password = this.changePasswordView.getPassword();
        String newPassword = this.changePasswordView.getNewPassword();
        if (userRepository.isOldPasswordCorrect(email, password)) {
            userRepository.changePassword(email, newPassword);
            changePasswordView.showMessage("Password changed", 1);
            changePasswordView.setVisibility(false);
            UserController userController = new UserController();
        } else {
            changePasswordView.showMessage("Old password doesn't match", 0);
        }
    }

}
