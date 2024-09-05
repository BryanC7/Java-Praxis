package cl.praxis.restaurante.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "plato")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "`Descripción`")
    private String descripcion;

    @Column(name = "Precio", precision = 5, scale = 2)
    private BigDecimal precio;

    @Column(name = "`Categoría`")
    private String categoria;

    @OneToMany(mappedBy = "plato")
    private Set<DetallePedido> detallePedidos = new LinkedHashSet<>();

}