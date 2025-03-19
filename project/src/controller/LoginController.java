package controller;

import model.UserModel;
import repository.UserRepository;
import view.LoginView;

public class LoginController {
    LoginView loginView = new LoginView();
    UserRepository userRepository;

    public LoginController() {
        this.userRepository = new UserRepository();
        this.loginView.setVisibility(true);
        this.loginView.setLoginController(this);
    }

    public void attemptLogin() {
        String email = loginView.getEmail();
        String password = loginView.getPassword();
        UserModel user = userRepository.getUserByEmailAndPassword(email, password);
        if (user != null) {
            loginView.setVisibility(false);
            UserMenuController userMenuController = new UserMenuController();
        } else {
            this.loginView.showMessage("Invalid email or password!", 0);
        }
    }
}
