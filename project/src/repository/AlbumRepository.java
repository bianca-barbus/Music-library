package repository;

import java.sql.*;

public class AlbumRepository {
    String url = "jdbc:postgresql://localhost:5432/MusicLibrary";
    String dbUsername = "postgres";
    String dbPassword = "postgres";

    public int getOrAddAlbum(String albumName, int artistId) throws SQLException {
        int albumId = getAlbumId(albumName, artistId);
        if (albumId == -1) {
            albumId = addAlbum(albumName, artistId);
        }
        return albumId;
    }

    public int getAlbumId(String name, int artistId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT album_id FROM album WHERE title = ? AND artist_id = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, artistId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("album_id");
            }
        }
        return -1;
    }

    public int addAlbum(String name, int artistId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO album (title, artist_id) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, artistId);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new SQLException("Creating album failed, no ID obtained.");
        }
    }
}
