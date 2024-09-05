package cl.praxis.proveedores.dao;

import cl.praxis.proveedores.model.SupplierDTO;

import java.util.List;

public interface SupplierDAO {
    SupplierDTO selectSupplier(int id);

    List<SupplierDTO> selectAllSuppliers();

    SupplierDTO insertSupplier(SupplierDTO supplier);

    SupplierDTO updateSupplier(SupplierDTO supplier);

    boolean deleteSupplier(int id);
}
