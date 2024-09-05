package cl.praxis.proveedores.services;

import cl.praxis.proveedores.model.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO selectSupplier(int id);

    List<SupplierDTO> selectAllSuppliers();

    SupplierDTO insertSupplier(SupplierDTO supplier);

    SupplierDTO updateSupplier(SupplierDTO supplier);

    boolean deleteSupplier(int id);
}
