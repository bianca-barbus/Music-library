package repository;

import model.UserModel;

import java.sql.*;

public class UserRepository {
    String url = "jdbc:postgresql://localhost:5432/MusicLibrary";
    String dbUsername = "postgres";
    String dbPassword = "postgres";

    public UserModel insertUser(String email, String firstName, String lastName, String password) throws SQLException {
        if (firstName == null || lastName == null || firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name and last name are required fields.");
        }
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String query = "INSERT INTO \"user\" (email, first_name, last_name, password) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, password);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                UserModel user = new UserModel();
                user.setEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPassword(password);
                return user;
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                throw new SQLException("User with this email already exists.", e);
            } else {
                throw new RuntimeException("Database operation failed", e);
            }
        }
        return null;
    }

    public UserModel getUserByEmailAndPassword(String email, String password) {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"user\" WHERE email = ? AND password = ?")) {

            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                UserModel user = new UserModel();
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changePassword(String email, String newPassword) {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE \"user\" SET password = ? WHERE email = ?")) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isOldPasswordCorrect(String email, String oldPassword) {
        try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM \"user\" WHERE email = ?")) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (storedPassword.equals(oldPassword)) return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}