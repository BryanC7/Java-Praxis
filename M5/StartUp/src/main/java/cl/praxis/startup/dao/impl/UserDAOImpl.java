package cl.praxis.startup.dao.impl;

import cl.praxis.startup.connection.DBConnection;
import cl.praxis.startup.dao.UserDAO;
import cl.praxis.startup.model.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String SELECT_ALL_USERS = "SELECT id, email, created_at, nick, name, password, weight, updated_at, rol_id FROM users";
    private static final String SELECT_USER_BY_ID = "SELECT id, email, created_at, nick, name, password, weight, updated_at, rol_id FROM users WHERE id = ?";
    private static final String INSERT_USER_SQL = "INSERT INTO users (email, created_at, nick, name, password, weight, updated_at, rol_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String USER_ADDRESS_JOIN = "SELECT u.id, u.email, u.created_at, u.nick, u.name, u.password, u.weight, u.updated_at, u.rol_id, a.address, a.numbering FROM users u JOIN addresses a ON u.id = a.user_id";
    @Override
    public UserDTO selectUser(int id) {
        UserDTO user = null;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                Date createdAt = resultSet.getDate("created_at");
                String nick = resultSet.getString("nick");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                int weight = resultSet.getInt("weight");
                Date updatedAt = resultSet.getDate("updated_at");
                int rolId = resultSet.getInt("rol_id");
                user = new UserDTO(id, email, createdAt, nick, name, password, weight, updatedAt, rolId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<UserDTO> selectAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                Date createdAt = resultSet.getDate("created_at");
                String nick = resultSet.getString("nick");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                int weight = resultSet.getInt("weight");
                Date updatedAt = resultSet.getDate("updated_at");
                int rolId = resultSet.getInt("rol_id");
                users.add(new UserDTO(id, email, createdAt, nick, name, password, weight, updatedAt, rolId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void insertUser(UserDTO user) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            java.sql.Date sqlCreatedAt = new java.sql.Date(user.getCreatedAt().getTime());
            java.sql.Date sqlUpdatedAt = new java.sql.Date(user.getUpdatedAt().getTime());

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setDate(2, sqlCreatedAt);
            preparedStatement.setString(3, user.getNick());
            preparedStatement.setString(4, user.getName());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getWeight());
            preparedStatement.setDate(7, sqlUpdatedAt);
            preparedStatement.setInt(8, user.getRolId());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                new UserDTO(
                        id,
                        user.getEmail(),
                        user.getCreatedAt(),
                        user.getNick(),
                        user.getName(),
                        user.getPassword(),
                        user.getWeight(),
                        user.getUpdatedAt(),
                        user.getRolId()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<UserDTO> selectUsersWithAddresses() {
        List<UserDTO> userAddressList = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(USER_ADDRESS_JOIN)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String email = resultSet.getString("email");
                Date createdAt = resultSet.getDate("created_at");
                String nick = resultSet.getString("nick");
                String userName = resultSet.getString("name");
                String password = resultSet.getString("password");
                int weight = resultSet.getInt("weight");
                Date updatedAt = resultSet.getDate("updated_at");
                int rolId = resultSet.getInt("rol_id");
                String addressName = resultSet.getString("address");
                String numbering = resultSet.getString("numbering");

                userAddressList.add(new UserDTO(userId, email, createdAt, nick, userName, password, weight, updatedAt, rolId, addressName, numbering));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userAddressList;
    }
}