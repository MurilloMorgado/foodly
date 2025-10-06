package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.Produto;

public interface ProdutoRespository extends JpaRepository<Produto, Long> {
}
