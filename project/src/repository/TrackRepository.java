package repository;

import model.TrackModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrackRepository {
    String url = "jdbc:postgresql://localhost:5432/MusicLibrary";
    String dbUsername = "postgres";
    String dbPassword = "postgres";

    public List<TrackModel> getAllTracks() {
        List<TrackModel> tracks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT track.*, artist.name AS artist_name, album.title AS album_name, genre.genre_name AS genre_name " +
                     "FROM track " +
                     "JOIN artist ON track.artist_id = artist.artist_id " +
                     "JOIN album ON track.album_id = album.album_id " +
                     "JOIN genre ON track.genre_id = genre.genre_id")) {
            while (resultSet.next()) {
                TrackModel track = new TrackModel();
                track.setTitle(resultSet.getString("title"));
                track.setArtist(resultSet.getString("artist_name"));
                track.setAlbum(resultSet.getString("album_name"));
                track.setGenre(resultSet.getString("genre_name"));

                tracks.add(track);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    public List<TrackModel> getOderedTracks() {
        List<TrackModel> tracks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT track.*, artist.name AS artist_name, album.title AS album_name, genre.genre_name AS genre_name " +
                     "FROM track " +
                     "JOIN artist ON track.artist_id = artist.artist_id " +
                     "JOIN album ON track.album_id = album.album_id " +
                     "JOIN genre ON track.genre_id = genre.genre_id " +
                     "ORDER BY track.title")) {
            while (resultSet.next()) {
                TrackModel track = new TrackModel();
                track.setTitle(resultSet.getString("title"));

                track.setArtist(resultSet.getString("artist_name"));
                track.setAlbum(resultSet.getString("album_name"));
                track.setGenre(resultSet.getString("genre_name"));

                tracks.add(track);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tracks;
    }

    public void addTrack(TrackModel track) throws SQLException {
        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();
        GenreRepository genreRepository = new GenreRepository();
        int artistId = artistRepository.getOrAddEntity(track.getArtist());
        int albumId = albumRepository.getOrAddAlbum(track.getAlbum(), artistId);
        int genreId = genreRepository.getOrAddEntity(track.getGenre());
        String durationText = "00:" + track.getDuration();
        Time duration = Time.valueOf(durationText);
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO track (title, artist_id, album_id, genre_id, duration) VALUES (?, ?, ?, ?, ?); ")) {
            preparedStatement.setString(1, track.getTitle());
            preparedStatement.setInt(2, artistId);
            preparedStatement.setInt(3, albumId);
            preparedStatement.setInt(4, genreId);
            preparedStatement.setTime(5, duration);
            preparedStatement.executeUpdate();
        }
    }
}

