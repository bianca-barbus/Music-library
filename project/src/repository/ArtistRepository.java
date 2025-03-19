package repository;

import java.sql.*;

public class ArtistRepository extends BaseRepository {
    @Override
    public int getEntityId(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT artist_id FROM artist WHERE name = ?")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("artist_id");
            }
        }
        return -1;
    }

    @Override
    public int addEntity(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO artist (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new SQLException("Creating artist failed, no ID obtained.");
        }
    }
}
