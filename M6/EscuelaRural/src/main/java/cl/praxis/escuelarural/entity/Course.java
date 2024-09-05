package cl.praxis.escuelarural.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cursos")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso", nullable = false, unique = true)
    private long id;
    @Column(name="nombre", nullable = false, length = 50)
    private String name;


    @OneToMany(mappedBy="course", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> studentList;
}