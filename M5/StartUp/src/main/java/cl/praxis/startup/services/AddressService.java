package cl.praxis.startup.services;

import cl.praxis.startup.model.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO selectAddress(int id);
    List<AddressDTO> selectAllAddresses();
    void insertAddress(AddressDTO address);
}
