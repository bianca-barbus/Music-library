package controller;

import repository.UserRepository;
import view.UserView;

public class UserController {
    UserView userView = new UserView();
    UserRepository userRepository;

    public UserController() {
        this.userView.setVisibility(true);
        this.userView.setUserController(this);
    }

    public void loginButtonClicked() {
        this.userRepository = new UserRepository();
        userView.setVisibility(false);
        LoginController loginController = new LoginController();
    }

    public void signInButtonClicked() {
        userView.setVisibility(false);
        SignInController signInController = new SignInController();
    }

    public void changePasswordButtonClicked() {
        userView.setVisibility(false);
        ChangePasswordController changePasswordController = new ChangePasswordController();
    }

    public void backButtonClicked() {
        userView.setVisibility(false);
        PersonController personController = new PersonController();
    }
}
