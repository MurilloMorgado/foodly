package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

}
