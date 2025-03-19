package view;

import controller.AddTrackController;

import javax.swing.*;
import java.awt.*;

public class AddTrackView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JLabel labelTitle = new JLabel("Title:");
    JTextField textFieldTitle = new JTextField();
    JLabel labelArtist = new JLabel("Artist:");
    JTextField textFieldArtist = new JTextField();
    JLabel labelAlbum = new JLabel("Album:");
    JTextField textFieldAlbum = new JTextField();
    JLabel labelDuration = new JLabel("Duration:");
    JTextField textFieldDuration = new JTextField();
    JLabel labelGenre = new JLabel("Genre:");
    JTextField textFieldGenre = new JTextField();
    JButton addButton = new JButton("Add");
    AddTrackController addTrackController;

    public AddTrackView() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        textFieldAlbum.setPreferredSize(new Dimension(300, 20));
        textFieldArtist.setPreferredSize(new Dimension(300, 20));
        textFieldDuration.setPreferredSize(new Dimension(300, 20));
        textFieldGenre.setPreferredSize(new Dimension(300, 20));
        textFieldTitle.setPreferredSize(new Dimension(300, 20));

        panel1.add(labelTitle);
        panel1.add(textFieldTitle);
        panel2.add(labelArtist);
        panel2.add(textFieldArtist);
        panel3.add(labelAlbum);
        panel3.add(textFieldAlbum);
        panel4.add(labelDuration);
        panel4.add(textFieldDuration);
        panel5.add(labelGenre);
        panel5.add(textFieldGenre);
        addButton.addActionListener(e -> addTrackController.addTrack());
        panel6.add(addButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        panel.add(panel6);
        frame.setContentPane(panel);
    }

    public String getTitle() {
        return textFieldTitle.getText();
    }

    public String getArtist() {
        return textFieldArtist.getText();
    }

    public String getAlbum() {
        return textFieldAlbum.getText();
    }

    public String getGenre() {
        return textFieldGenre.getText();
    }

    public String getDuration() {
        return textFieldDuration.getText();
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public void showMessage(String message, int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if (option == 1) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public AddTrackController getAddTrackController() {
        return addTrackController;
    }

    public void setAddTrackController(AddTrackController addTrackController) {
        this.addTrackController = addTrackController;
    }
}
