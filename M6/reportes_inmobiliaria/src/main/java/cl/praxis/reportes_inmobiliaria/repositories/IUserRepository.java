package cl.praxis.reportes_inmobiliaria.repositories;

import cl.praxis.reportes_inmobiliaria.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}