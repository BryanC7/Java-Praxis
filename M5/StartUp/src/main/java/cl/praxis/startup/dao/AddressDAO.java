package cl.praxis.startup.dao;

import cl.praxis.startup.model.AddressDTO;

import java.util.List;

public interface AddressDAO {
    AddressDTO selectAddress(int id);
    List<AddressDTO> selectAllAddresses();
    void insertAddress(AddressDTO address);
}
