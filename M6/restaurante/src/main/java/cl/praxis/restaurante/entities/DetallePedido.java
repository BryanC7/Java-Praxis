package cl.praxis.restaurante.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {
    @EmbeddedId
    private DetallePedidoId id;

    @MapsId("pedidoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pedido_ID", nullable = false)
    private Pedido pedido;

    @MapsId("platoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Plato_ID", nullable = false)
    private Plato plato;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Subtotal", precision = 5, scale = 2)
    private BigDecimal subtotal;

}