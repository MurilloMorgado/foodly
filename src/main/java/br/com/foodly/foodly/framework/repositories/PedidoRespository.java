package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.Pedido;

public interface PedidoRespository extends JpaRepository<Pedido, Long> {

}
