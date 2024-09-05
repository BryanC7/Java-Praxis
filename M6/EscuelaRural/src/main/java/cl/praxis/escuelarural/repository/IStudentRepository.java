package cl.praxis.escuelarural.repository;

import cl.praxis.escuelarural.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
