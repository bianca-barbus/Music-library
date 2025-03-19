package controller;

import model.UserModel;
import repository.UserRepository;
import view.SignInView;

import java.sql.SQLException;

public class SignInController {
    SignInView signInView = new SignInView();
    UserRepository userRepository;

    public SignInController() {
        this.userRepository = new UserRepository();
        this.signInView.setVisibility(true);
        this.signInView.setSignInController(this);
    }

    public void createAccount() {
        try {
            String email = this.signInView.getEmail();
            String firstName = this.signInView.getFirstName();
            String lastName = this.signInView.getLastName();
            String password = this.signInView.getPassword();
            if (!isPasswordValid(password)) {
                this.signInView.showMessage("Password must have at least 5 characters. Please try again!", 0);
                return;
            }
            if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
                this.signInView.showMessage("First name and last name are required.", 0);
                return;
            }
            UserModel user = userRepository.insertUser(email, firstName, lastName, password);
            if (user != null) {
                this.signInView.showMessage("Account created successfully!", 1);
                signInView.setVisibility(false);
                UserMenuController userMenuController = new UserMenuController();
            }
        } catch (SQLException e) {
            this.signInView.showMessage("There is already an account with this email", 0);
            throw new RuntimeException("An error occurred", e);
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 5;
    }
}
