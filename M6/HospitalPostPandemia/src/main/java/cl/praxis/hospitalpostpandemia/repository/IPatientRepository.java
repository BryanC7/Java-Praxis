package cl.praxis.hospitalpostpandemia.repository;

import cl.praxis.hospitalpostpandemia.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {

}