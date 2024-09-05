package cl.praxis.restaurante.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Numero")
    private Integer numero;

    @Column(name = "Capacidad")
    private Integer capacidad;

    @Column(name = "Ubicacion")
    private String ubicacion;

    @OneToMany(mappedBy = "mesa")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

}