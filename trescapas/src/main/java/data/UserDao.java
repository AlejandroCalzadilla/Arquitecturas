package data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserDao {
    // Simulación de una base de datos en memoria
    // CREATE
    public void createUser(User user) throws SQLException {
        String query = "INSERT INTO users (id, name) VALUES (?, ?)";
        try (Connection connection = DataConecction.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.executeUpdate();
        }
    }

    // READ
    public User findById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = DataConecction.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("lastname") );
            }
        }
        return null;
    }

    public List<User> findAll() throws SQLException {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection connection = DataConecction.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("lastname")  ));
            }
        }
        return users;
    }

    // UPDATE
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE users SET name = ? WHERE id = ?";
        try (Connection connection = DataConecction.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        }
    }

    // DELETE
    public void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection connection = DataConecction.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}
