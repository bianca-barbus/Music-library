package controller;

import view.PersonView;

public class PersonController {
    PersonView personView = new PersonView();

    public PersonController() {
        this.personView.setVisibility(true);
        this.personView.setPersonController(this);
    }

    public PersonView getView() {
        return personView;
    }

    public void setView(PersonView view) {
        this.personView = view;
    }

    public void adminButtonClicked() {
        this.personView.setVisibility(false);
        AdminController adminController = new AdminController();
    }

    public void userButtonClicked() {
        this.personView.setVisibility(false);
        UserController userController = new UserController();
    }

}