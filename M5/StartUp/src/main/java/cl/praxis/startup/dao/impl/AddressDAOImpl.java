package cl.praxis.startup.dao.impl;

import cl.praxis.startup.connection.DBConnection;
import cl.praxis.startup.dao.AddressDAO;
import cl.praxis.startup.model.AddressDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    private static final String SELECT_ALL_ADDRESSES = "SELECT id, address, numbering, user_id FROM addresses";
    private static final String SELECT_ADDRESS_BY_ID = "SELECT id, address, numbering, user_id FROM addresses WHERE id = ?";
    private static final String INSERT_ADDRESS_SQL = "INSERT INTO addresses (address, numbering, user_id) VALUES (?, ?, ?)";
    @Override
    public AddressDTO selectAddress(int id) {
        AddressDTO address = null;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String addressName = resultSet.getString("address");
                String numbering = resultSet.getString("numbering");
                int userId = resultSet.getInt("user_id");
                address = new AddressDTO(id, addressName, numbering, userId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return address;
    }

    @Override
    public List<AddressDTO> selectAllAddresses() {
        List<AddressDTO> addresses = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESSES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String addressName = resultSet.getString("address");
                String numbering = resultSet.getString("numbering");
                int userId = resultSet.getInt("user_id");
                addresses.add(new AddressDTO(id, addressName, numbering, userId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return addresses;
    }

    @Override
    public void insertAddress(AddressDTO address) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, address.getAddressName());
            preparedStatement.setString(2, address.getNumbering());
            preparedStatement.setInt(3, address.getUserId());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                new AddressDTO(
                        id,
                        address.getAddressName(),
                        address.getNumbering(),
                        address.getUserId()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
