package br.com.foodly.foodly.framework.service;

import java.util.List;

import br.com.foodly.foodly.framework.models.Pedido;

public interface PedidoService {

    List<Pedido> listarPedidos();

    Pedido buscarPedidoById(Long idPedido);

    Long criarPedido(Pedido pedido);

    void atualizarPedidoById(Pedido pedido, Long idPedido);

    void deletarPedidoById(Long idPedido);

}
