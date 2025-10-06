package br.com.foodly.foodly.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodly.foodly.framework.models.Pedido;
import br.com.foodly.foodly.framework.service.PedidoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    @PreAuthorize("hasnyhole('ADMIN')")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> listaPedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok().body(listaPedidos);
    }

    @GetMapping(value = "/{idPedido}")
    @PreAuthorize("hasnyhole('ADMIN')")
    public ResponseEntity<Pedido> buscarPedidoById(@PathVariable Long idPedido) {
        Pedido pedido = pedidoService.buscarPedidoById(idPedido);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping
    @PreAuthorize("hasnyhole('ADMIN', 'USER')")
    public ResponseEntity<Long> criarPedido(@RequestBody Pedido pedido) {
        Long idPedidoCriado = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok().body(idPedidoCriado);
    }

    @PutMapping(value = "/{idPedido}")
    @PreAuthorize("hasnyhole('ADMIN')")
    public ResponseEntity<Void> atualizarPedidoById(@RequestBody Pedido pedido, @PathVariable Long idPedido) {

        pedidoService.atualizarPedidoById(pedido, idPedido);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping(value = "/{idPedido}")
    @PreAuthorize("hasnyhole('ADMIN')")
    public ResponseEntity<Void> deletarPedidoById(@PathVariable Long idPedido) {
        pedidoService.deletarPedidoById(idPedido);
        return ResponseEntity.ok().build();
    }
}
