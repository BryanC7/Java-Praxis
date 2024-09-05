package cl.praxis.restaurante.repositories;

import cl.praxis.restaurante.entities.Camarero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICamareroRepository extends JpaRepository<Camarero, Integer> {
}
