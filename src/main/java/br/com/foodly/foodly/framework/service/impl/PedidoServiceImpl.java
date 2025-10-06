package br.com.foodly.foodly.framework.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.foodly.foodly.framework.models.Pedido;
import br.com.foodly.foodly.framework.repositories.PedidoRespository;
import br.com.foodly.foodly.framework.service.PedidoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRespository pedidoRespository;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRespository.findAll();
    }

    @Override
    public Pedido buscarPedidoById(Long idPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidoById'");
    }

    @Override
    public Long criarPedido(Pedido pedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarPedido'");
    }

    @Override
    public void atualizarPedidoById(Pedido pedido, Long idPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarPedidoById'");
    }

    @Override
    public void deletarPedidoById(Long idPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarPedidoById'");
    }
}
