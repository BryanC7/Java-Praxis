package cl.praxis.hospitalpostpandemia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pacientes")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente", nullable = false, unique = true)
    private long id;
    @Column(name="nombre", nullable = false, length = 50)
    private String firstName;
    @Column(name = "apellido", nullable = false, length = 50)
    private String lastName;
    @Column(name = "run", nullable = false)
    private int RUN;
    @Column(name = "edad", nullable = false)
    private int age;
    @Column(name = "correo", nullable = false, length = 100, unique = true)
    private String email;
}
