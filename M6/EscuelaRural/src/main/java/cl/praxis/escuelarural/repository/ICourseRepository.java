package cl.praxis.escuelarural.repository;

import cl.praxis.escuelarural.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
