package repository;

import java.sql.*;

public class GenreRepository extends BaseRepository {
    @Override
    public int getEntityId(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT genre_id FROM genre WHERE genre_name = ?")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("genre_id");
            }
        }
        return -1;
    }

    @Override
    public int addEntity(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO genre (genre_name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new SQLException("Creating genre failed, no ID obtained.");
        }
    }
}
