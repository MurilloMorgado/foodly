package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {

}
