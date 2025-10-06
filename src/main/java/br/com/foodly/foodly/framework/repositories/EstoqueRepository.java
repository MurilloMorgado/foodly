package br.com.foodly.foodly.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foodly.foodly.framework.models.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    
}
