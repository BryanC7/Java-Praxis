package cl.praxis.startup.dao.impl;

import cl.praxis.startup.connection.DBConnection;
import cl.praxis.startup.dao.UserRolDAO;
import cl.praxis.startup.model.UserRolDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRolDAOImpl implements UserRolDAO {

    private static final String INSERT_USER_ROL_SQL = "INSERT INTO roles_users (user_id, rol_id) VALUES (?, ?)";

    @Override
    public void insertUserRol(UserRolDTO userRolDTO) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_ROL_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, userRolDTO.getUserId());
            preparedStatement.setInt(2, userRolDTO.getRolId());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                new UserRolDTO(
                        id,
                        userRolDTO.getUserId(),
                        userRolDTO.getRolId()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
