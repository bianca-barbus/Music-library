package view;

import controller.TrackController;
import model.TrackModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class TracksView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JTable trackTable = new JTable();
    JButton refreshButton = new JButton("Refresh");
    JButton addTrackButton = new JButton("Add track");
    JButton orderButton = new JButton("Order tracks");
    TrackController trackController;

    public TracksView() {
        frame.setTitle("Music Library - Tracks");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        addTrackButton.addActionListener(e -> trackController.addTrackButtonClicked());
        panel1.add(addTrackButton);
        refreshButton.addActionListener(e -> trackController.getAllTracksAndDisplay());
        panel1.add(refreshButton);
        orderButton.addActionListener(e -> trackController.orderButtonClicked());
        panel1.add(orderButton);
        frame.add(panel1, BorderLayout.SOUTH);
    }

    public void displayTracks(List<TrackModel> tracks) {
        String[] columnNames = {"Title", "Artist", "Album", "Genre"};
        Object[][] data = new Object[tracks.size()][4];

        for (int i = 0; i < tracks.size(); i++) {
            TrackModel track = tracks.get(i);
            data[i][0] = track.getTitle();
            data[i][1] = track.getArtist();
            data[i][2] = track.getAlbum();
            data[i][3] = track.getGenre();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        trackTable.setModel(model);
        trackTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(trackTable);
        frame.add(scrollPane, BorderLayout.CENTER);
        JTableHeader header = trackTable.getTableHeader();
        frame.add(header, BorderLayout.NORTH);
        frame.add(trackTable);
    }

    public void showMessage(String message, int option) {
        if (option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if (option == 1) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public TrackController getTrackController() {
        return trackController;
    }

    public void setTrackController(TrackController trackController) {
        this.trackController = trackController;
    }
}
