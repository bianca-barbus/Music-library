package repository;

import model.PlaylistModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {
    String url = "jdbc:postgresql://localhost:5432/MusicLibrary";
    String dbUsername = "postgres";
    String dbPassword = "postgres";

    public List<PlaylistModel> getAllPlaylists() {
        List<PlaylistModel> playlists = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM playlist")) {
            while (resultSet.next()) {
                PlaylistModel playlist = new PlaylistModel();
                playlist.setTitle(resultSet.getString("title"));

                playlists.add(playlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playlists;
    }

}
