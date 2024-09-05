package cl.praxis.restaurante.repositories;

import cl.praxis.restaurante.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
}
