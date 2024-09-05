package cl.praxis.reportes_inmobiliaria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reportes")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity userEntity;
}