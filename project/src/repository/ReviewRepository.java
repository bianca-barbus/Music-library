package repository;

import model.ReviewModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    String url = "jdbc:postgresql://localhost:5432/MusicLibrary";
    String dbUsername = "postgres";
    String dbPassword = "postgres";

    public List<ReviewModel> getAllReviews() {
        List<ReviewModel> reviews = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT review.*, track.title AS track_title, artist.name AS artist_name, album.title AS album_name " +
                     "FROM review " +
                     "JOIN track ON review.track_id = track.track_id " +
                     "JOIN artist ON track.artist_id = artist.artist_id " +
                     "JOIN album ON track.album_id = album.album_id ")) {
            while (resultSet.next()) {
                ReviewModel review = new ReviewModel();
                review.setTrack(resultSet.getString("track_title"));
                review.setArtist(resultSet.getString("artist_name"));
                review.setAlbum(resultSet.getString("album_name"));
                review.setRating(resultSet.getInt("rating"));
                review.setComment(resultSet.getString("comment"));
                review.setReviewId(resultSet.getInt("review_id"));
                reviews.add(review);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }

    public void leaveReview(ReviewModel review) throws SQLException {
        int trackId = getTrackIdByTitleAndArtist(review.getTrack(), review.getArtist());

        if (trackId != -1) {
            try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
                String query = "INSERT INTO review (track_id, rating, comment) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, trackId);
                    preparedStatement.setInt(2, review.getRating());
                    preparedStatement.setString(3, review.getComment());
                    preparedStatement.executeUpdate();
                }
            }
        } else {
            throw new SQLException("Track not found. Please check the title and artist.");
        }
    }

    private int getTrackIdByTitleAndArtist(String title, String artistName) throws SQLException {
        int trackId = -1;
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String query = "SELECT track.track_id FROM track " +
                    "JOIN artist ON track.artist_id = artist.artist_id " +
                    "WHERE track.title = ? AND artist.name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, artistName);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        trackId = resultSet.getInt("track_id");
                    }
                }
            }
        }
        return trackId;
    }

    public void deleteReview(int reviewId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String query = "DELETE FROM review WHERE review_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, reviewId);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected == 0) {
                    throw new SQLException("Review not found or already deleted.");
                }
            }
        }
    }

}
