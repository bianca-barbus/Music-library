package main;

import controller.PersonController;
import view.PersonView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        PersonController personController = new PersonController();
        PersonView personView = new PersonView();

        personView.setPersonController(personController);
        personController.setView(personView);
    }
}
