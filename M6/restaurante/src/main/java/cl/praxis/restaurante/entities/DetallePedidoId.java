package cl.praxis.restaurante.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DetallePedidoId implements java.io.Serializable {
    private static final long serialVersionUID = -6294172400149695496L;
    @Column(name = "Pedido_ID", nullable = false)
    private Integer pedidoId;

    @Column(name = "Plato_ID", nullable = false)
    private Integer platoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DetallePedidoId entity = (DetallePedidoId) o;
        return Objects.equals(this.pedidoId, entity.pedidoId) &&
                Objects.equals(this.platoId, entity.platoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, platoId);
    }

}