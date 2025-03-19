package view;

import controller.PlaylistController;
import model.PlaylistModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class PlaylistsView {
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JTable playlistTable = new JTable();
    JScrollPane scrollPane = new JScrollPane(playlistTable);
    JButton refreshButton = new JButton("Refresh");
    JButton backButton = new JButton("Back");
    PlaylistController playlistController;

    public PlaylistsView() {
        frame.setTitle("Music Library - Playlists");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(scrollPane, BorderLayout.CENTER);

        refreshButton.addActionListener(e -> playlistController.seePlaylistsButtonClicked());
        panel1.add(refreshButton);
        backButton.addActionListener(e -> playlistController.backButtonClicked());
        panel1.add(backButton);
        frame.add(panel1, BorderLayout.SOUTH);
    }

    public void displayPlaylists(List<PlaylistModel> playlists) {
        String[] columnNames = {"Title"};
        Object[][] data = new Object[playlists.size()][1];

        for (int i = 0; i < playlists.size(); i++) {
            PlaylistModel playlist = playlists.get(i);
            data[i][0] = playlist.getTitle();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        playlistTable.setModel(model);
        JTableHeader header = playlistTable.getTableHeader();
        frame.add(header, BorderLayout.NORTH);
        frame.add(playlistTable);
    }

    public void setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    public PlaylistController getPlaylistController() {
        return playlistController;
    }

    public void setPlaylistController(PlaylistController playlistController) {
        this.playlistController = playlistController;
    }
}
