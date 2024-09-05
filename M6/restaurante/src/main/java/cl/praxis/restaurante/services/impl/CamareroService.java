package cl.praxis.restaurante.services.impl;

import cl.praxis.restaurante.entities.Camarero;
import cl.praxis.restaurante.repositories.ICamareroRepository;
import cl.praxis.restaurante.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamareroService implements IBaseCrud<Camarero> {
    @Autowired
    private ICamareroRepository camareroRepository;

    @Override
    public List<Camarero> getAll() {
        return camareroRepository.findAll();
    }

    @Override
    public Camarero getById(int id) {
        return null;
    }

    @Override
    public Camarero create(Camarero camarero) {
        return null;
    }

    @Override
    public Camarero update(Camarero camarero) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
