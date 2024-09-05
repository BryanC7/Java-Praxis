package cl.praxis.restaurante.services.impl;

import cl.praxis.restaurante.entities.Camarero;
import cl.praxis.restaurante.entities.Pedido;
import cl.praxis.restaurante.repositories.ICamareroRepository;
import cl.praxis.restaurante.repositories.IPedidoRepository;
import cl.praxis.restaurante.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements IBaseCrud<Pedido> {
    @Autowired
    IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getById(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void delete(int id) {
        pedidoRepository.deleteById(id);
    }
}
