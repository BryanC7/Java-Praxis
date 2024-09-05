package cl.praxis.restaurante.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "camarero")
public class Camarero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Edad")
    private Integer edad;

    @Column(name = "Fecha_Inicio")
    private LocalDate fechaInicio;

    @OneToMany(mappedBy = "camarero")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

}