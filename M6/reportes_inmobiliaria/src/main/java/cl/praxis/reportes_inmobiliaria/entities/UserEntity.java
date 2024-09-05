package cl.praxis.reportes_inmobiliaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String firstName;

    @Column(name = "apellido", nullable = false, length = 50)
    private String lastName;

    @Column(name = "correo", nullable = false, length = 100)
    private String email;

    @Column(name = "contraseña", nullable = false, length = 50)
    private String password;

    @OneToMany(mappedBy="userEntity", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Report> reportList;
}