package cl.praxis.proveedores.services.impl;

import cl.praxis.proveedores.dao.SupplierDAO;
import cl.praxis.proveedores.dao.impl.SupplierDAOImpl;
import cl.praxis.proveedores.model.SupplierDTO;
import cl.praxis.proveedores.services.SupplierService;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    private final SupplierDAO OBJ_SUPPLIER_DAO;

    public SupplierServiceImpl() {
        this.OBJ_SUPPLIER_DAO = new SupplierDAOImpl();
    }

    @Override
    public SupplierDTO selectSupplier(int id) {
        return OBJ_SUPPLIER_DAO.selectSupplier(id);
    }

    @Override
    public List<SupplierDTO> selectAllSuppliers() {
        return OBJ_SUPPLIER_DAO.selectAllSuppliers();
    }

    @Override
    public SupplierDTO insertSupplier(SupplierDTO supplier) {
        return OBJ_SUPPLIER_DAO.insertSupplier(supplier);
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplier) {
        return OBJ_SUPPLIER_DAO.updateSupplier(supplier);
    }

    @Override
    public boolean deleteSupplier(int id) {
        return OBJ_SUPPLIER_DAO.deleteSupplier(id);
    }
}
