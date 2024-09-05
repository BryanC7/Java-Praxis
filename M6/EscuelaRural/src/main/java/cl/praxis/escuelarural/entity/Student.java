package cl.praxis.escuelarural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="estudiantes")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante", nullable = false, unique = true)
    private long id;
    @Column(name="nombre", nullable = false, length = 50)
    private String firstName;
    @Column(name="apellido", nullable = false, length = 50)
    private String lastName;
    @Column(name="edad", nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Course course;
}