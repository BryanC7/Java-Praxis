package cl.praxis.restaurante.controllers.rests;

import cl.praxis.restaurante.entities.Pedido;
import cl.praxis.restaurante.services.impl.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRestController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos")
    public List<Pedido> mostrarPedidosApi() {
        return pedidoService.getAll();
    }

    @GetMapping("/pedidos/{id}")
    public Pedido obtenerPorId(@PathVariable int id) {
        return pedidoService.getById(id);
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.create(pedido);
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable int id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoService.update(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable int id) {
        pedidoService.delete(id);
    }
}
