package cl.praxis.startup.services.impl;

import cl.praxis.startup.dao.AddressDAO;
import cl.praxis.startup.dao.impl.AddressDAOImpl;
import cl.praxis.startup.model.AddressDTO;
import cl.praxis.startup.services.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private final AddressDAO OBJ_ADDRESS_DAO;

    public AddressServiceImpl() {
        this.OBJ_ADDRESS_DAO = new AddressDAOImpl();
    }

    @Override
    public AddressDTO selectAddress(int id) {
        return OBJ_ADDRESS_DAO.selectAddress(id);
    }

    @Override
    public List<AddressDTO> selectAllAddresses() {
        return OBJ_ADDRESS_DAO.selectAllAddresses();
    }

    @Override
    public void insertAddress(AddressDTO address) {
        OBJ_ADDRESS_DAO.insertAddress(address);
    }
}
