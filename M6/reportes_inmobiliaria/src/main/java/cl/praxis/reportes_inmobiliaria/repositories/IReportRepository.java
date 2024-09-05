package cl.praxis.reportes_inmobiliaria.repositories;

import cl.praxis.reportes_inmobiliaria.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepository extends JpaRepository<Report, Long> {
}
