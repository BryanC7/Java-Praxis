package cl.praxis.proveedores.dao.impl;

import cl.praxis.proveedores.connection.DBConecction;
import cl.praxis.proveedores.dao.SupplierDAO;
import cl.praxis.proveedores.model.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    private static final String SELECT_ALL_SUPPLIERS = "SELECT id, name, rut, address, email, phone_number, contact, contact_phone FROM suppliers";
    private static final String SELECT_SUPPLIER_BY_ID = "SELECT id, name, rut, address, email, phone_number, contact, contact_phone FROM suppliers WHERE id = ?";
    private static final String INSERT_SUPPLIER_SQL = "INSERT INTO suppliers (name, rut, address, email, phone_number, contact, contact_phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_SQL = "UPDATE suppliers SET name = ?, rut = ?, address = ?, email = ?, phone_number = ?, contact = ?, contact_phone = ? WHERE id = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM suppliers WHERE id = ?";

    public SupplierDAOImpl() {}

    @Override
    public SupplierDTO selectSupplier(int id) {
        SupplierDTO supplier = null;
        try (Connection connection = DBConecction.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUPPLIER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int rut = resultSet.getInt("rut");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phone_number");
                String contact = resultSet.getString("contact");
                int contactPhone = resultSet.getInt("contact_phone");
                supplier = new SupplierDTO(id, name, rut, address, email, phoneNumber, contact, contactPhone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supplier;
    }

    @Override
    public List<SupplierDTO> selectAllSuppliers() {
        List<SupplierDTO> suppliers = new ArrayList<>();
        try (Connection connection = DBConecction.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUPPLIERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int rut = resultSet.getInt("rut");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phone_number");
                String contact = resultSet.getString("contact");
                int contactPhone = resultSet.getInt("contact_phone");
                suppliers.add(new SupplierDTO(id, name, rut, address, email, phoneNumber, contact, contactPhone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suppliers;
    }

    @Override
    public SupplierDTO insertSupplier(SupplierDTO supplier) {
        SupplierDTO newSupplier = null;
        try (Connection connection = DBConecction.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUPPLIER_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setInt(2, supplier.getRut());
            preparedStatement.setString(3, supplier.getAddress());
            preparedStatement.setString(4, supplier.getEmail());
            preparedStatement.setInt(5, supplier.getPhoneNumber());
            preparedStatement.setString(6, supplier.getContact());
            preparedStatement.setInt(7, supplier.getContactPhone());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                newSupplier = new SupplierDTO(
                        id,
                        supplier.getName(),
                        supplier.getRut(),
                        supplier.getAddress(),
                        supplier.getEmail(),
                        supplier.getPhoneNumber(),
                        supplier.getContact(),
                        supplier.getContactPhone()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newSupplier;
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplier) {
        try (Connection connection = DBConecction.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL)) {
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setInt(2, supplier.getRut());
            preparedStatement.setString(3, supplier.getAddress());
            preparedStatement.setString(4, supplier.getEmail());
            preparedStatement.setInt(5, supplier.getPhoneNumber());
            preparedStatement.setString(6, supplier.getContact());
            preparedStatement.setInt(7, supplier.getContactPhone());
            preparedStatement.setInt(8, supplier.getSupplierId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return supplier;
    }

    @Override
    public boolean deleteSupplier(int id) {
        boolean supplierDeleted;
        try (Connection connection = DBConecction.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {
            preparedStatement.setInt(1, id);
            supplierDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return supplierDeleted;
    }
}
